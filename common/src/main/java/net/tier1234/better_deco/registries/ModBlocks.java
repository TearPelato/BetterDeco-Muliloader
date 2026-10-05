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
import java.util.function.Supplier;

public class ModBlocks {
    public static final List<ObjectRegistries<? extends Block>> BLOCKS = new ArrayList<>();
    

    //Test
    public static final ObjectRegistries<WorkbenchBlock> WORKBENCH = register("workbench",
            ()-> new WorkbenchBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));


    public static final ObjectRegistries<BathBlock> OAK_BATH = register("oak_bath",
            ()-> new BathBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> SPRUCE_BATH = register("spruce_bath",
            ()-> new BathBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> BIRCH_BATH = register("birch_bath",
            ()-> new BathBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> JUNGLE_BATH = register("jungle_bath",
            ()-> new BathBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> ACACIA_BATH = register("acacia_bath",
            ()-> new BathBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> DARK_OAK_BATH = register("dark_oak_bath",
            ()-> new BathBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> MANGROVE_BATH = register("mangrove_bath",
            ()-> new BathBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> CHERRY_BATH = register("cherry_bath",
            ()-> new BathBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> BAMBOO_BATH = register("bamboo_bath",
            ()-> new BathBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> CRIMSON_BATH = register("crimson_bath",
            ()-> new BathBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BathBlock> WARPED_BATH = register("warped_bath",
            ()-> new BathBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));




    public static final ObjectRegistries<ToiletBlock> OAK_TOILET = register("oak_toilet",
            ()-> new ToiletBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> SPRUCE_TOILET = register("spruce_toilet",
            ()-> new ToiletBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> BIRCH_TOILET = register("birch_toilet",
            ()-> new ToiletBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> JUNGLE_TOILET = register("jungle_toilet",
            ()-> new ToiletBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> ACACIA_TOILET = register("acacia_toilet",
            ()-> new ToiletBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> DARK_OAK_TOILET = register("dark_oak_toilet",
            ()-> new ToiletBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> MANGROVE_TOILET = register("mangrove_toilet",
            ()-> new ToiletBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> CHERRY_TOILET = register("cherry_toilet",
            ()-> new ToiletBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> BAMBOO_TOILET = register("bamboo_toilet",
            ()-> new ToiletBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> CRIMSON_TOILET = register("crimson_toilet",
            ()-> new ToiletBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ToiletBlock> WARPED_TOILET = register("warped_toilet",
            ()-> new ToiletBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));














    public static final ObjectRegistries<BasinBlock> OAK_BASIN = register("oak_basin",
            ()-> new BasinBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> SPRUCE_BASIN = register("spruce_basin",
            ()-> new BasinBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> BIRCH_BASIN = register("birch_basin",
            ()-> new BasinBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> JUNGLE_BASIN = register("jungle_basin",
            ()-> new BasinBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> ACACIA_BASIN = register("acacia_basin",
            ()-> new BasinBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> DARK_OAK_BASIN = register("dark_oak_basin",
            ()-> new BasinBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> MANGROVE_BASIN = register("mangrove_basin",
            ()-> new BasinBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> CHERRY_BASIN = register("cherry_basin",
            ()-> new BasinBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> BAMBOO_BASIN = register("bamboo_basin",
            ()-> new BasinBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> CRIMSON_BASIN = register("crimson_basin",
            ()-> new BasinBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<BasinBlock> WARPED_BASIN = register("warped_basin",
            ()-> new BasinBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));



    public static final ObjectRegistries<JarBlock> OAK_JAR = register("oak_jar",
            ()-> new JarBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> SPRUCE_JAR = register("spruce_jar",
            ()-> new JarBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> BIRCH_JAR = register("birch_jar",
            ()-> new JarBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> JUNGLE_JAR = register("jungle_jar",
            ()-> new JarBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> ACACIA_JAR = register("acacia_jar",
            ()-> new JarBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> DARK_OAK_JAR = register("dark_oak_jar",
            ()-> new JarBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> MANGROVE_JAR = register("mangrove_jar",
            ()-> new JarBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> CHERRY_JAR = register("cherry_jar",
            ()-> new JarBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> BAMBOO_JAR = register("bamboo_jar",
            ()-> new JarBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> CRIMSON_JAR = register("crimson_jar",
            ()-> new JarBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(1.0F)));
    public static final ObjectRegistries<JarBlock> WARPED_JAR = register("warped_jar",
            ()-> new JarBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(1.0F)));






    public static final ObjectRegistries<CuttingBoardBlock> OAK_CUTTING_BOARD = register("oak_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> SPRUCE_CUTTING_BOARD = register("spruce_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> BIRCH_CUTTING_BOARD = register("birch_cutting_board",
                ()-> new CuttingBoardBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> JUNGLE_CUTTING_BOARD = register("jungle_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> ACACIA_CUTTING_BOARD = register("acacia_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> DARK_OAK_CUTTING_BOARD = register("dark_oak_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> MANGROVE_CUTTING_BOARD = register("mangrove_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> CHERRY_CUTTING_BOARD = register("cherry_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> BAMBOO_CUTTING_BOARD = register("bamboo_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> CRIMSON_CUTTING_BOARD = register("crimson_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<CuttingBoardBlock> WARPED_CUTTING_BOARD = register("warped_cutting_board",
            ()-> new CuttingBoardBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.5f)));





    //Desk
    public static final ObjectRegistries<DeskBlock> OAK_DESK = register("oak_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.OAK));
    public static final ObjectRegistries<DeskBlock> SPRUCE_DESK = register("spruce_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.SPRUCE));
    public static final ObjectRegistries<DeskBlock> BIRCH_DESK = register("birch_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.BIRCH));
    public static final ObjectRegistries<DeskBlock> JUNGLE_DESK = register("jungle_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.JUNGLE));
    public static final ObjectRegistries<DeskBlock> ACACIA_DESK = register("acacia_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.ACACIA));
    public static final ObjectRegistries<DeskBlock> MANGROVE_DESK = register("mangrove_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.MANGROVE));
    public static final ObjectRegistries<DeskBlock> DARK_OAK_DESK = register("dark_oak_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.DARK_OAK));
    public static final ObjectRegistries<DeskBlock> CHERRY_DESK = register("cherry_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.CHERRY));
    public static final ObjectRegistries<DeskBlock> BAMBOO_DESK = register("bamboo_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.BAMBOO));
    public static final ObjectRegistries<DeskBlock> CRIMSON_DESK = register("crimson_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.CRIMSON));
    public static final ObjectRegistries<DeskBlock> WARPED_DESK = register("warped_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.WARPED));

    public static final ObjectRegistries<DeskCabinetBlock> OAK_DESK_CABINET = register("oak_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.OAK));
    public static final ObjectRegistries<DeskCabinetBlock> SPRUCE_DESK_CABINET = register("spruce_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.SPRUCE));
    public static final ObjectRegistries<DeskCabinetBlock> BIRCH_DESK_CABINET = register("birch_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.BIRCH));
    public static final ObjectRegistries<DeskCabinetBlock> JUNGLE_DESK_CABINET = register("jungle_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.JUNGLE));
    public static final ObjectRegistries<DeskCabinetBlock> ACACIA_DESK_CABINET = register("acacia_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.ACACIA));
    public static final ObjectRegistries<DeskCabinetBlock> MANGROVE_DESK_CABINET = register("mangrove_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.MANGROVE));
    public static final ObjectRegistries<DeskCabinetBlock> DARK_OAK_DESK_CABINET = register("dark_oak_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.DARK_OAK));
    public static final ObjectRegistries<DeskCabinetBlock> CHERRY_DESK_CABINET = register("cherry_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.CHERRY));
    public static final ObjectRegistries<DeskCabinetBlock> BAMBOO_DESK_CABINET = register("bamboo_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.BAMBOO));
    public static final ObjectRegistries<DeskCabinetBlock> CRIMSON_DESK_CABINET = register("crimson_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.CRIMSON));
    public static final ObjectRegistries<DeskCabinetBlock> WARPED_DESK_CABINET = register("warped_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.WARPED));

    //Path
    public static final ObjectRegistries<PathBlock> STONE_PATH = register("stone_path",
            ()-> new PathBlock(StoneType.STONE,BlockBehaviour.Properties.of().strength(3.1f)));
    public static final ObjectRegistries<PathBlock> ANDESITE_PATH = register("andesite_path",
            ()-> new PathBlock(StoneType.ANDESITE,BlockBehaviour.Properties.of().strength(3.1f)));
    public static final ObjectRegistries<PathBlock> GRANITE_PATH = register("granite_path",
            ()-> new PathBlock(StoneType.GRANITE,BlockBehaviour.Properties.of().strength(3.1f)));
    public static final ObjectRegistries<PathBlock> DIORITE_PATH = register("diorite_path",
            ()-> new PathBlock(StoneType.DIORITE,BlockBehaviour.Properties.of().strength(3.1f)));
    public static final ObjectRegistries<PathBlock> DEEPSLATE_PATH = register("deepslate_path",
            ()-> new PathBlock(StoneType.DEEPSLATE,BlockBehaviour.Properties.of().strength(3.1f)));




    //PARK BENCH
    public static final ObjectRegistries<ParkBenchBlock> OAK_PARK_BENCH = register("oak_park_bench",
            ()-> new ParkBenchBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> SPRUCE_PARK_BENCH = register("spruce_park_bench",
            ()-> new ParkBenchBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> BIRCH_PARK_BENCH = register("birch_park_bench",
            ()-> new ParkBenchBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> JUNGLE_PARK_BENCH = register("jungle_park_bench",
            ()-> new ParkBenchBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> ACACIA_PARK_BENCH = register("acacia_park_bench",
            ()-> new ParkBenchBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> DARK_OAK_PARK_BENCH = register("dark_oak_park_bench",
            ()-> new ParkBenchBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> MANGROVE_PARK_BENCH = register("mangrove_park_bench",
            ()-> new ParkBenchBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> CHERRY_PARK_BENCH = register("cherry_park_bench",
            ()-> new ParkBenchBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> BAMBOO_PARK_BENCH = register("bamboo_park_bench",
            ()-> new ParkBenchBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> CRIMSON_PARK_BENCH = register("crimson_park_bench",
            ()-> new ParkBenchBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.5f)));
    public static final ObjectRegistries<ParkBenchBlock> WARPED_PARK_BENCH = register("warped_park_bench",
            ()-> new ParkBenchBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.5f)));

    public static final ObjectRegistries<ToasterBlock> TOASTER_LIGHT = register("toaster_light",
            ()->  new ToasterBlock(MetalType.LIGHT,BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final ObjectRegistries<ToasterBlock> TOASTER_DARK = register("toaster_dark",
            ()->  new ToasterBlock(MetalType.DARK,BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //FRIDGE & FREEZERS
    public static final ObjectRegistries<FridgeBlock> FRIDGE_LIGHT = register("fridge_light",
            () -> new FridgeBlock(MetalType.LIGHT,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<FridgeBlock> FRIDGE_DARK = register("fridge_dark",
            () -> new FridgeBlock(MetalType.DARK,BlockBehaviour.Properties.of()));

    public static final ObjectRegistries<MicrowaveBlock> LIGHT_MICROWAVE = register("microwave_light",
            ()-> new MicrowaveBlock(MetalType.LIGHT,BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final ObjectRegistries<MicrowaveBlock> DARK_MICROWAVE = register("microwave_dark",
            ()-> new MicrowaveBlock(MetalType.DARK,BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));

    //Oven
    public static final ObjectRegistries<OvenBlock> OAK_OVEN = register("oak_oven",
            ()-> new OvenBlock(WoodType.OAK,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> SPRUCE_OVEN = register("spruce_oven",
            ()-> new OvenBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> BIRCH_OVEN = register("birch_oven",
            ()-> new OvenBlock(WoodType.BIRCH,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> JUNGLE_OVEN = register("jungle_oven",
            ()-> new OvenBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> ACACIA_OVEN = register("acacia_oven",
            ()-> new OvenBlock(WoodType.ACACIA,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> DARK_OAK_OVEN = register("dark_oak_oven",
            ()-> new OvenBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> MANGROVE_OVEN = register("mangrove_oven",
            ()-> new OvenBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> CHERRY_OVEN = register("cherry_oven",
            ()-> new OvenBlock(WoodType.CHERRY,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> BAMBOO_OVEN = register("bamboo_oven",
            ()-> new OvenBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> CRIMSON_OVEN = register("crimson_oven",
            ()-> new OvenBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of()));
    public static final ObjectRegistries<OvenBlock> WARPED_OVEN = register("warped_oven",
            ()-> new OvenBlock(WoodType.WARPED,BlockBehaviour.Properties.of()));


    //SHELFS
    public static final ObjectRegistries<ShelfBlock> OAK_SHELF = register("oak_shelf",
            ()-> new ShelfBlock(WoodType.OAK,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> SPRUCE_SHELF = register("spruce_shelf",
            ()-> new ShelfBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> BIRCH_SHELF = register("birch_shelf",
            ()-> new ShelfBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> JUNGLE_SHELF = register("jungle_shelf",
            ()-> new ShelfBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> ACACIA_SHELF = register("acacia_shelf",
            ()-> new ShelfBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> DARK_OAK_SHELF = register("dark_oak_shelf",
            ()-> new ShelfBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> MANGROVE_SHELF = register("mangrove_shelf",
            ()-> new ShelfBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> CHERRY_SHELF = register("cherry_shelf",
            ()-> new ShelfBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> BAMBOO_SHELF = register("bamboo_shelf",
            ()-> new ShelfBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> CRIMSON_SHELF = register("crimson_shelf",
            ()-> new ShelfBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<ShelfBlock> WARPED_SHELF = register("warped_shelf",
            ()-> new ShelfBlock(WoodType.WARPED,BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2.0f).sound(SoundType.WOOD)));

    //Furnitures
    //Chairs
    public static final ObjectRegistries<ChairBlock> OAK_CHAIR = register("oak_chair",
            () -> new ChairBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> SPRUCE_CHAIR = register("spruce_chair",
            () -> new ChairBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> BIRCH_CHAIR = register("birch_chair",
            () -> new ChairBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> JUNGLE_CHAIR = register("jungle_chair",
            () -> new ChairBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> ACACIA_CHAIR = register("acacia_chair",
            () -> new ChairBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> DARK_OAK_CHAIR = register("dark_oak_chair",
            () -> new ChairBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> MANGROVE_CHAIR = register("mangrove_chair",
            () -> new ChairBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> CHERRY_CHAIR = register("cherry_chair",
            () -> new ChairBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> BAMBOO_CHAIR = register("bamboo_chair",
            () -> new ChairBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> CRIMSON_CHAIR = register("crimson_chair",
            () -> new ChairBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<ChairBlock> WARPED_CHAIR = register("warped_chair",
            () -> new ChairBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Counters
    public static final ObjectRegistries<KitchenCounterBlock> OAK_KITCHEN_COUNTER = register("oak_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> SPRUCE_KITCHEN_COUNTER = register("spruce_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BIRCH_KITCHEN_COUNTER = register("birch_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> JUNGLE_KITCHEN_COUNTER = register("jungle_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> ACACIA_KITCHEN_COUNTER = register("acacia_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> DARK_OAK_KITCHEN_COUNTER = register("dark_oak_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> MANGROVE_KITCHEN_COUNTER = register("mangrove_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> CHERRY_KITCHEN_COUNTER = register("cherry_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BAMBOO_KITCHEN_COUNTER = register("bamboo_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> CRIMSON_KITCHEN_COUNTER = register("crimson_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> WARPED_KITCHEN_COUNTER = register("warped_kitchen_counter",
            ()-> new KitchenCounterBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Drawers
    public static final ObjectRegistries<KitchenDrawerBlock> OAK_KITCHEN_DRAWER = register("oak_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> SPRUCE_KITCHEN_DRAWER = register("spruce_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BIRCH_KITCHEN_DRAWER = register("birch_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> JUNGLE_KITCHEN_DRAWER = register("jungle_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> ACACIA_KITCHEN_DRAWER = register("acacia_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> DARK_OAK_KITCHEN_DRAWER = register("dark_oak_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> MANGROVE_KITCHEN_DRAWER = register("mangrove_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> CHERRY_KITCHEN_DRAWER = register("cherry_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BAMBOO_KITCHEN_DRAWER = register("bamboo_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> CRIMSON_KITCHEN_DRAWER = register("crimson_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> WARPED_KITCHEN_DRAWER = register("warped_kitchen_drawer",
            ()-> new KitchenDrawerBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

        //Sofas
    public static final ObjectRegistries<SofaBlock> RED_SOFA = register("red_sofa",
            ()-> new SofaBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> ORANGE_SOFA = register("orange_sofa",
            ()-> new SofaBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> BLUE_SOFA = register("blue_sofa",
            ()-> new SofaBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> CYAN_SOFA = register("cyan_sofa",
            ()-> new SofaBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> LIGHT_BLUE_SOFA = register("light_blue_sofa",
            ()-> new SofaBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> PURPLE_SOFA = register("purple_sofa",
            ()-> new SofaBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> MAGENTA_SOFA = register("magenta_sofa",
            ()-> new SofaBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> YELLOW_SOFA = register("yellow_sofa",
            ()-> new SofaBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> GREY_SOFA = register("grey_sofa",
            ()-> new SofaBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> LIGHT_GREY_SOFA = register("light_grey_sofa",
            ()-> new SofaBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> BLACK_SOFA = register("black_sofa",
            ()-> new SofaBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> WHITE_SOFA = register("white_sofa",
            ()-> new SofaBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> GREEN_SOFA = register("green_sofa",
            ()-> new SofaBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> LIME_SOFA = register("lime_sofa",
            ()-> new SofaBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> PINK_SOFA = register("pink_sofa",
            ()-> new SofaBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<SofaBlock> BROWN_SOFA = register("brown_sofa",
            ()-> new SofaBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Cabinet
    public static final ObjectRegistries<CabinetBlock> OAK_CABINET = register("oak_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> SPRUCE_CABINET = register("spruce_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BIRCH_CABINET = register("birch_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> JUNGLE_CABINET = register("jungle_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> ACACIA_CABINET = register("acacia_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> DARK_OAK_CABINET = register("dark_oak_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> MANGROVE_CABINET = register("mangrove_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> CHERRY_CABINET = register("cherry_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BAMBOO_CABINET = register("bamboo_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> CRIMSON_CABINET = register("crimson_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> WARPED_CABINET = register("warped_kitchen_cabinet",
            ()-> new CabinetBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Bedside Cabinets
    public static final ObjectRegistries<BedsideCabinetBlock> OAK_BEDSIDE = register("oak_bedside",
            ()-> new BedsideCabinetBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> SPRUCE_BEDSIDE = register("spruce_bedside",
            ()-> new BedsideCabinetBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> BIRCH_BEDSIDE = register("birch_bedside",
            ()-> new BedsideCabinetBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> JUNGLE_BEDSIDE = register("jungle_bedside",
            ()-> new BedsideCabinetBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> ACACIA_BEDSIDE = register("acacia_bedside",
            ()-> new BedsideCabinetBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> MANGROVE_BEDSIDE = register("mangrove_bedside",
            ()-> new BedsideCabinetBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> DARK_OAK_BEDSIDE = register("dark_oak_bedside",
            ()-> new BedsideCabinetBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> CHERRY_BEDSIDE = register("cherry_bedside",
            ()-> new BedsideCabinetBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> BAMBOO_BEDSIDE = register("bamboo_bedside",
            ()-> new BedsideCabinetBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> CRIMSON_BEDSIDE = register("crimson_bedside",
            ()-> new BedsideCabinetBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<BedsideCabinetBlock> WARPED_BEDSIDE = register("warped_bedside",
            ()-> new BedsideCabinetBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Crates
    public static final ObjectRegistries<CrateBlock> OAK_CRATE = register("oak_storage_crate",
            ()-> new CrateBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> SPRUCE_CRATE = register("spruce_storage_crate",
            ()-> new CrateBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> BIRCH_CRATE = register("birch_storage_crate",
            ()-> new CrateBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> JUNGLE_CRATE = register("jungle_storage_crate",
            ()-> new CrateBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> ACACIA_CRATE = register("acacia_storage_crate",
            ()-> new CrateBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> MANGROVE_CRATE = register("mangrove_storage_crate",
            ()-> new CrateBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> DARK_OAK_CRATE = register("dark_oak_storage_crate",
            ()-> new CrateBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> CHERRY_CRATE = register("cherry_storage_crate",
            ()-> new CrateBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> BAMBOO_CRATE = register("bamboo_storage_crate",
            ()-> new CrateBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> CRIMSON_CRATE = register("crimson_storage_crate",
            ()-> new CrateBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<CrateBlock> WARPED_CRATE = register("warped_storage_crate",
            ()-> new CrateBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Sinks
    public static final ObjectRegistries<KitchenSinkBlock> OAK_SINK = register("oak_sink",
            () -> new KitchenSinkBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> SPRUCE_SINK = register("spruce_sink",
            () -> new KitchenSinkBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BIRCH_SINK = register("birch_sink",
            () -> new KitchenSinkBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> JUNGLE_SINK = register("jungle_sink",
            () -> new KitchenSinkBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> ACACIA_SINK = register("acacia_sink",
            () -> new KitchenSinkBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> MANGROVE_SINK = register("mangrove_sink",
            () -> new KitchenSinkBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> DARK_OAK_SINK = register("dark_oak_sink",
            () -> new KitchenSinkBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> CHERRY_SINK = register("cherry_sink",
            () -> new KitchenSinkBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BAMBOO_SINK = register("bamboo_sink",
            () -> new KitchenSinkBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> CRIMSON_SINK = register("crimson_sink",
            () -> new KitchenSinkBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> WARPED_SINK = register("warped_sink",
            () -> new KitchenSinkBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //Colored Variants
    public static final ObjectRegistries<KitchenCounterBlock> RED_KITCHEN_COUNTER = register("red_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> YELLOW_KITCHEN_COUNTER = register("yellow_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> ORANGE_KITCHEN_COUNTER = register("orange_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> MAGENTA_KITCHEN_COUNTER = register("magenta_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> PURPLE_KITCHEN_COUNTER = register("purple_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> PINK_KITCHEN_COUNTER = register("pink_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BLUE_KITCHEN_COUNTER = register("blue_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> LIGHT_BLUE_KITCHEN_COUNTER = register("light_blue_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> CYAN_KITCHEN_COUNTER = register("cyan_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> GREEN_KITCHEN_COUNTER = register("green_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> LIME_KITCHEN_COUNTER = register("lime_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> GRAY_KITCHEN_COUNTER = register("gray_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> LIGHT_GRAY_KITCHEN_COUNTER = register("light_gray_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BLACK_KITCHEN_COUNTER = register("black_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> BROWN_KITCHEN_COUNTER = register("brown_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenCounterBlock> WHITE_KITCHEN_COUNTER = register("white_kitchen_counter",
            ()-> new KitchenCounterBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Colored Drawers
    public static final ObjectRegistries<KitchenDrawerBlock> RED_KITCHEN_DRAWER = register("red_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> YELLOW_KITCHEN_DRAWER = register("yellow_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> ORANGE_KITCHEN_DRAWER = register("orange_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> MAGENTA_KITCHEN_DRAWER = register("magenta_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> PURPLE_KITCHEN_DRAWER = register("purple_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> PINK_KITCHEN_DRAWER = register("pink_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BLUE_KITCHEN_DRAWER = register("blue_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> LIGHT_BLUE_KITCHEN_DRAWER = register("light_blue_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> CYAN_KITCHEN_DRAWER = register("cyan_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> GREEN_KITCHEN_DRAWER = register("green_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> LIME_KITCHEN_DRAWER = register("lime_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> GRAY_KITCHEN_DRAWER = register("gray_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> LIGHT_GRAY_KITCHEN_DRAWER = register("light_gray_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BLACK_KITCHEN_DRAWER = register("black_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> BROWN_KITCHEN_DRAWER = register("brown_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenDrawerBlock> WHITE_KITCHEN_DRAWER = register("white_kitchen_drawer",
            ()-> new KitchenDrawerBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Oven colored
    public static final ObjectRegistries<OvenBlock> RED_OVEN = register("red_oven",
            ()-> new OvenBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> YELLOW_OVEN = register("yellow_oven",
            ()-> new OvenBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> ORANGE_OVEN = register("orange_oven",
            ()-> new OvenBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> MAGENTA_OVEN = register("magenta_oven",
            ()-> new OvenBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> PURPLE_OVEN = register("purple_oven",
            ()-> new OvenBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> PINK_OVEN = register("pink_oven",
            ()-> new OvenBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> BLUE_OVEN = register("blue_oven",
            ()-> new OvenBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> LIGHT_BLUE_OVEN = register("light_blue_oven",
            ()-> new OvenBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> CYAN_OVEN = register("cyan_oven",
            ()-> new OvenBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> GREEN_OVEN = register("green_oven",
            ()-> new OvenBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> LIME_OVEN = register("lime_oven",
            ()-> new OvenBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> GRAY_OVEN = register("gray_oven",
            ()-> new OvenBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> LIGHT_GRAY_OVEN = register("light_gray_oven",
            ()-> new OvenBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> BLACK_OVEN = register("black_oven",
            ()-> new OvenBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> BROWN_OVEN = register("brown_oven",
            ()-> new OvenBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<OvenBlock> WHITE_OVEN = register("white_oven",
            ()-> new OvenBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    public static final ObjectRegistries<KitchenSinkBlock> RED_SINK = register("red_sink",
            ()-> new KitchenSinkBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> YELLOW_SINK = register("yellow_sink",
            ()-> new KitchenSinkBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> ORANGE_SINK = register("orange_sink",
            ()-> new KitchenSinkBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> MAGENTA_SINK = register("magenta_sink",
            ()-> new KitchenSinkBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> PURPLE_SINK = register("purple_sink",
            ()-> new KitchenSinkBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> PINK_SINK = register("pink_sink",
            ()-> new KitchenSinkBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BLUE_SINK = register("blue_sink",
            ()-> new KitchenSinkBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> LIGHT_BLUE_SINK = register("light_blue_sink",
            ()-> new KitchenSinkBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> CYAN_SINK = register("cyan_sink",
            ()-> new KitchenSinkBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> GREEN_SINK = register("green_sink",
            ()-> new KitchenSinkBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> LIME_SINK = register("lime_sink",
            ()-> new KitchenSinkBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> GRAY_SINK = register("gray_sink",
            ()-> new KitchenSinkBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> LIGHT_GRAY_SINK = register("light_gray_sink",
            ()-> new KitchenSinkBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BLACK_SINK = register("black_sink",
            ()-> new KitchenSinkBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> BROWN_SINK = register("brown_sink",
            ()-> new KitchenSinkBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<KitchenSinkBlock> WHITE_SINK = register("white_sink",
            ()-> new KitchenSinkBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    public static final ObjectRegistries<CabinetBlock> RED_CABINET = register("red_cabinet",
            ()-> new CabinetBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> YELLOW_CABINET = register("yellow_cabinet",
            ()-> new CabinetBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> ORANGE_CABINET = register("orange_cabinet",
            ()-> new CabinetBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> MAGENTA_CABINET = register("magenta_cabinet",
            ()-> new CabinetBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> PURPLE_CABINET = register("purple_cabinet",
            ()-> new CabinetBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> PINK_CABINET = register("pink_cabinet",
            ()-> new CabinetBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BLUE_CABINET = register("blue_cabinet",
            ()-> new CabinetBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> LIGHT_BLUE_CABINET = register("light_blue_cabinet",
            ()-> new CabinetBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> CYAN_CABINET = register("cyan_cabinet",
            ()-> new CabinetBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> GREEN_CABINET = register("green_cabinet",
            ()-> new CabinetBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> LIME_CABINET = register("lime_cabinet",
            ()-> new CabinetBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> GRAY_CABINET = register("gray_cabinet",
            ()-> new CabinetBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> LIGHT_GRAY_CABINET = register("light_gray_cabinet",
            ()-> new CabinetBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BLACK_CABINET = register("black_cabinet",
            ()-> new CabinetBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> BROWN_CABINET = register("brown_cabinet",
            ()-> new CabinetBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final ObjectRegistries<CabinetBlock> WHITE_CABINET = register("white_cabinet",
            ()-> new CabinetBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //STOOL
    public static final ObjectRegistries<StoolBlock> RED_STOOL = register("red_stool",
            ()-> new StoolBlock(DyeColor.RED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> ORANGE_STOOL = register("orange_stool",
            ()-> new StoolBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> BLUE_STOOL = register("blue_stool",
            ()-> new StoolBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> CYAN_STOOL = register("cyan_stool",
            ()-> new StoolBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> LIGHT_BLUE_STOOL = register("light_blue_stool",
            ()-> new StoolBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> PURPLE_STOOL = register("purple_stool",
            ()-> new StoolBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> MAGENTA_STOOL = register("magenta_stool",
            ()-> new StoolBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> YELLOW_STOOL = register("yellow_stool",
            ()-> new StoolBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> GREY_STOOL = register("grey_stool",
            ()-> new StoolBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> LIGHT_GREY_STOOL = register("light_grey_stool",
            ()-> new StoolBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> BLACK_STOOL = register("black_stool",
            ()-> new StoolBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> WHITE_STOOL = register("white_stool",
            ()-> new StoolBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> GREEN_STOOL = register("green_stool",
            ()-> new StoolBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> LIME_STOOL = register("lime_stool",
            ()-> new StoolBlock(DyeColor.LIME,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> PINK_STOOL = register("pink_stool",
            ()-> new StoolBlock(DyeColor.PINK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));
    public static final ObjectRegistries<StoolBlock> BROWN_STOOL = register("brown_stool",
            ()-> new StoolBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).noOcclusion()));

    //COFFEE TABLE
    public static final ObjectRegistries<CoffeeTableBlock> OAK_COFFEE_TABLE = register("oak_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> SPRUCE_COFFEE_TABLE = register("spruce_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> BIRCH_COFFEE_TABLE = register("birch_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> JUNGLE_COFFEE_TABLE = register("jungle_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> ACACIA_COFFEE_TABLE = register("acacia_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> DARK_OAK_COFFEE_TABLE = register("dark_oak_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> MANGROVE_COFFEE_TABLE = register("mangrove_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> CHERRY_COFFEE_TABLE = register("cherry_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> BAMBOO_COFFEE_TABLE = register("bamboo_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> CRIMSON_COFFEE_TABLE = register("crimson_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<CoffeeTableBlock> WARPED_COFFEE_TABLE = register("warped_coffee_table",
            ()-> new CoffeeTableBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    //Tables
    public static final ObjectRegistries<TableBlock> OAK_TABLE = register("oak_table",
            ()-> new TableBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> SPRUCE_TABLE = register("spruce_table",
            ()-> new TableBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> BIRCH_TABLE = register("birch_table",
            ()-> new TableBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> JUNGLE_TABLE = register("jungle_table",
            ()-> new TableBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> ACACIA_TABLE = register("acacia_table",
            ()-> new TableBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> DARK_OAK_TABLE = register("dark_oak_table",
            ()-> new TableBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> MANGROVE_TABLE = register("mangrove_table",
            ()-> new TableBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> CHERRY_TABLE = register("cherry_table",
            ()-> new TableBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> BAMBOO_TABLE = register("bamboo_table",
            ()-> new TableBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> CRIMSON_TABLE = register("crimson_table",
            ()-> new TableBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final ObjectRegistries<TableBlock> WARPED_TABLE = register("warped_table",
            ()-> new TableBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    public static final ObjectRegistries<LampBlock> WHITE_LAMP = register("white_lamp",
            ()-> new LampBlock(DyeColor.WHITE, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> LIGHT_GRAY_LAMP = register("light_gray_lamp",
            ()-> new LampBlock(DyeColor.LIGHT_GRAY, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> GRAY_LAMP = register("gray_lamp",
            ()-> new LampBlock(DyeColor.GRAY, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> BLACK_LAMP = register("black_lamp",
            ()-> new LampBlock(DyeColor.BLACK, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> BROWN_LAMP = register("brown_lamp",
            ()-> new LampBlock(DyeColor.BROWN, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> RED_LAMP = register("red_lamp",
            ()-> new LampBlock(DyeColor.RED, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> ORANGE_LAMP = register("orange_lamp",
            ()-> new LampBlock(DyeColor.ORANGE, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> YELLOW_LAMP = register("yellow_lamp",
            ()-> new LampBlock(DyeColor.YELLOW, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> LIME_LAMP = register("lime_lamp",
            ()-> new LampBlock(DyeColor.LIME, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> GREEN_LAMP = register("green_lamp",
            ()-> new LampBlock(DyeColor.GREEN, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> CYAN_LAMP = register("cyan_lamp",
            ()-> new LampBlock(DyeColor.CYAN, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> LIGHT_BLUE_LAMP = register("light_blue_lamp",
            ()-> new LampBlock(DyeColor.LIGHT_BLUE, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> BLUE_LAMP = register("blue_lamp",
            ()-> new LampBlock(DyeColor.BLUE, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> PURPLE_LAMP = register("purple_lamp",
            ()-> new LampBlock(DyeColor.PURPLE, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> MAGENTA_LAMP = register("magenta_lamp",
            ()-> new LampBlock(DyeColor.MAGENTA, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));
    public static final ObjectRegistries<LampBlock> PINK_LAMP = register("pink_lamp",
            ()-> new LampBlock(DyeColor.PINK, BlockBehaviour.Properties.of().strength(0.2f).lightLevel(LampBlock::getLight).sound(SoundType.WOOD)));




    //Digital Clock
    public static final ObjectRegistries<DigitalClockBlock> RED_DIGITAL_CLOCK = register("red_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.RED,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> ORANGE_DIGITAL_CLOCK = register("orange_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.ORANGE,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> YELLOW_DIGITAL_CLOCK = register("yellow_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.YELLOW,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> MAGENTA_DIGITAL_CLOCK = register("magenta_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.MAGENTA,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> PINK_DIGITAL_CLOCK = register("pink_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.PINK,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> PURPLE_DIGITAL_CLOCK = register("purple_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.PURPLE,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> BLUE_DIGITAL_CLOCK = register("blue_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.BLUE,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> LIGHT_BLUE_DIGITAL_CLOCK = register("light_blue_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.LIGHT_BLUE,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> CYAN_DIGITAL_CLOCK = register("cyan_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.CYAN,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> GREEN_DIGITAL_CLOCK = register("green_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.GREEN,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> LIME_DIGITAL_CLOCK = register("lime_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.LIME,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> GRAY_DIGITAL_CLOCK = register("gray_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.GRAY,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> LIGHT_GRAY_DIGITAL_CLOCK = register("light_gray_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.LIGHT_GRAY,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> BROWN_DIGITAL_CLOCK = register("brown_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.BROWN,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> BLACK_DIGITAL_CLOCK = register("black_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.BLACK,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final ObjectRegistries<DigitalClockBlock> WHITE_DIGITAL_CLOCK = register("white_digital_clock",
            ()-> new DigitalClockBlock(DyeColor.WHITE,BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));

    public static final ObjectRegistries<WoodenClockBlock> OAK_CLOCK = register("oak_clock",
            ()-> new WoodenClockBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> SPRUCE_CLOCK = register("spruce_clock",
            ()-> new WoodenClockBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> BIRCH_CLOCK = register("birch_clock",
            ()-> new WoodenClockBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> JUNGLE_CLOCK = register("jungle_clock",
            ()-> new WoodenClockBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> ACACIA_CLOCK = register("acacia_clock",
            ()-> new WoodenClockBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> DARK_OAK_CLOCK = register("dark_oak_clock",
            ()-> new WoodenClockBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> MANGROVE_CLOCK = register("mangrove_clock",
            ()-> new WoodenClockBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> CHERRY_CLOCK = register("cherry_clock",
            ()-> new WoodenClockBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> BAMBOO_CLOCK = register("bamboo_clock",
            ()-> new WoodenClockBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> CRIMSON_CLOCK = register("crimson_clock",
            ()-> new WoodenClockBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));
    public static final ObjectRegistries<WoodenClockBlock> WARPED_CLOCK = register("warped_clock",
            ()-> new WoodenClockBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD).sound(SoundType.WOOD)));








    //Glass Tecque
    public static final ObjectRegistries<TecqueBlock> ACACIA_GLASS_TECQUE = register("acacia_glass_tecque",
            ()-> new TecqueBlock(WoodType.ACACIA,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> SPRUCE_GLASS_TECQUE = register("spruce_glass_tecque",
            ()-> new TecqueBlock(WoodType.SPRUCE,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> OAK_GLASS_TECQUE = register("oak_glass_tecque",
            ()-> new TecqueBlock(WoodType.OAK,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> BIRCH_GLASS_TECQUE = register("birch_glass_tecque",
            ()-> new TecqueBlock(WoodType.BIRCH,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> JUNGLE_GLASS_TECQUE = register("jungle_glass_tecque",
            ()-> new TecqueBlock(WoodType.JUNGLE,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> MANGROVE_GLASS_TECQUE = register("mangrove_glass_tecque",
            ()-> new TecqueBlock(WoodType.MANGROVE,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> DARK_OAK_GLASS_TECQUE = register("dark_oak_glass_tecque",
            ()-> new TecqueBlock(WoodType.DARK_OAK,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> CHERRY_GLASS_TECQUE = register("cherry_glass_tecque",
            ()-> new TecqueBlock(WoodType.CHERRY,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> BAMBOO_GLASS_TECQUE = register("bamboo_glass_tecque",
            ()-> new TecqueBlock(WoodType.BAMBOO,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> CRIMSON_GLASS_TECQUE = register("crimson_glass_tecque",
            ()-> new TecqueBlock(WoodType.CRIMSON,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final ObjectRegistries<TecqueBlock> WARPED_GLASS_TECQUE = register("warped_glass_tecque",
            ()-> new TecqueBlock(WoodType.WARPED,BlockBehaviour.Properties.of().strength(3f).noOcclusion()));

    private static <T extends Block> ObjectRegistries<T> register(String name, Supplier<T> supplier) {
        ObjectRegistries<T> entry = ObjectRegistries.registerBlock(Constants.id(name), supplier);
        BLOCKS.add(entry);
        return entry;
    }

    public static void init() {}

}