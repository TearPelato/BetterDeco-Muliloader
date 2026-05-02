package net.tier1234.better_deco.mixin.access;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.world.item.CreativeModeTab;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(CreativeModeInventoryScreen.class)
public interface CreativeModeInventoryScreenAccessor {
    @Accessor
    static CreativeModeTab getSelectedTab() {
        throw new UnsupportedOperationException();
    }
    @Accessor("scrollOffs")
    float getScrollOffs();

    @Accessor("scrollOffs")
    void setScrollOffs(float value);
}
