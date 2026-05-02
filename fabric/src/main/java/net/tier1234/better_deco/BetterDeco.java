package net.tier1234.better_deco;

import com.mrcrayfish.framework.FrameworkSetup;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tier1234.better_deco.client.ClientBootstrap;
import net.tier1234.better_deco.datagen.CommonBlockTagProvider;
import net.tier1234.better_deco.datagen.CommonRecipeProvider;
import net.tier1234.better_deco.datagen.FabricBlockStateProvider;
import net.tier1234.better_deco.network.FabricNetworkHandler;

public class BetterDeco implements ModInitializer, ClientModInitializer, DataGeneratorEntrypoint {

    @Override
    public void onInitialize() {
        FrameworkSetup.run();
        FabricNetworkHandler.registerPayloads();
    }

    @Override
    public void onInitializeClient() {
        ClientBootstrap.init();
        ClientBootstrap.registerEntityRenderers(EntityRendererRegistry::register);
    }

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(CommonRecipeProvider::new);
        pack.addProvider(CommonBlockTagProvider::new);
        FabricDataGenerator.Pack.Factory<FabricBlockStateProvider> factory =
                FabricBlockStateProvider::new;
        pack.addProvider(factory);

    }
}
