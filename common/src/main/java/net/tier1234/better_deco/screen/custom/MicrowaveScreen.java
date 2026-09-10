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
        super(menu, playerInventory, title);    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.text(this.font, this.playerInventoryTitle, 7, 73, 4210752, false);
        graphics.text(this.font, this.title, 7, 7, 4210752, false);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED,GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight,256,256);
        renderProgressArrow(graphics, x, y);
    }


    private void renderProgressArrow(GuiGraphicsExtractor guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW_TEXTURE,x + 73, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);
        this.extractLabels(graphics,mouseX,mouseY);
    }

}
