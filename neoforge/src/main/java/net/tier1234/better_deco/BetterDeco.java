package net.tier1234.better_deco;

import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.PacketDistributor;
import net.tier1234.better_deco.compat.everycomp.CommonEveryCompatModule;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.network.NeoForgeNetworkHandler;
import net.tier1234.better_deco.registries.ModKeybinds;

@Mod(Constants.MOD_ID)
public class BetterDeco {
    public BetterDeco(IEventBus eventBus) {
        ModPackets.init(payload -> PacketDistributor.sendToServer(payload));
        eventBus.addListener(NeoForgeNetworkHandler::registerPayloads);
        ModKeybinds.init();

        if(ModList.get().isLoaded("everycomp")) {
            EveryCompatAPI.registerModule(new CommonEveryCompatModule());
        }

    }
}
