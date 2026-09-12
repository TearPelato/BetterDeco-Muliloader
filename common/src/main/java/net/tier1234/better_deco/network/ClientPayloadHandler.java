package net.tier1234.better_deco.network;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import net.tier1234.better_deco.network.message.SyncCraftableRecipesPayload;
import net.tier1234.better_deco.network.message.SyncWorkbenchRecipesPayload;
import net.tier1234.better_deco.screen.custom.WorkbenchMenu;
import net.tier1234.better_deco.screen.custom.WorkbenchScreen;
import net.tier1234.better_deco.util.ClientRecipes;

public class ClientPayloadHandler {

    public static void handleSyncCraftableRecipes(SyncCraftableRecipesPayload payload) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        mc.execute(() -> {
            if (player == null) return;

            if (player.containerMenu instanceof WorkbenchMenu menu
                    && menu.containerId == payload.containerId()) {
                menu.setCraftableRecipes(payload.craftable());

                if (mc.gui.screen() instanceof WorkbenchScreen screen) {
                    screen.updateRecipeButtons();
                }
            }
        });
    }

    public static void handleSyncWorkbenchRecipes(SyncWorkbenchRecipesPayload payload) {
        Minecraft mc = Minecraft.getInstance();
        mc.execute(() -> {
            if (mc.player == null) return;

            ClientRecipes.get().ifPresent(clientRecipes -> clientRecipes.accept(payload.recipes()));

            if (mc.player.containerMenu instanceof WorkbenchMenu menu
                    && menu.containerId == payload.containerId()) {

                menu.setClientRecipes(payload.results());

                if (mc.gui.screen() instanceof WorkbenchScreen screen) {
                    screen.updateRecipeButtons();
                }
            }
        });
    }
}