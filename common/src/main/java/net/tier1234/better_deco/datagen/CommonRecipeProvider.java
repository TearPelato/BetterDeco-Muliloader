package net.tier1234.better_deco.datagen;

import net.minecraft.advancements.Criterion;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.tier1234.better_deco.datagen.custom.FurniCraftingRecipeBuilder;
import net.tier1234.better_deco.init.ModBlocks;

import java.util.List;
import java.util.function.Function;

public class CommonRecipeProvider {
    private final RecipeOutput output;
    private final ConditionalModConsumer modLoadedConsumer;
    private final Function<ItemLike, Criterion<?>> hasItem;
    private final Function<TagKey<Item>, Criterion<?>> hasTag;

    public CommonRecipeProvider(RecipeOutput output, ConditionalModConsumer modLoadedConsumer, Function<ItemLike, Criterion<?>> hasItem, Function<TagKey<Item>, Criterion<?>> hasTag)
    {
        this.output = output;
        this.modLoadedConsumer = modLoadedConsumer;
        this.hasItem = hasItem;
        this.hasTag = hasTag;
    }

    public void generate(RecipeOutput recipeOutput) {
        List<ItemLike> PLANKS = List.of(Blocks.OAK_PLANKS,
                Blocks.SPRUCE_PLANKS, Blocks.BIRCH_PLANKS, Blocks.JUNGLE_PLANKS, Blocks.ACACIA_PLANKS, Blocks.DARK_OAK_PLANKS,
                Blocks.MANGROVE_PLANKS,Blocks.CHERRY_PLANKS,Blocks.BAMBOO_PLANKS,Blocks.CRIMSON_PLANKS,Blocks.WARPED_PLANKS);

        //Pedestal
        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.STONE_SLAB.asItem())
                .define('X', Blocks.SMOOTH_STONE.asItem())
                .unlockedBy("this.hasItem.apply_stone_slab", this.hasItem.apply(Blocks.STONE_SLAB))
                .unlockedBy("this.hasItem.apply_smooth_stone", this.hasItem.apply(Blocks.SMOOTH_STONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.STONE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.STONE_SLAB.asItem())
                .define('X', Blocks.STONE.asItem())
                .unlockedBy("this.hasItem.apply_stone_slab", this.hasItem.apply(Blocks.STONE_SLAB))
                .unlockedBy("this.hasItem.apply_stone", this.hasItem.apply(Blocks.STONE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.GRANITE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.POLISHED_GRANITE_SLAB.asItem())
                .define('X', Blocks.GRANITE.asItem())
                .unlockedBy("this.hasItem.apply_polished_granite_slab", this.hasItem.apply(Blocks.POLISHED_GRANITE_SLAB))
                .unlockedBy("this.hasItem.apply_granite", this.hasItem.apply(Blocks.GRANITE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DIORITE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.POLISHED_DIORITE_SLAB.asItem())
                .define('X', Blocks.DIORITE.asItem())
                .unlockedBy("this.hasItem.apply_polished_diorite_slab", this.hasItem.apply(Blocks.POLISHED_DIORITE_SLAB))
                .unlockedBy("this.hasItem.apply_diorite", this.hasItem.apply(Blocks.DIORITE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.DEEPSLATE_BRICK_SLAB.asItem())
                .define('X', Blocks.POLISHED_DEEPSLATE.asItem())
                .unlockedBy("this.hasItem.apply_deepslate_slab", this.hasItem.apply(Blocks.DEEPSLATE_BRICK_SLAB))
                .unlockedBy("this.hasItem.apply_ddeepslate_polished", this.hasItem.apply(Blocks.POLISHED_DEEPSLATE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.DEEPSLATE_TILE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.DEEPSLATE_TILE_SLAB.asItem())
                .define('X', Blocks.POLISHED_DEEPSLATE.asItem())
                .unlockedBy("this.hasItem.apply_deepslate_tile_slab", this.hasItem.apply(Blocks.DEEPSLATE_TILE_SLAB))
                .unlockedBy("this.hasItem.apply_deepslate_polished", this.hasItem.apply(Blocks.POLISHED_DEEPSLATE))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.BLACKSTONE_PEDESTAL.get())
                .pattern(" B ")
                .pattern(" X ")
                .pattern(" B ")
                .define('B', Items.POLISHED_BLACKSTONE_BRICK_SLAB.asItem())
                .define('X', Blocks.BLACKSTONE.asItem())
                .unlockedBy("this.hasItem.apply_polished_blackstone_slab", this.hasItem.apply(Blocks.POLISHED_BLACKSTONE_BRICK_SLAB))
                .unlockedBy("this.hasItem.apply_blackstone", this.hasItem.apply(Blocks.BLACKSTONE))
                .save(recipeOutput);

        //Tecque
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.STONE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.STONE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_stone_slab", this.hasItem.apply(Blocks.STONE_SLAB))
                .save(recipeOutput);

        //Wood Tecque
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.OAK_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.OAK_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_oak_slab", this.hasItem.apply(Blocks.OAK_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.SPRUCE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.SPRUCE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_spruce_slab", this.hasItem.apply(Blocks.SPRUCE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BIRCH_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.BIRCH_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_birch_slab", this.hasItem.apply(Blocks.BIRCH_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.JUNGLE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.JUNGLE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_jungle_slab", this.hasItem.apply(Blocks.JUNGLE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ACACIA_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.ACACIA_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_acacia_slab", this.hasItem.apply(Blocks.ACACIA_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.DARK_OAK_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.DARK_OAK_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_dark_oak_slab", this.hasItem.apply(Blocks.DARK_OAK_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.MANGROVE_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.MANGROVE_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_mangrove_slab", this.hasItem.apply(Blocks.MANGROVE_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CHERRY_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.CHERRY_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_cherry_slab", this.hasItem.apply(Blocks.CHERRY_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BAMBOO_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.BAMBOO_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_bamboo_slab", this.hasItem.apply(Blocks.BAMBOO_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CRIMSON_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.CRIMSON_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_crimson_slab", this.hasItem.apply(Blocks.CRIMSON_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.WARPED_GLASS_TECQUE.get())
                .pattern("###")
                .pattern("# #")
                .pattern("BBB")
                .define('B', Blocks.WARPED_SLAB.asItem())
                .define('#', Blocks.GLASS.asItem())
                .unlockedBy("this.hasItem.apply_glass", this.hasItem.apply(Blocks.GLASS))
                .unlockedBy("this.hasItem.apply_warped_slab", this.hasItem.apply(Blocks.WARPED_SLAB))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.FURNI_WORKBENCH.get())
                .pattern("PPP")
                .pattern("ICI")
                .pattern("I I")
                .define('P', ItemTags.PLANKS)
                .define('I', Items.IRON_INGOT)
                .define('C', Blocks.CRAFTING_TABLE)
                .unlockedBy("this.hasItem.apply_crafting_table", this.hasItem.apply(Blocks.CRAFTING_TABLE))
                .save(recipeOutput);


        //CUSTOM WORKBENCH RECIPE
//OAK
        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_TABLE.get(), 4)
                .requires(Blocks.OAK_LOG,2)
                .requires(Blocks.OAK_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.OAK_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_KITCHEN_COUNTER.get(), 2)
                .requires(Items.OAK_LOG,2)
                .requires(Items.OAK_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_KITCHEN_DRAWER.get(), 2)
                .requires(Items.OAK_LOG,2)
                .requires(Items.OAK_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_CABINET.get(), 1)
                .requires(Items.OAK_LOG,2)
                .requires(Items.OAK_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_COFFEE_TABLE.get(), 3)
                .requires(Items.OAK_LOG,1)
                .requires(Items.OAK_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_DINNING_TABLE.get(), 2)
                .requires(Items.OAK_LOG,2)
                .requires(Items.OAK_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.OAK_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_BEDSIDE.get(), 2)
                .requires(Items.OAK_LOG,2)
                .requires(Items.OAK_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.OAK_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.OAK_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.OAK_PLANKS, 5)
                .requires(Items.OAK_LOG, 2)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);
        
        FurniCraftingRecipeBuilder.crafting(ModBlocks.OAK_PARK_BENCH.get(), 4)
                .requires(Items.OAK_PLANKS,5)
                .requires(Items.OAK_LOG,4)
                .unlockedBy("this.hasItem.apply_oak_planks", this.hasItem.apply(Items.OAK_PLANKS))
                .save(recipeOutput);

        //DARK OAK

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_TABLE.get(), 4)
                .requires(Blocks.DARK_OAK_LOG,2)
                .requires(Blocks.DARK_OAK_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.DARK_OAK_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(), 2)
                .requires(Items.DARK_OAK_LOG,2)
                .requires(Items.DARK_OAK_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(), 2)
                .requires(Items.DARK_OAK_LOG,2)
                .requires(Items.DARK_OAK_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_CABINET.get(), 1)
                .requires(Items.DARK_OAK_LOG,2)
                .requires(Items.DARK_OAK_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_COFFEE_TABLE.get(), 3)
                .requires(Items.DARK_OAK_LOG,1)
                .requires(Items.DARK_OAK_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_DINNING_TABLE.get(), 2)
                .requires(Items.DARK_OAK_LOG,2)
                .requires(Items.DARK_OAK_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.DARK_OAK_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_BEDSIDE.get(), 2)
                .requires(Items.DARK_OAK_LOG,2)
                .requires(Items.DARK_OAK_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.DARK_OAK_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.DARK_OAK_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.DARK_OAK_PLANKS, 5)
                .requires(Items.DARK_OAK_LOG, 2)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.DARK_OAK_PARK_BENCH.get(), 4)
                .requires(Items.DARK_OAK_PLANKS,5)
                .requires(Items.DARK_OAK_LOG,4)
                .unlockedBy("this.hasItem.apply_dark_oak", this.hasItem.apply(Items.DARK_OAK_PLANKS))
                .save(recipeOutput);

        // SPRUCE

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_TABLE.get(), 4)
                .requires(Blocks.SPRUCE_LOG,2)
                .requires(Blocks.SPRUCE_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.SPRUCE_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(), 2)
                .requires(Items.SPRUCE_LOG,2)
                .requires(Items.SPRUCE_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(), 2)
                .requires(Items.SPRUCE_LOG,2)
                .requires(Items.SPRUCE_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_CABINET.get(), 1)
                .requires(Items.SPRUCE_LOG,2)
                .requires(Items.SPRUCE_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_COFFEE_TABLE.get(), 3)
                .requires(Items.SPRUCE_LOG,1)
                .requires(Items.SPRUCE_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_DINNING_TABLE.get(), 2)
                .requires(Items.SPRUCE_LOG,2)
                .requires(Items.SPRUCE_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.SPRUCE_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_BEDSIDE.get(), 2)
                .requires(Items.SPRUCE_LOG,2)
                .requires(Items.SPRUCE_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.SPRUCE_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.SPRUCE_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.SPRUCE_PLANKS, 5)
                .requires(Items.SPRUCE_LOG, 2)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.SPRUCE_PARK_BENCH.get(), 4)
                .requires(Items.SPRUCE_PLANKS,5)
                .requires(Items.SPRUCE_LOG,4)
                .unlockedBy("this.hasItem.apply_spruce_planks", this.hasItem.apply(Items.SPRUCE_PLANKS))
                .save(recipeOutput);
        

        // Birch
        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_TABLE.get(), 4)
                .requires(Blocks.BIRCH_LOG,2)
                .requires(Blocks.BIRCH_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.BIRCH_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_KITCHEN_COUNTER.get(), 2)
                .requires(Items.BIRCH_LOG,2)
                .requires(Items.BIRCH_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_KITCHEN_DRAWER.get(), 2)
                .requires(Items.BIRCH_LOG,2)
                .requires(Items.BIRCH_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_CABINET.get(), 1)
                .requires(Items.BIRCH_LOG,2)
                .requires(Items.BIRCH_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_COFFEE_TABLE.get(), 3)
                .requires(Items.BIRCH_LOG,1)
                .requires(Items.BIRCH_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_DINNING_TABLE.get(), 2)
                .requires(Items.BIRCH_LOG,2)
                .requires(Items.BIRCH_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.BIRCH_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_BEDSIDE.get(), 2)
                .requires(Items.BIRCH_LOG,2)
                .requires(Items.BIRCH_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.BIRCH_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.BIRCH_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.BIRCH_PLANKS, 5)
                .requires(Items.BIRCH_LOG, 2)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BIRCH_PARK_BENCH.get(), 4)
                .requires(Items.BIRCH_PLANKS,5)
                .requires(Items.BIRCH_LOG,4)
                .unlockedBy("this.hasItem.apply_birch_planks", this.hasItem.apply(Items.BIRCH_PLANKS))
                .save(recipeOutput);
        
        
        //JUNGLE
        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_TABLE.get(), 4)
                .requires(Blocks.JUNGLE_LOG,2)
                .requires(Blocks.JUNGLE_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.JUNGLE_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(), 2)
                .requires(Items.JUNGLE_LOG,2)
                .requires(Items.JUNGLE_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(), 2)
                .requires(Items.JUNGLE_LOG,2)
                .requires(Items.JUNGLE_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_CABINET.get(), 1)
                .requires(Items.JUNGLE_LOG,2)
                .requires(Items.JUNGLE_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_COFFEE_TABLE.get(), 3)
                .requires(Items.JUNGLE_LOG,1)
                .requires(Items.JUNGLE_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_DINNING_TABLE.get(), 2)
                .requires(Items.JUNGLE_LOG,2)
                .requires(Items.JUNGLE_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.JUNGLE_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_BEDSIDE.get(), 2)
                .requires(Items.JUNGLE_LOG,2)
                .requires(Items.JUNGLE_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.JUNGLE_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.JUNGLE_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.JUNGLE_PLANKS, 5)
                .requires(Items.JUNGLE_LOG, 2)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.JUNGLE_PARK_BENCH.get(), 4)
                .requires(Items.JUNGLE_PLANKS,5)
                .requires(Items.JUNGLE_LOG,4)
                .unlockedBy("this.hasItem.apply_jungle_planks", this.hasItem.apply(Items.JUNGLE_PLANKS))
                .save(recipeOutput);
        //ACACIA
        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_TABLE.get(), 4)
                .requires(Blocks.ACACIA_LOG,2)
                .requires(Blocks.ACACIA_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.ACACIA_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_KITCHEN_COUNTER.get(), 2)
                .requires(Items.ACACIA_LOG,2)
                .requires(Items.ACACIA_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_KITCHEN_DRAWER.get(), 2)
                .requires(Items.ACACIA_LOG,2)
                .requires(Items.ACACIA_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_CABINET.get(), 1)
                .requires(Items.ACACIA_LOG,2)
                .requires(Items.ACACIA_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_COFFEE_TABLE.get(), 3)
                .requires(Items.ACACIA_LOG,1)
                .requires(Items.ACACIA_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_DINNING_TABLE.get(), 2)
                .requires(Items.ACACIA_LOG,2)
                .requires(Items.ACACIA_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.ACACIA_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_BEDSIDE.get(), 2)
                .requires(Items.ACACIA_LOG,2)
                .requires(Items.ACACIA_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.ACACIA_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.ACACIA_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.ACACIA_PLANKS, 5)
                .requires(Items.ACACIA_LOG, 2)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.ACACIA_PARK_BENCH.get(), 4)
                .requires(Items.ACACIA_PLANKS,5)
                .requires(Items.ACACIA_LOG,4)
                .unlockedBy("this.hasItem.apply_acacia_planks", this.hasItem.apply(Items.ACACIA_PLANKS))
                .save(recipeOutput);

        //MANGROVE
        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_TABLE.get(), 4)
                .requires(Blocks.MANGROVE_LOG,2)
                .requires(Blocks.MANGROVE_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.MANGROVE_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(), 2)
                .requires(Items.MANGROVE_LOG,2)
                .requires(Items.MANGROVE_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(), 2)
                .requires(Items.MANGROVE_LOG,2)
                .requires(Items.MANGROVE_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_CABINET.get(), 1)
                .requires(Items.MANGROVE_LOG,2)
                .requires(Items.MANGROVE_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_COFFEE_TABLE.get(), 3)
                .requires(Items.MANGROVE_LOG,1)
                .requires(Items.MANGROVE_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_DINNING_TABLE.get(), 2)
                .requires(Items.MANGROVE_LOG,2)
                .requires(Items.MANGROVE_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.MANGROVE_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_BEDSIDE.get(), 2)
                .requires(Items.MANGROVE_LOG,2)
                .requires(Items.MANGROVE_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.MANGROVE_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.MANGROVE_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.MANGROVE_PLANKS, 5)
                .requires(Items.MANGROVE_LOG, 2)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.MANGROVE_PARK_BENCH.get(), 4)
                .requires(Items.MANGROVE_PLANKS,5)
                .requires(Items.MANGROVE_LOG,4)
                .unlockedBy("this.hasItem.apply_mangrove_planks", this.hasItem.apply(Items.MANGROVE_PLANKS))
                .save(recipeOutput);
        
        //CHERRY
        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_TABLE.get(), 4)
                .requires(Blocks.CHERRY_LOG,2)
                .requires(Blocks.CHERRY_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.CHERRY_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_KITCHEN_COUNTER.get(), 2)
                .requires(Items.CHERRY_LOG,2)
                .requires(Items.CHERRY_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_KITCHEN_DRAWER.get(), 2)
                .requires(Items.CHERRY_LOG,2)
                .requires(Items.CHERRY_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_CABINET.get(), 1)
                .requires(Items.CHERRY_LOG,2)
                .requires(Items.CHERRY_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_COFFEE_TABLE.get(), 3)
                .requires(Items.CHERRY_LOG,1)
                .requires(Items.CHERRY_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_DINNING_TABLE.get(), 2)
                .requires(Items.CHERRY_LOG,2)
                .requires(Items.CHERRY_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.CHERRY_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_BEDSIDE.get(), 2)
                .requires(Items.CHERRY_LOG,2)
                .requires(Items.CHERRY_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.CHERRY_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.CHERRY_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.CHERRY_PLANKS, 5)
                .requires(Items.CHERRY_LOG, 2)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CHERRY_PARK_BENCH.get(), 4)
                .requires(Items.CHERRY_PLANKS,5)
                .requires(Items.CHERRY_LOG,4)
                .unlockedBy("this.hasItem.apply_cherry_planks", this.hasItem.apply(Items.CHERRY_PLANKS))
                .save(recipeOutput);
        
        //BAMBOO
        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_TABLE.get(), 4)
                .requires(Blocks.BAMBOO_BLOCK,2)
                .requires(Blocks.BAMBOO_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.BAMBOO_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(), 2)
                .requires(Items.BAMBOO_BLOCK,2)
                .requires(Items.BAMBOO_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_KITCHEN_DRAWER.get(), 2)
                .requires(Items.BAMBOO_BLOCK,2)
                .requires(Items.BAMBOO_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_CABINET.get(), 1)
                .requires(Items.BAMBOO_BLOCK,2)
                .requires(Items.BAMBOO_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_COFFEE_TABLE.get(), 3)
                .requires(Items.BAMBOO_BLOCK,1)
                .requires(Items.BAMBOO_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_DINNING_TABLE.get(), 2)
                .requires(Items.BAMBOO_BLOCK,2)
                .requires(Items.BAMBOO_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.BAMBOO_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_BEDSIDE.get(), 2)
                .requires(Items.BAMBOO_BLOCK,2)
                .requires(Items.BAMBOO_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.BAMBOO_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.BAMBOO_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.BAMBOO_PLANKS, 5)
                .requires(Items.BAMBOO_BLOCK, 2)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.BAMBOO_PARK_BENCH.get(), 4)
                .requires(Items.BAMBOO_PLANKS,5)
                .requires(Items.BAMBOO_BLOCK,4)
                .unlockedBy("this.hasItem.apply_bamboo_block", this.hasItem.apply(Items.BAMBOO_PLANKS))
                .save(recipeOutput);

        //CRIMSON
        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_TABLE.get(), 4)
                .requires(Blocks.CRIMSON_STEM,2)
                .requires(Blocks.CRIMSON_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.CRIMSON_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(), 2)
                .requires(Items.CRIMSON_STEM,2)
                .requires(Items.CRIMSON_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(), 2)
                .requires(Items.CRIMSON_STEM,2)
                .requires(Items.CRIMSON_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_CABINET.get(), 1)
                .requires(Items.CRIMSON_STEM,2)
                .requires(Items.CRIMSON_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_COFFEE_TABLE.get(), 3)
                .requires(Items.CRIMSON_STEM,1)
                .requires(Items.CRIMSON_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_DINNING_TABLE.get(), 2)
                .requires(Items.CRIMSON_STEM,2)
                .requires(Items.CRIMSON_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.CRIMSON_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_BEDSIDE.get(), 2)
                .requires(Items.CRIMSON_STEM,2)
                .requires(Items.CRIMSON_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.CRIMSON_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.CRIMSON_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.CRIMSON_PLANKS, 5)
                .requires(Items.CRIMSON_STEM, 2)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.CRIMSON_PARK_BENCH.get(), 4)
                .requires(Items.CRIMSON_PLANKS,5)
                .requires(Items.CRIMSON_STEM,4)
                .unlockedBy("this.hasItem.apply_crimson_planks", this.hasItem.apply(Items.CRIMSON_PLANKS))
                .save(recipeOutput);
        
        
        //WARPED
        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_TABLE.get(), 4)
                .requires(Blocks.WARPED_STEM,2)
                .requires(Blocks.WARPED_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_CHAIR.get(), 4)
                .requires(Items.STICK,2)
                .requires(Blocks.WARPED_PLANKS, 4)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_KITCHEN_COUNTER.get(), 2)
                .requires(Items.WARPED_STEM,2)
                .requires(Items.WARPED_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_KITCHEN_DRAWER.get(), 2)
                .requires(Items.WARPED_STEM,2)
                .requires(Items.WARPED_PLANKS, 6)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_CABINET.get(), 1)
                .requires(Items.WARPED_STEM,2)
                .requires(Items.WARPED_PLANKS, 3)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_COFFEE_TABLE.get(), 3)
                .requires(Items.WARPED_STEM,1)
                .requires(Items.WARPED_PLANKS, 2)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_DINNING_TABLE.get(), 2)
                .requires(Items.WARPED_STEM,2)
                .requires(Items.WARPED_PLANKS, 3)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_CRATE.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.WARPED_PLANKS, 6)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_BEDSIDE.get(), 2)
                .requires(Items.WARPED_STEM,2)
                .requires(Items.WARPED_PLANKS, 5)
                .requires(Items.CHEST, 1)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_SINK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.WARPED_PLANKS, 3)
                .requires(Items.WHITE_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_SINK_DARK.get(), 2)
                .requires(Items.BUCKET,1)
                .requires(Items.WARPED_PLANKS, 3)
                .requires(Items.GRAY_CONCRETE, 2)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_OVEN.get(), 1)
                .requires(Items.SMOKER,1)
                .requires(Items.WARPED_PLANKS, 5)
                .requires(Items.WARPED_STEM, 2)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.WARPED_PARK_BENCH.get(), 4)
                .requires(Items.WARPED_PLANKS,5)
                .requires(Items.WARPED_STEM,4)
                .unlockedBy("this.hasItem.apply_warped_planks", this.hasItem.apply(Items.WARPED_PLANKS))
                .save(recipeOutput);
        













































        FurniCraftingRecipeBuilder.crafting(ModBlocks.FRIDGE_LIGHT.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.WHITE_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 2)
                .unlockedBy("this.hasItem.apply_iron_ingot", this.hasItem.apply(Items.IRON_INGOT))
                .save(recipeOutput);

        FurniCraftingRecipeBuilder.crafting(ModBlocks.FRIDGE_DARK.get(), 1)
                .requires(Items.CHEST,1)
                .requires(Items.GRAY_CONCRETE, 5)
                .requires(Items.IRON_INGOT, 2)
                .unlockedBy("this.hasItem.apply_iron_ingot", this.hasItem.apply(Items.IRON_INGOT))
                .save(recipeOutput);





























    }
    
}
