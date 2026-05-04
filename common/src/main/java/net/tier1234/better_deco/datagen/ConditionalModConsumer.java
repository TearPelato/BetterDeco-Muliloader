package net.tier1234.better_deco.datagen;

import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;

@FunctionalInterface
public interface ConditionalModConsumer
{
    void apply(String modId, ResourceLocation recipeName, RecipeBuilder builder);
}