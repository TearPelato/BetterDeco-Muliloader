package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidContainerRenderer;
import net.tier1234.better_deco.block.entity.custom.BasinBlockEntity;
import org.lwjgl.system.NonnullDefault;

@NonnullDefault
public class BasinBlockEntityRenderer implements BlockEntityRenderer<BasinBlockEntity> {

    public BasinBlockEntityRenderer(BlockEntityRendererProvider.Context ignored) {}

    @Override
    public void render(BasinBlockEntity be, float partialTick, PoseStack ms, MultiBufferSource buf, int light, int overlay) {
        Fluid fluid = be.getFluid();
        if (fluid == Fluids.EMPTY || be.getLevel() == null) return;
        BlockState state = be.getBlockState();
        if (!state.hasProperty(BlockStateProperties.HORIZONTAL_FACING)) return;
        Direction dir = state.getValue(BlockStateProperties.HORIZONTAL_FACING);
        AABB box = FluidContainerRenderer.createRotatedBox(dir, 1, 13, 1, 15, 15.9, 15);
        FluidContainerRenderer.drawContainer(be.getLevel(), be.getBlockPos(), be, box, ms, buf, light);
    }

}
