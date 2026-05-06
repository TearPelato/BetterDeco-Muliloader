package net.tier1234.better_deco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.resource.conditions.v1.ResourceConditions;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;

import java.util.concurrent.CompletableFuture;


public class FabricRecipeProviders extends FabricRecipeProvider {
    public FabricRecipeProviders(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        new CommonRecipeProvider(recipeOutput, (modId, recipeName, builder) -> {
            builder.save(this.withConditions(recipeOutput, ResourceConditions.allModsLoaded(modId)), recipeName);
        }, RecipeProvider::has, RecipeProvider::has).generate();

    }
}
