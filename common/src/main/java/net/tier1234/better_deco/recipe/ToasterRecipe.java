package net.tier1234.better_deco.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.recipe.input.ToasterRecipeInput;
import net.tier1234.better_deco.registries.ModRecipes;

public class ToasterRecipe implements Recipe<ToasterRecipeInput> {

    public static final int DEFAULT_COOK_TIME = 1200;

    private final Ingredient ingredient;
    private final ItemStackTemplate result;
    private final int cookTime;

    public ToasterRecipe(Ingredient ingredient, ItemStackTemplate result, int cookTime) {
        this.ingredient = ingredient;
        this.result = result;
        this.cookTime = cookTime > 0 ? cookTime : DEFAULT_COOK_TIME;
    }

    @Override
    public boolean matches(ToasterRecipeInput input, Level level) {
        return ingredient.test(input.item());
    }

    @Override
    public ItemStack assemble(ToasterRecipeInput toasterRecipeInput) {
        return result.create();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Toaster";
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack getResult() {
        return result.create();
    }

    public int getCookTime() {
        return cookTime;
    }

    @Override
    public RecipeSerializer<? extends Recipe<ToasterRecipeInput>> getSerializer() {
        return ModRecipes.TOASTER_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ToasterRecipeInput>> getType() {
        return ModRecipes.TOASTER_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(ingredient);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static final MapCodec<ToasterRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                    Codec.INT.optionalFieldOf("cookingtime", DEFAULT_COOK_TIME).forGetter(ToasterRecipe::getCookTime)
            ).apply(instance, ToasterRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, ToasterRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.ingredient,
                    ItemStackTemplate.STREAM_CODEC, recipe -> recipe.result,
                    ByteBufCodecs.VAR_INT, ToasterRecipe::getCookTime,
                    ToasterRecipe::new
            );
}