package net.tier1234.better_deco.block.custom;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.block_entity.FurnitureHorizontalEntityBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.block.entity.custom.MicrowaveBlockEntity;
import net.tier1234.better_deco.registries.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MicrowaveBlock extends FurnitureHorizontalEntityBlock {
    public static final MapCodec<MicrowaveBlock> CODEC = simpleCodec(MicrowaveBlock::new);
    public static final BooleanProperty OPEN = BooleanProperty.create("open");

    public MicrowaveBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(DIRECTION, Direction.NORTH)
                .setValue(OPEN, false));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
     final VoxelShape[] CLOSED = VoxelShapeHelper.getRotatedShapes(
                VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 3.0, 15.0, 8.0, 13.0), Direction.SOUTH));

      final VoxelShape[] BASE_OPEN = VoxelShapeHelper.getRotatedShapes(
                VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 3.0, 15.0, 8.0, 13.0), Direction.SOUTH));

       final VoxelShape[] DOOR_OPEN = VoxelShapeHelper.getRotatedShapes(
                VoxelShapeHelper.rotate(Block.box(1.0, 0.0, 13.0, 15.0, 8.0, 16.0), Direction.SOUTH));

        Map<BlockState, VoxelShape> map = new HashMap<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            int idx = direction.get2DDataValue();

            if (state.getValue(OPEN)) {
                map.put(state, VoxelShapeHelper.combineAll(List.of(BASE_OPEN[idx], DOOR_OPEN[idx])));
            } else {
                map.put(state, CLOSED[idx]);
            }
        }
        return map;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection().getOpposite());
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new MicrowaveBlockEntity(blockPos, blockState);
    }

    @Override
    public void onRemove(BlockState pState, Level pLevel, BlockPos pPos, BlockState pNewState, boolean pIsMoving) {
        if (pState.getBlock() != pNewState.getBlock()) {
            BlockEntity blockEntity = pLevel.getBlockEntity(pPos);
            if (blockEntity instanceof MicrowaveBlockEntity microwaveBlockEntity) {
                microwaveBlockEntity.drops();
            }
        }
        super.onRemove(pState, pLevel, pPos, pNewState, pIsMoving);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack pStack, BlockState pState, Level pLevel, BlockPos pPos,
                                              Player pPlayer, InteractionHand pHand, BlockHitResult pHitResult) {
        if (!pLevel.isClientSide()) {
            BlockEntity entity = pLevel.getBlockEntity(pPos);
            if (entity instanceof MicrowaveBlockEntity microwaveBlockEntity) {
                FrameworkAPI.openMenuWithData((ServerPlayer) pPlayer, microwaveBlockEntity, microwaveBlockEntity.getData());
            } else {
                throw new IllegalStateException("Our Container provider is missing!");
            }
        }
        return ItemInteractionResult.sidedSuccess(pLevel.isClientSide());
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> blockEntityType) {
        if (level.isClientSide()) {
            return null;
        }
        return createTicker(blockEntityType, ModBlockEntities.MICROWAVE.get(),
                (level1, blockPos, blockState, blockEntity) -> blockEntity.tick(level1, blockPos, blockState));
    }
}