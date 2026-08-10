package net.tier1234.better_deco.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.blockentity.FreezerBlockEntity;
import net.tier1234.better_deco.recipe.FreezerRecipe;
import net.tier1234.better_deco.recipe.OvenRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class FreezerCategory implements IRecipeCategory<FreezerRecipe> {


    public static final ResourceLocation UID = Constants.id("freezer");
    public static final ResourceLocation TEXTURE = Constants.id("textures/gui/freezer/freezer_jei.png");

    public static final RecipeType<FreezerRecipe> FREEZER_RECIPE_TYPE =
            new RecipeType<>(UID, FreezerRecipe.class);


    private final IDrawable background;
    private final IDrawable icon;

    public FreezerCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176, 84);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FRIDGE_LIGHT.get()));

    }


    @Override
    public RecipeType<FreezerRecipe> getRecipeType() {
        return FREEZER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.freezer");
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
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, FreezerRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 56, 17).addIngredients(recipe.ingredient);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 116,35).addItemStack(recipe.output);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 56, 53).addItemStacks(FreezerBlockEntity.FreezerFuelValues.get());
    }

    @Override
    public void draw(FreezerRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }
}
