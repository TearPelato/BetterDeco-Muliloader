package net.tier1234.better_deco.screen.custom;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.platform.Services;


public class OvenScreen extends AbstractContainerScreen<OvenMenu> {
    private static final Identifier GUI_TEXTURE =
            Constants.id("textures/gui/oven/oven.png");
    private static final Identifier ARROW_TEXTURE =
            Constants.id("textures/gui/arrow_progress_3.png");
    private static final Identifier LIT_PROGRESS_SPRITE = Identifier.withDefaultNamespace("container/furnace/lit_progress");

    public OvenScreen(OvenMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.text(this.font, this.playerInventoryTitle, 7, 91, 4210752, false);
        graphics.text(this.font, this.title, 69, 5, 4210752, false);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED,GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight,256,256);

        renderProgressArrows(graphics, x, y);
        renderBrunProgress(graphics, x, y);
    }

    private void renderProgressArrows(GuiGraphicsExtractor gui, int x, int y) {
        for (int i = 0; i < 3; i++) {
            int progress = menu.getScaledArrowProgress(i);

            if (progress > 0) {
                int arrowHeight = 16;
                int arrowX = x + 60 + i * 18;
                int arrowY = y + 36;

                gui.blit(ARROW_TEXTURE, arrowX, arrowY, 0, 0, 16, progress, 16, 16);
            }
        }
    }

    private void renderBrunProgress(GuiGraphicsExtractor graphics, int x, int y) {
        int xLeft = Services.CLIENT.getGuiLeft(this);
        int yTop = Services.CLIENT.getGuiTop(this);

        if (this.menu.isBurning()) {
            int litSpriteHeight = 14;
            int litProgressHeight = Mth.ceil(this.menu.getBurnProgress() * 13.0F) + 1;
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED,LIT_PROGRESS_SPRITE, 14, 14, 0, 14 - litProgressHeight, xLeft + 42, yTop + 10 + 14 - litProgressHeight, 14, litProgressHeight);
        }

    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractRenderState(graphics, mouseX, mouseY, a);
        this.extractLabels(graphics,mouseX,mouseY);
    }
}