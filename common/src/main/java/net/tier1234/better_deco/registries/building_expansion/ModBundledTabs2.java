package net.tier1234.better_deco.registries.building_expansion;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.tier1234.better_deco.creative_tabs.BundledTabs;

import java.util.ArrayList;
import java.util.List;

public class ModBundledTabs2 {
    private static final List<BundledTabs> FILTERS = new ArrayList<>();

    public static final BundledTabs MISCELLANEOUS = register(BundledTabs.builder()
            .icon(new ItemStack(Blocks.CHEST))
            .title(Component.translatable("bundled_tab.miscellaneous.title"))
            .displayItems((parameters, output)->{
                output.accept(Blocks.CHEST);
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
