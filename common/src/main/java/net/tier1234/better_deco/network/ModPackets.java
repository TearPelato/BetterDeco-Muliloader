package net.tier1234.better_deco.network;

import net.minecraft.network.protocol.common.ClientboundCustomPayloadPacket;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.tier1234.better_deco.platform.services.INetworkHelper;

public class ModPackets {
    private static INetworkHelper INSTANCE;

    public static void init(INetworkHelper helper) {
        INSTANCE = helper;
    }

    public static void sendToClient(ServerPlayer player, CustomPacketPayload payload) {
        player.connection.send(new ClientboundCustomPayloadPacket(payload));
    }

    public static void sendToServer(CustomPacketPayload payload) {
        if (INSTANCE == null) throw new IllegalStateException("ModPackets not initialized!");
        INSTANCE.sendToServer(payload);
    }
}