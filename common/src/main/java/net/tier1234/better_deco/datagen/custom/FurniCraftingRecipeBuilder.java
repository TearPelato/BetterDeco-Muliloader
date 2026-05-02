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
import net.tier1234.better_deco.recipe.FurniCraftingRecipe;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class FurniCraftingRecipeBuilder implements RecipeBuilder {
    private final NonNullList<CountedIngredient> materials = NonNullList.create();
    private final ItemStack result;
    private boolean showNotification = false;
    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();

    private FurniCraftingRecipeBuilder(ItemStack result) {
        this.result = result;
    }

    public static FurniCraftingRecipeBuilder crafting(ItemLike result, int count) {
        return new FurniCraftingRecipeBuilder(new ItemStack(result, count));
    }

    public static FurniCraftingRecipeBuilder crafting(ItemLike result) {
        return crafting(result, 1);
    }

    public FurniCraftingRecipeBuilder requires(ItemLike item, int count) {
        this.materials.add(new CountedIngredient(Ingredient.of(item), count));
        return this;
    }

    public FurniCraftingRecipeBuilder requires(TagKey<Item> tag, int count) {
        this.materials.add(new CountedIngredient(Ingredient.of(tag), count));
        return this;
    }

    public FurniCraftingRecipeBuilder requires(Ingredient ingredient, int count) {
        this.materials.add(new CountedIngredient(ingredient, count));
        return this;
    }

    public FurniCraftingRecipeBuilder showNotification(boolean show) {
        this.showNotification = show;
        return this;
    }

    @Override
    public FurniCraftingRecipeBuilder unlockedBy(String name, Criterion<?> criterion) {
        this.criteria.put(name, criterion);
        return this;
    }

    @Override
    public FurniCraftingRecipeBuilder group(@Nullable String groupName) {
        // Opzionale: puoi implementarlo se necessario
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

        FurniCraftingRecipe recipe = new FurniCraftingRecipe(
                this.materials,
                this.result,
                this.showNotification
        );

        output.accept(id, recipe, advancementBuilder.build(id.withPrefix("recipes/")));
    }
}