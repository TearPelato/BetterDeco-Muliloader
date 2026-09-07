package net.tier1234.better_deco.blockentity.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.tier1234.better_deco.block.ToasterBlock;
import net.tier1234.better_deco.blockentity.ToasterBlockEntity;

public class ToasterBlockEntityRenderer implements BlockEntityRenderer<ToasterBlockEntity> {

    private static final double[] SLOT_LOCAL_X = {6.0 / 16.0, 10.0 / 16.0};
    private static final double SLOT_LOCAL_Z = 8.0 / 16.0;

    private static final double BASE_Y = 7.5 / 16.0;
    private static final double MAX_RISE = 2.0 / 16.0;
    private static final float ITEM_SCALE = 0.5f;

    private final ItemRenderer itemRenderer;

    public ToasterBlockEntityRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    @Override
    public void render(ToasterBlockEntity toaster, float partialTick, PoseStack poseStack,
                       MultiBufferSource buffer, int packedLight, int packedOverlay) {

        BlockState state = toaster.getBlockState();
        if (!(state.getBlock() instanceof ToasterBlock)) {
            return;
        }

        Direction facing = state.getValue(ToasterBlock.DIRECTION);

        for (int slot = 0; slot < ToasterBlockEntity.SLOTS; slot++) {
            ItemStack stack = toaster.getItem(slot);
            if (stack.isEmpty()) {
                continue;
            }

            poseStack.pushPose();

            double localX = SLOT_LOCAL_X[slot] - 0.5;
            double localZ = SLOT_LOCAL_Z - 0.5;
            double[] rotated = rotateForFacing(localX, localZ, facing);

            float progress = toaster.getProgress(slot); // 0.0 -> 1.0, già presente nel BE
            double rise = MAX_RISE * progress;

            poseStack.translate(0.5 + rotated[0], BASE_Y + rise, 0.5 + rotated[1]);
            poseStack.mulPose(Axis.YP.rotationDegrees(facing.toYRot()));
            poseStack.scale(ITEM_SCALE, ITEM_SCALE, ITEM_SCALE);

            itemRenderer.renderStatic(stack, ItemDisplayContext.FIXED, packedLight, packedOverlay, poseStack, buffer, toaster.getLevel(), (int) toaster.getBlockPos().asLong());

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
    public boolean shouldRenderOffScreen(ToasterBlockEntity blockEntity) {
        return false;
    }

    @Override
    public int getViewDistance() {
        return 32;
    }
}

/*
 * ---- Aggiunta opzionale a ToasterBlockEntity.java ----
 * Utile per GUI/renderer/altri controlli, il limite di 2 item è già
 * garantito da SLOTS = 2 e dal loop in insertItem(), quindi qui servono
 * solo dei metodi di comodo, non una nuova logica:
 *
 * public boolean isFull() {
 *     return !items.get(0).isEmpty() && !items.get(1).isEmpty();
 * }
 *
 * public static int getSlotCount() {
 *     return SLOTS;
 * }
 */