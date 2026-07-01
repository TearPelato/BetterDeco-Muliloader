package net.tier1234.better_deco.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.block.entity.custom.FreezerBlockEntity;

public class FreezerFuelSlot extends Slot {


    public FreezerFuelSlot(Container container, int slot, int x, int y) {
        super(container, slot, x, y);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return FreezerBlockEntity.FreezerFuelValues.isValid(stack);
    }

    @Override
    public int getMaxStackSize() {
        return super.getMaxStackSize();
    }
}
