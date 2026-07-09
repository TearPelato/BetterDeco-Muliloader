package net.tier1234.better_deco.block.entity.custom;

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
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.deco_lib.api.block_entity.BasicLootBlockEntity;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.registries.ModRecipes;
import net.tier1234.better_deco.recipe.FreezerRecipe;
import net.tier1234.better_deco.screen.custom.FreezerMenu;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FreezerBlockEntity extends BasicLootBlockEntity implements MenuProvider {
    public final SimpleContainer itemHandler = new SimpleContainer(3) {

    };

    private static final int SLOT_INPUT = 0;
    private static final int SLOT_OUTPUT = 1;
    private static final int SLOT_FUEL = 2;

    private int progress = 0;
    private int maxProgress = 450;
    private int fuelTime = 0;
    private int fuelDuration = 0;
    protected final ContainerData data;

    public FreezerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FREEZER.get(), pos, state);

        data = new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> FreezerBlockEntity.this.progress;
                    case 1 -> FreezerBlockEntity.this.maxProgress;
                    case 2 -> FreezerBlockEntity.this.fuelTime;
                    case 3 -> FreezerBlockEntity.this.fuelDuration;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> FreezerBlockEntity.this.progress = value;
                    case 1 -> FreezerBlockEntity.this.maxProgress = value;
                    case 2 -> FreezerBlockEntity.this.fuelTime = value;
                    case 3 -> FreezerBlockEntity.this.fuelDuration = value;
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
        return Component.translatable("gui.better_deco.freezer");
    }

    private boolean hasFuel() {
        return fuelTime > 0;
    }

    private void consumeFuelItem(HolderLookup.Provider provider) {
        ItemStack fuel = itemHandler.getItem(SLOT_FUEL);
        if (fuel.isEmpty()) return;

        int burnTime = FreezerFuelValues.of(fuel)
                .map(f -> f.freezTime)
                .orElse(0);
        if (burnTime <= 0) return;

        fuelDuration = burnTime;
        fuelTime     = burnTime;

        ItemStack copy = itemHandler.getItem(SLOT_FUEL).copy();
        copy.shrink(1);
        itemHandler.setItem(SLOT_FUEL, copy.isEmpty() ? ItemStack.EMPTY : copy);


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
            if (hasRecipe(SLOT_INPUT, SLOT_OUTPUT)) {
                anyActive = true; break; }
        }

        if (anyActive && !hasFuel()) {
            consumeFuelItem(level.registryAccess());
            changed = true;
        }

        for (int i = 0; i < 3; i++) {
            if (hasFuel() && hasRecipe(SLOT_INPUT, SLOT_OUTPUT)) {
                progress++;
                changed = true;

                if (progress >= maxProgress) {
                    craftItem(SLOT_INPUT, SLOT_OUTPUT);
                    progress = 0;
                }
            } else {
                if (progress > 0) {
                    progress = 0; changed = true;
                }
            }
        }

        if (hasFuel() && anyActive) {
            fuelTime--;
            changed = true;
        }

        if (changed) setChanged(level, pos, state);
    }

    private  boolean hasRecipe(int inputSlot, int outputSlot) {
        ItemStack resource = itemHandler.getItem(inputSlot);
        if (resource.isEmpty()) return false;

        Optional<RecipeHolder<FreezerRecipe>> recipe = getRecipeFor(resource);
        if (recipe.isEmpty()) return false;

        ItemStack output = recipe.get().value().output;
        return canInsert(output, outputSlot);
    }

    private boolean canInsert(ItemStack output, int slot) {
         ItemStack existing = itemHandler.getItem(slot);
        return existing.isEmpty() || (existing.getItem() == output.getItem() && existing.getCount() + output.getCount() <= existing.getMaxStackSize());
    }

    private Optional<RecipeHolder<FreezerRecipe>> getRecipeFor(ItemStack input) {
        return  this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.FREEZER_TYPE.get(), new SingleRecipeInput(input), level);
    }

    private boolean canFreeze(RecipeHolder<FreezerRecipe> recipe) {
        ItemStack output = recipe.value().getResultItem(this.level.registryAccess());
        if (output.isEmpty()) return false;

        ItemStack resultStack = itemHandler.getItem(SLOT_OUTPUT);
        if (resultStack.isEmpty()) return true;
        return resultStack.getCount() + output.getCount() <= resultStack.getMaxStackSize();
    }

    private void craftItem(int inputSlot, int outputSlot) {
        ItemStack inputStack = itemHandler.getItem(inputSlot);
        Optional<RecipeHolder<FreezerRecipe>> recipe = getRecipeFor(inputStack);
        if(recipe.isEmpty()) return;

        ItemStack output = recipe.get().value().output;
        ItemStack copy = itemHandler.getItem(inputSlot).copy();
        copy.shrink(1);
        itemHandler.setItem(inputSlot, copy.isEmpty() ? ItemStack.EMPTY : copy);

        ItemStack existing = itemHandler.getItem(outputSlot);
        if(existing.isEmpty()) itemHandler.setItem(outputSlot, output.copy());
        else existing.grow(output.getCount());
    }

    @Override
    public int getContainerSize() {
        return 3;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("gui.better_deco.freezer");
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory) {
       return new FreezerMenu(windowId, playerInventory, this, this.data);
    }


    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        tag.put("inventory", itemHandler.createTag(registries));
        tag.putInt("Freezer.progress", progress);
        tag.putInt("Freezer.max_progress", maxProgress);
        tag.putInt("fuelTime", fuelTime);
        tag.putInt("fuelDuration", fuelDuration);
        super.saveAdditional(tag, registries);
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        itemHandler.fromTag(tag.getList("inventory", Tag.TAG_COMPOUND), registries);
        progress = tag.getInt("Freezer.progress");
        maxProgress = tag.getInt("Freezer.max_progress");
        fuelTime     = tag.getInt("fuelTime");
        fuelDuration = tag.getInt("fuelDuration");
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

    public FreezerMenu.FreezerData createCustomData() {
        return new FreezerMenu.FreezerData(this.getBlockPos());
    }

    public enum FreezerFuelValues {
        ICE(300, Items.ICE),
        PACKED_ICE(350, Items.PACKED_ICE),
        BLUE_ICE(450, Items.BLUE_ICE),
        POWDER_SNOW(250, Items.POWDER_SNOW_BUCKET);

        public final int freezTime;
        public final Item item;

        FreezerFuelValues(int freezTime, Item item){
            this.freezTime = freezTime;
            this.item = item;

        }

        public static Optional<FreezerFuelValues> of(ItemStack stack) {
            if (stack.isEmpty()) return Optional.empty();
            for (FreezerFuelValues fuel : values()) {
                if (stack.is(fuel.item)) return Optional.of(fuel);
            }
            return Optional.empty();
        }

        public static boolean isValid(ItemStack stack) {
            return of(stack).isPresent();
        }

        public static float getMultiplier(ItemStack stack) {
            return of(stack).map(f -> f.freezTime).orElse(0);
        }

        public static List<ItemStack> get() {
            List<ItemStack> stacks = new ArrayList<>();
            for (FreezerFuelValues fuel : values()) {
                stacks.add(new ItemStack(fuel.item));
            }
            return stacks;
        }
    }
}