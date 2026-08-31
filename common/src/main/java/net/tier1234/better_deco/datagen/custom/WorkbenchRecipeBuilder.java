package net.tier1234.better_deco.datagen.custom;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRequirements;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.core.NonNullList;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class WorkbenchRecipeBuilder implements RecipeBuilder {
    private final NonNullList<CountedIngredient> materials = NonNullList.create();
    private final ItemStack result;
    private boolean showNotification = false;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    private WorkbenchRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static WorkbenchRecipeBuilder crafting(ItemLike result, int count) {
        return new WorkbenchRecipeBuilder(new ItemStack(result, count));
    }

    public static WorkbenchRecipeBuilder crafting(ItemLike result) {
        return crafting(result, 1);
    }

    public WorkbenchRecipeBuilder requires(ItemLike item, int count) {
        this.materials.add(new CountedIngredient(Ingredient.of(item), count));
        return this;
    }

    public WorkbenchRecipeBuilder requires(TagKey<Item> tag, int count) {
        this.materials.add(new CountedIngredient(Ingredient.of(tag), count));
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
    public Item getResult() {
        return this.result.getItem();
    }

    @Override
    public void save(RecipeOutput output, ResourceLocation id) {
        if (this.criteria.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + id);
        }

        Advancement.Builder advancementBuilder = output.advancement()
                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(id))
                .rewards(AdvancementRewards.Builder.recipe(id))
                .requirements(AdvancementRequirements.Strategy.OR);

        this.criteria.forEach(advancementBuilder::addCriterion);

        WorkbenchRecipe recipe = new WorkbenchRecipe(
                this.materials,
                this.result,
                this.showNotification
        );

        output.accept(id, recipe, advancementBuilder.build(id.withPrefix("recipes/")));
    }
}