package net.tier1234.better_deco.mixin.access;

import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.tier1234.better_deco.creative_tabs.BundledTabSelector;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CreativeModeInventoryScreen.class)
public class CreativeModeInventoryScreenMixin {

    @Inject(method = "mouseScrolled", at = @At("HEAD"), cancellable = true)
    private void mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY, CallbackInfoReturnable<Boolean> cir) {
        if(BundledTabSelector.bootstrap().onScroll(mouseX, mouseY, scrollY))
        {
            cir.setReturnValue(true);
        }

        if(net.tier1234.better_deco.creative_tabs.bulding_expansion.BundledTabSelector.bootstrap().onScroll(mouseX, mouseY, scrollY))
        {
            cir.setReturnValue(true);
        }

    }
}