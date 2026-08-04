package net.tier1234.better_deco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.core.HolderLookup;
import net.tier1234.better_deco.registries.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class FabricLootTableProvider extends FabricBlockLootTableProvider {
    public FabricLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropSelf(ModBlocks.FURNI_WORKBENCH.get());
        //Tecque
        dropSelf(ModBlocks.STONE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.OAK_GLASS_TECQUE.get());
        dropSelf(ModBlocks.SPRUCE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.BIRCH_GLASS_TECQUE.get());
        dropSelf(ModBlocks.JUNGLE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.ACACIA_GLASS_TECQUE.get());
        dropSelf(ModBlocks.DARK_OAK_GLASS_TECQUE.get());
        dropSelf(ModBlocks.MANGROVE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.CHERRY_GLASS_TECQUE.get());
        dropSelf(ModBlocks.BAMBOO_GLASS_TECQUE.get());

        //Furnitures
        //Chairs

        dropSelf(ModBlocks.OAK_CHAIR.get());
        dropSelf(ModBlocks.SPRUCE_CHAIR.get());
        dropSelf(ModBlocks.BIRCH_CHAIR.get());
        dropSelf(ModBlocks.JUNGLE_CHAIR.get());
        dropSelf(ModBlocks.ACACIA_CHAIR.get());
        dropSelf(ModBlocks.MANGROVE_CHAIR.get());
        dropSelf(ModBlocks.DARK_OAK_CHAIR.get());
        dropSelf(ModBlocks.CHERRY_CHAIR.get());
        dropSelf(ModBlocks.BAMBOO_CHAIR.get());
        dropSelf(ModBlocks.CRIMSON_CHAIR.get());
        dropSelf(ModBlocks.WARPED_CHAIR.get());


        //Kitchen Counters
        dropSelf(ModBlocks.OAK_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.SPRUCE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.BIRCH_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.JUNGLE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.ACACIA_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.MANGROVE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.CHERRY_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.BAMBOO_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.CRIMSON_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.WARPED_KITCHEN_COUNTER.get());
        //Stripped Variants

        //Kitchen Drawers
        dropSelf(ModBlocks.OAK_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.SPRUCE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.BIRCH_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.JUNGLE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.ACACIA_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.MANGROVE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.CHERRY_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.BAMBOO_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.CRIMSON_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.WARPED_KITCHEN_DRAWER.get());

        //Stripped Variants

        //Kitchen Cabinet
        dropSelf(ModBlocks.OAK_CABINET.get());
        dropSelf(ModBlocks.SPRUCE_CABINET.get());
        dropSelf(ModBlocks.BIRCH_CABINET.get());
        dropSelf(ModBlocks.JUNGLE_CABINET.get());
        dropSelf(ModBlocks.ACACIA_CABINET.get());
        dropSelf(ModBlocks.MANGROVE_CABINET.get());
        dropSelf(ModBlocks.DARK_OAK_CABINET.get());
        dropSelf(ModBlocks.CHERRY_CABINET.get());
        dropSelf(ModBlocks.BAMBOO_CABINET.get());
        dropSelf(ModBlocks.CRIMSON_CABINET.get());
        dropSelf(ModBlocks.WARPED_CABINET.get());




        //Tables
        dropSelf(ModBlocks.OAK_TABLE.get());
        dropSelf(ModBlocks.SPRUCE_TABLE.get());
        dropSelf(ModBlocks.BIRCH_TABLE.get());
        dropSelf(ModBlocks.JUNGLE_TABLE.get());
        dropSelf(ModBlocks.ACACIA_TABLE.get());
        dropSelf(ModBlocks.MANGROVE_TABLE.get());
        dropSelf(ModBlocks.DARK_OAK_TABLE.get());
        dropSelf(ModBlocks.CHERRY_TABLE.get());
        dropSelf(ModBlocks.BAMBOO_TABLE.get());
        dropSelf(ModBlocks.CRIMSON_TABLE.get());
        dropSelf(ModBlocks.WARPED_TABLE.get());


        //Sofa
        dropSelf(ModBlocks.RED_SOFA.get());
        dropSelf(ModBlocks.YELLOW_SOFA.get());
        dropSelf(ModBlocks.PINK_SOFA.get());
        dropSelf(ModBlocks.PURPLE_SOFA.get());
        dropSelf(ModBlocks.BROWN_SOFA.get());
        dropSelf(ModBlocks.ORANGE_SOFA.get());
        dropSelf(ModBlocks.BLACK_SOFA.get());
        dropSelf(ModBlocks.WHITE_SOFA.get());
        dropSelf(ModBlocks.MAGENTA_SOFA.get());
        dropSelf(ModBlocks.LIGHT_BLUE_SOFA.get());
        dropSelf(ModBlocks.BLUE_SOFA.get());
        dropSelf(ModBlocks.GREEN_SOFA.get());
        dropSelf(ModBlocks.LIME_SOFA.get());
        dropSelf(ModBlocks.LIGHT_GREY_SOFA.get());
        dropSelf(ModBlocks.GREY_SOFA.get());
        dropSelf(ModBlocks.CYAN_SOFA.get());


        //Bedside
        dropSelf(ModBlocks.OAK_BEDSIDE.get());
        dropSelf(ModBlocks.SPRUCE_BEDSIDE.get());
        dropSelf(ModBlocks.BIRCH_BEDSIDE.get());
        dropSelf(ModBlocks.JUNGLE_BEDSIDE.get());
        dropSelf(ModBlocks.ACACIA_BEDSIDE.get());
        dropSelf(ModBlocks.MANGROVE_BEDSIDE.get());
        dropSelf(ModBlocks.DARK_OAK_BEDSIDE.get());
        dropSelf(ModBlocks.CHERRY_BEDSIDE.get());
        dropSelf(ModBlocks.BAMBOO_BEDSIDE.get());
        dropSelf(ModBlocks.CRIMSON_BEDSIDE.get());
        dropSelf(ModBlocks.WARPED_BEDSIDE.get());

        //Crates
        dropSelf(ModBlocks.OAK_CRATE.get());
        dropSelf(ModBlocks.SPRUCE_CRATE.get());
        dropSelf(ModBlocks.BIRCH_CRATE.get());
        dropSelf(ModBlocks.JUNGLE_CRATE.get());
        dropSelf(ModBlocks.ACACIA_CRATE.get());
        dropSelf(ModBlocks.MANGROVE_CRATE.get());
        dropSelf(ModBlocks.DARK_OAK_CRATE.get());
        dropSelf(ModBlocks.CHERRY_CRATE.get());
        dropSelf(ModBlocks.BAMBOO_CRATE.get());
        dropSelf(ModBlocks.CRIMSON_CRATE.get());
        dropSelf(ModBlocks.WARPED_CRATE.get());

        //Utilities

        //Pedestals

        dropSelf(ModBlocks.PEDESTAL.get());
        dropSelf(ModBlocks.DIORITE_PEDESTAL.get());
        dropSelf(ModBlocks.GRANITE_PEDESTAL.get());
        dropSelf(ModBlocks.BLACKSTONE_PEDESTAL.get());
        dropSelf(ModBlocks.DEEPSLATE_PEDESTAL.get());
        dropSelf(ModBlocks.DEEPSLATE_TILE_PEDESTAL.get());
        dropSelf(ModBlocks.STONE_PEDESTAL.get());

        //Sinks
        dropSelf(ModBlocks.OAK_SINK.get());
        dropSelf(ModBlocks.SPRUCE_SINK.get());
        dropSelf(ModBlocks.BIRCH_SINK.get());
        dropSelf(ModBlocks.JUNGLE_SINK.get());
        dropSelf(ModBlocks.ACACIA_SINK.get());
        dropSelf(ModBlocks.MANGROVE_SINK.get());
        dropSelf(ModBlocks.DARK_OAK_SINK.get());
        dropSelf(ModBlocks.CHERRY_SINK.get());
        dropSelf(ModBlocks.BAMBOO_SINK.get());
        dropSelf(ModBlocks.CRIMSON_SINK.get());
        dropSelf(ModBlocks.WARPED_SINK.get());

        dropSelf(ModBlocks.OAK_SINK_DARK.get());
        dropSelf(ModBlocks.SPRUCE_SINK_DARK.get());
        dropSelf(ModBlocks.BIRCH_SINK_DARK.get());
        dropSelf(ModBlocks.JUNGLE_SINK_DARK.get());
        dropSelf(ModBlocks.ACACIA_SINK_DARK.get());
        dropSelf(ModBlocks.MANGROVE_SINK_DARK.get());
        dropSelf(ModBlocks.DARK_OAK_SINK_DARK.get());
        dropSelf(ModBlocks.CHERRY_SINK_DARK.get());
        dropSelf(ModBlocks.BAMBOO_SINK_DARK.get());
        dropSelf(ModBlocks.CRIMSON_SINK_DARK.get());
        dropSelf(ModBlocks.WARPED_SINK_DARK.get());



        dropSelf(ModBlocks.STONE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.OAK_GLASS_TECQUE.get());
        dropSelf(ModBlocks.SPRUCE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.BIRCH_GLASS_TECQUE.get());
        dropSelf(ModBlocks.JUNGLE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.ACACIA_GLASS_TECQUE.get());
        dropSelf(ModBlocks.DARK_OAK_GLASS_TECQUE.get());
        dropSelf(ModBlocks.MANGROVE_GLASS_TECQUE.get());
        dropSelf(ModBlocks.CHERRY_GLASS_TECQUE.get());
        dropSelf(ModBlocks.BAMBOO_GLASS_TECQUE.get());
        dropSelf(ModBlocks.CRIMSON_GLASS_TECQUE.get());
        dropSelf(ModBlocks.WARPED_GLASS_TECQUE.get());




        dropSelf(ModBlocks.RED_STOOL.get());
        dropSelf(ModBlocks.YELLOW_STOOL.get());
        dropSelf(ModBlocks.ORANGE_STOOL.get());
        dropSelf(ModBlocks.PURPLE_STOOL.get());
        dropSelf(ModBlocks.MAGENTA_STOOL.get());
        dropSelf(ModBlocks.PINK_STOOL.get());
        dropSelf(ModBlocks.BLUE_STOOL.get());
        dropSelf(ModBlocks.LIGHT_BLUE_STOOL.get());
        dropSelf(ModBlocks.WITHE_STOOL.get());
        dropSelf(ModBlocks.CYAN_STOOL.get());
        dropSelf(ModBlocks.GREY_STOOL.get());
        dropSelf(ModBlocks.LIGHT_GREY_STOOL.get());
        dropSelf(ModBlocks.GREEN_STOOL.get());
        dropSelf(ModBlocks.LIME_STOOL.get());
        dropSelf(ModBlocks.BLACK_STOOL.get());
        dropSelf(ModBlocks.BROWN_STOOL.get());

        dropSelf(ModBlocks.RED_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.YELLOW_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.ORANGE_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.PURPLE_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.MAGENTA_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.PINK_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.BLUE_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.WHITE_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.CYAN_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.GRAY_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.GREEN_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.LIME_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.BLACK_DIGITAL_CLOCK.get());
        dropSelf(ModBlocks.BROWN_DIGITAL_CLOCK.get());



        dropSelf(ModBlocks.OAK_SHELF.get());
        dropSelf(ModBlocks.SPRUCE_SHELF.get());
        dropSelf(ModBlocks.BIRCH_SHELF.get());
        dropSelf(ModBlocks.JUNGLE_SHELF.get());
        dropSelf(ModBlocks.ACACIA_SHELF.get());
        dropSelf(ModBlocks.DARK_OAK_SHELF.get());
        dropSelf(ModBlocks.MANGROVE_SHELF.get());
        dropSelf(ModBlocks.CHERRY_SHELF.get());
        dropSelf(ModBlocks.BAMBOO_SHELF.get());
        dropSelf(ModBlocks.CRIMSON_SHELF.get());
        dropSelf(ModBlocks.WARPED_SHELF.get());




        dropSelf(ModBlocks.OAK_COFFEE_TABLE.get());
        dropSelf(ModBlocks.SPRUCE_COFFEE_TABLE.get());
        dropSelf(ModBlocks.BIRCH_COFFEE_TABLE.get());
        dropSelf(ModBlocks.JUNGLE_COFFEE_TABLE.get());
        dropSelf(ModBlocks.ACACIA_COFFEE_TABLE.get());
        dropSelf(ModBlocks.DARK_OAK_COFFEE_TABLE.get());
        dropSelf(ModBlocks.MANGROVE_COFFEE_TABLE.get());
        dropSelf(ModBlocks.CHERRY_COFFEE_TABLE.get());
        dropSelf(ModBlocks.BAMBOO_COFFEE_TABLE.get());
        dropSelf(ModBlocks.CRIMSON_COFFEE_TABLE.get());
        dropSelf(ModBlocks.WARPED_COFFEE_TABLE.get());


        dropSelf(ModBlocks.OAK_DINNING_TABLE.get());
        dropSelf(ModBlocks.SPRUCE_DINNING_TABLE.get());
        dropSelf(ModBlocks.BIRCH_DINNING_TABLE.get());
        dropSelf(ModBlocks.JUNGLE_DINNING_TABLE.get());
        dropSelf(ModBlocks.ACACIA_DINNING_TABLE.get());
        dropSelf(ModBlocks.DARK_OAK_DINNING_TABLE.get());
        dropSelf(ModBlocks.MANGROVE_DINNING_TABLE.get());
        dropSelf(ModBlocks.CHERRY_DINNING_TABLE.get());
        dropSelf(ModBlocks.BAMBOO_DINNING_TABLE.get());
        dropSelf(ModBlocks.CRIMSON_DINNING_TABLE.get());
        dropSelf(ModBlocks.WARPED_DINNING_TABLE.get());


        dropSelf(ModBlocks.OAK_OVEN.get());
        dropSelf(ModBlocks.SPRUCE_OVEN.get());
        dropSelf(ModBlocks.BIRCH_OVEN.get());
        dropSelf(ModBlocks.JUNGLE_OVEN.get());
        dropSelf(ModBlocks.ACACIA_OVEN.get());
        dropSelf(ModBlocks.DARK_OAK_OVEN.get());
        dropSelf(ModBlocks.MANGROVE_OVEN.get());
        dropSelf(ModBlocks.CHERRY_OVEN.get());
        dropSelf(ModBlocks.BAMBOO_OVEN.get());
        dropSelf(ModBlocks.CRIMSON_OVEN.get());
        dropSelf(ModBlocks.WARPED_OVEN.get());


        dropSelf(ModBlocks.LIGHT_MICROWAVE.get());
        dropSelf(ModBlocks.DARK_MICROWAVE.get());



        dropSelf(ModBlocks.OAK_PARK_BENCH.get());
        dropSelf(ModBlocks.SPRUCE_PARK_BENCH.get());
        dropSelf(ModBlocks.BIRCH_PARK_BENCH.get());
        dropSelf(ModBlocks.JUNGLE_PARK_BENCH.get());
        dropSelf(ModBlocks.ACACIA_PARK_BENCH.get());
        dropSelf(ModBlocks.DARK_OAK_PARK_BENCH.get());
        dropSelf(ModBlocks.MANGROVE_PARK_BENCH.get());
        dropSelf(ModBlocks.CHERRY_PARK_BENCH.get());
        dropSelf(ModBlocks.BAMBOO_PARK_BENCH.get());
        dropSelf(ModBlocks.CRIMSON_PARK_BENCH.get());
        dropSelf(ModBlocks.WARPED_PARK_BENCH.get());

        dropSelf(ModBlocks.OAK_DESK.get());
        dropSelf(ModBlocks.SPRUCE_DESK.get());
        dropSelf(ModBlocks.BIRCH_DESK.get());
        dropSelf(ModBlocks.JUNGLE_DESK.get());
        dropSelf(ModBlocks.ACACIA_DESK.get());
        dropSelf(ModBlocks.DARK_OAK_DESK.get());
        dropSelf(ModBlocks.MANGROVE_DESK.get());
        dropSelf(ModBlocks.CHERRY_DESK.get());
        dropSelf(ModBlocks.BAMBOO_DESK.get());
        dropSelf(ModBlocks.CRIMSON_DESK.get());
        dropSelf(ModBlocks.WARPED_DESK.get());

        dropSelf(ModBlocks.OAK_DESK_CABINET.get());
        dropSelf(ModBlocks.SPRUCE_DESK_CABINET.get());
        dropSelf(ModBlocks.BIRCH_DESK_CABINET.get());
        dropSelf(ModBlocks.JUNGLE_DESK_CABINET.get());
        dropSelf(ModBlocks.ACACIA_DESK_CABINET.get());
        dropSelf(ModBlocks.DARK_OAK_DESK_CABINET.get());
        dropSelf(ModBlocks.MANGROVE_DESK_CABINET.get());
        dropSelf(ModBlocks.CHERRY_DESK_CABINET.get());
        dropSelf(ModBlocks.BAMBOO_DESK_CABINET.get());
        dropSelf(ModBlocks.CRIMSON_DESK_CABINET.get());
        dropSelf(ModBlocks.WARPED_DESK_CABINET.get());

        dropSelf(ModBlocks.RED_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.YELLOW_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.PINK_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.PURPLE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.BROWN_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.ORANGE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.BLACK_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.WHITE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.MAGENTA_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.BLUE_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.GREEN_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.LIME_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.GRAY_KITCHEN_COUNTER.get());
        dropSelf(ModBlocks.CYAN_KITCHEN_COUNTER.get());

        dropSelf(ModBlocks.RED_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.YELLOW_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.PINK_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.PURPLE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.BROWN_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.ORANGE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.BLACK_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.WHITE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.MAGENTA_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.BLUE_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.GREEN_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.LIME_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.GRAY_KITCHEN_DRAWER.get());
        dropSelf(ModBlocks.CYAN_KITCHEN_DRAWER.get());

        dropSelf(ModBlocks.RED_OVEN.get());
        dropSelf(ModBlocks.YELLOW_OVEN.get());
        dropSelf(ModBlocks.PINK_OVEN.get());
        dropSelf(ModBlocks.PURPLE_OVEN.get());
        dropSelf(ModBlocks.BROWN_OVEN.get());
        dropSelf(ModBlocks.ORANGE_OVEN.get());
        dropSelf(ModBlocks.BLACK_OVEN.get());
        dropSelf(ModBlocks.WHITE_OVEN.get());
        dropSelf(ModBlocks.MAGENTA_OVEN.get());
        dropSelf(ModBlocks.LIGHT_BLUE_OVEN.get());
        dropSelf(ModBlocks.BLUE_OVEN.get());
        dropSelf(ModBlocks.GREEN_OVEN.get());
        dropSelf(ModBlocks.LIME_OVEN.get());
        dropSelf(ModBlocks.LIGHT_GRAY_OVEN.get());
        dropSelf(ModBlocks.GRAY_OVEN.get());
        dropSelf(ModBlocks.CYAN_OVEN.get());

        dropSelf(ModBlocks.RED_SINK.get());
        dropSelf(ModBlocks.YELLOW_SINK.get());
        dropSelf(ModBlocks.PINK_SINK.get());
        dropSelf(ModBlocks.PURPLE_SINK.get());
        dropSelf(ModBlocks.BROWN_SINK.get());
        dropSelf(ModBlocks.ORANGE_SINK.get());
        dropSelf(ModBlocks.BLACK_SINK.get());
        dropSelf(ModBlocks.WHITE_SINK.get());
        dropSelf(ModBlocks.MAGENTA_SINK.get());
        dropSelf(ModBlocks.LIGHT_BLUE_SINK.get());
        dropSelf(ModBlocks.BLUE_SINK.get());
        dropSelf(ModBlocks.GREEN_SINK.get());
        dropSelf(ModBlocks.LIME_SINK.get());
        dropSelf(ModBlocks.LIGHT_GRAY_SINK.get());
        dropSelf(ModBlocks.GRAY_SINK.get());
        dropSelf(ModBlocks.CYAN_SINK.get());

        dropSelf(ModBlocks.RED_CABINET.get());
        dropSelf(ModBlocks.YELLOW_CABINET.get());
        dropSelf(ModBlocks.PINK_CABINET.get());
        dropSelf(ModBlocks.PURPLE_CABINET.get());
        dropSelf(ModBlocks.BROWN_CABINET.get());
        dropSelf(ModBlocks.ORANGE_CABINET.get());
        dropSelf(ModBlocks.BLACK_CABINET.get());
        dropSelf(ModBlocks.WHITE_CABINET.get());
        dropSelf(ModBlocks.MAGENTA_CABINET.get());
        dropSelf(ModBlocks.LIGHT_BLUE_CABINET.get());
        dropSelf(ModBlocks.BLUE_CABINET.get());
        dropSelf(ModBlocks.GREEN_CABINET.get());
        dropSelf(ModBlocks.LIME_CABINET.get());
        dropSelf(ModBlocks.LIGHT_GRAY_CABINET.get());
        dropSelf(ModBlocks.GRAY_CABINET.get());
        dropSelf(ModBlocks.CYAN_CABINET.get());

        dropSelf(ModBlocks.FRIDGE_LIGHT.get());
        dropSelf(ModBlocks.FRIDGE_DARK.get());

        dropSelf(ModBlocks.TOASTER_LIGHT.get());
        dropSelf(ModBlocks.TOASTER_DARK.get());

        dropSelf(ModBlocks.STONE_PATH.get());
        dropSelf(ModBlocks.OAK_CUTTING_BOARD.get());

        dropSelf(ModBlocks.FURNI_WORKBENCH.get());

        dropSelf(ModBlocks.OAK_JAR.get());
        dropSelf(ModBlocks.SPRUCE_JAR.get());
        dropSelf(ModBlocks.BIRCH_JAR.get());
        dropSelf(ModBlocks.JUNGLE_JAR.get());
        dropSelf(ModBlocks.ACACIA_JAR.get());
        dropSelf(ModBlocks.DARK_OAK_JAR.get());
        dropSelf(ModBlocks.MANGROVE_JAR.get());
        dropSelf(ModBlocks.CHERRY_JAR.get());
        dropSelf(ModBlocks.BAMBOO_JAR.get());
        dropSelf(ModBlocks.CRIMSON_JAR.get());
        dropSelf(ModBlocks.WARPED_JAR.get());

        dropSelf(ModBlocks.OAK_CUTTING_BOARD.get());
        dropSelf(ModBlocks.SPRUCE_CUTTING_BOARD.get());
        dropSelf(ModBlocks.BIRCH_CUTTING_BOARD.get());
        dropSelf(ModBlocks.JUNGLE_CUTTING_BOARD.get());
        dropSelf(ModBlocks.ACACIA_CUTTING_BOARD.get());
        dropSelf(ModBlocks.DARK_OAK_CUTTING_BOARD.get());
        dropSelf(ModBlocks.MANGROVE_CUTTING_BOARD.get());
        dropSelf(ModBlocks.CHERRY_CUTTING_BOARD.get());
        dropSelf(ModBlocks.BAMBOO_CUTTING_BOARD.get());
        dropSelf(ModBlocks.CRIMSON_CUTTING_BOARD.get());
        dropSelf(ModBlocks.WARPED_CUTTING_BOARD.get());

        dropSelf(ModBlocks.OAK_BASIN.get());
        dropSelf(ModBlocks.SPRUCE_BASIN.get());
        dropSelf(ModBlocks.BIRCH_BASIN.get());
        dropSelf(ModBlocks.JUNGLE_BASIN.get());
        dropSelf(ModBlocks.ACACIA_BASIN.get());
        dropSelf(ModBlocks.DARK_OAK_BASIN.get());
        dropSelf(ModBlocks.MANGROVE_BASIN.get());
        dropSelf(ModBlocks.CHERRY_BASIN.get());
        dropSelf(ModBlocks.BAMBOO_BASIN.get());
        dropSelf(ModBlocks.CRIMSON_BASIN.get());
        dropSelf(ModBlocks.WARPED_BASIN.get());

        dropSelf(ModBlocks.OAK_TOILET.get());
        dropSelf(ModBlocks.SPRUCE_TOILET.get());
        dropSelf(ModBlocks.BIRCH_TOILET.get());
        dropSelf(ModBlocks.JUNGLE_TOILET.get());
        dropSelf(ModBlocks.ACACIA_TOILET.get());
        dropSelf(ModBlocks.DARK_OAK_TOILET.get());
        dropSelf(ModBlocks.MANGROVE_TOILET.get());
        dropSelf(ModBlocks.CHERRY_TOILET.get());
        dropSelf(ModBlocks.BAMBOO_TOILET.get());
        dropSelf(ModBlocks.CRIMSON_TOILET.get());
        dropSelf(ModBlocks.WARPED_TOILET.get());

        dropSelf(ModBlocks.OAK_BATH.get());
        dropSelf(ModBlocks.SPRUCE_BATH.get());
        dropSelf(ModBlocks.BIRCH_BATH.get());
        dropSelf(ModBlocks.JUNGLE_BATH.get());
        dropSelf(ModBlocks.ACACIA_BATH.get());
        dropSelf(ModBlocks.DARK_OAK_BATH.get());
        dropSelf(ModBlocks.MANGROVE_BATH.get());
        dropSelf(ModBlocks.CHERRY_BATH.get());
        dropSelf(ModBlocks.BAMBOO_BATH.get());
        dropSelf(ModBlocks.CRIMSON_BATH.get());
        dropSelf(ModBlocks.WARPED_BATH.get());


    }
}