package net.tier1234.better_deco.block.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import net.tearpelato.deco_lib.api.fluid.util.FluidInteractionUtil;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.block.entity.custom.BathBlockEntity;
import org.jetbrains.annotations.Nullable;

public class BathBlock extends FurnitureHorizontalBlock implements SimpleWaterloggedBlock, EntityBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_WATER = ModBlockStateProperties.HAS_WATER;
    public static final EnumProperty<BathPart> PART = EnumProperty.create("part", BathPart.class);

    private final ImmutableMap<BlockState, VoxelShape> shapesByState;

    public BathBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DIRECTION, Direction.SOUTH)
                .setValue(PART, BathPart.MAIN)
                .setValue(HAS_WATER, false));
        this.shapesByState = generateShapes(this.getStateDefinition().getPossibleStates());
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        for (BlockState s : states) {
            Direction dir = s.getValue(DIRECTION);
            VoxelShape shape = createShape(0, 0, 0, 16, 16, 16, dir);
            builder.put(s, shape);
        }
        return builder.build();
    }

    private VoxelShape createShape(double x1, double y1, double z1, double x2, double y2, double z2, Direction dir) {
        VoxelShape[] rotated = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(x1, y1, z1, x2, y2, z2), Direction.SOUTH));
        return rotated[dir.get2DDataValue()];
    }

     @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) return null;

        Direction dir = state.getValue(DIRECTION);
        Level level = context.getLevel();
        BlockPos extPos = context.getClickedPos().relative(dir);

        if (!level.getWorldBorder().isWithinBounds(extPos)) return null;
        if (!level.getBlockState(extPos).canBeReplaced(context)) return null;

        return state.setValue(PART, BathPart.MAIN);
    }

      @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (level.isClientSide) return;

        Direction dir = state.getValue(DIRECTION);
        BlockPos extPos = pos.relative(dir);
        boolean extWaterlogged = level.getFluidState(extPos).getType() == Fluids.WATER;

        level.setBlock(extPos, state
                .setValue(PART, BathPart.EXTENSION)
                .setValue(WATERLOGGED, extWaterlogged), Block.UPDATE_ALL);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && !state.is(newState.getBlock())) {
            BathPart part = state.getValue(PART);
            Direction facing = state.getValue(DIRECTION);
            BlockPos otherPos = part == BathPart.MAIN ? pos.relative(facing) : pos.relative(facing.getOpposite());
            BlockState otherState = level.getBlockState(otherPos);

            if (otherState.is(this) && otherState.getValue(PART) != part) {
                level.setBlock(otherPos, Blocks.AIR.defaultBlockState(), Block.UPDATE_ALL | Block.UPDATE_SUPPRESS_DROPS);
                level.levelEvent(2001, otherPos, Block.getId(otherState));
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        return InteractionResult.PASS;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide) return ItemInteractionResult.SUCCESS;

        BlockPos bePos = mainPos(state, pos);
        BlockEntity be = world.getBlockEntity(bePos);
        if (!(be instanceof BathBlockEntity sink)) return ItemInteractionResult.FAIL;

        if (stack.isEmpty()) return fillFromNearbyFluid(sink, world, bePos);
        Item item = stack.getItem();
        if (item == Items.BUCKET) return handleBucket(sink, player, hand, stack);
        return fillFromItemStack(sink, player, hand, stack);
    }


    private BlockPos mainPos(BlockState state, BlockPos pos) {
        if (state.getValue(PART) == BathPart.MAIN) return pos;
        Direction facing = state.getValue(DIRECTION);
        return pos.relative(facing.getOpposite());
    }

    private ItemInteractionResult fillFromNearbyFluid(BathBlockEntity sink, Level world, BlockPos pos) {
        FluidState fs = world.getFluidState(pos.below(2));
        if (!fs.isSource() || fs.isEmpty()) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        Fluid fluid = fs.getType();
        if (fluid != Fluids.WATER) return ItemInteractionResult.FAIL;
        return sink.addFluid(fluid) ? ItemInteractionResult.SUCCESS : ItemInteractionResult.FAIL;
    }

    private ItemInteractionResult fillFromItemStack(BathBlockEntity sink, Player player, InteractionHand hand, ItemStack stack) {
        Fluid fluid = FluidInteractionUtil.getFluidFromItemStack(stack);
        if (fluid == Fluids.EMPTY || stack.getItem() == Items.BUCKET) return ItemInteractionResult.FAIL;
        if (fluid != Fluids.WATER) return ItemInteractionResult.FAIL;
        boolean success = sink.addFluid(fluid);
        if (success && !player.isCreative()) player.setItemInHand(hand, Items.BUCKET.getDefaultInstance());
        return success ? ItemInteractionResult.SUCCESS : ItemInteractionResult.FAIL;
    }

    private ItemInteractionResult handleBucket(BathBlockEntity sink, Player player, InteractionHand hand, ItemStack stack) {
        if (sink.isEmpty() || sink.getAmount() < FluidContainerBlockEntity.BUCKET_VOLUME) return ItemInteractionResult.FAIL;
        Fluid fluid = sink.getFluid();
        Item filledBucket = fluid.getBucket();
        if (filledBucket == Items.AIR) return ItemInteractionResult.FAIL;
        sink.removeFluid(FluidContainerBlockEntity.BUCKET_VOLUME);
        if (!player.isCreative()) {
            ItemStack newStack = filledBucket.getDefaultInstance();
            stack.shrink(1);
            if (stack.isEmpty()) player.setItemInHand(hand, newStack);
            else if (!player.getInventory().add(newStack)) player.drop(newStack, false);
        }
        return ItemInteractionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return blockState.getValue(PART) == BathPart.EXTENSION ? null : new BathBlockEntity(blockPos, blockState);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapesByState.get(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, WATERLOGGED, HAS_WATER, PART);
    }

    public enum BathPart implements StringRepresentable {
        MAIN, EXTENSION;

        @Override
        public String getSerializedName() {
            return name().toLowerCase();
        }

        @Override
        public String toString() {
            return getSerializedName();
        }
    }
}