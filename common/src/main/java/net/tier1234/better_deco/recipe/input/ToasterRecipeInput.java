package net.tier1234.better_deco.recipe.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public record ToasterRecipeInput(ItemStack item) implements RecipeInput {

    @Override
    public ItemStack getItem(int index) {
        return item;
    }

    @Override
    public int size() {
        return 1;
    }
}