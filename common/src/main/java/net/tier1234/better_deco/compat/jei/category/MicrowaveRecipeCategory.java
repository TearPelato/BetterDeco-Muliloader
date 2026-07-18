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
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.recipe.MicrowaveRecipe;
import org.jetbrains.annotations.Nullable;

public class MicrowaveRecipeCategory implements IRecipeCategory<MicrowaveRecipe> {

    public static final ResourceLocation UID = Constants.id("microwave");
    public static final ResourceLocation TEXTURE = Constants.id("textures/gui/microwave/microwave_gui_jei.png");

    public static final RecipeType<MicrowaveRecipe> MICROWAVE_RECIPE_RECIPE_TYPE =
            new RecipeType<>(UID, MicrowaveRecipe.class);


    private final IDrawable background;
    private final IDrawable icon;

    public MicrowaveRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0,0,176, 85);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.LIGHT_MICROWAVE.get()));

    }

    @Override
    public RecipeType<MicrowaveRecipe> getRecipeType() {
        return MICROWAVE_RECIPE_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.microwave");
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
    public void setRecipe(IRecipeLayoutBuilder builder, MicrowaveRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).addItemStack(recipe.getResultItem(null));
    }

}
