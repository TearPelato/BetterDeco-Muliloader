package net.tier1234.better_deco;

import com.mrcrayfish.framework.FrameworkSetup;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.tier1234.better_deco.client.ClientBootstrap;

public class BetterDeco implements ModInitializer, ClientModInitializer {

    @Override
    public void onInitialize() {
        FrameworkSetup.run();
    }

    @Override
    public void onInitializeClient() {
        ClientBootstrap.registerEntityRenderers(EntityRendererRegistry::register);
    }
}
