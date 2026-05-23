package net.tier1234.better_deco.block.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.block.entity.custom.FurniWorkbenchBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FurniWorkbench extends FurnitureHorizontalBlock implements EntityBlock {
    public static final MapCodec<FurniWorkbench> CODEC = simpleCodec(FurniWorkbench::new);

    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public FurniWorkbench(Properties properties) {
        super(properties);
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        VoxelShape baseShape = getBaseShape();
        VoxelShape[] rotatedShapes = VoxelShapeHelper.getRotatedShapes(baseShape);

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();

        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            VoxelShape shape = rotatedShapes[direction.get2DDataValue()];
            builder.put(state, shape);
        }

        return builder.build();
    }

    private static VoxelShape getBaseShape() {
        return VoxelShapeHelper.combineAll(List.of(
                Block.box(1, 0, 1, 3, 14, 3),
                Block.box(1, 0, 13, 3, 14, 15),
                Block.box(13, 0, 1, 15, 14, 3),
                Block.box(13, 0, 13, 15, 14, 15),
                Block.box(2, 3, 2, 14, 5, 14),
                Block.box(2, 11, 2, 14, 14, 14),
                Block.box(0, 14, 0, 16, 15, 16),
                Block.box(0, 15, 15, 16, 16, 16),
                Block.box(6, 5, 8, 13, 8, 11),
                Block.box(4, 5, 5.5, 11, 8, 8.5),
                Block.box(3, 11, 2, 3, 16, 14)
        ));
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos) {
        return Shapes.empty();
    }

    @Override
    protected boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    protected RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof FurniWorkbenchBlockEntity workbench) {
                FrameworkAPI.openMenuWithData(serverPlayer, workbench, workbench.createCustomData());
            }
        }
        return InteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new FurniWorkbenchBlockEntity(blockPos, blockState);
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (!state.is(newState.getBlock())) { // Ensure block is actually removed and not just updated
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof FurniWorkbenchBlockEntity furniWorkbenchBE) {
                SimpleContainer container = furniWorkbenchBE.getOutputContainer();

                for (int i = 0; i < container.getContainerSize(); i++) {
                    ItemStack stack = container.getItem(i);
                    if (!stack.isEmpty()) {
                        Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), stack);
                    }
                }

                level.removeBlockEntity(pos);
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }
}