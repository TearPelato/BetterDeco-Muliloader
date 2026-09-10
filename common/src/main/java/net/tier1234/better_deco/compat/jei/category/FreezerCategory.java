package net.tier1234.better_deco.compat.jei.category;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.blockentity.FreezerBlockEntity;
import net.tier1234.better_deco.recipe.FreezerRecipe;
import net.tier1234.better_deco.recipe.MicrowaveRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;

import java.util.function.Supplier;

public class FreezerCategory extends FurnitureRecipeCategory<FreezerRecipe> {


    public static final Identifier TEXTURE = Constants.id("textures/gui/jei/freezer_jei.png");
    public static final Supplier<IRecipeHolderType<FreezerRecipe>> TYPE = IRecipeHolderType.createDeferred(ModRecipes.FREEZER_TYPE::get);



    public FreezerCategory(IGuiHelper helper) {
       super(TYPE,
               Component.translatable("gui.better_deco.freezer"),
               helper.createDrawable(TEXTURE, 0,0,176, 84),
               helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.FRIDGE_LIGHT.get())));


    }


    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.freezer");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<FreezerRecipe> recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 56, 17).add(recipe.value().ingredient);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 116,35).add(recipe.value().output);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 56, 53).add(FreezerBlockEntity.FreezerFuelValues.get().getFirst());
    }

    @Override
    public void draw(RecipeHolder<FreezerRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }

}
