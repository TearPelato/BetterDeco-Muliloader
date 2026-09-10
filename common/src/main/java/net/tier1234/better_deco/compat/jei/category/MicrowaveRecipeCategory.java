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
import net.tier1234.better_deco.recipe.MicrowaveRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;

import java.util.function.Supplier;

public class MicrowaveRecipeCategory extends FurnitureRecipeCategory<MicrowaveRecipe> {

    public static final Identifier UID = Constants.id("microwave");
    public static final Identifier TEXTURE = Constants.id("textures/gui/jei/microwave_gui_jei.png");
    public static final Supplier<IRecipeHolderType<MicrowaveRecipe>> TYPE = IRecipeHolderType.createDeferred(ModRecipes.MICROWAVE_TYPE::get);


    public MicrowaveRecipeCategory(IGuiHelper helper) {
       super(TYPE,
               Component.translatable("gui.better_deco.microwave"),
               helper.createDrawable(TEXTURE, 0,0,176, 85),
               helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.LIGHT_MICROWAVE.get())));

    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.microwave");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<MicrowaveRecipe> recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 54, 34).add(recipe.value().ingredient);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 34).add(recipe.value().output);
    }

    @Override
    public void draw(RecipeHolder<MicrowaveRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }

}
