package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemDisplayContext;
import net.tier1234.better_deco.block.ShelfBlock;
import net.tier1234.better_deco.blockentity.ShelfBlockEntity;
import net.tier1234.better_deco.registries.ModInventory;

public class ShelfBlockEntityRenderer implements BlockEntityRenderer<ShelfBlockEntity> {
    private static final float U1 = 1f / 16f;

    public ShelfBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(ShelfBlockEntity blockEntity, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource,
                       int packedLight, int packedOverlay) {

        Direction dir = blockEntity.getBlockState().getValue(ShelfBlock.DIRECTION);
        SimpleContainer items = blockEntity.handler;

        float scale = 0.30f;
        float xOffset = 5.2f;
        float yOffset = 3.5f;
        float yOffset2 = 4.5f;
        float zOffset = 0.15f;

        int[] xMult = {1, 0, -1, 1, 0, -1};
        float[] yVals = {
                U1 * yOffset,  U1 * yOffset,  U1 * yOffset,
                -U1 * yOffset2, -U1 * yOffset2, -U1 * yOffset2
        };


        for (int index = 0; index < items.getContainerSize(); index++) {
            if (items.getItem(index).isEmpty()) continue;

            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(U1 * xOffset * xMult[index], yVals[index], zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(index), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0);
            poseStack.popPose();

        }
    }
}

