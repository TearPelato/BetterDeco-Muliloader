package net.tier1234.better_deco;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.tearpelato.deco_lib.core.registries.helper.ScreenRegister;
import net.tier1234.better_deco.block.custom.ToiletBlock;
import net.tier1234.better_deco.client.ClientBootstrap;
import net.tier1234.better_deco.entity.custom.SeatEntity;
import net.tier1234.better_deco.registries.ModKeybinds;
import net.tier1234.better_deco.registries.ModSounds;
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

    @SubscribeEvent
    public static void registerKeybinding(RegisterKeyMappingsEvent event){
        event.register(ModKeybinds.PRESS_G.get());
    }

    @SubscribeEvent
    public static void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        LocalPlayer player = mc.player;

        if (player != null && ModKeybinds.KEY_MAPPING_G.consumeClick()) {
            Entity vehicle = player.getVehicle();
            if (vehicle instanceof SeatEntity seat) {
                BlockPos seatPos = seat.blockPosition();
                Level level = player.level();

                if (level.getBlockState(seatPos).getBlock() instanceof ToiletBlock) {
                    player.playSound(ModSounds.FART.get(), 0.5f, 1.0f);
                }
            }
        }
    }
}
