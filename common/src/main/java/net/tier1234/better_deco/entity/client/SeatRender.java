package net.tier1234.better_deco.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceLocation;
import net.tier1234.better_deco.entity.custom.SeatEntity;

public class SeatRender extends EntityRenderer<SeatEntity> {
    public SeatRender(EntityRendererProvider.Context context) {
        super(context);
    }


    @Override
    public boolean shouldRender(SeatEntity livingEntity, Frustum camera, double camX, double camY, double camZ) {
        return true;
    }

    @Override
    public EntityRenderState createRenderState() {
        return null;
    }

}