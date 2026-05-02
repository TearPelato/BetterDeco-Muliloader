package net.tier1234.better_deco.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.recipe.OvenRecipe;
import org.jetbrains.annotations.Nullable;

public class OvenRecipeCategory implements IRecipeCategory<OvenRecipe> {

    public static final ResourceLocation UID = Constants.id("oven");
    public static final ResourceLocation TEXTURE = Constants.id("textures/gui/oven/oven_jei_2.png");

    public static final RecipeType<OvenRecipe> OVEN_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, OvenRecipe.class);


    private final IDrawable background;
    private final IDrawable icon;

    public OvenRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176, 81);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OAK_OVEN.get()));

    }

    @Override
    public RecipeType<OvenRecipe> getRecipeType() {
        return OVEN_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.oven");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, OvenRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 78, 17).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 53).addItemStack(recipe.getResultItem(null));
    }

}
