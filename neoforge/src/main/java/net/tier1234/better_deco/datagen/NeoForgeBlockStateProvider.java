package net.tier1234.better_deco.datagen;

import net.minecraft.data.PackOutput;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.init.ModBlocks;

public class NeoForgeBlockStateProvider extends CommonBlockStateProvider {

    public NeoForgeBlockStateProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void registerStatesAndModels() {
        kitchenCounter(ModBlocks.CHERRY_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_counter"));
        kitchenCounter(ModBlocks.ACACIA_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_counter"));
        kitchenCounter(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_counter"));
        kitchenCounter(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_counter"));
        kitchenCounter(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_counter"));
        kitchenCounter(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_counter"));
        kitchenCounter(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_counter"));
        kitchenCounter(ModBlocks.WARPED_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_counter"));
        kitchenCounter(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_counter"));
        kitchenCounter(ModBlocks.BIRCH_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_counter"));

        kitchenDrawer(ModBlocks.ACACIA_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.CHERRY_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.WARPED_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.BIRCH_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.SPRUCE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.MANGROVE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.CRIMSON_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.BAMBOO_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_drawer_open"));

        kitchenSink(ModBlocks.OAK_SINK.get(), Constants.id("block/furniture/kitchen_counter/oak/oak_kitchen_sink"));
        kitchenSink(ModBlocks.CHERRY_SINK.get(),Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_sink"));
    }
}