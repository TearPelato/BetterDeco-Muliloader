package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.CuttingBoardBlock;
import net.tier1234.better_deco.blockentity.CuttingBoardBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.CuttingBoardRenderState;
import org.jetbrains.annotations.Nullable;

public class CuttingBoardBlockEntityRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity, CuttingBoardRenderState> {

    private final ItemModelResolver itemModelResolver;

    public CuttingBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public CuttingBoardRenderState createRenderState() {
        return new CuttingBoardRenderState();
    }

    @Override
    public void extractRenderState(CuttingBoardBlockEntity blockEntity, CuttingBoardRenderState state, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {
        BlockEntityRenderState.extractBase(blockEntity, state, breakProgress);
        state.item.clear();

        ItemStack stack = blockEntity.getItem(0);
        if (stack.isEmpty()) {
            return;
        }

        state.direction = blockEntity.getBlockState().getValue(CuttingBoardBlock.DIRECTION);

        if (!(blockEntity.getLevel() instanceof ClientLevel level)) {
            return;
        }

        this.itemModelResolver.updateForTopItem(state.item, stack, ItemDisplayContext.FIXED, level, null, (int) blockEntity.getBlockPos().asLong());
        state.flat = !state.item.usesBlockLight();
    }

    @Override
    public void submit(CuttingBoardRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {

        if (state.item.isEmpty()) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.08D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.direction.toYRot()));

        if (state.flat) {
            poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
            poseStack.scale(0.6F, 0.6F, 0.6F);
        } else {
            poseStack.scale(0.4F, 0.4F, 0.4F);
        }


        state.item.submit(poseStack, collector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);
        poseStack.popPose();
    }
}