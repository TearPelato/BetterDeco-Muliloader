package net.tier1234.better_deco.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.block.entity.custom.FreezerBlockEntity;
import net.tier1234.better_deco.block.entity.custom.FridgeBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Locale;
import java.util.stream.Stream;

public class NewFridgeBlock extends BaseEntityBlock {
    public static final MapCodec<NewFridgeBlock> CODEC = simpleCodec(NewFridgeBlock::new);
    public static final DirectionProperty DURECTION = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<FridgeModelType> MODEL_TYPE = EnumProperty.create("model", FridgeModelType.class);


    public NewFridgeBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DURECTION, Direction.NORTH)
                .setValue(MODEL_TYPE, FridgeModelType.FRIDGE));

    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DURECTION, MODEL_TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        if (level.getBlockState(blockPos.above()).canBeReplaced(context)) {
            return this.defaultBlockState().setValue(DURECTION, context.getHorizontalDirection().getOpposite());
        }
        return null;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (state.getValue(MODEL_TYPE) == FridgeModelType.FRIDGE) {
            if (blockEntity instanceof FridgeBlockEntity fridgeBlockEntity) {
                player.openMenu(fridgeBlockEntity);
                return InteractionResult.CONSUME;
            }
        } else if (state.getValue(MODEL_TYPE) == FridgeModelType.FREEZER ) {
            if (blockEntity instanceof FreezerBlockEntity freezerBlockEntity) {
                ((ServerPlayer) player).openMenu(
                        new SimpleMenuProvider(freezerBlockEntity, Component.translatable("gui.better_deco.freezer")));
            }
        }

        return InteractionResult.CONSUME;
    }

    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Container) {
            Containers.dropContents(level, pos, (Container)blockEntity);
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    private static Direction getNeighbourDirection(FridgeModelType modelType) {
        return modelType == FridgeModelType.FRIDGE ? Direction.UP : Direction.DOWN;
    }

    @Override
    public BlockState playerWillDestroy(Level level, BlockPos pos, BlockState state, Player player) {
        if (!level.isClientSide) {
            FridgeModelType modelType = state.getValue(MODEL_TYPE);
            BlockPos otherPos = pos.relative(getNeighbourDirection(modelType));
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.getBlock() == this && otherState.getValue(MODEL_TYPE) != modelType) {
                BlockPos bottomPos = modelType == FridgeModelType.FRIDGE ? pos : otherPos;
                BlockPos topPos = modelType == FridgeModelType.FREEZER ? pos : otherPos;

                level.setBlock(bottomPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, 2001, bottomPos, Block.getId(state));

                level.setBlock(topPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL);
                level.levelEvent(player, 2001, topPos, Block.getId(otherState));

                if (!player.isCreative()) {
                    dropResources(state, level, pos, null, player, player.getMainHandItem());
                    dropResources(otherState, level, otherPos, null, player, player.getMainHandItem());
                }
            }
        }

        return super.playerWillDestroy(level, pos, state, player);
    }


    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (!level.isClientSide) {
            BlockPos above = pos.above();
            if (level.getBlockState(above).canBeReplaced()) {
                level.setBlock(above, state.setValue(MODEL_TYPE, FridgeModelType.FREEZER), Block.UPDATE_ALL);
            }
        }
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        if (state.getValue(MODEL_TYPE) == FridgeModelType.FREEZER ) {
            return new FreezerBlockEntity(pos, state);
        } return new FridgeBlockEntity(pos, state);
    }


    public enum FridgeModelType implements StringRepresentable {
        FRIDGE, FREEZER;

        @Override
        public String getSerializedName() {
            return name().toLowerCase(Locale.ROOT);
        }

        @Override
        public String toString() {
            return getSerializedName();
        }
    }


    private static final VoxelShape FRIDGE = Stream.of(
            // Fridge (Corpo principale. Corretto Y=32 -> Y=16 per il blocco inferiore)
            Block.box(0, 0, 4, 16, 23, 12),  // Corpo: Z da 4 a 12 (Base Y 0-16, Z 4-12)
            Block.box(0, 0, 0, 16, 23, 4),   // Corpo: Z da 0 a 4
            Block.box(0, 0, 12, 16, 23, 16), // Corpo: Z da 12 a 16
            // Base
            Block.box(0, 0, 2, 16, 2, 16)

    ).reduce((v1, v2) -> Shapes.or(v1, v2)).get();

    private static final VoxelShape FREEZER = Stream.of(
            // Freezer (Corpo principale. Y va da 7 a 16)
            Block.box(0, 7, 4, 16, 16, 12),
            Block.box(0, 7, 0, 16, 16, 4),
            Block.box(0, 7, 12, 16, 16, 16)


    ).reduce((v1, v2) -> Shapes.or(v1, v2)).get();


    private static final VoxelShape[] SHAPES = new VoxelShape[8];

    static {
        SHAPES[0] = VoxelShapeHelper.rotateShape(FREEZER, Direction.SOUTH); //South
        SHAPES[1] = VoxelShapeHelper.rotateShape(FREEZER, Direction.WEST); //West
        SHAPES[2] = VoxelShapeHelper.rotateShape(FREEZER, Direction.NORTH); //North
        SHAPES[3] = VoxelShapeHelper.rotateShape(FREEZER, Direction.EAST); //East
        SHAPES[4] = VoxelShapeHelper.rotateShape(FRIDGE, Direction.SOUTH); //South Lower
        SHAPES[5] = VoxelShapeHelper.rotateShape(FRIDGE, Direction.WEST); //West Lower
        SHAPES[6] = VoxelShapeHelper.rotateShape(FRIDGE, Direction.NORTH); //North Lower
        SHAPES[7] = VoxelShapeHelper.rotateShape(FRIDGE, Direction.EAST); //East Lower
    }


    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(DURECTION);
        int d2d = direction.get2DDataValue();

        if (state.getValue(MODEL_TYPE) == FridgeModelType.FRIDGE) {
            return SHAPES[4 + d2d];
        } else {
            return SHAPES[d2d];
        }
    }
}