package net.tier1234.better_deco.screen.custom;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.tier1234.better_deco.Constants;

public class FreezerScreen extends AbstractContainerScreen<FreezerMenu> {
    private static final Identifier GUI_TEXTURE =
            Constants.id("textures/gui/freezer/freezer.png");
    private static final Identifier ARROW_TEXTURE =
            Constants.id("textures/gui/arrow_progress.png");

    public FreezerScreen(FreezerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        super.extractLabels(graphics, xm, ym);
        graphics.text(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 4210752, false);
        graphics.text(this.font, this.title, 60, 6, 4210752, false);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);
        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth,imageHeight, 256,256);

        renderProgressArrow(graphics, x, y);
        renderFreezProgress(graphics, x, y);
    }

    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractContents(graphics, mouseX, mouseY, a);
        this.extractTooltip(graphics, mouseX, mouseY);
    }


    private void renderProgressArrow(GuiGraphicsExtractor graphicsExtractor, int x, int y) {
        if(menu.isCrafting()) {
            graphicsExtractor.blit(RenderPipelines.GUI_TEXTURED,ARROW_TEXTURE,x + 79, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderFreezProgress(GuiGraphicsExtractor graphics, int x, int y) {
        if (this.menu.isFreezing()) {
            int litProgressHeight = Mth.ceil(this.menu.getFreezProgress() * 13.0F) + 1;
            int yOffset = 14 - litProgressHeight;

            graphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x + 57, y + 34 + 15 - litProgressHeight, 176, 13 - litProgressHeight, 14, litProgressHeight, 256, 256);


        }
    }
}