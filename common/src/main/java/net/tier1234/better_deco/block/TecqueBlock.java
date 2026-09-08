package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mrcrayfish.framework.api.FrameworkAPI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.block_entity.FurnitureHorizontalEntityBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.blockentity.TecqueBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;


public class TecqueBlock extends FurnitureHorizontalEntityBlock {
    public final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public static final MapCodec<TecqueBlock> CODEC = RecordCodecBuilder.mapCodec(builder->{
        return builder.group(WoodType.CODEC.fieldOf("wood_Type").forGetter(block-> {
            return block.woodType;
        }), propertiesCodec()).apply(builder, TecqueBlock::new);
    });

    private final WoodType woodType;

    public TecqueBlock(WoodType type, Properties properties) {
        super(properties);
        this.woodType = type;
        SHAPES = this.generateShapes(this.getStateDefinition().getPossibleStates());
    }

    public WoodType getWoodType() {
        return woodType;
    }

    @Override
    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        final VoxelShape[] SHAPE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1, 0, 1, 15, 11, 15), Direction.NORTH));

        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for (BlockState state : states) {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(SHAPE[direction.get2DDataValue()]);
            builder.put(state, VoxelShapeHelper.combine(shapes));
        }
        return builder.build();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    /* BLOCK ENTITY */

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new TecqueBlockEntity(blockPos, blockState);
    }

    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (player.isCrouching()) {
            return InteractionResult.PASS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof TecqueBlockEntity tecque)) {
            return InteractionResult.PASS;
        }

        if (stack.isEmpty()) {
            return InteractionResult.PASS;
        }

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        boolean inserted = tecque.insertItem(player, stack);
        if (inserted) {
            level.playSound(null, pos, SoundEvents.WOOD_HIT, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if (player.isCrouching()) {
            if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
                BlockEntity blockEntity = level.getBlockEntity(pos);
                if (blockEntity instanceof TecqueBlockEntity tecqueBlockEntity) {
                    FrameworkAPI.openMenuWithData(serverPlayer, tecqueBlockEntity, tecqueBlockEntity.createCustomData());
                }
            }
            return InteractionResult.SUCCESS;
        }

        BlockEntity blockEntity = level.getBlockEntity(pos);
        if (!(blockEntity instanceof TecqueBlockEntity tecque)) {
            return InteractionResult.PASS;
        }

        if (level.isClientSide()) {
            return InteractionResult.SUCCESS;
        }

        ItemStack extracted = tecque.extractItem(player);
        if (!extracted.isEmpty()) {
            level.playSound(null, pos, SoundEvents.WOOD_HIT, SoundSource.BLOCKS, 1.0f, 1.0f);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
