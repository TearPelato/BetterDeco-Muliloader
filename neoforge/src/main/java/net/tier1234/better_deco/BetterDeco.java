package net.tier1234.better_deco;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.registries.RegisterEvent;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.network.NeoForgeNetworkHandler;
import net.tier1234.better_deco.registries.*;

@Mod(Constants.MOD_ID)
public class BetterDeco {
    public BetterDeco(IEventBus eventBus) {
      //  ModPackets.init(payload -> PacketDistributor.sendToAllPlayers(payload));
        eventBus.addListener(NeoForgeNetworkHandler::registerPayloads);
        ModKeybinds.init();
        ModBlocks.init();
        ModItems.init();
        ModCreativeTabs.init();

        ModBlockEntities.init();
        ModEntities.init();
        ModMenuTypes.init();
        ModSounds.init();
        ModRecipes.init();
        ModConfigs.init();

        eventBus.addListener(this::register);


    }


    public void register(RegisterEvent event) {
        ObjectRegistries.createAll(Constants.MOD_ID,event.getRegistry());
    }
}
