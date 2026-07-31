package net.tier1234.better_deco.datagen;

import net.minecraft.data.PackOutput;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

public class NeoForgeBlockStateProvider extends CommonBlockStateProvider {

    public NeoForgeBlockStateProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerStatesAndModels() {
/**
 * All the wooden variants + wooden decorations
 **/
        //Kitchen Counters
        kitchenCounter(ModBlocks.OAK_KITCHEN_COUNTER.get(),
                Constants.id("block/oak_kitchen_counter"));
        kitchenCounter(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(),
                Constants.id("block/spruce_kitchen_counter"));
        kitchenCounter(ModBlocks.BIRCH_KITCHEN_COUNTER.get(),
                Constants.id("block/birch_kitchen_counter"));
        kitchenCounter(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(),
                Constants.id("block/jungle_kitchen_counter"));
        kitchenCounter(ModBlocks.ACACIA_KITCHEN_COUNTER.get(),
                Constants.id("block/acacia_kitchen_counter"));
        kitchenCounter(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(),
                Constants.id("block/dark_oak_kitchen_counter"));
        kitchenCounter(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(),
                Constants.id("block/mangrove_kitchen_counter"));
        kitchenCounter(ModBlocks.CHERRY_KITCHEN_COUNTER.get(),
                Constants.id("block/cherry_kitchen_counter"));
        kitchenCounter(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(),
                Constants.id("block/bamboo_kitchen_counter"));
        kitchenCounter(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(),
                Constants.id("block/crimson_kitchen_counter"));
        kitchenCounter(ModBlocks.WARPED_KITCHEN_COUNTER.get(),
                Constants.id("block/warped_kitchen_counter"));


        //Kitchen Drawers
        kitchenDrawer(ModBlocks.OAK_KITCHEN_DRAWER.get(),
                Constants.id("block/oak_kitchen_drawer"),
                Constants.id("block/oak_kitchen_drawer"));
        kitchenDrawer(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(),
                Constants.id("block/spruce_kitchen_drawer"),
                Constants.id("block/spruce_kitchen_drawer"));
        kitchenDrawer(ModBlocks.BIRCH_KITCHEN_DRAWER.get(),
                Constants.id("block/birch_kitchen_drawer"),
                Constants.id("block/birch_kitchen_drawer"));
        kitchenDrawer(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(),
                Constants.id("block/jungle_kitchen_drawer"),
                Constants.id("block/jungle_kitchen_drawer"));
        kitchenDrawer(ModBlocks.ACACIA_KITCHEN_DRAWER.get(),
                Constants.id("block/acacia_kitchen_drawer"),
                Constants.id("block/acacia_kitchen_drawer"));
        kitchenDrawer(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(),
                Constants.id("block/dark_oak_kitchen_drawer"),
                Constants.id("block/dark_oak_kitchen_drawer"));
        kitchenDrawer(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(),
                Constants.id("block/mangrove_kitchen_drawer"),
                Constants.id("block/mangrove_kitchen_drawer"));
        kitchenDrawer(ModBlocks.CHERRY_KITCHEN_DRAWER.get(),
                Constants.id("block/cherry_kitchen_drawer"),
                Constants.id("block/cherry_kitchen_drawer"));
        kitchenDrawer(ModBlocks.BAMBOO_KITCHEN_DRAWER.get(),
                Constants.id("block/bamboo_kitchen_drawer"),
                Constants.id("block/bamboo_kitchen_drawer"));
        kitchenDrawer(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(),
                Constants.id("block/crimson_kitchen_drawer"),
                Constants.id("block/crimson_kitchen_drawer"));
        kitchenDrawer(ModBlocks.WARPED_KITCHEN_DRAWER.get(),
                Constants.id("block/warped_kitchen_drawer"),
                Constants.id("block/warped_kitchen_drawer"));


        //Sinks
        kitchenSink(ModBlocks.OAK_SINK.get(), Constants.id("block/oak_kitchen_sink"));
        kitchenSink(ModBlocks.SPRUCE_SINK.get(), Constants.id("block/spruce_kitchen_sink"));
        kitchenSink(ModBlocks.BIRCH_SINK.get(), Constants.id("block/birch_kitchen_sink"));
        kitchenSink(ModBlocks.JUNGLE_SINK.get(), Constants.id("block/jungle_kitchen_sink"));
        kitchenSink(ModBlocks.ACACIA_SINK.get(), Constants.id("block/acacia_kitchen_sink"));
        kitchenSink(ModBlocks.DARK_OAK_SINK.get(), Constants.id("block/dark_oak_kitchen_sink"));
        kitchenSink(ModBlocks.MANGROVE_SINK.get(), Constants.id("block/mangrove_kitchen_sink"));
        kitchenSink(ModBlocks.CHERRY_SINK.get(), Constants.id("block/cherry_kitchen_sink"));
        kitchenSink(ModBlocks.BAMBOO_SINK.get(), Constants.id("block/bamboo_kitchen_sink"));
        kitchenSink(ModBlocks.CRIMSON_SINK.get(), Constants.id("block/crimson_kitchen_sink"));
        kitchenSink(ModBlocks.WARPED_SINK.get(), Constants.id("block/warped_kitchen_sink"));

        oven(ModBlocks.OAK_OVEN.get(), Constants.id("block/oak_kitchen_oven"));
        oven(ModBlocks.SPRUCE_OVEN.get(), Constants.id("block/spruce_kitchen_oven"));
        oven(ModBlocks.BIRCH_OVEN.get(), Constants.id("block/birch_kitchen_oven"));
        oven(ModBlocks.JUNGLE_OVEN.get(), Constants.id("block/jungle_kitchen_oven"));
        oven(ModBlocks.ACACIA_OVEN.get(), Constants.id("block/acacia_kitchen_oven"));
        oven(ModBlocks.DARK_OAK_OVEN.get(), Constants.id("block/dark_oak_kitchen_oven"));
        oven(ModBlocks.MANGROVE_OVEN.get(), Constants.id("block/mangrove_kitchen_oven"));
        oven(ModBlocks.CHERRY_OVEN.get(), Constants.id("block/cherry_kitchen_oven"));
        oven(ModBlocks.BAMBOO_OVEN.get(), Constants.id("block/bamboo_kitchen_oven"));
        oven(ModBlocks.CRIMSON_OVEN.get(), Constants.id("block/crimson_kitchen_oven"));
        oven(ModBlocks.WARPED_OVEN.get(), Constants.id("block/warped_kitchen_oven"));

        kitchenCabinet(ModBlocks.OAK_CABINET.get(), Constants.id("block/oak_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.SPRUCE_CABINET.get(), Constants.id("block/spruce_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.BIRCH_CABINET.get(), Constants.id("block/birch_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.JUNGLE_CABINET.get(), Constants.id("block/jungle_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.ACACIA_CABINET.get(), Constants.id("block/acacia_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.DARK_OAK_CABINET.get(), Constants.id("block/dark_oak_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.MANGROVE_CABINET.get(), Constants.id("block/mangrove_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.CHERRY_CABINET.get(), Constants.id("block/cherry_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.BAMBOO_CABINET.get(), Constants.id("block/bamboo_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.CRIMSON_CABINET.get(), Constants.id("block/crimson_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.WARPED_CABINET.get(), Constants.id("block/warped_kitchen_cabinet"));

        microwave(ModBlocks.LIGHT_MICROWAVE.get(), Constants.id("block/microwave_light"));
        microwave(ModBlocks.DARK_MICROWAVE.get(), Constants.id("block/microwave_dark"));
        fridge(ModBlocks.FRIDGE_LIGHT.get(), Constants.id("block/fridge_light"));
        fridge(ModBlocks.FRIDGE_DARK.get(), Constants.id("block/fridge_dark"));
        toaster(ModBlocks.TOASTER_LIGHT.get(), Constants.id("block/toaster_light"));
        toaster(ModBlocks.TOASTER_DARK.get(), Constants.id("block/toaster_dark"));

        cuttingBoard(ModBlocks.OAK_CUTTING_BOARD.get(), Constants.id("block/oak_cutting_board"));
        cuttingBoard(ModBlocks.SPRUCE_CUTTING_BOARD.get(), Constants.id("block/spruce_cutting_board"));
        cuttingBoard(ModBlocks.BIRCH_CUTTING_BOARD.get(), Constants.id("block/birch_cutting_board"));
        cuttingBoard(ModBlocks.JUNGLE_CUTTING_BOARD.get(), Constants.id("block/jungle_cutting_board"));
        cuttingBoard(ModBlocks.ACACIA_CUTTING_BOARD.get(), Constants.id("block/acacia_cutting_board"));
        cuttingBoard(ModBlocks.DARK_OAK_CUTTING_BOARD.get(), Constants.id("block/dark_oak_cutting_board"));
        cuttingBoard(ModBlocks.MANGROVE_CUTTING_BOARD.get(), Constants.id("block/mangrove_cutting_board"));
        cuttingBoard(ModBlocks.CHERRY_CUTTING_BOARD.get(), Constants.id("block/cherry_cutting_board"));
        cuttingBoard(ModBlocks.BAMBOO_CUTTING_BOARD.get(), Constants.id("block/bamboo_cutting_board"));
        cuttingBoard(ModBlocks.CRIMSON_CUTTING_BOARD.get(), Constants.id("block/crimson_cutting_board"));
        cuttingBoard(ModBlocks.WARPED_CUTTING_BOARD.get(), Constants.id("block/warped_cutting_board"));

        registerItemModel(ModItems.KITCHEN_KNIFE.get(), Constants.id("item/knife"));

        jar(ModBlocks.OAK_JAR.get(), Constants.id("block/oak_jar"));
        jar(ModBlocks.SPRUCE_JAR.get(), Constants.id("block/spruce_jar"));
        jar(ModBlocks.BIRCH_JAR.get(), Constants.id("block/birch_jar"));
        jar(ModBlocks.JUNGLE_JAR.get(), Constants.id("block/jungle_jar"));
        jar(ModBlocks.ACACIA_JAR.get(), Constants.id("block/acacia_jar"));
        jar(ModBlocks.DARK_OAK_JAR.get(), Constants.id("block/dark_oak_jar"));
        jar(ModBlocks.MANGROVE_JAR.get(), Constants.id("block/mangrove_jar"));
        jar(ModBlocks.CHERRY_JAR.get(), Constants.id("block/cherry_jar"));
        jar(ModBlocks.BAMBOO_JAR.get(), Constants.id("block/bamboo_jar"));
        jar(ModBlocks.CRIMSON_JAR.get(), Constants.id("block/crimson_jar"));
        jar(ModBlocks.WARPED_JAR.get(), Constants.id("block/warped_jar"));

/**
 * All the coloured variants
 **/
        kitchenCounter(ModBlocks.WHITE_KITCHEN_COUNTER.get(), Constants.id("block/white_kitchen_counter"));
        kitchenDrawer(ModBlocks.WHITE_KITCHEN_DRAWER.get(), Constants.id("block/white_kitchen_drawer"), Constants.id("block/white_kitchen_drawer"));
        oven(ModBlocks.WHITE_OVEN.get(), Constants.id("block/white_kitchen_oven"));
        kitchenSink(ModBlocks.WHITE_SINK.get(), Constants.id("block/white_kitchen_sink"));
        kitchenCabinet(ModBlocks.WHITE_CABINET.get(), Constants.id("block/white_kitchen_cabinet"));

        kitchenCounter(ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get(), Constants.id("block/light_gray_kitchen_counter"));
        kitchenDrawer(ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get(), Constants.id("block/light_gray_kitchen_drawer"), Constants.id("block/light_gray_kitchen_drawer"));
        oven(ModBlocks.LIGHT_GRAY_OVEN.get(), Constants.id("block/light_gray_kitchen_oven"));
        kitchenSink(ModBlocks.LIGHT_GRAY_SINK.get(), Constants.id("block/light_gray_kitchen_sink"));
        kitchenCabinet(ModBlocks.LIGHT_GRAY_CABINET.get(), Constants.id("block/light_gray_kitchen_cabinet"));

        kitchenCounter(ModBlocks.GRAY_KITCHEN_COUNTER.get(), Constants.id("block/gray_kitchen_counter"));
        kitchenDrawer(ModBlocks.GRAY_KITCHEN_DRAWER.get(), Constants.id("block/gray_kitchen_drawer"), Constants.id("block/gray_kitchen_drawer"));
        oven(ModBlocks.GRAY_OVEN.get(), Constants.id("block/gray_kitchen_oven"));
        kitchenSink(ModBlocks.GRAY_SINK.get(), Constants.id("block/gray_kitchen_sink"));
        kitchenCabinet(ModBlocks.GRAY_CABINET.get(), Constants.id("block/gray_kitchen_cabinet"));

        kitchenCounter(ModBlocks.BLACK_KITCHEN_COUNTER.get(), Constants.id("block/black_kitchen_counter"));
        kitchenDrawer(ModBlocks.BLACK_KITCHEN_DRAWER.get(), Constants.id("block/black_kitchen_drawer"), Constants.id("block/black_kitchen_drawer"));
        oven(ModBlocks.BLACK_OVEN.get(), Constants.id("block/black_kitchen_oven"));
        kitchenSink(ModBlocks.BLACK_SINK.get(), Constants.id("block/black_kitchen_sink"));
        kitchenCabinet(ModBlocks.BLACK_CABINET.get(), Constants.id("block/black_kitchen_cabinet"));

        kitchenCounter(ModBlocks.BROWN_KITCHEN_COUNTER.get(), Constants.id("block/brown_kitchen_counter"));
        kitchenDrawer(ModBlocks.BROWN_KITCHEN_DRAWER.get(), Constants.id("block/brown_kitchen_drawer"), Constants.id("block/furniture/kitchen/colored/brown_kitchen_drawer"));
        oven(ModBlocks.BROWN_OVEN.get(), Constants.id("block/brown_kitchen_oven"));
        kitchenSink(ModBlocks.BROWN_SINK.get(), Constants.id("block/brown_kitchen_sink"));
        kitchenCabinet(ModBlocks.BROWN_CABINET.get(), Constants.id("block/brown_kitchen_cabinet"));

        kitchenCounter(ModBlocks.RED_KITCHEN_COUNTER.get(), Constants.id("block/red_kitchen_counter"));
        kitchenDrawer(ModBlocks.RED_KITCHEN_DRAWER.get(), Constants.id("block/red_kitchen_drawer"), Constants.id("block/red_kitchen_drawer"));
        oven(ModBlocks.RED_OVEN.get(), Constants.id("block/red_kitchen_oven"));
        kitchenSink(ModBlocks.RED_SINK.get(), Constants.id("block/red_kitchen_sink"));
        kitchenCabinet(ModBlocks.RED_CABINET.get(), Constants.id("block/red_kitchen_cabinet"));

        kitchenCounter(ModBlocks.ORANGE_KITCHEN_COUNTER.get(), Constants.id("block/orange_kitchen_counter"));
        kitchenDrawer(ModBlocks.ORANGE_KITCHEN_DRAWER.get(), Constants.id("block/orange_kitchen_drawer"), Constants.id("block/orange_kitchen_drawer"));
        oven(ModBlocks.ORANGE_OVEN.get(), Constants.id("block/orange_kitchen_oven"));
        kitchenSink(ModBlocks.ORANGE_SINK.get(), Constants.id("block/orange_kitchen_sink"));
        kitchenCabinet(ModBlocks.ORANGE_CABINET.get(), Constants.id("block/orange_kitchen_cabinet"));

        kitchenCounter(ModBlocks.YELLOW_KITCHEN_COUNTER.get(), Constants.id("block/yellow_kitchen_counter"));
        kitchenDrawer(ModBlocks.YELLOW_KITCHEN_DRAWER.get(), Constants.id("block/yellow_kitchen_drawer"), Constants.id("block/yellow_kitchen_drawer"));
        oven(ModBlocks.YELLOW_OVEN.get(), Constants.id("block/yellow_kitchen_oven"));
        kitchenSink(ModBlocks.YELLOW_SINK.get(), Constants.id("block/yellow_kitchen_sink"));
        kitchenCabinet(ModBlocks.YELLOW_CABINET.get(), Constants.id("block/yellow_kitchen_cabinet"));

        kitchenCounter(ModBlocks.LIME_KITCHEN_COUNTER.get(), Constants.id("block/lime_kitchen_counter"));
        kitchenDrawer(ModBlocks.LIME_KITCHEN_DRAWER.get(), Constants.id("block/lime_kitchen_drawer"), Constants.id("block/lime_kitchen_drawer"));
        oven(ModBlocks.LIME_OVEN.get(), Constants.id("block/lime_kitchen_oven"));
        kitchenSink(ModBlocks.LIME_SINK.get(), Constants.id("block/lime_kitchen_sink"));
        kitchenCabinet(ModBlocks.LIME_CABINET.get(), Constants.id("block/lime_kitchen_cabinet"));

        kitchenCounter(ModBlocks.GREEN_KITCHEN_COUNTER.get(), Constants.id("block/green_kitchen_counter"));
        kitchenDrawer(ModBlocks.GREEN_KITCHEN_DRAWER.get(), Constants.id("block/green_kitchen_drawer"), Constants.id("block/green_kitchen_drawer"));
        oven(ModBlocks.GREEN_OVEN.get(), Constants.id("block/green_kitchen_oven"));
        kitchenSink(ModBlocks.GREEN_SINK.get(), Constants.id("block/green_kitchen_sink"));
        kitchenCabinet(ModBlocks.GREEN_CABINET.get(), Constants.id("block/green_kitchen_cabinet"));

        kitchenCounter(ModBlocks.CYAN_KITCHEN_COUNTER.get(), Constants.id("block/cyan_kitchen_counter"));
        kitchenDrawer(ModBlocks.CYAN_KITCHEN_DRAWER.get(), Constants.id("block/cyan_kitchen_drawer"), Constants.id("block/cyan_kitchen_drawer"));
        oven(ModBlocks.CYAN_OVEN.get(), Constants.id("block/cyan_kitchen_oven"));
        kitchenSink(ModBlocks.CYAN_SINK.get(), Constants.id("block/cyan_kitchen_sink"));
        kitchenCabinet(ModBlocks.CYAN_CABINET.get(), Constants.id("block/cyan_kitchen_cabinet"));

        kitchenCounter(ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get(), Constants.id("block/light_blue_kitchen_counter"));
        kitchenDrawer(ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get(), Constants.id("block/light_blue_kitchen_drawer"), Constants.id("block/light_blue_kitchen_drawer"));
        oven(ModBlocks.LIGHT_BLUE_OVEN.get(), Constants.id("block/light_blue_kitchen_oven"));
        kitchenSink(ModBlocks.LIGHT_BLUE_SINK.get(), Constants.id("block/light_blue_kitchen_sink"));
        kitchenCabinet(ModBlocks.LIGHT_BLUE_CABINET.get(), Constants.id("block/light_blue_kitchen_cabinet"));

        kitchenCounter(ModBlocks.BLUE_KITCHEN_COUNTER.get(), Constants.id("block/blue_kitchen_counter"));
        kitchenDrawer(ModBlocks.BLUE_KITCHEN_DRAWER.get(), Constants.id("block/blue_kitchen_drawer"), Constants.id("block/blue_kitchen_drawer"));
        oven(ModBlocks.BLUE_OVEN.get(), Constants.id("block/blue_kitchen_oven"));
        kitchenSink(ModBlocks.BLUE_SINK.get(), Constants.id("block/blue_kitchen_sink"));
        kitchenCabinet(ModBlocks.BLUE_CABINET.get(), Constants.id("block/blue_kitchen_cabinet"));

        kitchenCounter(ModBlocks.PURPLE_KITCHEN_COUNTER.get(), Constants.id("block/purple_kitchen_counter"));
        kitchenDrawer(ModBlocks.PURPLE_KITCHEN_DRAWER.get(), Constants.id("block/purple_kitchen_drawer"), Constants.id("block/purple_kitchen_drawer"));
        oven(ModBlocks.PURPLE_OVEN.get(), Constants.id("block/purple_kitchen_oven"));
        kitchenSink(ModBlocks.PURPLE_SINK.get(), Constants.id("block/purple_kitchen_sink"));
        kitchenCabinet(ModBlocks.PURPLE_CABINET.get(), Constants.id("block/purple_kitchen_cabinet"));

        kitchenCounter(ModBlocks.MAGENTA_KITCHEN_COUNTER.get(), Constants.id("block/magenta_kitchen_counter"));
        kitchenDrawer(ModBlocks.MAGENTA_KITCHEN_DRAWER.get(), Constants.id("block/magenta_kitchen_drawer"), Constants.id("block/magenta_kitchen_drawer"));
        oven(ModBlocks.MAGENTA_OVEN.get(), Constants.id("block/magenta_kitchen_oven"));
        kitchenSink(ModBlocks.MAGENTA_SINK.get(), Constants.id("block/magenta_kitchen_sink"));
        kitchenCabinet(ModBlocks.MAGENTA_CABINET.get(), Constants.id("block/magenta_kitchen_cabinet"));

        kitchenCounter(ModBlocks.PINK_KITCHEN_COUNTER.get(), Constants.id("block/pink_kitchen_counter"));
        kitchenDrawer(ModBlocks.PINK_KITCHEN_DRAWER.get(), Constants.id("block/pink_kitchen_drawer"), Constants.id("block/pink_kitchen_drawer"));
        oven(ModBlocks.PINK_OVEN.get(), Constants.id("block/pink_kitchen_oven"));
        kitchenSink(ModBlocks.PINK_SINK.get(), Constants.id("block/pink_kitchen_sink"));
        kitchenCabinet(ModBlocks.PINK_CABINET.get(), Constants.id("block/pink_kitchen_cabinet"));

        workbench(ModBlocks.FURNI_WORKBENCH.get(), Constants.id("block/workbench_front"),Constants.id("block/workbench_side"),Constants.id("block/workbench_top"), Constants.id("block/workbench_bottom"));

        basin(ModBlocks.OAK_BASIN.get(), Constants.id("block/oak_basin"));
        basin(ModBlocks.SPRUCE_BASIN.get(), Constants.id("block/spruce_basin"));
        basin(ModBlocks.BIRCH_BASIN.get(), Constants.id("block/birch_basin"));
        basin(ModBlocks.JUNGLE_BASIN.get(), Constants.id("block/jungle_basin"));
        basin(ModBlocks.ACACIA_BASIN.get(), Constants.id("block/acacia_basin"));
        basin(ModBlocks.DARK_OAK_BASIN.get(), Constants.id("block/dark_oak_basin"));
        basin(ModBlocks.MANGROVE_BASIN.get(), Constants.id("block/mangrove_basin"));
        basin(ModBlocks.CHERRY_BASIN.get(), Constants.id("block/cherry_basin"));
        basin(ModBlocks.BAMBOO_BASIN.get(), Constants.id("block/bamboo_basin"));
        basin(ModBlocks.CRIMSON_BASIN.get(), Constants.id("block/crimson_basin"));
        basin(ModBlocks.WARPED_BASIN.get(), Constants.id("block/warped_basin"));

        toilet(ModBlocks.OAK_TOILET.get(), Constants.id(("block/oak_toilet")));
        toilet(ModBlocks.SPRUCE_TOILET.get(), Constants.id(("block/spruce_toilet")));
        toilet(ModBlocks.BIRCH_TOILET.get(), Constants.id(("block/birch_toilet")));
        toilet(ModBlocks.JUNGLE_TOILET.get(), Constants.id(("block/jungle_toilet")));
        toilet(ModBlocks.ACACIA_TOILET.get(), Constants.id(("block/acacia_toilet")));
        toilet(ModBlocks.DARK_OAK_TOILET.get(), Constants.id(("block/dark_oak_toilet")));
        toilet(ModBlocks.MANGROVE_TOILET.get(), Constants.id(("block/mangrove_toilet")));
        toilet(ModBlocks.CHERRY_TOILET.get(), Constants.id(("block/cherry_toilet")));
        toilet(ModBlocks.BAMBOO_TOILET.get(), Constants.id(("block/bamboo_toilet")));
        toilet(ModBlocks.CRIMSON_TOILET.get(), Constants.id(("block/crimson_toilet")));
        toilet(ModBlocks.WARPED_TOILET.get(), Constants.id(("block/warped_toilet")));

        bath(ModBlocks.OAK_BATH.get(), Constants.id(("block/oak_bath")));
        bath(ModBlocks.SPRUCE_BATH.get(), Constants.id(("block/spruce_bath")));
        bath(ModBlocks.BIRCH_BATH.get(), Constants.id(("block/birch_bath")));
        bath(ModBlocks.JUNGLE_BATH.get(), Constants.id(("block/jungle_bath")));
        bath(ModBlocks.ACACIA_BATH.get(), Constants.id(("block/acacia_bath")));
        bath(ModBlocks.DARK_OAK_BATH.get(), Constants.id(("block/dark_oak_bath")));
        bath(ModBlocks.MANGROVE_BATH.get(), Constants.id(("block/mangrove_bath")));
        bath(ModBlocks.CHERRY_BATH.get(), Constants.id(("block/cherry_bath")));
        bath(ModBlocks.BAMBOO_BATH.get(), Constants.id(("block/bamboo_bath")));
        bath(ModBlocks.CRIMSON_BATH.get(), Constants.id(("block/crimson_bath")));
        bath(ModBlocks.WARPED_BATH.get(), Constants.id(("block/warped_bath")));


    }
}