package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.block.BlockAndTintGetter;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidContainerRenderer;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidRenderState;
import net.tearpelato.deco_lib.api.fluid.renderer.core.FluidSprites;
import net.tier1234.better_deco.blockentity.BasinBlockEntity;
import org.jspecify.annotations.Nullable;


public class BasinBlockEntityRenderer implements BlockEntityRenderer<BasinBlockEntity, FluidRenderState> {

    public BasinBlockEntityRenderer(BlockEntityRendererProvider.Context ignored) {}


    @Override
    public FluidRenderState createRenderState() {
        return new FluidRenderState();
    }

    @Override
    public void extractRenderState(BasinBlockEntity blockEntity, FluidRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        if (blockEntity.getLevel() == null) return;

        BlockState blockState = blockEntity.getBlockState();
        if (!blockState.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) return;

        state.facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        state.fluid = blockEntity.getFluid();
        state.level = blockEntity.getLevel();
        state.world = (BlockAndTintGetter) blockEntity.getLevel();
        state.pos = blockEntity.getBlockPos();
        state.be = blockEntity;


        if (state.fluid != Fluids.EMPTY && state.fluid != null) {
            FluidState fluidState = state.fluid.defaultFluidState();
            state.fluidSprites = new FluidSprites(null, null).getFluidSprites(fluidState);
        } else {
            state.fluidSprites = null;
        }

    }

    @Override
    public void submit(FluidRenderState fluidRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
        if (fluidRenderState.fluid == Fluids.EMPTY || fluidRenderState.fluidSprites == null || fluidRenderState.world == null) {
            return;
        }

        poseStack.pushPose();
        Direction dir = fluidRenderState.facing;

        poseStack.translate(0.5, 0, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-90F * dir.get2DDataValue()));
        poseStack.translate(-0.5, 0, -0.5);

        AABB box = FluidContainerRenderer.createRotatedBox(dir, 1, 13, 1, 15, 15.9, 15);

        FluidContainerRenderer.drawContainer(fluidRenderState, fluidRenderState.world, fluidRenderState.pos, fluidRenderState.be, box, poseStack,
                Minecraft.getInstance().renderBuffers().bufferSource());

        poseStack.popPose();
    }
}
