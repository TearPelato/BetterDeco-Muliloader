package net.tier1234.better_deco.platform.services;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;

import java.util.Collection;

public interface IRecipeHelper {
    Collection<RecipeHolder<WorkbenchRecipe>> getWorkbenchRecipes(ServerLevel level);
}
