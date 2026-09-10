package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.*;

@RegistryContainer
public class ModRecipes {
    

    public static final RegistryEntry<RecipeSerializer<OvenRecipe>> OVEN_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("oven"),()-> {
                return new RecipeSerializer<OvenRecipe>(OvenRecipe.CODEC, OvenRecipe.STREAM_CODEC);
            });
    public static final RegistryEntry<RecipeType<OvenRecipe>> OVEN_TYPE =
            RegistryEntry.recipeType(Constants.id("oven"));


    public static final RegistryEntry<RecipeSerializer<MicrowaveRecipe>> MICROWAVE_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("microwave"), ()-> {
                return new RecipeSerializer<>(MicrowaveRecipe.CODEC, MicrowaveRecipe.STREAM_CODEC);
            });
    public static final RegistryEntry<RecipeType<MicrowaveRecipe>> MICROWAVE_TYPE =
        RegistryEntry.recipeType(Constants.id("microwave"));


    public static final RegistryEntry<RecipeSerializer<FreezerRecipe>> FREEZER_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("freezer"),()-> {
                return new RecipeSerializer<>(FreezerRecipe.CODEC, FreezerRecipe.STREAM_CODEC);
            });
    public static final RegistryEntry<RecipeType<FreezerRecipe>> FREEZER_TYPE =
            RegistryEntry.recipeType(Constants.id("freezer"));

    public static final RegistryEntry<RecipeSerializer<WorkbenchRecipe>> WORKBENCH_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("workbench"), ()-> {
                return new RecipeSerializer<>(WorkbenchRecipe.CODEC, WorkbenchRecipe.STREAM_CODEC);
            });
    public static final RegistryEntry<RecipeType<WorkbenchRecipe>> WORKBENCH_TYPE =
            RegistryEntry.recipeType(Constants.id("workbench"));

    public static final RegistryEntry<RecipeSerializer<CuttingBoardRecipe>> CUTTING_BOARD_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("cutting_board"), ()-> {
                return new RecipeSerializer<>(CuttingBoardRecipe.CODEC, CuttingBoardRecipe.STREAM_CODEC);
            });
    public static final RegistryEntry<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD_TYPE =
            RegistryEntry.recipeType(Constants.id("cutting_board"));

    public static final RegistryEntry<RecipeSerializer<ToasterRecipe>> TOASTER_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("toaster"), ()-> {
                return new RecipeSerializer<>(ToasterRecipe.CODEC, ToasterRecipe.STREAM_CODEC);
            });
    public static final RegistryEntry<RecipeType<ToasterRecipe>> TOASTER_TYPE =
            RegistryEntry.recipeType(Constants.id("toaster"));


}
