package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SingleItemRecipeBuilder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.datagen.custom.ToasterRecipeBuilder;
import net.tier1234.better_deco.datagen.custom.WorkbenchRecipeBuilder;
import net.tier1234.better_deco.recipe.CuttingBoardRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

import java.util.concurrent.CompletableFuture;

public class CommonRecipeProvider extends RecipeProvider {

    protected CommonRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    public void buildRecipes() {
        shaped(RecipeCategory.DECORATIONS, ModBlocks.WORKBENCH.get())
                .pattern("PPP")
                .pattern("ICI")
                .pattern("I I")
                .define('P', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .define('C', Blocks.CRAFTING_TABLE)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(this.output);


        shaped(RecipeCategory.TOOLS, ModItems.KITCHEN_KNIFE.get())
                .pattern("   ")
                .pattern(" AB")
                .pattern(" CA")
                .define('A', Items.STRING)
                .define('B', Items.IRON_INGOT)
                .define('C', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_string", has(Items.STRING))
                .save(this.output);



        WorkbenchRecipeBuilder.crafting(ModBlocks.FRIDGE_LIGHT.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.WHITE_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(this.output);

        WorkbenchRecipeBuilder.crafting(ModBlocks.FRIDGE_DARK.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.GRAY_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(this.output);


        WorkbenchRecipeBuilder.crafting(ModBlocks.LIGHT_MICROWAVE.get(), 1)
                .requires(Items.WHITE_CONCRETE,3)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .requires(Items.GLASS_PANE, 1)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(this.output);


        WorkbenchRecipeBuilder.crafting(ModBlocks.DARK_MICROWAVE.get(), 1)
                .requires(Items.GRAY_CONCRETE,3)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .requires(Items.GLASS_PANE, 1)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(this.output);


        this.kitchenCounter(Blocks.OAK_PLANKS, ModBlocks.OAK_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.WARPED_PLANKS, ModBlocks.WARPED_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_KITCHEN_COUNTER.get());

        this.kitchenDrawer(Blocks.OAK_PLANKS, ModBlocks.OAK_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.WARPED_PLANKS, ModBlocks.WARPED_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_KITCHEN_DRAWER.get());

        this.kitchenCabinet(Blocks.OAK_PLANKS, ModBlocks.OAK_CABINET.get());
        this.kitchenCabinet(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CABINET.get());
        this.kitchenCabinet(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CABINET.get());
        this.kitchenCabinet(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CABINET.get());
        this.kitchenCabinet(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CABINET.get());
        this.kitchenCabinet(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CABINET.get());
        this.kitchenCabinet(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CABINET.get());
        this.kitchenCabinet(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CABINET.get());
        this.kitchenCabinet(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CABINET.get());
        this.kitchenCabinet(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CABINET.get());
        this.kitchenCabinet(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CABINET.get());
        this.kitchenCabinet(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_CABINET.get());

        this.kitchenOven(Blocks.OAK_PLANKS, ModBlocks.OAK_OVEN.get());
        this.kitchenOven(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_OVEN.get());
        this.kitchenOven(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_OVEN.get());
        this.kitchenOven(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_OVEN.get());
        this.kitchenOven(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_OVEN.get());
        this.kitchenOven(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_OVEN.get());
        this.kitchenOven(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_OVEN.get());
        this.kitchenOven(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_OVEN.get());
        this.kitchenOven(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_OVEN.get());
        this.kitchenOven(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_OVEN.get());
        this.kitchenOven(Blocks.WARPED_PLANKS, ModBlocks.WARPED_OVEN.get());
        this.kitchenOven(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_OVEN.get());

        this.kitchenSink(Blocks.OAK_PLANKS, ModBlocks.OAK_SINK.get());
        this.kitchenSink(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_SINK.get());
        this.kitchenSink(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_SINK.get());
        this.kitchenSink(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_SINK.get());
        this.kitchenSink(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_SINK.get());
        this.kitchenSink(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_SINK.get());
        this.kitchenSink(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_SINK.get());
        this.kitchenSink(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_SINK.get());
        this.kitchenSink(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_SINK.get());
        this.kitchenSink(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_SINK.get());
        this.kitchenSink(Blocks.WARPED_PLANKS, ModBlocks.WARPED_SINK.get());
        this.kitchenSink(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_SINK.get());

        this.kitchenCounter(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.RED_CONCRETE, ModBlocks.RED_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.LIME_CONCRETE, ModBlocks.LIME_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_KITCHEN_COUNTER.get());
        this.kitchenCounter(Blocks.PINK_CONCRETE, ModBlocks.PINK_KITCHEN_COUNTER.get());

        this.kitchenDrawer(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.RED_CONCRETE, ModBlocks.RED_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.LIME_CONCRETE, ModBlocks.LIME_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_KITCHEN_DRAWER.get());
        this.kitchenDrawer(Blocks.PINK_CONCRETE, ModBlocks.PINK_KITCHEN_DRAWER.get());

        this.kitchenOven(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_OVEN.get());
        this.kitchenOven(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_OVEN.get());
        this.kitchenOven(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_OVEN.get());
        this.kitchenOven(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_OVEN.get());
        this.kitchenOven(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_OVEN.get());
        this.kitchenOven(Blocks.RED_CONCRETE, ModBlocks.RED_OVEN.get());
        this.kitchenOven(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_OVEN.get());
        this.kitchenOven(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_OVEN.get());
        this.kitchenOven(Blocks.LIME_CONCRETE, ModBlocks.LIME_OVEN.get());
        this.kitchenOven(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_OVEN.get());
        this.kitchenOven(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_OVEN.get());
        this.kitchenOven(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_OVEN.get());
        this.kitchenOven(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_OVEN.get());
        this.kitchenOven(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_OVEN.get());
        this.kitchenOven(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_OVEN.get());
        this.kitchenOven(Blocks.PINK_CONCRETE, ModBlocks.PINK_OVEN.get());

        this.kitchenSink(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_SINK.get());
        this.kitchenSink(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_SINK.get());
        this.kitchenSink(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_SINK.get());
        this.kitchenSink(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_SINK.get());
        this.kitchenSink(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_SINK.get());
        this.kitchenSink(Blocks.RED_CONCRETE, ModBlocks.RED_SINK.get());
        this.kitchenSink(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_SINK.get());
        this.kitchenSink(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_SINK.get());
        this.kitchenSink(Blocks.LIME_CONCRETE, ModBlocks.LIME_SINK.get());
        this.kitchenSink(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_SINK.get());
        this.kitchenSink(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_SINK.get());
        this.kitchenSink(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_SINK.get());
        this.kitchenSink(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_SINK.get());
        this.kitchenSink(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_SINK.get());
        this.kitchenSink(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_SINK.get());
        this.kitchenSink(Blocks.PINK_CONCRETE, ModBlocks.PINK_SINK.get());



        this.cuttingBoard(Blocks.OAK_PLANKS, ModBlocks.OAK_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CUTTING_BOARD.get());
        this.cuttingBoard(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_CUTTING_BOARD.get());

        this.jar(Blocks.OAK_PLANKS, ModBlocks.OAK_JAR.get());
        this.jar(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_JAR.get());
        this.jar(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_JAR.get());
        this.jar(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_JAR.get());
        this.jar(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_JAR.get());
        this.jar(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_JAR.get());
        this.jar(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_JAR.get());
        this.jar(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_JAR.get());
        this.jar(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_JAR.get());
        this.jar(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_JAR.get());
        this.jar(Blocks.WARPED_PLANKS, ModBlocks.WARPED_JAR.get());
        this.jar(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_JAR.get());

        this.table(Blocks.OAK_PLANKS, ModBlocks.OAK_TABLE.get());
        this.table(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_TABLE.get());
        this.table(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_TABLE.get());
        this.table(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_TABLE.get());
        this.table(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_TABLE.get());
        this.table(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_TABLE.get());
        this.table(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_TABLE.get());
        this.table(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_TABLE.get());
        this.table(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_TABLE.get());
        this.table(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_TABLE.get());
        this.table(Blocks.WARPED_PLANKS, ModBlocks.WARPED_TABLE.get());
        this.table(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_TABLE.get());

        this.chair(Blocks.OAK_PLANKS, ModBlocks.OAK_CHAIR.get());
        this.chair(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CHAIR.get());
        this.chair(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CHAIR.get());
        this.chair(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CHAIR.get());
        this.chair(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CHAIR.get());
        this.chair(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CHAIR.get());
        this.chair(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CHAIR.get());
        this.chair(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CHAIR.get());
        this.chair(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CHAIR.get());
        this.chair(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CHAIR.get());
        this.chair(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CHAIR.get());
        this.chair(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_CHAIR.get());

        this.coffeeTable(Blocks.OAK_PLANKS, ModBlocks.OAK_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.WARPED_PLANKS, ModBlocks.WARPED_COFFEE_TABLE.get());
        this.coffeeTable(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_COFFEE_TABLE.get());

        this.desk(Blocks.OAK_PLANKS, ModBlocks.OAK_DESK.get());
        this.desk(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_DESK.get());
        this.desk(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_DESK.get());
        this.desk(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_DESK.get());
        this.desk(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_DESK.get());
        this.desk(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_DESK.get());
        this.desk(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_DESK.get());
        this.desk(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_DESK.get());
        this.desk(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_DESK.get());
        this.desk(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_DESK.get());
        this.desk(Blocks.WARPED_PLANKS, ModBlocks.WARPED_DESK.get());
        this.desk(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_DESK.get());

        this.deskCabinet(Blocks.OAK_PLANKS, ModBlocks.OAK_DESK_CABINET.get());
        this.deskCabinet(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_DESK_CABINET.get());
        this.deskCabinet(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_DESK_CABINET.get());
        this.deskCabinet(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_DESK_CABINET.get());
        this.deskCabinet(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_DESK_CABINET.get());
        this.deskCabinet(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_DESK_CABINET.get());
        this.deskCabinet(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_DESK_CABINET.get());
        this.deskCabinet(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_DESK_CABINET.get());
        this.deskCabinet(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_DESK_CABINET.get());
        this.deskCabinet(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_DESK_CABINET.get());
        this.deskCabinet(Blocks.WARPED_PLANKS, ModBlocks.WARPED_DESK_CABINET.get());
        this.deskCabinet(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_DESK_CABINET.get());

        this.lamp(Blocks.WHITE_WOOL, ModBlocks.WHITE_LAMP.get());
        this.lamp(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GRAY_LAMP.get());
        this.lamp(Blocks.GRAY_WOOL, ModBlocks.GRAY_LAMP.get());
        this.lamp(Blocks.BLACK_WOOL, ModBlocks.BLACK_LAMP.get());
        this.lamp(Blocks.BROWN_WOOL, ModBlocks.BROWN_LAMP.get());
        this.lamp(Blocks.RED_WOOL, ModBlocks.RED_LAMP.get());
        this.lamp(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_LAMP.get());
        this.lamp(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_LAMP.get());
        this.lamp(Blocks.LIME_WOOL, ModBlocks.LIME_LAMP.get());
        this.lamp(Blocks.GREEN_WOOL, ModBlocks.GREEN_LAMP.get());
        this.lamp(Blocks.CYAN_WOOL, ModBlocks.CYAN_LAMP.get());
        this.lamp(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_LAMP.get());
        this.lamp(Blocks.BLUE_WOOL, ModBlocks.BLUE_LAMP.get());
        this.lamp(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_LAMP.get());
        this.lamp(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_LAMP.get());
        this.lamp(Blocks.PINK_WOOL, ModBlocks.PINK_LAMP.get());

        this.sofa(Blocks.WHITE_WOOL, ModBlocks.WHITE_SOFA.get());
        this.sofa(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GREY_SOFA.get());
        this.sofa(Blocks.GRAY_WOOL, ModBlocks.GREY_SOFA.get());
        this.sofa(Blocks.BLACK_WOOL, ModBlocks.BLACK_SOFA.get());
        this.sofa(Blocks.BROWN_WOOL, ModBlocks.BROWN_SOFA.get());
        this.sofa(Blocks.RED_WOOL, ModBlocks.RED_SOFA.get());
        this.sofa(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_SOFA.get());
        this.sofa(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_SOFA.get());
        this.sofa(Blocks.LIME_WOOL, ModBlocks.LIME_SOFA.get());
        this.sofa(Blocks.GREEN_WOOL, ModBlocks.GREEN_SOFA.get());
        this.sofa(Blocks.CYAN_WOOL, ModBlocks.CYAN_SOFA.get());
        this.sofa(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_SOFA.get());
        this.sofa(Blocks.BLUE_WOOL, ModBlocks.BLUE_SOFA.get());
        this.sofa(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_SOFA.get());
        this.sofa(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_SOFA.get());
        this.sofa(Blocks.PINK_WOOL, ModBlocks.PINK_SOFA.get());

        this.stool(Blocks.WHITE_WOOL, ModBlocks.WHITE_STOOL.get());
        this.stool(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GREY_STOOL.get());
        this.stool(Blocks.GRAY_WOOL, ModBlocks.GREY_STOOL.get());
        this.stool(Blocks.BLACK_WOOL, ModBlocks.BLACK_STOOL.get());
        this.stool(Blocks.BROWN_WOOL, ModBlocks.BROWN_STOOL.get());
        this.stool(Blocks.RED_WOOL, ModBlocks.RED_STOOL.get());
        this.stool(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_STOOL.get());
        this.stool(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_STOOL.get());
        this.stool(Blocks.LIME_WOOL, ModBlocks.LIME_STOOL.get());
        this.stool(Blocks.GREEN_WOOL, ModBlocks.GREEN_STOOL.get());
        this.stool(Blocks.CYAN_WOOL, ModBlocks.CYAN_STOOL.get());
        this.stool(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_STOOL.get());
        this.stool(Blocks.BLUE_WOOL, ModBlocks.BLUE_STOOL.get());
        this.stool(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_STOOL.get());
        this.stool(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_STOOL.get());
        this.stool(Blocks.PINK_WOOL, ModBlocks.PINK_STOOL.get());

        this.digitalClock(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.RED_CONCRETE, ModBlocks.RED_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.LIME_CONCRETE, ModBlocks.LIME_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_DIGITAL_CLOCK.get());
        this.digitalClock(Blocks.PINK_CONCRETE, ModBlocks.PINK_DIGITAL_CLOCK.get());

        this.woodenClock(Blocks.OAK_PLANKS, ModBlocks.OAK_CLOCK.get());
        this.woodenClock(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CLOCK.get());
        this.woodenClock(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CLOCK.get());
        this.woodenClock(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CLOCK.get());
        this.woodenClock(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CLOCK.get());
        this.woodenClock(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CLOCK.get());
        this.woodenClock(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CLOCK.get());
        this.woodenClock(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CLOCK.get());
        this.woodenClock(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CLOCK.get());
        this.woodenClock(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CLOCK.get());
        this.woodenClock(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CLOCK.get());
        this.woodenClock(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_CLOCK.get());

        this.bedside(Blocks.OAK_PLANKS, ModBlocks.OAK_BEDSIDE.get());
        this.bedside(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_BEDSIDE.get());
        this.bedside(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_BEDSIDE.get());
        this.bedside(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_BEDSIDE.get());
        this.bedside(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_BEDSIDE.get());
        this.bedside(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_BEDSIDE.get());
        this.bedside(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_BEDSIDE.get());
        this.bedside(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_BEDSIDE.get());
        this.bedside(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_BEDSIDE.get());
        this.bedside(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_BEDSIDE.get());
        this.bedside(Blocks.WARPED_PLANKS, ModBlocks.WARPED_BEDSIDE.get());
        this.bedside(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_BEDSIDE.get());

        this.toilet(Blocks.OAK_PLANKS, ModBlocks.OAK_TOILET.get());
        this.toilet(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_TOILET.get());
        this.toilet(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_TOILET.get());
        this.toilet(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_TOILET.get());
        this.toilet(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_TOILET.get());
        this.toilet(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_TOILET.get());
        this.toilet(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_TOILET.get());
        this.toilet(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_TOILET.get());
        this.toilet(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_TOILET.get());
        this.toilet(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_TOILET.get());
        this.toilet(Blocks.WARPED_PLANKS, ModBlocks.WARPED_TOILET.get());
        this.toilet(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_TOILET.get());

        this.basin(Blocks.OAK_PLANKS, ModBlocks.OAK_BASIN.get());
        this.basin(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_BASIN.get());
        this.basin(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_BASIN.get());
        this.basin(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_BASIN.get());
        this.basin(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_BASIN.get());
        this.basin(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_BASIN.get());
        this.basin(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_BASIN.get());
        this.basin(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_BASIN.get());
        this.basin(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_BASIN.get());
        this.basin(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_BASIN.get());
        this.basin(Blocks.WARPED_PLANKS, ModBlocks.WARPED_BASIN.get());
        this.basin(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_BASIN.get());

        this.bath(Blocks.OAK_PLANKS, ModBlocks.OAK_BATH.get());
        this.bath(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_BATH.get());
        this.bath(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_BATH.get());
        this.bath(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_BATH.get());
        this.bath(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_BATH.get());
        this.bath(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_BATH.get());
        this.bath(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_BATH.get());
        this.bath(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_BATH.get());
        this.bath(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_BATH.get());
        this.bath(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_BATH.get());
        this.bath(Blocks.WARPED_PLANKS, ModBlocks.WARPED_BATH.get());
        this.bath(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_BATH.get());

        this.shelf(Blocks.OAK_PLANKS, ModBlocks.OAK_SHELF.get());
        this.shelf(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_SHELF.get());
        this.shelf(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_SHELF.get());
        this.shelf(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_SHELF.get());
        this.shelf(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_SHELF.get());
        this.shelf(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_SHELF.get());
        this.shelf(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_SHELF.get());
        this.shelf(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_SHELF.get());
        this.shelf(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_SHELF.get());
        this.shelf(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_SHELF.get());
        this.shelf(Blocks.WARPED_PLANKS, ModBlocks.WARPED_SHELF.get());
        this.shelf(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_SHELF.get());

        this.bench(Blocks.OAK_PLANKS, ModBlocks.OAK_PARK_BENCH.get());
        this.bench(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_PARK_BENCH.get());
        this.bench(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_PARK_BENCH.get());
        this.bench(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_PARK_BENCH.get());
        this.bench(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_PARK_BENCH.get());
        this.bench(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_PARK_BENCH.get());
        this.bench(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_PARK_BENCH.get());
        this.bench(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_PARK_BENCH.get());
        this.bench(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_PARK_BENCH.get());
        this.bench(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_PARK_BENCH.get());
        this.bench(Blocks.WARPED_PLANKS, ModBlocks.WARPED_PARK_BENCH.get());
        this.bench(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_PARK_BENCH.get());

        this.stonePath(Blocks.COBBLESTONE, ModBlocks.STONE_PATH.get());
        this.stonePath(Blocks.ANDESITE, ModBlocks.ANDESITE_PATH.get());
        this.stonePath(Blocks.DIORITE, ModBlocks.DIORITE_PATH.get());
        this.stonePath(Blocks.GRANITE, ModBlocks.GRANITE_PATH.get());
        this.stonePath(Blocks.DEEPSLATE, ModBlocks.DEEPSLATE_PATH.get());


        this.crate(Blocks.OAK_PLANKS, ModBlocks.OAK_CRATE.get());
        this.crate(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CRATE.get());
        this.crate(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CRATE.get());
        this.crate(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CRATE.get());
        this.crate(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CRATE.get());
        this.crate(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CRATE.get());
        this.crate(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CRATE.get());
        this.crate(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CRATE.get());
        this.crate(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CRATE.get());
        this.crate(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CRATE.get());
        this.crate(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CRATE.get());
        this.crate(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_CRATE.get());

        this.glassTecque(Blocks.OAK_PLANKS, ModBlocks.OAK_GLASS_TECQUE.get());
        this.glassTecque(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_GLASS_TECQUE.get());
        this.glassTecque(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_GLASS_TECQUE.get());
        this.glassTecque(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_GLASS_TECQUE.get());
        this.glassTecque(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_GLASS_TECQUE.get());
        this.glassTecque(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_GLASS_TECQUE.get());
        this.glassTecque(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_GLASS_TECQUE.get());
        this.glassTecque(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_GLASS_TECQUE.get());
        this.glassTecque(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_GLASS_TECQUE.get());
        this.glassTecque(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_GLASS_TECQUE.get());
        this.glassTecque(Blocks.WARPED_PLANKS, ModBlocks.WARPED_GLASS_TECQUE.get());
        this.glassTecque(Blocks.PALE_OAK_PLANKS, ModBlocks.PALE_OAK_GLASS_TECQUE.get());

        this.cuttingBoardRecipe(Items.BREAD, ModItems.SLICED_BREAD.get(), 2);
        this.toasterRecipe(ModItems.SLICED_BREAD.get(), ModItems.COOKED_SLICED_BREAD.get(),200);
    }


    public void kitchenCounter(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenDrawer(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenOven(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenSink(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenCabinet(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void cuttingBoard(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void jar(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void table(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,4)
                .unlockedBy("has_item", has(wood))
                .save(output);

    }

    public void chair(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,4)
                .requires(Items.STICK,2)
                .unlockedBy("has_item", has(wood))
                .save(output);

    }

    public void coffeeTable(Block wood, Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.GLASS,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void desk(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void deskCabinet(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void lamp(Block wool,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wool,3)
                .requires(Items.GLOWSTONE_DUST,2)
                .requires(Items.STICK, 2)
                .unlockedBy("has_item", has(wool))
                .save(output);
    }

    public void sofa(Block wool,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wool,4)
                .requires(Items.STICK, 2)
                .unlockedBy("has_item", has(wool))
                .save(output);
    }

    public void stool(Block wool,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wool,2)
                .requires(Items.STICK, 4)
                .unlockedBy("has_item", has(wool))
                .save(output);
    }

    public void bedside(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.CHEST, 1)
                .requires(Items.IRON_INGOT, 1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void digitalClock(Block concrete,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(concrete,2)
                .requires(Items.CLOCK,1)
                .unlockedBy("has_item", has(concrete))
                .save(output);
    }

    public void woodenClock(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,2)
                .requires(Items.CLOCK,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void basin(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,2)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.BUCKET, 1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void toilet(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,1)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET, 1)
                .requires(Items.IRON_INGOT, 2)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void bath(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,2)
                .requires(Items.QUARTZ_BLOCK,5)
                .requires(Items.BUCKET, 1)
                .requires(Items.IRON_INGOT, 5)
                .requires(Items.COPPER_INGOT, 2)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void shelf(Block wood,  Block result) {
        shaped(RecipeCategory.DECORATIONS, result)
                .pattern("###")
                .pattern("B B")
                .define('B', Items.STICK)
                .define('#', wood.asItem())
                .unlockedBy("has_item", has(wood))
                .save(output);

    }

    public void bench(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.IRON_CHAIN, 2)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void stonePath(Block stone, Block result){
        WorkbenchRecipeBuilder.crafting(result)
                .requires(stone,1)
                .unlockedBy("has_item", has(stone))
                .save(output);
    }

    public void crate(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,4)
                .requires(Items.CHEST,2)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }


    public void glassTecque(Block wood,  Block result) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,1)
                .requires(Items.GLASS_PANE,4)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }



    public void cuttingBoardRecipe(ItemLike input, ItemLike result, int count) {
        String baseName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();
        String resultName = BuiltInRegistries.ITEM.getKey(result.asItem()).getPath();
        SingleItemRecipeBuilder builder = new SingleItemRecipeBuilder(RecipeCategory.MISC, CuttingBoardRecipe::new, Ingredient.of(input), result, count);
        ResourceKey<Recipe<?>> key = ResourceKey.create(Registries.RECIPE, Constants.id("slicing/" + resultName + "_from_" + baseName));
        builder.unlockedBy("has_" + baseName, has(input)).save(output, key);

    }

    public void toasterRecipe(ItemLike input, ItemLike result, int cookTime) {
        String baseName = BuiltInRegistries.ITEM.getKey(input.asItem()).getPath();
        ResourceKey<Recipe<?>> key = ResourceKey.create(Registries.RECIPE, Constants.id("toasting/" + baseName));
        ToasterRecipeBuilder.toasting(Ingredient.of(input), result, 1, cookTime)
                .unlockedBy("has_" + baseName, has(input))
                .save(output, key);
    }

    public static final class Runner extends RecipeProvider.Runner
    {
        public Runner(PackOutput output, CompletableFuture<HolderLookup.Provider> completableFuture)
        {
            super(output, completableFuture);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput output)
        {
            return new CommonRecipeProvider(provider, output);
        }

        @Override
        public String getName()
        {
            return "BetterDeco Recipes";
        }
    }

}
