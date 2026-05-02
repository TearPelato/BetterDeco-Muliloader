package net.tier1234.better_deco.platform;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.tier1234.better_deco.platform.services.INetworkHelper;

public class FabricNetworkHelper implements INetworkHelper {
    @Override
    public void sendToServer(CustomPacketPayload payload) {
        ClientPlayNetworking.send(payload);
    }
}
