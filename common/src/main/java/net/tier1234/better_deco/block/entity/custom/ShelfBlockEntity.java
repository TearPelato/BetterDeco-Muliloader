package net.tier1234.better_deco.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.init.ModBlockEntities;
import net.tier1234.better_deco.init.ModInventory;
import net.tier1234.better_deco.screen.custom.ShelfMenu;
import net.tier1234.better_deco.screen.custom.TecqueMenu;
import org.jetbrains.annotations.Nullable;

public class ShelfBlockEntity extends RandomizableContainerBlockEntity implements MenuProvider {

    public final ModInventory handler;

    public ShelfBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHELF_BE.get(), pos, state);
        this.handler = new ModInventory(6, stack -> this.setChanged()); // 6 slot
    }

    @Override
    protected Component getDefaultName() {
        return Component.literal("Shelf");
    }

    @Override
    public int getContainerSize() {
        return handler.getContainerSize();
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < handler.getContainerSize(); i++) {
            if (!handler.getItem(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        NonNullList<ItemStack> items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        for (int i = 0; i < getContainerSize(); i++) {
            items.set(i, handler.getItem(i));
        }
        return items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {
        for (int i = 0; i < items.size(); i++) {
            handler.setItem(i, items.get(i));
        }
        setChanged();
    }

    @Override
    public void clearContent() {
        for (int i = 0; i < handler.getContainerSize(); i++) {
            handler.setItem(i, ItemStack.EMPTY);
        }
        setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        return !player.isSpectator() && player.distanceToSqr(
                (double) worldPosition.getX() + 0.5D,
                (double) worldPosition.getY() + 0.5D,
                (double) worldPosition.getZ() + 0.5D
        ) <= 64.0D;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }


    public int getComparatorOutput() {
        return AbstractContainerMenu.getRedstoneSignalFromContainer(this);
    }

    public static void dropContents(Level level, BlockPos pos, ShelfBlockEntity shelf) {
        Containers.dropContents(level, pos, shelf);
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory) {
        return new ShelfMenu(containerId, playerInventory, this);
    }
    public ShelfMenu.CustomData createCustomData() {
        return new ShelfMenu.CustomData(this.getBlockPos());
    }
}