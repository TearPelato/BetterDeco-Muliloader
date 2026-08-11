package net.tier1234.better_deco.blockentity.renderer;

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
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.tearpelato.deco_lib.api.fluid.renderer.FluidContainerRenderer;
import net.tier1234.better_deco.block.ToiletBlock;
import net.tier1234.better_deco.blockentity.ToiletBlockEntity;
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
        AABB box = FluidContainerRenderer.createRotatedBox(dir, 5,5,5, 13,8,11);
        FluidContainerRenderer.drawContainer(be.getLevel(), be.getBlockPos(), be, box, poseStack, multiBufferSource, getLightLevel(be.getLevel(), be.getBlockPos()));
    }
    private int getLightLevel(Level level, BlockPos pos) {
        int bLight = level.getBrightness(LightLayer.BLOCK, pos);
        int sLight = level.getBrightness(LightLayer.SKY, pos);
        return LightTexture.pack(bLight, sLight);
    }
}
