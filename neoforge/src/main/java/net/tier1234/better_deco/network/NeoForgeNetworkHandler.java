package net.tier1234.better_deco.network;

import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.network.message.*;

public class NeoForgeNetworkHandler {

    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        PayloadRegistrar registrar = event.registrar(Constants.MOD_ID);

        registrar.playToClient(
                SyncCraftableRecipesPayload.TYPE,
                SyncCraftableRecipesPayload.STREAM_CODEC,
                (payload, context) -> context.enqueueWork(
                        () -> ClientPayloadHandler.handleSyncCraftableRecipes(payload)));

        registrar.playToClient(
                SyncWorkbenchRecipesPayload.TYPE,
                SyncWorkbenchRecipesPayload.STREAM_CODEC,
                (payload, context) -> context.enqueueWork(
                        () -> ClientPayloadHandler.handleSyncWorkbenchRecipes(payload)));


        registrar.playToServer(
                CraftRecipePayload.TYPE,
                CraftRecipePayload.STREAM_CODEC,
                (payload, context) -> context.enqueueWork(
                        () -> ServerPayloadHandler.handleCraftRecipe(payload, (ServerPlayer) context.player())));

        registrar.playToServer(
                SelectRecipePayload.TYPE,
                SelectRecipePayload.STREAM_CODEC,
                (payload,context)-> context.enqueueWork(
                        () -> ServerPayloadHandler.handleSelectRecipe(payload, (ServerPlayer) context.player())));
    }
}