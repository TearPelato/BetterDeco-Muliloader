package net.tier1234.better_deco.block.entity.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.init.ModBlockEntities;
import net.tier1234.better_deco.screen.custom.CrateMenu;
import org.jetbrains.annotations.Nullable;

public class CrateBlockEntity extends BlockEntity implements MenuProvider {
    public final SimpleContainer inventory = new SimpleContainer(66) {
        @Override
        public int getMaxStackSize() {
            return 1;
        }

    };

    public CrateBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.STORAGE_CRATE.get(), pos, blockState);
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
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Crate");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new CrateMenu(i, inventory, this);
    }

}
