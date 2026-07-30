package net.tier1234.better_deco.block.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
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
import net.tier1234.better_deco.Config;
import net.tier1234.better_deco.block.entity.custom.KitchenSinkBlockEntity;

import org.jetbrains.annotations.Nullable;
import java.util.Arrays;

public class KitchenSinkBlock extends FurnitureHorizontalBlock implements SimpleWaterloggedBlock, EntityBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty HAS_WATER = ModBlockStateProperties.HAS_WATER;

    private final ImmutableMap<BlockState, VoxelShape> shapesByState;

    public KitchenSinkBlock(Properties props) {
        super(props);
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DIRECTION, Direction.SOUTH)
                .setValue(HAS_WATER, false));
        this.shapesByState = generateShapes(this.getStateDefinition().getPossibleStates());
    }


    public ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        for (BlockState s : states) {
            Direction dir = s.getValue(DIRECTION);
            VoxelShape lower = createShape(0, 0, 0, 16, 9, 14, dir);
            VoxelShape upper = createShape(0, 9, 0, 16, 16, 16, dir);
            builder.put(s, VoxelShapeHelper.combineAll(Arrays.asList(lower, upper)));
        }
        return builder.build();
    }

    private VoxelShape createShape(double x1, double y1, double z1, double x2, double y2, double z2, Direction dir) {
        VoxelShape[] rotated = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(x1, y1, z1, x2, y2, z2), Direction.SOUTH));
        return rotated[dir.get2DDataValue()];
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new KitchenSinkBlockEntity(pos, state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level world, BlockPos pos, Player player, BlockHitResult hit) {
        return InteractionResult.PASS;
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (world.isClientSide) return ItemInteractionResult.SUCCESS;
        BlockEntity be = world.getBlockEntity(pos);
        if (!(be instanceof KitchenSinkBlockEntity sink)) return ItemInteractionResult.FAIL;

        if (stack.isEmpty()) return fillFromNearbyFluid(sink, world, pos);
        Item item = stack.getItem();
        if (item == Items.BUCKET) return handleBucket(sink, player, hand, stack);
        return fillFromItemStack(sink, player, hand, stack);
    }

    private ItemInteractionResult fillFromNearbyFluid(KitchenSinkBlockEntity sink, Level world, BlockPos pos) {
        FluidState fs = world.getFluidState(pos.below(2));
        if (!fs.isSource() || fs.isEmpty()) return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        Fluid fluid = fs.getType();
        if (!Config.CLIENT.sink.allowAllLiquids.get() && fluid != Fluids.WATER) return ItemInteractionResult.FAIL;
        return sink.addFluid(fluid) ? ItemInteractionResult.SUCCESS : ItemInteractionResult.FAIL;

    }

    private ItemInteractionResult fillFromItemStack(KitchenSinkBlockEntity sink, Player player, InteractionHand hand, ItemStack stack) {
        Fluid fluid = FluidInteractionUtil.getFluidFromItemStack(stack);
        if (fluid == Fluids.EMPTY || stack.getItem() == Items.BUCKET) return ItemInteractionResult.FAIL;
        if (!Config.CLIENT.sink.allowAllLiquids.get() && fluid != Fluids.WATER) return ItemInteractionResult.FAIL;
        boolean success = sink.addFluid(fluid);
        if (success && !player.isCreative()) player.setItemInHand(hand, Items.BUCKET.getDefaultInstance());
        return success ? ItemInteractionResult.SUCCESS : ItemInteractionResult.FAIL;
    }

    private ItemInteractionResult handleBucket(KitchenSinkBlockEntity sink, Player player, InteractionHand hand, ItemStack stack) {
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
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return shapesByState.get(state);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, WATERLOGGED, HAS_WATER);
    }
}