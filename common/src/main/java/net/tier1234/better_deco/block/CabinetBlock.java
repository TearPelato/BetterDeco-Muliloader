package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoorHingeSide;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.block_entity.FurnitureHorizontalEntityBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.blockentity.CabinetBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class CabinetBlock extends FurnitureHorizontalEntityBlock {
    public static final BooleanProperty OPEN = BooleanProperty.create("open");
    public static final EnumProperty<DoorHingeSide> HANDLE = BlockStateProperties.DOOR_HINGE;

    public static final MapCodec<CabinetBlock> CODEC = simpleCodec(CabinetBlock::new);
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public CabinetBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(OPEN, false).setValue(HANDLE, DoorHingeSide.LEFT));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection());
        BlockPos pos = context.getClickedPos();
        Vec3 clickVec = context.getClickLocation().subtract(Vec3.atLowerCornerOf(pos));
        Direction forward = context.getHorizontalDirection();
        Direction right = forward.getClockWise();
        double side = right.getAxis().choose(clickVec.x, 0, clickVec.z);
        side = Math.abs(Math.min(right.getAxisDirection().getStep(), 0) + side);
        return state.setValue(HANDLE, side > 0.5 ? DoorHingeSide.RIGHT : DoorHingeSide.LEFT);
    }

    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape[] BASE_CLOSED = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0, 0, 0, 16, 16, 13), Direction.SOUTH));
        final VoxelShape[] BASE_OPEN = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0, 0, 0, 16, 16, 11), Direction.SOUTH));
        final VoxelShape[] DOOR_OPEN_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0, 0, 11, 2, 16, 27), Direction.SOUTH));
        final VoxelShape[] DOOR_OPEN_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(14, 0, 11, 16, 16, 27), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            if(state.getValue(OPEN))
            {
                shapes.add(BASE_OPEN[direction.get2DDataValue()]);
                if(state.getValue(HANDLE) == DoorHingeSide.LEFT){
                    shapes.add(DOOR_OPEN_LEFT[direction.get2DDataValue()]);
                }else {

                    shapes.add(DOOR_OPEN_RIGHT[direction.get2DDataValue()]);
                }

            }
            else
            {
                shapes.add(BASE_CLOSED[direction.get2DDataValue()]);
            }
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        } else {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof CabinetBlockEntity cabinetBlockEntity) {
                player.openMenu(cabinetBlockEntity);
                return InteractionResult.CONSUME;
            }
            return InteractionResult.PASS;
        }
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(OPEN);
        builder.add(HANDLE);
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state)
    {
        return new CabinetBlockEntity(pos, state);
    }
}