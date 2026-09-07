package net.tier1234.better_deco.compat.everycomp;

import net.mehvahdjukaar.every_compat.ECRegistry;
import net.mehvahdjukaar.every_compat.api.PaletteStrategies;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.api.SimpleModule;
import net.mehvahdjukaar.moonlight.api.resources.RecipeTemplate;
import net.mehvahdjukaar.moonlight.api.resources.recipe.BlockTypeSwapIngredient;
import net.mehvahdjukaar.moonlight.api.set.BlockType;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.*;
import net.tier1234.better_deco.creative_tabs.BundledTabs;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModBundledTabs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommonEveryCompatModule extends SimpleModule {

    public final SimpleEntrySet<WoodType, KitchenCounterBlock> kitchenCounter;
    public final SimpleEntrySet<WoodType, KitchenDrawerBlock> kitchenDrawer;
    public final SimpleEntrySet<WoodType, OvenBlock> kitchenOven;
    public final SimpleEntrySet<WoodType, KitchenSinkBlock> kitchenSink;
    public final SimpleEntrySet<WoodType, CabinetBlock> kitchenCabinet;
    public final SimpleEntrySet<WoodType, CuttingBoardBlock> cuttingBoard;
    public final SimpleEntrySet<WoodType, JarBlock> jar;


   public final SimpleEntrySet<WoodType, ChairBlock> chair;
   public final SimpleEntrySet<WoodType, TableBlock> table;
   public final SimpleEntrySet<WoodType, DeskBlock> desk;
   public final SimpleEntrySet<WoodType, DeskCabinetBlock> deskCabinet;
   public final SimpleEntrySet<WoodType, BedsideCabinetBlock> bedsideCabinet;
   public final SimpleEntrySet<WoodType, WoodenClockBlock> woodenClock;
   public final SimpleEntrySet<WoodType, CoffeeTableBlock> coffeeTable;
   public final SimpleEntrySet<WoodType, CrateBlock> crate;
   public final SimpleEntrySet<WoodType, ParkBenchBlock> parkBench;
   public final SimpleEntrySet<WoodType, ToiletBlock> toilet;
   public final SimpleEntrySet<WoodType, BasinBlock> basin;
   public final SimpleEntrySet<WoodType, BathBlock> bath;
   public final SimpleEntrySet<WoodType, ShelfBlock> shelf;


    private static CommonEveryCompatModule INSTANCE;

    public CommonEveryCompatModule() {
        super(Constants.MOD_ID, "bd", Constants.MOD_ID);
        INSTANCE = this;

        kitchenCounter = SimpleEntrySet.builder(WoodType.class, "kitchen_counter",
                        ModBlocks.OAK_KITCHEN_COUNTER::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new KitchenCounterBlock(w.toVanillaOrOak(), Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/oak_kitchen_counter"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        kitchenDrawer = SimpleEntrySet.builder(WoodType.class, "kitchen_drawer",
                        ModBlocks.OAK_KITCHEN_DRAWER::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new KitchenDrawerBlock(w.toVanillaOrOak(), Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_kitchen_drawer"), modRes("block/oak_kitchen_drawer_m"))
                .addTile(ModBlockEntities.CUSTOM_KITCHEN_DRAWER_BE::get)
                .noTab()
                .build();

        kitchenOven = SimpleEntrySet.builder(WoodType.class, "oven",
                        ModBlocks.OAK_OVEN::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new OvenBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_kitchen_oven"),modRes("block/oak_kitchen_oven_m"))
                .addTile(getModTile("oven"))
                .noTab()
                .build();

        kitchenSink = SimpleEntrySet.builder(WoodType.class, "sink",
                        ModBlocks.OAK_SINK::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new KitchenSinkBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_kitchen_sink"), modRes("block/oak_kitchen_sink_m"))
                .addTile(ModBlockEntities.KITCHEN_SINK::get)
                .noTab()
                .build();

        kitchenCabinet = SimpleEntrySet.builder(WoodType.class, "kitchen_cabinet",
                        ModBlocks.OAK_CABINET::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new CabinetBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_kitchen_cabinet"), modRes("block/oak_kitchen_cabinet_m"))
                .addTile(getModTile("cabinet"))
                .noTab()
                .build();

        cuttingBoard = SimpleEntrySet.builder(WoodType.class, "cutting_board",
                        ModBlocks.OAK_CUTTING_BOARD::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new CuttingBoardBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/oak_cutting_board"), PaletteStrategies.PLANKS_STANDARD)
                .addTile(getModTile("cutting_board"))
                .noTab()
                .build();

        jar = SimpleEntrySet.builder(WoodType.class, "jar",
                        ModBlocks.OAK_JAR::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new JarBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_jar"), modRes("block/oak_jar_m"))
                .addTile(getModTile("jar"))
                .noTab()
                .build();



        desk = SimpleEntrySet.builder(WoodType.class, "desk",
                        ModBlocks.OAK_DESK::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new DeskBlock(Utils.copyPropertySafe(w.planks),w.toVanillaOrOak()))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/oak_desk"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        deskCabinet = SimpleEntrySet.builder(WoodType.class, "desk_cabinet",
                        ModBlocks.OAK_DESK_CABINET::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new DeskCabinetBlock(Utils.copyPropertySafe(w.planks),w.toVanillaOrOak()))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_desk_drawer"), modRes("block/oak_desk_drawer_m"))
                .addTile(getModTile("desk_cabinet"))
                .noTab()
                .build();

        bedsideCabinet = SimpleEntrySet.builder(WoodType.class, "bedside",
                        ModBlocks.OAK_BEDSIDE::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new BedsideCabinetBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_bedside_cabinet"), modRes("block/oak_bedside_cabinet_m"))
                .addTile(ModBlockEntities.BEDSIDE_CABINET::get)
                .noTab()
                .build();


        chair = SimpleEntrySet.builder(WoodType.class, "chair",
                ModBlocks.OAK_CHAIR::get,
                ()-> VanillaWoodTypes.OAK,
                w-> new ChairBlock(w.toVanillaOrOak(), Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/oak_chair"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        table = SimpleEntrySet.builder(WoodType.class, "table",
                        ModBlocks.OAK_TABLE::get,
                        ()-> VanillaWoodTypes.OAK,
                        w-> new TableBlock(w.toVanillaOrOak(), Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/oak_table"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        woodenClock = SimpleEntrySet.builder(WoodType.class, "clock",
                        ModBlocks.OAK_CLOCK::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new WoodenClockBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_clock"), modRes("block/oak_clock_m"))
                .addTile(ModBlockEntities.WOODEN_CLOCK::get)
                .noTab()
                .build();

        crate = SimpleEntrySet.builder(WoodType.class, "storage_crate",
                        ModBlocks.OAK_CRATE::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new CrateBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/oak_crate"), PaletteStrategies.PLANKS_STANDARD)
                .addTile(ModBlockEntities.STORAGE_CRATE::get)
                .noTab()
                .build();

        parkBench = SimpleEntrySet.builder(WoodType.class, "park_bench",
                        ModBlocks.OAK_PARK_BENCH::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new ParkBenchBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_bench"), modRes("block/oak_bench_m"))
                .noTab()
                .build();

        coffeeTable = SimpleEntrySet.builder(WoodType.class, "coffee_table",
                        ModBlocks.OAK_COFFEE_TABLE::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new CoffeeTableBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addNonAnimatedTextureM(modRes("block/oak_coffee_table"), modRes("block/oak_coffee_table_m"))
                .noTab()
                .build();

        toilet = SimpleEntrySet.builder(WoodType.class, "toilet",
                        ModBlocks.OAK_TOILET::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new ToiletBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTile(ModBlockEntities.TOILET::get)
                .addNonAnimatedTextureM(modRes("block/oak_toilet"), modRes("block/oak_toilet_m"))
                .noTab()
                .build();


        basin = SimpleEntrySet.builder(WoodType.class, "basin",
                        ModBlocks.OAK_BASIN::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new BasinBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTile(ModBlockEntities.BASIN::get)
                .addNonAnimatedTextureM(modRes("block/oak_basin"), modRes("block/oak_basin_m"))
                .noTab()
                .build();

        bath = SimpleEntrySet.builder(WoodType.class, "bath",
                        ModBlocks.OAK_BATH::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new BathBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTile(ModBlockEntities.BATH::get)
                .addNonAnimatedTextureM(modRes("block/oak_bath"), modRes("block/oak_bath_m"))
                .noTab()
                .build();

        shelf = SimpleEntrySet.builder(WoodType.class, "shelf",
                        ModBlocks.OAK_SHELF::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new ShelfBlock(w.toVanillaOrOak(),Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTile(ModBlockEntities.SHELF_BE::get)
                .addTexture(modRes("block/oak_shelf"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();


        //General
        this.addEntry(chair);
        this.addEntry(table);
        this.addEntry(coffeeTable);

        //Kitchen
        this.addEntry(kitchenCounter);
        this.addEntry(kitchenDrawer);
        this.addEntry(kitchenOven);
        this.addEntry(kitchenSink);
        this.addEntry(kitchenCabinet);
        this.addEntry(cuttingBoard);
        this.addEntry(jar);

        //Office and Bedroom
        this.addEntry(bedsideCabinet);
        this.addEntry(desk);
        this.addEntry(deskCabinet);
        this.addEntry(woodenClock);
        this.addEntry(shelf);

        //Bath
        this.addEntry(basin);
        this.addEntry(toilet);
        this.addEntry(bath);

        //Outdoor
        this.addEntry(crate);
        this.addEntry(parkBench);



    }

    public static class EveryCompatCreativeTabRegister {

        public static final BundledTabs EVERYCOMPAT_TAB = ModBundledTabs.register(
                BundledTabs.builder()
                        .icon(ECRegistry.ALL_WOODS.get().getDefaultInstance())
                        .title(Component.translatable("bundled_tab.everycompat"))
                        .displayItems((parameters, output) -> {
                            CommonEveryCompatModule module = getModuleInstance();

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


                        })
                        .build()
        );


        private static CommonEveryCompatModule getModuleInstance() {
            return CommonEveryCompatModule.INSTANCE;
        }

        public static void register() {
            EVERYCOMPAT_TAB.getClass();
        }
    }


    @Override
    public void onModSetup() {
        super.onModSetup();

        RecipeTemplate.register(WorkbenchRecipe.class, (old, from, to)-> {
            List<CountedIngredient> newIngredients = convertCountedIngredients(old.getMaterials(), from, to);
            ItemStack originalResult = old.getResultItem(RegistryAccess.EMPTY);
            ItemStack newResult = RecipeTemplate.convertItemStack(originalResult, from, to);
            if (newResult == null) {
                throw new UnsupportedOperationException("Failed to convert recipe result");
            } else {
                NonNullList<CountedIngredient> ingredients = NonNullList.of(CountedIngredient.EMPTY, newIngredients.toArray(CountedIngredient[]::new));
                return new WorkbenchRecipe(ingredients, newResult, old.showNotification());
            }

        });

    }


    private static <R extends Recipe<?>, T extends BlockType> @NotNull List<CountedIngredient> convertCountedIngredients(
            NonNullList<CountedIngredient> or, T from, T to) {

        List<CountedIngredient> newList = new ArrayList<>();
        for (CountedIngredient si : or) {
            if (si.ingredient().isEmpty()) {
                newList.add(si);
            } else {
                newList.add(CountedIngredient.of(
                        BlockTypeSwapIngredient.create(si.ingredient(), from, to),
                        si.count()));
            }
        }
        return newList;
    }

}
