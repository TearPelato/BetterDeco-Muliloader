package net.tier1234.better_deco.screen.slot;

import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.tier1234.better_deco.screen.custom.OvenMenu;

public class OvenFuelSlot extends Slot {

    private final OvenMenu menu;

    public OvenFuelSlot(OvenMenu menu,Container container, int slot, int x, int y) {
        super(container, slot, x, y);
        this.menu = menu;
    }


    @Override
    public boolean mayPlace(ItemStack stack) {
        return menu.isFuelItem(stack);
    }

    @Override
    public int getMaxStackSize(ItemStack itemStack) {
        return isBucket(itemStack) ? 1 : super.getMaxStackSize(itemStack);
    }

    public static boolean isBucket(ItemStack itemStack) {
        return itemStack.is(Items.BUCKET);
    }
}