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
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.tier1234.better_deco.block.ToasterBlock;
import net.tier1234.better_deco.blockentity.ToasterBlockEntity;
import net.tier1234.better_deco.blockentity.renderer.render_state.ToasterRenderState;
import org.jetbrains.annotations.Nullable;

public class ToasterBlockEntityRenderer implements BlockEntityRenderer<ToasterBlockEntity, ToasterRenderState> {

    private static final double SLOT_LOCAL_X = 0.0;
    private static final double[] SLOT_LOCAL_Z = {-0.125, 0.125};

    private static final double ITEM_Y = 7.2 / 16.0;
    private static final float ITEM_SCALE = 0.5F;

    private final ItemModelResolver itemModelResolver;

    public ToasterBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemModelResolver = context.itemModelResolver();
    }


    @Override
    public ToasterRenderState createRenderState() {
        return new ToasterRenderState();
    }

    @Override
    public void extractRenderState(ToasterBlockEntity toaster, ToasterRenderState state, float partialTick, Vec3 cameraPosition, @Nullable ModelFeatureRenderer.CrumblingOverlay breakProgress) {

        BlockEntityRenderState.extractBase(toaster, state, breakProgress);

        BlockState blockState = toaster.getBlockState();

        if (!(blockState.getBlock() instanceof ToasterBlock)) {
            for (ItemStackRenderState item : state.items) {
                item.clear();
            }
            return;
        }

        state.facing = blockState.getValue(ToasterBlock.DIRECTION);

        if (!(toaster.getLevel() instanceof ClientLevel level)) {
            return;
        }

        for (int slot = 0; slot < ToasterBlockEntity.SLOTS; slot++) {
            ItemStack stack = toaster.getItem(slot);

            state.items[slot].clear();

            if (stack.isEmpty()) {
                continue;
            }

            this.itemModelResolver.updateForTopItem(state.items[slot], stack, ItemDisplayContext.FIXED, level, null, (int) toaster.getBlockPos().asLong() + slot);
        }
    }

    @Override
    public void submit(ToasterRenderState state, PoseStack poseStack, SubmitNodeCollector collector, CameraRenderState camera) {

        for (int slot = 0; slot < ToasterBlockEntity.SLOTS; slot++) {
            ItemStackRenderState item = state.items[slot];

            if (item.isEmpty()) {
                continue;
            }

            poseStack.pushPose();
            double[] rotated = rotateForFacing(SLOT_LOCAL_X, SLOT_LOCAL_Z[slot], state.facing);

            poseStack.translate(0.5D + rotated[0], ITEM_Y, 0.5D + rotated[1]);
            poseStack.mulPose(Axis.YP.rotationDegrees(state.facing.toYRot()));
            poseStack.scale(ITEM_SCALE, ITEM_SCALE, ITEM_SCALE);

            item.submit(poseStack, collector, state.lightCoords, 0, -1);
            poseStack.popPose();
        }
    }

    private static double[] rotateForFacing(double x, double z, Direction facing) {
        return switch (facing) {
            case NORTH -> new double[]{x, z};
            case SOUTH -> new double[]{-x, -z};
            case WEST -> new double[]{-z, x};
            case EAST -> new double[]{z, -x};
            default -> new double[]{x, z};
        };
    }

    @Override
    public boolean shouldRenderOffScreen() {
        return true;
    }

    @Override
    public int getViewDistance() {
        return 32;
    }
}