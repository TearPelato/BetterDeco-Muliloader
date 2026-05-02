package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.tier1234.better_deco.block.custom.CustomShelfBlock;
import net.tier1234.better_deco.block.entity.custom.ShelfBlockEntity;
import net.tier1234.better_deco.init.ModInventory;

public class ShelfBlockEntityRenderer implements BlockEntityRenderer<ShelfBlockEntity> {
    private static final float U1 = 1f / 16f;

    public ShelfBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    }

    @Override
    public void render(ShelfBlockEntity blockEntity, float partialTick,
                       PoseStack poseStack, MultiBufferSource bufferSource,
                       int packedLight, int packedOverlay) {

        Direction dir = blockEntity.getBlockState().getValue(CustomShelfBlock.FACING);
        ModInventory items = blockEntity.handler;

        float scale = 0.30f;
        float xOffset = 5.2f;
        float yOffset = 3.5f;
        float yOffset2 = 4.5f;
        float zOffset = 0.15f;

        // Slot 0
        if (!items.getItem(0).isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(U1 * xOffset, U1 * yOffset, zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(0), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }

        // Slot 1
        if (!items.getItem(1).isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(0, U1 * yOffset, zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(1), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }

        // Slot 2
        if (!items.getItem(2).isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(-U1 * xOffset, U1 * yOffset, zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(2), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }

        // Slot 3
        if (!items.getItem(3).isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(U1 * xOffset, -U1 * yOffset2, zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(3), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }

        // Slot 4
        if (!items.getItem(4).isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(0, -U1 * yOffset2, zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(4), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }

        // Slot 5
        if (!items.getItem(5).isEmpty()) {
            poseStack.pushPose();
            poseStack.translate(0.5f, 0.5f, 0.5f);
            poseStack.mulPose(Axis.YP.rotationDegrees(-dir.toYRot() + 180f));
            poseStack.translate(-U1 * xOffset, -U1 * yOffset2, zOffset);
            poseStack.scale(scale, scale, scale);
            Minecraft.getInstance().getItemRenderer().renderStatic(
                    items.getItem(5), ItemDisplayContext.FIXED,
                    packedLight, packedOverlay, poseStack, bufferSource,
                    blockEntity.getLevel(), 0
            );
            poseStack.popPose();
        }
    }
}

