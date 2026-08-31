package net.tier1234.better_deco.network;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.network.message.CraftRecipePayload;
import net.tier1234.better_deco.network.message.SelectRecipePayload;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.screen.custom.WorkbenchMenu;

import java.util.List;

public class ServerPayloadHandler {
    public static void handleCraftRecipe(CraftRecipePayload payload, ServerPlayer serverPlayer) {
        if (serverPlayer.containerMenu instanceof WorkbenchMenu menu && menu.containerId == payload.containerId()) {
            List<RecipeHolder<WorkbenchRecipe>> recipes = menu.recipes;
            menu.craft(recipes.get(payload.recipeIndex()));
        }
    }

    public static void handleSelectRecipe(SelectRecipePayload payload, ServerPlayer serverPlayer) {
        if (serverPlayer.containerMenu instanceof WorkbenchMenu menu &&
                menu.containerId == payload.containerId()) {
            menu.selectRecipe(payload.recipeIndex());
        }
    }

}