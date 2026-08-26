package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;

import java.util.ArrayList;
import java.util.List;

public class CoffeeTableBlock extends FurnitureHorizontalBlock
{

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);
    private WoodType woodType;

    public CoffeeTableBlock(WoodType type,Properties properties)
    {
        super(properties);
        this.woodType = type;
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(DIRECTION, Direction.NORTH)
                .setValue(TYPE, Type.DEFAULT));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    public WoodType getWoodType() {
        return woodType;
    }

    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        final VoxelShape TABLE_TOP_SHORT = Block.box(0.0, 6.0, 0.0, 16.0, 8.0, 16.0);
        final VoxelShape LEG_SOUTH_EAST_SHORT = Block.box(13.5, 0, 13.5, 15.5, 6, 15.5);
        final VoxelShape LEG_SOUTH_WEST_SHORT = Block.box(0.5, 0, 13.5, 2.5, 6, 15.5);
        final VoxelShape LEG_NORTH_WEST_SHORT = Block.box(0.5, 0, 0.5, 2.5, 6, 2.5);
        final VoxelShape LEG_NORTH_EAST_SHORT = Block.box(13.5, 0, 0.5, 15.5, 6, 2.5);

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states)
        {
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(TABLE_TOP_SHORT);
            switch (type) {



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
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos)
    {
        return this.getCofeeTableState(state, level, pos);
    }

    public BlockState getCofeeTableState(BlockState state, LevelAccessor level, BlockPos pos)
    {
        boolean north = this.isCoffeeTable(level.getBlockState(pos.north()));
        boolean east = this.isCoffeeTable(level.getBlockState(pos.east()));
        boolean south = this.isCoffeeTable(level.getBlockState(pos.south()));
        boolean west = this.isCoffeeTable(level.getBlockState(pos.west()));

        int count = (north ? 1 : 0) + (east ? 1 : 0) + (south ? 1 : 0) + (west ? 1 : 0);

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
            boolean front = pick(facing, north, east, south, west);
            boolean back  = pick(facing.getOpposite(), north, east, south, west);
            boolean left  = pick(facing.getCounterClockWise(), north, east, south, west);
            boolean right = pick(facing.getClockWise(), north, east, south, west);

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

    private boolean isCoffeeTable(BlockState state)
    {
        return state.getBlock() instanceof CoffeeTableBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        super.createBlockStateDefinition(builder);
        builder.add(TYPE);
    }

    public enum Type implements StringRepresentable {
        DEFAULT("default"),
        LEFT("left"),
        RIGHT("right"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right"),
        MIDDLE("middle"),
        MIDDLE_TOP("middle_top"),
        MIDDLE_BOTTOM("middle_bottom"),
        CENTER("center");

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
