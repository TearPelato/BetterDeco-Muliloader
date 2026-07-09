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
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.screen.custom.TecqueMenu;
import org.jetbrains.annotations.Nullable;

public class TecqueBlockEntity extends BlockEntity implements MenuProvider {
    public final SimpleContainer inventory = new SimpleContainer(1) {
        @Override
        public int getMaxStackSize() {
            return 1;
        }

    };
    private float rotation;

    public TecqueBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.GLASS_TECQUE.get(), pos, blockState);
    }

    public float getRenderingRotation() {
        rotation += 0.5f;
        if(rotation >= 360) {
            rotation = 0;
        }
        return rotation;
    }

    public void clearContents() {
        inventory.setItem(0, ItemStack.EMPTY);
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
        tag.put("inventory", inventory.createTag(registries));
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        inventory.fromTag(tag.getList("inventory", Tag.TAG_COMPOUND), registries);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Tecque");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new TecqueMenu(i, inventory, this);
    }


    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    public TecqueMenu.TecqueData createCustomData() {
        return new TecqueMenu.TecqueData(this.getBlockPos());
    }
}
