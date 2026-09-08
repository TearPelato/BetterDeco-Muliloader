package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.block.JarBlock;
import net.tier1234.better_deco.blockentity.JarBlockEntity;

public class JarBlockEntityRenderer implements BlockEntityRenderer<JarBlockEntity> {

    private final ItemRenderer renderer;

    public JarBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.renderer = context.getItemRenderer();
    }

    @Override
    public void render(JarBlockEntity jar, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {

        ItemStack stack = jar.getItem(0);
        if (stack.isEmpty())
            return;

        Direction direction = jar.getBlockState().getValue(JarBlock.DIRECTION);

        poseStack.pushPose();
        poseStack.translate(0.5, 0.1, 0.5);
        poseStack.scale(0.499F, 0.499F, 0.499F);

        BakedModel model = this.renderer.getModel(stack, jar.getLevel(), null, 0);

        float offset = model.isGui3d() ? 0.0375F : 0.0625F;
        boolean flat = !model.isGui3d();

        int count = stack.getCount();

        for (int i = 0; i < count; i++) {
            this.drawItem(stack, jar.getLevel(), direction, poseStack, bufferSource, packedLight, packedOverlay, flat, offset, i);
        }

        poseStack.popPose();
    }

    private void drawItem(ItemStack stack, Level level, Direction facing, PoseStack poseStack, MultiBufferSource source, int light, int overlay, boolean flat, float offset, int index) {
        poseStack.pushPose();
        poseStack.translate(0, index * offset, 0);

        this.setupItemRotation(poseStack, facing, flat);
        this.renderer.renderStatic(stack, ItemDisplayContext.NONE, light, overlay, poseStack, source, level, 0);
        poseStack.popPose();
    }

    private void setupItemRotation(PoseStack poseStack, Direction facing, boolean flat) {
        if (!flat)
            return;

        poseStack.mulPose(facing.getRotation());
        poseStack.mulPose(Axis.YP.rotation(Mth.PI));
    }
}