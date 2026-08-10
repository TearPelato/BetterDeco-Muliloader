package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.registries.ModRecipes;
import net.tier1234.better_deco.recipe.OvenRecipe;
import net.tier1234.better_deco.screen.custom.OvenMenu;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class OvenBlockEntity extends BlockEntity implements MenuProvider {
    public final SimpleContainer itemHandler = new SimpleContainer(7) {

    };

    private static final int[] INPUT_SLOTS = {0, 1, 2};
    private static final int[] OUTPUT_SLOTS = {3, 4, 5};
    private static final int FUEL_SLOT = 6;

    protected final ContainerData data;
    private final int[] progress = new int[3];
    private final int maxProgress = 72;
    private int fuelTime = 0;
    private int fuelDuration = 0;


    public OvenBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.OVEN.get(), pos, state);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0, 1, 2 -> progress[i];
                    case 3 -> fuelTime;
                    case 4 -> fuelDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0, 1, 2 -> progress[i] = value;
                    case 3 -> fuelTime = value;
                    case 4 -> fuelDuration = value;
                }
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("gui.better_deco.oven");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inv, Player player) {
        return new OvenMenu(id, inv, this, this.data);
    }

    private boolean hasFuel() {
        return fuelTime > 0;
    }

    private void consumeFuelItem() {
        ItemStack fuel = itemHandler.getItem(FUEL_SLOT);
        if (fuel.isEmpty()) return;


        int burnTime = AbstractFurnaceBlockEntity.getFuel().getOrDefault(fuel.getItem(), 0);
        if (burnTime <= 0) return;

        fuelDuration = burnTime;
        fuelTime     = burnTime;

        ItemStack copy = itemHandler.getItem(FUEL_SLOT).copy();
        copy.shrink(1);
        itemHandler.setItem(FUEL_SLOT, copy.isEmpty() ? ItemStack.EMPTY : copy);

    }


    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getContainerSize());
        for (int i = 0; i < itemHandler.getContainerSize(); i++) {
            inventory.setItem(i, itemHandler.getItem(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public void tick(Level level, BlockPos pos, BlockState state) {
        boolean changed = false;

        boolean anyActive = false;
        for (int i = 0; i < 3; i++) {
            if (hasRecipe(INPUT_SLOTS[i], OUTPUT_SLOTS[i])) { anyActive = true; break; }
        }

        if (anyActive && !hasFuel()) {
            consumeFuelItem();
            changed = true;
        }

        for (int i = 0; i < 3; i++) {
            if (hasFuel() && hasRecipe(INPUT_SLOTS[i], OUTPUT_SLOTS[i])) {
                progress[i]++;
                changed = true;

                if (progress[i] >= maxProgress) {
                    craftItem(INPUT_SLOTS[i], OUTPUT_SLOTS[i]);
                    progress[i] = 0;
                }
            } else {
                if (progress[i] > 0) { progress[i] = 0; changed = true; }
            }
        }

        if (hasFuel() && anyActive) {
            fuelTime--;
            changed = true;
        }

        if (changed) setChanged(level, pos, state);
    }

    private boolean hasRecipe(int inputSlot, int outputSlot) {
        ItemStack inputStack = itemHandler.getItem(inputSlot);
        if(inputStack.isEmpty()) return false;

        Optional<RecipeHolder<OvenRecipe>> recipe = getRecipeFor(inputStack);
        if(recipe.isEmpty()) return false;

        ItemStack output = recipe.get().value().output;
        return canInsert(output, outputSlot);
    }

    private Optional<RecipeHolder<OvenRecipe>> getRecipeFor(ItemStack input) {
        return level.getRecipeManager().getRecipeFor(ModRecipes.OVEN_TYPE.get(), new SingleRecipeInput(input), level);
    }

    private void craftItem(int inputSlot, int outputSlot) {
        ItemStack inputStack = itemHandler.getItem(inputSlot);
        Optional<RecipeHolder<OvenRecipe>> recipe = getRecipeFor(inputStack);
        if(recipe.isEmpty()) return;

        ItemStack output = recipe.get().value().output;
        ItemStack copy = itemHandler.getItem(inputSlot).copy();
        copy.shrink(1);
        itemHandler.setItem(inputSlot, copy.isEmpty() ? ItemStack.EMPTY : copy);

        ItemStack existing = itemHandler.getItem(outputSlot);
        if(existing.isEmpty()) itemHandler.setItem(outputSlot, output.copy());
        else existing.grow(output.getCount());
    }

    private boolean canInsert(ItemStack output, int slot) {
        ItemStack existing = itemHandler.getItem(slot);
        return existing.isEmpty() || (existing.getItem() == output.getItem() && existing.getCount() + output.getCount() <= existing.getMaxStackSize());
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.createTag(registries));
        for(int i=0;i<3;i++) tag.putInt("progress" + i, progress[i]);
        tag.putInt("fuelTime", fuelTime);
        tag.putInt("fuelDuration", fuelDuration);
        super.saveAdditional(tag, registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.fromTag(tag.getList("inventory", Tag.TAG_COMPOUND), registries);
        for(int i=0;i<3;i++) progress[i] = tag.getInt("progress" + i);
        fuelTime     = tag.getInt("fuelTime");
        fuelDuration = tag.getInt("fuelDuration");
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) { return saveWithoutMetadata(registries); }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public OvenMenu.CustomData getData() {
        return new OvenMenu.CustomData(this.getBlockPos(), this.progress[0], this.progress[1], this.progress[2]);
    }
}