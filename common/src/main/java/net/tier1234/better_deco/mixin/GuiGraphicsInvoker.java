package net.tier1234.better_deco.mixin;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraft.resources.Identifier;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(GuiGraphicsExtractor.class)
public interface GuiGraphicsInvoker {

    @Invoker("setTooltipForNextFrameInternal")
    void invokeTooltip(Font font, List<ClientTooltipComponent> lines, int xo, int yo, ClientTooltipPositioner positioner, @Nullable Identifier style, boolean replaceExisting);
}