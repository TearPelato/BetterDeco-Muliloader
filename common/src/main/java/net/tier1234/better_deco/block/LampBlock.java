package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LampBlock extends FurnitureHorizontalBlock {

    public static final BooleanProperty POWERED = BlockStateProperties.POWERED;
    private DyeColor color;
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);

    public LampBlock(DyeColor color,Properties properties) {
        super(properties);
        this.color = color;
        this.registerDefaultState(this.getStateDefinition().any().setValue(POWERED, Boolean.FALSE).setValue(TYPE, Type.SINGLE));
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        Map<Type, VoxelShape[]> shapesByType = new EnumMap<>(Type.class);

        shapesByType.put(Type.SINGLE, VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(VoxelShapeHelper.combineAll(List.of(Block.box(5, 0, 5, 11, 1, 11), Block.box(7, 1, 7, 9, 12, 9), Block.box(3, 9, 3, 13, 17, 13))), Direction.NORTH)));
        shapesByType.put(Type.TOP, VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(VoxelShapeHelper.combineAll(List.of(Block.box(7, 1, 7, 9, 12, 9), Block.box(3, 9, 3, 13, 16, 13))), Direction.NORTH)));
        shapesByType.put(Type.MIDDLE, VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(7, 0, 7, 9, 16, 9), Direction.NORTH)));
        shapesByType.put(Type.BOTTOM, VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(VoxelShapeHelper.combineAll(List.of(Block.box(5, 0, 5, 11, 1, 11), Block.box(7, 1, 7, 9, 12, 9))), Direction.NORTH)));
        shapesByType.put(Type.WALL, VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(VoxelShapeHelper.combineAll(List.of(Block.box(5, 0, 15, 11, 6, 16), Block.box(7, 2, 9, 9, 4, 15), Block.box(7, 2, 7, 9, 12, 9), Block.box(3, 9, 3, 13, 16, 13))), Direction.NORTH)));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            Type type = state.getValue(TYPE);
            VoxelShape[] shapesForType = shapesByType.get(type);
            builder.put(state, shapesForType[direction.get2DDataValue()]);
        }
        return builder.build();
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!level.isClientSide) {
            boolean powered = !state.getValue(POWERED);

            if (state.getValue(TYPE) == Type.SINGLE || state.getValue(TYPE) == Type.WALL) {
                level.setBlock(pos, state.setValue(POWERED, powered), Block.UPDATE_ALL);
            } else {
                while (isLamp(level.getBlockState(pos.below()))) {
                    pos = pos.below();
                }
                BlockState s = level.getBlockState(pos);
                while (isLamp(s)) {
                    level.setBlock(pos, s.setValue(POWERED, powered), Block.UPDATE_ALL);
                    pos = pos.above();
                    s = level.getBlockState(pos);
                }
            }
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(POWERED, TYPE);
    }

    public boolean getType(BlockState state) {
        return state.getValue(TYPE) == Type.SINGLE || state.getValue(TYPE) == Type.MIDDLE || state.getValue(TYPE) == Type.TOP || state.getValue(TYPE) == Type.BOTTOM || state.getValue(TYPE) == Type.WALL;
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        Direction face = context.getClickedFace();

        if (face.getAxis().isHorizontal()) {
            BlockPos supportPos = pos.relative(face.getOpposite());
            if (level.getBlockState(supportPos).isFaceSturdy(level, supportPos, face)) {
                return defaultBlockState().setValue(DIRECTION, face).setValue(TYPE, Type.WALL);
            }
        }

        Direction dir = context.getHorizontalDirection().getOpposite();
        return defaultBlockState().setValue(DIRECTION, dir).setValue(TYPE, computeType(level, pos));
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState,
                                     LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        if (state.getValue(TYPE) == Type.WALL) {
            Direction facing = state.getValue(DIRECTION);
            if (direction == facing.getOpposite() && !neighborState.isFaceSturdy(level, neighborPos, facing)) {
                return Blocks.AIR.defaultBlockState();
            }
            return state;
        }

        if (direction.getAxis() == Direction.Axis.Y) {
            return state.setValue(TYPE, computeType(level, pos));
        }

        return super.updateShape(state, direction, neighborState, level, pos, neighborPos);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        if (state.getValue(TYPE) == Type.WALL) {
            Direction facing = state.getValue(DIRECTION);
            BlockPos supportPos = pos.relative(facing.getOpposite());
            return level.getBlockState(supportPos).isFaceSturdy(level, supportPos, facing);
        }
        return super.canSurvive(state, level, pos);
    }

    private Type computeType(LevelAccessor level, BlockPos pos) {
        boolean below = isLamp(level.getBlockState(pos.below()));
        boolean above = isLamp(level.getBlockState(pos.above()));
        if (below && above) return Type.MIDDLE;
        if (below) return Type.TOP;
        if (above) return Type.BOTTOM;
        return Type.SINGLE;
    }


    private boolean isLamp(BlockState state) {
        return state.getBlock() instanceof LampBlock && state.getValue(TYPE) != Type.WALL;
    }

    public static int getLight(BlockState state) {
        return state.getValue(POWERED) ? 15 : 0;
    }

    public enum Type implements StringRepresentable {
        SINGLE("single"),
        TOP("top"),
        MIDDLE("middle"),
        BOTTOM("bottom"),
        WALL("wall");


        private String name;
        Type(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.getSerializedName();
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
