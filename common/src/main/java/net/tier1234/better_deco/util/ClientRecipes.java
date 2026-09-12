package net.tier1234.better_deco.util;

import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;

import java.util.List;
import java.util.Optional;

/**
 * Author: MrCrayfish
 * Edited by Me to fit this mod
 */
public class ClientRecipes {

    private List<ItemStack> workbenchResults = List.of();
    private List<RecipeHolder<WorkbenchRecipe>> workbenchRecipes = List.of();

    public void accept(List<RecipeHolder<WorkbenchRecipe>> recipes) {
        this.workbenchRecipes = ImmutableList.copyOf(recipes);
    }

    public List<ItemStack> workbenchResults() {
        return this.workbenchResults;
    }

    public List<RecipeHolder<WorkbenchRecipe>> workbenchRecipes() {
        return this.workbenchRecipes;
    }

    public interface Access {
        ClientRecipes clientRecipes();
    }

    public static Optional<ClientRecipes> get() {
        return Optional.ofNullable(Minecraft.getInstance().getConnection())
                .map(listener -> ((Access) listener).clientRecipes());
    }
}