package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.registries.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class CommonBlockTagProvider extends TagsProvider<Block> {

    public CommonBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.BLOCK, lookupProvider);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_AXE)



                .add(Constants.getBlockResKey(ModBlocks.OAK_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_CHAIR.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_CHAIR.get()))


                .add(Constants.getBlockResKey(ModBlocks.OAK_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_CRATE.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_CRATE.get()))

                //Bedside
                .add(Constants.getBlockResKey(ModBlocks.OAK_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_BEDSIDE.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_BEDSIDE.get()))

                //Sink
                .add(Constants.getBlockResKey(ModBlocks.OAK_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_SINK.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_SINK.get()))


                //Wooden Tecque
                .add(Constants.getBlockResKey(ModBlocks.OAK_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_GLASS_TECQUE.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_GLASS_TECQUE.get()))

                //Sofa
                .add(Constants.getBlockResKey(ModBlocks.RED_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.ORANGE_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.YELLOW_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.MAGENTA_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.PINK_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.PURPLE_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.BLUE_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.CYAN_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.LIGHT_BLUE_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.GREEN_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.LIME_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.GREY_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.LIGHT_GREY_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.BLACK_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.WHITE_SOFA.get()))
                .add(Constants.getBlockResKey(ModBlocks.BROWN_SOFA.get()))

                //Shelf
                .add(Constants.getBlockResKey(ModBlocks.OAK_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_SHELF.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_SHELF.get()))


                //Coffee Table
                .add(Constants.getBlockResKey(ModBlocks.OAK_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_COFFEE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_COFFEE_TABLE.get()))

                 //Dinning Table
                .add(Constants.getBlockResKey(ModBlocks.OAK_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_TABLE.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_TABLE.get()))



        //Counter
                .add(Constants.getBlockResKey(ModBlocks.OAK_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_KITCHEN_COUNTER.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_KITCHEN_COUNTER.get()))
        //Drawer
                .add(Constants.getBlockResKey(ModBlocks.OAK_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_KITCHEN_DRAWER.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_KITCHEN_DRAWER.get()))
        //Cabinet
                .add(Constants.getBlockResKey(ModBlocks.OAK_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_CABINET.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_CABINET.get()))
        //Oven
                .add(Constants.getBlockResKey(ModBlocks.OAK_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_OVEN.get()))
                .add(Constants.getBlockResKey(ModBlocks.WORKBENCH.get()))

                .add(Constants.getBlockResKey(ModBlocks.OAK_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_CUTTING_BOARD.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_CUTTING_BOARD.get()))


                .add(Constants.getBlockResKey(ModBlocks.OAK_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.SPRUCE_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.BIRCH_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.JUNGLE_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.ACACIA_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.MANGROVE_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.DARK_OAK_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.CHERRY_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.BAMBOO_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.CRIMSON_JAR.get()))
                .add(Constants.getBlockResKey(ModBlocks.WARPED_JAR.get()))

                 ;

          tag(BlockTags.MINEABLE_WITH_PICKAXE)


          //Clock

                  .add(Constants.getBlockResKey(ModBlocks.RED_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.ORANGE_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.YELLOW_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.MAGENTA_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.PINK_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.PURPLE_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.BLUE_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.CYAN_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.GREEN_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.LIME_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.GRAY_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.BLACK_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.WHITE_DIGITAL_CLOCK.get()))
                  .add(Constants.getBlockResKey(ModBlocks.BROWN_DIGITAL_CLOCK.get()))

          //Stool
                  .add(Constants.getBlockResKey(ModBlocks.RED_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.ORANGE_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.YELLOW_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.MAGENTA_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.PINK_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.PURPLE_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.BLUE_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.CYAN_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.LIGHT_BLUE_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.GREEN_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.LIME_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.GREY_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.LIGHT_GREY_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.BLACK_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.WHITE_STOOL.get()))
                  .add(Constants.getBlockResKey(ModBlocks.BROWN_STOOL.get()))

                  .add(Constants.getBlockResKey(ModBlocks.LIGHT_MICROWAVE.get()))
                  .add(Constants.getBlockResKey(ModBlocks.DARK_MICROWAVE.get()))


          ;



    }
}
