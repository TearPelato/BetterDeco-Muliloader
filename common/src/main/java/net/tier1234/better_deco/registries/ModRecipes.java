package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.item.crafting.RecipeType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.*;

@RegistryContainer
public class ModRecipes {
    

    public static final RegistryEntry<OvenRecipe.Serializer> OVEN_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("oven"), OvenRecipe.Serializer::new);
    public static final RegistryEntry<RecipeType<OvenRecipe>> OVEN_TYPE =
            RegistryEntry.recipeType(Constants.id("oven"));


    public static final RegistryEntry<MicrowaveRecipe.Serializer> MICROWAVE_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("microwave"), MicrowaveRecipe.Serializer::new);
    public static final RegistryEntry<RecipeType<MicrowaveRecipe>> MICROWAVE_TYPE =
        RegistryEntry.recipeType(Constants.id("microwave"));


    public static final RegistryEntry<FreezerRecipe.Serializer> FREEZER_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("freezer"), FreezerRecipe.Serializer::new);
    public static final RegistryEntry<RecipeType<FreezerRecipe>> FREEZER_TYPE =
            RegistryEntry.recipeType(Constants.id("freezer"));

    public static final RegistryEntry<WorkbenchRecipe.Serializer> WORKBENCH_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("workbench"), WorkbenchRecipe.Serializer::new);
    public static final RegistryEntry<RecipeType<WorkbenchRecipe>> WORKBENCH_TYPE =
            RegistryEntry.recipeType(Constants.id("workbench"));

    public static final RegistryEntry<CuttingBoardRecipe.Serializer> CUTTING_BOARD_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("cutting_board"), CuttingBoardRecipe.Serializer::new);
    public static final RegistryEntry<RecipeType<CuttingBoardRecipe>> CUTTING_BOARD_TYPE =
            RegistryEntry.recipeType(Constants.id("cutting_board"));

    public static final RegistryEntry<ToasterRecipe.Serializer> TOASTER_SERIALIZER =
            RegistryEntry.recipeSerializer(Constants.id("toaster"), ToasterRecipe.Serializer::new);
    public static final RegistryEntry<RecipeType<ToasterRecipe>> TOASTER_TYPE =
            RegistryEntry.recipeType(Constants.id("toaster"));


}
