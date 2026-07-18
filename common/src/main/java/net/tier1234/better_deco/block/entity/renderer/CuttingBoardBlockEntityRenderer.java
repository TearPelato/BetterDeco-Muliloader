package net.tier1234.better_deco.block.entity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.tier1234.better_deco.block.custom.CuttingBoardBlock;
import net.tier1234.better_deco.block.entity.custom.CuttingBoardBlockEntity;

public class CuttingBoardBlockEntityRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity> {

    public ItemRenderer itemRenderer;

    public CuttingBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
    this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(CuttingBoardBlockEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack,
                       MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay) {
        ItemStack stack = pBlockEntity.getItem(0);

        Direction direction = pBlockEntity.getBlockState().getValue(CuttingBoardBlock.DIRECTION);

        pPoseStack.pushPose();
        pPoseStack.translate(0.5, 0.1, 0.5);
        pPoseStack.scale(0.5f, 0.5f, 0.5f);
        BakedModel model = this.itemRenderer.getModel(stack, pBlockEntity.getLevel(), null, 0);
        float offset = model.isGui3d() ? 0.0375F : 0.0625F;
        this.drawItem(stack, pBlockEntity.getLevel(), direction, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay, !model.isGui3d(), offset);
        pPoseStack.popPose();
    }

    private void drawItem(ItemStack stack, Level level, Direction facing, PoseStack poseStack, MultiBufferSource source, int light, int overlay, boolean flat, float offset)
    {
        poseStack.pushPose();
        this.setupItemRotation(poseStack, facing, flat);
        this.itemRenderer.renderStatic(stack, ItemDisplayContext.NONE, light, overlay, poseStack, source, level, 0);
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