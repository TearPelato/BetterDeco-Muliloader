package net.tier1234.better_deco.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Inventory;
import net.tier1234.better_deco.Constants;

public class FreezerScreen extends AbstractContainerScreen<FreezerMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            Constants.id( "textures/gui/freezer/freezer.png");
    private static final ResourceLocation ARROW_TEXTURE =
            Constants.id("textures/gui/arrow_progress.png");

    public FreezerScreen(FreezerMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
        this.imageWidth = 176;
        this.imageHeight = 166;
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 94, 4210752, false);
        guiGraphics.drawString(this.font, this.title, 60, 6, 4210752, false);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float partialTick, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = (this.width - this.imageWidth) / 2;
        int y = (this.height - this.imageHeight) / 2;

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, this.imageWidth, this.imageHeight);
        renderProgressArrow(guiGraphics, x, y);
        renderFreezProgress(guiGraphics, x, y);


    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        this.renderTooltip(guiGraphics, mouseX, mouseY);

    }
    private void renderProgressArrow(GuiGraphics graphics, int x, int y) {
        if(menu.isCrafting()) {
            graphics.blit(ARROW_TEXTURE,x + 79, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    private void renderFreezProgress(GuiGraphics graphics, int x, int y) {
        if (this.menu.isFreezing()) {
            int litProgressHeight = Mth.ceil(this.menu.getFreezProgress() * 13.0F) + 1;
            int yOffset = 14 - litProgressHeight;

            graphics.blit(GUI_TEXTURE, x + 57, y + 34 + 15 - litProgressHeight, 176, 13 - litProgressHeight, 14, litProgressHeight, 256, 256);


        }
    }
}