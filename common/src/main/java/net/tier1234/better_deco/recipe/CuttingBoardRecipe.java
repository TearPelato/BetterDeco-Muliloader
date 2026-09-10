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

public class CuttingBoardRecipe extends SingleItemRecipe {

    public CuttingBoardRecipe(CommonInfo commonInfo, Ingredient input, ItemStackTemplate result) {
        super(commonInfo, input, result);
    }

    @Override
    public RecipeSerializer<? extends SingleItemRecipe> getSerializer() {
        return ModRecipes.CUTTING_BOARD_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends SingleItemRecipe> getType() {
        return ModRecipes.CUTTING_BOARD_TYPE.get();
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(input());
    }

    @Override
    public boolean matches(SingleRecipeInput singleRecipeInput, Level level) {
        return this.input().test(singleRecipeInput.item());
    }

    @Override
    public String group() {
        return "CuttingBoard";
    }

    public Ingredient getIngredient() {
        return this.input();
    }

    public ItemStack getResult() {
        return this.result().create();
    }

    public static final MapCodec<CuttingBoardRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    CommonInfo.MAP_CODEC.forGetter(recipe -> recipe.commonInfo),
                    Ingredient.CODEC.fieldOf("ingredient").forGetter(recipe -> recipe.input()),
                    ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.result())
            ).apply(instance, CuttingBoardRecipe::new)
    );

    public static final StreamCodec<RegistryFriendlyByteBuf, CuttingBoardRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    CommonInfo.STREAM_CODEC, recipe -> recipe.commonInfo,
                    Ingredient.CONTENTS_STREAM_CODEC, recipe -> recipe.input(),
                    ItemStackTemplate.STREAM_CODEC, recipe -> recipe.result(),
                    CuttingBoardRecipe::new
            );
}