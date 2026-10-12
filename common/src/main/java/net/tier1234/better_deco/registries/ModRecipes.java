package net.tier1234.better_deco.registries;

import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.*;

public class ModRecipes {


    public static final ObjectRegistries<RecipeSerializer<OvenRecipe>> OVEN_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("oven"),()-> {
                return new RecipeSerializer<OvenRecipe>(OvenRecipe.CODEC, OvenRecipe.STREAM_CODEC);
            });
    public static final ObjectRegistries<RecipeType<OvenRecipe>> OVEN_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("oven"));


    public static final ObjectRegistries<RecipeSerializer<MicrowaveRecipe>> MICROWAVE_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("microwave"), ()-> {
                return new RecipeSerializer<>(MicrowaveRecipe.CODEC, MicrowaveRecipe.STREAM_CODEC);
            });
    public static final ObjectRegistries<RecipeType<MicrowaveRecipe>> MICROWAVE_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("microwave"));


    public static final ObjectRegistries<RecipeSerializer<FreezerRecipe>> FREEZER_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("freezer"),()-> {
                return new RecipeSerializer<>(FreezerRecipe.CODEC, FreezerRecipe.STREAM_CODEC);
            });
    public static final ObjectRegistries<RecipeType<FreezerRecipe>> FREEZER_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("freezer"));

    public static final ObjectRegistries<RecipeSerializer<WorkbenchRecipe>> WORKBENCH_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("workbench"), ()-> {
                return new RecipeSerializer<>(WorkbenchRecipe.CODEC, WorkbenchRecipe.STREAM_CODEC);
            });
    public static final ObjectRegistries<RecipeType<WorkbenchRecipe>> WORKBENCH_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("workbench"));

    public static final ObjectRegistries<RecipeSerializer<CuttingBoardRecipe>> CUTTING_BOARD_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("cutting_board"), ()-> {
                return new RecipeSerializer<>(CuttingBoardRecipe.CODEC, CuttingBoardRecipe.STREAM_CODEC);
            });

    public static final ObjectRegistries<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("cutting_board"));

    public static final ObjectRegistries<RecipeSerializer<ToasterRecipe>> TOASTER_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("toaster"), ()-> {
                return new RecipeSerializer<>(ToasterRecipe.CODEC, ToasterRecipe.STREAM_CODEC);
            });
    public static final ObjectRegistries<RecipeType<ToasterRecipe>> TOASTER_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("toaster"));


    public static void init() {}
}