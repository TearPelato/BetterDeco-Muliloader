package net.tier1234.better_deco.recipe;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.registries.ModRecipes;

public class MicrowaveRecipe implements Recipe<SingleRecipeInput> {

    public final Ingredient ingredient;
    public final ItemStackTemplate output;

    public MicrowaveRecipe(Ingredient input, ItemStackTemplate output) {
        this.ingredient = input;
        this.output = output;
    }

    @Override
    public boolean matches(SingleRecipeInput singleItemRecipe, Level level) {
        return ingredient.test(singleItemRecipe.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput singleItemRecipe) {
        return output.create();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Microwave";
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return ModRecipes.MICROWAVE_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return ModRecipes.MICROWAVE_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(ingredient);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static final MapCodec<MicrowaveRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.output)
            ).apply(instance, MicrowaveRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, MicrowaveRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.ingredient,
                    ItemStackTemplate.STREAM_CODEC, recipe -> recipe.output,
                    MicrowaveRecipe::new
            );
}