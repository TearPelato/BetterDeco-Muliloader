package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.tier1234.better_deco.datagen.custom.FurniCraftingRecipeBuilder;
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


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FURNI_WORKBENCH.get())
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














































        FurniCraftingRecipeBuilder.crafting(ModBlocks.FRIDGE_LIGHT.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.WHITE_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.FRIDGE_DARK.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.GRAY_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .unlockedBy("has_chest", has(Items.CHEST))
                .save(recipeOutput);


        FurniCraftingRecipeBuilder.crafting(ModBlocks.LIGHT_MICROWAVE.get(), 1)
                .requires(Items.WHITE_CONCRETE,3)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .requires(Items.GLASS_PANE, 1)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);


        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_MICROWAVE.get(), 1)
                .requires(Items.GRAY_CONCRETE,3)
                .requires(Items.IRON_INGOT, 3)
                .requires(Items.REDSTONE, 2)
                .requires(Items.GLASS_PANE, 1)
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(recipeOutput);



        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_KITCHEN_COUNTER.get(), 1)
                .requires(Items.OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_KITCHEN_DRAWER.get(), 1)
                .requires(Items.OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_OVEN.get(), 1)
                .requires(Items.OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_SINK.get(), 1)
                .requires(Items.OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_CABINET.get(), 1)
                .requires(Items.OAK_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_CUTTING_BOARD.get(), 1)
                .requires(Items.OAK_PLANKS,1)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_JAR.get(), 1)
                .requires(Items.OAK_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_oak_planks", has(Items.OAK_PLANKS))
                .save(recipeOutput);



        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(), 1)
                .requires(Items.SPRUCE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(), 1)
                .requires(Items.SPRUCE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_OVEN.get(), 1)
                .requires(Items.SPRUCE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_SINK.get(), 1)
                .requires(Items.SPRUCE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_CABINET.get(), 1)
                .requires(Items.SPRUCE_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_CUTTING_BOARD.get(), 1)
                .requires(Items.SPRUCE_PLANKS,1)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_JAR.get(), 1)
                .requires(Items.SPRUCE_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_spruce_planks", has(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_KITCHEN_COUNTER.get(), 1)
                .requires(Items.BIRCH_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_KITCHEN_DRAWER.get(), 1)
                .requires(Items.BIRCH_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_OVEN.get(), 1)
                .requires(Items.BIRCH_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_SINK.get(), 1)
                .requires(Items.BIRCH_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_CABINET.get(), 1)
                .requires(Items.BIRCH_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_CUTTING_BOARD.get(), 1)
                .requires(Items.BIRCH_PLANKS,1)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_JAR.get(), 1)
                .requires(Items.BIRCH_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_birch_planks", has(Items.BIRCH_PLANKS))
                .save(recipeOutput);


        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(), 1)
                .requires(Items.JUNGLE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(), 1)
                .requires(Items.JUNGLE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_OVEN.get(), 1)
                .requires(Items.JUNGLE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_SINK.get(), 1)
                .requires(Items.JUNGLE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_CABINET.get(), 1)
                .requires(Items.JUNGLE_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_CUTTING_BOARD.get(), 1)
                .requires(Items.JUNGLE_PLANKS,1)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_JAR.get(), 1)
                .requires(Items.JUNGLE_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_jungle_planks", has(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_KITCHEN_COUNTER.get(), 1)
                .requires(Items.ACACIA_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_KITCHEN_DRAWER.get(), 1)
                .requires(Items.ACACIA_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_OVEN.get(), 1)
                .requires(Items.ACACIA_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_SINK.get(), 1)
                .requires(Items.ACACIA_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_CABINET.get(), 1)
                .requires(Items.ACACIA_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_CUTTING_BOARD.get(), 1)
                .requires(Items.ACACIA_PLANKS,1)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_JAR.get(), 1)
                .requires(Items.ACACIA_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_acacia_planks", has(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_OVEN.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_SINK.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_CABINET.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_CUTTING_BOARD.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,1)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_JAR.get(), 1)
                .requires(Items.DARK_OAK_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_dark_oak_planks", has(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);


        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(), 1)
                .requires(Items.MANGROVE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(), 1)
                .requires(Items.MANGROVE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_OVEN.get(), 1)
                .requires(Items.MANGROVE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_SINK.get(), 1)
                .requires(Items.MANGROVE_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_CABINET.get(), 1)
                .requires(Items.MANGROVE_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_CUTTING_BOARD.get(), 1)
                .requires(Items.MANGROVE_PLANKS,1)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_JAR.get(), 1)
                .requires(Items.MANGROVE_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_mangrove_planks", has(Items.MANGROVE_PLANKS))
                .save(recipeOutput);


        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_KITCHEN_COUNTER.get(), 1)
                .requires(Items.CHERRY_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_KITCHEN_DRAWER.get(), 1)
                .requires(Items.CHERRY_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_OVEN.get(), 1)
                .requires(Items.CHERRY_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_SINK.get(), 1)
                .requires(Items.CHERRY_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_CABINET.get(), 1)
                .requires(Items.CHERRY_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_CUTTING_BOARD.get(), 1)
                .requires(Items.CHERRY_PLANKS,1)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_JAR.get(), 1)
                .requires(Items.CHERRY_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_cherry_planks", has(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(), 1)
                .requires(Items.BAMBOO_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_KITCHEN_DRAWER.get(), 1)
                .requires(Items.BAMBOO_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_OVEN.get(), 1)
                .requires(Items.BAMBOO_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_SINK.get(), 1)
                .requires(Items.BAMBOO_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_CABINET.get(), 1)
                .requires(Items.BAMBOO_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_CUTTING_BOARD.get(), 1)
                .requires(Items.BAMBOO_PLANKS,1)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_JAR.get(), 1)
                .requires(Items.BAMBOO_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_bamboo_planks", has(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(), 1)
                .requires(Items.CRIMSON_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(), 1)
                .requires(Items.CRIMSON_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_OVEN.get(), 1)
                .requires(Items.CRIMSON_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_SINK.get(), 1)
                .requires(Items.CRIMSON_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_CABINET.get(), 1)
                .requires(Items.CRIMSON_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_CUTTING_BOARD.get(), 1)
                .requires(Items.CRIMSON_PLANKS,1)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_JAR.get(), 1)
                .requires(Items.CRIMSON_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_crimson_planks", has(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_KITCHEN_COUNTER.get(), 1)
                .requires(Items.WARPED_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_KITCHEN_DRAWER.get(), 1)
                .requires(Items.WARPED_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.CHEST,1)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_OVEN.get(), 1)
                .requires(Items.WARPED_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.SMOKER,1)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_SINK.get(), 1)
                .requires(Items.WARPED_PLANKS,2)
                .requires(Items.QUARTZ_BLOCK,3)
                .requires(Items.BUCKET,1)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_CABINET.get(), 1)
                .requires(Items.WARPED_PLANKS,1)
                .requires(Items.QUARTZ_BLOCK,2)
                .requires(Items.CHEST,1)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .unlockedBy("has_quartz", has(Items.QUARTZ_BLOCK))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_CUTTING_BOARD.get(), 1)
                .requires(Items.WARPED_PLANKS,1)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_JAR.get(), 1)
                .requires(Items.WARPED_PLANKS,1)
                .requires(Items.GLASS_PANE,1)
                .unlockedBy("has_warped_planks", has(Items.WARPED_PLANKS))
                .save(recipeOutput);



















    }
}
