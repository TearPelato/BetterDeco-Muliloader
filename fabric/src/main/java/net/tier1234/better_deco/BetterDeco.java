package net.tier1234.better_deco;

import com.mrcrayfish.framework.FrameworkSetup;
import net.fabricmc.api.ModInitializer;
import net.tier1234.better_deco.network.FabricNetworkHandler;

public class BetterDeco implements ModInitializer {

    @Override
    public void onInitialize() {
        FrameworkSetup.run();
        FabricNetworkHandler.registerPayloads();
    }

}
