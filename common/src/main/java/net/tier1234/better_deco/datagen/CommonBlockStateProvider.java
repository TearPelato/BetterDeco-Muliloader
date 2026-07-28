package net.tier1234.better_deco.datagen;

import com.google.gson.JsonObject;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.model.TextureMapping;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.custom.*;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public abstract class CommonBlockStateProvider implements DataProvider {

    private final PackOutput.PathProvider blockStatePaths;
    private final PackOutput.PathProvider modelPaths;
    private final PackOutput.PathProvider itemModelPaths;


    private final Map<ResourceLocation, JsonObject> itemModels = new LinkedHashMap<>();

    private final Map<ResourceLocation, JsonObject> blockStates = new LinkedHashMap<>();
    private final Map<ResourceLocation, JsonObject> models      = new LinkedHashMap<>();


    protected CommonBlockStateProvider(PackOutput output) {
        this.blockStatePaths = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.modelPaths      = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models/block");
        this.itemModelPaths =  output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models/item");

    }

    protected abstract void registerStatesAndModels();

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        blockStates.clear();
        models.clear();
        registerStatesAndModels();

        List<CompletableFuture<?>> futures = new ArrayList<>();

        blockStates.forEach((id, json) ->
                futures.add(DataProvider.saveStable(cache, json,
                        blockStatePaths.json(ResourceLocation.fromNamespaceAndPath(id.getNamespace(), id.getPath())))));

        models.forEach((id, json) ->
                futures.add(DataProvider.saveStable(cache, json,
                        modelPaths.json(ResourceLocation.fromNamespaceAndPath(id.getNamespace(), id.getPath())))));
        itemModels.forEach((id, json)-> {
            futures.add(DataProvider.saveStable(cache, json,
                    itemModelPaths.json(ResourceLocation.fromNamespaceAndPath(id.getNamespace(), id.getPath()))));
        });

        return CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new));
    }

    @Override
    public String getName() {
        return "BetterDeco BlockStates & Models";
    }

    protected void kitchenCounter(KitchenCounterBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation defaultKey     = modId(baseName + "_default");
        ResourceLocation leftCornerKey  = modId(baseName + "_left_corner");
        ResourceLocation rightCornerKey = modId(baseName + "_right_corner");
        ResourceLocation leftInvKey     = modId(baseName + "_left_corner_inverted");
        ResourceLocation rightInvKey    = modId(baseName + "_right_corner_inverted");

        ResourceLocation defaultRef     = modId("block/" + baseName + "_default");
        ResourceLocation leftCornerRef  = modId("block/" + baseName + "_left_corner");
        ResourceLocation rightCornerRef = modId("block/" + baseName + "_right_corner");
        ResourceLocation leftInvRef     = modId("block/" + baseName + "_left_corner_inverted");
        ResourceLocation rightInvRef    = modId("block/" + baseName + "_right_corner_inverted");

        registerModel(defaultKey,     Constants.id("block/kitchen_counter_default"),               texture);
        registerModel(leftCornerKey,  Constants.id("block/kitchen_counter_left_corner"),           texture);
        registerModel(rightCornerKey, Constants.id("block/kitchen_counter_right_corner"),          texture);
        registerModel(leftInvKey,     Constants.id("block/kitchen_counter_left_corner_inverted"),  texture);
        registerModel(rightInvKey,    Constants.id("block/kitchen_counter_right_corner_inverted"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int defRot  = defaultRotation(dir);
            int cornRot = cornerRotation(dir);
            for (KitchenCounterBlock.Type type : KitchenCounterBlock.Type.values()) {
                String key = "facing=" + dir.getSerializedName() + ",type=" + type.getSerializedName();
                ResourceLocation model = switch (type) {
                    case DEFAULT               -> defaultRef;
                    case LEFT_CORNER           -> leftCornerRef;
                    case RIGHT_CORNER          -> rightCornerRef;
                    case LEFT_CORNER_INVERTED  -> leftInvRef;
                    case RIGHT_CORNER_INVERTED -> rightInvRef;
                };
                int rot = (type == KitchenCounterBlock.Type.DEFAULT) ? defRot : cornRot;
                variants.add(key, variantJson(model, rot));
            }
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName,defaultRef);
    }

    protected void kitchenDrawer(KitchenDrawerBlock block,
                                 ResourceLocation textureClosed,
                                 ResourceLocation textureOpen) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation closedKey = modId(baseName + "_closed");
        ResourceLocation openKey   = modId(baseName + "_open");

        ResourceLocation closedRef = modId("block/" + baseName + "_closed");
        ResourceLocation openRef   = modId("block/" + baseName + "_open");

        registerModel(closedKey, Constants.id("block/kitchen_drawer_closed"), textureClosed);
        registerModel(openKey,   Constants.id("block/kitchen_drawer_open"),   textureOpen);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH + ",open=false", variantJson(closedRef, 0));
            variants.add("facing=" + Direction.EAST + ",open=false", variantJson(closedRef, 90));
            variants.add("facing=" + Direction.SOUTH + ",open=false", variantJson(closedRef, 180));
            variants.add("facing=" + Direction.WEST + ",open=false", variantJson(closedRef, 270));

            variants.add("facing=" + Direction.NORTH + ",open=true",  variantJson(openRef,   0));
            variants.add("facing=" + Direction.EAST + ",open=true",  variantJson(openRef,   90));
            variants.add("facing=" + Direction.SOUTH + ",open=true",  variantJson(openRef,   180));
            variants.add("facing=" + Direction.WEST + ",open=true",  variantJson(openRef,   270));
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, closedRef);

    }

    protected void  kitchenSink(KitchenSinkBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation textureKey = modId(baseName);
        ResourceLocation textureRef = modId("block/" + baseName );

        registerModel(textureKey, Constants.id("block/kitchen_sink"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH, variantJson(textureRef, 180));
            variants.add("facing=" + Direction.EAST, variantJson(textureRef, 270));
            variants.add("facing=" + Direction.SOUTH, variantJson(textureRef, 0));
            variants.add("facing=" + Direction.WEST , variantJson(textureRef, 90));
        }
        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName,textureRef);

    }

    protected void oven(OvenBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation textureKey = modId(baseName);
        ResourceLocation textureRef = modId("block/" + baseName );

        registerModel(textureKey, Constants.id("block/oven"), texture);

        JsonObject variants = new JsonObject();
        variants.add("facing=" + Direction.NORTH, variantJson(textureRef, 0));
        variants.add("facing=" + Direction.EAST, variantJson(textureRef, 90));
        variants.add("facing=" + Direction.SOUTH, variantJson(textureRef, 180));
        variants.add("facing=" + Direction.WEST , variantJson(textureRef, 270));

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, textureRef);
    }

    protected void kitchenCabinet(CabinetBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation closedRightKey = modId(baseName + "_closed_right");
        ResourceLocation closedLeftKey   = modId(baseName + "_closed_left");
        ResourceLocation openRightKey    = modId(baseName + "_open_right");
        ResourceLocation openLeftKey    = modId(baseName + "_open_left");

        ResourceLocation closedRightRef = modId("block/" + baseName + "_closed_right");
        ResourceLocation closedLeftRef = modId("block/" + baseName + "_closed_left");
        ResourceLocation openRightRef   = modId("block/" + baseName + "_open_right");
        ResourceLocation openLeftRef   = modId("block/" + baseName + "_open_left");



        registerModel(closedRightKey, Constants.id("block/cabinet_closed_right"), texture);
        registerModel(closedLeftKey, Constants.id("block/cabinet_closed_left"), texture);
        registerModel(openRightKey,   Constants.id("block/cabinet_open_right"),   texture);
        registerModel(openLeftKey,   Constants.id("block/cabinet_open_left"),   texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            variants.add("facing=" + Direction.NORTH + ",open=false," + "hinge=" + DoorHingeSide.LEFT, variantJson(closedLeftRef, 0));
            variants.add("facing=" + Direction.EAST + ",open=false," + "hinge=" + DoorHingeSide.LEFT, variantJson(closedLeftRef, 90));
            variants.add("facing=" + Direction.SOUTH + ",open=false," + "hinge=" + DoorHingeSide.LEFT, variantJson(closedLeftRef, 180));
            variants.add("facing=" + Direction.WEST + ",open=false," + "hinge=" + DoorHingeSide.LEFT, variantJson(closedLeftRef, 270));

            variants.add("facing=" + Direction.NORTH + ",open=true," + "hinge=" + DoorHingeSide.LEFT,  variantJson(openLeftRef,   0));
            variants.add("facing=" + Direction.EAST + ",open=true," + "hinge=" + DoorHingeSide.LEFT,  variantJson(openLeftRef,   90));
            variants.add("facing=" + Direction.SOUTH + ",open=true," + "hinge=" + DoorHingeSide.LEFT,  variantJson(openLeftRef,   180));
            variants.add("facing=" + Direction.WEST + ",open=true," + "hinge=" + DoorHingeSide.LEFT,  variantJson(openLeftRef,   270));

            variants.add("facing=" + Direction.NORTH + ",open=false," + "hinge=" + DoorHingeSide.RIGHT, variantJson(closedRightRef, 0));
            variants.add("facing=" + Direction.EAST + ",open=false," + "hinge=" + DoorHingeSide.RIGHT, variantJson(closedRightRef, 90));
            variants.add("facing=" + Direction.SOUTH + ",open=false," + "hinge=" + DoorHingeSide.RIGHT, variantJson(closedRightRef, 180));
            variants.add("facing=" + Direction.WEST + ",open=false," + "hinge=" + DoorHingeSide.RIGHT, variantJson(closedRightRef, 270));

            variants.add("facing=" + Direction.NORTH + ",open=true," + "hinge=" + DoorHingeSide.RIGHT,  variantJson(openRightRef,   0));
            variants.add("facing=" + Direction.EAST + ",open=true," + "hinge=" + DoorHingeSide.RIGHT,  variantJson(openRightRef,   90));
            variants.add("facing=" + Direction.SOUTH + ",open=true," + "hinge=" + DoorHingeSide.RIGHT,  variantJson(openRightRef,   180));
            variants.add("facing=" + Direction.WEST + ",open=true," + "hinge=" + DoorHingeSide.RIGHT,  variantJson(openRightRef,   270));



        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, closedLeftRef);

    }


    protected void fridge(FridgeBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation bottomKey = modId(baseName + "_bottom");
        ResourceLocation topKey    = modId(baseName + "_top");
        ResourceLocation fullKey    = modId(baseName);

        ResourceLocation bottomRef = modId("block/" + baseName + "_bottom");
        ResourceLocation topRef    = modId("block/" + baseName + "_top");

        registerModel(bottomKey, Constants.id("block/fridge_bottom"), texture);
        registerModel(topKey,    Constants.id("block/fridge_top"),    texture);
        registerModel(fullKey,      Constants.id("block/fridge"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            String facing = "facing=" + dir.getSerializedName();
            variants.add("model=fridge,"  + facing, variantJson(bottomRef, rot));
            variants.add("model=freezer," + facing, variantJson(topRef, rot));
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);

        registerItemBlockModel(baseName, modId("block/" + baseName));
    }

    protected void microwave(MicrowaveBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation closedKey = modId(baseName + "_closed");
        ResourceLocation openKey   = modId(baseName + "_open");

        ResourceLocation closedRef = modId("block/" + baseName + "_closed");
        ResourceLocation openRef   = modId("block/" + baseName + "_open");

        registerModel(closedKey, Constants.id("block/microwave_closed"), texture);
        registerModel(openKey,   Constants.id("block/microwave_open"),   texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH + ",open=false", variantJson(closedRef, 0));
            variants.add("facing=" + Direction.EAST + ",open=false", variantJson(closedRef, 90));
            variants.add("facing=" + Direction.SOUTH + ",open=false", variantJson(closedRef, 180));
            variants.add("facing=" + Direction.WEST + ",open=false", variantJson(closedRef, 270));

            variants.add("facing=" + Direction.NORTH + ",open=true",  variantJson(openRef,   0));
            variants.add("facing=" + Direction.EAST + ",open=true",  variantJson(openRef,   90));
            variants.add("facing=" + Direction.SOUTH + ",open=true",  variantJson(openRef,   180));
            variants.add("facing=" + Direction.WEST + ",open=true",  variantJson(openRef,   270));
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, closedRef);

    }


    protected void toaster(ToasterBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation toasterKey = modId(baseName);
        ResourceLocation toasterRef = modId("block/" + baseName);

        registerModel(toasterKey, Constants.id("block/toaster"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH, variantJson(toasterRef, 270));
            variants.add("facing=" + Direction.EAST, variantJson(toasterRef, 0));
            variants.add("facing=" + Direction.SOUTH, variantJson(toasterRef, 90));
            variants.add("facing=" + Direction.WEST, variantJson(toasterRef, 1800));

        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, toasterRef);

    }

    protected void cuttingBoard(CuttingBoardBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation cuttingBoardKey = modId(baseName);

        ResourceLocation cuttingBoardRef = modId("block/" + baseName);

        registerModel(cuttingBoardKey, Constants.id("block/cutting_board"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH, variantJson(cuttingBoardRef, 0));
            variants.add("facing=" + Direction.EAST , variantJson(cuttingBoardRef, 90));
            variants.add("facing=" + Direction.SOUTH , variantJson(cuttingBoardRef, 180));
            variants.add("facing=" + Direction.WEST , variantJson(cuttingBoardRef, 270));
        }


        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, modId("block/" + baseName));
    }

    protected void jar(JarBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation jarKey = modId(baseName);
        ResourceLocation jarRef = modId("block/" + baseName);

        registerModel(jarKey, Constants.id("block/jar"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH, variantJson(jarRef, 0));
            variants.add("facing=" + Direction.EAST , variantJson(jarRef, 90));
            variants.add("facing=" + Direction.SOUTH , variantJson(jarRef, 180));
            variants.add("facing=" + Direction.WEST , variantJson(jarRef, 270));
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, modId("block/" + baseName));

    }

    protected void workbench(Block block,
                             ResourceLocation textureFront,
                             ResourceLocation textureSide,
                             ResourceLocation textureTop,
                             ResourceLocation textureBottom) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation modelKey = modId(baseName);
        ResourceLocation modelRef = modId("block/" + baseName);

        registerCubeModel(modelKey, textureTop, textureFront, textureSide, textureBottom);

        JsonObject variants = new JsonObject();
        variants.add("", variantJson(modelRef, 0));

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);

        registerItemBlockModel(baseName, modelRef);
    }

    protected void basin(BasinBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation textureKey = modId(baseName);
        ResourceLocation textureRef = modId("block/" + baseName );

        registerModel(textureKey, Constants.id("block/basin"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH, variantJson(textureRef, 180));
            variants.add("facing=" + Direction.EAST, variantJson(textureRef, 270));
            variants.add("facing=" + Direction.SOUTH, variantJson(textureRef, 0));
            variants.add("facing=" + Direction.WEST , variantJson(textureRef, 90));
        }
        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName,textureRef);

    }



























































































































    private void registerCubeModel(ResourceLocation id,
                                   ResourceLocation top,
                                   ResourceLocation front,
                                   ResourceLocation side,
                                   ResourceLocation bottom) {
        JsonObject textures = new JsonObject();
        textures.addProperty("particle", front.toString());
        textures.addProperty("up",    top.toString());
        textures.addProperty("down",  bottom.toString());
        textures.addProperty("north", front.toString());
        textures.addProperty("south", front.toString());
        textures.addProperty("east",  side.toString());
        textures.addProperty("west",  side.toString());

        JsonObject model = new JsonObject();
        model.addProperty("parent", "minecraft:block/cube");
        model.add("textures", textures);

        models.put(id, model);
    }




    private void registerModel(ResourceLocation id, ResourceLocation parent, ResourceLocation texture) {
        JsonObject textures = new JsonObject();
        textures.addProperty("0",        texture.toString());
        textures.addProperty("particle", texture.toString());

        JsonObject model = new JsonObject();
        model.addProperty("parent", parent.toString());
        model.add("textures", textures);

        models.put(id, model);
    }
    public void registerItemModel(Item item, ResourceLocation texture) {
        String baseName = BuiltInRegistries.ITEM.getKey(item).getPath();
        JsonObject textures = new JsonObject();
        textures.addProperty("layer0", texture.toString());
        JsonObject model = new JsonObject();
        model.addProperty("parent", "minecraft:item/handheld");
        model.add("textures", textures);
        itemModels.put(modId(baseName), model);

    }

    protected void registerItemBlockModel(String blockName, ResourceLocation blockModelRef) {
        JsonObject model = new JsonObject();
        model.addProperty("parent", blockModelRef.toString());
        itemModels.put(modId(blockName), model);
    }

    private static JsonObject variantJson(ResourceLocation model, int rotY) {
        JsonObject obj = new JsonObject();
        obj.addProperty("model", model.toString());
        if (rotY != 0) obj.addProperty("y", rotY);
        return obj;
    }

    private static ResourceLocation modId(String path) {
        return ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, path);
    }

    private static final Direction[] HORIZONTALS = {
            Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST
    };

    private static int defaultRotation(Direction dir) {
        return switch (dir) {
            case NORTH -> 180;
            case EAST  -> 270;
            case SOUTH -> 0;
            case WEST  -> 90;
            default    -> 0;
        };
    }

    private static int cornerRotation(Direction dir) {
        return switch (dir) {
            case NORTH -> 0;
            case EAST  -> 90;
            case SOUTH -> 180;
            case WEST  -> 270;
            default    -> 0;
        };
    }
}