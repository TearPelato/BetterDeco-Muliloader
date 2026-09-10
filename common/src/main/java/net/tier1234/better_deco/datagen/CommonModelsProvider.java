package net.tier1234.better_deco.datagen;

import com.mojang.math.Quadrant;
import com.mrcrayfish.framework.api.datagen.FrameworkGenerator;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.dispatch.Variant;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.*;
import net.tier1234.better_deco.block.type.MetalType;
import net.tier1234.better_deco.block.type.StoneType;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

import java.util.Map;
import java.util.Optional;

import static net.tier1234.better_deco.block.BathBlock.BathPart.BOTTOM;
import static net.tier1234.better_deco.block.BathBlock.BathPart.HEAD;
import static net.tier1234.better_deco.block.FridgeBlock.FridgeModelType.FREEZER;
import static net.tier1234.better_deco.block.FridgeBlock.FridgeModelType.FRIDGE;

public class CommonModelsProvider extends FrameworkGenerator {

    public CommonModelsProvider(Map<Block, BlockModelDefinitionGenerator> generators, Map<Item, ClientItem> items, Map<Identifier, ModelInstance> models) {
        super(generators, items, models);
    }

    @Override
    public void generate() {

        woodenKitchenCounter(ModBlocks.OAK_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.SPRUCE_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.BIRCH_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.JUNGLE_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.ACACIA_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.MANGROVE_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.CHERRY_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.BAMBOO_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.CRIMSON_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.WARPED_KITCHEN_COUNTER.get());
        woodenKitchenCounter(ModBlocks.PALE_OAK_KITCHEN_COUNTER.get());


        //Kitchen Drawers
        woodenKitchenDrawer(ModBlocks.OAK_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.SPRUCE_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.BIRCH_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.JUNGLE_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.ACACIA_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.DARK_OAK_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.MANGROVE_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.CHERRY_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.BAMBOO_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.CRIMSON_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.WARPED_KITCHEN_DRAWER.get());
        woodenKitchenDrawer(ModBlocks.PALE_OAK_KITCHEN_DRAWER.get());


        //Sinks
        woodenKitchenSink(ModBlocks.OAK_SINK.get());
        woodenKitchenSink(ModBlocks.SPRUCE_SINK.get());
        woodenKitchenSink(ModBlocks.BIRCH_SINK.get());
        woodenKitchenSink(ModBlocks.JUNGLE_SINK.get());
        woodenKitchenSink(ModBlocks.ACACIA_SINK.get());
        woodenKitchenSink(ModBlocks.DARK_OAK_SINK.get());
        woodenKitchenSink(ModBlocks.MANGROVE_SINK.get());
        woodenKitchenSink(ModBlocks.CHERRY_SINK.get());
        woodenKitchenSink(ModBlocks.BAMBOO_SINK.get());
        woodenKitchenSink(ModBlocks.CRIMSON_SINK.get());
        woodenKitchenSink(ModBlocks.WARPED_SINK.get());
        woodenKitchenSink(ModBlocks.PALE_OAK_SINK.get());

        woodenOven(ModBlocks.OAK_OVEN.get());
        woodenOven(ModBlocks.SPRUCE_OVEN.get());
        woodenOven(ModBlocks.BIRCH_OVEN.get());
        woodenOven(ModBlocks.JUNGLE_OVEN.get());
        woodenOven(ModBlocks.ACACIA_OVEN.get());
        woodenOven(ModBlocks.DARK_OAK_OVEN.get());
        woodenOven(ModBlocks.MANGROVE_OVEN.get());
        woodenOven(ModBlocks.CHERRY_OVEN.get());
        woodenOven(ModBlocks.BAMBOO_OVEN.get());
        woodenOven(ModBlocks.CRIMSON_OVEN.get());
        woodenOven(ModBlocks.WARPED_OVEN.get());
        woodenOven(ModBlocks.PALE_OAK_OVEN.get());

        woodenKitchenCabinet(ModBlocks.OAK_CABINET.get());
        woodenKitchenCabinet(ModBlocks.SPRUCE_CABINET.get());
        woodenKitchenCabinet(ModBlocks.BIRCH_CABINET.get());
        woodenKitchenCabinet(ModBlocks.JUNGLE_CABINET.get());
        woodenKitchenCabinet(ModBlocks.ACACIA_CABINET.get());
        woodenKitchenCabinet(ModBlocks.DARK_OAK_CABINET.get());
        woodenKitchenCabinet(ModBlocks.MANGROVE_CABINET.get());
        woodenKitchenCabinet(ModBlocks.CHERRY_CABINET.get());
        woodenKitchenCabinet(ModBlocks.BAMBOO_CABINET.get());
        woodenKitchenCabinet(ModBlocks.CRIMSON_CABINET.get());
        woodenKitchenCabinet(ModBlocks.WARPED_CABINET.get());
        woodenKitchenCabinet(ModBlocks.PALE_OAK_CABINET.get());

        microwave(ModBlocks.LIGHT_MICROWAVE.get());
        microwave(ModBlocks.DARK_MICROWAVE.get());
        fridge(ModBlocks.FRIDGE_LIGHT.get());
        fridge(ModBlocks.FRIDGE_DARK.get());
        toaster(ModBlocks.TOASTER_LIGHT.get());
        toaster(ModBlocks.TOASTER_DARK.get());

        cuttingBoard(ModBlocks.OAK_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.SPRUCE_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.BIRCH_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.JUNGLE_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.ACACIA_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.DARK_OAK_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.MANGROVE_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.CHERRY_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.BAMBOO_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.CRIMSON_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.WARPED_CUTTING_BOARD.get());
        cuttingBoard(ModBlocks.PALE_OAK_CUTTING_BOARD.get());

        jar(ModBlocks.OAK_JAR.get());
        jar(ModBlocks.SPRUCE_JAR.get());
        jar(ModBlocks.BIRCH_JAR.get());
        jar(ModBlocks.JUNGLE_JAR.get());
        jar(ModBlocks.ACACIA_JAR.get());
        jar(ModBlocks.DARK_OAK_JAR.get());
        jar(ModBlocks.MANGROVE_JAR.get());
        jar(ModBlocks.CHERRY_JAR.get());
        jar(ModBlocks.BAMBOO_JAR.get());
        jar(ModBlocks.CRIMSON_JAR.get());
        jar(ModBlocks.WARPED_JAR.get());
        jar(ModBlocks.PALE_OAK_JAR.get());

        coloredKitchenCounter(ModBlocks.WHITE_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.WHITE_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.WHITE_OVEN.get());
        coloredKitchenSink(ModBlocks.WHITE_SINK.get());
        coloredKitchenCabinet(ModBlocks.WHITE_CABINET.get());

        coloredKitchenCounter(ModBlocks.LIGHT_GRAY_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.LIGHT_GRAY_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.LIGHT_GRAY_OVEN.get());
        coloredKitchenSink(ModBlocks.LIGHT_GRAY_SINK.get());
        coloredKitchenCabinet(ModBlocks.LIGHT_GRAY_CABINET.get());

        coloredKitchenCounter(ModBlocks.GRAY_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.GRAY_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.GRAY_OVEN.get());
        coloredKitchenSink(ModBlocks.GRAY_SINK.get());
        coloredKitchenCabinet(ModBlocks.GRAY_CABINET.get());

        coloredKitchenCounter(ModBlocks.BLACK_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.BLACK_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.BLACK_OVEN.get());
        coloredKitchenSink(ModBlocks.BLACK_SINK.get());
        coloredKitchenCabinet(ModBlocks.BLACK_CABINET.get());

        coloredKitchenCounter(ModBlocks.BROWN_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.BROWN_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.BROWN_OVEN.get());
        coloredKitchenSink(ModBlocks.BROWN_SINK.get());
        coloredKitchenCabinet(ModBlocks.BROWN_CABINET.get());

        coloredKitchenCounter(ModBlocks.RED_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.RED_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.RED_OVEN.get());
        coloredKitchenSink(ModBlocks.RED_SINK.get());
        coloredKitchenCabinet(ModBlocks.RED_CABINET.get());

        coloredKitchenCounter(ModBlocks.ORANGE_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.ORANGE_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.ORANGE_OVEN.get());
        coloredKitchenSink(ModBlocks.ORANGE_SINK.get());
        coloredKitchenCabinet(ModBlocks.ORANGE_CABINET.get());

        coloredKitchenCounter(ModBlocks.YELLOW_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.YELLOW_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.YELLOW_OVEN.get());
        coloredKitchenSink(ModBlocks.YELLOW_SINK.get());
        coloredKitchenCabinet(ModBlocks.YELLOW_CABINET.get());

        coloredKitchenCounter(ModBlocks.LIME_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.LIME_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.LIME_OVEN.get());
        coloredKitchenSink(ModBlocks.LIME_SINK.get());
        coloredKitchenCabinet(ModBlocks.LIME_CABINET.get());

        coloredKitchenCounter(ModBlocks.GREEN_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.GREEN_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.GREEN_OVEN.get());
        coloredKitchenSink(ModBlocks.GREEN_SINK.get());
        coloredKitchenCabinet(ModBlocks.GREEN_CABINET.get());

        coloredKitchenCounter(ModBlocks.CYAN_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.CYAN_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.CYAN_OVEN.get());
        coloredKitchenSink(ModBlocks.CYAN_SINK.get());
        coloredKitchenCabinet(ModBlocks.CYAN_CABINET.get());

        coloredKitchenCounter(ModBlocks.LIGHT_BLUE_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.LIGHT_BLUE_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.LIGHT_BLUE_OVEN.get());
        coloredKitchenSink(ModBlocks.LIGHT_BLUE_SINK.get());
        coloredKitchenCabinet(ModBlocks.LIGHT_BLUE_CABINET.get());

        coloredKitchenCounter(ModBlocks.BLUE_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.BLUE_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.BLUE_OVEN.get());
        coloredKitchenSink(ModBlocks.BLUE_SINK.get());
        coloredKitchenCabinet(ModBlocks.BLUE_CABINET.get());

        coloredKitchenCounter(ModBlocks.PURPLE_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.PURPLE_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.PURPLE_OVEN.get());
        coloredKitchenSink(ModBlocks.PURPLE_SINK.get());
        coloredKitchenCabinet(ModBlocks.PURPLE_CABINET.get());

        coloredKitchenCounter(ModBlocks.MAGENTA_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.MAGENTA_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.MAGENTA_OVEN.get());
        coloredKitchenSink(ModBlocks.MAGENTA_SINK.get());
        coloredKitchenCabinet(ModBlocks.MAGENTA_CABINET.get());

        coloredKitchenCounter(ModBlocks.PINK_KITCHEN_COUNTER.get());
        coloredKitchenDrawer(ModBlocks.PINK_KITCHEN_DRAWER.get());
        coloredOven(ModBlocks.PINK_OVEN.get());
        coloredKitchenSink(ModBlocks.PINK_SINK.get());
        coloredKitchenCabinet(ModBlocks.PINK_CABINET.get());

         workbench(ModBlocks.WORKBENCH.get());

        basin(ModBlocks.OAK_BASIN.get());
        basin(ModBlocks.SPRUCE_BASIN.get());
        basin(ModBlocks.BIRCH_BASIN.get());
        basin(ModBlocks.JUNGLE_BASIN.get());
        basin(ModBlocks.ACACIA_BASIN.get());
        basin(ModBlocks.DARK_OAK_BASIN.get());
        basin(ModBlocks.MANGROVE_BASIN.get());
        basin(ModBlocks.CHERRY_BASIN.get());
        basin(ModBlocks.BAMBOO_BASIN.get());
        basin(ModBlocks.CRIMSON_BASIN.get());
        basin(ModBlocks.WARPED_BASIN.get());
        basin(ModBlocks.PALE_OAK_BASIN.get());

        toilet(ModBlocks.OAK_TOILET.get());
        toilet(ModBlocks.SPRUCE_TOILET.get());
        toilet(ModBlocks.BIRCH_TOILET.get());
        toilet(ModBlocks.JUNGLE_TOILET.get());
        toilet(ModBlocks.ACACIA_TOILET.get());
        toilet(ModBlocks.DARK_OAK_TOILET.get());
        toilet(ModBlocks.MANGROVE_TOILET.get());
        toilet(ModBlocks.CHERRY_TOILET.get());
        toilet(ModBlocks.BAMBOO_TOILET.get());
        toilet(ModBlocks.CRIMSON_TOILET.get());
        toilet(ModBlocks.WARPED_TOILET.get());
        toilet(ModBlocks.PALE_OAK_TOILET.get());

        bath(ModBlocks.OAK_BATH.get());
        bath(ModBlocks.SPRUCE_BATH.get());
        bath(ModBlocks.BIRCH_BATH.get());
        bath(ModBlocks.JUNGLE_BATH.get());
        bath(ModBlocks.ACACIA_BATH.get());
        bath(ModBlocks.DARK_OAK_BATH.get());
        bath(ModBlocks.MANGROVE_BATH.get());
        bath(ModBlocks.CHERRY_BATH.get());
        bath(ModBlocks.BAMBOO_BATH.get());
        bath(ModBlocks.CRIMSON_BATH.get());
        bath(ModBlocks.WARPED_BATH.get());
        bath(ModBlocks.PALE_OAK_BATH.get());

        sofa(ModBlocks.WHITE_SOFA.get());
        sofa(ModBlocks.LIGHT_GREY_SOFA.get());
        sofa(ModBlocks.GREY_SOFA.get());
        sofa(ModBlocks.BLACK_SOFA.get());
        sofa(ModBlocks.BROWN_SOFA.get());
        sofa(ModBlocks.RED_SOFA.get());
        sofa(ModBlocks.ORANGE_SOFA.get());
        sofa(ModBlocks.YELLOW_SOFA.get());
        sofa(ModBlocks.LIME_SOFA.get());
        sofa(ModBlocks.GREEN_SOFA.get());
        sofa(ModBlocks.CYAN_SOFA.get());
        sofa(ModBlocks.LIGHT_BLUE_SOFA.get());
        sofa(ModBlocks.BLUE_SOFA.get());
        sofa(ModBlocks.PURPLE_SOFA.get());
        sofa(ModBlocks.MAGENTA_SOFA.get());
        sofa(ModBlocks.PINK_SOFA.get());

        chair(ModBlocks.OAK_CHAIR.get());
        chair(ModBlocks.SPRUCE_CHAIR.get());
        chair(ModBlocks.BIRCH_CHAIR.get());
        chair(ModBlocks.JUNGLE_CHAIR.get());
        chair(ModBlocks.ACACIA_CHAIR.get());
        chair(ModBlocks.DARK_OAK_CHAIR.get());
        chair(ModBlocks.MANGROVE_CHAIR.get());
        chair(ModBlocks.CHERRY_CHAIR.get());
        chair(ModBlocks.BAMBOO_CHAIR.get());
        chair(ModBlocks.CRIMSON_CHAIR.get());
        chair(ModBlocks.WARPED_CHAIR.get());
        chair(ModBlocks.PALE_OAK_CHAIR.get());

        stool(ModBlocks.WHITE_STOOL.get());
        stool(ModBlocks.LIGHT_GREY_STOOL.get());
        stool(ModBlocks.GREY_STOOL.get());
        stool(ModBlocks.BLACK_STOOL.get());
        stool(ModBlocks.BROWN_STOOL.get());
        stool(ModBlocks.RED_STOOL.get());
        stool(ModBlocks.ORANGE_STOOL.get());
        stool(ModBlocks.YELLOW_STOOL.get());
        stool(ModBlocks.LIME_STOOL.get());
        stool(ModBlocks.GREEN_STOOL.get());
        stool(ModBlocks.CYAN_STOOL.get());
        stool(ModBlocks.LIGHT_BLUE_STOOL.get());
        stool(ModBlocks.BLUE_STOOL.get());
        stool(ModBlocks.PURPLE_STOOL.get());
        stool(ModBlocks.MAGENTA_STOOL.get());
        stool(ModBlocks.PINK_STOOL.get());

        table(ModBlocks.OAK_TABLE.get());
        table(ModBlocks.SPRUCE_TABLE.get());
        table(ModBlocks.BIRCH_TABLE.get());
        table(ModBlocks.JUNGLE_TABLE.get());
        table(ModBlocks.ACACIA_TABLE.get());
        table(ModBlocks.DARK_OAK_TABLE.get());
        table(ModBlocks.MANGROVE_TABLE.get());
        table(ModBlocks.CHERRY_TABLE.get());
        table(ModBlocks.BAMBOO_TABLE.get());
        table(ModBlocks.CRIMSON_TABLE.get());
        table(ModBlocks.WARPED_TABLE.get());
        table(ModBlocks.PALE_OAK_TABLE.get());


        desk(ModBlocks.OAK_DESK.get());
        desk(ModBlocks.SPRUCE_DESK.get());
        desk(ModBlocks.BIRCH_DESK.get());
        desk(ModBlocks.JUNGLE_DESK.get());
        desk(ModBlocks.ACACIA_DESK.get());
        desk(ModBlocks.DARK_OAK_DESK.get());
        desk(ModBlocks.MANGROVE_DESK.get());
        desk(ModBlocks.CHERRY_DESK.get());
        desk(ModBlocks.BAMBOO_DESK.get());
        desk(ModBlocks.CRIMSON_DESK.get());
        desk(ModBlocks.WARPED_DESK.get());
        desk(ModBlocks.PALE_OAK_DESK.get());

        deskCabinet(ModBlocks.OAK_DESK_CABINET.get());
        deskCabinet(ModBlocks.SPRUCE_DESK_CABINET.get());
        deskCabinet(ModBlocks.BIRCH_DESK_CABINET.get());
        deskCabinet(ModBlocks.JUNGLE_DESK_CABINET.get());
        deskCabinet(ModBlocks.ACACIA_DESK_CABINET.get());
        deskCabinet(ModBlocks.DARK_OAK_DESK_CABINET.get());
        deskCabinet(ModBlocks.MANGROVE_DESK_CABINET.get());
        deskCabinet(ModBlocks.CHERRY_DESK_CABINET.get());
        deskCabinet(ModBlocks.BAMBOO_DESK_CABINET.get());
        deskCabinet(ModBlocks.CRIMSON_DESK_CABINET.get());
        deskCabinet(ModBlocks.WARPED_DESK_CABINET.get());
        deskCabinet(ModBlocks.PALE_OAK_DESK_CABINET.get());



        coffeeTable(ModBlocks.OAK_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.SPRUCE_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.BIRCH_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.JUNGLE_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.ACACIA_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.DARK_OAK_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.MANGROVE_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.CHERRY_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.BAMBOO_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.CRIMSON_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.WARPED_COFFEE_TABLE.get());
        coffeeTable(ModBlocks.PALE_OAK_COFFEE_TABLE.get());


        bedsideCabinet(ModBlocks.OAK_BEDSIDE.get());
        bedsideCabinet(ModBlocks.SPRUCE_BEDSIDE.get());
        bedsideCabinet(ModBlocks.BIRCH_BEDSIDE.get());
        bedsideCabinet(ModBlocks.JUNGLE_BEDSIDE.get());
        bedsideCabinet(ModBlocks.ACACIA_BEDSIDE.get());
        bedsideCabinet(ModBlocks.DARK_OAK_BEDSIDE.get());
        bedsideCabinet(ModBlocks.MANGROVE_BEDSIDE.get());
        bedsideCabinet(ModBlocks.CHERRY_BEDSIDE.get());
        bedsideCabinet(ModBlocks.BAMBOO_BEDSIDE.get());
        bedsideCabinet(ModBlocks.CRIMSON_BEDSIDE.get());
        bedsideCabinet(ModBlocks.WARPED_BEDSIDE.get());
        bedsideCabinet(ModBlocks.PALE_OAK_BEDSIDE.get());

        lamp(ModBlocks.WHITE_LAMP.get());
        lamp(ModBlocks.LIGHT_GRAY_LAMP.get());
        lamp(ModBlocks.GRAY_LAMP.get());
        lamp(ModBlocks.BLACK_LAMP.get());
        lamp(ModBlocks.BROWN_LAMP.get());
        lamp(ModBlocks.RED_LAMP.get());
        lamp(ModBlocks.ORANGE_LAMP.get());
        lamp(ModBlocks.YELLOW_LAMP.get());
        lamp(ModBlocks.LIME_LAMP.get());
        lamp(ModBlocks.GREEN_LAMP.get());
        lamp(ModBlocks.CYAN_LAMP.get());
        lamp(ModBlocks.LIGHT_BLUE_LAMP.get());
        lamp(ModBlocks.BLUE_LAMP.get());
        lamp(ModBlocks.PURPLE_LAMP.get());
        lamp(ModBlocks.MAGENTA_LAMP.get());
        lamp(ModBlocks.PINK_LAMP.get());

        digitalClock(ModBlocks.WHITE_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.LIGHT_GRAY_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.GRAY_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.BLACK_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.BROWN_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.RED_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.ORANGE_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.YELLOW_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.LIME_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.GREEN_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.CYAN_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.LIGHT_BLUE_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.BLUE_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.PURPLE_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.MAGENTA_DIGITAL_CLOCK.get());
        digitalClock(ModBlocks.PINK_DIGITAL_CLOCK.get());

        woodenClock(ModBlocks.OAK_CLOCK.get());
        woodenClock(ModBlocks.SPRUCE_CLOCK.get());
        woodenClock(ModBlocks.BIRCH_CLOCK.get());
        woodenClock(ModBlocks.JUNGLE_CLOCK.get());
        woodenClock(ModBlocks.ACACIA_CLOCK.get());
        woodenClock(ModBlocks.DARK_OAK_CLOCK.get());
        woodenClock(ModBlocks.MANGROVE_CLOCK.get());
        woodenClock(ModBlocks.CHERRY_CLOCK.get());
        woodenClock(ModBlocks.BAMBOO_CLOCK.get());
        woodenClock(ModBlocks.CRIMSON_CLOCK.get());
        woodenClock(ModBlocks.WARPED_CLOCK.get());
        woodenClock(ModBlocks.PALE_OAK_CLOCK.get());

        shelf(ModBlocks.OAK_SHELF.get());
        shelf(ModBlocks.SPRUCE_SHELF.get());
        shelf(ModBlocks.BIRCH_SHELF.get());
        shelf(ModBlocks.JUNGLE_SHELF.get());
        shelf(ModBlocks.ACACIA_SHELF.get());
        shelf(ModBlocks.DARK_OAK_SHELF.get());
        shelf(ModBlocks.MANGROVE_SHELF.get());
        shelf(ModBlocks.CHERRY_SHELF.get());
        shelf(ModBlocks.BAMBOO_SHELF.get());
        shelf(ModBlocks.CRIMSON_SHELF.get());
        shelf(ModBlocks.WARPED_SHELF.get());
        shelf(ModBlocks.PALE_OAK_SHELF.get());

        bench(ModBlocks.OAK_PARK_BENCH.get());
        bench(ModBlocks.SPRUCE_PARK_BENCH.get());
        bench(ModBlocks.BIRCH_PARK_BENCH.get());
        bench(ModBlocks.JUNGLE_PARK_BENCH.get());
        bench(ModBlocks.ACACIA_PARK_BENCH.get());
        bench(ModBlocks.DARK_OAK_PARK_BENCH.get());
        bench(ModBlocks.MANGROVE_PARK_BENCH.get());
        bench(ModBlocks.CHERRY_PARK_BENCH.get());
        bench(ModBlocks.BAMBOO_PARK_BENCH.get());
        bench(ModBlocks.CRIMSON_PARK_BENCH.get());
        bench(ModBlocks.WARPED_PARK_BENCH.get());
        bench(ModBlocks.PALE_OAK_PARK_BENCH.get());

        stonePath(ModBlocks.STONE_PATH.get());
        stonePath(ModBlocks.ANDESITE_PATH.get());
        stonePath(ModBlocks.GRANITE_PATH.get());
        stonePath(ModBlocks.DIORITE_PATH.get());
        stonePath(ModBlocks.DEEPSLATE_PATH.get());

        crate(ModBlocks.OAK_CRATE.get());
        crate(ModBlocks.SPRUCE_CRATE.get());
        crate(ModBlocks.BIRCH_CRATE.get());
        crate(ModBlocks.JUNGLE_CRATE.get());
        crate(ModBlocks.ACACIA_CRATE.get());
        crate(ModBlocks.DARK_OAK_CRATE.get());
        crate(ModBlocks.MANGROVE_CRATE.get());
        crate(ModBlocks.CHERRY_CRATE.get());
        crate(ModBlocks.BAMBOO_CRATE.get());
        crate(ModBlocks.CRIMSON_CRATE.get());
        crate(ModBlocks.WARPED_CRATE.get());
        crate(ModBlocks.PALE_OAK_CRATE.get());

        glassTecque(ModBlocks.OAK_GLASS_TECQUE.get());
        glassTecque(ModBlocks.SPRUCE_GLASS_TECQUE.get());
        glassTecque(ModBlocks.BIRCH_GLASS_TECQUE.get());
        glassTecque(ModBlocks.JUNGLE_GLASS_TECQUE.get());
        glassTecque(ModBlocks.ACACIA_GLASS_TECQUE.get());
        glassTecque(ModBlocks.DARK_OAK_GLASS_TECQUE.get());
        glassTecque(ModBlocks.MANGROVE_GLASS_TECQUE.get());
        glassTecque(ModBlocks.CHERRY_GLASS_TECQUE.get());
        glassTecque(ModBlocks.BAMBOO_GLASS_TECQUE.get());
        glassTecque(ModBlocks.CRIMSON_GLASS_TECQUE.get());
        glassTecque(ModBlocks.WARPED_GLASS_TECQUE.get());
        glassTecque(ModBlocks.PALE_OAK_GLASS_TECQUE.get());

    }


