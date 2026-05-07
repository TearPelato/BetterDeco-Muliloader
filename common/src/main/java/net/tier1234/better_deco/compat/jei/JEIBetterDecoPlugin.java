package net.tier1234.better_deco.compat.jei;


import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.core.RegistryAccess;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.compat.jei.category.FurniWorkbenchCategory;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.compat.jei.category.MicrowaveRecipeCategory;
import net.tier1234.better_deco.compat.jei.category.OvenRecipeCategory;
import net.tier1234.better_deco.recipe.MicrowaveRecipe;
import net.tier1234.better_deco.init.ModRecipes;
import net.tier1234.better_deco.recipe.OvenRecipe;
import net.tier1234.better_deco.screen.custom.MicrowaveScreen;
import net.tier1234.better_deco.screen.custom.OvenScreen;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIBetterDecoPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return Constants.id("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new OvenRecipeCategory(guiHelper));
        registration.addRecipeCategories(new MicrowaveRecipeCategory(guiHelper));
        registration.addRecipeCategories(new FurniWorkbenchCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager manager = getRecipeManager();
        registration.addRecipes(OvenRecipeCategory.OVEN_RECIPE_RECIPE_TYPE, this.getRecipes(ModRecipes.OVEN_TYPE.get()));
        registration.addRecipes(MicrowaveRecipeCategory.MICROWAVE_RECIPE_RECIPE_TYPE, this.getRecipes(ModRecipes.MICROWAVE_TYPE.get()));
        registration.addRecipes(FurniWorkbenchCategory.TYPE, this.getRecipes(ModRecipes.WORKBENCH_TYPE.get()));
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
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.FURNI_WORKBENCH.get().asItem()),
                FurniWorkbenchCategory.TYPE);
    }

    /**
     * @author MrCrayfish
     *
     * Helpers
     * */

    private <C extends RecipeInput, T extends Recipe<C>> List<T> getRecipes(RecipeType<T> type)
    {
        return getRecipeManager().getAllRecipesFor(type).stream().map(RecipeHolder::value).toList();
    }

    public static RecipeManager getRecipeManager()
    {
        ClientPacketListener listener = Objects.requireNonNull(Minecraft.getInstance().getConnection());
        return listener.getRecipeManager();
    }

    private static RegistryAccess getRegistryAccess()
    {
        ClientPacketListener listener = Objects.requireNonNull(Minecraft.getInstance().getConnection());
        return listener.registryAccess();
    }

    public static ItemStack getResult(Recipe<?> recipe)
    {
        return recipe.getResultItem(getRegistryAccess());
    }

}