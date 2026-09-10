package net.tier1234.better_deco.datagen.custom;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.criterion.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.ToasterRecipe;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToasterRecipeBuilder implements RecipeBuilder {

    private final Ingredient ingredient;
    private final Item result;
    private final int count;
    private final int cookTime;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
    private String group;

    public ToasterRecipeBuilder(Ingredient ingredient, ItemLike result, int count, int cookTime) {
        this.ingredient = ingredient;
        this.result = result.asItem();
        this.count = count;
        this.cookTime = cookTime;
    }

    public static ToasterRecipeBuilder toasting(Ingredient ingredient, ItemLike result) {
        return new ToasterRecipeBuilder(ingredient, result, 1, ToasterRecipe.DEFAULT_COOK_TIME);
    }

    public static ToasterRecipeBuilder toasting(Ingredient ingredient, ItemLike result, int count, int cookTime) {
        return new ToasterRecipeBuilder(ingredient, result, count, cookTime);
    }

    @Override
    public RecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public RecipeBuilder group(String group) {
        this.group = group;
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return null;
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        ensureValid(resourceKey);

        Advancement.Builder advancement = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);

        criteria.forEach(advancement::addCriterion);

        ToasterRecipe recipe = new ToasterRecipe(ingredient, new ItemStackTemplate(result, count), cookTime);
        recipeOutput.accept(resourceKey, recipe, advancement.build(Constants.id("recipes/toasting/")));
    }

    public Item getResult() {
        return result;
    }

    private void ensureValid(ResourceKey<Recipe<?>> resourceKey) {
        if (criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceKey);
        }
    }
}
