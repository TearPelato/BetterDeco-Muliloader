package net.tier1234.better_deco.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;


public class FreezerRecipeInput implements RecipeInput {
    private final ItemStack input;

    public FreezerRecipeInput(ItemStack input) {
        this.input = input;
    }

    public ItemStack getInput() {
        return input;
    }

    @Override
    public ItemStack getItem(int i) {
        return input;
    }

    @Override
    public int size() {
        return 1;
    }
}