package net.tier1234.better_deco;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.tier1234.better_deco.network.NeoForgeNetworkHandler;

@Mod(Constants.MOD_ID)
public class BetterDeco {
    public BetterDeco(IEventBus eventBus) {
        eventBus.addListener(NeoForgeNetworkHandler::registerPayloads);


    }
}
