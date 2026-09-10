package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.feature.ModelFeatureRenderer;
import net.minecraft.client.renderer.item.ItemModelResolver;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.CuttingBoardBlock;
import net.tier1234.better_deco.blockentity.CuttingBoardBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.CuttingBoardRenderState;
import org.jetbrains.annotations.Nullable;

public class CuttingBoardBlockEntityRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity, CuttingBoardRenderState> {

    private final ItemModelResolver itemModelResolver;

    public CuttingBoardBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public CuttingBoardRenderState createRenderState() {
        return new CuttingBoardRenderState();
    }

    @Override
    public void extractRenderState(CuttingBoardBlockEntity blockEntity, CuttingBoardRenderState state, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {

        BlockEntityRenderState.extractBase(blockEntity, state, breakProgress);
        state.item.clear();

        ItemStack stack = blockEntity.getItem(0);
        if (stack.isEmpty()) {
            return;
        }

        state.direction = blockEntity.getBlockState()
                .getValue(CuttingBoardBlock.DIRECTION);

        if (!(blockEntity.getLevel() instanceof ClientLevel level)) {
            return;
        }

        this.itemModelResolver.updateForTopItem(state.item, stack, ItemDisplayContext.NONE, level, null, 0);

        state.flat = !state.item.usesBlockLight();
        state.offset = state.flat ? 0.0625F : 0.0375F;
    }

    @Override
    public void submit(CuttingBoardRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {

        if (state.item.isEmpty()) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.1D, 0.5D);
        poseStack.scale(0.5F, 0.5F, 0.5F);
        poseStack.pushPose();

        this.setupItemRotation(poseStack, state.direction, state.flat);

        state.item.submit(poseStack, collector, state.lightCoords, 0, -1);
        poseStack.popPose();
        poseStack.translate(0.0D, state.offset, 0.0D);

        this.postDrawItem(poseStack, state.flat);
        poseStack.popPose();
    }

    private void setupItemRotation(PoseStack poseStack, Direction facing, boolean flat) {
        if (!flat) {
            return;
        }

        poseStack.mulPose(facing.getRotation());
        poseStack.mulPose(Axis.YP.rotation(Mth.PI));
    }

    private void postDrawItem(PoseStack poseStack, boolean flat) {

        if (flat) {
            poseStack.mulPose(Axis.YP.rotation(Mth.HALF_PI / 2.01F));
            return;
        }
        poseStack.scale(0.998F, 0.998F, 0.998F);
    }
}