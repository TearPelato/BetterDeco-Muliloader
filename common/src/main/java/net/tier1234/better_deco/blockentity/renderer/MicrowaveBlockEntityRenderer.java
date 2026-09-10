package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.MicrowaveBlock;
import net.tier1234.better_deco.blockentity.MicrowaveBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.MicrowaveRenderState;
import org.jetbrains.annotations.Nullable;

public class MicrowaveBlockEntityRenderer implements BlockEntityRenderer<MicrowaveBlockEntity, MicrowaveRenderState> {

    private final ItemModelResolver itemModelResolver;

    public MicrowaveBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }


    @Override
    public MicrowaveRenderState createRenderState() {
        return new MicrowaveRenderState();
    }

    @Override
    public void extractRenderState(MicrowaveBlockEntity blockEntity, MicrowaveRenderState state, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {

        BlockEntityRenderState.extractBase(blockEntity, state, breakProgress);

        state.facing = blockEntity.getBlockState().getValue(MicrowaveBlock.DIRECTION);
        state.item.clear();
        state.rotation = 0.0F;

        ItemStack stack = blockEntity.getDisplayedItem();
        if (stack.isEmpty()) {
            return;
        }

        if (!(blockEntity.getLevel() instanceof ClientLevel level)) {
            return;
        }

        this.itemModelResolver.updateForTopItem(state.item, stack, ItemDisplayContext.GROUND, level, null, (int) blockEntity.getBlockPos().asLong());


        if (blockEntity.progress > 0 && !blockEntity.hasCraftingFinished()) {
            state.rotation = (level.getGameTime() + partialTick) * 4.0F;
        }
    }

    @Override
    public void submit(MicrowaveRenderState state, PoseStack poseStack,
                       SubmitNodeCollector collector, CameraRenderState camera) {

        if (state.item.isEmpty()) {
            return;
        }

        poseStack.pushPose();

        poseStack.translate(0.5D, 0.0D, 0.5D);
        poseStack.mulPose(Axis.YP.rotationDegrees(-state.facing.toYRot()));
        poseStack.translate(-0.5D, 0.0D, -0.5D);

        poseStack.translate(0.375D, 0.15D, 0.43D);

        if (state.rotation != 0.0F) {
            poseStack.translate(0.125D, 0.0D, 0.07D);
            poseStack.mulPose(Axis.YP.rotationDegrees(state.rotation));
            poseStack.translate(-0.125D, 0.0D, -0.07D);
        }

        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
        poseStack.scale(0.5F, 0.5F, 0.5F);

        state.item.submit(poseStack, collector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

        poseStack.popPose();
    }
}