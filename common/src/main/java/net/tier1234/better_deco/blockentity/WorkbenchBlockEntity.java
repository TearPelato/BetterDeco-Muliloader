package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.screen.custom.WorkbenchMenu;

import org.jetbrains.annotations.Nullable;

public class WorkbenchBlockEntity extends BlockEntity implements MenuProvider {
    private final SimpleContainer inventory = new SimpleContainer(1);
    protected final DataSlot selectedRecipe = DataSlot.standalone();

    public WorkbenchBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.FURNI_WORKBENCH.get(), blockPos, blockState);
        this.selectedRecipe.set(-1);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("container.better_deco.workbench");
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new WorkbenchMenu(id, inventory, level, this.worldPosition, this.inventory);
    }

    public DataSlot selectedRecipeDataSlot()
    {
        return this.selectedRecipe;
    }

    public void drops() {
        SimpleContainer inv = new SimpleContainer(inventory.getContainerSize());
        for(int i = 0; i < inventory.getContainerSize(); i++) {
            inv.setItem(i, inventory.getItem(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inv);
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        ContainerHelper.saveAllItems(tag, inventory.getItems(), registries);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        ContainerHelper.loadAllItems(tag, inventory.getItems(), registries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithoutMetadata(registries);
    }


    public WorkbenchMenu.CustomData createCustomData() {
        return new WorkbenchMenu.CustomData(this.selectedRecipe.get());
    }
}