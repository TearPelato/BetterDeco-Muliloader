package net.tier1234.better_deco.datagen;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.core.Direction;
import net.minecraft.data.models.blockstates.*;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.data.models.model.ModelTemplate;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.data.models.model.TextureSlot;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.*;
import net.tier1234.better_deco.block.type.MetalType;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static net.tier1234.better_deco.block.BathBlock.BathPart.BOTTOM;
import static net.tier1234.better_deco.block.BathBlock.BathPart.HEAD;
import static net.tier1234.better_deco.block.FridgeBlock.FridgeModelType.FREEZER;
import static net.tier1234.better_deco.block.FridgeBlock.FridgeModelType.FRIDGE;

public class CommonModelsProvider {

    private final Consumer<BlockStateGenerator> blockStateConsumer;
    private final BiConsumer<ResourceLocation, Supplier<JsonElement>> modelConsumer;

    protected CommonModelsProvider(Consumer<BlockStateGenerator> blockStateConsumer,
                                   BiConsumer<ResourceLocation, Supplier<JsonElement>> modelConsumer) {
        this.blockStateConsumer = blockStateConsumer;
        this.modelConsumer = modelConsumer;
    }


    public void run() {

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

        registerItemModel(ModItems.KITCHEN_KNIFE.get(),ResourceLocation.withDefaultNamespace("item/handheld"),Constants.id("item/knife"));

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
        deskCabinet(ModBlocks.WARPED_DESK_CABINET.get() );



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
    }


