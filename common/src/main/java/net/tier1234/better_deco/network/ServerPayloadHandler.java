package net.tier1234.better_deco.network;

import net.minecraft.server.level.ServerPlayer;
import net.tier1234.better_deco.network.message.CraftRecipePayload;
import net.tier1234.better_deco.network.message.SelectRecipePayload;
import net.tier1234.better_deco.screen.custom.WorkbenchMenu;

public class ServerPayloadHandler {
    public static void handleCraftRecipe(CraftRecipePayload payload, ServerPlayer serverPlayer) {
        if (serverPlayer.containerMenu instanceof WorkbenchMenu menu &&
                menu.containerId == payload.containerId()) {
            menu.craftSelectedRecipe(payload.recipeIndex());
        }
    }

    public static void handleSelectRecipe(SelectRecipePayload payload, ServerPlayer serverPlayer) {
        if (serverPlayer.containerMenu instanceof WorkbenchMenu menu &&
                menu.containerId == payload.containerId()) {
            menu.selectRecipe(payload.recipeIndex(), payload.amountDelta());
        }
    }

}