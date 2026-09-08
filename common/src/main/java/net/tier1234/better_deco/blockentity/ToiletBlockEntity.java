package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import net.tier1234.better_deco.Config;
import net.tier1234.better_deco.registries.ModBlockEntities;


public class ToiletBlockEntity extends FluidContainerBlockEntity {
    public ToiletBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.TOILET.get(), pos, blockState, Config.SERVER.toilet.capacity.get() * BUCKET_VOLUME);
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
}
