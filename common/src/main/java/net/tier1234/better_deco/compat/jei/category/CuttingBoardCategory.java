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
import net.tier1234.better_deco.recipe.CuttingBoardRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;
import org.jetbrains.annotations.Nullable;

public class CuttingBoardCategory implements IRecipeCategory<CuttingBoardRecipe> {

    public static final ResourceLocation TEXTURE = Constants.id("textures/gui/jei/cutting_board_jei.png");
    public static final ResourceLocation UID = Constants.id("cutting_board");
    public static final RecipeType<CuttingBoardRecipe> TYPE =
            new RecipeType<>(UID, CuttingBoardRecipe.class);


    private IDrawable icon;
    private IDrawable background;

    public CuttingBoardCategory(IGuiHelper guiHelper) {
        this.background = guiHelper.createDrawable(TEXTURE, 0, 0, 176, 84);
        this.icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OAK_CUTTING_BOARD.get()));
    }


    @Override
    public RecipeType<CuttingBoardRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("category.better_deco.cutting_board");
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
    public void setRecipe(IRecipeLayoutBuilder builder, CuttingBoardRecipe recipe, IFocusGroup focuses) {
        builder.addInputSlot(33,35).addIngredients(recipe.getIngredient());
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY,69,35).addItemStack(new ItemStack(ModItems.KITCHEN_KNIFE.get()));
        builder.addOutputSlot(127,35).addItemStack(recipe.getResult());
    }

    @Override
    public void draw(CuttingBoardRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
    }
}
