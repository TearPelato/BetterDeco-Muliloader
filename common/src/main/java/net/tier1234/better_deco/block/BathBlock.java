package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.Entity;
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
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import net.tearpelato.deco_lib.api.fluid.util.FluidInteractionUtil;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.blockentity.BathBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.stream.Collectors;

public class BathBlock extends FurnitureHorizontalBlock implements SimpleWaterloggedBlock, EntityBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_WATER = ModBlockStateProperties.HAS_WATER;
    public static final EnumProperty<BathPart> PART = EnumProperty.create("part", BathPart.class);
    protected static final VoxelShape BASE_SHAPE = Block.box(0, 2, 0, 32, 16, 16);
    protected static final VoxelShape COLLISION_SHAPE = Shapes.join(BASE_SHAPE, Block.box(2, 4, 2, 28, 16, 14), BooleanOp.ONLY_FIRST);


    public BathBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DIRECTION, Direction.SOUTH)
                .setValue(PART, BathPart.BOTTOM)
                .setValue(HAS_WATER, false));
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states)
    {
        return ImmutableMap.copyOf(states.stream().collect(Collectors.toMap(state -> state, state -> {
            if(state.getValue(PART) == BathPart.HEAD) {
                return VoxelShapeHelper.rotateHorizontally(BASE_SHAPE.move(-1, 0, 0), state.getValue(DIRECTION));
            }
            return VoxelShapeHelper.rotateHorizontally(BASE_SHAPE, state.getValue(DIRECTION));
        })));
    }


    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) return null;

        Direction dir = state.getValue(DIRECTION);
        Level level = context.getLevel();
        BlockPos headPos = context.getClickedPos().relative(dir);

        if (!level.getWorldBorder().isWithinBounds(headPos)) return null;
        if (!level.getBlockState(headPos).canBeReplaced(context)) return null;

        return state.setValue(PART, BathPart.BOTTOM);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        super.setPlacedBy(level, pos, state, placer, stack);
        if (level.isClientSide) return;

        Direction dir = state.getValue(DIRECTION);
        BlockPos headPos = pos.relative(dir);
        boolean headWaterlogged = level.getFluidState(headPos).getType() == Fluids.WATER;

        level.setBlock(headPos, state
                .setValue(PART, BathPart.HEAD)
                .setValue(WATERLOGGED, headWaterlogged), Block.UPDATE_ALL);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context)
    {
        if(state.getValue(PART) == BathPart.HEAD)
        {
            return VoxelShapeHelper.rotateHorizontally(COLLISION_SHAPE.move(-1, 0, 0), state.getValue(DIRECTION));
        }
        return VoxelShapeHelper.rotateHorizontally(COLLISION_SHAPE, state.getValue(DIRECTION));
    }


    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!level.isClientSide && !state.is(newState.getBlock())) {
            BathPart part = state.getValue(PART);
            Direction facing = state.getValue(DIRECTION);
            BlockPos otherPos = part == BathPart.BOTTOM ? pos.relative(facing) : pos.relative(facing.getOpposite());
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
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof BathBlockEntity sink)) return ItemInteractionResult.FAIL;

        if (stack.isEmpty()) return fillFromNearbyFluid(sink, world, pos);
        Item item = stack.getItem();
        if (item == Items.BUCKET) return handleBucket(sink, player, hand, stack);
        return fillFromItemStack(sink, player, hand, stack);
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
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (entity instanceof Player) {
            if(entity.isOnFire()) {
                entity.clearFire();
                level.playSound(null, entity.getX(), entity.getY(), entity.getZ(), SoundEvents.GENERIC_EXTINGUISH_FIRE, entity.getSoundSource(), 0.5f, 1.0f);
            }
        }
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new BathBlockEntity(blockPos, blockState);
    }


    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, WATERLOGGED, HAS_WATER, PART);
    }

    public enum BathPart implements StringRepresentable {
        BOTTOM, HEAD;

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