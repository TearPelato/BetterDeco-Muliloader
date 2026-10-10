package net.tier1234.better_deco;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.compat.EveryCompatImpl;
import net.tier1234.better_deco.network.FabricNetworkHandler;
import net.tier1234.better_deco.registries.*;

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
        ModKeybinds.init();

        if (FabricLoader.getInstance().isModLoaded("everycomp")) {
           EveryCompatImpl.init();
        }
    }

}