    protected void woodenKitchenCounter(KitchenCounterBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_kitchen_counter"));

        ResourceLocation defaultModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation leftCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner")), Optional.of("_left_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation rightCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner")), Optional.of("_right_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation leftInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner_inverted")), Optional.of("_left_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation rightInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner_inverted")), Optional.of("_right_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, KitchenCounterBlock.TYPE)
                        .select(Direction.NORTH, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));




        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, defaultModel);
    }

    protected void coloredKitchenCounter(KitchenCounterBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + color.getName() + "_concrete"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/" + color.getName() + "_kitchen_counter"));

        ResourceLocation defaultModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation leftCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner")), Optional.of("_left_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation rightCornerModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner")), Optional.of("_right_corner"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation leftInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_left_corner_inverted")), Optional.of("_left_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation rightInvModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_counter_right_corner_inverted")), Optional.of("_right_corner_inverted"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, KitchenCounterBlock.TYPE)
                .select(Direction.NORTH, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, KitchenCounterBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER, Variant.variant().with(VariantProperties.MODEL, leftCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER, Variant.variant().with(VariantProperties.MODEL, rightCornerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, leftInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED, Variant.variant().with(VariantProperties.MODEL, rightInvModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));


        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, defaultModel);

    }

    protected void woodenKitchenDrawer(KitchenDrawerBlock block){
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+type.name()+"_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+type.name()+"_kitchen_drawer"));
        ResourceLocation closedModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_closed")),
                Optional.of("_closed"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation openModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_open")),
                Optional.of("_open"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, KitchenDrawerBlock.OPEN)
                .select(Direction.NORTH, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, closedModel);
    }

    protected void coloredKitchenDrawer(KitchenDrawerBlock block){
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+color.getName()+"_concrete"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+color.getName()+"_kitchen_drawer"));
        ResourceLocation closedModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_closed")),
                Optional.of("_closed"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation openModel = new ModelTemplate(Optional.of(Constants.id("block/kitchen_drawer_open")),
                Optional.of("_open"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, KitchenDrawerBlock.OPEN)
                .select(Direction.NORTH, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, false, Variant.variant().with(VariantProperties.MODEL, closedModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, true, Variant.variant().with(VariantProperties.MODEL, openModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, closedModel);
    }

    protected void woodenKitchenSink(KitchenSinkBlock block) {
       WoodType type = block.getWoodType();
       TextureMapping textures = new TextureMapping();
       textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+type.name()+"_planks"));
       textures.put(TextureSlot.TEXTURE, Constants.id("block/"+type.name()+"_kitchen_sink"));
       ModelTemplate template = getModel(Constants.id("block/kitchen_sink"));
       ResourceLocation model  = template.create(block, textures, modelConsumer);
       PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
               .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
               .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
               .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
               .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

       blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void coloredKitchenSink(KitchenSinkBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+color.getName()+"_concrete"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+color.getName()+"_kitchen_sink"));
        ModelTemplate template = getModel(Constants.id("block/kitchen_sink"));
        ResourceLocation model  = template.create(block, textures, modelConsumer);
        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }


    protected void woodenOven(OvenBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+type.name()+"_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+type.name()+"_kitchen_oven"));
        ModelTemplate template = getModel(Constants.id("block/oven"));
        ResourceLocation model  = template.create(block, textures, modelConsumer);
        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void coloredOven(OvenBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+color.getName()+"_concrete"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+color.getName()+"_kitchen_oven"));
        ModelTemplate template = getModel(Constants.id("block/oven"));
        ResourceLocation model  = template.create(block, textures, modelConsumer);
        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }


    protected void woodenKitchenCabinet(CabinetBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+type.name()+"_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+type.name()+"_kitchen_cabinet"));

        ResourceLocation closedModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_left")),
                Optional.of("_closed_left"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation openModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_left")),
                Optional.of("_open_left"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        ResourceLocation closedModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_right")),
                Optional.of("_closed_right"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation openModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_right")),
                Optional.of("_open_right"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);


        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, CabinetBlock.OPEN, CabinetBlock.HANDLE)
                .select(Direction.NORTH, false, DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, false,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, false,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, false,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, false, DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, false,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, false,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, false,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, closedModelLeft);
    }

    protected void coloredKitchenCabinet(CabinetBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+color.getName()+"_concrete"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/"+color.getName()+"_kitchen_cabinet"));

        ResourceLocation closedModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_left")),
                Optional.of("_closed_left"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation openModelLeft = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_left")),
                Optional.of("_open_left"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        ResourceLocation closedModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_closed_right")),
                Optional.of("_closed_right"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation openModelRight = new ModelTemplate(Optional.of(Constants.id("block/cabinet_open_right")),
                Optional.of("_open_right"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);


        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, CabinetBlock.OPEN, CabinetBlock.HANDLE)
                .select(Direction.NORTH, false, DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, false,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, false,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, false,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, closedModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, true,DoorHingeSide.LEFT, Variant.variant().with(VariantProperties.MODEL, openModelLeft).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, false, DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, false,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, false,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, false,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, closedModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, true,DoorHingeSide.RIGHT, Variant.variant().with(VariantProperties.MODEL, openModelRight).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, closedModelLeft);
    }


    protected void fridge(FridgeBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/gray_concrete"))
                .put(TextureSlot.TEXTURE, Constants.id("block/fridge_" + type.getName()));

        ResourceLocation topModel = new ModelTemplate(Optional.of(Constants.id("block/fridge_top")), Optional.of("_top"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation bottomModel = new ModelTemplate(Optional.of(Constants.id("block/fridge_bottom")), Optional.of("_bottom"),TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation model = new ModelTemplate(Optional.of(Constants.id("block/fridge")), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, FridgeBlock.MODEL_TYPE)
                .select(Direction.NORTH, FRIDGE, Variant.variant().with(VariantProperties.MODEL, bottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH,FRIDGE, Variant.variant().with(VariantProperties.MODEL, bottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST,FRIDGE,  Variant.variant().with(VariantProperties.MODEL, bottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST,FRIDGE,  Variant.variant().with(VariantProperties.MODEL, bottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, FREEZER, Variant.variant().with(VariantProperties.MODEL, topModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH,FREEZER, Variant.variant().with(VariantProperties.MODEL, topModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST,FREEZER,  Variant.variant().with(VariantProperties.MODEL, topModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST,FREEZER,  Variant.variant().with(VariantProperties.MODEL, topModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void microwave(MicrowaveBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, Constants.id(type.getName()))
                .put(TextureSlot.TEXTURE, Constants.id("block/microwave_" + type.getName()));

        ModelTemplate template = getModel(Constants.id("block/microwave"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);

    }


    protected void toaster(ToasterBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, Constants.id(type.getName()))
                .put(TextureSlot.TEXTURE, Constants.id("block/toaster_" + type.getName()));

        ModelTemplate template = getModel(Constants.id("block/toaster"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);

    }

    protected void cuttingBoard(CuttingBoardBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_cutting_board"));

        ModelTemplate template = getModel(Constants.id("block/cutting_board"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void jar(JarBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_jar"));

        ModelTemplate template = getModel(Constants.id("block/jar"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void basin(BasinBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_basin"));

        ModelTemplate template = getModel(Constants.id("block/basin"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void toilet(ToiletBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_toilet"));

        ModelTemplate template = getModel(Constants.id("block/toilet"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void bath(BathBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_toilet"));

        ResourceLocation modelHead = new ModelTemplate(Optional.of(Constants.id("block/bath_head")), Optional.of("_head"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation modelBottom = new ModelTemplate(Optional.of(Constants.id("block/bath_bottom")), Optional.of("_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures, modelConsumer);
        ResourceLocation model = new ModelTemplate(Optional.of(Constants.id("block/bath")), Optional.empty(), TextureSlot.PARTICLE, TextureSlot.TEXTURE).create(block,textures,modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, BathBlock.PART)
                .select(Direction.NORTH, HEAD, Variant.variant().with(VariantProperties.MODEL, modelHead).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, HEAD, Variant.variant().with(VariantProperties.MODEL, modelHead).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, HEAD, Variant.variant().with(VariantProperties.MODEL, modelHead).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, HEAD, Variant.variant().with(VariantProperties.MODEL, modelHead).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, BOTTOM, Variant.variant().with(VariantProperties.MODEL, modelBottom).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, BOTTOM, Variant.variant().with(VariantProperties.MODEL, modelBottom).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, BOTTOM, Variant.variant().with(VariantProperties.MODEL, modelBottom).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, BOTTOM, Variant.variant().with(VariantProperties.MODEL, modelBottom).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void sofa(SofaBlock block) {
        DyeColor color = block.getColor();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + color.getName() + "_concrete"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + color.getName() + "_sofa"));

        ResourceLocation singleModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_single")), Optional.of("_single"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation leftModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation rightModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation middleModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation cornerLeftModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_corner_left")), Optional.of("_corner_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation cornerRightModel = new ModelTemplate(Optional.of(Constants.id("block/sofa_corner_right")), Optional.of("_corner_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, SofaBlock.TYPE)
                .select(Direction.NORTH, SofaBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, SofaBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, SofaBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, SofaBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, SofaBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, SofaBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, SofaBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, SofaBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, SofaBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, SofaBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, SofaBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, SofaBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, SofaBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, SofaBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, SofaBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, SofaBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, SofaBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, SofaBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, SofaBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, SofaBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.NORTH, SofaBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, SofaBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST, SofaBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST, SofaBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));

        registerItemModel(block, singleModel);

    }


    protected void chair(ChairBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_chair"));

        ModelTemplate template = getModel(Constants.id("block/chair"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }


    protected void table(TableBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_table"));

        ResourceLocation defaultModel = new ModelTemplate(Optional.of(Constants.id("block/table_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation leftModel = new ModelTemplate(Optional.of(Constants.id("block/table_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation rightModel = new ModelTemplate(Optional.of(Constants.id("block/table_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation middleModel = new ModelTemplate(Optional.of(Constants.id("block/table_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation middleTopModel = new ModelTemplate(Optional.of(Constants.id("block/table_middle_top")), Optional.of("_middle_top"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation middleBottomModel = new ModelTemplate(Optional.of(Constants.id("block/table_middle_bottom")), Optional.of("_middle_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation centerModel = new ModelTemplate(Optional.of(Constants.id("block/table_center")), Optional.of("_center"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation cornerLeftModel = new ModelTemplate(Optional.of(Constants.id("block/table_corner_left")), Optional.of("_corner_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation cornerRightModel = new ModelTemplate(Optional.of(Constants.id("block/table_corner_right")), Optional.of("_corner_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);


        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, TableBlock.TYPE)
                        .select(Direction.NORTH, TableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                        .select(Direction.NORTH, TableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                        .select(Direction.SOUTH, TableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                        .select(Direction.EAST, TableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                        .select(Direction.WEST, TableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));


        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, defaultModel);
    }


    protected void desk(DeskBlock block)  {
     WoodType type = block.getWoodType();
     TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_desk"));

        ResourceLocation singleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_single")), Optional.of("_single"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation leftModel = new ModelTemplate(Optional.of(Constants.id("block/desk_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation rightModel = new ModelTemplate(Optional.of(Constants.id("block/desk_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation middleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, DeskBlock.TYPE)
                .select(Direction.NORTH, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, singleModel);

    }


    protected void deskCabinet(DeskCabinetBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_desk"));

        ResourceLocation singleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_single_closed")), Optional.of("_single_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation leftModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_left_closed")), Optional.of("_left_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation rightModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_right_closed")), Optional.of("_right_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);
        ResourceLocation middleModel = new ModelTemplate(Optional.of(Constants.id("block/desk_cabinet_middle_closed")), Optional.of("_middle_closed"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block, textures,modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, DeskBlock.TYPE)
                .select(Direction.NORTH, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.SINGLE, Variant.variant().with(VariantProperties.MODEL, singleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, DeskBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, singleModel);
    }

    protected void coffeeTable(CoffeeTableBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"));
        textures.put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_coffee_table"));

        ResourceLocation defaultModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_default")), Optional.of("_default"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation leftModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_left")), Optional.of("_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation rightModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_right")), Optional.of("_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation middleModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_middle")), Optional.of("_middle"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation middleTopModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_middle_top")), Optional.of("_middle_top"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation middleBottomModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_middle_bottom")), Optional.of("_middle_bottom"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation centerModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_center")), Optional.of("_center"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation cornerLeftModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_corner_left")), Optional.of("_corner_left"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);
        ResourceLocation cornerRightModel = new ModelTemplate(Optional.of(Constants.id("block/coffee_table_corner_right")), Optional.of("_corner_right"), TextureSlot.TEXTURE, TextureSlot.PARTICLE).create(block,textures,modelConsumer);


        PropertyDispatch dispatch = PropertyDispatch.properties(BlockStateProperties.HORIZONTAL_FACING, CoffeeTableBlock.TYPE)
                .select(Direction.NORTH, CoffeeTableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.DEFAULT, Variant.variant().with(VariantProperties.MODEL, defaultModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.LEFT, Variant.variant().with(VariantProperties.MODEL, leftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.RIGHT, Variant.variant().with(VariantProperties.MODEL, rightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.MIDDLE, Variant.variant().with(VariantProperties.MODEL, middleModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.MIDDLE_TOP, Variant.variant().with(VariantProperties.MODEL, middleTopModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.MIDDLE_BOTTOM, Variant.variant().with(VariantProperties.MODEL, middleBottomModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.CENTER, Variant.variant().with(VariantProperties.MODEL, centerModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.CORNER_LEFT, Variant.variant().with(VariantProperties.MODEL, cornerLeftModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.NORTH, CoffeeTableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, CoffeeTableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST, CoffeeTableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST, CoffeeTableBlock.Type.CORNER_RIGHT, Variant.variant().with(VariantProperties.MODEL, cornerRightModel).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));


        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, defaultModel);
    }



    protected void bedsideCabinet(BedsideCabinetBlock block) {
        WoodType type = block.getWoodType();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_bedside_cabinet"));

        ModelTemplate template = getModel(Constants.id("block/bedside_cabinet"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    protected void digitalClock(DigitalClockBlock block) {
        DyeColor color = block.getDyeColor();
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/"+ color.getName() + "_concrete"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + color.getName() + "_digital_clock"));

        ModelTemplate template = getModel(Constants.id("block/digital_clock"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }


    private void woodenClock(WoodenClockBlock block) {
        WoodType type = block.getWoodType();

        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/" + type.name() + "_planks"))
                .put(TextureSlot.TEXTURE, Constants.id("block/" + type.name() + "_clock"));

        ModelTemplate template = getModel(Constants.id("block/wooden_clock"));
        ResourceLocation model = template.create(block, textures, modelConsumer);

        PropertyDispatch dispatch = PropertyDispatch.property(BlockStateProperties.HORIZONTAL_FACING)
                .select(Direction.NORTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R180))
                .select(Direction.SOUTH, Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R0))
                .select(Direction.EAST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R270))
                .select(Direction.WEST,  Variant.variant().with(VariantProperties.MODEL, model).with(VariantProperties.Y_ROT, VariantProperties.Rotation.R90));

        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block).with(dispatch));
        registerItemModel(block, model);
    }

    private void workbench(WorkbenchBlock block) {
        TextureMapping textures = new TextureMapping()
                .put(TextureSlot.PARTICLE, ResourceLocation.withDefaultNamespace("block/oak_planks"))
                .put(TextureSlot.DOWN, Constants.id("block/" + block.name() + "_bottom"))
                .put(TextureSlot.UP, Constants.id("block/" + block.name() + "_top"))
                .put(TextureSlot.NORTH, Constants.id("block/" + block.name() + "_front"))
                .put(TextureSlot.SOUTH, Constants.id("block/" + block.name() + "_side"))
                .put(TextureSlot.EAST, Constants.id("block/" + block.name() + "_side"))
                .put(TextureSlot.WEST, Constants.id("block/" + block.name() + "_side"));
        ResourceLocation model = new ModelTemplate(Optional.of(ResourceLocation.withDefaultNamespace("block/cube")), Optional.empty(), TextureSlot.PARTICLE, TextureSlot.NORTH, TextureSlot.SOUTH, TextureSlot.EAST, TextureSlot.WEST, TextureSlot.UP, TextureSlot.DOWN).create(block, textures, modelConsumer);
        blockStateConsumer.accept(MultiVariantGenerator.multiVariant(block, Variant.variant().with(VariantProperties.MODEL, model)));

        registerItemModel(block, model);

    }


    private static ModelTemplate getModel(ResourceLocation model) {
        return new ModelTemplate(Optional.of(model), Optional.empty(), TextureSlot.TEXTURE, TextureSlot.PARTICLE);
    }

    protected void registerItemModel(Item item, ResourceLocation parent, ResourceLocation texture) {
        ResourceLocation itemModel = ModelLocationUtils.getModelLocation(item);
        modelConsumer.accept(itemModel, () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", parent.toString());

            JsonObject textures = new JsonObject();
            textures.addProperty("layer0", texture.toString());
            json.add("textures", textures);

            return json;
        });
    }

    protected void registerItemModel(Item item, ResourceLocation parentModel) {
        ResourceLocation itemModel = ModelLocationUtils.getModelLocation(item);
        modelConsumer.accept(itemModel, () -> {
            JsonObject json = new JsonObject();
            json.addProperty("parent", parentModel.toString());
            return json;
        });
    }

    protected void registerItemModel(Block block, ResourceLocation parentModel) {
        registerItemModel(block.asItem(), parentModel);
    }

}