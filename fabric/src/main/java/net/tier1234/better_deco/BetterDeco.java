package net.tier1234.better_deco;

import com.mrcrayfish.framework.FrameworkSetup;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.tier1234.better_deco.compat.everycomp.FabricEveryCompatModule;
import net.tier1234.better_deco.network.FabricNetworkHandler;
import net.tier1234.better_deco.registries.ModKeybinds;

public class BetterDeco implements ModInitializer {

    @Override
    public void onInitialize() {
        FrameworkSetup.run();
        FabricNetworkHandler.registerPayloads();
        FabricNetworkHandler.registerServer();
        ModKeybinds.init();

        if (FabricLoader.getInstance().isModLoaded("everycomp")) {
            EveryCompatAPI.registerModule(new FabricEveryCompatModule());
            FabricEveryCompatModule.register();
        }

    }

}
