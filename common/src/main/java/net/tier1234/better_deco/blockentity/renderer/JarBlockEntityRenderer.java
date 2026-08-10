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
    public void render(JarBlockEntity jar, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        ItemStack filter = jar.getItem(0);
        if(filter.isEmpty())
            return;

        Direction direction = jar.getBlockState().getValue(JarBlock.DIRECTION);
        poseStack.pushPose();
        poseStack.translate(0.5, 0.1, 0.5);
        poseStack.scale(0.499F, 0.499F, 0.499F);

        for(int i = 0; i < jar.getContainerSize(); i++)
        {
            ItemStack stack = jar.getItem(i);
            if(stack.isEmpty())
                continue;

            BakedModel model = this.renderer.getModel(stack, jar.getLevel(), null, 0);
            float offset = model.isGui3d() ? 0.0375F : 0.0625F;
            this.drawItem(stack, jar.getLevel(), direction, poseStack, bufferSource, packedLight, packedOverlay, !model.isGui3d(), offset);

        }
        poseStack.popPose();
    }

    private void drawItem(ItemStack stack, Level level, Direction facing, PoseStack poseStack, MultiBufferSource source, int light, int overlay, boolean flat, float offset)
    {
        poseStack.pushPose();
        this.setupItemRotation(poseStack, facing, flat);
        this.renderer.renderStatic(stack, ItemDisplayContext.NONE, light, overlay, poseStack, source, level, 0);
        poseStack.popPose();
        poseStack.translate(0, offset, 0);
        this.postDrawItem(poseStack, flat);
    }

    private void setupItemRotation(PoseStack poseStack, Direction facing, boolean flat)
    {
        if(!flat) return;
        poseStack.mulPose(facing.getRotation());
        poseStack.mulPose(Axis.YP.rotation(Mth.PI));
    }

    private void postDrawItem(PoseStack poseStack, boolean flat)
    {
        if(flat)
        {
            poseStack.mulPose(Axis.YP.rotation(Mth.HALF_PI / 2.01F));
            return;
        }
        poseStack.scale(0.998F, 0.998F, 0.998F);
    }
}