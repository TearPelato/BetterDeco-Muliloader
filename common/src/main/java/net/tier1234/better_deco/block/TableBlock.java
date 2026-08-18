package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureWaterloggedBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;

import java.util.ArrayList;
import java.util.List;

public class TableBlock extends FurnitureHorizontalBlock
{
     public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public TableBlock(Properties properties)
    {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(TYPE, Type.DEFAULT).setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape TOP = Block.box(0, 14, 0, 16, 16, 16);
        final VoxelShape[] LEG_SOUTH_EAST_TALL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 0, 13.5, 15.5, 14, 15.5), Direction.SOUTH));
        final VoxelShape[] LEG_SOUTH_WEST_TALL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0, 13.5, 2.5, 14, 15.5), Direction.SOUTH));
        final VoxelShape[] LEG_NORTH_WEST_TALL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0.5, 0, 0.5, 2.5, 14, 2.5), Direction.SOUTH));
        final VoxelShape[] LEG_NORTH_EAST_TALL = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(13.5, 0, 0.5, 15.5, 14, 2.5), Direction.SOUTH));


        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();


        for(BlockState state : states) {
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(TOP);

            switch (type){
                case DEFAULT:
                    shapes.add(LEG_SOUTH_EAST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    shapes.add(LEG_NORTH_EAST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    shapes.add(LEG_SOUTH_WEST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    shapes.add(LEG_NORTH_WEST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    break;
                case LEFT:
                    shapes.add(LEG_SOUTH_EAST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    break;
                case RIGHT:
                    shapes.add(LEG_SOUTH_EAST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    break;
                case CORNER_LEFT:
                    shapes.add(LEG_SOUTH_EAST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    break;
                case CORNER_RIGHT:
                    shapes.add(LEG_SOUTH_EAST_TALL[state.getValue(DIRECTION).get2DDataValue()]);
                    break;
                case MIDDLE:
                    shapes.add(TOP);
                    break;
                case CENTER:
                    shapes.add(TOP);
                    break;
                case MIDDLE_TOP:
                    shapes.add(TOP);
                    break;
                case MIDDLE_BOTTOM:
                    shapes.add(TOP);
                    break;



            }
            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }

        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState newState, LevelAccessor level, BlockPos pos, BlockPos newPos)
    {
        return this.getTableState(state, level, pos);
    }

    public BlockState getTableState(BlockState state, LevelAccessor level, BlockPos pos)
    {
        boolean n = this.isTable(level.getBlockState(pos.north()));
        boolean e = this.isTable(level.getBlockState(pos.east()));
        boolean s = this.isTable(level.getBlockState(pos.south()));
        boolean w = this.isTable(level.getBlockState(pos.west()));

        int count = (n ? 1 : 0) + (e ? 1 : 0) + (s ? 1 : 0) + (w ? 1 : 0);

        if (count == 0)
        {
            return state.setValue(TYPE, Type.DEFAULT);
        }
        if (count == 4)
        {
            return state.setValue(TYPE, Type.CENTER);
        }

        for (Direction facing : Direction.Plane.HORIZONTAL)
        {
            boolean front = pick(facing, n, e, s, w);
            boolean back  = pick(facing.getOpposite(), n, e, s, w);
            boolean left  = pick(facing.getCounterClockWise(), n, e, s, w);
            boolean right = pick(facing.getClockWise(), n, e, s, w);

            Type type = resolveType(front, back, left, right);
            if (type != null)
            {
                return state.setValue(TYPE, type).setValue(DIRECTION, facing);
            }
        }

        return state.setValue(TYPE, Type.DEFAULT);
    }

    private static boolean pick(Direction direction, boolean north, boolean east, boolean south, boolean west)
    {
        return switch (direction)
        {
            case NORTH -> north;
            case EAST  -> east;
            case SOUTH -> south;
            case WEST  -> west;
            default    -> false;
        };
    }

    private static Type resolveType(boolean front, boolean back, boolean left, boolean right)
    {
        if (!front && !back && right && !left)  return Type.LEFT;
        if (!front && !back && left && !right)  return Type.RIGHT;
        if (!front && !back && left && right)   return Type.MIDDLE;
        if (!front && back && right && !left)   return Type.CORNER_LEFT;
        if (!front && back && left && !right)   return Type.CORNER_RIGHT;
        if (!front && back && left && right)    return Type.MIDDLE_TOP;
        if (front && !back && left && right)    return Type.MIDDLE_BOTTOM;
        return null;
    }

    private boolean isTable(BlockState state)
    {
        return state.getBlock() instanceof TableBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        return this.getTableState(super.getStateForPlacement(context), context.getLevel(), context.getClickedPos());
    }


    public enum Type implements StringRepresentable {
        DEFAULT("default"),
        LEFT("left"),
        RIGHT("right"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right"),
        MIDDLE("middle"),
        CENTER("center"),
        MIDDLE_TOP("middle_top"),
        MIDDLE_BOTTOM("middle_bottom");



        private final String id;

        Type(String id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return this.getSerializedName();
        }

        @Override
        public String getSerializedName() {
            return id;
        }
    }

}