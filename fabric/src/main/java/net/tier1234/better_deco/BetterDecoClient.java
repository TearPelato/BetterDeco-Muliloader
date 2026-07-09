package net.tier1234.better_deco;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.tearpelato.deco_lib.core.registries.helper.ScreenRegister;
import net.tier1234.better_deco.client.ClientBootstrap;
import net.tier1234.better_deco.network.FabricNetworkHandler;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.util.CutoutRenderLayerBlocks;
import org.apache.commons.lang3.function.TriFunction;

public class BetterDecoClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientBootstrap.init();
        ClientBootstrap.registerEntityRenderers(EntityRendererRegistry::register);
        ClientBootstrap.registerBlockEntityRenderers(BlockEntityRenderers::register);
        ClientBootstrap.registerScreens(new ScreenRegister() {
            @Override
            public <T extends AbstractContainerMenu, U extends Screen & MenuAccess<T>> void apply(MenuType<T> type, TriFunction<T, Inventory, Component, U> factory) {
                MenuScreens.register(type, factory::apply);
            }
        });
        ModPackets.init(payload -> ClientPlayNetworking.send(payload));
        FabricNetworkHandler.registerClient();

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), CutoutRenderLayerBlocks.getBlocks());
    }
}
