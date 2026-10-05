package net.tier1234.better_deco.registries;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.creative_tabs.BundledTabs;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ModCreativeTabs {
    
    public static final ObjectRegistries<CreativeModeTab> BETTER_DECO = ObjectRegistries.registerCreativeTab(Constants.id("better_deco"),
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
                    .title(Component.translatable("creativetab.better_deco.better_deco"))
                    .icon(() -> new ItemStack(ModBlocks.OAK_CHAIR.get()))
                    .displayItems((parameters,output)-> {
                        var provider = parameters.holders();
                        List<BundledTabs> filters = ModBundledTabs.getFilters();
                        filters.forEach(tab -> tab.populate(provider));

                        Set<Item> seen = new HashSet<>();
                        filters.stream()
                                .flatMap(filter -> filter.getDisplayItems().stream())
                                .forEach(stack -> {
                                    if (seen.add(stack.getItem())) {
                                        output.accept(stack);
                                    }
                                });
                    })

                    .build());



    public static void init() {}
}
