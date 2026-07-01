package net.tier1234.better_deco.recipe;


import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.init.ModRecipes;

public class FreezerRecipe implements Recipe<SingleRecipeInput> {

    public final Ingredient ingredient;
    public final ItemStack output;
    public final int fuelCost;

    public FreezerRecipe(Ingredient ingredient, ItemStack output, int fuelCost) {
        this.ingredient = ingredient;
        this.output = output;
        this.fuelCost = fuelCost;
    }


    @Override
    public boolean matches(SingleRecipeInput container, Level level) {
        return ingredient.test(container.item());
    }

    @Override
    public ItemStack assemble(SingleRecipeInput container, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return output;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FREEZER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FREEZER_TYPE.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.FRIDGE_LIGHT.get());
    }

    public static class Serializer implements RecipeSerializer<FreezerRecipe> {
        public static final MapCodec<FreezerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.ingredient),
                ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.output),
                Codec.INT.optionalFieldOf("fuelCost", 0).forGetter(recipe -> recipe.fuelCost)
        ).apply(inst, FreezerRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FreezerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, r -> r.ingredient,
                        ItemStack.STREAM_CODEC, r-> r.output,
                        ByteBufCodecs.VAR_INT, r-> r.fuelCost,
                        FreezerRecipe::new);

        @Override
        public MapCodec<FreezerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FreezerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}