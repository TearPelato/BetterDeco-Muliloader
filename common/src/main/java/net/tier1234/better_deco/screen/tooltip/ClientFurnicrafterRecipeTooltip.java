package net.tier1234.better_deco.screen.tooltip;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.FurniCraftingRecipe;
import net.tier1234.better_deco.screen.custom.FurniWorkbenchMenu;
import net.tier1234.better_deco.screen.custom.FurniWorkbenchScreen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClientFurnicrafterRecipeTooltip implements ClientTooltipComponent {
    private final FurniWorkbenchMenu menu;
    private final FurniCraftingRecipe recipe;

    public ClientFurnicrafterRecipeTooltip(FurniWorkbenchMenu menu, FurniCraftingRecipe recipe) {
        this.menu = menu;
        this.recipe = recipe;
    }

    @Override
    public int getHeight() {
        return 20;
    }

    @Override
    public int getWidth(Font font) {
        // Each ingredient occupies 18 pixels in width.
        return this.recipe.getMaterials().size() * 18;
    }

    @Override
    public void renderImage(Font font, int start, int top, GuiGraphics graphics) {
        Map<Integer, Integer> counted = new HashMap<>();
        List<CountedIngredient> materials = this.recipe.getMaterials();
        for (int i = 0; i < materials.size(); i++) {
            CountedIngredient material = materials.get(i);
            ItemStack copy = getStack(material).copy();
            copy.setCount(material.count());
            // Render the ingredient icon
            graphics.renderFakeItem(copy, start + i * 18, top);
            graphics.renderItemDecorations(font, copy, start + i * 18, top);

            // Draw a check or a cross depending on whether the player has enough material.
            PoseStack pose = graphics.pose();
            pose.pushPose();
            // Translate Z so the overlay is drawn on top.
            pose.translate(0, 0, 200);
            boolean hasEnough = this.menu.hasMaterials(material, counted);
            graphics.blit(FurniWorkbenchScreen.TEXTURE, start + i * 18, top, hasEnough ? 246 : 240, 40, 6, 5, 256, 256);
            pose.popPose();
        }
    }

    private ItemStack getStack(CountedIngredient material) {
        ItemStack[] items = material.ingredient().getItems();
        int index = (int) ((Util.getMillis() / 1000) % items.length);
        return items[index];
    }
}