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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.recipe.OvenRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

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
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }


    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, OvenRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 78, 17).addIngredients(recipe.inputItem);
        builder.addSlot(RecipeIngredientRole.OUTPUT, 78, 53).addItemStack(recipe.output);
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 42, 35).addItemStacks(OvenFuels.get());

    }

    @Override
    public void draw(OvenRecipe recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        this.background.draw(guiGraphics, 0, 0);
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
