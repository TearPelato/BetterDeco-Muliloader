package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
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
import net.tier1234.better_deco.block.BathBlock;
import net.tier1234.better_deco.blockentity.BathBlockEntity;
import org.jspecify.annotations.Nullable;


public class BathBlockEntityRenderer implements BlockEntityRenderer<BathBlockEntity, FluidRenderState> {

   public BathBlockEntityRenderer(BlockEntityRendererProvider.Context ignored) {}

    @Override
    public FluidRenderState createRenderState() {
        return new FluidRenderState();
    }

    @Override
    public void extractRenderState(BathBlockEntity blockEntity, FluidRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        if (blockEntity.getLevel() == null) return;
        BlockState blockState = blockEntity.getBlockState();

        state.facing = blockState.getValue(BlockStateProperties.HORIZONTAL_FACING);
        state.fluid = blockEntity.getFluid();
        state.level = blockEntity.getLevel();
        state.world = (BlockAndTintGetter) blockEntity.getLevel();
        state.be = blockEntity;

        if (state.fluid != Fluids.EMPTY && state.fluid != null) {
            FluidState fluidState = state.fluid.defaultFluidState();
            state.fluidSprites = new FluidSprites(null, null).getFluidSprites(fluidState);
        } else {
            state.fluidSprites = null;
        }
        FluidRenderState.extract(state, blockEntity.getLevel(), blockEntity.getBlockPos());
        if(blockState.hasProperty(BathBlock.DIRECTION)) {
            state.box = this.getFluidBox(blockEntity, blockState.getValue(BathBlock.DIRECTION));
        }

    }

    private AABB getFluidBox(BathBlockEntity bath, Direction direction)
    {
        if(bath.isHead())
        {
            return FluidContainerRenderer.createRotatedBox(direction, 0, 4, 2, 12, 15, 14);
        }
        return FluidContainerRenderer.createRotatedBox(direction, 2, 4, 2, 16, 15, 14);
    }

    @Override
    public void submit(FluidRenderState fluidRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {
       FluidContainerRenderer.submit(fluidRenderState, poseStack,submitNodeCollector);
    }


}
