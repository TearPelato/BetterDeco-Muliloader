package net.tier1234.better_deco.datagen.custom;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.triggers.Criterion;
import net.minecraft.advancements.triggers.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class WorkbenchRecipeBuilder implements RecipeBuilder {
    private final NonNullList<CountedIngredient> materials = NonNullList.create();
    private final ItemStackTemplate result;
    private boolean showNotification = false;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    private WorkbenchRecipeBuilder(ItemStackTemplate result) {
        this.result = result;
    }

    public static WorkbenchRecipeBuilder crafting(ItemLike result, int count) {
        return new WorkbenchRecipeBuilder(new ItemStackTemplate(result.asItem(), count));
    }

    public static WorkbenchRecipeBuilder crafting(ItemLike result) {
        return crafting(result, 1);
    }

    public WorkbenchRecipeBuilder requires(ItemLike item, int count) {
        this.materials.add(new CountedIngredient(Ingredient.of(item), count));
        return this;
    }

    public WorkbenchRecipeBuilder requires(Ingredient ingredient, int count) {
        this.materials.add(new CountedIngredient(ingredient, count));
        return this;
    }

    public WorkbenchRecipeBuilder showNotification(boolean show) {
        this.showNotification = show;
        return this;
    }

    @Override
    public WorkbenchRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public WorkbenchRecipeBuilder group(@Nullable String groupName) {
        return this;
    }

    @Override
    public ResourceKey<Recipe<?>> defaultId() {
        return RecipeBuilder.getDefaultRecipeId(this.result);
    }

    @Override
    public void save(RecipeOutput recipeOutput, ResourceKey<Recipe<?>> resourceKey) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + resourceKey);
        }

        Advancement.Builder advancementBuilder = recipeOutput.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceKey))
                .rewards(AdvancementRewards.Builder.recipe(resourceKey))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancementBuilder::addCriterion);

        WorkbenchRecipe recipe = new WorkbenchRecipe(
                this.materials,
                this.result,
                this.showNotification
        );

        recipeOutput.accept(resourceKey, recipe, advancementBuilder.build(Constants.id("recipes/")));
    }
}