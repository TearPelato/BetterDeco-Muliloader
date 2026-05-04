package net.tier1234.better_deco.init;


import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.creative_tabs.BundledTabs;

import java.util.List;
@RegistryContainer

public class ModCreativeTabs {
   public static final RegistryEntry<CreativeModeTab> BETTER_DECO = RegistryEntry.creativeModeTab(
           Constants.id("better_deco"), builder -> {
                       builder.alignedRight();
                       builder.title(Component.translatable("creativetab.better_deco.better_deco"));
                       builder.icon(() -> new ItemStack(ModBlocks.OAK_CHAIR.get()));
                       builder.displayItems((parameters, output) -> {
                           var provider = parameters.holders();
                           List<BundledTabs> filters = ModBundledTabs.getFilters();
                           filters.forEach(tab -> tab.populate(provider));
                           filters.stream()
                                   .flatMap(filter -> filter.getDisplayItems().stream())
                                   .forEach(output::accept);
                       });
           });

}
