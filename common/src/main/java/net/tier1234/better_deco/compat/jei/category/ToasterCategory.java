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
import net.tier1234.better_deco.recipe.ToasterRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class ToasterCategory implements IRecipeCategory<ToasterRecipe> {

    public static final ResourceLocation TEXTURE = Constants.id("textures/gui/jei/toaster_jei.png");
    public static final ResourceLocation UID = Constants.id("toaster");
    public static final RecipeType<ToasterRecipe> TYPE =
            new RecipeType<>(UID, ToasterRecipe.class);


    private IDrawable icon;
    private IDrawable background;

    public ToasterCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 176, 84);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.TOASTER_LIGHT.get()));
    }


    @Override
    public RecipeType<ToasterRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("category.better_deco.toaster");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
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
    public void setRecipe(IRecipeLayoutBuilder builder, ToasterRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(51,16).addIngredients(recipe.getIngredient());
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY,51,45).addItemStack(new ItemStack(ModBlocks.TOASTER_LIGHT.get()));
        builder.addOutputSlot(127,35).addItemStack(recipe.getResult());
    }

    @Override
    public void draw(ToasterRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }
}
