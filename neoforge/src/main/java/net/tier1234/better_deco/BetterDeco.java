package net.tier1234.better_deco;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.PacketDistributor;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.network.NeoForgeNetworkHandler;

@Mod(Constants.MOD_ID)
public class BetterDeco {
    public BetterDeco(IEventBus eventBus) {
        ModPackets.init(payload -> PacketDistributor.sendToServer(payload));
        eventBus.addListener(NeoForgeNetworkHandler::registerPayloads);


    }
}
