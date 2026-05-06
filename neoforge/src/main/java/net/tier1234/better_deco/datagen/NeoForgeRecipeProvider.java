package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.concurrent.CompletableFuture;

public class NeoForgeRecipeProvider extends RecipeProvider {
    public NeoForgeRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        new CommonRecipeProvider(recipeOutput, (modId, recipeName, builder) -> {
            builder.save(recipeOutput.withConditions(new ModLoadedCondition(modId)), recipeName);
        }, RecipeProvider::has, RecipeProvider::has).generate();
    }
}
