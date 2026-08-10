package net.tier1234.better_deco.block;


import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.registries.ModEntities;
import net.tier1234.better_deco.entity.custom.SeatEntity;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class BarStoolBlock extends Block {
    public static final DirectionProperty DIRECTION = DirectionProperty.create("direction", Direction.Plane.HORIZONTAL);
    public static final IntegerProperty COLOUR = IntegerProperty.create("colour", 0, 15);

    private final ImmutableMap<BlockState, VoxelShape> SHAPES;

    public BarStoolBlock(Properties properties) {
        super(Properties.of()
                .strength(0.5F)
                .sound(SoundType.WOOD)
                .noOcclusion()
        );
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(DIRECTION, Direction.NORTH)
                .setValue(COLOUR, 0)
        );
        SHAPES = generateShapes(this.stateDefinition.getPossibleStates());
    }

    protected ImmutableMap<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        // Definisci le forme base per lo sgabello (esempio semplice)
        final VoxelShape baseShape = Block.box(2, 0, 2, 13, 9, 13);
        final VoxelShape legFrontLeft = Block.box(2, 0, 2, 4, 13, 4);
        final VoxelShape legFrontRight = Block.box(12, 0, 2, 14, 13, 4);
        final VoxelShape legBackLeft = Block.box(2, 0, 12, 4, 13, 14);
        final VoxelShape legBackRight = Block.box(12, 0, 12, 14, 13, 14);

        ImmutableMap.Builder<BlockState, VoxelShape> builder = ImmutableMap.builder();
        for (BlockState state : states) {
            Direction dir = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();

            shapes.add(baseShape);
            shapes.add(legFrontLeft);
            shapes.add(legFrontRight);
            shapes.add(legBackLeft);
            shapes.add(legBackRight);

            VoxelShape combined = VoxelShapeHelper.combineAll(shapes);
            VoxelShape rotated = VoxelShapeHelper.rotate(combined, dir);
            builder.put(state, rotated);
        }
        return builder.build();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION, COLOUR);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter world, BlockPos pos, net.minecraft.world.phys.shapes.CollisionContext context) {
        return SHAPES.get(state);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hitResult) {
        if(!level.isClientSide()) {
            Entity entity = null;
            List<SeatEntity> entities = level.getEntities(ModEntities.SEAT_ENTITY.get(), new AABB(pos), chair -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.SEAT_ENTITY.get().spawn(((ServerLevel) level), pos, MobSpawnType.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }

        return InteractionResult.SUCCESS;
    }



    @Nullable
    @Override
    public BlockState getStateForPlacement(net.minecraft.world.item.context.BlockPlaceContext context) {
        Direction dir = context.getHorizontalDirection().getOpposite();
        return this.defaultBlockState()
                .setValue(DIRECTION, dir);
    }

}

