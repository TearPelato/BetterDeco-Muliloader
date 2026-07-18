package net.tier1234.better_deco.block.custom;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockBox;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.block_entity.FurnitureHorizontalEntityBlock;
import net.tier1234.better_deco.block.entity.custom.JarBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.stream.Collectors;

public class JarBlock extends FurnitureHorizontalEntityBlock {

    public static final MapCodec<JarBlock> CODEC = simpleCodec(JarBlock::new);


    public JarBlock(Properties properties) {
        super(properties);
    }


    @Override
    protected ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!(level.getBlockEntity(pos) instanceof JarBlockEntity jar)) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (stack.isEmpty()) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        ItemStack stored = jar.getItem(0);

        boolean sameItem = stored.isEmpty() || ItemStack.isSameItemSameComponents(stored, stack);
        if (!sameItem) {
            return ItemInteractionResult.FAIL;
        }

        int maxCapacity = Math.min(stack.getMaxStackSize(), 64);
        if (stored.getCount() >= maxCapacity) {
            return ItemInteractionResult.FAIL;
        }

        if (!level.isClientSide) {
            if (stored.isEmpty()) {
                jar.setItem(0, stack.copyWithCount(1));
            } else {
                stored.grow(1);
                jar.setChanged();
            }

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 0.6F, 1.2F);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
        }

        return ItemInteractionResult.sidedSuccess(level.isClientSide);
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
        VoxelShape shapes = Block.box(3,0,3,13,12,13);
        return  ImmutableMap.copyOf(states.stream().collect(Collectors.toMap(state -> state, o -> shapes)));
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return CODEC;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new JarBlockEntity(pos, state);
    }
}
