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
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;

public class FreezerRecipe implements Recipe<SingleRecipeInput> {

    public final Ingredient ingredient;
    public final ItemStackTemplate output;
    public final int fuelCost;

    public FreezerRecipe(Ingredient ingredient, ItemStackTemplate output, int fuelCost) {
        this.ingredient = ingredient;
        this.output = output;
        this.fuelCost = fuelCost;
    }

    @Override
    public boolean matches(SingleRecipeInput container, Level level) {
        return ingredient.test(container.item());
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
        return "Freezer";
    }

    @Override
    public RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return ModRecipes.FREEZER_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return ModRecipes.FREEZER_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(ingredient);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static final MapCodec<FreezerRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.output),
                    Codec.INT.optionalFieldOf("fuelCost", 200).forGetter(recipe -> recipe.fuelCost)
            ).apply(instance, FreezerRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, FreezerRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.ingredient,
                    ItemStackTemplate.STREAM_CODEC, recipe -> recipe.output,
                    ByteBufCodecs.VAR_INT, recipe -> recipe.fuelCost,
                    FreezerRecipe::new
            );
}