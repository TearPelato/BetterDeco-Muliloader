package net.tier1234.better_deco.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.tearpelato.deco_lib.api.fluid.block_entity.FluidContainerBlockEntity;
import net.tier1234.better_deco.Config;
import net.tier1234.better_deco.registries.ModBlockEntities;
import org.lwjgl.system.NonnullDefault;

@NonnullDefault
public class BasinBlockEntity extends FluidContainerBlockEntity {
    public BasinBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.BASIN.get(), pos, state, Config.CLIENT.basin.capacity.get() * FluidContainerBlockEntity.BUCKET_VOLUME);
    }

    public boolean addFluid(Fluid fluid) {
        int current = getAmount();
        int max = getCapacity();
        if (isEmpty() || getFluid() == fluid) {
            if (current + BUCKET_VOLUME <= max) {
                setFluid(fluid, current + BUCKET_VOLUME);
                return true;
            }
        }
        return false;
    }

    public void removeFluid(int amount) {
        int remaining = getAmount() - amount;
        setFluid(getFluid(), Math.max(remaining, 0));
    }


}
