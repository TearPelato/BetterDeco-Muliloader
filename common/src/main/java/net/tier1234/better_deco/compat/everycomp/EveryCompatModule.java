package net.tier1234.better_deco.compat.everycomp;



//TODO Everycompat back for multiloader!!
/**@author Tier1234. Using the compat api made by LiukRast, really helpfull for registrating a new custom
 * compatibility with simple and small mods
 **/
//@Compat("everycomp")
public class EveryCompatModule
     //   extends SimpleModule
{
  /*
    public final SimpleEntrySet<WoodType, KitchenCounterBlock> kitchenCounter;
    public final SimpleEntrySet<WoodType, KitchenDrawerBlock> kitchenDrawer;
    private static EveryCompatModule INSTANCE;



    public EveryCompatModule(IEventBus bus) {
        super(Constants.MOD_ID, "bd", Constants.MOD_ID);
        EveryCompatAPI.registerModule(this);
        bus.register(this);
        INSTANCE = this;
        kitchenCounter = SimpleEntrySet.<WoodType, KitchenCounterBlock>builder(WoodType.class, "kitchen_counter",
                        () -> ModBlocks.OAK_KITCHEN_COUNTER.get(),
                        () -> VanillaWoodTypes.OAK,
                        w -> new KitchenCounterBlock(Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/furniture/kitchen_counter/oak_kitchen_counter"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        kitchenDrawer = SimpleEntrySet.<WoodType, KitchenDrawerBlock>builder(WoodType.class, "kitchen_drawer",
                () -> ModBlocks.OAK_KITCHEN_DRAWER.get(),
                () -> VanillaWoodTypes.OAK,
                 w-> new KitchenDrawerBlock(Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/furniture/kitchen_counter/oak_kitchen_drawer"), PaletteStrategies.PLANKS_STANDARD)
                .addTile(getModTile("kitchen_drawer"))
                .noTab()
                .build();


        this.addEntry(kitchenCounter);
        this.addEntry(kitchenDrawer);
    }

    /**
     * Class where registered the Custom filter tab for registering all the custom blocks
     * created with everycompat: It also features the event register
     *
     */
   /*
    public static class EveryCompatCreativeTabRegister {

        public static final BundledTabs EVERYCOMPAT_TAB = ModBundledTabs.register(
                        BundledTabs.builder()
                                .icon(ECRegistry.ALL_WOODS.get().getDefaultInstance())
                                .title(Component.translatable("bundled_tab.everycompat"))
                                .displayItems((parameters, output) -> {
                                    EveryCompatModule module = getModuleInstance();

                                    /**
                                     * Method to register all entries, I don't think i'll use that cause i'd like to register
                                     * my blocks with my logic*/
                                    /* if (module != null) {
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
        /*                        })
                                .build()
        );

        private static EveryCompatModule getModuleInstance() {
            return EveryCompatModule.INSTANCE;
        }

        public static void register(RegisterEvent.RegisterHelper<CreativeModeTab> ignored) {
            //It's okay if empty
        }
    }
/**
 * Event where the tab is registered and initializated
 **/
   /* @SubscribeEvent
    public void register(RegisterEvent event) {
        event.register(BuiltInRegistries.CREATIVE_MODE_TAB.key(), EveryCompatCreativeTabRegister::register);
    }*/
}