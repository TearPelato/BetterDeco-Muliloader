package net.tier1234.better_deco.block.entity.custom;

import com.google.common.collect.Maps;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.init.ModBlockEntities;
import net.tier1234.better_deco.recipe.FreezerRecipe;
import net.tier1234.better_deco.recipe.FreezerRecipeInput;
import net.tier1234.better_deco.init.ModRecipes;
import net.tier1234.better_deco.screen.custom.FreezerMenu;

import org.jetbrains.annotations.Nullable;
import java.util.Map;
import java.util.Optional;

public class FreezerBlockEntity extends BlockEntity implements MenuProvider {
    public final SimpleContainer itemHandler = new SimpleContainer(3) {

    };

    private static final int SLOT_INPUT = 0;
    private static final int SLOT_FUEL = 1;
    private static final int SLOT_OUTPUT = 2;

    private int fuelTime;
    private int fuelTimeTotal;

    private int progress = 0;
    private int maxProgress = 200;

    private final Map<ResourceLocation, Integer> usedRecipeCount = Maps.newHashMap();

    protected final ContainerData data;

    public FreezerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FREEZER.get(), pos, state);

        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> fuelTime;
                    case 1 -> fuelTimeTotal;
                    case 2 -> progress;
                    case 3 -> maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> fuelTime = value;
                    case 1 -> fuelTimeTotal = value;
                    case 2 -> progress = value;
                    case 3 -> maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.better_deco.freezer");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new FreezerMenu(id, inv, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getContainerSize());
        for (int i = 0; i < itemHandler.getContainerSize(); i++) {
            inventory.setItem(i, itemHandler.getItem(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private Optional<RecipeHolder<FreezerRecipe>> getCurrentRecipe(ItemStack input) {
        return level.getRecipeManager().getRecipeFor(ModRecipes.FREEZER_TYPE.get(), new FreezerRecipeInput(input), level);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, FreezerBlockEntity be) {
        boolean dirty = false;

        ItemStack fuelStack = be.itemHandler.getItem(SLOT_FUEL);
        ItemStack inputStack = be.itemHandler.getItem(SLOT_INPUT);

        Optional<RecipeHolder<FreezerRecipe>> recipe = be.getCurrentRecipe(inputStack);

        if (!be.isFreezing() && recipe.isPresent() && be.canFreeze(recipe.get()) && !fuelStack.isEmpty()) {
            be.fuelTime = be.getFuelTime(fuelStack);
            be.fuelTimeTotal = be.fuelTime;
            if (be.isFreezing()) {
                fuelStack.shrink(1);
                dirty = true;
            }
        }

        if (be.isFreezing() && recipe.isPresent() && be.canFreeze(recipe.get())) {
            be.progress++;
            be.maxProgress = be.getProgressTime(recipe.get());

            if (be.progress >= be.maxProgress) {
                be.progress = 0;
                be.craftItem(recipe.get());
                dirty = true;
            }
        } else {
            be.progress = 0;
        }

        if (dirty) {
            setChanged(level, pos, state);
        }
    }

    private boolean isFreezing() {
        return this.fuelTime > 0;
    }

    private int getFuelTime(ItemStack stack) {
        if (stack.isEmpty()) return 0;
        if (stack.is(Items.ICE)) return 2000;
        if (stack.is(Items.PACKED_ICE)) return 18000;
        if (stack.is(Items.BLUE_ICE)) return 162000;
        return 0;
    }

    private int getProgressTime(RecipeHolder<FreezerRecipe> recipe) {
        // qui puoi decidere un tempo standard o un tempo personalizzato per ricetta
        return 72; // esempio: come nel microwave
    }

    private boolean canFreeze(RecipeHolder<FreezerRecipe> recipe) {
        ItemStack output = recipe.value().getResultItem(this.level.registryAccess());
        if (output.isEmpty()) return false;

        ItemStack resultStack = itemHandler.getItem(SLOT_OUTPUT);
        if (resultStack.isEmpty()) return true;
        return resultStack.getCount() + output.getCount() <= resultStack.getMaxStackSize();
    }

    private void craftItem(RecipeHolder<FreezerRecipe> recipe) {
        if (!canFreeze(recipe)) return;

        ItemStack copy = itemHandler.getItem(SLOT_INPUT).copy();
        copy.shrink(1);
        itemHandler.setItem(SLOT_INPUT, copy.isEmpty() ? ItemStack.EMPTY : copy);

        ItemStack resultStack = itemHandler.getItem(SLOT_OUTPUT);
        ItemStack output = recipe.value().getResultItem(this.level.registryAccess());

        if (resultStack.isEmpty()) {
            itemHandler.setItem(SLOT_OUTPUT, output.copy());
        } else {
            resultStack.grow(output.getCount());
        }

        if (!level.isClientSide) {
            usedRecipeCount.merge(recipe.id(), 1, Integer::sum);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.createTag(registries));
        tag.putInt("FuelTime", fuelTime);
        tag.putInt("FuelTimeTotal", fuelTimeTotal);
        tag.putInt("Progress", progress);
        tag.putInt("MaxProgress", maxProgress);

        tag.putInt("RecipesUsedSize", usedRecipeCount.size());
        int i = 0;
        for (Map.Entry<ResourceLocation, Integer> e : usedRecipeCount.entrySet()) {
            tag.putString("RecipeLocation" + i, e.getKey().toString());
            tag.putInt("RecipeAmount" + i, e.getValue());
            i++;
        }

        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.fromTag(tag.getList("inventory", Tag.TAG_COMPOUND), registries);
        fuelTime = tag.getInt("FuelTime");
        fuelTimeTotal = tag.getInt("FuelTimeTotal");
        progress = tag.getInt("Progress");
        maxProgress = tag.getInt("MaxProgress");
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}