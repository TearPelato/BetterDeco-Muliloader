package net.tier1234.better_deco.client;

import net.tearpelato.deco_lib.core.registries.helper.BlockEntityRendererRegister;
import net.tearpelato.deco_lib.core.registries.helper.EntityRendererRegister;
import net.tearpelato.deco_lib.core.registries.helper.ScreenRegister;
import net.tier1234.better_deco.blockentity.renderer.*;
import net.tier1234.better_deco.creative_tabs.BundledTabSelector;
import net.tier1234.better_deco.entity.client.SeatRender;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.registries.ModEntities;
import net.tier1234.better_deco.registries.ModMenuTypes;
import net.tier1234.better_deco.screen.custom.*;

/**
 * @author  MrCrayfish
 * */
public class ClientBootstrap {

    public static void init() {
        BundledTabSelector.bootstrap();

    }

    public static void registerEntityRenderers(EntityRendererRegister register)
    {
        register.apply(ModEntities.SEAT_ENTITY.get(), SeatRender::new);
    }

    public static void registerScreens(ScreenRegister register)
    {
        register.apply(ModMenuTypes.CRATE_MENU.get(), CrateScreen::new);
        register.apply(ModMenuTypes.PEDESTAL_MENU.get(), PedestalScreen::new);
        register.apply(ModMenuTypes.TECQUE_MENU.get(), TecqueScreen::new);
        register.apply(ModMenuTypes.FURNI_WORKBENCH.get(), FurniWorkbenchScreen::new);
        register.apply(ModMenuTypes.SHELF_MENU.get(), ShelfScreen::new);
        register.apply(ModMenuTypes.MICROWAVE_MENU.get(), MicrowaveScreen::new);
        register.apply(ModMenuTypes.OVEN_MENU.get(), OvenScreen::new);
        register.apply(ModMenuTypes.FREEZER_MENU.get(), FreezerScreen::new);

    }

    public static void registerBlockEntityRenderers(BlockEntityRendererRegister register)
    {
        register.apply(ModBlockEntities.GLASS_TECQUE.get(), TecqueBlockEntityRenderer::new);
        register.apply(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
        register.apply(ModBlockEntities.KITCHEN_SINK.get(), KitchenSinkBlockEntityRenderer::new);
        register.apply(ModBlockEntities.SHELF_BE.get(), ShelfBlockEntityRenderer::new);
        register.apply(ModBlockEntities.DIGITAL_CLOCK.get(), DigitalClockBlockEntityRenderer::new);
        register.apply(ModBlockEntities.MICROWAVE.get(), MicrowaveBlockEntityRenderer::new);
        register.apply(ModBlockEntities.CUTTING_BOARD.get(), CuttingBoardBlockEntityRenderer::new);
        register.apply(ModBlockEntities.JAR.get(), JarBlockEntityRenderer::new);
        register.apply(ModBlockEntities.BASIN.get(), BasinBlockEntityRenderer::new);
        register.apply(ModBlockEntities.TOILET.get(), ToiletBlockEntityRenderer::new);
        register.apply(ModBlockEntities.BATH.get(), BathBlockEntityRenderer::new);
    }
}
