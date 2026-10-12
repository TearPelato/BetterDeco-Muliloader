package net.tier1234.better_deco.registries;

import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.*;
import net.tier1234.better_deco.block.type.MetalType;
import net.tier1234.better_deco.block.type.StoneType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ModBlocks {
    public static final List<ObjectRegistries<? extends Block>> BLOCKS = new ArrayList<>();


    //Test
    public static final ObjectRegistries<WorkbenchBlock> WORKBENCH = register("workbench",
            properties -> new WorkbenchBlock(properties.strength(2.0f).sound(SoundType.WOOD)));


    public static final ObjectRegistries<BathBlock> OAK_BATH = register("oak_bath",
            properties -> new BathBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> SPRUCE_BATH = register("spruce_bath",
            properties -> new BathBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> BIRCH_BATH = register("birch_bath",
            properties -> new BathBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> JUNGLE_BATH = register("jungle_bath",
            properties -> new BathBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> ACACIA_BATH = register("acacia_bath",
            properties -> new BathBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> DARK_OAK_BATH = register("dark_oak_bath",
            properties -> new BathBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> MANGROVE_BATH = register("mangrove_bath",
            properties -> new BathBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> CHERRY_BATH = register("cherry_bath",
            properties -> new BathBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> BAMBOO_BATH = register("bamboo_bath",
            properties -> new BathBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> CRIMSON_BATH = register("crimson_bath",
            properties -> new BathBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> WARPED_BATH = register("warped_bath",
            properties -> new BathBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> PALE_OAK_BATH = register("pale_oak_bath",
            properties -> new BathBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD)));




    public static final ObjectRegistries<ToiletBlock> OAK_TOILET = register("oak_toilet",
            properties -> new ToiletBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> SPRUCE_TOILET = register("spruce_toilet",
            properties -> new ToiletBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> BIRCH_TOILET = register("birch_toilet",
            properties -> new ToiletBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> JUNGLE_TOILET = register("jungle_toilet",
            properties -> new ToiletBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> ACACIA_TOILET = register("acacia_toilet",
            properties -> new ToiletBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> DARK_OAK_TOILET = register("dark_oak_toilet",
            properties -> new ToiletBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> MANGROVE_TOILET = register("mangrove_toilet",
            properties -> new ToiletBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> CHERRY_TOILET = register("cherry_toilet",
            properties -> new ToiletBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> BAMBOO_TOILET = register("bamboo_toilet",
            properties -> new ToiletBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> CRIMSON_TOILET = register("crimson_toilet",
            properties -> new ToiletBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> WARPED_TOILET = register("warped_toilet",
            properties -> new ToiletBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> PALE_OAK_TOILET = register("pale_oak_toilet",
            properties -> new ToiletBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD)));














    public static final ObjectRegistries<BasinBlock> OAK_BASIN = register("oak_basin",
            properties -> new BasinBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> SPRUCE_BASIN = register("spruce_basin",
            properties -> new BasinBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> BIRCH_BASIN = register("birch_basin",
            properties -> new BasinBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> JUNGLE_BASIN = register("jungle_basin",
            properties -> new BasinBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> ACACIA_BASIN = register("acacia_basin",
            properties -> new BasinBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> DARK_OAK_BASIN = register("dark_oak_basin",
            properties -> new BasinBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> MANGROVE_BASIN = register("mangrove_basin",
            properties -> new BasinBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> CHERRY_BASIN = register("cherry_basin",
            properties -> new BasinBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> BAMBOO_BASIN = register("bamboo_basin",
            properties -> new BasinBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> CRIMSON_BASIN = register("crimson_basin",
            properties -> new BasinBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> WARPED_BASIN = register("warped_basin",
            properties -> new BasinBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> PALE_OAK_BASIN = register("pale_oak_basin",
            properties -> new BasinBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD)));



    public static final ObjectRegistries<JarBlock> OAK_JAR = register("oak_jar",
            properties -> new JarBlock(WoodType.OAK, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> SPRUCE_JAR = register("spruce_jar",
            properties -> new JarBlock(WoodType.SPRUCE, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> BIRCH_JAR = register("birch_jar",
            properties -> new JarBlock(WoodType.BIRCH, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> JUNGLE_JAR = register("jungle_jar",
            properties -> new JarBlock(WoodType.JUNGLE, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> ACACIA_JAR = register("acacia_jar",
            properties -> new JarBlock(WoodType.ACACIA, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> DARK_OAK_JAR = register("dark_oak_jar",
            properties -> new JarBlock(WoodType.DARK_OAK, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> MANGROVE_JAR = register("mangrove_jar",
            properties -> new JarBlock(WoodType.MANGROVE, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> CHERRY_JAR = register("cherry_jar",
            properties -> new JarBlock(WoodType.CRIMSON, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> BAMBOO_JAR = register("bamboo_jar",
            properties -> new JarBlock(WoodType.BAMBOO, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> CRIMSON_JAR = register("crimson_jar",
            properties -> new JarBlock(WoodType.CRIMSON, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> WARPED_JAR = register("warped_jar",
            properties -> new JarBlock(WoodType.WARPED, properties.strength(1.0F)));
    public static final ObjectRegistries<JarBlock> PALE_OAK_JAR = register("pale_oak_jar",
            properties -> new JarBlock(WoodType.PALE_OAK, properties.strength(1.0F)));






    public static final ObjectRegistries<CuttingBoardBlock> OAK_CUTTING_BOARD = register("oak_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.OAK, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> SPRUCE_CUTTING_BOARD = register("spruce_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.SPRUCE, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> BIRCH_CUTTING_BOARD = register("birch_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.BIRCH, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> JUNGLE_CUTTING_BOARD = register("jungle_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.JUNGLE, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> ACACIA_CUTTING_BOARD = register("acacia_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.ACACIA, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> DARK_OAK_CUTTING_BOARD = register("dark_oak_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.DARK_OAK, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> MANGROVE_CUTTING_BOARD = register("mangrove_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.MANGROVE, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> CHERRY_CUTTING_BOARD = register("cherry_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.CHERRY, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> BAMBOO_CUTTING_BOARD = register("bamboo_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.BAMBOO, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> CRIMSON_CUTTING_BOARD = register("crimson_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.CRIMSON, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> WARPED_CUTTING_BOARD = register("warped_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.WARPED, properties.strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> PALE_OAK_CUTTING_BOARD = register("pale_oak_cutting_board",
            properties -> new CuttingBoardBlock(WoodType.PALE_OAK, properties.strength(2.5f)));





    //Desk
    public static final ObjectRegistries<DeskBlock> OAK_DESK = register("oak_desk",
            properties -> new DeskBlock(WoodType.OAK, properties));
    public static final ObjectRegistries<DeskBlock> SPRUCE_DESK = register("spruce_desk",
            properties -> new DeskBlock(WoodType.SPRUCE, properties));
    public static final ObjectRegistries<DeskBlock> BIRCH_DESK = register("birch_desk",
            properties -> new DeskBlock(WoodType.BIRCH, properties));
    public static final ObjectRegistries<DeskBlock> JUNGLE_DESK = register("jungle_desk",
            properties -> new DeskBlock(WoodType.JUNGLE, properties));
    public static final ObjectRegistries<DeskBlock> ACACIA_DESK = register("acacia_desk",
            properties -> new DeskBlock(WoodType.ACACIA, properties));
    public static final ObjectRegistries<DeskBlock> MANGROVE_DESK = register("mangrove_desk",
            properties -> new DeskBlock(WoodType.MANGROVE, properties));
    public static final ObjectRegistries<DeskBlock> DARK_OAK_DESK = register("dark_oak_desk",
            properties -> new DeskBlock(WoodType.DARK_OAK, properties));
    public static final ObjectRegistries<DeskBlock> CHERRY_DESK = register("cherry_desk",
            properties -> new DeskBlock(WoodType.CHERRY, properties));
    public static final ObjectRegistries<DeskBlock> BAMBOO_DESK = register("bamboo_desk",
            properties -> new DeskBlock(WoodType.BAMBOO, properties));
    public static final ObjectRegistries<DeskBlock> CRIMSON_DESK = register("crimson_desk",
            properties -> new DeskBlock(WoodType.CRIMSON, properties));
    public static final ObjectRegistries<DeskBlock> WARPED_DESK = register("warped_desk",
            properties -> new DeskBlock(WoodType.WARPED, properties));
    public static final ObjectRegistries<DeskBlock> PALE_OAK_DESK = register("pale_oak_desk",
            properties -> new DeskBlock(WoodType.PALE_OAK, properties));


    public static final ObjectRegistries<DeskCabinetBlock> OAK_DESK_CABINET = register("oak_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.OAK,properties));
    public static final ObjectRegistries<DeskCabinetBlock> SPRUCE_DESK_CABINET = register("spruce_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.SPRUCE, properties));
    public static final ObjectRegistries<DeskCabinetBlock> BIRCH_DESK_CABINET = register("birch_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.BIRCH, properties));
    public static final ObjectRegistries<DeskCabinetBlock> JUNGLE_DESK_CABINET = register("jungle_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.JUNGLE, properties));
    public static final ObjectRegistries<DeskCabinetBlock> ACACIA_DESK_CABINET = register("acacia_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.ACACIA, properties));
    public static final ObjectRegistries<DeskCabinetBlock> MANGROVE_DESK_CABINET = register("mangrove_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.MANGROVE, properties));
    public static final ObjectRegistries<DeskCabinetBlock> DARK_OAK_DESK_CABINET = register("dark_oak_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.DARK_OAK, properties));
    public static final ObjectRegistries<DeskCabinetBlock> CHERRY_DESK_CABINET = register("cherry_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.CHERRY, properties));
    public static final ObjectRegistries<DeskCabinetBlock> BAMBOO_DESK_CABINET = register("bamboo_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.BAMBOO, properties));
    public static final ObjectRegistries<DeskCabinetBlock> CRIMSON_DESK_CABINET = register("crimson_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.CRIMSON, properties));
    public static final ObjectRegistries<DeskCabinetBlock> WARPED_DESK_CABINET = register("warped_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.WARPED, properties));
    public static final ObjectRegistries<DeskCabinetBlock> PALE_OAK_DESK_CABINET = register("pale_oak_desk_cabinet",
            properties -> new DeskCabinetBlock(WoodType.PALE_OAK, properties));

    //Path
    public static final ObjectRegistries<PathBlock> STONE_PATH = register("stone_path",
            properties -> new PathBlock(StoneType.STONE, properties.strength(3.1f)));
    public static final ObjectRegistries<PathBlock> ANDESITE_PATH = register("andesite_path",
            properties -> new PathBlock(StoneType.ANDESITE, properties.strength(3.1f)));
    public static final ObjectRegistries<PathBlock> GRANITE_PATH = register("granite_path",
            properties -> new PathBlock(StoneType.GRANITE, properties.strength(3.1f)));
    public static final ObjectRegistries<PathBlock> DIORITE_PATH = register("diorite_path",
            properties -> new PathBlock(StoneType.DIORITE, properties.strength(3.1f)));
    public static final ObjectRegistries<PathBlock> DEEPSLATE_PATH = register("deepslate_path",
            properties -> new PathBlock(StoneType.DEEPSLATE, properties.strength(3.1f)));




    //PARK BENCH
    public static final ObjectRegistries<ParkBenchBlock> OAK_PARK_BENCH = register("oak_park_bench",
            properties -> new ParkBenchBlock(WoodType.OAK, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> SPRUCE_PARK_BENCH = register("spruce_park_bench",
            properties -> new ParkBenchBlock(WoodType.SPRUCE, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> BIRCH_PARK_BENCH = register("birch_park_bench",
            properties -> new ParkBenchBlock(WoodType.BIRCH, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> JUNGLE_PARK_BENCH = register("jungle_park_bench",
            properties -> new ParkBenchBlock(WoodType.JUNGLE, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> ACACIA_PARK_BENCH = register("acacia_park_bench",
            properties -> new ParkBenchBlock(WoodType.ACACIA, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> DARK_OAK_PARK_BENCH = register("dark_oak_park_bench",
            properties -> new ParkBenchBlock(WoodType.DARK_OAK, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> MANGROVE_PARK_BENCH = register("mangrove_park_bench",
            properties -> new ParkBenchBlock(WoodType.MANGROVE, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> CHERRY_PARK_BENCH = register("cherry_park_bench",
            properties -> new ParkBenchBlock(WoodType.CHERRY, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> BAMBOO_PARK_BENCH = register("bamboo_park_bench",
            properties -> new ParkBenchBlock(WoodType.BAMBOO, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> CRIMSON_PARK_BENCH = register("crimson_park_bench",
            properties -> new ParkBenchBlock(WoodType.CRIMSON, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> WARPED_PARK_BENCH = register("warped_park_bench",
            properties -> new ParkBenchBlock(WoodType.WARPED, properties.strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> PALE_OAK_PARK_BENCH = register("pale_oak_park_bench",
            properties -> new ParkBenchBlock(WoodType.PALE_OAK, properties.strength(2.5f)));



    public static final ObjectRegistries<ToasterBlock> TOASTER_LIGHT = register("toaster_light",
            properties ->  new ToasterBlock(MetalType.LIGHT, properties.strength(2f).noOcclusion()));
    public static final ObjectRegistries<ToasterBlock> TOASTER_DARK = register("toaster_dark",
            properties ->  new ToasterBlock(MetalType.DARK, properties.strength(2f).noOcclusion()));

    //FRIDGE & FREEZERS
    public static final ObjectRegistries<FridgeBlock> FRIDGE_LIGHT = register("fridge_light",
            properties -> new FridgeBlock(MetalType.LIGHT, properties));
    public static final ObjectRegistries<FridgeBlock> FRIDGE_DARK = register("fridge_dark",
            properties -> new FridgeBlock(MetalType.DARK, properties));

    public static final ObjectRegistries<MicrowaveBlock> LIGHT_MICROWAVE = register("microwave_light",
            properties -> new MicrowaveBlock(MetalType.LIGHT, properties.strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final ObjectRegistries<MicrowaveBlock> DARK_MICROWAVE = register("microwave_dark",
            properties -> new MicrowaveBlock(MetalType.DARK, properties.strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));

    //Oven
    public static final ObjectRegistries<OvenBlock> OAK_OVEN = register("oak_oven",
            properties -> new OvenBlock(WoodType.OAK, properties));
    public static final ObjectRegistries<OvenBlock> SPRUCE_OVEN = register("spruce_oven",
            properties -> new OvenBlock(WoodType.SPRUCE, properties));
    public static final ObjectRegistries<OvenBlock> BIRCH_OVEN = register("birch_oven",
            properties -> new OvenBlock(WoodType.BIRCH, properties));
    public static final ObjectRegistries<OvenBlock> JUNGLE_OVEN = register("jungle_oven",
            properties -> new OvenBlock(WoodType.JUNGLE, properties));
    public static final ObjectRegistries<OvenBlock> ACACIA_OVEN = register("acacia_oven",
            properties -> new OvenBlock(WoodType.ACACIA, properties));
    public static final ObjectRegistries<OvenBlock> DARK_OAK_OVEN = register("dark_oak_oven",
            properties -> new OvenBlock(WoodType.DARK_OAK, properties));
    public static final ObjectRegistries<OvenBlock> MANGROVE_OVEN = register("mangrove_oven",
            properties -> new OvenBlock(WoodType.MANGROVE, properties));
    public static final ObjectRegistries<OvenBlock> CHERRY_OVEN = register("cherry_oven",
            properties -> new OvenBlock(WoodType.CHERRY, properties));
    public static final ObjectRegistries<OvenBlock> BAMBOO_OVEN = register("bamboo_oven",
            properties -> new OvenBlock(WoodType.BAMBOO, properties));
    public static final ObjectRegistries<OvenBlock> CRIMSON_OVEN = register("crimson_oven",
            properties -> new OvenBlock(WoodType.CRIMSON, properties));
    public static final ObjectRegistries<OvenBlock> WARPED_OVEN = register("warped_oven",
            properties -> new OvenBlock(WoodType.WARPED, properties));
    public static final ObjectRegistries<OvenBlock> PALE_OAK_OVEN = register("pale_oak_oven",
            properties -> new OvenBlock(WoodType.PALE_OAK, properties));


    //SHELFS
    public static final ObjectRegistries<ShelfBlock> OAK_SHELF = register("oak_shelf",
            properties -> new ShelfBlock(WoodType.OAK, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> SPRUCE_SHELF = register("spruce_shelf",
            properties -> new ShelfBlock(WoodType.SPRUCE, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> BIRCH_SHELF = register("birch_shelf",
            properties -> new ShelfBlock(WoodType.BIRCH, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> JUNGLE_SHELF = register("jungle_shelf",
            properties -> new ShelfBlock(WoodType.JUNGLE, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> ACACIA_SHELF = register("acacia_shelf",
            properties -> new ShelfBlock(WoodType.ACACIA, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> DARK_OAK_SHELF = register("dark_oak_shelf",
            properties -> new ShelfBlock(WoodType.DARK_OAK, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> MANGROVE_SHELF = register("mangrove_shelf",
            properties -> new ShelfBlock(WoodType.MANGROVE, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> CHERRY_SHELF = register("cherry_shelf",
            properties -> new ShelfBlock(WoodType.CHERRY, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> BAMBOO_SHELF = register("bamboo_shelf",
            properties -> new ShelfBlock(WoodType.BAMBOO, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> CRIMSON_SHELF = register("crimson_shelf",
            properties -> new ShelfBlock(WoodType.CRIMSON, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> WARPED_SHELF = register("warped_shelf",
            properties -> new ShelfBlock(WoodType.WARPED, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> PALE_OAK_SHELF = register("pale_oak_shelf",
            properties -> new ShelfBlock(WoodType.PALE_OAK, properties.sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));

    //Furnitures
    //Chairs
    public static final ObjectRegistries<ChairBlock> OAK_CHAIR = register("oak_chair",
            properties -> new ChairBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> SPRUCE_CHAIR = register("spruce_chair",
            properties -> new ChairBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> BIRCH_CHAIR = register("birch_chair",
            properties -> new ChairBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> JUNGLE_CHAIR = register("jungle_chair",
            properties -> new ChairBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> ACACIA_CHAIR = register("acacia_chair",
            properties -> new ChairBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> DARK_OAK_CHAIR = register("dark_oak_chair",
            properties -> new ChairBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> MANGROVE_CHAIR = register("mangrove_chair",
            properties -> new ChairBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> CHERRY_CHAIR = register("cherry_chair",
            properties -> new ChairBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> BAMBOO_CHAIR = register("bamboo_chair",
            properties -> new ChairBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> CRIMSON_CHAIR = register("crimson_chair",
            properties -> new ChairBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> WARPED_CHAIR = register("warped_chair",
            properties -> new ChairBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> PALE_OAK_CHAIR = register("pale_oak_chair",
            properties -> new ChairBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Counters
    public static final ObjectRegistries<KitchenCounterBlock> OAK_KITCHEN_COUNTER = register("oak_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> SPRUCE_KITCHEN_COUNTER = register("spruce_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BIRCH_KITCHEN_COUNTER = register("birch_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> JUNGLE_KITCHEN_COUNTER = register("jungle_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> ACACIA_KITCHEN_COUNTER = register("acacia_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> DARK_OAK_KITCHEN_COUNTER = register("dark_oak_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> MANGROVE_KITCHEN_COUNTER = register("mangrove_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> CHERRY_KITCHEN_COUNTER = register("cherry_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BAMBOO_KITCHEN_COUNTER = register("bamboo_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> CRIMSON_KITCHEN_COUNTER = register("crimson_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> WARPED_KITCHEN_COUNTER = register("warped_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> PALE_OAK_KITCHEN_COUNTER = register("pale_oak_kitchen_counter",
            properties -> new KitchenCounterBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Drawers
    public static final ObjectRegistries<KitchenDrawerBlock> OAK_KITCHEN_DRAWER = register("oak_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> SPRUCE_KITCHEN_DRAWER = register("spruce_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BIRCH_KITCHEN_DRAWER = register("birch_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> JUNGLE_KITCHEN_DRAWER = register("jungle_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> ACACIA_KITCHEN_DRAWER = register("acacia_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> DARK_OAK_KITCHEN_DRAWER = register("dark_oak_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> MANGROVE_KITCHEN_DRAWER = register("mangrove_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> CHERRY_KITCHEN_DRAWER = register("cherry_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BAMBOO_KITCHEN_DRAWER = register("bamboo_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> CRIMSON_KITCHEN_DRAWER = register("crimson_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> WARPED_KITCHEN_DRAWER = register("warped_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> PALE_OAK_KITCHEN_DRAWER = register("pale_oak_kitchen_drawer",
            properties -> new KitchenDrawerBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Sofas
    public static final ObjectRegistries<SofaBlock> RED_SOFA = register("red_sofa",
            properties -> new SofaBlock(DyeColor.RED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> ORANGE_SOFA = register("orange_sofa",
            properties -> new SofaBlock(DyeColor.ORANGE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> BLUE_SOFA = register("blue_sofa",
            properties -> new SofaBlock(DyeColor.BLUE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> CYAN_SOFA = register("cyan_sofa",
            properties -> new SofaBlock(DyeColor.CYAN, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> LIGHT_BLUE_SOFA = register("light_blue_sofa",
            properties -> new SofaBlock(DyeColor.LIGHT_BLUE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> PURPLE_SOFA = register("purple_sofa",
            properties -> new SofaBlock(DyeColor.PURPLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> MAGENTA_SOFA = register("magenta_sofa",
            properties -> new SofaBlock(DyeColor.MAGENTA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> YELLOW_SOFA = register("yellow_sofa",
            properties -> new SofaBlock(DyeColor.YELLOW, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> GREY_SOFA = register("grey_sofa",
            properties -> new SofaBlock(DyeColor.GRAY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> LIGHT_GREY_SOFA = register("light_grey_sofa",
            properties -> new SofaBlock(DyeColor.LIGHT_GRAY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> BLACK_SOFA = register("black_sofa",
            properties -> new SofaBlock(DyeColor.BLACK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> WHITE_SOFA = register("white_sofa",
            properties -> new SofaBlock(DyeColor.WHITE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> GREEN_SOFA = register("green_sofa",
            properties -> new SofaBlock(DyeColor.GREEN, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> LIME_SOFA = register("lime_sofa",
            properties -> new SofaBlock(DyeColor.LIME, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> PINK_SOFA = register("pink_sofa",
            properties -> new SofaBlock(DyeColor.PINK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> BROWN_SOFA = register("brown_sofa",
            properties -> new SofaBlock(DyeColor.BROWN, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Cabinet
    public static final ObjectRegistries<CabinetBlock> OAK_CABINET = register("oak_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> SPRUCE_CABINET = register("spruce_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BIRCH_CABINET = register("birch_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> JUNGLE_CABINET = register("jungle_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> ACACIA_CABINET = register("acacia_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> DARK_OAK_CABINET = register("dark_oak_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> MANGROVE_CABINET = register("mangrove_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> CHERRY_CABINET = register("cherry_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BAMBOO_CABINET = register("bamboo_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> CRIMSON_CABINET = register("crimson_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> WARPED_CABINET = register("warped_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> PALE_OAK_CABINET = register("pale_oak_kitchen_cabinet",
            properties -> new CabinetBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));


    //Bedside Cabinets
    public static final ObjectRegistries<BedsideCabinetBlock> OAK_BEDSIDE = register("oak_bedside",
            properties -> new BedsideCabinetBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> SPRUCE_BEDSIDE = register("spruce_bedside",
            properties -> new BedsideCabinetBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> BIRCH_BEDSIDE = register("birch_bedside",
            properties -> new BedsideCabinetBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> JUNGLE_BEDSIDE = register("jungle_bedside",
            properties -> new BedsideCabinetBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> ACACIA_BEDSIDE = register("acacia_bedside",
            properties -> new BedsideCabinetBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> MANGROVE_BEDSIDE = register("mangrove_bedside",
            properties -> new BedsideCabinetBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> DARK_OAK_BEDSIDE = register("dark_oak_bedside",
            properties -> new BedsideCabinetBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> CHERRY_BEDSIDE = register("cherry_bedside",
            properties -> new BedsideCabinetBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> BAMBOO_BEDSIDE = register("bamboo_bedside",
            properties -> new BedsideCabinetBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> CRIMSON_BEDSIDE = register("crimson_bedside",
            properties -> new BedsideCabinetBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> WARPED_BEDSIDE = register("warped_bedside",
            properties -> new BedsideCabinetBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> PALE_OAK_BEDSIDE = register("pale_oak_bedside",
            properties -> new BedsideCabinetBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Crates
    public static final ObjectRegistries<CrateBlock> OAK_CRATE = register("oak_storage_crate",
            properties -> new CrateBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> SPRUCE_CRATE = register("spruce_storage_crate",
            properties -> new CrateBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> BIRCH_CRATE = register("birch_storage_crate",
            properties -> new CrateBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> JUNGLE_CRATE = register("jungle_storage_crate",
            properties -> new CrateBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> ACACIA_CRATE = register("acacia_storage_crate",
            properties -> new CrateBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> MANGROVE_CRATE = register("mangrove_storage_crate",
            properties -> new CrateBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> DARK_OAK_CRATE = register("dark_oak_storage_crate",
            properties -> new CrateBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> CHERRY_CRATE = register("cherry_storage_crate",
            properties -> new CrateBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> BAMBOO_CRATE = register("bamboo_storage_crate",
            properties -> new CrateBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> CRIMSON_CRATE = register("crimson_storage_crate",
            properties -> new CrateBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> WARPED_CRATE = register("warped_storage_crate",
            properties -> new CrateBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> PALE_OAK_CRATE = register("pale_oak_storage_crate",
            properties -> new CrateBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Sinks
    public static final ObjectRegistries<KitchenSinkBlock> OAK_SINK = register("oak_sink",
            properties -> new KitchenSinkBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> SPRUCE_SINK = register("spruce_sink",
            properties -> new KitchenSinkBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BIRCH_SINK = register("birch_sink",
            properties -> new KitchenSinkBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> JUNGLE_SINK = register("jungle_sink",
            properties -> new KitchenSinkBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> ACACIA_SINK = register("acacia_sink",
            properties -> new KitchenSinkBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> MANGROVE_SINK = register("mangrove_sink",
            properties -> new KitchenSinkBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> DARK_OAK_SINK = register("dark_oak_sink",
            properties -> new KitchenSinkBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> CHERRY_SINK = register("cherry_sink",
            properties -> new KitchenSinkBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BAMBOO_SINK = register("bamboo_sink",
            properties -> new KitchenSinkBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> CRIMSON_SINK = register("crimson_sink",
            properties -> new KitchenSinkBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> WARPED_SINK = register("warped_sink",
            properties -> new KitchenSinkBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> PALE_OAK_SINK = register("pale_oak_sink",
            properties -> new KitchenSinkBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Colored Variants
    public static final ObjectRegistries<KitchenCounterBlock> RED_KITCHEN_COUNTER = register("red_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.RED, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> YELLOW_KITCHEN_COUNTER = register("yellow_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.YELLOW, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> ORANGE_KITCHEN_COUNTER = register("orange_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.ORANGE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> MAGENTA_KITCHEN_COUNTER = register("magenta_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.MAGENTA, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> PURPLE_KITCHEN_COUNTER = register("purple_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.PURPLE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> PINK_KITCHEN_COUNTER = register("pink_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.PINK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BLUE_KITCHEN_COUNTER = register("blue_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> LIGHT_BLUE_KITCHEN_COUNTER = register("light_blue_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.LIGHT_BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> CYAN_KITCHEN_COUNTER = register("cyan_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.CYAN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> GREEN_KITCHEN_COUNTER = register("green_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.GREEN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> LIME_KITCHEN_COUNTER = register("lime_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.LIME, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> GRAY_KITCHEN_COUNTER = register("gray_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> LIGHT_GRAY_KITCHEN_COUNTER = register("light_gray_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.LIGHT_GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BLACK_KITCHEN_COUNTER = register("black_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.BLACK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BROWN_KITCHEN_COUNTER = register("brown_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.BROWN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> WHITE_KITCHEN_COUNTER = register("white_kitchen_counter",
            properties -> new KitchenCounterBlock(DyeColor.WHITE, properties.strength(2.5f).noOcclusion()));

    //Colored Drawers
    public static final ObjectRegistries<KitchenDrawerBlock> RED_KITCHEN_DRAWER = register("red_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.RED, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> YELLOW_KITCHEN_DRAWER = register("yellow_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.YELLOW, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> ORANGE_KITCHEN_DRAWER = register("orange_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.ORANGE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> MAGENTA_KITCHEN_DRAWER = register("magenta_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.MAGENTA, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> PURPLE_KITCHEN_DRAWER = register("purple_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.PURPLE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> PINK_KITCHEN_DRAWER = register("pink_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.PINK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BLUE_KITCHEN_DRAWER = register("blue_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> LIGHT_BLUE_KITCHEN_DRAWER = register("light_blue_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.LIGHT_BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> CYAN_KITCHEN_DRAWER = register("cyan_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.CYAN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> GREEN_KITCHEN_DRAWER = register("green_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.GREEN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> LIME_KITCHEN_DRAWER = register("lime_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.LIME, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> GRAY_KITCHEN_DRAWER = register("gray_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> LIGHT_GRAY_KITCHEN_DRAWER = register("light_gray_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.LIGHT_GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BLACK_KITCHEN_DRAWER = register("black_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.BLACK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BROWN_KITCHEN_DRAWER = register("brown_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.BROWN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> WHITE_KITCHEN_DRAWER = register("white_kitchen_drawer",
            properties -> new KitchenDrawerBlock(DyeColor.WHITE, properties.strength(2.5f).noOcclusion()));

    //Oven colored
    public static final ObjectRegistries<OvenBlock> RED_OVEN = register("red_oven",
            properties -> new OvenBlock(DyeColor.RED, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> YELLOW_OVEN = register("yellow_oven",
            properties -> new OvenBlock(DyeColor.YELLOW, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> ORANGE_OVEN = register("orange_oven",
            properties -> new OvenBlock(DyeColor.ORANGE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> MAGENTA_OVEN = register("magenta_oven",
            properties -> new OvenBlock(DyeColor.MAGENTA, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> PURPLE_OVEN = register("purple_oven",
            properties -> new OvenBlock(DyeColor.PURPLE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> PINK_OVEN = register("pink_oven",
            properties -> new OvenBlock(DyeColor.PINK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> BLUE_OVEN = register("blue_oven",
            properties -> new OvenBlock(DyeColor.BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> LIGHT_BLUE_OVEN = register("light_blue_oven",
            properties -> new OvenBlock(DyeColor.LIGHT_BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> CYAN_OVEN = register("cyan_oven",
            properties -> new OvenBlock(DyeColor.CYAN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> GREEN_OVEN = register("green_oven",
            properties -> new OvenBlock(DyeColor.GREEN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> LIME_OVEN = register("lime_oven",
            properties -> new OvenBlock(DyeColor.LIME, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> GRAY_OVEN = register("gray_oven",
            properties -> new OvenBlock(DyeColor.GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> LIGHT_GRAY_OVEN = register("light_gray_oven",
            properties -> new OvenBlock(DyeColor.LIGHT_GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> BLACK_OVEN = register("black_oven",
            properties -> new OvenBlock(DyeColor.BLACK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> BROWN_OVEN = register("brown_oven",
            properties -> new OvenBlock(DyeColor.BROWN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> WHITE_OVEN = register("white_oven",
            properties -> new OvenBlock(DyeColor.WHITE, properties.strength(2.5f).noOcclusion()));

    public static final ObjectRegistries<KitchenSinkBlock> RED_SINK = register("red_sink",
            properties -> new KitchenSinkBlock(DyeColor.RED, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> YELLOW_SINK = register("yellow_sink",
            properties -> new KitchenSinkBlock(DyeColor.YELLOW, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> ORANGE_SINK = register("orange_sink",
            properties -> new KitchenSinkBlock(DyeColor.ORANGE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> MAGENTA_SINK = register("magenta_sink",
            properties -> new KitchenSinkBlock(DyeColor.MAGENTA, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> PURPLE_SINK = register("purple_sink",
            properties -> new KitchenSinkBlock(DyeColor.PURPLE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> PINK_SINK = register("pink_sink",
            properties -> new KitchenSinkBlock(DyeColor.PINK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BLUE_SINK = register("blue_sink",
            properties -> new KitchenSinkBlock(DyeColor.BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> LIGHT_BLUE_SINK = register("light_blue_sink",
            properties -> new KitchenSinkBlock(DyeColor.LIGHT_BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> CYAN_SINK = register("cyan_sink",
            properties -> new KitchenSinkBlock(DyeColor.CYAN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> GREEN_SINK = register("green_sink",
            properties -> new KitchenSinkBlock(DyeColor.GREEN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> LIME_SINK = register("lime_sink",
            properties -> new KitchenSinkBlock(DyeColor.LIME, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> GRAY_SINK = register("gray_sink",
            properties -> new KitchenSinkBlock(DyeColor.GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> LIGHT_GRAY_SINK = register("light_gray_sink",
            properties -> new KitchenSinkBlock(DyeColor.LIGHT_GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BLACK_SINK = register("black_sink",
            properties -> new KitchenSinkBlock(DyeColor.BLACK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BROWN_SINK = register("brown_sink",
            properties -> new KitchenSinkBlock(DyeColor.BROWN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> WHITE_SINK = register("white_sink",
            properties -> new KitchenSinkBlock(DyeColor.WHITE, properties.strength(2.5f).noOcclusion()));

    public static final ObjectRegistries<CabinetBlock> RED_CABINET = register("red_cabinet",
            properties -> new CabinetBlock(DyeColor.RED, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> YELLOW_CABINET = register("yellow_cabinet",
            properties -> new CabinetBlock(DyeColor.YELLOW, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> ORANGE_CABINET = register("orange_cabinet",
            properties -> new CabinetBlock(DyeColor.ORANGE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> MAGENTA_CABINET = register("magenta_cabinet",
            properties -> new CabinetBlock(DyeColor.MAGENTA, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> PURPLE_CABINET = register("purple_cabinet",
            properties -> new CabinetBlock(DyeColor.PURPLE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> PINK_CABINET = register("pink_cabinet",
            properties -> new CabinetBlock(DyeColor.PINK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BLUE_CABINET = register("blue_cabinet",
            properties -> new CabinetBlock(DyeColor.BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> LIGHT_BLUE_CABINET = register("light_blue_cabinet",
            properties -> new CabinetBlock(DyeColor.LIGHT_BLUE, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> CYAN_CABINET = register("cyan_cabinet",
            properties -> new CabinetBlock(DyeColor.CYAN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> GREEN_CABINET = register("green_cabinet",
            properties -> new CabinetBlock(DyeColor.GREEN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> LIME_CABINET = register("lime_cabinet",
            properties -> new CabinetBlock(DyeColor.LIME, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> GRAY_CABINET = register("gray_cabinet",
            properties -> new CabinetBlock(DyeColor.GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> LIGHT_GRAY_CABINET = register("light_gray_cabinet",
            properties -> new CabinetBlock(DyeColor.LIGHT_GRAY, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BLACK_CABINET = register("black_cabinet",
            properties -> new CabinetBlock(DyeColor.BLACK, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BROWN_CABINET = register("brown_cabinet",
            properties -> new CabinetBlock(DyeColor.BROWN, properties.strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> WHITE_CABINET = register("white_cabinet",
            properties -> new CabinetBlock(DyeColor.WHITE, properties.strength(2.5f).noOcclusion()));

    //STOOL
    public static final ObjectRegistries<StoolBlock> RED_STOOL = register("red_stool",
            properties -> new StoolBlock(DyeColor.RED, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> ORANGE_STOOL = register("orange_stool",
            properties -> new StoolBlock(DyeColor.ORANGE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> BLUE_STOOL = register("blue_stool",
            properties -> new StoolBlock(DyeColor.BLUE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> CYAN_STOOL = register("cyan_stool",
            properties -> new StoolBlock(DyeColor.CYAN, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> LIGHT_BLUE_STOOL = register("light_blue_stool",
            properties -> new StoolBlock(DyeColor.LIGHT_BLUE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> PURPLE_STOOL = register("purple_stool",
            properties -> new StoolBlock(DyeColor.PURPLE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> MAGENTA_STOOL = register("magenta_stool",
            properties -> new StoolBlock(DyeColor.MAGENTA, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> YELLOW_STOOL = register("yellow_stool",
            properties -> new StoolBlock(DyeColor.YELLOW, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> GREY_STOOL = register("grey_stool",
            properties -> new StoolBlock(DyeColor.GRAY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> LIGHT_GREY_STOOL = register("light_grey_stool",
            properties -> new StoolBlock(DyeColor.LIGHT_GRAY, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> BLACK_STOOL = register("black_stool",
            properties -> new StoolBlock(DyeColor.BLACK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> WHITE_STOOL = register("white_stool",
            properties -> new StoolBlock(DyeColor.WHITE, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> GREEN_STOOL = register("green_stool",
            properties -> new StoolBlock(DyeColor.GREEN, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> LIME_STOOL = register("lime_stool",
            properties -> new StoolBlock(DyeColor.LIME, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> PINK_STOOL = register("pink_stool",
            properties -> new StoolBlock(DyeColor.PINK, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> BROWN_STOOL = register("brown_stool",
            properties -> new StoolBlock(DyeColor.BROWN, properties.strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //COFFEE TABLE
    public static final ObjectRegistries<CoffeeTableBlock> OAK_COFFEE_TABLE = register("oak_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.OAK, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> SPRUCE_COFFEE_TABLE = register("spruce_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.SPRUCE, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> BIRCH_COFFEE_TABLE = register("birch_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.BIRCH, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> JUNGLE_COFFEE_TABLE = register("jungle_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.JUNGLE, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> ACACIA_COFFEE_TABLE = register("acacia_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.ACACIA, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> DARK_OAK_COFFEE_TABLE = register("dark_oak_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.DARK_OAK, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> MANGROVE_COFFEE_TABLE = register("mangrove_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.MANGROVE, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> CHERRY_COFFEE_TABLE = register("cherry_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.CHERRY, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> BAMBOO_COFFEE_TABLE = register("bamboo_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.BAMBOO, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> CRIMSON_COFFEE_TABLE = register("crimson_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.CRIMSON, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> WARPED_COFFEE_TABLE = register("warped_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.WARPED, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> PALE_OAK_COFFEE_TABLE = register("pale_oak_coffee_table",
            properties -> new CoffeeTableBlock(WoodType.PALE_OAK, properties.strength(2f).sound(SoundType.WOOD)));

    //Tables
    public static final ObjectRegistries<TableBlock> OAK_TABLE = register("oak_table",
            properties -> new TableBlock(WoodType.OAK, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> SPRUCE_TABLE = register("spruce_table",
            properties -> new TableBlock(WoodType.SPRUCE, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> BIRCH_TABLE = register("birch_table",
            properties -> new TableBlock(WoodType.BIRCH, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> JUNGLE_TABLE = register("jungle_table",
            properties -> new TableBlock(WoodType.JUNGLE, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> ACACIA_TABLE = register("acacia_table",
            properties -> new TableBlock(WoodType.ACACIA, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> DARK_OAK_TABLE = register("dark_oak_table",
            properties -> new TableBlock(WoodType.DARK_OAK, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> MANGROVE_TABLE = register("mangrove_table",
            properties -> new TableBlock(WoodType.MANGROVE, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> CHERRY_TABLE = register("cherry_table",
            properties -> new TableBlock(WoodType.CHERRY, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> BAMBOO_TABLE = register("bamboo_table",
            properties -> new TableBlock(WoodType.BAMBOO, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> CRIMSON_TABLE = register("crimson_table",
            properties -> new TableBlock(WoodType.CRIMSON, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> WARPED_TABLE = register("warped_table",
            properties -> new TableBlock(WoodType.WARPED, properties.strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> PALE_OAK_TABLE = register("pale_oak_table",
            properties -> new TableBlock(WoodType.PALE_OAK, properties.strength(2f).sound(SoundType.WOOD)));

    public static final ObjectRegistries<LampBlock> WHITE_LAMP = register("white_lamp",
            properties -> new LampBlock(DyeColor.WHITE,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> LIGHT_GRAY_LAMP = register("light_gray_lamp",
            properties -> new LampBlock(DyeColor.LIGHT_GRAY,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> GRAY_LAMP = register("gray_lamp",
            properties -> new LampBlock(DyeColor.GRAY,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> BLACK_LAMP = register("black_lamp",
            properties -> new LampBlock(DyeColor.BLACK,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> BROWN_LAMP = register("brown_lamp",
            properties -> new LampBlock(DyeColor.BROWN,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> RED_LAMP = register("red_lamp",
            properties -> new LampBlock(DyeColor.RED,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> ORANGE_LAMP = register("orange_lamp",
            properties -> new LampBlock(DyeColor.ORANGE,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> YELLOW_LAMP = register("yellow_lamp",
            properties -> new LampBlock(DyeColor.YELLOW,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> LIME_LAMP = register("lime_lamp",
            properties -> new LampBlock(DyeColor.LIME,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> GREEN_LAMP = register("green_lamp",
            properties -> new LampBlock(DyeColor.GREEN,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> CYAN_LAMP = register("cyan_lamp",
            properties -> new LampBlock(DyeColor.CYAN,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> LIGHT_BLUE_LAMP = register("light_blue_lamp",
            properties -> new LampBlock(DyeColor.LIGHT_BLUE,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> BLUE_LAMP = register("blue_lamp",
            properties -> new LampBlock(DyeColor.BLUE,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> PURPLE_LAMP = register("purple_lamp",
            properties -> new LampBlock(DyeColor.PURPLE,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> MAGENTA_LAMP = register("magenta_lamp",
            properties -> new LampBlock(DyeColor.MAGENTA,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> PINK_LAMP = register("pink_lamp",
            properties -> new LampBlock(DyeColor.PINK,  properties.strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));




    //Digital Clock
    public static final ObjectRegistries<DigitalClockBlock> RED_DIGITAL_CLOCK = register("red_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.RED, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> ORANGE_DIGITAL_CLOCK = register("orange_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.ORANGE, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> YELLOW_DIGITAL_CLOCK = register("yellow_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.YELLOW, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> MAGENTA_DIGITAL_CLOCK = register("magenta_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.MAGENTA, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> PINK_DIGITAL_CLOCK = register("pink_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.PINK, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> PURPLE_DIGITAL_CLOCK = register("purple_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.PURPLE, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> BLUE_DIGITAL_CLOCK = register("blue_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.BLUE, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> LIGHT_BLUE_DIGITAL_CLOCK = register("light_blue_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.LIGHT_BLUE, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> CYAN_DIGITAL_CLOCK = register("cyan_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.CYAN, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> GREEN_DIGITAL_CLOCK = register("green_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.GREEN, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> LIME_DIGITAL_CLOCK = register("lime_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.LIME, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> GRAY_DIGITAL_CLOCK = register("gray_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.GRAY, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> LIGHT_GRAY_DIGITAL_CLOCK = register("light_gray_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.LIGHT_GRAY, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> BROWN_DIGITAL_CLOCK = register("brown_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.BROWN, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> BLACK_DIGITAL_CLOCK = register("black_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.BLACK, properties.sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> WHITE_DIGITAL_CLOCK = register("white_digital_clock",
            properties -> new DigitalClockBlock(DyeColor.WHITE, properties.sound(SoundType.DECORATED_POT).strength(2f)));

    public static final ObjectRegistries<WoodenClockBlock> OAK_CLOCK = register("oak_clock",
            properties -> new WoodenClockBlock(WoodType.OAK, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> SPRUCE_CLOCK = register("spruce_clock",
            properties -> new WoodenClockBlock(WoodType.SPRUCE, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> BIRCH_CLOCK = register("birch_clock",
            properties -> new WoodenClockBlock(WoodType.BIRCH, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> JUNGLE_CLOCK = register("jungle_clock",
            properties -> new WoodenClockBlock(WoodType.JUNGLE, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> ACACIA_CLOCK = register("acacia_clock",
            properties -> new WoodenClockBlock(WoodType.ACACIA, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> DARK_OAK_CLOCK = register("dark_oak_clock",
            properties -> new WoodenClockBlock(WoodType.DARK_OAK, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> MANGROVE_CLOCK = register("mangrove_clock",
            properties -> new WoodenClockBlock(WoodType.MANGROVE, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> CHERRY_CLOCK = register("cherry_clock",
            properties -> new WoodenClockBlock(WoodType.CHERRY, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> BAMBOO_CLOCK = register("bamboo_clock",
            properties -> new WoodenClockBlock(WoodType.BAMBOO, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> CRIMSON_CLOCK = register("crimson_clock",
            properties -> new WoodenClockBlock(WoodType.CRIMSON, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> WARPED_CLOCK = register("warped_clock",
            properties -> new WoodenClockBlock(WoodType.WARPED, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> PALE_OAK_CLOCK = register("pale_oak_clock",
            properties -> new WoodenClockBlock(WoodType.PALE_OAK, properties.strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));








    //Glass Tecque
    public static final ObjectRegistries<TecqueBlock> ACACIA_GLASS_TECQUE = register("acacia_glass_tecque",
            properties -> new TecqueBlock(WoodType.ACACIA, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> SPRUCE_GLASS_TECQUE = register("spruce_glass_tecque",
            properties -> new TecqueBlock(WoodType.SPRUCE, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> OAK_GLASS_TECQUE = register("oak_glass_tecque",
            properties -> new TecqueBlock(WoodType.OAK, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> BIRCH_GLASS_TECQUE = register("birch_glass_tecque",
            properties -> new TecqueBlock(WoodType.BIRCH, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> JUNGLE_GLASS_TECQUE = register("jungle_glass_tecque",
            properties -> new TecqueBlock(WoodType.JUNGLE, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> MANGROVE_GLASS_TECQUE = register("mangrove_glass_tecque",
            properties -> new TecqueBlock(WoodType.MANGROVE, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> DARK_OAK_GLASS_TECQUE = register("dark_oak_glass_tecque",
            properties -> new TecqueBlock(WoodType.DARK_OAK, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> CHERRY_GLASS_TECQUE = register("cherry_glass_tecque",
            properties -> new TecqueBlock(WoodType.CHERRY, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> BAMBOO_GLASS_TECQUE = register("bamboo_glass_tecque",
            properties -> new TecqueBlock(WoodType.BAMBOO, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> CRIMSON_GLASS_TECQUE = register("crimson_glass_tecque",
            properties -> new TecqueBlock(WoodType.CRIMSON, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> WARPED_GLASS_TECQUE = register("warped_glass_tecque",
            properties -> new TecqueBlock(WoodType.WARPED, properties.strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> PALE_OAK_GLASS_TECQUE = register("pale_oak_glass_tecque",
            properties -> new TecqueBlock(WoodType.PALE_OAK, properties.strength(3f).noOcclusion()));


    private static <T extends Block> ObjectRegistries<T> register(String name, Function<BlockBehaviour.Properties, T> function) {
        ObjectRegistries<T> entry = ObjectRegistries.registerBlock(Constants.id(name), function);
        BLOCKS.add(entry);
        return entry;
    }

    public static void init() {}

}