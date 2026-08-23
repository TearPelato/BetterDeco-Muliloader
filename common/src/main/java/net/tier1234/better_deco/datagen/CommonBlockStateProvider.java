package net.tier1234.better_deco.datagen;

import com.google.gson.JsonObject;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.*;

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

        ResourceLocation defaultKey     = Constants.id(baseName + "_default");
        ResourceLocation leftCornerKey  = Constants.id(baseName + "_left_corner");
        ResourceLocation rightCornerKey = Constants.id(baseName + "_right_corner");
        ResourceLocation leftInvKey     = Constants.id(baseName + "_left_corner_inverted");
        ResourceLocation rightInvKey    = Constants.id(baseName + "_right_corner_inverted");

        ResourceLocation defaultRef     = Constants.id("block/" + baseName + "_default");
        ResourceLocation leftCornerRef  = Constants.id("block/" + baseName + "_left_corner");
        ResourceLocation rightCornerRef = Constants.id("block/" + baseName + "_right_corner");
        ResourceLocation leftInvRef     = Constants.id("block/" + baseName + "_left_corner_inverted");
        ResourceLocation rightInvRef    = Constants.id("block/" + baseName + "_right_corner_inverted");

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

        ResourceLocation closedKey = Constants.id(baseName + "_closed");
        ResourceLocation openKey   = Constants.id(baseName + "_open");

        ResourceLocation closedRef = Constants.id("block/" + baseName + "_closed");
        ResourceLocation openRef   = Constants.id("block/" + baseName + "_open");

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
        ResourceLocation textureKey = Constants.id(baseName);
        ResourceLocation textureRef = Constants.id("block/" + baseName );

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
        ResourceLocation textureKey = Constants.id(baseName);
        ResourceLocation textureRef = Constants.id("block/" + baseName );

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

        ResourceLocation closedRightKey = Constants.id(baseName + "_closed_right");
        ResourceLocation closedLeftKey   = Constants.id(baseName + "_closed_left");
        ResourceLocation openRightKey    = Constants.id(baseName + "_open_right");
        ResourceLocation openLeftKey    = Constants.id(baseName + "_open_left");

        ResourceLocation closedRightRef = Constants.id("block/" + baseName + "_closed_right");
        ResourceLocation closedLeftRef = Constants.id("block/" + baseName + "_closed_left");
        ResourceLocation openRightRef   = Constants.id("block/" + baseName + "_open_right");
        ResourceLocation openLeftRef   = Constants.id("block/" + baseName + "_open_left");



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

        ResourceLocation bottomKey = Constants.id(baseName + "_bottom");
        ResourceLocation topKey    = Constants.id(baseName + "_top");
        ResourceLocation fullKey    = Constants.id(baseName);

        ResourceLocation bottomRef = Constants.id("block/" + baseName + "_bottom");
        ResourceLocation topRef    = Constants.id("block/" + baseName + "_top");

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

        registerItemBlockModel(baseName, Constants.id("block/" + baseName));
    }

    protected void microwave(MicrowaveBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation closedKey = Constants.id(baseName + "_closed");
        ResourceLocation openKey   = Constants.id(baseName + "_open");

        ResourceLocation closedRef = Constants.id("block/" + baseName + "_closed");
        ResourceLocation openRef   = Constants.id("block/" + baseName + "_open");

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
        ResourceLocation toasterKey = Constants.id(baseName);
        ResourceLocation toasterRef = Constants.id("block/" + baseName);

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

        ResourceLocation cuttingBoardKey = Constants.id(baseName);

        ResourceLocation cuttingBoardRef = Constants.id("block/" + baseName);

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
        registerItemBlockModel(baseName, Constants.id("block/" + baseName));
    }

    protected void jar(JarBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation jarKey = Constants.id(baseName);
        ResourceLocation jarRef = Constants.id("block/" + baseName);

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
        registerItemBlockModel(baseName, Constants.id("block/" + baseName));

    }

    protected void workbench(Block block,
                             ResourceLocation textureFront,
                             ResourceLocation textureSide,
                             ResourceLocation textureTop,
                             ResourceLocation textureBottom) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation modelKey = Constants.id(baseName);
        ResourceLocation modelRef = Constants.id("block/" + baseName);

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
        ResourceLocation textureKey = Constants.id(baseName);
        ResourceLocation textureRef = Constants.id("block/" + baseName );

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

    protected void toilet(ToiletBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation textureKey = Constants.id(baseName);
        ResourceLocation textureRef = Constants.id("block/" + baseName );

        registerModel(textureKey, Constants.id("block/toilet"), texture);

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

    protected void bath(BathBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation bottomModelKey = Constants.id(baseName + "_bottom");
        ResourceLocation headModelKey   = Constants.id(baseName + "_head");
        ResourceLocation itemModelKey   = Constants.id(baseName);

        ResourceLocation bottomRef = Constants.id("block/" + baseName + "_bottom");
        ResourceLocation headRef   = Constants.id("block/" + baseName + "_head");
        ResourceLocation itemRef   = Constants.id("block/" + baseName);

        registerModel(bottomModelKey, Constants.id("block/bath_bottom"), texture);
        registerModel(headModelKey,   Constants.id("block/bath_head"), texture);

        registerModel(itemModelKey,   Constants.id("block/bath"), texture);

        JsonObject variants = new JsonObject();

        variants.add("facing=" + Direction.NORTH + ",part=bottom", variantJson(bottomRef, 180));
        variants.add("facing=" + Direction.EAST  + ",part=bottom", variantJson(bottomRef, 270));
        variants.add("facing=" + Direction.SOUTH + ",part=bottom", variantJson(bottomRef, 0));
        variants.add("facing=" + Direction.WEST  + ",part=bottom", variantJson(bottomRef, 90));

        variants.add("facing=" + Direction.NORTH + ",part=head", variantJson(headRef, 180));
        variants.add("facing=" + Direction.EAST  + ",part=head", variantJson(headRef, 270));
        variants.add("facing=" + Direction.SOUTH + ",part=head", variantJson(headRef, 0));
        variants.add("facing=" + Direction.WEST  + ",part=head", variantJson(headRef, 90));

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);

        registerItemBlockModel(baseName, itemRef);
    }

    protected void sofa(SofaBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation defaultKey     = Constants.id(baseName + "_single");
        ResourceLocation leftCornerKey  = Constants.id(baseName + "_left");
        ResourceLocation rightCornerKey = Constants.id(baseName + "_right");
        ResourceLocation middleKey     = Constants.id(baseName + "_middle");
        ResourceLocation corner_leftKey    = Constants.id(baseName + "_corner_left");
        ResourceLocation corner_rightKey   = Constants.id(baseName + "_corner_right");

        ResourceLocation defaultRef     = Constants.id("block/" + baseName + "_single");
        ResourceLocation leftCornerRef  = Constants.id("block/" + baseName + "_left");
        ResourceLocation rightCornerRef = Constants.id("block/" + baseName + "_right");
        ResourceLocation middleRef    = Constants.id("block/" + baseName + "_middle");
        ResourceLocation corner_leftRef    = Constants.id("block/" + baseName + "_corner_left");
        ResourceLocation corner_rightRef   = Constants.id("block/" + baseName + "_corner_right");

        registerModel(defaultKey,     Constants.id("block/sofa_single"),               texture);
        registerModel(leftCornerKey,  Constants.id("block/sofa_left"),           texture);
        registerModel(rightCornerKey, Constants.id("block/sofa_right"),          texture);
        registerModel(middleKey,     Constants.id("block/sofa_middle"),  texture);
        registerModel(corner_leftKey,    Constants.id("block/sofa_corner_left"), texture);
        registerModel(corner_rightKey,    Constants.id("block/sofa_corner_right"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int defRot  = defaultRotation(dir);
            int cornRot = cornerRotation(dir);
            for (SofaBlock.Type type : SofaBlock.Type.values()) {
                String key = "facing=" + dir.getSerializedName() + ",type=" + type.getSerializedName();
                ResourceLocation model = switch (type) {
                    case SINGLE               -> defaultRef;
                    case LEFT           -> leftCornerRef;
                    case RIGHT          -> rightCornerRef;
                    case MIDDLE  -> middleRef;
                    case CORNER_LEFT -> corner_leftRef;
                    case CORNER_RIGHT -> corner_rightRef;
                };
                int rot = (type == SofaBlock.Type.SINGLE) ? defRot : cornRot;
                variants.add(key, variantJson(model, rot));
            }
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName,defaultRef);
    }


    protected void chair(ChairBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();
        ResourceLocation chairKey = Constants.id(baseName);
        ResourceLocation chairRef = Constants.id("block/" + baseName);
        
        registerModel(chairKey, Constants.id("block/chair"),texture);
        
        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            variants.add("facing=" + Direction.NORTH, variantJson(chairRef, 0));
            variants.add("facing=" + Direction.EAST, variantJson(chairRef, 90));
            variants.add("facing=" + Direction.SOUTH, variantJson(chairRef, 180));
            variants.add("facing=" + Direction.WEST , variantJson(chairRef, 270));
        }
        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName,chairRef);
    }


    protected void table(TableBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation defaultKey      = Constants.id(baseName + "_default");
        ResourceLocation leftKey         = Constants.id(baseName + "_left");
        ResourceLocation rightKey        = Constants.id(baseName + "_right");
        ResourceLocation cornerLeftKey   = Constants.id(baseName + "_corner_left");
        ResourceLocation cornerRightKey  = Constants.id(baseName + "_corner_right");
        ResourceLocation middleKey       = Constants.id(baseName + "_middle");
        ResourceLocation centerKey       = Constants.id(baseName + "_center");
        ResourceLocation middleTopKey    = Constants.id(baseName + "_middle_top");
        ResourceLocation middleBottomKey = Constants.id(baseName + "_middle_bottom");

        ResourceLocation defaultRef      = Constants.id("block/" + baseName + "_default");
        ResourceLocation leftRef         = Constants.id("block/" + baseName + "_left");
        ResourceLocation rightRef        = Constants.id("block/" + baseName + "_right");
        ResourceLocation cornerLeftRef   = Constants.id("block/" + baseName + "_corner_left");
        ResourceLocation cornerRightRef  = Constants.id("block/" + baseName + "_corner_right");
        ResourceLocation middleRef       = Constants.id("block/" + baseName + "_middle");
        ResourceLocation centerRef       = Constants.id("block/" + baseName + "_center");
        ResourceLocation middleTopRef    = Constants.id("block/" + baseName + "_middle_top");
        ResourceLocation middleBottomRef = Constants.id("block/" + baseName + "_middle_bottom");

        registerModel(defaultKey,      Constants.id("block/table"),       texture);
        registerModel(leftKey,         Constants.id("block/table_left"),          texture);
        registerModel(rightKey,        Constants.id("block/table_right"),         texture);
        registerModel(cornerLeftKey,   Constants.id("block/table_corner_left"),   texture);
        registerModel(cornerRightKey,  Constants.id("block/table_corner_right"),  texture);
        registerModel(middleKey,       Constants.id("block/table_middle"),        texture);
        registerModel(centerKey,       Constants.id("block/table_center"),        texture);
        registerModel(middleTopKey,    Constants.id("block/table_middle_top"),    texture);
        registerModel(middleBottomKey, Constants.id("block/table_middle_bottom"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            for (TableBlock.Type type : TableBlock.Type.values()) {
                String key = "facing=" + dir.getSerializedName() + ",type=" + type.getSerializedName();

                ResourceLocation model = switch (type) {
                    case DEFAULT        -> defaultRef;
                    case LEFT           -> leftRef;
                    case RIGHT          -> rightRef;
                    case CORNER_LEFT    -> cornerLeftRef;
                    case CORNER_RIGHT   -> cornerRightRef;
                    case MIDDLE         -> middleRef;
                    case CENTER         -> centerRef;
                    case MIDDLE_TOP     -> middleTopRef;
                    case MIDDLE_BOTTOM  -> middleBottomRef;
                };

                variants.add(key, variantJson(model, rot));
            }
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, defaultRef);
    }


    protected void desk(DeskBlock block, ResourceLocation texture)  {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation deskSingleKey = Constants.id(baseName + "_single");
        ResourceLocation deskRightKey = Constants.id(baseName + "_right");
        ResourceLocation deskLeftKey = Constants.id(baseName + "_left");
        ResourceLocation deskMiddleKey = Constants.id(baseName + "_middle");

        ResourceLocation deskSingleRef = Constants.id("block/" + baseName + "_single");
        ResourceLocation deskRightRef = Constants.id("block/" + baseName + "_right");
        ResourceLocation deskLeftRef = Constants.id("block/" + baseName + "_left");
        ResourceLocation deskMiddleRef = Constants.id("block/" + baseName + "_middle");

        registerModel(deskSingleKey, Constants.id("block/desk_single"), texture);
        registerModel(deskRightKey, Constants.id("block/desk_right"), texture);
        registerModel(deskLeftKey, Constants.id("block/desk_left"), texture);
        registerModel(deskMiddleKey, Constants.id("block/desk_middle"), texture);



        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            for(DeskBlock.Type type : DeskBlock.Type.values()) {
                String key = "facing=" + dir.getSerializedName() + ",type=" + type.getSerializedName();

                ResourceLocation model = switch (type) {
                    case SINGLE ->  deskSingleRef;
                    case RIGHT ->  deskRightRef;
                    case LEFT ->  deskLeftRef;
                    case MIDDLE ->   deskMiddleRef;


                };
                variants.add(key, variantJson(model, rot));


            }
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, deskSingleRef);

    }


    protected void deskCabinet(DeskCabinetBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation singleKey = Constants.id(baseName + "_single_closed");
        ResourceLocation rightKey = Constants.id(baseName + "_right_closed");
        ResourceLocation leftKey = Constants.id(baseName + "_left_closed");
        ResourceLocation middleKey = Constants.id(baseName + "_middle_closed");


        ResourceLocation singleRef = Constants.id("block/" + baseName + "_single_closed");
        ResourceLocation rightRef = Constants.id("block/" + baseName + "_right_closed");
        ResourceLocation leftRef = Constants.id("block/" + baseName + "_left_closed");
        ResourceLocation middleRef = Constants.id("block/" + baseName + "_middle_closed");

        registerModel(singleKey, Constants.id("block/desk_cabinet_single_closed"), texture);
        registerModel(rightKey, Constants.id("block/desk_cabinet_right_closed"), texture);
        registerModel(leftKey, Constants.id("block/desk_cabinet_left_closed"), texture);
        registerModel(middleKey, Constants.id("block/desk_cabinet_middle_closed"), texture);

        JsonObject variants = new JsonObject();

        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            for (DeskBlock.Type type : DeskBlock.Type.values()) {
                String key = "facing=" + dir.getSerializedName() + ",type=" + type.getSerializedName();
                ResourceLocation closedModel = switch (type) {
                    case SINGLE -> singleRef;
                    case RIGHT -> rightRef;
                    case LEFT -> leftRef;
                    case MIDDLE -> middleRef;
                };


                variants.add(key, variantJson(closedModel, rot));
            }
        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, singleRef);
    }

    protected void coffeeTable(CoffeeTableBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation defaultKey      = Constants.id(baseName + "_default");
        ResourceLocation leftKey         = Constants.id(baseName + "_left");
        ResourceLocation rightKey        = Constants.id(baseName + "_right");
        ResourceLocation cornerLeftKey   = Constants.id(baseName + "_corner_left");
        ResourceLocation cornerRightKey  = Constants.id(baseName + "_corner_right");
        ResourceLocation middleKey       = Constants.id(baseName + "_middle");
        ResourceLocation centerKey       = Constants.id(baseName + "_center");
        ResourceLocation middleTopKey    = Constants.id(baseName + "_middle_top");
        ResourceLocation middleBottomKey = Constants.id(baseName + "_middle_bottom");

        ResourceLocation defaultRef      = Constants.id("block/" + baseName + "_default");
        ResourceLocation leftRef         = Constants.id("block/" + baseName + "_left");
        ResourceLocation rightRef        = Constants.id("block/" + baseName + "_right");
        ResourceLocation cornerLeftRef   = Constants.id("block/" + baseName + "_corner_left");
        ResourceLocation cornerRightRef  = Constants.id("block/" + baseName + "_corner_right");
        ResourceLocation middleRef       = Constants.id("block/" + baseName + "_middle");
        ResourceLocation centerRef       = Constants.id("block/" + baseName + "_center");
        ResourceLocation middleTopRef    = Constants.id("block/" + baseName + "_middle_top");
        ResourceLocation middleBottomRef = Constants.id("block/" + baseName + "_middle_bottom");

        registerModel(defaultKey,      Constants.id("block/coffee_table_default"),       texture);
        registerModel(leftKey,         Constants.id("block/coffee_table_left"),          texture);
        registerModel(rightKey,        Constants.id("block/coffee_table_right"),         texture);
        registerModel(cornerLeftKey,   Constants.id("block/coffee_table_corner_left"),   texture);
        registerModel(cornerRightKey,  Constants.id("block/coffee_table_corner_right"),  texture);
        registerModel(middleKey,       Constants.id("block/coffee_table_middle"),        texture);
        registerModel(centerKey,       Constants.id("block/coffee_table_center"),        texture);
        registerModel(middleTopKey,    Constants.id("block/coffee_table_middle_top"),    texture);
        registerModel(middleBottomKey, Constants.id("block/coffee_table_middle_bottom"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            int rot = defaultRotation(dir);
            for (CoffeeTableBlock.Type type : CoffeeTableBlock.Type.values()) {
                String key = "facing=" + dir.getSerializedName() + ",type=" + type.getSerializedName();

                ResourceLocation model = switch (type) {
                    case DEFAULT        -> defaultRef;
                    case LEFT           -> leftRef;
                    case RIGHT          -> rightRef;
                    case CORNER_LEFT    -> cornerLeftRef;
                    case CORNER_RIGHT   -> cornerRightRef;
                    case MIDDLE         -> middleRef;
                    case CENTER         -> centerRef;
                    case MIDDLE_TOP     -> middleTopRef;
                    case MIDDLE_BOTTOM  -> middleBottomRef;
                };

                variants.add(key, variantJson(model, rot));
            }
        }


        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, defaultRef);

    }



    protected void bedsideCabinet(BedsideCabinetBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation closedKey = Constants.id(baseName);
        ResourceLocation closedRef = Constants.id("block/" + baseName);

        registerModel(closedKey, Constants.id("block/bedside_cabinet"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            variants.add("facing=" + Direction.NORTH, variantJson(closedRef, 0));
            variants.add("facing=" + Direction.EAST, variantJson(closedRef, 90));
            variants.add("facing=" + Direction.SOUTH, variantJson(closedRef, 180));
            variants.add("facing=" + Direction.WEST, variantJson(closedRef, 270));

        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, closedRef);

    }

    protected void digitalClock(DigitalClockBlock block, ResourceLocation texture) {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).getPath();

        ResourceLocation closedKey = Constants.id(baseName);
        ResourceLocation closedRef = Constants.id("block/" + baseName);

        registerModel(closedKey, Constants.id("block/digital_clock"), texture);

        JsonObject variants = new JsonObject();
        for (Direction dir : HORIZONTALS) {
            variants.add("facing=" + Direction.NORTH, variantJson(closedRef, 0));
            variants.add("facing=" + Direction.EAST, variantJson(closedRef, 90));
            variants.add("facing=" + Direction.SOUTH, variantJson(closedRef, 180));
            variants.add("facing=" + Direction.WEST, variantJson(closedRef, 270));

        }

        JsonObject root = new JsonObject();
        root.add("variants", variants);
        blockStates.put(BuiltInRegistries.BLOCK.getKey(block), root);
        registerItemBlockModel(baseName, closedRef);

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
        itemModels.put(Constants.id(baseName), model);

    }

    protected void registerItemBlockModel(String blockName, ResourceLocation blockModelRef) {
        JsonObject model = new JsonObject();
        model.addProperty("parent", blockModelRef.toString());
        itemModels.put(Constants.id(blockName), model);
    }

    private static JsonObject variantJson(ResourceLocation model, int rotY) {
        JsonObject obj = new JsonObject();
        obj.addProperty("model", model.toString());
        if (rotY != 0) obj.addProperty("y", rotY);
        return obj;
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