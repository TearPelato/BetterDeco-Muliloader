package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RegistryContainer
public class ModBlocks {
    public static final List<RegistryEntry<? extends Block>> BLOCKS = new ArrayList<>();
    

    //Test
    public static final RegistryEntry<WorkbenchBlock> WORKBENCH = register("workbench",
            ()-> new WorkbenchBlock(BlockBehaviour.Properties.of().strength(2.0f)));


    public static final RegistryEntry<BathBlock> OAK_BATH = register("oak_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> SPRUCE_BATH = register("spruce_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> BIRCH_BATH = register("birch_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> JUNGLE_BATH = register("jungle_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> ACACIA_BATH = register("acacia_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> DARK_OAK_BATH = register("dark_oak_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> MANGROVE_BATH = register("mangrove_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> CHERRY_BATH = register("cherry_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> BAMBOO_BATH = register("bamboo_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> CRIMSON_BATH = register("crimson_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BathBlock> WARPED_BATH = register("warped_bath",
            ()-> new BathBlock(BlockBehaviour.Properties.of().strength(2.0f)));




    public static final RegistryEntry<ToiletBlock> OAK_TOILET = register("oak_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> SPRUCE_TOILET = register("spruce_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> BIRCH_TOILET = register("birch_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> JUNGLE_TOILET = register("jungle_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> ACACIA_TOILET = register("acacia_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> DARK_OAK_TOILET = register("dark_oak_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> MANGROVE_TOILET = register("mangrove_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> CHERRY_TOILET = register("cherry_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> BAMBOO_TOILET = register("bamboo_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> CRIMSON_TOILET = register("crimson_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<ToiletBlock> WARPED_TOILET = register("warped_toilet",
            ()-> new ToiletBlock(BlockBehaviour.Properties.of().strength(2.0f)));














    public static final RegistryEntry<BasinBlock> OAK_BASIN = register("oak_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> SPRUCE_BASIN = register("spruce_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> BIRCH_BASIN = register("birch_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> JUNGLE_BASIN = register("jungle_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> ACACIA_BASIN = register("acacia_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> DARK_OAK_BASIN = register("dark_oak_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> MANGROVE_BASIN = register("mangrove_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> CHERRY_BASIN = register("cherry_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> BAMBOO_BASIN = register("bamboo_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> CRIMSON_BASIN = register("crimson_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));
    public static final RegistryEntry<BasinBlock> WARPED_BASIN = register("warped_basin",
            ()-> new BasinBlock(BlockBehaviour.Properties.of().strength(2.0f)));



    public static final RegistryEntry<JarBlock> OAK_JAR = register("oak_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> SPRUCE_JAR = register("spruce_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> BIRCH_JAR = register("birch_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> JUNGLE_JAR = register("jungle_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> ACACIA_JAR = register("acacia_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> DARK_OAK_JAR = register("dark_oak_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> MANGROVE_JAR = register("mangrove_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> CHERRY_JAR = register("cherry_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> BAMBOO_JAR = register("bamboo_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> CRIMSON_JAR = register("crimson_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));
    public static final RegistryEntry<JarBlock> WARPED_JAR = register("warped_jar",
            ()-> new JarBlock(BlockBehaviour.Properties.of().strength(1.0F)));






    public static final RegistryEntry<CuttingBoardBlock> OAK_CUTTING_BOARD = register("oak_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> SPRUCE_CUTTING_BOARD = register("spruce_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> BIRCH_CUTTING_BOARD = register("birch_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> JUNGLE_CUTTING_BOARD = register("jungle_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> ACACIA_CUTTING_BOARD = register("acacia_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> DARK_OAK_CUTTING_BOARD = register("dark_oak_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> MANGROVE_CUTTING_BOARD = register("mangrove_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> CHERRY_CUTTING_BOARD = register("cherry_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> BAMBOO_CUTTING_BOARD = register("bamboo_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> CRIMSON_CUTTING_BOARD = register("crimson_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<CuttingBoardBlock> WARPED_CUTTING_BOARD = register("warped_cutting_board",
            ()-> new CuttingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));





    //Desk
    public static final RegistryEntry<DeskBlock> OAK_DESK = register("oak_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.OAK));
    public static final RegistryEntry<DeskBlock> SPRUCE_DESK = register("spruce_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.SPRUCE));
    public static final RegistryEntry<DeskBlock> BIRCH_DESK = register("birch_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.BIRCH));
    public static final RegistryEntry<DeskBlock> JUNGLE_DESK = register("jungle_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.JUNGLE));
    public static final RegistryEntry<DeskBlock> ACACIA_DESK = register("acacia_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.ACACIA));
    public static final RegistryEntry<DeskBlock> MANGROVE_DESK = register("mangrove_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.MANGROVE));
    public static final RegistryEntry<DeskBlock> DARK_OAK_DESK = register("dark_oak_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.DARK_OAK));
    public static final RegistryEntry<DeskBlock> CHERRY_DESK = register("cherry_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.CHERRY));
    public static final RegistryEntry<DeskBlock> BAMBOO_DESK = register("bamboo_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.BAMBOO));
    public static final RegistryEntry<DeskBlock> CRIMSON_DESK = register("crimson_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.CRIMSON));
    public static final RegistryEntry<DeskBlock> WARPED_DESK = register("warped_desk",
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), WoodType.WARPED));

    public static final RegistryEntry<DeskCabinetBlock> OAK_DESK_CABINET = register("oak_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.OAK));
    public static final RegistryEntry<DeskCabinetBlock> SPRUCE_DESK_CABINET = register("spruce_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.SPRUCE));
    public static final RegistryEntry<DeskCabinetBlock> BIRCH_DESK_CABINET = register("birch_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.BIRCH));
    public static final RegistryEntry<DeskCabinetBlock> JUNGLE_DESK_CABINET = register("jungle_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.JUNGLE));
    public static final RegistryEntry<DeskCabinetBlock> ACACIA_DESK_CABINET = register("acacia_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.ACACIA));
    public static final RegistryEntry<DeskCabinetBlock> MANGROVE_DESK_CABINET = register("mangrove_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.MANGROVE));
    public static final RegistryEntry<DeskCabinetBlock> DARK_OAK_DESK_CABINET = register("dark_oak_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.DARK_OAK));
    public static final RegistryEntry<DeskCabinetBlock> CHERRY_DESK_CABINET = register("cherry_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.CHERRY));
    public static final RegistryEntry<DeskCabinetBlock> BAMBOO_DESK_CABINET = register("bamboo_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.BAMBOO));
    public static final RegistryEntry<DeskCabinetBlock> CRIMSON_DESK_CABINET = register("crimson_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.CRIMSON));
    public static final RegistryEntry<DeskCabinetBlock> WARPED_DESK_CABINET = register("warped_desk_cabinet",
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), WoodType.WARPED));

    //Path
    public static final RegistryEntry<Block> STONE_PATH = register("stone_path",
            ()-> new RockPath(BlockBehaviour.Properties.of().strength(3.1f)));

    //PARK BENCH
    public static final RegistryEntry<Block> OAK_PARK_BENCH = register("oak_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> SPRUCE_PARK_BENCH = register("spruce_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> BIRCH_PARK_BENCH = register("birch_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> JUNGLE_PARK_BENCH = register("jungle_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> ACACIA_PARK_BENCH = register("acacia_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> DARK_OAK_PARK_BENCH = register("dark_oak_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> MANGROVE_PARK_BENCH = register("mangrove_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> CHERRY_PARK_BENCH = register("cherry_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> BAMBOO_PARK_BENCH = register("bamboo_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> CRIMSON_PARK_BENCH = register("crimson_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> WARPED_PARK_BENCH = register("warped_park_bench",
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));

    public static final RegistryEntry<ToasterBlock> TOASTER_LIGHT = register("toaster_light",
            ()->  new ToasterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ToasterBlock> TOASTER_DARK = register("toaster_dark",
            ()->  new ToasterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //FRIDGE & FREEZERS
    public static final RegistryEntry<FridgeBlock> FRIDGE_LIGHT = register("fridge_light",
            () -> new FridgeBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<FridgeBlock> FRIDGE_DARK = register("fridge_dark",
            () -> new FridgeBlock(BlockBehaviour.Properties.of()));

    public static final RegistryEntry<MicrowaveBlock> LIGHT_MICROWAVE = register("microwave_light",
            ()-> new MicrowaveBlock(BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryEntry<MicrowaveBlock> DARK_MICROWAVE = register("microwave_dark",
            ()-> new MicrowaveBlock(BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));

    //Oven
    public static final RegistryEntry<OvenBlock> OAK_OVEN = register("oak_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> SPRUCE_OVEN = register("spruce_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> BIRCH_OVEN = register("birch_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> JUNGLE_OVEN = register("jungle_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> ACACIA_OVEN = register("acacia_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> DARK_OAK_OVEN = register("dark_oak_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> MANGROVE_OVEN = register("mangrove_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> CHERRY_OVEN = register("cherry_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> BAMBOO_OVEN = register("bamboo_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> CRIMSON_OVEN = register("crimson_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> WARPED_OVEN = register("warped_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));


    //SHELFS
    public static final RegistryEntry<Block> OAK_SHELF = register("oak_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> SPRUCE_SHELF = register("spruce_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> BIRCH_SHELF = register("birch_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> JUNGLE_SHELF = register("jungle_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> ACACIA_SHELF = register("acacia_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> DARK_OAK_SHELF = register("dark_oak_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> MANGROVE_SHELF = register("mangrove_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> CHERRY_SHELF = register("cherry_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> BAMBOO_SHELF = register("bamboo_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> CRIMSON_SHELF = register("crimson_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> WARPED_SHELF = register("warped_shelf",
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));

    //Furnitures
    //Chairs
    public static final RegistryEntry<ChairBlock> OAK_CHAIR = register("oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> SPRUCE_CHAIR = register("spruce_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> BIRCH_CHAIR = register("birch_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> JUNGLE_CHAIR = register("jungle_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> ACACIA_CHAIR = register("acacia_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> DARK_OAK_CHAIR = register("dark_oak_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> MANGROVE_CHAIR = register("mangrove_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> CHERRY_CHAIR = register("cherry_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> BAMBOO_CHAIR = register("bamboo_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> CRIMSON_CHAIR = register("crimson_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<ChairBlock> WARPED_CHAIR = register("warped_chair",
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Counters
    public static final RegistryEntry<KitchenCounterBlock> OAK_KITCHEN_COUNTER = register("oak_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> SPRUCE_KITCHEN_COUNTER = register("spruce_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BIRCH_KITCHEN_COUNTER = register("birch_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> JUNGLE_KITCHEN_COUNTER = register("jungle_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> ACACIA_KITCHEN_COUNTER = register("acacia_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> DARK_OAK_KITCHEN_COUNTER = register("dark_oak_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> MANGROVE_KITCHEN_COUNTER = register("mangrove_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> CHERRY_KITCHEN_COUNTER = register("cherry_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BAMBOO_KITCHEN_COUNTER = register("bamboo_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> CRIMSON_KITCHEN_COUNTER = register("crimson_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> WARPED_KITCHEN_COUNTER = register("warped_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Drawers
    public static final RegistryEntry<KitchenDrawerBlock> OAK_KITCHEN_DRAWER = register("oak_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> SPRUCE_KITCHEN_DRAWER = register("spruce_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BIRCH_KITCHEN_DRAWER = register("birch_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> JUNGLE_KITCHEN_DRAWER = register("jungle_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> ACACIA_KITCHEN_DRAWER = register("acacia_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> DARK_OAK_KITCHEN_DRAWER = register("dark_oak_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> MANGROVE_KITCHEN_DRAWER = register("mangrove_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> CHERRY_KITCHEN_DRAWER = register("cherry_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BAMBOO_KITCHEN_DRAWER = register("bamboo_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> CRIMSON_KITCHEN_DRAWER = register("crimson_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> WARPED_KITCHEN_DRAWER = register("warped_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

        //Sofas
    public static final RegistryEntry<SofaBlock> RED_SOFA = register("red_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> ORANGE_SOFA = register("orange_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> BLUE_SOFA = register("blue_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> CYAN_SOFA = register("cyan_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> LIGHT_BLUE_SOFA = register("light_blue_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> PURPLE_SOFA = register("purple_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> MAGENTA_SOFA = register("magenta_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> YELLOW_SOFA = register("yellow_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> GREY_SOFA = register("grey_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> LIGHT_GREY_SOFA = register("light_grey_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> BLACK_SOFA = register("black_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> WHITE_SOFA = register("white_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> GREEN_SOFA = register("green_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> LIME_SOFA = register("lime_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> PINK_SOFA = register("pink_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<SofaBlock> BROWN_SOFA = register("brown_sofa",
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Cabinet
    public static final RegistryEntry<CabinetBlock> OAK_CABINET = register("oak_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> SPRUCE_CABINET = register("spruce_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> BIRCH_CABINET = register("birch_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> JUNGLE_CABINET = register("jungle_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> ACACIA_CABINET = register("acacia_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> DARK_OAK_CABINET = register("dark_oak_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> MANGROVE_CABINET = register("mangrove_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> CHERRY_CABINET = register("cherry_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> BAMBOO_CABINET = register("bamboo_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> CRIMSON_CABINET = register("crimson_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> WARPED_CABINET = register("warped_kitchen_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));


    //Pedestals
    public static final RegistryEntry<Block> PEDESTAL = register("pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> STONE_PEDESTAL = register("stone_pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DIORITE_PEDESTAL = register("diorite_pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> GRANITE_PEDESTAL = register("granite_pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_PEDESTAL = register("deepslate_pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_TILE_PEDESTAL = register("deepslate_tile_pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> BLACKSTONE_PEDESTAL = register("blackstone_pedestal",
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    //Bedside Cabinets
    public static final RegistryEntry<BedsideCabinetBlock> OAK_BEDSIDE = register("oak_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> SPRUCE_BEDSIDE = register("spruce_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> BIRCH_BEDSIDE = register("birch_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> JUNGLE_BEDSIDE = register("jungle_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> ACACIA_BEDSIDE = register("acacia_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> MANGROVE_BEDSIDE = register("mangrove_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> DARK_OAK_BEDSIDE = register("dark_oak_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> CHERRY_BEDSIDE = register("cherry_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> BAMBOO_BEDSIDE = register("bamboo_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> CRIMSON_BEDSIDE = register("crimson_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<BedsideCabinetBlock> WARPED_BEDSIDE = register("warped_bedside",
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Crates
    public static final RegistryEntry<Block> OAK_CRATE = register("oak_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_CRATE = register("spruce_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_CRATE = register("birch_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_CRATE = register("jungle_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_CRATE = register("acacia_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_CRATE = register("mangrove_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_CRATE = register("dark_oak_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_CRATE = register("cherry_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_CRATE = register("bamboo_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_CRATE = register("crimson_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_CRATE = register("warped_storage_crate",
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Sinks
    public static final RegistryEntry<KitchenSinkBlock> OAK_SINK = register("oak_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> SPRUCE_SINK = register("spruce_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BIRCH_SINK = register("birch_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> JUNGLE_SINK = register("jungle_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> ACACIA_SINK = register("acacia_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> MANGROVE_SINK = register("mangrove_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> DARK_OAK_SINK = register("dark_oak_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> CHERRY_SINK = register("cherry_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BAMBOO_SINK = register("bamboo_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> CRIMSON_SINK = register("crimson_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> WARPED_SINK = register("warped_sink",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final RegistryEntry<Block> OAK_SINK_DARK = register("oak_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_SINK_DARK = register("spruce_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_SINK_DARK = register("birch_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_SINK_DARK = register("jungle_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_SINK_DARK = register("acacia_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_SINK_DARK = register("mangrove_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_SINK_DARK = register("dark_oak_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_SINK_DARK = register("cherry_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final RegistryEntry<Block> BAMBOO_SINK_DARK = register("bamboo_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_SINK_DARK = register("crimson_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_SINK_DARK = register("warped_sink_dark",
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Colored Variants
    public static final RegistryEntry<KitchenCounterBlock> RED_KITCHEN_COUNTER = register("red_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> YELLOW_KITCHEN_COUNTER = register("yellow_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> ORANGE_KITCHEN_COUNTER = register("orange_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> MAGENTA_KITCHEN_COUNTER = register("magenta_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> PURPLE_KITCHEN_COUNTER = register("purple_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> PINK_KITCHEN_COUNTER = register("pink_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BLUE_KITCHEN_COUNTER = register("blue_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> LIGHT_BLUE_KITCHEN_COUNTER = register("light_blue_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> CYAN_KITCHEN_COUNTER = register("cyan_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> GREEN_KITCHEN_COUNTER = register("green_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> LIME_KITCHEN_COUNTER = register("lime_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> GRAY_KITCHEN_COUNTER = register("gray_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> LIGHT_GRAY_KITCHEN_COUNTER = register("light_gray_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BLACK_KITCHEN_COUNTER = register("black_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BROWN_KITCHEN_COUNTER = register("brown_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> WHITE_KITCHEN_COUNTER = register("white_kitchen_counter",
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Colored Drawers
    public static final RegistryEntry<KitchenDrawerBlock> RED_KITCHEN_DRAWER = register("red_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> YELLOW_KITCHEN_DRAWER = register("yellow_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> ORANGE_KITCHEN_DRAWER = register("orange_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> MAGENTA_KITCHEN_DRAWER = register("magenta_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> PURPLE_KITCHEN_DRAWER = register("purple_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> PINK_KITCHEN_DRAWER = register("pink_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BLUE_KITCHEN_DRAWER = register("blue_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> LIGHT_BLUE_KITCHEN_DRAWER = register("light_blue_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> CYAN_KITCHEN_DRAWER = register("cyan_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> GREEN_KITCHEN_DRAWER = register("green_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> LIME_KITCHEN_DRAWER = register("lime_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> GRAY_KITCHEN_DRAWER = register("gray_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> LIGHT_GRAY_KITCHEN_DRAWER = register("light_gray_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BLACK_KITCHEN_DRAWER = register("black_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BROWN_KITCHEN_DRAWER = register("brown_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> WHITE_KITCHEN_DRAWER = register("white_kitchen_drawer",
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Oven colored
    public static final RegistryEntry<OvenBlock> RED_OVEN = register("red_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> YELLOW_OVEN = register("yellow_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> ORANGE_OVEN = register("orange_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> MAGENTA_OVEN = register("magenta_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> PURPLE_OVEN = register("purple_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> PINK_OVEN = register("pink_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> BLUE_OVEN = register("blue_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> LIGHT_BLUE_OVEN = register("light_blue_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> CYAN_OVEN = register("cyan_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> GREEN_OVEN = register("green_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> LIME_OVEN = register("lime_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> GRAY_OVEN = register("gray_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> LIGHT_GRAY_OVEN = register("light_gray_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> BLACK_OVEN = register("black_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> BROWN_OVEN = register("brown_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<OvenBlock> WHITE_OVEN = register("white_oven",
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    public static final RegistryEntry<KitchenSinkBlock> RED_SINK = register("red_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> YELLOW_SINK = register("yellow_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> ORANGE_SINK = register("orange_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> MAGENTA_SINK = register("magenta_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> PURPLE_SINK = register("purple_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> PINK_SINK = register("pink_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BLUE_SINK = register("blue_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> LIGHT_BLUE_SINK = register("light_blue_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> CYAN_SINK = register("cyan_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> GREEN_SINK = register("green_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> LIME_SINK = register("lime_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> GRAY_SINK = register("gray_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> LIGHT_GRAY_SINK = register("light_gray_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BLACK_SINK = register("black_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BROWN_SINK = register("brown_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> WHITE_SINK = register("white_sink",
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    public static final RegistryEntry<CabinetBlock> RED_CABINET = register("red_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> YELLOW_CABINET = register("yellow_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> ORANGE_CABINET = register("orange_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> MAGENTA_CABINET = register("magenta_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> PURPLE_CABINET = register("purple_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> PINK_CABINET = register("pink_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> BLUE_CABINET = register("blue_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> LIGHT_BLUE_CABINET = register("light_blue_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> CYAN_CABINET = register("cyan_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> GREEN_CABINET = register("green_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> LIME_CABINET = register("lime_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> GRAY_CABINET = register("gray_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> LIGHT_GRAY_CABINET = register("light_gray_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> BLACK_CABINET = register("black_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> BROWN_CABINET = register("brown_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<CabinetBlock> WHITE_CABINET = register("white_cabinet",
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //STOOL
    public static final RegistryEntry<Block> RED_STOOL = register("red_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_STOOL = register("orange_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_STOOL = register("blue_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_STOOL = register("cyan_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_STOOL = register("light_blue_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_STOOL = register("purple_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_STOOL = register("magenta_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_STOOL = register("yellow_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> GREY_STOOL = register("grey_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GREY_STOOL = register("light_grey_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_STOOL = register("black_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WITHE_STOOL = register("white_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_STOOL = register("green_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_STOOL = register("lime_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_STOOL = register("pink_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_STOOL = register("brown_stool",
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //COFFEE TABLE
    public static final RegistryEntry<CoffeeTableBlock> OAK_COFFEE_TABLE = register("oak_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> SPRUCE_COFFEE_TABLE = register("spruce_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> BIRCH_COFFEE_TABLE = register("birch_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> JUNGLE_COFFEE_TABLE = register("jungle_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> ACACIA_COFFEE_TABLE = register("acacia_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> DARK_OAK_COFFEE_TABLE = register("dark_oak_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> MANGROVE_COFFEE_TABLE = register("mangrove_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> CHERRY_COFFEE_TABLE = register("cherry_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> BAMBOO_COFFEE_TABLE = register("bamboo_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> CRIMSON_COFFEE_TABLE = register("crimson_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<CoffeeTableBlock> WARPED_COFFEE_TABLE = register("warped_coffee_table",
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    //DINNING TABLE
    public static final RegistryEntry<TableBlock> OAK_TABLE = register("oak_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> SPRUCE_TABLE = register("spruce_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> BIRCH_TABLE = register("birch_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> JUNGLE_TABLE = register("jungle_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> ACACIA_TABLE = register("acacia_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> DARK_OAK_TABLE = register("dark_oak_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> MANGROVE_TABLE = register("mangrove_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> CHERRY_TABLE = register("cherry_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> BAMBOO_TABLE = register("bamboo_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> CRIMSON_TABLE = register("crimson_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<TableBlock> WARPED_TABLE = register("warped_table",
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    //Digital Clock
    public static final RegistryEntry<DigitalClockBlock> RED_DIGITAL_CLOCK = register("red_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> ORANGE_DIGITAL_CLOCK = register("orange_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> YELLOW_DIGITAL_CLOCK = register("yellow_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> MAGENTA_DIGITAL_CLOCK = register("magenta_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> PINK_DIGITAL_CLOCK = register("pink_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> PURPLE_DIGITAL_CLOCK = register("purple_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> BLUE_DIGITAL_CLOCK = register("blue_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> LIGHT_BLUE_DIGITAL_CLOCK = register("light_blue_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> CYAN_DIGITAL_CLOCK = register("cyan_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> GREEN_DIGITAL_CLOCK = register("green_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> LIME_DIGITAL_CLOCK = register("lime_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> GRAY_DIGITAL_CLOCK = register("gray_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> LIGHT_GRAY_DIGITAL_CLOCK = register("light_gray_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> BROWN_DIGITAL_CLOCK = register("brown_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> BLACK_DIGITAL_CLOCK = register("black_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<DigitalClockBlock> WHITE_DIGITAL_CLOCK = register("white_digital_clock",
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));

    //Glass Tecque
    public static final RegistryEntry<Block> STONE_GLASS_TECQUE = register("stone_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_GLASS_TECQUE = register("acacia_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_GLASS_TECQUE = register("spruce_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> OAK_GLASS_TECQUE = register("oak_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_GLASS_TECQUE = register("birch_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_GLASS_TECQUE = register("jungle_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_GLASS_TECQUE = register("mangrove_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_GLASS_TECQUE = register("dark_oak_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_GLASS_TECQUE = register("cherry_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_GLASS_TECQUE = register("bamboo_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_GLASS_TECQUE = register("crimson_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_GLASS_TECQUE = register("warped_glass_tecque",
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));

    private static <T extends Block> RegistryEntry<T> register(String name, Supplier<T> supplier) {
        RegistryEntry<T> entry = RegistryEntry.blockWithItem(Constants.id(name), supplier);
        BLOCKS.add(entry);
        return entry;
    }



}