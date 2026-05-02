package net.tier1234.better_deco.block.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;

import java.util.List;

public class ToasterBlock extends FurnitureHorizontalBlock {

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ToasterBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        this.SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }


    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape BODY = Block.box(3, 0, 3, 13, 7, 11);
        final VoxelShape LEVER_LEFT = Block.box(5, 0, 4, 6, 1, 10);
        final VoxelShape LEVER_RIGHT = Block.box(10, 0, 4, 11, 1, 10);
        final VoxelShape SIDE_LEFT = Block.box(4, 1, 3.5, 5, 7, 10.5);
        final VoxelShape SIDE_RIGHT = Block.box(11, 1, 3.5, 12, 7, 10.5);

        final VoxelShape BASE_SHAPE = VoxelShapeHelper.combineAll(List.of(
                BODY, LEVER_LEFT, LEVER_RIGHT, SIDE_LEFT, SIDE_RIGHT
        ));

        final VoxelShape[] ROTATED = VoxelShapeHelper.getRotatedShapes(BASE_SHAPE);

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction dir = state.getValue(DIRECTION);
            builder.put(state, ROTATED[dir.get2DDataValue()]);
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter level, BlockPos pos) {
        return SHAPES.get(state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection().getOpposite());
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction dir, BlockState neighbor, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return state;
    }
}