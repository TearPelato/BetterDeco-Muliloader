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
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.compat.jei.category.*;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;
import net.tier1234.better_deco.screen.custom.FreezerScreen;
import net.tier1234.better_deco.screen.custom.MicrowaveScreen;
import net.tier1234.better_deco.screen.custom.OvenScreen;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class JEIBetterDecoPlugin implements IModPlugin {
    @Override
    public Identifier getPluginUid() {
        return Constants.id("jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        IGuiHelper guiHelper = registration.getJeiHelpers().getGuiHelper();

        registration.addRecipeCategories(new OvenRecipeCategory(guiHelper));
        registration.addRecipeCategories(new MicrowaveRecipeCategory(guiHelper));
        registration.addRecipeCategories(new WorkbenchCategory(guiHelper));
        registration.addRecipeCategories(new FreezerCategory(guiHelper));
        registration.addRecipeCategories(new CuttingBoardCategory(guiHelper));
        registration.addRecipeCategories(new ToasterCategory(guiHelper));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(OvenRecipeCategory.TYPE.get(), this.getRecipes(ModRecipes.OVEN_TYPE.get()));
        registration.addRecipes(MicrowaveRecipeCategory.TYPE.get(), this.getRecipes(ModRecipes.MICROWAVE_TYPE.get()));
        registration.addRecipes(WorkbenchCategory.TYPE.get(), this.getRecipes(ModRecipes.WORKBENCH_TYPE.get()));
        registration.addRecipes(FreezerCategory.TYPE.get(), this.getRecipes(ModRecipes.FREEZER_TYPE.get()));
        registration.addRecipes(CuttingBoardCategory.TYPE.get(), this.getRecipes(ModRecipes.CUTTING_BOARD_TYPE.get()));
        registration.addRecipes(ToasterCategory.TYPE.get(), this.getRecipes(ModRecipes.TOASTER_TYPE.get()));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(OvenScreen.class, 74, 30, 22, 20,
                OvenRecipeCategory.TYPE.get());
        registration.addRecipeClickArea(MicrowaveScreen.class, 74, 30, 22, 20,
                MicrowaveRecipeCategory.TYPE.get());
        registration.addRecipeClickArea(FreezerScreen.class, 74, 30, 22, 20,
                FreezerCategory.TYPE.get());

    }
    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        //Oven
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(),new ItemStack(ModBlocks.OAK_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.SPRUCE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.BIRCH_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.JUNGLE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.ACACIA_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.DARK_OAK_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.MANGROVE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.CHERRY_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.BAMBOO_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.CRIMSON_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.WARPED_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.RED_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.ORANGE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.YELLOW_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.MAGENTA_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.PINK_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.PURPLE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.GREEN_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.LIME_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.CYAN_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.LIGHT_BLUE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.BLUE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.WHITE_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.BROWN_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.BLACK_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.GRAY_OVEN.get().asItem()));
        registration.addCraftingStation(OvenRecipeCategory.TYPE.get(), new ItemStack(ModBlocks.LIGHT_GRAY_OVEN.get().asItem()));


        //Microwave
        registration.addCraftingStation(MicrowaveRecipeCategory.TYPE.get(),new ItemStack(ModBlocks.LIGHT_MICROWAVE.get().asItem()));
        registration.addCraftingStation(MicrowaveRecipeCategory.TYPE.get(),new ItemStack(ModBlocks.DARK_MICROWAVE.get().asItem()));
        registration.addCraftingStation(WorkbenchCategory.TYPE.get(),new ItemStack(ModBlocks.WORKBENCH.get().asItem())
        );

        //Freezer
        registration.addCraftingStation(FreezerCategory.TYPE.get(), new ItemStack(ModBlocks.FRIDGE_LIGHT.get()));
        registration.addCraftingStation(FreezerCategory.TYPE.get(), new ItemStack(ModBlocks.FRIDGE_DARK.get()));

        //Cutting Board
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.OAK_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.SPRUCE_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.BIRCH_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.JUNGLE_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.ACACIA_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.DARK_OAK_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.MANGROVE_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.CHERRY_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.BAMBOO_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.CRIMSON_CUTTING_BOARD.get().asItem()));
        registration.addCraftingStation(CuttingBoardCategory.TYPE.get(), new ItemStack(ModBlocks.WARPED_CUTTING_BOARD.get().asItem()));


        registration.addCraftingStation(ToasterCategory.TYPE.get(), new ItemStack(ModBlocks.TOASTER_LIGHT.get()));
        registration.addCraftingStation(ToasterCategory.TYPE.get(), new ItemStack(ModBlocks.TOASTER_DARK.get()));


    }

    /**
     * @author MrCrayfish
     *
     * Helpers
     * */

    private <C extends RecipeInput, T extends Recipe<C>> List<RecipeHolder<T>> getRecipes(RecipeType<T> type)
    {
        return List.copyOf(SyncedRecipes.getMap().byType(type));
    }


    private static RegistryAccess getRegistryAccess()
    {
        ClientPacketListener listener = Objects.requireNonNull(Minecraft.getInstance().getConnection());
        return listener.registryAccess();
    }

}