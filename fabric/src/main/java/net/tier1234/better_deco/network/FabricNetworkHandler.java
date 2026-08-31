package net.tier1234.better_deco.network;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.tier1234.better_deco.network.message.CraftRecipePayload;
import net.tier1234.better_deco.network.message.SelectRecipePayload;
import net.tier1234.better_deco.network.message.SyncCraftableRecipesPayload;

public class FabricNetworkHandler {


    public static void registerPayloads() {
        PayloadTypeRegistry.playS2C().register(SyncCraftableRecipesPayload.TYPE, SyncCraftableRecipesPayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(CraftRecipePayload.TYPE, CraftRecipePayload.STREAM_CODEC);
        PayloadTypeRegistry.playC2S().register(SelectRecipePayload.TYPE, SelectRecipePayload.STREAM_CODEC);
    }

    public static void registerClient() {
        ClientPlayNetworking.registerGlobalReceiver(
                SyncCraftableRecipesPayload.TYPE,
                (payload, context) -> context.client().execute(
                        () -> ClientPayloadHandler.handleSyncCraftableRecipes(payload)));
    }

    public static void registerServer() {
        ServerPlayNetworking.registerGlobalReceiver(
                CraftRecipePayload.TYPE,
                (payload, context) -> context.server().execute(
                        () -> ServerPayloadHandler.handleCraftRecipe(payload, context.player())));

    ServerPlayNetworking.registerGlobalReceiver(
            SelectRecipePayload.TYPE,
            (payload, context) -> context.server().execute(
                    ()-> ServerPayloadHandler.handleSelectRecipe(payload, context.player())));

    }
}
