package net.tier1234.better_deco.client;

import net.tier1234.better_deco.core_registeries.EntityRendererRegister;
import net.tier1234.better_deco.entities.client.SeatRender;
import net.tier1234.better_deco.init.ModEntities;

/**
 * @author  MrCrayfish
 * */
public class ClientBootstrap {

    public void init() {

    }

    public static void registerEntityRenderers(EntityRendererRegister register)
    {
        register.apply(ModEntities.SEAT_ENTITY.get(), SeatRender::new);
    }
}
