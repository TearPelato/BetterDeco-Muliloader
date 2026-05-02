package net.tier1234.better_deco.datagen;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.custom.KitchenCounterBlock;
import net.tier1234.better_deco.block.custom.KitchenDrawerBlock;
import net.tier1234.better_deco.init.ModBlocks;

public class NeoForgeBlockStateProvider extends BlockStateProvider {
    public NeoForgeBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        this.kitchenCounter(ModBlocks.CHERRY_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_counter"));
        this.kitchenCounter(ModBlocks.ACACIA_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_counter"));
        this.kitchenCounter(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_counter"));
        this.kitchenCounter(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_counter"));
        this.kitchenCounter(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_counter"));
        this.kitchenCounter(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_counter"));
        this.kitchenCounter(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_counter"));
        this.kitchenCounter(ModBlocks.WARPED_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_counter"));
        this.kitchenCounter(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_counter"));
        this.kitchenCounter(ModBlocks.BIRCH_KITCHEN_COUNTER.get(), Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_counter"));

        this.kitchenDrawer(ModBlocks.ACACIA_KITCHEN_DRAWER.get(), Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer"), Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer_open"));
        this.kitchenDrawer(ModBlocks.CHERRY_KITCHEN_DRAWER.get(), Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer"), Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer_open"));
        this.kitchenDrawer(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(), Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer"), Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer_open"));
        this.kitchenDrawer(ModBlocks.WARPED_KITCHEN_DRAWER.get(), Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer"), Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer_open"));
        this.kitchenDrawer(ModBlocks.BIRCH_KITCHEN_DRAWER.get(),Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer"), Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer_open") );
    }

    private void kitchenCounter(KitchenCounterBlock block, ResourceLocation texture)
    {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ModelFile defaultModel = models().withExistingParent(baseName + "_default", Constants.id("block/kitchen_counter_default"))
                .texture("0", texture)
                .texture("particle", texture);

        ModelFile leftCorner = models().withExistingParent(baseName + "_left_corner", Constants.id("block/kitchen_counter_left_corner"))
                .texture("0", texture)
                .texture("particle", texture);

        ModelFile rightCorner = models().withExistingParent(baseName + "_right_corner", Constants.id("block/kitchen_counter_right_corner"))
                .texture("0", texture)
                .texture("particle", texture);

        ModelFile leftCornerInverted = models().withExistingParent(baseName + "_left_corner_inverted", Constants.id("block/kitchen_counter_left_corner_inverted"))
                .texture("0", texture)
                .texture("particle", texture);

        ModelFile rightCornerInverted = models().withExistingParent(baseName + "_right_corner_inverted", Constants.id("block/kitchen_counter_right_corner_inverted"))
                .texture("0", texture)
                .texture("particle", texture);

        VariantBlockStateBuilder builder = getVariantBuilder(block);

        // NORTH
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.NORTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.DEFAULT)
                .modelForState().modelFile(defaultModel).rotationY(180).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.NORTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER)
                .modelForState().modelFile(leftCorner).rotationY(0).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.NORTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER)
                .modelForState().modelFile(rightCorner).rotationY(0).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.NORTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED)
                .modelForState().modelFile(leftCornerInverted).rotationY(0).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.NORTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED)
                .modelForState().modelFile(rightCornerInverted).rotationY(0).addModel();

        // EAST
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.EAST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.DEFAULT)
                .modelForState().modelFile(defaultModel).rotationY(270).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.EAST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER)
                .modelForState().modelFile(leftCorner).rotationY(90).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.EAST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER)
                .modelForState().modelFile(rightCorner).rotationY(90).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.EAST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED)
                .modelForState().modelFile(leftCornerInverted).rotationY(90).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.EAST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED)
                .modelForState().modelFile(rightCornerInverted).rotationY(90).addModel();

        // SOUTH
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.SOUTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.DEFAULT)
                .modelForState().modelFile(defaultModel).rotationY(0).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.SOUTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER)
                .modelForState().modelFile(leftCorner).rotationY(180).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.SOUTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER)
                .modelForState().modelFile(rightCorner).rotationY(180).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.SOUTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED)
                .modelForState().modelFile(leftCornerInverted).rotationY(180).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.SOUTH).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED)
                .modelForState().modelFile(rightCornerInverted).rotationY(180).addModel();

        // WEST
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.WEST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.DEFAULT)
                .modelForState().modelFile(defaultModel).rotationY(90).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.WEST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER)
                .modelForState().modelFile(leftCorner).rotationY(270).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.WEST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER)
                .modelForState().modelFile(rightCorner).rotationY(270).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.WEST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.LEFT_CORNER_INVERTED)
                .modelForState().modelFile(leftCornerInverted).rotationY(270).addModel();
        builder.partialState().with(KitchenCounterBlock.DIRECTION, Direction.WEST).with(KitchenCounterBlock.TYPE, KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED)
                .modelForState().modelFile(rightCornerInverted).rotationY(270).addModel();
    }

    private void kitchenDrawer(KitchenDrawerBlock block, ResourceLocation textureClosed, ResourceLocation textureOpen)
    {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ModelFile closedModel = models().withExistingParent(baseName + "_closed", Constants.id("block/kitchen_drawer_closed"))
                .texture("0", textureClosed)
                .texture("particle", textureClosed);

        ModelFile openModel = models().withExistingParent(baseName + "_open", Constants.id("block/kitchen_drawer_open"))
                .texture("0", textureOpen)
                .texture("particle", textureOpen);

        VariantBlockStateBuilder builder = getVariantBuilder(block);

        // NORTH
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.NORTH).with(KitchenDrawerBlock.OPEN, false)
                .modelForState().modelFile(closedModel).rotationY(0).addModel();
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.NORTH).with(KitchenDrawerBlock.OPEN, true)
                .modelForState().modelFile(openModel).rotationY(0).addModel();

        // EAST
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.EAST).with(KitchenDrawerBlock.OPEN, false)
                .modelForState().modelFile(closedModel).rotationY(90).addModel();
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.EAST).with(KitchenDrawerBlock.OPEN, true)
                .modelForState().modelFile(openModel).rotationY(90).addModel();

        // SOUTH
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.SOUTH).with(KitchenDrawerBlock.OPEN, false)
                .modelForState().modelFile(closedModel).rotationY(180).addModel();
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.SOUTH).with(KitchenDrawerBlock.OPEN, true)
                .modelForState().modelFile(openModel).rotationY(180).addModel();

        // WEST
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.WEST).with(KitchenDrawerBlock.OPEN, false)
                .modelForState().modelFile(closedModel).rotationY(270).addModel();
        builder.partialState().with(KitchenDrawerBlock.DIRECTION, Direction.WEST).with(KitchenDrawerBlock.OPEN, true)
                .modelForState().modelFile(openModel).rotationY(270).addModel();
    }

}
