package net.tier1234.better_deco.platform.services;

import net.minecraft.network.protocol.common.custom.CustomPacketPayload;

public interface INetworkHelper {
    void sendToServer(CustomPacketPayload payload);
}