package net.tier1234.better_deco.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.creative_tabs.BundledTabs;
import net.tier1234.better_deco.util.ModTags;

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
                        output.accept(ModTags.Items.GENERAL);
                    }))
                    .build());

    public static final BundledTabs ITEMS = register(BundledTabs.builder()
            .title(Component.translatable("bundled_tabs.item"))
            .icon(new ItemStack(ModItems.KITCHEN_KNIFE.get()))
            .displayItems((provider, output) -> {
                output.accept(ModItems.KITCHEN_KNIFE.get());
            })
            .build());

    public static final BundledTabs KITCHEN = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.kitchen"))
                    .icon(new ItemStack(ModBlocks.OAK_KITCHEN_COUNTER.get()))
                    .displayItems((provider, output) -> {
                        output.accept(ModTags.Items.KITCHEN);
                    })
                    .build());



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
                            .build());


    public static final BundledTabs BEDROOM = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.bedroom_furniture.title"))
                    .icon(new ItemStack(ModBlocks.OAK_BEDSIDE.get()))
                    .displayItems((provider, output) -> {
                        output.accept(ModTags.Items.BEDROOM);
                    })
                    .build());



    public static final BundledTabs OFFICE = register(
            BundledTabs.builder()
                    .icon(new ItemStack(ModBlocks.OAK_DESK.get()))
                    .title(Component.translatable("bundled_tab.office.title"))
                    .displayItems((provider, output) -> {
                        output.accept(ModTags.Items.OFFICE);
                    })
                    .build());


    public static final BundledTabs BATHROOM = register(
            BundledTabs.builder()
                    .title(Component.translatable("bundled_tab.bathroom_furniture.title"))
                    .icon(new ItemStack(ModBlocks.OAK_BASIN.get()))
                    .displayItems((provider, output) -> {
                        output.accept(ModTags.Items.BATHROOM);
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
