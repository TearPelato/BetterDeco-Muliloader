package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import net.tier1234.better_deco.Config;
import net.tier1234.better_deco.block.BathBlock;
import net.tier1234.better_deco.registries.ModBlockEntities;
import org.jetbrains.annotations.Nullable;


public class BathBlockEntity extends FluidContainerBlockEntity {

    public BathBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BATH.get(), pos, state, Config.SERVER.bathTube.capacity.get() * BUCKET_VOLUME);
    }

    public boolean addFluid(Fluid fluid) {
        int current = getStoredAmount();
        int max = getCapacity();
        if (isEmpty() || getFluid() == fluid) {
            if (current + BUCKET_VOLUME <= max) {
                setFluidAndAmount(fluid, current + BUCKET_VOLUME);
                return true;
            }
        }
        return false;
    }

    public void removeFluid(int amount) {
        int remaining = getStoredAmount() - amount;
        setFluidAndAmount(getFluid(), Math.max(remaining, 0));
    }

    private @Nullable BathBlockEntity getOtherPart() {
        if (level == null)
            return null;

        BlockState state = getBlockState();
        Direction direction = state.getValue(BathBlock.DIRECTION);
        BlockPos otherPos = state.getValue(BathBlock.PART) == BathBlock.BathPart.BOTTOM ? worldPosition.relative(direction) : worldPosition.relative(direction.getOpposite());
        BlockEntity other = level.getBlockEntity(otherPos);

        return other instanceof BathBlockEntity bath ? bath : null;
    }

    public boolean isHead() {
        return getBlockState().getValue(BathBlock.PART) == BathBlock.BathPart.HEAD;
    }
}