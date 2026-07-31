package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidContainerRenderer;
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
        AABB box = FluidContainerRenderer.createRotatedBox(dir, 2, 2, 2, 14, 15.9, 16);
        FluidContainerRenderer.drawContainer(be.getLevel(), be.getBlockPos(), be, box, ms, buf, getLightLevel(be.getLevel(), be.getBlockPos()));
    }

    @Override
    public boolean shouldRenderOffScreen(BathBlockEntity blockEntity) {
        return true;
    }

    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