    protected void woodenKitchenCounter(KitchenCounterBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_kitchen_counter")));

        Identifier defaultModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner")), Optional.of("_left_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner")), Optional.of("_right_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner_inverted")), Optional.of("_left_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner_inverted")), Optional.of("_right_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, KitchenCounterBlock.TYPE)
                        .select(Direction.NORTH, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, defaultModel);
    }

    protected void coloredKitchenCounter(KitchenCounterBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_kitchen_counter")));

        Identifier defaultModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner")), Optional.of("_left_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner")), Optional.of("_right_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner_inverted")), Optional.of("_left_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner_inverted")), Optional.of("_right_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, KitchenCounterBlock.TYPE)
                        .select(Direction.NORTH, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER, new MultiVariant(WeightedList.of(new Variant(leftCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER, new MultiVariant(WeightedList.of(new Variant(rightCornerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(leftInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, new MultiVariant(WeightedList.of(new Variant(rightInvModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, defaultModel);
    }

    protected void woodenKitchenDrawer(KitchenDrawerBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_kitchen_drawer")));

        Identifier closedModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_closed")), Optional.of("_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier openModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_open")), Optional.of("_open"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, KitchenDrawerBlock.OPEN)
                        .select(Direction.NORTH, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, closedModel);
    }

    protected void coloredKitchenDrawer(KitchenDrawerBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_kitchen_drawer")));

        Identifier closedModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_closed")), Optional.of("_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier openModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_open")), Optional.of("_open"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, KitchenDrawerBlock.OPEN)
                        .select(Direction.NORTH, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, new MultiVariant(WeightedList.of(new Variant(closedModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, new MultiVariant(WeightedList.of(new Variant(openModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, closedModel);
    }

    protected void woodenKitchenSink(KitchenSinkBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_kitchen_sink")));
        ModelTemplate template = getModel(Constants.id("block/kitchen_sink"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }

    protected void coloredKitchenSink(KitchenSinkBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_kitchen_sink")));
        ModelTemplate template = getModel(Constants.id("block/kitchen_sink"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }


    protected void woodenOven(OvenBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_kitchen_oven")));
        ModelTemplate template = getModel(Constants.id("block/oven"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }

    protected void coloredOven(OvenBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_kitchen_oven")));
        ModelTemplate template = getModel(Constants.id("block/oven"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }


    protected void woodenKitchenCabinet(CabinetBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_kitchen_cabinet")));

        Identifier closedModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_left")), Optional.of("_closed_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier openModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_left")), Optional.of("_open_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        Identifier closedModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_right")), Optional.of("_closed_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier openModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_right")), Optional.of("_open_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, CabinetBlock.OPEN, CabinetBlock.HANDLE)
                        .select(Direction.NORTH, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, closedModelLeft);
    }

    protected void coloredKitchenCabinet(CabinetBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_kitchen_cabinet")));

        Identifier closedModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_left")), Optional.of("_closed_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier openModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_left")), Optional.of("_open_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        Identifier closedModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_right")), Optional.of("_closed_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier openModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_right")), Optional.of("_open_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, CabinetBlock.OPEN, CabinetBlock.HANDLE)
                        .select(Direction.NORTH, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(closedModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, DoorHingeSide.LEFT, new MultiVariant(WeightedList.of(new Variant(openModelLeft))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(closedModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, DoorHingeSide.RIGHT, new MultiVariant(WeightedList.of(new Variant(openModelRight))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, closedModelLeft);
    }


    protected void fridge(FridgeBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/gray_concrete")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/fridge_" + type.getName())));

        Identifier topModel = new ModelTemplate(Optional.of(Constants.id("block/fridge_top")), Optional.of("_top"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier bottomModel = new ModelTemplate(Optional.of(Constants.id("block/fridge_bottom")), Optional.of("_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, FridgeBlock.MODEL_TYPE)
                        .select(Direction.NORTH, FRIDGE, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, FRIDGE, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, FRIDGE, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, FRIDGE, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, FREEZER, new MultiVariant(WeightedList.of(new Variant(topModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, FREEZER, new MultiVariant(WeightedList.of(new Variant(topModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, FREEZER, new MultiVariant(WeightedList.of(new Variant(topModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, FREEZER, new MultiVariant(WeightedList.of(new Variant(topModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, bottomModel);
    }

    protected void microwave(MicrowaveBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Constants.id(type.getName())))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/microwave_" + type.getName())));

        ModelTemplate template = getModel(Constants.id("block/microwave"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }


    protected void toaster(ToasterBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Constants.id(type.getName())))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/toaster_" + type.getName())));

        ModelTemplate template = getModel(Constants.id("block/toaster"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))));

        this.registerItemWithModel(block, model);
    }

    protected void cuttingBoard(CuttingBoardBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_cutting_board")));

        ModelTemplate template = getModel(Constants.id("block/cutting_board"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }

    protected void jar(JarBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_jar")));

        ModelTemplate template = getModel(Constants.id("block/jar"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }

    protected void basin(BasinBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_basin")));

        ModelTemplate template = getModel(Constants.id("block/basin"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }

    protected void toilet(ToiletBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_toilet")));

        ModelTemplate template = getModel(Constants.id("block/toilet"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }

    protected void bath(BathBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_bath")));

        Identifier modelHead = new ModelTemplate(Optional.of(Constants.id("block/bath_head")), Optional.of("_head"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier modelBottom = new ModelTemplate(Optional.of(Constants.id("block/bath_bottom")), Optional.of("_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier model = new ModelTemplate(Optional.of(Constants.id("block/bath")), Optional.empty(), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, BathBlock.PART)
                        .select(Direction.NORTH, HEAD, new MultiVariant(WeightedList.of(new Variant(modelHead))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, HEAD, new MultiVariant(WeightedList.of(new Variant(modelHead))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, HEAD, new MultiVariant(WeightedList.of(new Variant(modelHead))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, HEAD, new MultiVariant(WeightedList.of(new Variant(modelHead))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, BOTTOM, new MultiVariant(WeightedList.of(new Variant(modelBottom))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, BOTTOM, new MultiVariant(WeightedList.of(new Variant(modelBottom))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, BOTTOM, new MultiVariant(WeightedList.of(new Variant(modelBottom))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, BOTTOM, new MultiVariant(WeightedList.of(new Variant(modelBottom))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }

    protected void sofa(SofaBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_sofa")));

        Identifier singleModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_single")), Optional.of("_single"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier cornerLeftModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_corner_left")), Optional.of("_corner_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier cornerRightModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_corner_right")), Optional.of("_corner_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, SofaBlock.TYPE)
                        .select(Direction.NORTH, SofaBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, SofaBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, SofaBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, SofaBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, SofaBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, SofaBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, SofaBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, SofaBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, SofaBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, SofaBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, SofaBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, SofaBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, SofaBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, SofaBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, SofaBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, SofaBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, SofaBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, SofaBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, SofaBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, SofaBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, SofaBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, SofaBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, SofaBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, SofaBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, singleModel);
    }


    protected void chair(ChairBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_chair")));

        ModelTemplate template = getModel(Constants.id("block/chair"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }

    protected void stool(StoolBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_wool")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_stool")));
        ModelTemplate template = getModel(Constants.id("block/stool"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }


    protected void table(TableBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_table")));

        Identifier defaultModel = new ModelTemplate(Optional.of(Constants.id("block/table_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/table_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/table_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/table_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleTopModel = new ModelTemplate(Optional.of(Constants.id("block/table_middle_top")), Optional.of("_middle_top"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleBottomModel = new ModelTemplate(Optional.of(Constants.id("block/table_middle_bottom")), Optional.of("_middle_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier centerModel = new ModelTemplate(Optional.of(Constants.id("block/table_center")), Optional.of("_center"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier cornerLeftModel = new ModelTemplate(Optional.of(Constants.id("block/table_corner_left")), Optional.of("_corner_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier cornerRightModel = new ModelTemplate(Optional.of(Constants.id("block/table_corner_right")), Optional.of("_corner_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, TableBlock.TYPE)
                        .select(Direction.NORTH, TableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, TableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, TableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, TableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, TableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, defaultModel);
    }


    protected void desk(DeskBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_desk")));

        Identifier singleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_single")), Optional.of("_single"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/desk_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/desk_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, DeskBlock.TYPE)
                        .select(Direction.NORTH, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, singleModel);
    }


    protected void deskCabinet(DeskCabinetBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_desk_drawer")));

        Identifier singleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_single_closed")), Optional.of("_single_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_left_closed")), Optional.of("_left_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_right_closed")), Optional.of("_right_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_middle_closed")), Optional.of("_middle_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, DeskBlock.TYPE)
                        .select(Direction.NORTH, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, DeskBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, singleModel);
    }

    protected void coffeeTable(CoffeeTableBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_coffee_table")));

        Identifier defaultModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleTopModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_middle_top")), Optional.of("_middle_top"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleBottomModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_middle_bottom")), Optional.of("_middle_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier centerModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_center")), Optional.of("_center"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier cornerLeftModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_corner_left")), Optional.of("_corner_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier cornerRightModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_corner_right")), Optional.of("_corner_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, CoffeeTableBlock.TYPE)
                        .select(Direction.NORTH, CoffeeTableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.DEFAULT, new MultiVariant(WeightedList.of(new Variant(defaultModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.MIDDLE_TOP, new MultiVariant(WeightedList.of(new Variant(middleTopModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.MIDDLE_BOTTOM, new MultiVariant(WeightedList.of(new Variant(middleBottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.CENTER, new MultiVariant(WeightedList.of(new Variant(centerModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.CORNER_LEFT, new MultiVariant(WeightedList.of(new Variant(cornerLeftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, CoffeeTableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, CoffeeTableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, CoffeeTableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, CoffeeTableBlock.Type.CORNER_RIGHT, new MultiVariant(WeightedList.of(new Variant(cornerRightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, defaultModel);
    }



    protected void bedsideCabinet(BedsideCabinetBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_bedside_cabinet")));

        ModelTemplate template = getModel(Constants.id("block/bedside_cabinet"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }

    protected void lamp(LampBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_wool")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_lamp")));
        Identifier singleOffModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_single_off")), Optional.of("_single_off"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier singleOnModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_single_on")), Optional.of("_single_on"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier bottomModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_bottom")), Optional.of("_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier topOffModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_top_off")), Optional.of("_top_off"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier topOnModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_top_on")), Optional.of("_top_on"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier wallOffModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_wall_off")), Optional.of("_wall_off"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);
        Identifier wallOnModel = new ModelTemplate(Optional.of(Constants.id("block/lamp_wall_on")), Optional.of("_wall_on"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, LampBlock.POWERED, LampBlock.TYPE)
                        .select(Direction.NORTH, false, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, LampBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, false, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, false, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, LampBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, LampBlock.Type.BOTTOM, new MultiVariant(WeightedList.of(new Variant(bottomModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, false, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, LampBlock.Type.TOP, new MultiVariant(WeightedList.of(new Variant(topOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, false, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, false, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, false, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, false, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOffModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, true, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, true, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, true, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, true, LampBlock.Type.WALL, new MultiVariant(WeightedList.of(new Variant(wallOnModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, singleOffModel);
    }

    protected void digitalClock(DigitalClockBlock block) {
        DyeColor color = block.getDyeColor();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + color.getName() + "_concrete")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + color.getName() + "_digital_clock")));

        ModelTemplate template = getModel(Constants.id("block/digital_clock"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, model);
    }


    private void woodenClock(WoodenClockBlock block) {
        WoodType type = block.getWoodType();

        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")))
                .put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_clock")));

        ModelTemplate template = getModel(Constants.id("block/wooden_clock"));
        Identifier model = template.create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, model);
    }

    private void workbench(WorkbenchBlock block) {
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/oak_planks")))
                .put(TextureSlot.DOWN, new Material(Constants.id("block/" + block.name() + "_bottom")))
                .put(TextureSlot.UP, new Material(Constants.id("block/" + block.name() + "_top")))
                .put(TextureSlot.NORTH, new Material(Constants.id("block/" + block.name() + "_front")))
                .put(TextureSlot.SOUTH, new Material(Constants.id("block/" + block.name() + "_side")))
                .put(TextureSlot.EAST, new Material(Constants.id("block/" + block.name() + "_side")))
                .put(TextureSlot.WEST, new Material(Constants.id("block/" + block.name() + "_side")));
        Identifier model = new ModelTemplate(Optional.of(Identifier.withDefaultNamespace("block/cube")), Optional.empty(), TextureSlot.PARTICLE, TextureSlot.NORTH, TextureSlot.SOUTH, TextureSlot.EAST, TextureSlot.WEST, TextureSlot.UP, TextureSlot.DOWN).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block, new MultiVariant(WeightedList.of(new Variant(model)))));

        this.registerItemWithModel(block, model);
    }

    private void shelf(ShelfBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_shelf")));

        Identifier singleModel = new ModelTemplate(Optional.of(Constants.id("block/shelf_single")), Optional.of("_single"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/shelf_left")), Optional.of("_left"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/shelf_middle")), Optional.of("_middle"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/shelf_right")), Optional.of("_right"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, ShelfBlock.TYPE)
                        .select(Direction.NORTH, ShelfBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, ShelfBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, ShelfBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, ShelfBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, ShelfBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, ShelfBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, ShelfBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, ShelfBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, ShelfBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, ShelfBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, ShelfBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, ShelfBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.NORTH, ShelfBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, ShelfBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST, ShelfBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST, ShelfBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));

        this.registerItemWithModel(block, singleModel);
    }

    private void bench(ParkBenchBlock block) {
        WoodType type = block.getType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_bench")));

        Identifier singleModel = new ModelTemplate(Optional.of(Constants.id("block/park_bench_single")), Optional.of("_single"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);
        Identifier leftModel = new ModelTemplate(Optional.of(Constants.id("block/park_bench_left")), Optional.of("_left"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);
        Identifier middleModel = new ModelTemplate(Optional.of(Constants.id("block/park_bench_middle")), Optional.of("_middle"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);
        Identifier rightModel = new ModelTemplate(Optional.of(Constants.id("block/park_bench_right")), Optional.of("_right"), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block, textures, this.models::put);

        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, ParkBenchBlock.TYPE)
                        .select(Direction.NORTH, ParkBenchBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, ParkBenchBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, ParkBenchBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, ParkBenchBlock.Type.SINGLE, new MultiVariant(WeightedList.of(new Variant(singleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, ParkBenchBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, ParkBenchBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, ParkBenchBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, ParkBenchBlock.Type.LEFT, new MultiVariant(WeightedList.of(new Variant(leftModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, ParkBenchBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, ParkBenchBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, ParkBenchBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, ParkBenchBlock.Type.MIDDLE, new MultiVariant(WeightedList.of(new Variant(middleModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.NORTH, ParkBenchBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.SOUTH, ParkBenchBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.EAST, ParkBenchBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))
                        .select(Direction.WEST, ParkBenchBlock.Type.RIGHT, new MultiVariant(WeightedList.of(new Variant(rightModel))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))));

        this.registerItemWithModel(block, singleModel);
    }


    private void stonePath(PathBlock block) {
        StoneType type = block.getType();

        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.getName())));
        textures.put(TextureSlot.TEXTURE, new Material(Identifier.withDefaultNamespace("block/" + type.getName())));

        ModelTemplate template = getModel(Constants.id("block/stone_path0"));
        Identifier model = template.create(block, textures, this.models::put);
        this.registerItemWithModel(block, model);

        this.generators.put(block, MultiVariantGenerator.dispatch(block).with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING, PathBlock.WATERLOGGED)
                .select(Direction.NORTH, false, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                .select(Direction.SOUTH, false, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                .select(Direction.EAST, false, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                .select(Direction.WEST, false, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))

                .select(Direction.NORTH, true, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                .select(Direction.SOUTH, true, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                .select(Direction.EAST, true, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                .select(Direction.WEST, true, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));
    }

    private void crate(CrateBlock block) {
        WoodType type = block.getType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_crate")));

        ModelTemplate template = getModel(Constants.id("block/crate"));
        Identifier model = template.create(block, textures, this.models::put);

        this.registerItemWithModel(block, model);
        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST,  new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST,  new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));
    }

    private void glassTecque(TecqueBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, new Material(Identifier.withDefaultNamespace("block/" + type.name() + "_planks")));
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/" + type.name() + "_glass_tecque")));

        ModelTemplate template = getModel(Constants.id("block/glass_tecque"));
        Identifier model = template.create(block, textures, this.models::put);
        this.registerItemWithModel(block, model);
        this.generators.put(block, MultiVariantGenerator.dispatch(block)
                .with(PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.NORTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R0)))
                        .select(Direction.SOUTH, new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R180)))
                        .select(Direction.EAST,  new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R90)))
                        .select(Direction.WEST,  new MultiVariant(WeightedList.of(new Variant(model))).with(VariantMutator.Y_ROT.withValue(Quadrant.R270)))));
    }


    private static ModelTemplate getModel(Identifier model) {
        return new ModelTemplate(Optional.of(model), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
    }

    private void registerItemWithModel(Block block, Identifier location) {
        this.items.put(block.asItem(), this.createClientItem(ItemModelUtils.plainModel(location)));
    }
}