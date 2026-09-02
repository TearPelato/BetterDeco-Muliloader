package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.deco_lib.api.block_entity.BasicLootBlockEntity;
import net.tier1234.better_deco.block.FridgeBlock;
import net.tier1234.better_deco.registries.ModBlockEntities;


public class FridgeBlockEntity extends BasicLootBlockEntity
{

    public FridgeBlockEntity(BlockPos pos, BlockState state)
    {
        super(ModBlockEntities.FRIDGE.get(), pos, state);
    }

    @Override
    public int getContainerSize()
    {
        return 45;
    }

    @Override
    protected Component getDefaultName()
    {
        return Component.translatable("gui.better_deco.fridge");
    }

    @Override
    protected AbstractContainerMenu createMenu(int windowId, Inventory playerInventory)
    {
        return new ChestMenu(MenuType.GENERIC_9x5, windowId, playerInventory, this, 5);
    }

}