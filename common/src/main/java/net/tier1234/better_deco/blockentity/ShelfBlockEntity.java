package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
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
    public void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        NonNullList<ItemStack> items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(input, items);
        for (int i = 0; i < items.size(); i++) {
            handler.setItem(i, items.get(i));
        }
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        NonNullList<ItemStack> items = NonNullList.withSize(getContainerSize(), ItemStack.EMPTY);
        for (int i = 0; i < getContainerSize(); i++) {
            items.set(i, handler.getItem(i));
        }
        ContainerHelper.saveAllItems(output, items);
    }
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        drops();
        super.preRemoveSideEffects(pos, state);
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