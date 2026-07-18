package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.registries.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class CommonBlockTagProvider extends IntrinsicHolderTagsProvider<Block> {

    public CommonBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.BLOCK, lookupProvider, block -> block.builtInRegistryHolder().key());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)


        //Furniture
                   //Tables
                .add(ModBlocks.OAK_TABLE.get())
                .add(ModBlocks.SPRUCE_TABLE.get())
                .add(ModBlocks.BIRCH_TABLE.get())
                .add(ModBlocks.JUNGLE_TABLE.get())
                .add(ModBlocks.ACACIA_TABLE.get())
                .add(ModBlocks.MANGROVE_TABLE.get())
                .add(ModBlocks.DARK_OAK_TABLE.get())
                .add(ModBlocks.CHERRY_TABLE.get())
                .add(ModBlocks.BAMBOO_TABLE.get())
                .add(ModBlocks.CRIMSON_TABLE.get())
                .add(ModBlocks.WARPED_TABLE.get())


        //Chairs
                .add(ModBlocks.OAK_CHAIR.get())
                .add(ModBlocks.SPRUCE_CHAIR.get())
                .add(ModBlocks.BIRCH_CHAIR.get())
                .add(ModBlocks.JUNGLE_CHAIR.get())
                .add(ModBlocks.ACACIA_CHAIR.get())
                .add(ModBlocks.MANGROVE_CHAIR.get())
                .add(ModBlocks.DARK_OAK_CHAIR.get())
                .add(ModBlocks.CHERRY_CHAIR.get())
                .add(ModBlocks.BAMBOO_CHAIR.get())
                .add(ModBlocks.CRIMSON_CHAIR.get())
                .add(ModBlocks.WARPED_CHAIR.get())


        //Crates
                .add(ModBlocks.OAK_CRATE.get())
                .add(ModBlocks.SPRUCE_CRATE.get())
                .add(ModBlocks.BIRCH_CRATE.get())
                .add(ModBlocks.JUNGLE_CRATE.get())
                .add(ModBlocks.ACACIA_CRATE.get())
                .add(ModBlocks.MANGROVE_CRATE.get())
                .add(ModBlocks.DARK_OAK_CRATE.get())
                .add(ModBlocks.CHERRY_CRATE.get())
                .add(ModBlocks.BAMBOO_CRATE.get())
                .add(ModBlocks.CRIMSON_CRATE.get())
                .add(ModBlocks.WARPED_CRATE.get())

                //Bedside
                .add(ModBlocks.OAK_BEDSIDE.get())
                .add(ModBlocks.SPRUCE_BEDSIDE.get())
                .add(ModBlocks.BIRCH_BEDSIDE.get())
                .add(ModBlocks.JUNGLE_BEDSIDE.get())
                .add(ModBlocks.ACACIA_BEDSIDE.get())
                .add(ModBlocks.DARK_OAK_BEDSIDE.get())
                .add(ModBlocks.MANGROVE_BEDSIDE.get())
                .add(ModBlocks.CHERRY_BEDSIDE.get())
                .add(ModBlocks.BAMBOO_BEDSIDE.get())
                .add(ModBlocks.CRIMSON_BEDSIDE.get())
                .add(ModBlocks.WARPED_BEDSIDE.get())

                //Sink
                .add(ModBlocks.OAK_SINK.get())
                .add(ModBlocks.SPRUCE_SINK.get())
                .add(ModBlocks.BIRCH_SINK.get())
                .add(ModBlocks.JUNGLE_SINK.get())
                .add(ModBlocks.ACACIA_SINK.get())
                .add(ModBlocks.DARK_OAK_SINK.get())
                .add(ModBlocks.MANGROVE_SINK.get())
                .add(ModBlocks.CHERRY_SINK.get())
                .add(ModBlocks.BAMBOO_SINK.get())
                .add(ModBlocks.CRIMSON_SINK.get())
                .add(ModBlocks.WARPED_SINK.get())

                .add(ModBlocks.OAK_SINK_DARK.get())
                .add(ModBlocks.SPRUCE_SINK_DARK.get())
                .add(ModBlocks.BIRCH_SINK_DARK.get())
                .add(ModBlocks.JUNGLE_SINK_DARK.get())
                .add(ModBlocks.ACACIA_SINK_DARK.get())
                .add(ModBlocks.DARK_OAK_SINK_DARK.get())
                .add(ModBlocks.MANGROVE_SINK_DARK.get())
                .add(ModBlocks.CHERRY_SINK_DARK.get())
                .add(ModBlocks.BAMBOO_SINK_DARK.get())
                .add(ModBlocks.CRIMSON_SINK_DARK.get())
                .add(ModBlocks.WARPED_SINK_DARK.get())



                //Wooden Tecque
                .add(ModBlocks.OAK_GLASS_TECQUE.get())
                .add(ModBlocks.SPRUCE_GLASS_TECQUE.get())
                .add(ModBlocks.BIRCH_GLASS_TECQUE.get())
                .add(ModBlocks.JUNGLE_GLASS_TECQUE.get())
                .add(ModBlocks.ACACIA_GLASS_TECQUE.get())
                .add(ModBlocks.DARK_OAK_GLASS_TECQUE.get())
                .add(ModBlocks.MANGROVE_GLASS_TECQUE.get())
                .add(ModBlocks.CHERRY_GLASS_TECQUE.get())
                .add(ModBlocks.BAMBOO_GLASS_TECQUE.get())
                .add(ModBlocks.CRIMSON_GLASS_TECQUE.get())
                .add(ModBlocks.WARPED_GLASS_TECQUE.get())

                //Sofa
                .add(ModBlocks.RED_SOFA.get())
                .add(ModBlocks.ORANGE_SOFA.get())
                .add(ModBlocks.YELLOW_SOFA.get())
                .add(ModBlocks.MAGENTA_SOFA.get())
                .add(ModBlocks.PINK_SOFA.get())
                .add(ModBlocks.PURPLE_SOFA.get())
                .add(ModBlocks.BLUE_SOFA.get())
                .add(ModBlocks.CYAN_SOFA.get())
                .add(ModBlocks.LIGHT_BLUE_SOFA.get())
                .add(ModBlocks.GREEN_SOFA.get())
                .add(ModBlocks.LIME_SOFA.get())
                .add(ModBlocks.GREY_SOFA.get())
                .add(ModBlocks.LIGHT_GREY_SOFA.get())
                .add(ModBlocks.BLACK_SOFA.get())
                .add(ModBlocks.WITHE_SOFA.get())
                .add(ModBlocks.BROWN_SOFA.get())

                //Shelf
                .add(ModBlocks.OAK_SHELF.get())
                .add(ModBlocks.SPRUCE_SHELF.get())
                .add(ModBlocks.BIRCH_SHELF.get())
                .add(ModBlocks.JUNGLE_SHELF.get())
                .add(ModBlocks.ACACIA_SHELF.get())
                .add(ModBlocks.DARK_OAK_SHELF.get())
                .add(ModBlocks.MANGROVE_SHELF.get())
                .add(ModBlocks.CHERRY_SHELF.get())
                .add(ModBlocks.BAMBOO_SHELF.get())
                .add(ModBlocks.CRIMSON_SHELF.get())
                .add(ModBlocks.WARPED_SHELF.get())


                //Coffee Table
                .add(ModBlocks.OAK_COFFEE_TABLE.get())
                .add(ModBlocks.SPRUCE_COFFEE_TABLE.get())
                .add(ModBlocks.BIRCH_COFFEE_TABLE.get())
                .add(ModBlocks.JUNGLE_COFFEE_TABLE.get())
                .add(ModBlocks.ACACIA_COFFEE_TABLE.get())
                .add(ModBlocks.DARK_OAK_COFFEE_TABLE.get())
                .add(ModBlocks.MANGROVE_COFFEE_TABLE.get())
                .add(ModBlocks.CHERRY_COFFEE_TABLE.get())
                .add(ModBlocks.BAMBOO_COFFEE_TABLE.get())
                .add(ModBlocks.CRIMSON_COFFEE_TABLE.get())
                .add(ModBlocks.WARPED_COFFEE_TABLE.get())

                 //Dinning Table
                .add(ModBlocks.OAK_DINNING_TABLE.get())
                .add(ModBlocks.SPRUCE_DINNING_TABLE.get())
                .add(ModBlocks.BIRCH_DINNING_TABLE.get())
                .add(ModBlocks.JUNGLE_DINNING_TABLE.get())
                .add(ModBlocks.ACACIA_DINNING_TABLE.get())
                .add(ModBlocks.DARK_OAK_DINNING_TABLE.get())
                .add(ModBlocks.MANGROVE_DINNING_TABLE.get())
                .add(ModBlocks.CHERRY_DINNING_TABLE.get())
                .add(ModBlocks.BAMBOO_DINNING_TABLE.get())
                .add(ModBlocks.CRIMSON_DINNING_TABLE.get())
                .add(ModBlocks.WARPED_DINNING_TABLE.get())



        //Counter
                .add(ModBlocks.OAK_KITCHEN_COUNTER.get())
                .add(ModBlocks.SPRUCE_KITCHEN_COUNTER.get())
                .add(ModBlocks.BIRCH_KITCHEN_COUNTER.get())
                .add(ModBlocks.JUNGLE_KITCHEN_COUNTER.get())
                .add(ModBlocks.ACACIA_KITCHEN_COUNTER.get())
                .add(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get())
                .add(ModBlocks.MANGROVE_KITCHEN_COUNTER.get())
                .add(ModBlocks.CHERRY_KITCHEN_COUNTER.get())
                .add(ModBlocks.BAMBOO_KITCHEN_COUNTER.get())
                .add(ModBlocks.CRIMSON_KITCHEN_COUNTER.get())
                .add(ModBlocks.WARPED_KITCHEN_COUNTER.get())
        //Drawer
                .add(ModBlocks.OAK_KITCHEN_DRAWER.get())
                .add(ModBlocks.SPRUCE_KITCHEN_DRAWER.get())
                .add(ModBlocks.BIRCH_KITCHEN_DRAWER.get())
                .add(ModBlocks.JUNGLE_KITCHEN_DRAWER.get())
                .add(ModBlocks.ACACIA_KITCHEN_DRAWER.get())
                .add(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get())
                .add(ModBlocks.MANGROVE_KITCHEN_DRAWER.get())
                .add(ModBlocks.CHERRY_KITCHEN_DRAWER.get())
                .add(ModBlocks.BAMBOO_KITCHEN_DRAWER.get())
                .add(ModBlocks.CRIMSON_KITCHEN_DRAWER.get())
                .add(ModBlocks.WARPED_KITCHEN_DRAWER.get())
        //Cabinet
                .add(ModBlocks.OAK_CABINET.get())
                .add(ModBlocks.SPRUCE_CABINET.get())
                .add(ModBlocks.BIRCH_CABINET.get())
                .add(ModBlocks.JUNGLE_CABINET.get())
                .add(ModBlocks.ACACIA_CABINET.get())
                .add(ModBlocks.DARK_OAK_CABINET.get())
                .add(ModBlocks.MANGROVE_CABINET.get())
                .add(ModBlocks.CHERRY_CABINET.get())
                .add(ModBlocks.BAMBOO_CABINET.get())
                .add(ModBlocks.CRIMSON_CABINET.get())
                .add(ModBlocks.WARPED_CABINET.get())
        //Oven
                .add(ModBlocks.OAK_OVEN.get())
                .add(ModBlocks.SPRUCE_OVEN.get())
                .add(ModBlocks.BIRCH_OVEN.get())
                .add(ModBlocks.JUNGLE_OVEN.get())
                .add(ModBlocks.ACACIA_OVEN.get())
                .add(ModBlocks.DARK_OAK_OVEN.get())
                .add(ModBlocks.MANGROVE_OVEN.get())
                .add(ModBlocks.CHERRY_OVEN.get())
                .add(ModBlocks.BAMBOO_OVEN.get())
                .add(ModBlocks.CRIMSON_OVEN.get())
                .add(ModBlocks.WARPED_OVEN.get())
                .add(ModBlocks.FURNI_WORKBENCH.get())

                .add(ModBlocks.OAK_CUTTING_BOARD.get())
                .add(ModBlocks.SPRUCE_CUTTING_BOARD.get())
                .add(ModBlocks.BIRCH_CUTTING_BOARD.get())
                .add(ModBlocks.JUNGLE_CUTTING_BOARD.get())
                .add(ModBlocks.ACACIA_CUTTING_BOARD.get())
                .add(ModBlocks.MANGROVE_CUTTING_BOARD.get())
                .add(ModBlocks.DARK_OAK_CUTTING_BOARD.get())
                .add(ModBlocks.CHERRY_CUTTING_BOARD.get())
                .add(ModBlocks.BAMBOO_CUTTING_BOARD.get())
                .add(ModBlocks.CRIMSON_CUTTING_BOARD.get())
                .add(ModBlocks.WARPED_CUTTING_BOARD.get())


                .add(ModBlocks.OAK_JAR.get())
                .add(ModBlocks.SPRUCE_JAR.get())
                .add(ModBlocks.BIRCH_JAR.get())
                .add(ModBlocks.JUNGLE_JAR.get())
                .add(ModBlocks.ACACIA_JAR.get())
                .add(ModBlocks.MANGROVE_JAR.get())
                .add(ModBlocks.DARK_OAK_JAR.get())
                .add(ModBlocks.CHERRY_JAR.get())
                .add(ModBlocks.BAMBOO_JAR.get())
                .add(ModBlocks.CRIMSON_JAR.get())
                .add(ModBlocks.WARPED_JAR.get())

                 ;

          tag(BlockTags.MINEABLE_WITH_PICKAXE)
                  .add(ModBlocks.PEDESTAL.get())
                  .add(ModBlocks.STONE_PEDESTAL.get())
                  .add(ModBlocks.BLACKSTONE_PEDESTAL.get())
                  .add(ModBlocks.DIORITE_PEDESTAL.get())
                  .add(ModBlocks.GRANITE_PEDESTAL.get())
                  .add(ModBlocks.DEEPSLATE_TILE_PEDESTAL.get())
                  .add(ModBlocks.DEEPSLATE_PEDESTAL.get())

                  //Andesite

                  .add(ModBlocks.STONE_GLASS_TECQUE.get())

                  //Pedestal
                  .add(ModBlocks.PEDESTAL.get())
                  .add(ModBlocks.STONE_PEDESTAL.get())
                  .add(ModBlocks.DIORITE_PEDESTAL.get())
                  .add(ModBlocks.GRANITE_PEDESTAL.get())
                  .add(ModBlocks.DEEPSLATE_PEDESTAL.get())
                  .add(ModBlocks.DEEPSLATE_TILE_PEDESTAL.get())
                  .add(ModBlocks.BLACKSTONE_PEDESTAL.get())



          //Clock

                  .add(ModBlocks.RED_DIGITAL_CLOCK.get())
                  .add(ModBlocks.ORANGE_DIGITAL_CLOCK.get())
                  .add(ModBlocks.YELLOW_DIGITAL_CLOCK.get())
                  .add(ModBlocks.MAGENTA_DIGITAL_CLOCK.get())
                  .add(ModBlocks.PINK_DIGITAL_CLOCK.get())
                  .add(ModBlocks.PURPLE_DIGITAL_CLOCK.get())
                  .add(ModBlocks.BLUE_DIGITAL_CLOCK.get())
                  .add(ModBlocks.CYAN_DIGITAL_CLOCK.get())
                  .add(ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get())
                  .add(ModBlocks.GREEN_DIGITAL_CLOCK.get())
                  .add(ModBlocks.LIME_DIGITAL_CLOCK.get())
                  .add(ModBlocks.GRAY_DIGITAL_CLOCK.get())
                  .add(ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get())
                  .add(ModBlocks.BLACK_DIGITAL_CLOCK.get())
                  .add(ModBlocks.WHITE_DIGITAL_CLOCK.get())
                  .add(ModBlocks.BROWN_DIGITAL_CLOCK.get())

          //Stool
                  .add(ModBlocks.RED_STOOL.get())
                  .add(ModBlocks.ORANGE_STOOL.get())
                  .add(ModBlocks.YELLOW_STOOL.get())
                  .add(ModBlocks.MAGENTA_STOOL.get())
                  .add(ModBlocks.PINK_STOOL.get())
                  .add(ModBlocks.PURPLE_STOOL.get())
                  .add(ModBlocks.BLUE_STOOL.get())
                  .add(ModBlocks.CYAN_STOOL.get())
                  .add(ModBlocks.LIGHT_BLUE_STOOL.get())
                  .add(ModBlocks.GREEN_STOOL.get())
                  .add(ModBlocks.LIME_STOOL.get())
                  .add(ModBlocks.GREY_STOOL.get())
                  .add(ModBlocks.LIGHT_GREY_STOOL.get())
                  .add(ModBlocks.BLACK_STOOL.get())
                  .add(ModBlocks.WITHE_STOOL.get())
                  .add(ModBlocks.BROWN_STOOL.get())

                  .add(ModBlocks.LIGHT_MICROWAVE.get())
                  .add(ModBlocks.DARK_MICROWAVE.get())


          ;



    }
}
