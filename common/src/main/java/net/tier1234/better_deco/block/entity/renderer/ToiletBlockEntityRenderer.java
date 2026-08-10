package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidContainerRenderer;
import net.tier1234.better_deco.block.custom.ToiletBlock;
import net.tier1234.better_deco.block.entity.custom.ToiletBlockEntity;
import org.lwjgl.system.NonnullDefault;

@NonnullDefault
public class ToiletBlockEntityRenderer implements BlockEntityRenderer<ToiletBlockEntity> {

   public ToiletBlockEntityRenderer(BlockEntityRendererProvider.Context ignored) {}

    @Override
    public void render(ToiletBlockEntity be, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int overlay, int light) {
        Fluid fluid = be.getFluid();
        if (fluid == Fluids.EMPTY || be.getLevel() == null) return;
        BlockState state = be.getBlockState();
        Direction dir = state.getValue(ToiletBlock.DIRECTION);
        AABB box = FluidContainerRenderer.createRotatedBox(dir, 4, 3.2f, 5, 12, 5.5f, 12);
        FluidContainerRenderer.drawContainer(be.getLevel(), be.getBlockPos(), be, box, poseStack, multiBufferSource, light);
    }
}
