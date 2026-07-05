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

    public ItemStack stack;
    public final ItemRenderer itemRenderer;

    public MicrowaveBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(MicrowaveBlockEntity blockEntity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        stack = blockEntity.itemHandler.getItem(0);
        if (stack.isEmpty()) {
            return;
        }

        poseStack.pushPose();
        int lightAbove = LevelRenderer.getLightColor(blockEntity.getLevel(), blockEntity.getBlockPos().above());
        Direction facing = blockEntity.getLevel().getBlockState(blockEntity.getBlockPos()).getValue(MicrowaveBlock.DIRECTION);
        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));

        float x, y, z;
        switch (facing) {
            case NORTH -> { x = 0.625f; y = 0.15f; z = 0.57f; }
            case SOUTH -> { x = 0.375f; y = 0.15f; z = 0.43f; }
            case WEST  -> { x = 0.57f;  y = 0.15f; z = 0.375f; }
            case EAST  -> { x = 0.43f;  y = 0.15f; z = 0.625f; }
            default -> throw new IllegalStateException("Unexpected value: " + facing);
        }
        poseStack.translate(x, y, z);
        poseStack.mulPose(Axis.YP.rotationDegrees(-facing.toYRot()));

        if (blockEntity.hasRecipe() && !blockEntity.hasCraftingFinished()) {
            poseStack.mulPose(Axis.YP.rotationDegrees((blockEntity.getLevel().getGameTime() + partialTick) * 4));
        }
        poseStack.mulPose(Axis.XP.rotationDegrees(90f));

        poseStack.scale(0.5f, 0.5f, 0.5f);
        this.itemRenderer.renderStatic(stack, ItemDisplayContext.GROUND, lightAbove, packedOverlay, poseStack, bufferSource, blockEntity.getLevel(), 0);
        poseStack.popPose();
    }
}