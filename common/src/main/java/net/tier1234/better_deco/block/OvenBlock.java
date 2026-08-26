package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.blockentity.OvenBlockEntity;
import org.jetbrains.annotations.Nullable;


public class OvenBlock extends FurnitureHorizontalBlock implements EntityBlock
{
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;
    private WoodType woodType;
    private DyeColor color;

    public OvenBlock(WoodType type,Properties properties)
    {
        super(properties);
        this.woodType = type;
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    public OvenBlock(DyeColor color,Properties properties)
    {
        super(properties);
        this.color = color;
        this.registerDefaultState(this.getStateDefinition().any().setValue(DIRECTION, Direction.NORTH));
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    public WoodType getWoodType() {
        return woodType;
    }

    public DyeColor getColor() {
        return color;
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {

        final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(
                VoxelShapeHelper.rotate(Block.box(0, 0, 0, 16, 13, 14), Direction.SOUTH));
        final VoxelShape[] TOP = VoxelShapeHelper.getRotatedShapes(
                VoxelShapeHelper.rotate(Block.box(0, 13, 0, 16, 16, 16), Direction.SOUTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);

            VoxelShape shape = Shapes.or(
                    BASE[direction.get2DDataValue()],
                    TOP[direction.get2DDataValue()]
            );

            builder.put(state, shape);
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter reader, BlockPos pos, CollisionContext context)
    {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getOcclusionShape(BlockState state, BlockGetter reader, BlockPos pos)
    {
        return SHAPES.get(state);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof OvenBlockEntity) {
                ((OvenBlockEntity) blockEntity).drops();
            }
        }
        super.onRemove(state, level, pos, newState, isMoving);
    }

    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            BlockEntity entity = level.getBlockEntity(pos);
            if (entity instanceof OvenBlockEntity ovenBlockEntity) {
                FrameworkAPI.openMenuWithData((ServerPlayer) player,ovenBlockEntity, ovenBlockEntity.getData());
            } else {
                throw new IllegalStateException("Oven container provider is missing!");
            }
        }
        return ItemInteractionResult.sidedSuccess(level.isClientSide());

    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new OvenBlockEntity(pos, state);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        return level.isClientSide ? null :
                (type == ModBlockEntities.OVEN.get()
                        ? (lvl, pos, st, be) -> ((OvenBlockEntity) be).tick(lvl, pos, st)
                        : null);
    }
}
