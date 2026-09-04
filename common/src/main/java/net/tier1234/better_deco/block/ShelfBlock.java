package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.blockentity.ShelfBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class ShelfBlock extends FurnitureHorizontalBlock implements EntityBlock {

    private final WoodType woodType;
    public static final EnumProperty<Type> TYPE = EnumProperty.create("type", Type.class);
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public ShelfBlock(WoodType type, Properties properties) {
        super(properties);
        this.woodType = type;
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH).setValue(TYPE, Type.SINGLE));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    public WoodType getWoodType() {
        return woodType;
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] TOP = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0,14,0,16,16,10), Direction.NORTH));
        final VoxelShape[] SUPPORT_LEFT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(12,8,0,16,14,6), Direction.NORTH));
        final VoxelShape[] SUPPORT_RIGHT = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(0,8,0,4,14,6), Direction.NORTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();

        for (BlockState state : states) {
            Type type = state.getValue(TYPE);
            List<VoxelShape> shapes = new ArrayList<>();
            switch (type) {
                case SINGLE: shapes.add(TOP[state.getValue(DIRECTION).get2DDataValue()]);
                             shapes.add(SUPPORT_LEFT[state.getValue(DIRECTION).get2DDataValue()]);
                             shapes.add(SUPPORT_RIGHT[state.getValue(DIRECTION).get2DDataValue()]);
                break;
                case LEFT: shapes.add(TOP[state.getValue(DIRECTION).get2DDataValue()]);
                           shapes.add(SUPPORT_RIGHT[state.getValue(DIRECTION).get2DDataValue()]);
                break;
                case RIGHT: shapes.add(TOP[state.getValue(DIRECTION).get2DDataValue()]);
                            shapes.add(SUPPORT_LEFT[state.getValue(DIRECTION).get2DDataValue()]);
                break;
                case MIDDLE: shapes.add(TOP[state.getValue(DIRECTION).get2DDataValue()]);
                break;
            }
            builder.put(state,VoxelShapeHelper.combineAll(shapes));

        }

        return builder.build();
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos,
                         BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof ShelfBlockEntity shelf) {
                shelf.drops();
                level.updateNeighborsAt(pos, this);
            }
            super.onRemove(state, level, pos, newState, isMoving);
        }
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.isCrouching()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof ShelfBlockEntity shelf)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (stack.isEmpty()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (level.isClientSide) {
            return ItemInteractionResult.sidedSuccess(true);
        }

        boolean inserted = shelf.insertItem(player, stack);
        if (inserted) {
            level.playSound(null, pos, SoundEvents.WOOD_HIT, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return ItemInteractionResult.SUCCESS;
        }

        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        if (player.isCrouching()) {
            if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof ShelfBlockEntity shelfBlockEntity) {
                    FrameworkAPI.openMenuWithData(serverPlayer, shelfBlockEntity, shelfBlockEntity.createCustomData());
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof ShelfBlockEntity shelf)) {
            return InteractionResult.PASS;
        }

        if (level.isClientSide) {
            return InteractionResult.SUCCESS;
        }

        ItemStack extracted = shelf.extractItem(player);
        if (!extracted.isEmpty()) {
            level.playSound(null, pos, SoundEvents.WOOD_HIT, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    protected BlockState updateShape(BlockState state, Direction direction, BlockState neighborState, LevelAccessor level, BlockPos pos, BlockPos neighborPos) {
        return this.getShelfState(state, level, pos);
    }

    public BlockState getShelfState(BlockState state, LevelAccessor level, BlockPos pos){

        Direction direction = state.getValue(DIRECTION);
        Direction leftDir = direction.getClockWise();
        Direction rightDir = direction.getCounterClockWise();

        BlockState leftState = level.getBlockState(pos.relative(leftDir));
        BlockState rightState = level.getBlockState(pos.relative(rightDir));

        boolean left = isShelf(leftState) && leftState.getValue(DIRECTION) == direction;
        boolean right = isShelf(rightState) && rightState.getValue(DIRECTION) == direction;

        Type type;
        if (left && right) {
            type = Type.MIDDLE;
        } else if (left) {
            type = Type.RIGHT;
        } else if (right) {
            type = Type.LEFT;
        } else {
            type = Type.SINGLE;
        }


        return state.setValue(TYPE, type);
    }

    public boolean isShelf(BlockState state) {
        return state.getBlock() instanceof ShelfBlock;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, TYPE);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection().getOpposite());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext ctx) {
        return SHAPES.get(state);
    }



    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new ShelfBlockEntity(pos, state);
    }

    public enum Type implements StringRepresentable {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle");

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
            return this.id;
        }
    }
}
