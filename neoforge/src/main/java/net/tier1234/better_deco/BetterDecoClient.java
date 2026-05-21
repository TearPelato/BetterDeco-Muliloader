package net.tier1234.better_deco;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.tearpelato.deco_lib.core.registries.helper.ScreenRegister;
import net.tier1234.better_deco.client.ClientBootstrap;
import org.apache.commons.lang3.function.TriFunction;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class BetterDecoClient {


    @SubscribeEvent
    private static void onClientSetupEvent(FMLClientSetupEvent event) {
        event.enqueueWork(ClientBootstrap::init);
    }



    /**@author MrCrayfish */
    @SubscribeEvent
    private static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event)
    {
        ClientBootstrap.registerEntityRenderers(event::registerEntityRenderer);
        ClientBootstrap.registerBlockEntityRenderers(event::registerBlockEntityRenderer);
    }


    @SubscribeEvent
    private static void onRegisterMenuScreens(RegisterMenuScreensEvent event)
    {
        ClientBootstrap.registerScreens(new ScreenRegister() {
            @Override
            public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void apply(MenuType<T> type, TriFunction<T, Inventory, Component, U> factory) {
                event.register(type, factory::apply);
            }
        });
    }
}
