package net.tier1234.better_deco.entity.client;

import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.tier1234.better_deco.entity.custom.SeatEntity;

public class SeatRender extends EntityRenderer<SeatEntity> {
    public SeatRender(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(SeatEntity chairEntity) {
        return null;
    }

    @Override
    public boolean shouldRender(SeatEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }
}