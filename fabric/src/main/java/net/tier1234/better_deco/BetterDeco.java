package net.tier1234.better_deco;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.network.FabricNetworkHandler;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.network.message.SyncWorkbenchRecipesPayload;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.registries.*;

import java.util.List;

public class BetterDeco implements ModInitializer {

    @Override
    public void onInitialize() {
        ModBlocks.init();
        ModItems.init();
        ModCreativeTabs.init();

        ModBlockEntities.init();
        ModEntities.init();
        ModMenuTypes.init();
        ModSounds.init();
        ModRecipes.init();
        ModConfigs.init();

        ObjectRegistries.createAll(Constants.MOD_ID);
        
        FabricNetworkHandler.registerPayloads();
        FabricNetworkHandler.registerServer();

        ServerLifecycleEvents.SYNC_DATA_PACK_CONTENTS.register((player,joined)-> {
            List<RecipeHolder<WorkbenchRecipe>> recipes = List.copyOf(player.level().getServer().getRecipeManager().recipes
                    .byType(ModRecipes.WORKBENCH_TYPE.get()));

            List<ItemStack> results = recipes.stream()
                    .map(holder -> holder.value().getResultItem(player.level().registryAccess()))
                    .toList();

            ModPackets.sendToClient(player, new SyncWorkbenchRecipesPayload(recipes.size(),results,recipes));

        });

    }

}
