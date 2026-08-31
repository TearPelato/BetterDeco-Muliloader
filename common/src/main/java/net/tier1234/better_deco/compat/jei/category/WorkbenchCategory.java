package net.tier1234.better_deco.compat.jei.category;

import com.ibm.icu.impl.Pair;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.compat.jei.JEIBetterDecoPlugin;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorkbenchCategory implements IRecipeCategory<WorkbenchRecipe> {

    public static final ResourceLocation TEXTURE = Constants.id("textures/gui/workbench/workbench_jei.png");

    public static final ResourceLocation UID = Constants.id("furni_crafting");
    public static final RecipeType<WorkbenchRecipe> TYPE =
            new RecipeType<>(UID, WorkbenchRecipe.class);



    private IDrawable icon;
    private IDrawable background;
    private IGuiHelper guiHelper;
    private List<Pair<Vector2i, IDrawable>> slots = new ArrayList<>();

    public WorkbenchCategory(IGuiHelper guiHelper) {
        this.guiHelper = guiHelper;
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 176, 75);
        this.icon = guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.WORKBENCH.get()));
    }

    @Override
    public RecipeType<WorkbenchRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.jei.workbench");
    }


    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, WorkbenchRecipe recipe, IFocusGroup focuses) {

        this.slots.clear();
        NonNullList<CountedIngredient> ingredients =recipe.getMaterials();
        int leftPos = 10;
        int topPos = 10;
        int slotSize = 18;
        int boxSize = 54;
        int width = slotSize * Mth.clamp(ingredients.size(), 1, 3);
        int height = slotSize * Mth.clamp(Mth.ceil(ingredients.size() / (float) 3), 1, 3);
        for(int i = 0; i < ingredients.size(); i++)
        {
            int x = leftPos + (i % 3) * slotSize + (boxSize - width) / 2;
            int y = topPos + (i / 3) * slotSize + (boxSize - height) / 2;
            CountedIngredient material = ingredients.get(i);
            List<ItemStack> stacks = Arrays.stream(material.ingredient().getItems()).map(stack -> {
                ItemStack copy = stack.copy();
                copy.setCount(material.count());
                return copy;
            }).toList();
            builder.addSlot(RecipeIngredientRole.INPUT, x, y).addItemStacks(stacks);
            this.slots.add(Pair.of(new Vector2i(x - 1, y - 1), this.guiHelper.createDrawable(TEXTURE, 0, 0, 16, 16)));


        builder.addSlot(RecipeIngredientRole.OUTPUT, 104,29).addItemStack(JEIBetterDecoPlugin.getResult(recipe));
    }
}

    @Override
    public void draw(WorkbenchRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }
}
