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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.OvenRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OvenRecipeCategory extends FurnitureRecipeCategory<OvenRecipe> {


    public static final Identifier TEXTURE = Constants.id("textures/gui/jei/oven_jei_2.png");
    public static final Supplier<IRecipeHolderType<OvenRecipe>> TYPE = IRecipeHolderType.createDeferred(ModRecipes.OVEN_TYPE::get);

    public OvenRecipeCategory(IGuiHelper helper) {
        super(TYPE,
             Component.translatable("gui.better_deco.oven"),
             helper.createDrawable(TEXTURE, 0,0,176, 81),
             helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.OAK_OVEN.get())));

    }


    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.oven");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<OvenRecipe> recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 78, 17).add(recipe.value().inputItem);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 53).add(recipe.value().output);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 42, 35).add(OvenFuels.get().getFirst());
    }


    @Override
    public void draw(RecipeHolder<OvenRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }


    public enum OvenFuels {
        COAL(300, Items.COAL),
        CHARCOAL(350, Items.CHARCOAL);

        public final int cookTime;
        public final Item item;

        OvenFuels(int cookTime, Item item){
            this.cookTime = cookTime;
            this.item = item;

        }

        public static List<ItemStack> get() {
            List<ItemStack> stacks = new ArrayList<>();
            for (OvenFuels fuel : values()) {
                stacks.add(new ItemStack(fuel.item));
            }
            return stacks;
        }
    }

}
