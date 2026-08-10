package net.tier1234.better_deco.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import net.tier1234.better_deco.Config;
import net.tier1234.better_deco.block.custom.BathBlock;
import net.tier1234.better_deco.registries.ModBlockEntities;
import org.jetbrains.annotations.Nullable;
import org.lwjgl.system.NonnullDefault;

@NonnullDefault
public class BathBlockEntity extends FluidContainerBlockEntity {

    public BathBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BATH.get(), pos, state, Config.SERVER.bathTube.capacity.get() * BUCKET_VOLUME);
    }

    public boolean addFluid(Fluid fluid) {
        int current = getAmount();
        int max = getCapacity();

        if (!isEmpty() && getFluid() != fluid)
            return false;

        if (current + BUCKET_VOLUME > max)
            return false;

        int newAmount = current + BUCKET_VOLUME;

        setFluid(fluid, newAmount);
        setChanged();

        BathBlockEntity other = getOtherPart();
        if (other != null) {
            other.setFluid(fluid, newAmount);
            other.setChanged();
        }

        return true;
    }

    public void removeFluid(int amount) {
        int remaining = Math.max(getAmount() - amount, 0);

        setFluid(getFluid(), remaining);
        setChanged();

        BathBlockEntity other = getOtherPart();
        if (other != null) {
            other.setFluid(getFluid(), remaining);
            other.setChanged();
        }
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