package net.tier1234.better_deco.screen.tooltip;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.Util;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.screen.custom.WorkbenchMenu;
import net.tier1234.better_deco.screen.custom.WorkbenchScreen;

import java.util.List;
import java.util.Map;

public class ClientWorkbenchRecipeIngredientTooltip implements ClientTooltipComponent {
    private final WorkbenchMenu menu;
    private final CountedIngredient material;
    private final Map<Integer, Integer> counted;

    public ClientWorkbenchRecipeIngredientTooltip(WorkbenchMenu menu, CountedIngredient material, Map<Integer, Integer> counted) {
        this.menu = menu;
        this.material = material;
        this.counted = counted;
    }

    @Override
    public int getHeight(Font font) {
        return 18;
    }

    @Override
    public int getWidth(Font font) {
        return 18 + font.width(getStack(material).getDisplayName());
    }

    @Override
    public void extractImage(Font font, int start, int top, int width, int height, GuiGraphicsExtractor graphics) {
        ItemStack stack = getStack(material).copy();
        stack.setCount(this.material.count());

        graphics.fakeItem(stack, start, top);
        graphics.itemDecorations(font, stack, start, top);
        MutableComponent name = stack.getHoverName().copy().withStyle(ChatFormatting.GRAY);
        graphics.text(font, name, start + 18 + 5, top + 4, 0xFFFFFFFF);

        graphics.nextStratum();
        boolean hasEnough = this.menu.hasMaterials(this.material, this.counted);
        graphics.blit(RenderPipelines.GUI_TEXTURED, WorkbenchScreen.TEXTURE, start, top, hasEnough ? 246 : 240, 40, 6, 5, 256, 256);
    }

    private ItemStack getStack(CountedIngredient material) {
        List<Holder<Item>> items = material.ingredient().items().toList();
        int index = (int) ((Util.getMillis() / 1000) % items.size());
        return new ItemStack(items.get(index).value());
    }
}