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
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.JarBlock;
import net.tier1234.better_deco.blockentity.JarBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.JarRenderState;
import org.jetbrains.annotations.Nullable;
import org.joml.AxisAngle4f;

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
    public void extractRenderState(JarBlockEntity jar, JarRenderState state, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {

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

        int count = stack.getCount();

        for (int i = 0; i < count; i++) {
            ItemStackRenderState itemState = new ItemStackRenderState();

            this.itemModelResolver.updateForTopItem(itemState, stack, ItemDisplayContext.NONE, level, null, i);

            if (itemState.isEmpty()) {
                continue;
            }


            boolean isFlat = !itemState.usesBlockLight();
            float offset = isFlat ? 0.0625F : 0.0375F;
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

        poseStack.translate(0.5D, 0.1D, 0.5D);
        poseStack.scale(0.499F, 0.499F, 0.499F);

        for (int i = 0; i < state.items.size(); i++) {
            poseStack.pushPose();
            float offset = state.offsets.get(i);
            poseStack.translate(0.0D, i * offset, 0.0D);

            if (state.flat.get(i)) {
                setupItemRotation(poseStack, state.direction);
            }

            state.items.get(i).submit(poseStack, collector, state.lightCoords, 0, -1);
            poseStack.popPose();
        }

        poseStack.popPose();
    }

    private void setupItemRotation(PoseStack poseStack, Direction facing) {
        poseStack.mulPose(facing.getRotation());
        poseStack.mulPose(Axis.YP.rotation(Mth.PI));
    }
}