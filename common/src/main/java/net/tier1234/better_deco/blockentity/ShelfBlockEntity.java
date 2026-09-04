package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.deco_lib.api.block_entity.BasicLootBlockEntity;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.screen.custom.ShelfMenu;
import org.jetbrains.annotations.Nullable;

public class ShelfBlockEntity extends BasicLootBlockEntity {
    public final SimpleContainer handler = new SimpleContainer(4);

    public ShelfBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.SHELF_BE.get(), pos, state);
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.better_deco.shelf");
    }

    @Override
    public int getContainerSize() {
        return 4;
    }

    public boolean insertItem(Player player, ItemStack stack) {
        for (int i = 0; i < handler.getContainerSize(); i++) {
            if (handler.getItem(i).isEmpty()) {
                ItemStack toInsert = stack.copyWithCount(1);
                handler.setItem(i, toInsert);
                if (!player.getAbilities().instabuild) {
                    stack.shrink(1);
                }
                setChanged();
                if (level != null) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
                return true;
            }
        }
        return false;
    }

    public ItemStack extractItem(Player player) {
        for (int i = 0; i < handler.getContainerSize(); i++) {
            ItemStack stack = handler.getItem(i);
            if (!stack.isEmpty()) {
                handler.setItem(i, ItemStack.EMPTY);
                if (!player.getInventory().add(stack)) {
                    player.drop(stack, false);
                }
                setChanged();
                if (level != null) {
                    level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                }
                return stack;
            }
        }
        return ItemStack.EMPTY;
    }

    @Override
    public void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        handler.clearContent();
        ListTag items = tag.getList("Items", Tag.TAG_COMPOUND);
        for (int i = 0; i < items.size(); i++) {
            CompoundTag itemTag = items.getCompound(i);
            int slot = itemTag.getInt("Slot");
            if (slot >= 0 && slot < handler.getContainerSize()) {
                ItemStack.parse(registries, itemTag.getCompound("Item"))
                        .ifPresent(stack -> handler.setItem(slot, stack));
            }
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ListTag items = new ListTag();
        for (int i = 0; i < handler.getContainerSize(); i++) {
            ItemStack stack = handler.getItem(i);
            if (!stack.isEmpty()) {
                CompoundTag itemTag = new CompoundTag();
                itemTag.putInt("Slot", i);
                itemTag.put("Item", stack.save(registries));
                items.add(itemTag);
            }
        }
        tag.put("Items", items);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }



    public void drops() {
        SimpleContainer inv = new SimpleContainer(handler.getContainerSize());
        for(int i = 0; i < handler.getContainerSize(); i++) {
            inv.setItem(i, handler.getItem(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
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