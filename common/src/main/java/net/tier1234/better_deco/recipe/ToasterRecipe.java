package net.tier1234.better_deco.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.recipe.input.ToasterRecipeInput;
import net.tier1234.better_deco.registries.ModRecipes;

public class ToasterRecipe implements Recipe<ToasterRecipeInput> {

    public static final int DEFAULT_COOK_TIME = 1200;

    private final Ingredient ingredient;
    private final ItemStack result;
    private final int cookTime;

    public ToasterRecipe(Ingredient ingredient, ItemStack result, int cookTime) {
        this.ingredient = ingredient;
        this.result = result;
        this.cookTime = cookTime > 0 ? cookTime : DEFAULT_COOK_TIME;
    }

    @Override
    public boolean matches(ToasterRecipeInput input, Level level) {
        return ingredient.test(input.item());
    }

    @Override
    public ItemStack assemble(ToasterRecipeInput input, HolderLookup.Provider registries) {
        return result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return result.copy();
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public ItemStack getResult() {
        return result;
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

    public static class Serializer implements RecipeSerializer<ToasterRecipe> {

        public static final MapCodec<ToasterRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(ToasterRecipe::getIngredient),
                ItemStack.CODEC.fieldOf("result").forGetter(ToasterRecipe::getResult),
                Codec.INT.optionalFieldOf("cookingtime", DEFAULT_COOK_TIME).forGetter(ToasterRecipe::getCookTime)
        ).apply(instance, ToasterRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ToasterRecipe> STREAM_CODEC = StreamCodec.composite(
                Ingredient.CONTENTS_STREAM_CODEC, ToasterRecipe::getIngredient,
                ItemStack.STREAM_CODEC, ToasterRecipe::getResult,
                ByteBufCodecs.VAR_INT, ToasterRecipe::getCookTime,
                ToasterRecipe::new
        );

        @Override
        public MapCodec<ToasterRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ToasterRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}