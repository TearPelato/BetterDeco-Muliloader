package net.tier1234.better_deco.screen.tooltip;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.Holder;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.screen.custom.WorkbenchMenu;
import net.tier1234.better_deco.screen.custom.WorkbenchScreen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ClientWorkbenchRecipeTooltip implements ClientTooltipComponent {
    private final WorkbenchMenu menu;
    private final WorkbenchRecipe recipe;

    public ClientWorkbenchRecipeTooltip(WorkbenchMenu menu, WorkbenchRecipe recipe) {
        this.menu = menu;
        this.recipe = recipe;
    }

    @Override
    public int getHeight(Font font) {
        return 20;
    }

    @Override
    public int getWidth(Font font) {
        return this.recipe.getMaterials().size() * 18;
    }

    @Override
    public void extractImage(Font font, int start, int top, int width, int height, GuiGraphicsExtractor graphics) {
        Map<Integer, Integer> counted = new HashMap<>();
        List<CountedIngredient> materials = this.recipe.getMaterials();
        for (int i = 0; i < materials.size(); i++) {
            CountedIngredient material = materials.get(i);
            ItemStack copy = getStack(material).copy();
            copy.setCount(material.count());
            graphics.fakeItem(copy, start + i * 18, top);
            graphics.itemDecorations(font, copy, start + i * 18, top);

            graphics.nextStratum();
            boolean hasEnough = this.menu.hasMaterials(material, counted);
            graphics.blit(RenderPipelines.GUI_TEXTURED, WorkbenchScreen.TEXTURE, start + i * 18, top, hasEnough ? 246 : 240, 40, 6, 5, 256, 256);
        }
    }

    private ItemStack getStack(CountedIngredient material) {
        List<Holder<Item>> items = material.ingredient().items().toList();
        int index = (int) ((Util.getMillis() / 1000) % items.size());
        return new ItemStack(items.get(index).value());
    }
}