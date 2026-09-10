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
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.client.renderer.state.level.CameraRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.JarBlock;
import net.tier1234.better_deco.blockentity.JarBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.JarRenderState;
import org.jetbrains.annotations.Nullable;

public class JarBlockEntityRenderer implements BlockEntityRenderer<JarBlockEntity, JarRenderState> {

    private final ItemModelResolver itemModelResolver;

    public JarBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }

    @Override
    public JarRenderState createRenderState() {
        return new JarRenderState();
    }

    @Override
    public void extractRenderState(JarBlockEntity jar, JarRenderState state, float partialTick,
                                   Vec3 cameraPosition,
                                   @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {

        BlockEntityRenderState.extractBase(jar, state, breakProgress);

        state.direction = jar.getBlockState().getValue(JarBlock.DIRECTION);
        state.items.clear();
        state.offsets.clear();
        state.flat.clear();

        ItemStack stack = jar.getItem(0);
        if (stack.isEmpty()) {
            return;
        }

        if (!(jar.getLevel() instanceof ClientLevel level)) {
            return;
        }

        int count = Math.min(stack.getCount(), 16);

        for (int i = 0; i < count; i++) {
            ItemStackRenderState itemState = new ItemStackRenderState();
            this.itemModelResolver.updateForTopItem(itemState, stack, ItemDisplayContext.GROUND, level, null, i);

            if (itemState.isEmpty()) {
                continue;
            }

            boolean isFlat = !itemState.usesBlockLight();
            float offset = isFlat ? 0.06F : 0.04F;

            state.items.add(itemState);
            state.offsets.add(offset);
            state.flat.add(isFlat);
        }
    }

    @Override
    public void submit(JarRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {

        if (state.items.isEmpty()) {
            return;
        }

        poseStack.pushPose();
        poseStack.translate(0.5D, 0.15D, 0.5D);
        poseStack.scale(0.35F, 0.35F, 0.35F);

        for (int i = 0; i < state.items.size(); i++) {
            poseStack.pushPose();
            poseStack.translate(0.0D, i * state.offsets.get(i), 0.0D);

            if (Boolean.TRUE.equals(state.flat.get(i))) {
                poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
                poseStack.mulPose(Axis.ZP.rotationDegrees(state.direction.toYRot()));
            } else {
                poseStack.mulPose(Axis.YP.rotationDegrees(-state.direction.toYRot()));
            }

            state.items.get(i).submit(poseStack, collector, state.lightCoords, OverlayTexture.NO_OVERLAY, 0);

            poseStack.popPose();
        }

        poseStack.popPose();
    }
    private void setupItemRotation(PoseStack poseStack, Direction facing) {
        poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));
        poseStack.mulPose(Axis.XP.rotationDegrees(90.0F));
    }
}