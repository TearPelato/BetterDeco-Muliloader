package net.tier1234.better_deco.datagen;

import com.google.gson.JsonObject;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.custom.KitchenCounterBlock;
import net.tier1234.better_deco.block.custom.KitchenDrawerBlock;
import net.tier1234.better_deco.init.ModBlocks;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class FabricBlockStateProvider implements DataProvider {

    private final PackOutput.PathProvider blockStatePathProvider;
    private final Map<Block, JsonObject> blockStates = new LinkedHashMap<>();

    public FabricBlockStateProvider(PackOutput output) {
        this.blockStatePathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        registerStatesAndModels();

        List<CompletableFuture<?>> futures = new ArrayList<>();
        for (Map.Entry<Block, JsonObject> entry : blockStates.entrySet()) {
            ResourceLocation id = BuiltInRegistries.BLOCK.getKey(entry.getKey());
            Path path = blockStatePathProvider.json(id);
            futures.add(DataProvider.saveStable(cache, entry.getValue(), path));
        }
        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "Block States: " + Constants.MOD_ID;
    }

    protected void registerStatesAndModels() {
        kitchenCounter(ModBlocks.CHERRY_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_counter"));
        kitchenCounter(ModBlocks.ACACIA_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_counter"));
        kitchenCounter(ModBlocks.DARK_OAK_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/dark_oak/dark_oak_kitchen_counter"));
        kitchenCounter(ModBlocks.MANGROVE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/mangrove/mangrove_kitchen_counter"));
        kitchenCounter(ModBlocks.JUNGLE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_counter"));
        kitchenCounter(ModBlocks.SPRUCE_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/spruce/spruce_kitchen_counter"));
        kitchenCounter(ModBlocks.CRIMSON_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/crimson/crimson_kitchen_counter"));
        kitchenCounter(ModBlocks.WARPED_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_counter"));
        kitchenCounter(ModBlocks.BAMBOO_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/bamboo/bamboo_kitchen_counter"));
        kitchenCounter(ModBlocks.BIRCH_KITCHEN_COUNTER.get(),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_counter"));

        kitchenDrawer(ModBlocks.ACACIA_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/acacia/acacia_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.CHERRY_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/cherry/cherry_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.JUNGLE_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/jungle/jungle_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.WARPED_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/warped/warped_kitchen_drawer_open"));
        kitchenDrawer(ModBlocks.BIRCH_KITCHEN_DRAWER.get(),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer"),
                Constants.id("block/furniture/kitchen_counter/birch/birch_kitchen_drawer_open"));
    }

    private void kitchenCounter(KitchenCounterBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        String defaultModel        = modPath(baseName + "_default");
        String leftCorner          = modPath(baseName + "_left_corner");
        String rightCorner         = modPath(baseName + "_right_corner");
        String leftCornerInverted  = modPath(baseName + "_left_corner_inverted");
        String rightCornerInverted = modPath(baseName + "_right_corner_inverted");

        JsonObject variants = new JsonObject();

        record TypeEntry(KitchenCounterBlock.Type type, String model) {}
        List<TypeEntry> types = List.of(
                new TypeEntry(KitchenCounterBlock.Type.DEFAULT,                defaultModel),
                new TypeEntry(KitchenCounterBlock.Type.LEFT_CORNER,            leftCorner),
                new TypeEntry(KitchenCounterBlock.Type.RIGHT_CORNER,           rightCorner),
                new TypeEntry(KitchenCounterBlock.Type.LEFT_CORNER_INVERTED,   leftCornerInverted),
                new TypeEntry(KitchenCounterBlock.Type.RIGHT_CORNER_INVERTED,  rightCornerInverted)
        );

        record DirEntry(Direction dir, int defaultY, int cornerY) {}
        List<DirEntry> dirs = List.of(
                new DirEntry(Direction.NORTH, 180, 0),
                new DirEntry(Direction.EAST,  270, 90),
                new DirEntry(Direction.SOUTH, 0,   180),
                new DirEntry(Direction.WEST,  90,  270)
        );

        for (DirEntry d : dirs) {
            for (TypeEntry t : types) {
                int rotY = (t.type() == KitchenCounterBlock.Type.DEFAULT) ? d.defaultY() : d.cornerY();
                String key = "facing=" + d.dir().getSerializedName() + ",type=" + t.type().getSerializedName();
                variants.add(key, modelVariant(t.model(), rotY));
            }
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(block, root);
    }

    private void kitchenDrawer(KitchenDrawerBlock block,
                               ResourceLocation textureClosed,
                               ResourceLocation textureOpen) {
        String baseName    = BuiltInRegistries.BLOCK.getKey(block).getPath();
        String closedModel = modPath(baseName + "_closed");
        String openModel   = modPath(baseName + "_open");

        JsonObject variants = new JsonObject();

        record DirRot(Direction dir, int rotY) {}
        List<DirRot> dirs = List.of(
                new DirRot(Direction.NORTH, 0),
                new DirRot(Direction.EAST,  90),
                new DirRot(Direction.SOUTH, 180),
                new DirRot(Direction.WEST,  270)
        );

        for (DirRot d : dirs) {
            String keyOpen   = "facing=" + d.dir().getSerializedName() + ",open=true";
            String keyClosed = "facing=" + d.dir().getSerializedName() + ",open=false";
            variants.add(keyClosed, modelVariant(closedModel, d.rotY()));
            variants.add(keyOpen,   modelVariant(openModel,   d.rotY()));
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(block, root);
    }

    private static String modPath(String blockName) {
        return Constants.MOD_ID + ":block/" + blockName;
    }

    private static JsonObject modelVariant(String model, int rotY) {
        JsonObject obj = new JsonObject();
        obj.addProperty("model", model);
        if (rotY != 0) {
            obj.addProperty("y", rotY);
        }
        return obj;
    }
}