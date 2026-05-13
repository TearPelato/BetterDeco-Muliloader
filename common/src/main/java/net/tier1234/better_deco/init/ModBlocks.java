package net.tier1234.better_deco.init;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.custom.*;

@RegistryContainer
public class ModBlocks {

    //Test
    public static final RegistryEntry<Block> FURNI_WORKBENCH = RegistryEntry.blockWithItem(Constants.id("furni_workbench"),
            ()-> new FurniWorkbench(BlockBehaviour.Properties.of().strength(2.7f)));

    public static final RegistryEntry<Block> CHOPPING_BOARD = RegistryEntry.blockWithItem(Constants.id("chopping_board"),
            ()-> new ChoppingBoardBlock(BlockBehaviour.Properties.of().strength(2.5f)));

    //Desk
    public static final RegistryEntry<Block> OAK_DESK = RegistryEntry.blockWithItem(Constants.id("oak_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.OAK));
    public static final RegistryEntry<Block> SPRUCE_DESK = RegistryEntry.blockWithItem(Constants.id("spruce_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.SPRUCE));
    public static final RegistryEntry<Block> BIRCH_DESK = RegistryEntry.blockWithItem(Constants.id("birch_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.BIRCH));
    public static final RegistryEntry<Block> JUNGLE_DESK = RegistryEntry.blockWithItem(Constants.id("jungle_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.JUNGLE));
    public static final RegistryEntry<Block> ACACIA_DESK = RegistryEntry.blockWithItem(Constants.id("acacia_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.ACACIA));
    public static final RegistryEntry<Block> MANGROVE_DESK = RegistryEntry.blockWithItem(Constants.id("mangrove_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.MANGROVE));
    public static final RegistryEntry<Block> DARK_OAK_DESK = RegistryEntry.blockWithItem(Constants.id("dark_oak_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.DARK_OAK));
    public static final RegistryEntry<Block> CHERRY_DESK = RegistryEntry.blockWithItem(Constants.id("cherry_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.CHERRY));
    public static final RegistryEntry<Block> BAMBOO_DESK = RegistryEntry.blockWithItem(Constants.id("bamboo_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.BAMBOO));
    public static final RegistryEntry<Block> CRIMSON_DESK = RegistryEntry.blockWithItem(Constants.id("crimson_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.CRIMSON));
    public static final RegistryEntry<Block> WARPED_DESK = RegistryEntry.blockWithItem(Constants.id("warped_desk"),
            ()-> new DeskBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.WARPED));

    public static final RegistryEntry<Block> OAK_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("oak_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.OAK));
    public static final RegistryEntry<Block> SPRUCE_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("spruce_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.SPRUCE));
    public static final RegistryEntry<Block> BIRCH_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("birch_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.BIRCH));
    public static final RegistryEntry<Block> JUNGLE_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("jungle_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.JUNGLE));
    public static final RegistryEntry<Block> ACACIA_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("acacia_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.ACACIA));
    public static final RegistryEntry<Block> MANGROVE_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("mangrove_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.MANGROVE));
    public static final RegistryEntry<Block> DARK_OAK_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("dark_oak_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.DARK_OAK));
    public static final RegistryEntry<Block> CHERRY_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("cherry_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.CHERRY));
    public static final RegistryEntry<Block> BAMBOO_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("bamboo_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.BAMBOO));
    public static final RegistryEntry<Block> CRIMSON_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("crimson_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.CRIMSON));
    public static final RegistryEntry<Block> WARPED_DESK_CABINET = RegistryEntry.blockWithItem(Constants.id("warped_desk_cabinet"),
            ()-> new DeskCabinetBlock(BlockBehaviour.Properties.of(), DeskBlock.MaterialType.WARPED));

    //Path
    public static final RegistryEntry<Block> STONE_PATH = RegistryEntry.blockWithItem(Constants.id("stone_path"),
            ()-> new RockPath(BlockBehaviour.Properties.of().strength(3.1f)));

    //PARK BENCH
    public static final RegistryEntry<Block> OAK_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("oak_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> SPRUCE_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("spruce_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> BIRCH_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("birch_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> JUNGLE_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("jungle_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> ACACIA_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("acacia_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> DARK_OAK_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("dark_oak_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> MANGROVE_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("mangrove_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> CHERRY_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("cherry_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> BAMBOO_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("bamboo_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> CRIMSON_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("crimson_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));
    public static final RegistryEntry<Block> WARPED_PARK_BENCH = RegistryEntry.blockWithItem(Constants.id("warped_park_bench"),
            ()-> new ParkBenchBlock(BlockBehaviour.Properties.of().strength(2.5f)));

    public static final RegistryEntry<Block> TOASTER_LIGHT = RegistryEntry.blockWithItem(Constants.id("toaster_light"),
            ()->  new ToasterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> TOASTER_DARK = RegistryEntry.blockWithItem(Constants.id("toaster_dark"),
            ()->  new ToasterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //FRIDGE & FREEZERS
    public static final RegistryEntry<NewFridgeBlock> FRIDGE_LIGHT = RegistryEntry.blockWithItem(Constants.id("fridge_light"),
            () -> new NewFridgeBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<NewFridgeBlock> FRIDGE_DARK = RegistryEntry.blockWithItem(Constants.id("fridge_dark"),
            () -> new NewFridgeBlock(BlockBehaviour.Properties.of()));

    public static final RegistryEntry<Block> LIGHT_MICROWAVE = RegistryEntry.blockWithItem(Constants.id("microwave_light"),
            ()-> new MicrowaveBlock(BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));
    public static final RegistryEntry<Block> DARK_MICROWAVE = RegistryEntry.blockWithItem(Constants.id("microwave_dark"),
            ()-> new MicrowaveBlock(BlockBehaviour.Properties.of().strength(2.5f).sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()));

    //Oven
    public static final RegistryEntry<OvenBlock> OAK_OVEN = RegistryEntry.blockWithItem(Constants.id("oak_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> SPRUCE_OVEN = RegistryEntry.blockWithItem(Constants.id("spruce_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> BIRCH_OVEN = RegistryEntry.blockWithItem(Constants.id("birch_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> JUNGLE_OVEN = RegistryEntry.blockWithItem(Constants.id("jungle_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> ACACIA_OVEN = RegistryEntry.blockWithItem(Constants.id("acacia_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> DARK_OAK_OVEN = RegistryEntry.blockWithItem(Constants.id("dark_oak_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> MANGROVE_OVEN = RegistryEntry.blockWithItem(Constants.id("mangrove_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> CHERRY_OVEN = RegistryEntry.blockWithItem(Constants.id("cherry_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> BAMBOO_OVEN = RegistryEntry.blockWithItem(Constants.id("bamboo_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> CRIMSON_OVEN = RegistryEntry.blockWithItem(Constants.id("crimson_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));
    public static final RegistryEntry<OvenBlock> WARPED_OVEN = RegistryEntry.blockWithItem(Constants.id("warped_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of()));

    public static final RegistryEntry<Block> SPRUCE_DIORITE_OVEN = RegistryEntry.blockWithItem(Constants.id("spruce_diorite_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(3f)));
    public static final RegistryEntry<Block> DARK_OAK_CALCITE_OVEN = RegistryEntry.blockWithItem(Constants.id("dark_oak_calcite_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(3f)));
    public static final RegistryEntry<Block> OAK_ANDESITE_OVEN = RegistryEntry.blockWithItem(Constants.id("oak_andesite_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(3f)));

    //SHELFS
    public static final RegistryEntry<Block> OAK_SHELF = RegistryEntry.blockWithItem(Constants.id("oak_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> SPRUCE_SHELF = RegistryEntry.blockWithItem(Constants.id("spruce_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> BIRCH_SHELF = RegistryEntry.blockWithItem(Constants.id("birch_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> JUNGLE_SHELF = RegistryEntry.blockWithItem(Constants.id("jungle_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> ACACIA_SHELF = RegistryEntry.blockWithItem(Constants.id("acacia_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> DARK_OAK_SHELF = RegistryEntry.blockWithItem(Constants.id("dark_oak_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> MANGROVE_SHELF = RegistryEntry.blockWithItem(Constants.id("mangrove_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> CHERRY_SHELF = RegistryEntry.blockWithItem(Constants.id("cherry_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> BAMBOO_SHELF = RegistryEntry.blockWithItem(Constants.id("bamboo_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> CRIMSON_SHELF = RegistryEntry.blockWithItem(Constants.id("crimson_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));
    public static final RegistryEntry<Block> WARPED_SHELF = RegistryEntry.blockWithItem(Constants.id("warped_shelf"),
            ()-> new CustomShelfBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD).strength(2f)));

    //Furnitures
    //Chairs
    public static final RegistryEntry<Block> BIRCH_CHAIR = RegistryEntry.blockWithItem(Constants.id("birch_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_CHAIR = RegistryEntry.blockWithItem(Constants.id("spruce_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> OAK_CHAIR = RegistryEntry.blockWithItem(Constants.id("oak_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_CHAIR = RegistryEntry.blockWithItem(Constants.id("dark_oak_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_CHAIR = RegistryEntry.blockWithItem(Constants.id("mangrove_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_CHAIR = RegistryEntry.blockWithItem(Constants.id("warped_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_CHAIR = RegistryEntry.blockWithItem(Constants.id("crimson_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_CHAIR = RegistryEntry.blockWithItem(Constants.id("acacia_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_CHAIR = RegistryEntry.blockWithItem(Constants.id("jungle_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_CHAIR = RegistryEntry.blockWithItem(Constants.id("cherry_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_CHAIR = RegistryEntry.blockWithItem(Constants.id("bamboo_chair"),
            () -> new ChairBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Counters
    public static final RegistryEntry<KitchenCounterBlock> OAK_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("oak_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> SPRUCE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("spruce_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BIRCH_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("birch_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> JUNGLE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("jungle_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> ACACIA_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("acacia_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> DARK_OAK_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("dark_oak_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> MANGROVE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("mangrove_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> CHERRY_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("cherry_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> BAMBOO_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("bamboo_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> CRIMSON_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("crimson_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenCounterBlock> WARPED_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("warped_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Drawers
    public static final RegistryEntry<KitchenDrawerBlock> OAK_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("oak_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> SPRUCE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("spruce_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BIRCH_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("birch_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> JUNGLE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("jungle_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> ACACIA_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("acacia_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> DARK_OAK_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("dark_oak_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> MANGROVE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("mangrove_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> CHERRY_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("cherry_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> BAMBOO_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("bamboo_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> CRIMSON_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("crimson_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenDrawerBlock> WARPED_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("warped_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final RegistryEntry<Block> SPRUCE_DIORITE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("spruce_diorite_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(3f)));
    public static final RegistryEntry<Block> DARK_OAK_CALCITE_DRAWER = RegistryEntry.blockWithItem(Constants.id("dark_oak_calcite_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(3f)));
    public static final RegistryEntry<Block> OAK_ANDESITE_DRAWER = RegistryEntry.blockWithItem(Constants.id("oak_andesite_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(3f)));

    //Tables
    public static final RegistryEntry<Block> OAK_TABLE = RegistryEntry.blockWithItem(Constants.id("oak_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_TABLE = RegistryEntry.blockWithItem(Constants.id("spruce_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_TABLE = RegistryEntry.blockWithItem(Constants.id("birch_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_TABLE = RegistryEntry.blockWithItem(Constants.id("jungle_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_TABLE = RegistryEntry.blockWithItem(Constants.id("acacia_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_TABLE = RegistryEntry.blockWithItem(Constants.id("dark_oak_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_TABLE = RegistryEntry.blockWithItem(Constants.id("mangrove_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_TABLE = RegistryEntry.blockWithItem(Constants.id("cherry_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_TABLE = RegistryEntry.blockWithItem(Constants.id("bamboo_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_TABLE = RegistryEntry.blockWithItem(Constants.id("crimson_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_TABLE = RegistryEntry.blockWithItem(Constants.id("warped_table"),
            ()-> new TableBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Sofas
    public static final RegistryEntry<Block> RED_SOFA = RegistryEntry.blockWithItem(Constants.id("red_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_SOFA = RegistryEntry.blockWithItem(Constants.id("orange_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_SOFA = RegistryEntry.blockWithItem(Constants.id("blue_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_SOFA = RegistryEntry.blockWithItem(Constants.id("cyan_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_SOFA = RegistryEntry.blockWithItem(Constants.id("light_blue_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_SOFA = RegistryEntry.blockWithItem(Constants.id("purple_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_SOFA = RegistryEntry.blockWithItem(Constants.id("magenta_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_SOFA = RegistryEntry.blockWithItem(Constants.id("yellow_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> GREY_SOFA = RegistryEntry.blockWithItem(Constants.id("grey_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GREY_SOFA = RegistryEntry.blockWithItem(Constants.id("light_grey_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_SOFA = RegistryEntry.blockWithItem(Constants.id("black_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WITHE_SOFA = RegistryEntry.blockWithItem(Constants.id("white_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_SOFA = RegistryEntry.blockWithItem(Constants.id("green_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_SOFA = RegistryEntry.blockWithItem(Constants.id("lime_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_SOFA = RegistryEntry.blockWithItem(Constants.id("pink_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_SOFA = RegistryEntry.blockWithItem(Constants.id("brown_sofa"),
            ()-> new SofaBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Cabinet
    public static final RegistryEntry<Block> OAK_CABINET = RegistryEntry.blockWithItem(Constants.id("oak_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_CABINET = RegistryEntry.blockWithItem(Constants.id("spruce_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_CABINET = RegistryEntry.blockWithItem(Constants.id("birch_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_CABINET = RegistryEntry.blockWithItem(Constants.id("jungle_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_CABINET = RegistryEntry.blockWithItem(Constants.id("acacia_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_CABINET = RegistryEntry.blockWithItem(Constants.id("dark_oak_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_CABINET = RegistryEntry.blockWithItem(Constants.id("mangrove_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_CABINET = RegistryEntry.blockWithItem(Constants.id("cherry_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_CABINET = RegistryEntry.blockWithItem(Constants.id("bamboo_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_CABINET = RegistryEntry.blockWithItem(Constants.id("crimson_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_CABINET = RegistryEntry.blockWithItem(Constants.id("warped_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final RegistryEntry<Block> SPRUCE_DIORITE_CABINET = RegistryEntry.blockWithItem(Constants.id("spruce_diorite_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(3f)));
    public static final RegistryEntry<Block> DARK_OAK_CALCITE_CABINET = RegistryEntry.blockWithItem(Constants.id("dark_oak_calcite_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(3f)));
    public static final RegistryEntry<Block> OAK_ANDESITE_CABINET = RegistryEntry.blockWithItem(Constants.id("oak_andesite_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(3f)));

    //Pedestals
    public static final RegistryEntry<Block> PEDESTAL = RegistryEntry.blockWithItem(Constants.id("pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> STONE_PEDESTAL = RegistryEntry.blockWithItem(Constants.id("stone_pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DIORITE_PEDESTAL = RegistryEntry.blockWithItem(Constants.id("diorite_pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> GRANITE_PEDESTAL = RegistryEntry.blockWithItem(Constants.id("granite_pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_PEDESTAL = RegistryEntry.blockWithItem(Constants.id("deepslate_pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_TILE_PEDESTAL = RegistryEntry.blockWithItem(Constants.id("deepslate_tile_pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> BLACKSTONE_PEDESTAL = RegistryEntry.blockWithItem(Constants.id("blackstone_pedestal"),
            ()-> new PedestalBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    //Bedside Cabinets
    public static final RegistryEntry<Block> OAK_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("oak_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("spruce_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("birch_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("jungle_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("acacia_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("mangrove_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("dark_oak_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("cherry_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("bamboo_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("crimson_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_BEDSIDE = RegistryEntry.blockWithItem(Constants.id("warped_bedside"),
            ()-> new BedsideCabinetBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Crates
    public static final RegistryEntry<Block> OAK_CRATE = RegistryEntry.blockWithItem(Constants.id("oak_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_CRATE = RegistryEntry.blockWithItem(Constants.id("spruce_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_CRATE = RegistryEntry.blockWithItem(Constants.id("birch_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_CRATE = RegistryEntry.blockWithItem(Constants.id("jungle_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_CRATE = RegistryEntry.blockWithItem(Constants.id("acacia_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_CRATE = RegistryEntry.blockWithItem(Constants.id("mangrove_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_CRATE = RegistryEntry.blockWithItem(Constants.id("dark_oak_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_CRATE = RegistryEntry.blockWithItem(Constants.id("cherry_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_CRATE = RegistryEntry.blockWithItem(Constants.id("bamboo_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_CRATE = RegistryEntry.blockWithItem(Constants.id("crimson_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_CRATE = RegistryEntry.blockWithItem(Constants.id("warped_storage_crate"),
            ()-> new CrateBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Sinks
    public static final RegistryEntry<KitchenSinkBlock> OAK_SINK = RegistryEntry.blockWithItem(Constants.id("light_oak_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> SPRUCE_SINK = RegistryEntry.blockWithItem(Constants.id("light_spruce_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BIRCH_SINK = RegistryEntry.blockWithItem(Constants.id("light_birch_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> JUNGLE_SINK = RegistryEntry.blockWithItem(Constants.id("light_jungle_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> ACACIA_SINK = RegistryEntry.blockWithItem(Constants.id("light_acacia_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> MANGROVE_SINK = RegistryEntry.blockWithItem(Constants.id("light_mangrove_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> DARK_OAK_SINK = RegistryEntry.blockWithItem(Constants.id("light_dark_oak_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> CHERRY_SINK = RegistryEntry.blockWithItem(Constants.id("light_cherry_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> BAMBOO_SINK = RegistryEntry.blockWithItem(Constants.id("light_bamboo_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> CRIMSON_SINK = RegistryEntry.blockWithItem(Constants.id("light_crimson_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<KitchenSinkBlock> WARPED_SINK = RegistryEntry.blockWithItem(Constants.id("light_warped_sink"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    public static final RegistryEntry<Block> OAK_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("oak_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("spruce_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("birch_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("jungle_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("acacia_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("mangrove_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("dark_oak_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("cherry_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CHERRY_PLANKS)));
    public static final RegistryEntry<Block> BAMBOO_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("bamboo_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("crimson_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_SINK_DARK = RegistryEntry.blockWithItem(Constants.id("warped_sink_dark"),
            () -> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //Colored Variants
    public static final RegistryEntry<Block> RED_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("red_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("yellow_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("orange_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("magenta_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("purple_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("pink_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("blue_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("light_blue_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("cyan_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("green_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("lime_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GRAY_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("gray_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GRAY_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("light_gray_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("black_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("brown_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> WHITE_KITCHEN_COUNTER = RegistryEntry.blockWithItem(Constants.id("white_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Colored Drawers
    public static final RegistryEntry<Block> RED_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("red_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("yellow_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("orange_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("magenta_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("purple_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("pink_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("blue_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("light_blue_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("cyan_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("green_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("lime_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GRAY_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("gray_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GRAY_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("light_gray_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("black_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("brown_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> WHITE_KITCHEN_DRAWER = RegistryEntry.blockWithItem(Constants.id("white_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Oven colored
    public static final RegistryEntry<Block> RED_OVEN = RegistryEntry.blockWithItem(Constants.id("red_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_OVEN = RegistryEntry.blockWithItem(Constants.id("yellow_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_OVEN = RegistryEntry.blockWithItem(Constants.id("orange_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_OVEN = RegistryEntry.blockWithItem(Constants.id("magenta_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_OVEN = RegistryEntry.blockWithItem(Constants.id("purple_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_OVEN = RegistryEntry.blockWithItem(Constants.id("pink_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_OVEN = RegistryEntry.blockWithItem(Constants.id("blue_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_OVEN = RegistryEntry.blockWithItem(Constants.id("light_blue_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_OVEN = RegistryEntry.blockWithItem(Constants.id("cyan_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_OVEN = RegistryEntry.blockWithItem(Constants.id("green_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_OVEN = RegistryEntry.blockWithItem(Constants.id("lime_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GRAY_OVEN = RegistryEntry.blockWithItem(Constants.id("gray_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GRAY_OVEN = RegistryEntry.blockWithItem(Constants.id("light_gray_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_OVEN = RegistryEntry.blockWithItem(Constants.id("black_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_OVEN = RegistryEntry.blockWithItem(Constants.id("brown_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> WHITE_OVEN = RegistryEntry.blockWithItem(Constants.id("white_oven"),
            ()-> new OvenBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    public static final RegistryEntry<Block> RED_SINK = RegistryEntry.blockWithItem(Constants.id("red_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_SINK = RegistryEntry.blockWithItem(Constants.id("yellow_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_SINK = RegistryEntry.blockWithItem(Constants.id("orange_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_SINK = RegistryEntry.blockWithItem(Constants.id("magenta_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_SINK = RegistryEntry.blockWithItem(Constants.id("purple_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_SINK = RegistryEntry.blockWithItem(Constants.id("pink_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_SINK = RegistryEntry.blockWithItem(Constants.id("blue_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_SINK = RegistryEntry.blockWithItem(Constants.id("light_blue_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_SINK = RegistryEntry.blockWithItem(Constants.id("cyan_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_SINK = RegistryEntry.blockWithItem(Constants.id("green_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_SINK = RegistryEntry.blockWithItem(Constants.id("lime_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GRAY_SINK = RegistryEntry.blockWithItem(Constants.id("gray_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GRAY_SINK = RegistryEntry.blockWithItem(Constants.id("light_gray_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_SINK = RegistryEntry.blockWithItem(Constants.id("black_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_SINK = RegistryEntry.blockWithItem(Constants.id("brown_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> WHITE_SINK = RegistryEntry.blockWithItem(Constants.id("white_sink"),
            ()-> new KitchenSinkBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    public static final RegistryEntry<Block> RED_CABINET = RegistryEntry.blockWithItem(Constants.id("red_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_CABINET = RegistryEntry.blockWithItem(Constants.id("yellow_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_CABINET = RegistryEntry.blockWithItem(Constants.id("orange_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_CABINET = RegistryEntry.blockWithItem(Constants.id("magenta_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_CABINET = RegistryEntry.blockWithItem(Constants.id("purple_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_CABINET = RegistryEntry.blockWithItem(Constants.id("pink_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_CABINET = RegistryEntry.blockWithItem(Constants.id("blue_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_CABINET = RegistryEntry.blockWithItem(Constants.id("light_blue_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_CABINET = RegistryEntry.blockWithItem(Constants.id("cyan_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_CABINET = RegistryEntry.blockWithItem(Constants.id("green_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_CABINET = RegistryEntry.blockWithItem(Constants.id("lime_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> GRAY_CABINET = RegistryEntry.blockWithItem(Constants.id("gray_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GRAY_CABINET = RegistryEntry.blockWithItem(Constants.id("light_gray_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_CABINET = RegistryEntry.blockWithItem(Constants.id("black_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_CABINET = RegistryEntry.blockWithItem(Constants.id("brown_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));
    public static final RegistryEntry<Block> WHITE_CABINET = RegistryEntry.blockWithItem(Constants.id("white_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(2.5f).noOcclusion()));

    //Stone Variants
    //Counter
    public static final RegistryEntry<Block> STONE_COUNTER = RegistryEntry.blockWithItem(Constants.id("stone_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DIORITE_COUNTER = RegistryEntry.blockWithItem(Constants.id("diorite_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> GRANITE_COUNTER = RegistryEntry.blockWithItem(Constants.id("granite_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> BLACKSTONE_COUNTER = RegistryEntry.blockWithItem(Constants.id("blackstone_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_COUNTER = RegistryEntry.blockWithItem(Constants.id("deepslate_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_TILE_COUNTER = RegistryEntry.blockWithItem(Constants.id("deepslate_tiles_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_DIORITE_COUNTER = RegistryEntry.blockWithItem(Constants.id("spruce_diorite_kitchen_counter"),
            ()-> new KitchenCounterBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    //Drawers
    public static final RegistryEntry<Block> STONE_DRAWER = RegistryEntry.blockWithItem(Constants.id("stone_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> GRANITE_DRAWER = RegistryEntry.blockWithItem(Constants.id("granite_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DIORITE_DRAWER = RegistryEntry.blockWithItem(Constants.id("diorite_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_DRAWER = RegistryEntry.blockWithItem(Constants.id("deepslate_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_TILES_DRAWER = RegistryEntry.blockWithItem(Constants.id("deepslate_tiles_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> BLACKSTONE_DRAWER = RegistryEntry.blockWithItem(Constants.id("blackstone_kitchen_drawer"),
            ()-> new KitchenDrawerBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    //Cabinets
    public static final RegistryEntry<Block> STONE_CABINET = RegistryEntry.blockWithItem(Constants.id("stone_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> GRANITE_CABINET = RegistryEntry.blockWithItem(Constants.id("granite_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DIORITE_CABINET = RegistryEntry.blockWithItem(Constants.id("diorite_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_CABINET = RegistryEntry.blockWithItem(Constants.id("deepslate_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> DEEPSLATE_TILES_CABINET = RegistryEntry.blockWithItem(Constants.id("deepslate_tiles_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));
    public static final RegistryEntry<Block> BLACKSTONE_CABINET = RegistryEntry.blockWithItem(Constants.id("blackstone_cabinet"),
            ()-> new CabinetBlock(BlockBehaviour.Properties.of().strength(4f).noOcclusion()));

    //STOOL
    public static final RegistryEntry<Block> RED_STOOL = RegistryEntry.blockWithItem(Constants.id("red_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> ORANGE_STOOL = RegistryEntry.blockWithItem(Constants.id("orange_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BLUE_STOOL = RegistryEntry.blockWithItem(Constants.id("blue_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> CYAN_STOOL = RegistryEntry.blockWithItem(Constants.id("cyan_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_BLUE_STOOL = RegistryEntry.blockWithItem(Constants.id("light_blue_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> PURPLE_STOOL = RegistryEntry.blockWithItem(Constants.id("purple_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> MAGENTA_STOOL = RegistryEntry.blockWithItem(Constants.id("magenta_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> YELLOW_STOOL = RegistryEntry.blockWithItem(Constants.id("yellow_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> GREY_STOOL = RegistryEntry.blockWithItem(Constants.id("grey_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIGHT_GREY_STOOL = RegistryEntry.blockWithItem(Constants.id("light_grey_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BLACK_STOOL = RegistryEntry.blockWithItem(Constants.id("black_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> WITHE_STOOL = RegistryEntry.blockWithItem(Constants.id("white_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> GREEN_STOOL = RegistryEntry.blockWithItem(Constants.id("green_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> LIME_STOOL = RegistryEntry.blockWithItem(Constants.id("lime_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> PINK_STOOL = RegistryEntry.blockWithItem(Constants.id("pink_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final RegistryEntry<Block> BROWN_STOOL = RegistryEntry.blockWithItem(Constants.id("brown_stool"),
            ()-> new BarStoolBlock(BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    //COFFEE TABLE
    public static final RegistryEntry<Block> OAK_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("oak_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> SPRUCE_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("spruce_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> BIRCH_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("birch_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> JUNGLE_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("jungle_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> ACACIA_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("acacia_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> DARK_OAK_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("dark_oak_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> MANGROVE_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("mangrove_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> CHERRY_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("cherry_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> BAMBOO_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("bamboo_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> CRIMSON_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("crimson_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> WARPED_COFFEE_TABLE = RegistryEntry.blockWithItem(Constants.id("warped_coffee_table"),
            ()-> new CoffeeTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    //DINNING TABLE
    public static final RegistryEntry<Block> OAK_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("oak_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> SPRUCE_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("spruce_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> BIRCH_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("birch_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> JUNGLE_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("jungle_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> ACACIA_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("acacia_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> DARK_OAK_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("dark_oak_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> MANGROVE_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("mangrove_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> CHERRY_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("cherry_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> BAMBOO_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("bamboo_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> CRIMSON_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("crimson_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));
    public static final RegistryEntry<Block> WARPED_DINNING_TABLE = RegistryEntry.blockWithItem(Constants.id("warped_dinning_table"),
            ()-> new DinningTableBlock(BlockBehaviour.Properties.of().strength(2f).sound(SoundType.WOOD)));

    //Digital Clock
    public static final RegistryEntry<Block> RED_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("red_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> ORANGE_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("orange_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> YELLOW_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("yellow_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> MAGENTA_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("magenta_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> PINK_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("pink_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> PURPLE_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("purple_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> BLUE_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("blue_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> LIGHT_BLUE_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("light_blue_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> CYAN_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("cyan_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> GREEN_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("green_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> LIME_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("lime_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> GRAY_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("gray_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> LIGHT_GRAY_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("light_gray_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> BROWN_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("brown_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> BLACK_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("black_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));
    public static final RegistryEntry<Block> WHITE_DIGITAL_CLOCK = RegistryEntry.blockWithItem(Constants.id("white_digital_clock"),
            ()-> new DigitalClockBlock(BlockBehaviour.Properties.of().sound(SoundType.DECORATED_POT).strength(2f)));

    //Glass Tecque
    public static final RegistryEntry<Block> STONE_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("stone_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> ACACIA_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("acacia_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> SPRUCE_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("spruce_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> OAK_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("oak_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> BIRCH_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("birch_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> JUNGLE_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("jungle_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> MANGROVE_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("mangrove_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> DARK_OAK_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("dark_oak_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> CHERRY_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("cherry_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> BAMBOO_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("bamboo_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> CRIMSON_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("crimson_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
    public static final RegistryEntry<Block> WARPED_GLASS_TECQUE = RegistryEntry.blockWithItem(Constants.id("warped_glass_tecque"),
            ()-> new TecqueBlock(BlockBehaviour.Properties.of().strength(3f).noOcclusion()));
}