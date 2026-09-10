package net.tier1234.better_deco.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.registries.ModRecipes;

public class OvenRecipe implements Recipe<SingleRecipeInput> {

    public final Ingredient inputItem;
    public final ItemStackTemplate output;
    public final int fuelCost;

    public OvenRecipe(Ingredient inputItem, ItemStackTemplate output, int fuelCost) {
        this.inputItem = inputItem;
        this.output = output;
        this.fuelCost = fuelCost;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        return inputItem.test(input.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput singleRecipeInput) {
        return output.create();
    }

    @Override
    public boolean showNotification() {
        return false;
    }

    @Override
    public String group() {
        return "Oven";
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return ModRecipes.OVEN_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return ModRecipes.OVEN_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputItem);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static final MapCodec<OvenRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.inputItem),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.output),
                    Codec.INT.optionalFieldOf("fuel_cost", 200).forGetter(recipe -> recipe.fuelCost)
            ).apply(instance, OvenRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, OvenRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.inputItem,
                    ItemStackTemplate.STREAM_CODEC, recipe -> recipe.output,
                    ByteBufCodecs.VAR_INT, recipe -> recipe.fuelCost,
                    OvenRecipe::new
            );
}