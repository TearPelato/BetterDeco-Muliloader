package net.tier1234.better_deco.platform;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.neoforged.neoforge.network.PacketDistributor;
import net.tier1234.better_deco.platform.services.INetworkHelper;

public class NeoForgeNetworkHelper implements INetworkHelper {
    @Override
    public void sendToServer(CustomPacketPayload payload) {
        PacketDistributor.sendToServer(payload);
    }
}
