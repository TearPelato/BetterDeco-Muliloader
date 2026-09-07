package net.tier1234.better_deco.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.SingleItemRecipe;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.registries.ModRecipes;

public class CuttingBoardRecipe extends SingleItemRecipe {
    public CuttingBoardRecipe( Ingredient ingredient, ItemStack result) {
        super(ModRecipes.CUTTING_BOARD_TYPE.get(),ModRecipes.CUTTING_BOARD_SERIALIZER.get(), "", ingredient, result);
    }

    public CuttingBoardRecipe(String s, Ingredient ingredient, ItemStack itemStack) {
            this(ingredient, itemStack);
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level) {
        return this.ingredient.test(singleRecipeInput.item());
    }

    public Ingredient getIngredient()
    {
        return this.ingredient;
    }

    public ItemStack getResult()
    {
        return this.result;
    }


    public static class Serializer extends SingleItemRecipe.Serializer<CuttingBoardRecipe> {
        public Serializer() {
            super(CuttingBoardRecipe::new);
        }
    }
}
