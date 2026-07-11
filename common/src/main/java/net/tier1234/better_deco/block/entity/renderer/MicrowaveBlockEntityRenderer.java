package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.block.custom.MicrowaveBlock;
import net.tier1234.better_deco.block.entity.custom.MicrowaveBlockEntity;

public class MicrowaveBlockEntityRenderer implements BlockEntityRenderer<MicrowaveBlockEntity> {
    private final ItemRenderer itemRenderer;

    public MicrowaveBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(MicrowaveBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemStack stack = blockEntity.getDisplayedItem();

        if (stack.isEmpty()) {
            return;
        }

        Direction facing = blockEntity.getBlockState().getValue(MicrowaveBlock.DIRECTION);
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.0D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));
        poseStack.translate(-0.5D, 0.0D, -0.5D);
        poseStack.translate(0.375D, 0.15D, 0.43D);

        if (blockEntity.hasRecipe() && !blockEntity.hasCraftingFinished()) {
            poseStack.translate(0.125D, 0.0D, 0.07D);
            poseStack.mulPose(Axis.YP.rotationDegrees((blockEntity.getLevel().getGameTime() + partialTick) * 4F));
            poseStack.translate(-0.125D, 0.0D, -0.07D);
        }

        poseStack.mulPose(Axis.XP.rotationDegrees(90F));
        poseStack.scale(0.5F, 0.5F, 0.5F);
        int light = LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos().above());
        this.itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, light, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 0);

        poseStack.popPose();
    }
}