package net.tier1234.better_deco.compat.everycomp;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mehvahdjukaar.every_compat.ECRegistry;
import net.mehvahdjukaar.every_compat.api.PaletteStrategies;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.modules.EveryCompatModule;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.custom.KitchenCounterBlock;
import net.tier1234.better_deco.block.custom.KitchenDrawerBlock;
import net.tier1234.better_deco.creative_tabs.BundledTabs;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModBundledTabs;

public class FabricEveryCompatModule extends EveryCompatModule {
    public final SimpleEntrySet<WoodType, KitchenCounterBlock> kitchenCounter;
    public final SimpleEntrySet<WoodType, KitchenDrawerBlock> kitchenDrawer;
    private static  FabricEveryCompatModule INSTANCE;



    public FabricEveryCompatModule() {
        super(Constants.MOD_ID, Constants.MOD_ID);
        INSTANCE = this;
        kitchenCounter = SimpleEntrySet.builder(WoodType.class, "kitchen_counter",
                        () -> ModBlocks.OAK_KITCHEN_COUNTER.get(),
                        () -> VanillaWoodTypes.OAK,
                        w -> new KitchenCounterBlock(Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/furniture/kitchen/wodden/oak/oak_kitchen_counter"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        kitchenDrawer = SimpleEntrySet.builder(WoodType.class, "kitchen_drawer",
                        () -> ModBlocks.OAK_KITCHEN_DRAWER.get(),
                        () -> VanillaWoodTypes.OAK,
                        w-> new KitchenDrawerBlock(Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/furniture/kitchen/wodden/oak/oak_kitchen_drawer"), PaletteStrategies.PLANKS_STANDARD)
                .addTile(getModTile("kitchen_drawer"))
                .noTab()
                .build();


        this.addEntry(kitchenCounter);
        this.addEntry(kitchenDrawer);
    }

    /**
     * Class where registered the Custom filter tab for registering all the custom blocks
     * created with everycompat: It also features the event register
     * */
    public static class EveryCompatCreativeTabRegister {

        public static final BundledTabs EVERYCOMPAT_TAB = ModBundledTabs.register(
                BundledTabs.builder()
                        .icon(ECRegistry.ALL_WOODS.get().getDefaultInstance())
                        .title(Component.translatable("bundled_tab.everycompat"))
                        .displayItems((parameters, output) -> {
                            FabricEveryCompatModule module = getModuleInstance();

                            /**
                             * Method to register all entries, I don't think i'll use that cause i'd like to register
                             * my blocks with my logic*/
                            if (module != null) {
                                module.getEntries().forEach(entry -> {
                                    if (entry instanceof SimpleEntrySet<?, ?> entrySet) {
                                        entrySet.blocks.values().forEach(block -> {
                                            output.accept(block.asItem());
                                        });
                                    }
                                });
                            }

                                    /* if (module != null) {
                                        module.kitchenCounter.blocks.forEach((woodType, block) -> {
                                            output.accept(block.asItem());
                                        });

                                    }*/
                        })
                        .build()
        );

        private static FabricEveryCompatModule getModuleInstance() {
            return FabricEveryCompatModule.INSTANCE;
        }


        public static void register(CreativeModeTab creativeModeTab, FabricItemGroupEntries fabricItemGroupEntries) {

        }
    }
    /**
     * Event where the tab is registered and initializated
     **/

    public static void register() {
        EveryCompatCreativeTabRegister.EVERYCOMPAT_TAB.toString();
        ItemGroupEvents.MODIFY_ENTRIES_ALL.register(EveryCompatCreativeTabRegister::register);

    }
}