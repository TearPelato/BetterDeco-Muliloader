package net.tier1234.better_deco.network;

import net.minecraft.server.level.ServerPlayer;
import net.tier1234.better_deco.network.message.CraftRecipePayload;
import net.tier1234.better_deco.screen.custom.FurniWorkbenchMenu;

public class ServerPayloadHandler {
    public static void handleCraftRecipe(CraftRecipePayload payload, ServerPlayer serverPlayer) {
        if (serverPlayer.containerMenu instanceof FurniWorkbenchMenu menu &&
                menu.containerId == payload.containerId()) {
            menu.craftSelectedRecipe(payload.recipeIndex());
        }
    }
}