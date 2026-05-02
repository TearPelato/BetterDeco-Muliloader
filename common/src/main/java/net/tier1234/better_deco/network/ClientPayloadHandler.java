package net.tier1234.better_deco.network;

import net.minecraft.client.Minecraft;
import net.tier1234.better_deco.network.message.SyncCraftableRecipesPayload;
import net.tier1234.better_deco.screen.custom.FurniWorkbenchMenu;
import net.tier1234.better_deco.screen.custom.FurniWorkbenchScreen;

public class ClientPayloadHandler {

    public static void handleSyncCraftableRecipes(SyncCraftableRecipesPayload payload) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        if (mc.player.containerMenu instanceof FurniWorkbenchMenu menu &&
                menu.containerId == payload.containerId()) {
            menu.setCraftableRecipes(payload.craftable());
            if (mc.screen instanceof FurniWorkbenchScreen screen) {
                screen.updateRecipeButtons();
            }
        }
    }
}