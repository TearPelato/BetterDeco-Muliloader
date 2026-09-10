package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.ShelfBlock;
import net.tier1234.better_deco.blockentity.ShelfBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.ShelfRenderState;
import org.jspecify.annotations.Nullable;

public class ShelfBlockEntityRenderer implements BlockEntityRenderer<ShelfBlockEntity, ShelfRenderState> {
    private static final float U1 = 1f / 16f;

    public final ItemModelResolver itemModelResolver;

    public ShelfBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public ShelfRenderState createRenderState() {
        return new ShelfRenderState();
    }

    @Override
    public void extractRenderState(ShelfBlockEntity blockEntity, ShelfRenderState state, float partialTicks, Vec3 cameraPosition, ModelFeatureRenderer.@Nullable CrumblingOverlay breakProgress) {
        BlockEntityRenderer.super.extractRenderState(blockEntity, state, partialTicks, cameraPosition, breakProgress);
        state.be = blockEntity;
        state.lightPosition = blockEntity.getBlockPos();
        state.blockEntityLevel = blockEntity.getLevel();

        itemModelResolver.updateForTopItem(state.itemStackRenderState,
                blockEntity.handler.getItems().get(0), ItemDisplayContext.FIXED, blockEntity.getLevel(), null, 0);


    }

    @Override
    public void submit(ShelfRenderState shelfRenderState, PoseStack poseStack, SubmitNodeCollector submitNodeCollector, CameraRenderState cameraRenderState) {

        Direction dir = shelfRenderState.be.getBlockState().getValue(ShelfBlock.DIRECTION);
        SimpleContainer items = shelfRenderState.be.handler;

        float scale = 0.30f;

        float xOffset = 3.5f;
        float zFront = 2.0f;
        float zBack = 5.5f;
        float yOffset = 9.3f;

        int[] xMult   = {-1, 1, -1, 1};
        float[] zVals = { zFront, zFront, zBack, zBack };
        int size = Math.min(items.getContainerSize(), 4);
        for (int index = 0; index < size; index++) {
            if (items.getItem(index).isEmpty()) continue;

            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(
                    U1 * xOffset * xMult[index],
                    U1 * yOffset,
                    U1 * zVals[index]
            );
            poseStack.scale(scale, scale, scale);
            shelfRenderState.itemStackRenderState.submit(poseStack, submitNodeCollector, shelfRenderState.lightCoords, OverlayTexture.NO_OVERLAY, 0);
            poseStack.popPose();
        }
    }
}

