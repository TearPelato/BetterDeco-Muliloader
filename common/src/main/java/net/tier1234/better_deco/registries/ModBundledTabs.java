package net.tier1234.better_deco.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.creative_tabs.BundledTabs;

import java.util.ArrayList;
import java.util.List;

/**
 * BundledTabs from VanillaBackport, used with BlackGear's permission.
 * @author BlackGear
 */
public class ModBundledTabs {
    private static final List<BundledTabs> FILTERS = new ArrayList<>();

    public static final BundledTabs GENERALS = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.general"))
                    .icon(new ItemStack(ModBlocks.OAK_CHAIR.get()))
                    .displayItems(((provider, output) -> {
                        output.accept(ModBlocks.WORKBENCH.get());

                        output.accept(ModBlocks.OAK_CHAIR.get());
                        output.accept(ModBlocks.SPRUCE_CHAIR.get());
                        output.accept(ModBlocks.BIRCH_CHAIR.get());
                        output.accept(ModBlocks.JUNGLE_CHAIR.get());
                        output.accept(ModBlocks.ACACIA_CHAIR.get());
                        output.accept(ModBlocks.DARK_OAK_CHAIR.get());
                        output.accept(ModBlocks.MANGROVE_CHAIR.get());
                        output.accept(ModBlocks.CHERRY_CHAIR.get());
                        output.accept(ModBlocks.BAMBOO_CHAIR.get());
                        output.accept(ModBlocks.CRIMSON_CHAIR.get());
                        output.accept(ModBlocks.WARPED_CHAIR.get());

                        output.accept(ModBlocks.OAK_BASIC_TABLE.get());
                        output.accept(ModBlocks.SPRUCE_BASIC_TABLE.get());
                        output.accept(ModBlocks.BIRCH_BASIC_TABLE.get());
                        output.accept(ModBlocks.JUNGLE_BASIC_TABLE.get());
                        output.accept(ModBlocks.ACACIA_BASIC_TABLE.get());
                        output.accept(ModBlocks.DARK_OAK_BASIC_TABLE.get());
                        output.accept(ModBlocks.MANGROVE_BASIC_TABLE.get());
                        output.accept(ModBlocks.CHERRY_BASIC_TABLE.get());
                        output.accept(ModBlocks.BAMBOO_BASIC_TABLE.get());
                        output.accept(ModBlocks.CRIMSON_BASIC_TABLE.get());
                        output.accept(ModBlocks.WARPED_BASIC_TABLE.get());

                        output.accept(ModBlocks.OAK_TABLE.get());
                        output.accept(ModBlocks.SPRUCE_TABLE.get());
                        output.accept(ModBlocks.BIRCH_TABLE.get());
                        output.accept(ModBlocks.JUNGLE_TABLE.get());
                        output.accept(ModBlocks.ACACIA_TABLE.get());
                        output.accept(ModBlocks.DARK_OAK_TABLE.get());
                        output.accept(ModBlocks.MANGROVE_TABLE.get());
                        output.accept(ModBlocks.CHERRY_TABLE.get());
                        output.accept(ModBlocks.BAMBOO_TABLE.get());
                        output.accept(ModBlocks.CRIMSON_TABLE.get());
                        output.accept(ModBlocks.WARPED_TABLE.get());

                        output.accept(ModBlocks.WHITE_SOFA.get());
                        output.accept(ModBlocks.LIGHT_GREY_SOFA.get());
                        output.accept(ModBlocks.GREY_SOFA.get());
                        output.accept(ModBlocks.BLACK_SOFA.get());
                        output.accept(ModBlocks.RED_SOFA.get());
                        output.accept(ModBlocks.ORANGE_SOFA.get());
                        output.accept(ModBlocks.YELLOW_SOFA.get());
                        output.accept(ModBlocks.LIME_SOFA.get());
                        output.accept(ModBlocks.GREEN_SOFA.get());
                        output.accept(ModBlocks.CYAN_SOFA.get());
                        output.accept(ModBlocks.LIGHT_BLUE_SOFA.get());
                        output.accept(ModBlocks.BLUE_SOFA.get());
                        output.accept(ModBlocks.PURPLE_SOFA.get());
                        output.accept(ModBlocks.MAGENTA_SOFA.get());
                        output.accept(ModBlocks.PINK_SOFA.get());
                        output.accept(ModBlocks.BROWN_SOFA.get());

                        output.accept(ModBlocks.OAK_COFFEE_TABLE.get());
                        output.accept(ModBlocks.SPRUCE_COFFEE_TABLE.get());
                        output.accept(ModBlocks.BIRCH_COFFEE_TABLE.get());
                        output.accept(ModBlocks.JUNGLE_COFFEE_TABLE.get());
                        output.accept(ModBlocks.ACACIA_COFFEE_TABLE.get());
                        output.accept(ModBlocks.DARK_OAK_COFFEE_TABLE.get());
                        output.accept(ModBlocks.MANGROVE_COFFEE_TABLE.get());
                        output.accept(ModBlocks.CHERRY_COFFEE_TABLE.get());
                        output.accept(ModBlocks.BAMBOO_COFFEE_TABLE.get());
                        output.accept(ModBlocks.CRIMSON_COFFEE_TABLE.get());
                        output.accept(ModBlocks.WARPED_COFFEE_TABLE.get());

                        output.accept(ModBlocks.WITHE_STOOL.get());
                        output.accept(ModBlocks.LIGHT_GREY_STOOL.get());
                        output.accept(ModBlocks.GREY_STOOL.get());
                        output.accept(ModBlocks.BLACK_STOOL.get());
                        output.accept(ModBlocks.RED_STOOL.get());
                        output.accept(ModBlocks.ORANGE_STOOL.get());
                        output.accept(ModBlocks.YELLOW_STOOL.get());
                        output.accept(ModBlocks.LIME_STOOL.get());
                        output.accept(ModBlocks.GREEN_STOOL.get());
                        output.accept(ModBlocks.CYAN_STOOL.get());
                        output.accept(ModBlocks.LIGHT_BLUE_STOOL.get());
                        output.accept(ModBlocks.BLUE_STOOL.get());
                        output.accept(ModBlocks.PURPLE_STOOL.get());
                        output.accept(ModBlocks.MAGENTA_STOOL.get());
                        output.accept(ModBlocks.PINK_STOOL.get());
                        output.accept(ModBlocks.BROWN_STOOL.get());

                    }))
                    .build());

    public static final BundledTabs ITEMS = register(BundledTabs.builder()
            .title(Component.translatable("bundled_tabs.item"))
            .icon(new ItemStack(ModItems.KITCHEN_KNIFE.get()))
            .displayItems(((provider, output) -> {
                output.accept(ModItems.KITCHEN_KNIFE.get());
            }))
            .build());

    public static final BundledTabs KITCHEN = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.kitchen"))
                    .icon(new ItemStack(ModBlocks.OAK_KITCHEN_COUNTER.get()))
                    .displayItems((provider, output) -> {
                        output.accept(ModBlocks.OAK_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.SPRUCE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.BIRCH_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.JUNGLE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.ACACIA_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.MANGROVE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.CHERRY_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.BAMBOO_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.CRIMSON_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.WARPED_KITCHEN_COUNTER.get());

                        output.accept(ModBlocks.OAK_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.SPRUCE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.BIRCH_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.JUNGLE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.ACACIA_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.MANGROVE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.CHERRY_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.BAMBOO_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.CRIMSON_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.WARPED_KITCHEN_DRAWER.get());

                        output.accept(ModBlocks.OAK_OVEN.get());
                        output.accept(ModBlocks.SPRUCE_OVEN.get());
                        output.accept(ModBlocks.BIRCH_OVEN.get());
                        output.accept(ModBlocks.JUNGLE_OVEN.get());
                        output.accept(ModBlocks.ACACIA_OVEN.get());
                        output.accept(ModBlocks.DARK_OAK_OVEN.get());
                        output.accept(ModBlocks.MANGROVE_OVEN.get());
                        output.accept(ModBlocks.CHERRY_OVEN.get());
                        output.accept(ModBlocks.BAMBOO_OVEN.get());
                        output.accept(ModBlocks.CRIMSON_OVEN.get());
                        output.accept(ModBlocks.WARPED_OVEN.get());

                        output.accept(ModBlocks.OAK_SINK.get());
                        output.accept(ModBlocks.SPRUCE_SINK.get());
                        output.accept(ModBlocks.BIRCH_SINK.get());
                        output.accept(ModBlocks.JUNGLE_SINK.get());
                        output.accept(ModBlocks.ACACIA_SINK.get());
                        output.accept(ModBlocks.DARK_OAK_SINK.get());
                        output.accept(ModBlocks.MANGROVE_SINK.get());
                        output.accept(ModBlocks.CHERRY_SINK.get());
                        output.accept(ModBlocks.BAMBOO_SINK.get());
                        output.accept(ModBlocks.CRIMSON_SINK.get());
                        output.accept(ModBlocks.WARPED_SINK.get());

                        output.accept(ModBlocks.OAK_CABINET.get());
                        output.accept(ModBlocks.SPRUCE_CABINET.get());
                        output.accept(ModBlocks.BIRCH_CABINET.get());
                        output.accept(ModBlocks.JUNGLE_CABINET.get());
                        output.accept(ModBlocks.ACACIA_CABINET.get());
                        output.accept(ModBlocks.DARK_OAK_CABINET.get());
                        output.accept(ModBlocks.MANGROVE_CABINET.get());
                        output.accept(ModBlocks.CHERRY_CABINET.get());
                        output.accept(ModBlocks.BAMBOO_CABINET.get());
                        output.accept(ModBlocks.CRIMSON_CABINET.get());
                        output.accept(ModBlocks.WARPED_CABINET.get());

                        output.accept(ModBlocks.WHITE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.GRAY_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.BLACK_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.BROWN_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.RED_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.ORANGE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.YELLOW_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.LIME_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.GREEN_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.CYAN_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.BLUE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.PURPLE_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.MAGENTA_KITCHEN_COUNTER.get());
                        output.accept(ModBlocks.PINK_KITCHEN_COUNTER.get());



                        output.accept(ModBlocks.WHITE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.GRAY_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.BLACK_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.BROWN_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.RED_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.ORANGE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.YELLOW_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.LIME_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.GREEN_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.CYAN_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.BLUE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.PURPLE_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.MAGENTA_KITCHEN_DRAWER.get());
                        output.accept(ModBlocks.PINK_KITCHEN_DRAWER.get());

                        output.accept(ModBlocks.WHITE_OVEN.get());
                        output.accept(ModBlocks.LIGHT_GRAY_OVEN.get());
                        output.accept(ModBlocks.GRAY_OVEN.get());
                        output.accept(ModBlocks.BLACK_OVEN.get());
                        output.accept(ModBlocks.BROWN_OVEN.get());
                        output.accept(ModBlocks.RED_OVEN.get());
                        output.accept(ModBlocks.ORANGE_OVEN.get());
                        output.accept(ModBlocks.YELLOW_OVEN.get());
                        output.accept(ModBlocks.LIME_OVEN.get());
                        output.accept(ModBlocks.GREEN_OVEN.get());
                        output.accept(ModBlocks.CYAN_OVEN.get());
                        output.accept(ModBlocks.LIGHT_BLUE_OVEN.get());
                        output.accept(ModBlocks.BLUE_OVEN.get());
                        output.accept(ModBlocks.PURPLE_OVEN.get());
                        output.accept(ModBlocks.MAGENTA_OVEN.get());
                        output.accept(ModBlocks.PINK_OVEN.get());


                        output.accept(ModBlocks.WHITE_SINK.get());
                        output.accept(ModBlocks.LIGHT_GRAY_SINK.get());
                        output.accept(ModBlocks.GRAY_SINK.get());
                        output.accept(ModBlocks.BLACK_SINK.get());
                        output.accept(ModBlocks.BROWN_SINK.get());
                        output.accept(ModBlocks.RED_SINK.get());
                        output.accept(ModBlocks.ORANGE_SINK.get());
                        output.accept(ModBlocks.YELLOW_SINK.get());
                        output.accept(ModBlocks.LIME_SINK.get());
                        output.accept(ModBlocks.GREEN_SINK.get());
                        output.accept(ModBlocks.CYAN_SINK.get());
                        output.accept(ModBlocks.LIGHT_BLUE_SINK.get());
                        output.accept(ModBlocks.BLUE_SINK.get());
                        output.accept(ModBlocks.PURPLE_SINK.get());
                        output.accept(ModBlocks.MAGENTA_SINK.get());
                        output.accept(ModBlocks.PINK_SINK.get());


                        output.accept(ModBlocks.WHITE_CABINET.get());
                        output.accept(ModBlocks.LIGHT_GRAY_CABINET.get());
                        output.accept(ModBlocks.GRAY_CABINET.get());
                        output.accept(ModBlocks.BLACK_CABINET.get());
                        output.accept(ModBlocks.BROWN_CABINET.get());
                        output.accept(ModBlocks.RED_CABINET.get());
                        output.accept(ModBlocks.ORANGE_CABINET.get());
                        output.accept(ModBlocks.YELLOW_CABINET.get());
                        output.accept(ModBlocks.LIME_CABINET.get());
                        output.accept(ModBlocks.GREEN_CABINET.get());
                        output.accept(ModBlocks.CYAN_CABINET.get());
                        output.accept(ModBlocks.LIGHT_BLUE_CABINET.get());
                        output.accept(ModBlocks.BLUE_CABINET.get());
                        output.accept(ModBlocks.PURPLE_CABINET.get());
                        output.accept(ModBlocks.MAGENTA_CABINET.get());
                        output.accept(ModBlocks.PINK_CABINET.get());

                        output.accept(ModBlocks.OAK_CUTTING_BOARD.get());
                        output.accept(ModBlocks.SPRUCE_CUTTING_BOARD.get());
                        output.accept(ModBlocks.BIRCH_CUTTING_BOARD.get());
                        output.accept(ModBlocks.JUNGLE_CUTTING_BOARD.get());
                        output.accept(ModBlocks.ACACIA_CUTTING_BOARD.get());
                        output.accept(ModBlocks.DARK_OAK_CUTTING_BOARD.get());
                        output.accept(ModBlocks.MANGROVE_CUTTING_BOARD.get());
                        output.accept(ModBlocks.CHERRY_CUTTING_BOARD.get());
                        output.accept(ModBlocks.BAMBOO_CUTTING_BOARD.get());
                        output.accept(ModBlocks.CRIMSON_CUTTING_BOARD.get());
                        output.accept(ModBlocks.WARPED_CUTTING_BOARD.get());

                        output.accept(ModBlocks.OAK_JAR.get());
                        output.accept(ModBlocks.SPRUCE_JAR.get());
                        output.accept(ModBlocks.BIRCH_JAR.get());
                        output.accept(ModBlocks.JUNGLE_JAR.get());
                        output.accept(ModBlocks.ACACIA_JAR.get());
                        output.accept(ModBlocks.DARK_OAK_JAR.get());
                        output.accept(ModBlocks.MANGROVE_JAR.get());
                        output.accept(ModBlocks.CHERRY_JAR.get());
                        output.accept(ModBlocks.BAMBOO_JAR.get());
                        output.accept(ModBlocks.CRIMSON_JAR.get());
                        output.accept(ModBlocks.WARPED_JAR.get());

                        output.accept(ModBlocks.FRIDGE_LIGHT.get());
                        output.accept(ModBlocks.FRIDGE_DARK.get());

                        output.accept(ModBlocks.LIGHT_MICROWAVE.get());
                        output.accept(ModBlocks.DARK_MICROWAVE.get());

                        output.accept(ModBlocks.TOASTER_DARK.get());
                        output.accept(ModBlocks.TOASTER_LIGHT.get());




                    })
                    .build()
    );


    public static final BundledTabs FURNITURE_EXTRAS = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.utilities.title"))
                    .icon(new ItemStack(ModBlocks.OAK_CRATE.get()))
                    .displayItems((provider, output) -> {


                        output.accept(ModBlocks.OAK_SHELF.get());
                        output.accept(ModBlocks.SPRUCE_SHELF.get());
                        output.accept(ModBlocks.BIRCH_SHELF.get());
                        output.accept(ModBlocks.JUNGLE_SHELF.get());
                        output.accept(ModBlocks.ACACIA_SHELF.get());
                        output.accept(ModBlocks.DARK_OAK_SHELF.get());
                        output.accept(ModBlocks.MANGROVE_SHELF.get());
                        output.accept(ModBlocks.CHERRY_SHELF.get());
                        output.accept(ModBlocks.BAMBOO_SHELF.get());
                        output.accept(ModBlocks.CRIMSON_SHELF.get());
                        output.accept(ModBlocks.WARPED_SHELF.get());

                        output.accept(ModBlocks.PEDESTAL.get());
                        output.accept(ModBlocks.STONE_PEDESTAL.get());
                        output.accept(ModBlocks.DIORITE_PEDESTAL.get());
                        output.accept(ModBlocks.GRANITE_PEDESTAL.get());
                        output.accept(ModBlocks.DEEPSLATE_PEDESTAL.get());
                        output.accept(ModBlocks.DEEPSLATE_TILE_PEDESTAL.get());
                        output.accept(ModBlocks.BLACKSTONE_PEDESTAL.get());

                        output.accept(ModBlocks.STONE_GLASS_TECQUE.get());

                        output.accept(ModBlocks.OAK_GLASS_TECQUE.get());
                        output.accept(ModBlocks.SPRUCE_GLASS_TECQUE.get());
                        output.accept(ModBlocks.BIRCH_GLASS_TECQUE.get());
                        output.accept(ModBlocks.JUNGLE_GLASS_TECQUE.get());
                        output.accept(ModBlocks.ACACIA_GLASS_TECQUE.get());
                        output.accept(ModBlocks.MANGROVE_GLASS_TECQUE.get());
                        output.accept(ModBlocks.DARK_OAK_GLASS_TECQUE.get());
                        output.accept(ModBlocks.CHERRY_GLASS_TECQUE.get());
                        output.accept(ModBlocks.BAMBOO_GLASS_TECQUE.get());
                        output.accept(ModBlocks.CRIMSON_GLASS_TECQUE.get());
                        output.accept(ModBlocks.WARPED_GLASS_TECQUE.get());
                    })
                    .build()
    );



    public static final BundledTabs EXTERNAL_DECORATIONS = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.external_deco"))
                    .icon(new ItemStack(ModBlocks.OAK_PARK_BENCH.get()))
                    .displayItems((provider, output) -> {
                        output.accept(ModBlocks.OAK_CRATE.get());
                        output.accept(ModBlocks.SPRUCE_CRATE.get());
                        output.accept(ModBlocks.BIRCH_CRATE.get());
                        output.accept(ModBlocks.JUNGLE_CRATE.get());
                        output.accept(ModBlocks.ACACIA_CRATE.get());
                        output.accept(ModBlocks.MANGROVE_CRATE.get());
                        output.accept(ModBlocks.DARK_OAK_CRATE.get());
                        output.accept(ModBlocks.CHERRY_CRATE.get());
                        output.accept(ModBlocks.BAMBOO_CRATE.get());
                        output.accept(ModBlocks.CRIMSON_CRATE.get());
                        output.accept(ModBlocks.WARPED_CRATE.get());

                        output.accept(ModBlocks.OAK_PARK_BENCH.get());
                        output.accept(ModBlocks.SPRUCE_PARK_BENCH.get());
                        output.accept(ModBlocks.BIRCH_PARK_BENCH.get());
                        output.accept(ModBlocks.JUNGLE_PARK_BENCH.get());
                        output.accept(ModBlocks.ACACIA_PARK_BENCH.get());
                        output.accept(ModBlocks.DARK_OAK_PARK_BENCH.get());
                        output.accept(ModBlocks.MANGROVE_PARK_BENCH.get());
                        output.accept(ModBlocks.CHERRY_PARK_BENCH.get());
                        output.accept(ModBlocks.BAMBOO_PARK_BENCH.get());
                        output.accept(ModBlocks.CRIMSON_PARK_BENCH.get());
                        output.accept(ModBlocks.WARPED_PARK_BENCH.get());

                        output.accept(ModBlocks.STONE_PATH.get());


                    })
                            .build()
    );


    public static final BundledTabs BEDROOM = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.bedroom_furniture.title"))
                    .icon(new ItemStack(ModBlocks.OAK_BEDSIDE.get()))
                    .displayItems((provider, output) -> {

                        output.accept(ModBlocks.OAK_DESK.get());
                        output.accept(ModBlocks.SPRUCE_DESK.get());
                        output.accept(ModBlocks.BIRCH_DESK.get());
                        output.accept(ModBlocks.JUNGLE_DESK.get());
                        output.accept(ModBlocks.ACACIA_DESK.get());
                        output.accept(ModBlocks.DARK_OAK_DESK.get());
                        output.accept(ModBlocks.MANGROVE_DESK.get());
                        output.accept(ModBlocks.CHERRY_DESK.get());
                        output.accept(ModBlocks.BAMBOO_DESK.get());
                        output.accept(ModBlocks.CRIMSON_DESK.get());
                        output.accept(ModBlocks.WARPED_DESK.get());

                        output.accept(ModBlocks.OAK_DESK_CABINET.get());
                        output.accept(ModBlocks.SPRUCE_DESK_CABINET.get());
                        output.accept(ModBlocks.BIRCH_DESK_CABINET.get());
                        output.accept(ModBlocks.JUNGLE_DESK_CABINET.get());
                        output.accept(ModBlocks.ACACIA_DESK_CABINET.get());
                        output.accept(ModBlocks.DARK_OAK_DESK_CABINET.get());
                        output.accept(ModBlocks.MANGROVE_DESK_CABINET.get());
                        output.accept(ModBlocks.CHERRY_DESK_CABINET.get());
                        output.accept(ModBlocks.BAMBOO_DESK_CABINET.get());
                        output.accept(ModBlocks.CRIMSON_DESK_CABINET.get());
                        output.accept(ModBlocks.WARPED_DESK_CABINET.get());

                        output.accept(ModBlocks.OAK_BEDSIDE.get());
                        output.accept(ModBlocks.SPRUCE_BEDSIDE.get());
                        output.accept(ModBlocks.BIRCH_BEDSIDE.get());
                        output.accept(ModBlocks.JUNGLE_BEDSIDE.get());
                        output.accept(ModBlocks.ACACIA_BEDSIDE.get());
                        output.accept(ModBlocks.MANGROVE_BEDSIDE.get());
                        output.accept(ModBlocks.DARK_OAK_BEDSIDE.get());
                        output.accept(ModBlocks.CHERRY_BEDSIDE.get());
                        output.accept(ModBlocks.BAMBOO_BEDSIDE.get());
                        output.accept(ModBlocks.CRIMSON_BEDSIDE.get());
                        output.accept(ModBlocks.WARPED_BEDSIDE.get());

                        output.accept(ModBlocks.WHITE_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.GRAY_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.BLACK_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.RED_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.ORANGE_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.YELLOW_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.LIME_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.GREEN_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.CYAN_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.BLUE_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.PURPLE_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.MAGENTA_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.PINK_DIGITAL_CLOCK.get());
                        output.accept(ModBlocks.BROWN_DIGITAL_CLOCK.get());



                    })
                    .build());

    public static final BundledTabs BATHROOM = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.bathroom_furniture.title"))
                    .icon(new ItemStack(ModBlocks.OAK_BASIN.get()))
                    .displayItems((provider, output) -> {

                        output.accept(ModBlocks.OAK_BASIN.get());
                        output.accept(ModBlocks.SPRUCE_BASIN.get());
                        output.accept(ModBlocks.BIRCH_BASIN.get());
                        output.accept(ModBlocks.JUNGLE_BASIN.get());
                        output.accept(ModBlocks.ACACIA_BASIN.get());
                        output.accept(ModBlocks.DARK_OAK_BASIN.get());
                        output.accept(ModBlocks.MANGROVE_BASIN.get());
                        output.accept(ModBlocks.CHERRY_BASIN.get());
                        output.accept(ModBlocks.BAMBOO_BASIN.get());
                        output.accept(ModBlocks.CRIMSON_BASIN.get());
                        output.accept(ModBlocks.WARPED_BASIN.get());

                        output.accept(ModBlocks.OAK_TOILET.get());
                        output.accept(ModBlocks.SPRUCE_TOILET.get());
                        output.accept(ModBlocks.BIRCH_TOILET.get());
                        output.accept(ModBlocks.JUNGLE_TOILET.get());
                        output.accept(ModBlocks.ACACIA_TOILET.get());
                        output.accept(ModBlocks.DARK_OAK_TOILET.get());
                        output.accept(ModBlocks.MANGROVE_TOILET.get());
                        output.accept(ModBlocks.CHERRY_TOILET.get());
                        output.accept(ModBlocks.BAMBOO_TOILET.get());
                        output.accept(ModBlocks.CRIMSON_TOILET.get());
                        output.accept(ModBlocks.WARPED_TOILET.get());

                        output.accept(ModBlocks.OAK_BATH.get());
                        output.accept(ModBlocks.SPRUCE_BATH.get());
                        output.accept(ModBlocks.BIRCH_BATH.get());
                        output.accept(ModBlocks.JUNGLE_BATH.get());
                        output.accept(ModBlocks.ACACIA_BATH.get());
                        output.accept(ModBlocks.DARK_OAK_BATH.get());
                        output.accept(ModBlocks.MANGROVE_BATH.get());
                        output.accept(ModBlocks.CHERRY_BATH.get());
                        output.accept(ModBlocks.BAMBOO_BATH.get());
                        output.accept(ModBlocks.CRIMSON_BATH.get());
                        output.accept(ModBlocks.WARPED_BATH.get());


                    })
                    .build());


    public static BundledTabs register(BundledTabs builder) {
        FILTERS.add(builder);
        return builder;
    }

    public static List<BundledTabs> getFilters() {
        return FILTERS;
    }
}
