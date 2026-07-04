package net.tier1234.better_deco.datagen;

import net.minecraft.data.PackOutput;
import net.neoforged.fml.common.Mod;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.init.ModBlocks;

public class NeoForgeBlockStateProvider extends CommonBlockStateProvider {

    public NeoForgeBlockStateProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerStatesAndModels() {

        //Kitchen Counters
        kitchenCounter(ModBlocks.OAK_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_counter"));
        kitchenCounter(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_counter"));
        kitchenCounter(ModBlocks.BIRCH_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_counter"));
        kitchenCounter(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_counter"));
        kitchenCounter(ModBlocks.ACACIA_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_counter"));
        kitchenCounter(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_counter"));
        kitchenCounter(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_counter"));
        kitchenCounter(ModBlocks.CHERRY_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_counter"));
        kitchenCounter(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_counter"));
        kitchenCounter(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_counter"));
        kitchenCounter(ModBlocks.WARPED_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_counter"));


        //Kitchen Drawers
        kitchenDrawer(ModBlocks.OAK_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_drawer"));
        kitchenDrawer(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_drawer"));
        kitchenDrawer(ModBlocks.BIRCH_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer"));
        kitchenDrawer(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer"));
        kitchenDrawer(ModBlocks.ACACIA_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer"));
        kitchenDrawer(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_drawer"));
        kitchenDrawer(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_drawer"));
        kitchenDrawer(ModBlocks.CHERRY_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer"));
        kitchenDrawer(ModBlocks.BAMBOO_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_drawer"));
        kitchenDrawer(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_drawer"));
        kitchenDrawer(ModBlocks.WARPED_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer"));


        //Sinks
        kitchenSink(ModBlocks.OAK_SINK.get(), Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_sink"));
        kitchenSink(ModBlocks.SPRUCE_SINK.get(),Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_sink"));
        kitchenSink(ModBlocks.BIRCH_SINK.get(),Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_sink"));
        kitchenSink(ModBlocks.JUNGLE_SINK.get(),Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_sink"));
        kitchenSink(ModBlocks.ACACIA_SINK.get(),Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_sink"));
        kitchenSink(ModBlocks.DARK_OAK_SINK.get(),Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_sink"));
        kitchenSink(ModBlocks.MANGROVE_SINK.get(),Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_sink"));
        kitchenSink(ModBlocks.CHERRY_SINK.get(),Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_sink"));
        kitchenSink(ModBlocks.BAMBOO_SINK.get(),Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_sink"));
        kitchenSink(ModBlocks.CRIMSON_SINK.get(),Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_sink"));
        kitchenSink(ModBlocks.WARPED_SINK.get(),Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_sink"));

        oven(ModBlocks.OAK_OVEN.get(), Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_oven"));
        oven(ModBlocks.SPRUCE_OVEN.get(), Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_oven"));
        oven(ModBlocks.BIRCH_OVEN.get(), Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_oven"));
        oven(ModBlocks.JUNGLE_OVEN.get(), Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_oven"));
        oven(ModBlocks.ACACIA_OVEN.get(), Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_oven"));
        oven(ModBlocks.DARK_OAK_OVEN.get(), Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_oven"));
        oven(ModBlocks.MANGROVE_OVEN.get(), Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_oven"));
        oven(ModBlocks.CHERRY_OVEN.get(), Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_oven"));
        oven(ModBlocks.BAMBOO_OVEN.get(), Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_oven"));
        oven(ModBlocks.CRIMSON_OVEN.get(), Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_oven"));
        oven(ModBlocks.WARPED_OVEN.get(), Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_oven"));

       fridge(ModBlocks.FRIDGE_LIGHT.get(), Constants.id("block/fridge_light"));
       fridge(ModBlocks.FRIDGE_DARK.get(), Constants.id("block/fridge_dark"));

        kitchenCabinet(ModBlocks.OAK_CABINET.get(), Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.SPRUCE_CABINET.get(), Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.BIRCH_CABINET.get(), Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.JUNGLE_CABINET.get(), Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.ACACIA_CABINET.get(), Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.DARK_OAK_CABINET.get(), Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.MANGROVE_CABINET.get(), Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.CHERRY_CABINET.get(), Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.BAMBOO_CABINET.get(), Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.CRIMSON_CABINET.get(), Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_cabinet"));
        kitchenCabinet(ModBlocks.WARPED_CABINET.get(), Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_cabinet"));



    }
}