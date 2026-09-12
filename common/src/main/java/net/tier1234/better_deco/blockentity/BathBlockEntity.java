package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
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
        BathBlockEntity master = getMaster();
        if (master == null) return false;

        int current = master.getStoredAmount();
        int max = master.getCapacity();

        if ((master.isEmpty() || master.getFluid() == fluid) && current + BUCKET_VOLUME <= max) {
            int newAmount = current + BUCKET_VOLUME;
            setFluidOnBoth(master, fluid, newAmount);
            return true;
        }
        return false;
    }

    public void removeFluid(int amount) {
        BathBlockEntity master = getMaster();
        if (master == null) return;

        int remaining = Math.max(master.getStoredAmount() - amount, 0);
        Fluid fluid = remaining > 0 ? master.getFluid() : Fluids.EMPTY;
        setFluidOnBoth(master, fluid, remaining);
    }

    private @Nullable BathBlockEntity getMaster() {
        if (level == null) return null;

        if (!isHead()) {
            return this;
        }
        return getOtherPart();
    }

    private void setFluidOnBoth(BathBlockEntity master, Fluid fluid, int amount) {
        master.setFluidAndAmount(fluid, amount);
        master.setChanged();

        BathBlockEntity other = master.getOtherPart();
        if (other != null) {
            other.setFluidAndAmount(fluid, amount);
            other.setChanged();
        }
    }

    private @Nullable BathBlockEntity getOtherPart() {
        if (level == null) return null;

        BlockState state = getBlockState();
        Direction direction = state.getValue(BathBlock.DIRECTION);
        BlockPos otherPos = state.getValue(BathBlock.PART) == BathBlock.BathPart.BOTTOM
                ? worldPosition.relative(direction)
                : worldPosition.relative(direction.getOpposite());

        BlockEntity other = level.getBlockEntity(otherPos);
        return other instanceof BathBlockEntity bath ? bath : null;
    }

    public boolean isHead() {
        return getBlockState().getValue(BathBlock.PART) == BathBlock.BathPart.HEAD;
    }
}