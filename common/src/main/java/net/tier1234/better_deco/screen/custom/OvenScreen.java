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

    private int GUIimageWidht = this.imageWidth;
    private int GUIimageHeight = this.imageHeight;


    public OvenScreen(OvenMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        GUIimageWidht = 176;
        GUIimageHeight = 184;
    }

    @Override
    protected void extractLabels(GuiGraphicsExtractor graphics, int xm, int ym) {
        graphics.text(this.font, this.title, this.titleLabelX, this.titleLabelY - 9, -12566464, false);
        graphics.text(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY + 9, -12566464, false);
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractBackground(graphics, mouseX, mouseY, a);

        int x = (width - imageWidth) / 2;
        int y = (height - GUIimageHeight) / 2;

        graphics.blit(RenderPipelines.GUI_TEXTURED,GUI_TEXTURE, x, y, 0, 0, imageWidth, GUIimageHeight, 256,256);

        renderProgressArrows(graphics, x, y);
        renderBurnProgress(graphics, x, y);
    }


    @Override
    public void extractContents(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float a) {
        super.extractContents(graphics, mouseX, mouseY, a);
        this.extractTooltip(graphics, mouseX, mouseY);
    }


    private void renderBurnProgress(GuiGraphicsExtractor graphics, int x, int y) {
        int xLeft = Services.CLIENT.getGuiLeft(this);
        int yTop = Services.CLIENT.getGuiTop(this);

        if (this.menu.isBurning()) {
            int litSpriteHeight = 14;
            int litProgressHeight = Mth.ceil(this.menu.getBurnProgress() * 13.0F) + 1;
            graphics.blitSprite(RenderPipelines.GUI_TEXTURED, LIT_PROGRESS_SPRITE, 14, 14, 0, 14 - litProgressHeight, xLeft + 42, yTop + 10 + 14 - litProgressHeight, 14, litProgressHeight);
        }

    }



    private void renderProgressArrows(GuiGraphicsExtractor gui, int x, int y) {
        for (int i = 0; i < 3; i++) {
            int progress = menu.getScaledArrowProgress(i);

            if (progress > 0) {
                int arrowHeight = 16;
                int arrowX = x + 60 + i * 18;
                int arrowY = y + 36;

                gui.blit(RenderPipelines.GUI_TEXTURED,ARROW_TEXTURE, arrowX, arrowY, 0, 0, 16, progress, 16, 16);
            }
        }

    }

}