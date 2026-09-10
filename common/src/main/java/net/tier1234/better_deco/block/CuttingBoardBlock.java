package net.tier1234.better_deco.block;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.SingleRecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.tearpelato.deco_lib.api.block.furniture.FurnitureHorizontalBlock;
import net.tearpelato.deco_lib.api.shape.VoxelShapeHelper;
import net.tier1234.better_deco.blockentity.CuttingBoardBlockEntity;
import net.tier1234.better_deco.recipe.CuttingBoardRecipe;
import net.tier1234.better_deco.registries.ModRecipes;
import net.tier1234.better_deco.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class CuttingBoardBlock extends FurnitureHorizontalBlock implements EntityBlock {
   private WoodType woodType;
    public CuttingBoardBlock(WoodType type, Properties properties) {
        super(properties);
        this.woodType = type;
    }

    public WoodType getWoodType() {
        return woodType;
    }

    @Override
    protected Map<BlockState, VoxelShape> generateShapes(ImmutableList<BlockState> states) {
       final VoxelShape[] BASE = VoxelShapeHelper.getRotatedShapes(VoxelShapeHelper.rotate(Block.box(1,0,4,15,1,12), Direction.NORTH));
        ImmutableMap.Builder<BlockState, VoxelShape> builder = new ImmutableMap.Builder<>();
        for(BlockState state : states)
        {
            Direction direction = state.getValue(DIRECTION);
            List<VoxelShape> shapes = new ArrayList<>();
            shapes.add(BASE[direction.get2DDataValue()]);


            builder.put(state, VoxelShapeHelper.combineAll(shapes));
        }
        return builder.build();
    }


    @Override
    protected InteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos,
                                              Player player, InteractionHand hand, BlockHitResult hitResult) {
        if (!(level.getBlockEntity(pos) instanceof CuttingBoardBlockEntity cuttingBoard)) {
            return InteractionResult.PASS;
        }

        ItemStack stored = cuttingBoard.getItem(0);

        if (!stored.isEmpty() && stack.is(ModTags.Items.KNIVES)) {
            return tryCut(cuttingBoard, level, pos, state, player, hand);
        }

        if (!stored.isEmpty()) {
            return InteractionResult.PASS;
        }

        if (stack.isEmpty()) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {
            cuttingBoard.setItem(0, stack.copyWithCount(1));

            if (!player.getAbilities().instabuild) {
                stack.shrink(1);
            }

            level.playSound(null, pos, SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS, 0.6F, 1.2F);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos,
                                               Player player, BlockHitResult hitResult) {
        if (!(level.getBlockEntity(pos) instanceof CuttingBoardBlockEntity cuttingBoard)) {
            return InteractionResult.PASS;
        }

        ItemStack stored = cuttingBoard.getItem(0);

        if (stored.isEmpty()) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {
            player.addItem(stored.copy());
            cuttingBoard.setItem(0, ItemStack.EMPTY);
            cuttingBoard.setChanged();

            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);
        }

        return InteractionResult.SUCCESS;
    }

    private InteractionResult tryCut(CuttingBoardBlockEntity cuttingBoard, Level level, BlockPos pos,
                                         BlockState state, Player player, InteractionHand hand) {
        ItemStack stored = cuttingBoard.getItem(0);
        SingleRecipeInput input = new SingleRecipeInput(stored);
        ItemStack knife = player.getItemInHand(hand);
        Optional<RecipeHolder<CuttingBoardRecipe>> match = ((ServerLevel)level).recipeAccess()
                .getRecipeFor(ModRecipes.CUTTING_BOARD_TYPE.get(), input, level);

        if (match.isEmpty()) {
            return InteractionResult.PASS;
        }

        if (!level.isClientSide()) {
            ItemStack result = match.get().value().getResult().copy();

            cuttingBoard.setItem(0, result);
            cuttingBoard.setChanged();


            if (!player.getAbilities().instabuild) {
                knife.hurtAndBreak(1, player, hand.asEquipmentSlot());
            }

            level.playSound(null, pos, SoundEvents.WOOD_HIT, SoundSource.BLOCKS, 1.0F, 1.0F);
            level.sendBlockUpdated(pos, state, state, Block.UPDATE_ALL);

            if (level instanceof ServerLevel serverLevel) {
                serverLevel.sendParticles(ParticleTypes.CRIT,
                        pos.getX() + 0.5, pos.getY() + 0.15, pos.getZ() + 0.5,
                        6, 0.2, 0.05, 0.2, 0.0);
            }
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new CuttingBoardBlockEntity(pos, state);
    }
}
