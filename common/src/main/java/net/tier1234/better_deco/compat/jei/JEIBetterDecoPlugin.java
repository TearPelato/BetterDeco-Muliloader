package net.tier1234.better_deco.compat.jei;


import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.compat.jei.category.MicrowaveRecipeCategory;
import net.tier1234.better_deco.compat.jei.category.OvenRecipeCategory;
import net.tier1234.better_deco.recipe.MicrowaveRecipe;
import net.tier1234.better_deco.init.ModRecipes;
import net.tier1234.better_deco.recipe.OvenRecipe;
import net.tier1234.better_deco.screen.custom.MicrowaveScreen;
import net.tier1234.better_deco.screen.custom.OvenScreen;

import java.util.List;

@JeiPlugin
public class JEIBetterDecoPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return Constants.id("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new OvenRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));

        registration.addRecipeCategories(new MicrowaveRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()
        ));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<OvenRecipe> ovenRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.OVEN_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE, ovenRecipes);

        List<MicrowaveRecipe> microwaveRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.MICROWAVE_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(MicrowaveRecipeCategory.MICROWAVE_RECIPE_RECIPE_TYPE, microwaveRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(OvenScreen.class, 74, 30, 22, 20,
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeClickArea(MicrowaveScreen.class, 74, 30, 22, 20,
                MicrowaveRecipeCategory.MICROWAVE_RECIPE_RECIPE_TYPE);


    }
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        //Oven
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.OAK_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.SPRUCE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BIRCH_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.JUNGLE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ACACIA_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.DARK_OAK_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MANGROVE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CHERRY_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BAMBOO_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CRIMSON_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WARPED_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);

        registration.addRecipeCatalyst(new ItemStack(ModBlocks.RED_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ORANGE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.YELLOW_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.MAGENTA_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.PINK_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.PURPLE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.GREEN_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.LIME_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.CYAN_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.LIGHT_BLUE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BLUE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.WHITE_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BROWN_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.BLACK_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.GRAY_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.LIGHT_GRAY_OVEN.get().asItem()),
                OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE);


        //Microwave
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.LIGHT_MICROWAVE.get().asItem()),
                MicrowaveRecipeCategory.MICROWAVE_RECIPE_RECIPE_TYPE);
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.DARK_MICROWAVE.get().asItem()),
                MicrowaveRecipeCategory.MICROWAVE_RECIPE_RECIPE_TYPE);
    }
}