package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.tier1234.better_deco.datagen.custom.WorkbenchRecipeBuilder;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

import java.util.concurrent.CompletableFuture;

public class CommonRecipeProvider extends RecipeProvider {
    public CommonRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.STONE_SLAB.asItem())
                .define('X', Blocks.SMOOTH_STONE.asItem())
                .unlockedBy("has_stone_slab", has(Blocks.STONE_SLAB))
                .unlockedBy("has_smooth_stone", has(Blocks.SMOOTH_STONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.STONE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.STONE_SLAB.asItem())
                .define('X', Blocks.STONE.asItem())
                .unlockedBy("has_stone_slab", has(Blocks.STONE_SLAB))
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GRANITE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.POLISHED_GRANITE_SLAB.asItem())
                .define('X', Blocks.GRANITE.asItem())
                .unlockedBy("has_polished_granite_slab", has(Blocks.POLISHED_GRANITE_SLAB))
                .unlockedBy("has_granite", has(Blocks.GRANITE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DIORITE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.POLISHED_DIORITE_SLAB.asItem())
                .define('X', Blocks.DIORITE.asItem())
                .unlockedBy("has_polished_diorite_slab", has(Blocks.POLISHED_DIORITE_SLAB))
                .unlockedBy("has_diorite", has(Blocks.DIORITE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.DEEPSLATE_BRICK_SLAB.asItem())
                .define('X', Blocks.POLISHED_DEEPSLATE.asItem())
                .unlockedBy("has_deepslate_slab", has(Blocks.DEEPSLATE_BRICK_SLAB))
                .unlockedBy("has_ddeepslate_polished", has(Blocks.POLISHED_DEEPSLATE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_TILE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.DEEPSLATE_TILE_SLAB.asItem())
                .define('X', Blocks.POLISHED_DEEPSLATE.asItem())
                .unlockedBy("has_deepslate_tile_slab", has(Blocks.DEEPSLATE_TILE_SLAB))
                .unlockedBy("has_deepslate_polished", has(Blocks.POLISHED_DEEPSLATE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.POLISHED_BLACKSTONE_BRICK_SLAB.asItem())
                .define('X', Blocks.BLACKSTONE.asItem())
                .unlockedBy("has_polished_blackstone_slab", has(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB))
                .unlockedBy("has_blackstone", has(Blocks.BLACKSTONE))
                .save(recipeOutput);

        //Tecque
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STONE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.STONE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_stone_slab", has(Blocks.STONE_SLAB))
                .save(recipeOutput);

        //Wood Tecque
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OAK_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.OAK_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_oak_slab", has(Blocks.OAK_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SPRUCE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.SPRUCE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_spruce_slab", has(Blocks.SPRUCE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BIRCH_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.BIRCH_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_birch_slab", has(Blocks.BIRCH_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.JUNGLE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.JUNGLE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_jungle_slab", has(Blocks.JUNGLE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ACACIA_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.ACACIA_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_acacia_slab", has(Blocks.ACACIA_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DARK_OAK_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.DARK_OAK_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_dark_oak_slab", has(Blocks.DARK_OAK_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MANGROVE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.MANGROVE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_mangrove_slab", has(Blocks.MANGROVE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHERRY_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.CHERRY_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_cherry_slab", has(Blocks.CHERRY_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BAMBOO_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.BAMBOO_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_bamboo_slab", has(Blocks.BAMBOO_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRIMSON_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.CRIMSON_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_crimson_slab", has(Blocks.CRIMSON_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WARPED_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.WARPED_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("has_glass", has(Blocks.GLASS))
                .unlockedBy("has_warped_slab", has(Blocks.WARPED_SLAB))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WORKBENCH.get())
                .pattern("PPP")
                .pattern("ICI")
                .pattern("I I")
                .define('P', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .define('C', Blocks.CRAFTING_TABLE)
                .unlockedBy("has_crafting_table", has(Blocks.CRAFTING_TABLE))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.KITCHEN_KNIFE.get())
                .pattern("   ")
                .pattern(" AB")
                .pattern(" CA")
                .define('A', Items.STRING)
                .define('B', Items.IRON_INGOT)
                .define('C', Items.STICK)
                .unlockedBy("has_iron", has(Items.IRON_INGOT))
                .unlockedBy("has_stick", has(Items.STICK))
                .unlockedBy("has_string", has(Items.STRING))
                .save(recipeOutput);



        WorkbenchRecipeBuilder.crafting(ModBlocks.FRIDGE_LIGHT.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.WHITE_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(recipeOutput);

        WorkbenchRecipeBuilder.crafting(ModBlocks.FRIDGE_DARK.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.GRAY_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(recipeOutput);


        WorkbenchRecipeBuilder.crafting(ModBlocks.LIGHT_MICROWAVE.get(), 1)
                .requires(Items.WHITE_CONCRETE,3)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .requires(Items.GLASS_PANE, 1)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);


        WorkbenchRecipeBuilder.crafting(ModBlocks.DARK_MICROWAVE.get(), 1)
                .requires(Items.GRAY_CONCRETE,3)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .requires(Items.GLASS_PANE, 1)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);


        this.kitchenCounter(Blocks.OAK_PLANKS, ModBlocks.OAK_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.WARPED_PLANKS, ModBlocks.WARPED_KITCHEN_COUNTER.get(), recipeOutput);

        this.kitchenDrawer(Blocks.OAK_PLANKS, ModBlocks.OAK_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.WARPED_PLANKS, ModBlocks.WARPED_KITCHEN_DRAWER.get(), recipeOutput);

        this.kitchenCabinet(Blocks.OAK_PLANKS, ModBlocks.OAK_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CABINET.get(), recipeOutput);
        this.kitchenCabinet(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CABINET.get(), recipeOutput);

        this.kitchenOven(Blocks.OAK_PLANKS, ModBlocks.OAK_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.WARPED_PLANKS, ModBlocks.WARPED_OVEN.get(), recipeOutput);

        this.kitchenSink(Blocks.OAK_PLANKS, ModBlocks.OAK_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.WARPED_PLANKS, ModBlocks.WARPED_SINK.get(), recipeOutput);

        this.kitchenCounter(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.RED_CONCRETE, ModBlocks.RED_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.LIME_CONCRETE, ModBlocks.LIME_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_KITCHEN_COUNTER.get(), recipeOutput);
        this.kitchenCounter(Blocks.PINK_CONCRETE, ModBlocks.PINK_KITCHEN_COUNTER.get(), recipeOutput);

        this.kitchenDrawer(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.RED_CONCRETE, ModBlocks.RED_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.LIME_CONCRETE, ModBlocks.LIME_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_KITCHEN_DRAWER.get(), recipeOutput);
        this.kitchenDrawer(Blocks.PINK_CONCRETE, ModBlocks.PINK_KITCHEN_DRAWER.get(), recipeOutput);

        this.kitchenOven(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.RED_CONCRETE, ModBlocks.RED_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.LIME_CONCRETE, ModBlocks.LIME_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_OVEN.get(), recipeOutput);
        this.kitchenOven(Blocks.PINK_CONCRETE, ModBlocks.PINK_OVEN.get(), recipeOutput);

        this.kitchenSink(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.RED_CONCRETE, ModBlocks.RED_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.LIME_CONCRETE, ModBlocks.LIME_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_SINK.get(), recipeOutput);
        this.kitchenSink(Blocks.PINK_CONCRETE, ModBlocks.PINK_SINK.get(), recipeOutput);



        this.cuttingBoard(Blocks.OAK_PLANKS, ModBlocks.OAK_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CUTTING_BOARD.get(), recipeOutput);
        this.cuttingBoard(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CUTTING_BOARD.get(), recipeOutput);

        this.jar(Blocks.OAK_PLANKS, ModBlocks.OAK_JAR.get(), recipeOutput);
        this.jar(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_JAR.get(), recipeOutput);
        this.jar(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_JAR.get(), recipeOutput);
        this.jar(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_JAR.get(), recipeOutput);
        this.jar(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_JAR.get(), recipeOutput);
        this.jar(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_JAR.get(), recipeOutput);
        this.jar(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_JAR.get(), recipeOutput);
        this.jar(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_JAR.get(), recipeOutput);
        this.jar(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_JAR.get(), recipeOutput);
        this.jar(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_JAR.get(), recipeOutput);
        this.jar(Blocks.WARPED_PLANKS, ModBlocks.WARPED_JAR.get(), recipeOutput);

        this.table(Blocks.OAK_PLANKS, ModBlocks.OAK_TABLE.get(), recipeOutput);
        this.table(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_TABLE.get(), recipeOutput);
        this.table(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_TABLE.get(), recipeOutput);
        this.table(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_TABLE.get(), recipeOutput);
        this.table(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_TABLE.get(), recipeOutput);
        this.table(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_TABLE.get(), recipeOutput);
        this.table(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_TABLE.get(), recipeOutput);
        this.table(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_TABLE.get(), recipeOutput);
        this.table(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_TABLE.get(), recipeOutput);
        this.table(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_TABLE.get(), recipeOutput);
        this.table(Blocks.WARPED_PLANKS, ModBlocks.WARPED_TABLE.get(), recipeOutput);

        this.chair(Blocks.OAK_PLANKS, ModBlocks.OAK_CHAIR.get(), recipeOutput);
        this.chair(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CHAIR.get(), recipeOutput);
        this.chair(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CHAIR.get(), recipeOutput);
        this.chair(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CHAIR.get(), recipeOutput);
        this.chair(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CHAIR.get(), recipeOutput);
        this.chair(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CHAIR.get(), recipeOutput);
        this.chair(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CHAIR.get(), recipeOutput);
        this.chair(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CHAIR.get(), recipeOutput);
        this.chair(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CHAIR.get(), recipeOutput);
        this.chair(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CHAIR.get(), recipeOutput);
        this.chair(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CHAIR.get(), recipeOutput);

        this.coffeeTable(Blocks.OAK_PLANKS, ModBlocks.OAK_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_COFFEE_TABLE.get(), recipeOutput);
        this.coffeeTable(Blocks.WARPED_PLANKS, ModBlocks.WARPED_COFFEE_TABLE.get(), recipeOutput);

        this.desk(Blocks.OAK_PLANKS, ModBlocks.OAK_DESK.get(), recipeOutput);
        this.desk(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_DESK.get(), recipeOutput);
        this.desk(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_DESK.get(), recipeOutput);
        this.desk(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_DESK.get(), recipeOutput);
        this.desk(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_DESK.get(), recipeOutput);
        this.desk(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_DESK.get(), recipeOutput);
        this.desk(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_DESK.get(), recipeOutput);
        this.desk(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_DESK.get(), recipeOutput);
        this.desk(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_DESK.get(), recipeOutput);
        this.desk(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_DESK.get(), recipeOutput);
        this.desk(Blocks.WARPED_PLANKS, ModBlocks.WARPED_DESK.get(), recipeOutput);

        this.deskCabinet(Blocks.OAK_PLANKS, ModBlocks.OAK_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_DESK_CABINET.get(), recipeOutput);
        this.deskCabinet(Blocks.WARPED_PLANKS, ModBlocks.WARPED_DESK_CABINET.get(), recipeOutput);

        this.lamp(Blocks.WHITE_WOOL, ModBlocks.WHITE_LAMP.get(), recipeOutput);
        this.lamp(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GRAY_LAMP.get(), recipeOutput);
        this.lamp(Blocks.GRAY_WOOL, ModBlocks.GRAY_LAMP.get(), recipeOutput);
        this.lamp(Blocks.BLACK_WOOL, ModBlocks.BLACK_LAMP.get(), recipeOutput);
        this.lamp(Blocks.BROWN_WOOL, ModBlocks.BROWN_LAMP.get(), recipeOutput);
        this.lamp(Blocks.RED_WOOL, ModBlocks.RED_LAMP.get(), recipeOutput);
        this.lamp(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_LAMP.get(), recipeOutput);
        this.lamp(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_LAMP.get(), recipeOutput);
        this.lamp(Blocks.LIME_WOOL, ModBlocks.LIME_LAMP.get(), recipeOutput);
        this.lamp(Blocks.GREEN_WOOL, ModBlocks.GREEN_LAMP.get(), recipeOutput);
        this.lamp(Blocks.CYAN_WOOL, ModBlocks.CYAN_LAMP.get(), recipeOutput);
        this.lamp(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_LAMP.get(), recipeOutput);
        this.lamp(Blocks.BLUE_WOOL, ModBlocks.BLUE_LAMP.get(), recipeOutput);
        this.lamp(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_LAMP.get(), recipeOutput);
        this.lamp(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_LAMP.get(), recipeOutput);
        this.lamp(Blocks.PINK_WOOL, ModBlocks.PINK_LAMP.get(), recipeOutput);

        this.sofa(Blocks.WHITE_WOOL, ModBlocks.WHITE_SOFA.get(), recipeOutput);
        this.sofa(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GREY_SOFA.get(), recipeOutput);
        this.sofa(Blocks.GRAY_WOOL, ModBlocks.GREY_SOFA.get(), recipeOutput);
        this.sofa(Blocks.BLACK_WOOL, ModBlocks.BLACK_SOFA.get(), recipeOutput);
        this.sofa(Blocks.BROWN_WOOL, ModBlocks.BROWN_SOFA.get(), recipeOutput);
        this.sofa(Blocks.RED_WOOL, ModBlocks.RED_SOFA.get(), recipeOutput);
        this.sofa(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_SOFA.get(), recipeOutput);
        this.sofa(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_SOFA.get(), recipeOutput);
        this.sofa(Blocks.LIME_WOOL, ModBlocks.LIME_SOFA.get(), recipeOutput);
        this.sofa(Blocks.GREEN_WOOL, ModBlocks.GREEN_SOFA.get(), recipeOutput);
        this.sofa(Blocks.CYAN_WOOL, ModBlocks.CYAN_SOFA.get(), recipeOutput);
        this.sofa(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_SOFA.get(), recipeOutput);
        this.sofa(Blocks.BLUE_WOOL, ModBlocks.BLUE_SOFA.get(), recipeOutput);
        this.sofa(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_SOFA.get(), recipeOutput);
        this.sofa(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_SOFA.get(), recipeOutput);
        this.sofa(Blocks.PINK_WOOL, ModBlocks.PINK_SOFA.get(), recipeOutput);

        this.stool(Blocks.WHITE_WOOL, ModBlocks.WHITE_STOOL.get(), recipeOutput);
        this.stool(Blocks.LIGHT_GRAY_WOOL, ModBlocks.LIGHT_GREY_STOOL.get(), recipeOutput);
        this.stool(Blocks.GRAY_WOOL, ModBlocks.GREY_STOOL.get(), recipeOutput);
        this.stool(Blocks.BLACK_WOOL, ModBlocks.BLACK_STOOL.get(), recipeOutput);
        this.stool(Blocks.BROWN_WOOL, ModBlocks.BROWN_STOOL.get(), recipeOutput);
        this.stool(Blocks.RED_WOOL, ModBlocks.RED_STOOL.get(), recipeOutput);
        this.stool(Blocks.YELLOW_WOOL, ModBlocks.YELLOW_STOOL.get(), recipeOutput);
        this.stool(Blocks.ORANGE_WOOL, ModBlocks.ORANGE_STOOL.get(), recipeOutput);
        this.stool(Blocks.LIME_WOOL, ModBlocks.LIME_STOOL.get(), recipeOutput);
        this.stool(Blocks.GREEN_WOOL, ModBlocks.GREEN_STOOL.get(), recipeOutput);
        this.stool(Blocks.CYAN_WOOL, ModBlocks.CYAN_STOOL.get(), recipeOutput);
        this.stool(Blocks.LIGHT_BLUE_WOOL, ModBlocks.LIGHT_BLUE_STOOL.get(), recipeOutput);
        this.stool(Blocks.BLUE_WOOL, ModBlocks.BLUE_STOOL.get(), recipeOutput);
        this.stool(Blocks.PURPLE_WOOL, ModBlocks.PURPLE_STOOL.get(), recipeOutput);
        this.stool(Blocks.MAGENTA_WOOL, ModBlocks.MAGENTA_STOOL.get(), recipeOutput);
        this.stool(Blocks.PINK_WOOL, ModBlocks.PINK_STOOL.get(), recipeOutput);

        this.digitalClock(Blocks.WHITE_CONCRETE, ModBlocks.WHITE_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.LIGHT_GRAY_CONCRETE, ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.GRAY_CONCRETE, ModBlocks.GRAY_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.BLACK_CONCRETE, ModBlocks.BLACK_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.BROWN_CONCRETE, ModBlocks.BROWN_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.RED_CONCRETE, ModBlocks.RED_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.YELLOW_CONCRETE, ModBlocks.YELLOW_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.ORANGE_CONCRETE, ModBlocks.ORANGE_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.LIME_CONCRETE, ModBlocks.LIME_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.GREEN_CONCRETE, ModBlocks.GREEN_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.CYAN_CONCRETE, ModBlocks.CYAN_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.LIGHT_BLUE_CONCRETE, ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.BLUE_CONCRETE, ModBlocks.BLUE_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.PURPLE_CONCRETE, ModBlocks.PURPLE_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.MAGENTA_CONCRETE, ModBlocks.MAGENTA_DIGITAL_CLOCK.get(), recipeOutput);
        this.digitalClock(Blocks.PINK_CONCRETE, ModBlocks.PINK_DIGITAL_CLOCK.get(), recipeOutput);

        this.woodenClock(Blocks.OAK_PLANKS, ModBlocks.OAK_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_CLOCK.get(), recipeOutput);
        this.woodenClock(Blocks.WARPED_PLANKS, ModBlocks.WARPED_CLOCK.get(), recipeOutput);


        this.bedside(Blocks.OAK_PLANKS, ModBlocks.OAK_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.SPRUCE_PLANKS, ModBlocks.SPRUCE_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.BIRCH_PLANKS, ModBlocks.BIRCH_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.JUNGLE_PLANKS, ModBlocks.JUNGLE_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.ACACIA_PLANKS, ModBlocks.ACACIA_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.DARK_OAK_PLANKS, ModBlocks.DARK_OAK_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.MANGROVE_PLANKS, ModBlocks.MANGROVE_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.CHERRY_PLANKS, ModBlocks.CHERRY_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.BAMBOO_PLANKS, ModBlocks.BAMBOO_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.CRIMSON_PLANKS, ModBlocks.CRIMSON_BEDSIDE.get(), recipeOutput);
        this.bedside(Blocks.WARPED_PLANKS, ModBlocks.WARPED_BEDSIDE.get(), recipeOutput);



    }

    public void kitchenCounter(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenDrawer(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenOven(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenSink(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void kitchenCabinet(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void cuttingBoard(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood, 1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void jar(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void table(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,4)
                .unlockedBy("has_item", has(wood))
                .save(output);

    }

    public void chair(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,4)
                .requires(Items.STICK,2)
                .unlockedBy("has_item", has(wood))
                .save(output);

    }

    public void coffeeTable(Block wood, Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.GLASS,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void desk(Block wood,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void deskCabinet(Block wood,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void lamp(Block wool,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wool,3)
                .requires(Items.GLOWSTONE_DUST,2)
                .requires(Items.STICK, 2)
                .unlockedBy("has_item", has(wool))
                .save(output);
    }

    public void sofa(Block wool,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wool,4)
                .requires(Items.STICK, 2)
                .unlockedBy("has_item", has(wool))
                .save(output);
    }

    public void stool(Block wool,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wool,2)
                .requires(Items.STICK, 4)
                .unlockedBy("has_item", has(wool))
                .save(output);
    }

    public void bedside(Block wood,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,3)
                .requires(Items.CHEST, 1)
                .requires(Items.IRON_INGOT, 1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }

    public void digitalClock(Block concrete,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(concrete,2)
                .requires(Items.CLOCK,1)
                .unlockedBy("has_item", has(concrete))
                .save(output);
    }
    public void woodenClock(Block wood,  Block result, RecipeOutput output) {
        WorkbenchRecipeBuilder.crafting(result)
                .requires(wood,2)
                .requires(Items.CLOCK,1)
                .unlockedBy("has_item", has(wood))
                .save(output);
    }


}
