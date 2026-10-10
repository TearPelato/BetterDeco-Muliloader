package net.tier1234.better_deco.registries;


import net.minecraft.world.item.crafting.RecipeType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.*;

public class ModRecipes {
    

    public static final ObjectRegistries<OvenRecipe.Serializer> OVEN_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("oven"), OvenRecipe.Serializer::new);
    public static final ObjectRegistries<RecipeType<OvenRecipe>> OVEN_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("oven"));


    public static final ObjectRegistries<MicrowaveRecipe.Serializer> MICROWAVE_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("microwave"), MicrowaveRecipe.Serializer::new);
    public static final ObjectRegistries<RecipeType<MicrowaveRecipe>> MICROWAVE_TYPE =
        ObjectRegistries.registerRecipeType(Constants.id("microwave"));


    public static final ObjectRegistries<FreezerRecipe.Serializer> FREEZER_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("freezer"), FreezerRecipe.Serializer::new);
    public static final ObjectRegistries<RecipeType<FreezerRecipe>> FREEZER_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("freezer"));

    public static final ObjectRegistries<WorkbenchRecipe.Serializer> WORKBENCH_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("workbench"), WorkbenchRecipe.Serializer::new);
    public static final ObjectRegistries<RecipeType<WorkbenchRecipe>> WORKBENCH_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("workbench"));

    public static final ObjectRegistries<CuttingBoardRecipe.Serializer> CUTTING_BOARD_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("cutting_board"), CuttingBoardRecipe.Serializer::new);
    public static final ObjectRegistries<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("cutting_board"));

    public static final ObjectRegistries<ToasterRecipe.Serializer> TOASTER_SERIALIZER =
            ObjectRegistries.registerRecipeSerializer(Constants.id("toaster"), ToasterRecipe.Serializer::new);
    public static final ObjectRegistries<RecipeType<ToasterRecipe>> TOASTER_TYPE =
            ObjectRegistries.registerRecipeType(Constants.id("toaster"));



    public static void init() {}
}
