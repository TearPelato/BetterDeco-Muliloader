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
import net.tier1234.better_deco.recipe.CuttingBoardRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;
import net.tier1234.better_deco.registries.ModRecipes;

import java.util.function.Supplier;

public class CuttingBoardCategory extends FurnitureRecipeCategory<CuttingBoardRecipe> {

    public static final Identifier TEXTURE = Constants.id("textures/gui/jei/cutting_board_jei.png");
    public static final Supplier<IRecipeHolderType<CuttingBoardRecipe>> TYPE = IRecipeHolderType.createDeferred(ModRecipes.CUTTING_BOARD_TYPE::get);


    public CuttingBoardCategory(IGuiHelper guiHelper) {
        super(TYPE,
                Component.translatable("category.better_deco.cutting_board"),
                guiHelper.createDrawable(TEXTURE, 0, 0, 176, 84),
                guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OAK_CUTTING_BOARD.get())));

    }

    @Override
    public Component getTitle() {
        return Component.translatable("category.better_deco.cutting_board");
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<CuttingBoardRecipe> recipe, IFocusGroup focuses) {
        builder.addInputSlot(33,35).add(recipe.value().getIngredient());
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY,69,35).add(new ItemStack(ModItems.KITCHEN_KNIFE.get()));
        builder.addOutputSlot(127,35).add(recipe.value().getResult());
    }

    @Override
    public void draw(RecipeHolder<CuttingBoardRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }
}
