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
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.deco_lib.api.block_entity.BasicLootBlockEntity;
import net.tier1234.better_deco.recipe.MicrowaveRecipe;
import net.tier1234.better_deco.recipe.input.MicrowaveRecipeInput;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.registries.ModRecipes;
import net.tier1234.better_deco.screen.custom.MicrowaveMenu;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MicrowaveBlockEntity extends BasicLootBlockEntity {
    public final SimpleContainer itemHandler = new SimpleContainer(2) {

    };

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    private int progress = 0;
    private int maxProgress = 200;

    public MicrowaveBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MICROWAVE.get(), pos, state);
    }

    private final List<BlockPos> linkedProducers = new ArrayList<>();


    protected final ContainerData data = new ContainerData() {
        @Override
        public int get(int index) {
            return switch (index) {
                case 0 -> MicrowaveBlockEntity.this.progress;
                case 1 -> MicrowaveBlockEntity.this.maxProgress;
                default -> 0;
            };
        }

        @Override
        public void set(int index, int value) {
            switch (index) {
                case 0 -> MicrowaveBlockEntity.this.progress = value;
                case 1 -> MicrowaveBlockEntity.this.maxProgress = value;
            }
        }

        @Override
        public int getCount() {
            return 2;
        }
    };

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        if(hasRecipe()) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    public void craftItem() {
        Optional<RecipeHolder<MicrowaveRecipe>> recipe = getCurrentRecipe();
        ItemStack output = recipe.get().value().output();

        ItemStack copy = itemHandler.getItem(INPUT_SLOT).copy();
        copy.shrink(1);
        itemHandler.setItem(INPUT_SLOT, copy.isEmpty() ? ItemStack.EMPTY : copy);
        itemHandler.setItem(OUTPUT_SLOT, new ItemStack(output.getItem(),
                itemHandler.getItem(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    public void resetProgress() {
        progress = 0;
        maxProgress = 72;
    }

    public boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    public void increaseCraftingProgress() {
        progress++;
    }

    public boolean hasRecipe() {
        Optional<RecipeHolder<MicrowaveRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        ItemStack output = recipe.get().value().output();
        return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    public Optional<RecipeHolder<MicrowaveRecipe>> getCurrentRecipe() {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.MICROWAVE_TYPE.get(), new MicrowaveRecipeInput(itemHandler.getItem(INPUT_SLOT)), level);
    }

    public boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return itemHandler.getItem(OUTPUT_SLOT).isEmpty() ||
                itemHandler.getItem(OUTPUT_SLOT).getItem() == output.getItem();
    }

    public boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getItem(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getItem(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getItem(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getContainerSize());
        for (int i = 0; i < itemHandler.getContainerSize(); i++) {
            inventory.setItem(i, itemHandler.getItem(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    public int getContainerSize() {
        return 2;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("gui.better_deco.microwave");
    }
    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory) {
        return new MicrowaveMenu(windowId, playerInventory, this, this.data);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.createTag(pRegistries));
        pTag.putInt("growth_chamber.progress", progress);
        pTag.putInt("growth_chamber.max_progress", maxProgress);

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    public void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.fromTag(pTag.getList("inventory", Tag.TAG_COMPOUND), pRegistries);
        progress = pTag.getInt("growth_chamber.progress");
        maxProgress = pTag.getInt("growth_chamber.max_progress");
    }


    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        return saveWithoutMetadata(provider);
    }


    @Override
    public Component getDisplayName() {
        return Component.translatable("gui.better_deco.microwave");
    }


    public ItemStack getDisplayedItem() {
        ItemStack output = itemHandler.getItem(1);
        if (!output.isEmpty()) {
            return output;
        }

        return itemHandler.getItem(0);
    }

    public MicrowaveMenu.CustomData getData() {
        return new MicrowaveMenu.CustomData(this.getBlockPos(), this.progress);
    }
}