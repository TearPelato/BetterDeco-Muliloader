package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
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
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.block_entity.FurnitureHorizontalEntityBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.block.type.MetalType;
import net.tier1234.better_deco.blockentity.FreezerBlockEntity;
import net.tier1234.better_deco.blockentity.FridgeBlockEntity;
import net.tier1234.better_deco.registries.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FridgeBlock extends FurnitureHorizontalEntityBlock {

    public static final MapCodec<FridgeBlock> CODEC = RecordCodecBuilder.mapCodec(builder->{
        return builder.group(MetalType.CODEC.fieldOf("metal_type").forGetter(block-> {
            return block.type;
        }), propertiesCodec()).apply(builder, FridgeBlock::new);
            });

    public static final DirectionProperty DIRECTION = BlockStateProperties.HORIZONTAL_FACING;
    public static final EnumProperty<FridgeModelType> MODEL_TYPE = EnumProperty.create("model", FridgeModelType.class);
    private MetalType type;
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public FridgeBlock(MetalType type,Properties properties) {
        super(properties);
        this.type = type;
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DIRECTION, Direction.NORTH)
                .setValue(MODEL_TYPE, FridgeModelType.FRIDGE));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());

    }

    public MetalType getType() {
        return type;
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] FRIDGE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0,0,0,16,23,16), Direction.SOUTH));
        final VoxelShape[] FREEZER = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0,7,0,16,16,16), Direction.SOUTH));
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            FridgeModelType type = state.getValue(MODEL_TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            switch (type) {
                case FRIDGE: shapes.add(FRIDGE[direction.get2DDataValue()]);
                     break;
                case FREEZER: shapes.add(FREEZER[direction.get2DDataValue()]);
                      break;
            }
            builder.put(state,VoxelShapeHelper.combineAll(shapes));
        }

        return builder.build();
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
                FrameworkAPI.openMenuWithData((ServerPlayer) player, freezerBlockEntity, freezerBlockEntity.createCustomData());
            }
        }

        return InteractionResult.CONSUME;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.is(newState.getBlock())) return;

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (blockEntity instanceof Container) {
            Containers.dropContents(level, pos, (Container)blockEntity);
            level.updateNeighbourForOutputSignal(pos, this);
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, MODEL_TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockPos = context.getClickedPos();
        Level level = context.getLevel();
        if (level.getBlockState(blockPos.above()).canBeReplaced(context)) {
            return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection().getOpposite());
        }
        return null;
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
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
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

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (state.getValue(MODEL_TYPE) == FridgeModelType.FRIDGE) {
            return SHAPES.get(state);
        } else {
            return SHAPES.get(state);
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if(level.isClientSide()) {
            return null;
        }
        if(state.getValue(MODEL_TYPE) == FridgeModelType.FRIDGE) {
            return null;
        }
        return createTickerHelper(blockEntityType, ModBlockEntities.FREEZER.get(),
                (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
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
}