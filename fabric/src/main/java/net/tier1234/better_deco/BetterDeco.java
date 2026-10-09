package net.tier1234.better_deco;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.compat.EveryCompatImpl;
import net.tier1234.better_deco.network.FabricNetworkHandler;
import net.tier1234.better_deco.registries.ModKeybinds;

public class BetterDeco implements ModInitializer {

    @Override
    public void onInitialize() {
        FabricNetworkHandler.registerPayloads();
        FabricNetworkHandler.registerServer();
        ModKeybinds.init();

        if (FabricLoader.getInstance().isModLoaded("everycomp")) {
           EveryCompatImpl.init();
        }
        ModConfigs.init();
        ObjectRegistries.createAll(Constants.MOD_ID);
    }

}
