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
import net.tier1234.better_deco.recipe.ToasterRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;

import java.util.function.Supplier;

public class ToasterCategory extends FurnitureRecipeCategory<ToasterRecipe> {

    public static final Identifier TEXTURE = Constants.id("textures/gui/jei/toaster_jei.png");
    public static final Supplier<IRecipeHolderType<ToasterRecipe>> TYPE = IRecipeHolderType.createDeferred(ModRecipes.TOASTER_TYPE::get);


    public ToasterCategory(IGuiHelper guiHelper) {
        super(TYPE,
                Component.translatable("category.better_deco.toaster"),
                guiHelper.createDrawable(TEXTURE, 0, 0, 176, 84),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TOASTER_LIGHT.get())));
    }


    @Override
    public Component getTitle() {
        return Component.translatable("category.better_deco.toaster");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<ToasterRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(51,16).add(recipe.value().getIngredient());
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY,51,45).add(new ItemStack(ModBlocks.TOASTER_LIGHT.get()));
        builder.addOutputSlot(127,35).add(recipe.value().getResult());
    }


    @Override
    public void draw(RecipeHolder<ToasterRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }
}
