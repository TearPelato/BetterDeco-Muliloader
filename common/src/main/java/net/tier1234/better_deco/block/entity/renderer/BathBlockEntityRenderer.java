package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidContainerRenderer;
import net.tier1234.better_deco.block.custom.BathBlock;
import net.tier1234.better_deco.block.entity.custom.BathBlockEntity;
import net.tier1234.better_deco.block.entity.custom.BathBlockEntity;
import org.lwjgl.system.NonnullDefault;

@NonnullDefault
public class BathBlockEntityRenderer implements BlockEntityRenderer<BathBlockEntity> {

   public BathBlockEntityRenderer(BlockEntityRendererProvider.Context ignored) {}

    @Override
    public void render(BathBlockEntity be, float partialTick, PoseStack ms, MultiBufferSource buf, int light, int overlay) {
        Fluid fluid = be.getFluid();
        if (fluid == Fluids.EMPTY || be.getLevel() == null) return;
        BlockState state = be.getBlockState();
        if (!state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) return;
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        AABB box = this.getFluidBox(be,dir);
        FluidContainerRenderer.drawContainer(be.getLevel(), be.getBlockPos(), be, box, ms, buf, light);
    }


    private AABB getFluidBox(BathBlockEntity bath, Direction direction)
    {
        if(bath.isHead())
        {
            return FluidContainerRenderer.createRotatedBox(direction, 0, 4, 2, 12, 15, 14);
        }
        return FluidContainerRenderer.createRotatedBox(direction, 2, 4, 2, 16, 15, 14);
    }
}
