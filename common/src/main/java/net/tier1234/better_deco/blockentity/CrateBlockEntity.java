package net.tier1234.better_deco.blockentity;


import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.deco_lib.api.block_entity.BasicLootBlockEntity;
import net.tier1234.better_deco.registries.ModBlockEntities;

public class CrateBlockEntity extends BasicLootBlockEntity {
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
    public int getContainerSize() {
        return 66;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.better_deco.crate");
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory) {
        return new ChestMenu(MenuType.GENERIC_9x6, windowId, playerInventory, this,6);
    }


}
