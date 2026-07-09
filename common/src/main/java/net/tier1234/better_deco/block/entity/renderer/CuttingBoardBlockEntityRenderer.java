package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.block.custom.CuttingBoardBlock;
import net.tier1234.better_deco.block.entity.custom.CuttingBoardBlockEntity;

public class CuttingBoardBlockEntityRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity> {
    public ItemStack stack;
    public final ItemRenderer itemRenderer;

    public CuttingBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CuttingBoardBlockEntity be, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {
        stack = be.getItem(0);
        if (stack.isEmpty()) return;

        poseStack.pushPose();
        Direction facing = be.getBlockState().getValue(CuttingBoardBlock.DIRECTION);
        int lightAbove = LevelRenderer.getLightColor(be.getLevel(), be.getBlockPos().above());
        poseStack.translate(0.5, 1.001, 0.5);
        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));
        poseStack.scale(0.4f, 0.4f, 0.4f);
        poseStack.mulPose(Axis.XP.rotationDegrees(90f));

        this.itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, lightAbove, packedOverlay, poseStack, buffer, be.getLevel(), 0);

        poseStack.popPose();
    }
}