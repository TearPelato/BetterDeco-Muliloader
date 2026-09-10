package net.tier1234.better_deco.screen.custom;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;
import net.tier1234.better_deco.Constants;


public class MicrowaveScreen extends AbstractContainerScreen<MicrowaveMenu> {
    private static final Identifier GUI_TEXTURE =
            Constants.id("textures/gui/microwave/microwave_gui.png");
    private static final Identifier ARROW_TEXTURE =
            Constants.id("textures/gui/arrow_progress.png");

    public MicrowaveScreen(MicrowaveMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
        renderProgressArrow(graphics, x, y);
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractContents(graphics, mouseX, mouseY, a);
        this.extractTooltip(graphics, mouseX, mouseY);
    }

    private void renderProgressArrow(GuiGraphicsExtractor graphicsExtractor, int x, int y) {
        if(menu.isCrafting()) {
            graphicsExtractor.blit(RenderPipelines.GUI_TEXTURED,ARROW_TEXTURE,x + 73, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }
}