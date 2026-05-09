package net.tier1234.better_deco.init;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.inventory.MenuType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.screen.custom.*;

@RegistryContainer
public class ModMenuTypes {


    public static final RegistryEntry<MenuType<TecqueMenu>> TECQUE_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("tecque_menu"),
                    TecqueMenu.TecqueData.CODEC, TecqueMenu::new);

    public static final RegistryEntry<MenuType<PedestalMenu>> PEDESTAL_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("pedestal_menu"), PedestalMenu.CustomData.CODEC, PedestalMenu::new);

    public static final RegistryEntry<MenuType<CrateMenu>> CRATE_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("crate_menu"), CrateMenu.CustomData.CODEC, CrateMenu::new);

    public static final RegistryEntry<MenuType<ShelfMenu>> SHELF_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("shelf_menu"), ShelfMenu.CustomData.CODEC, ShelfMenu::new);

    public static final RegistryEntry<MenuType<OvenMenu>> OVEN_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("oven_menu"), OvenMenu.CustomData.CODEC, OvenMenu::new);

    public static final RegistryEntry<MenuType<MicrowaveMenu>> MICROWAVE_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("microwave_menu"), MicrowaveMenu.CustomData.CODEC, MicrowaveMenu::new);

    public static final RegistryEntry<MenuType<SinkMenu>> SINK_MENU =
            RegistryEntry.menuType(Constants.id("sink_menu"),
                    (id,inv)-> new SinkMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<FreezerMenu>> FREEZER_MENU =
            RegistryEntry.menuType(Constants.id("freezer_menu"),
                    (id,inv)-> new FreezerMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<FurniWorkbenchMenu>> FURNI_WORKBENCH =
            RegistryEntry.menuTypeWithData(Constants.id("workbench"), FurniWorkbenchMenu.CustomData.STREAM_CODEC, FurniWorkbenchMenu::new);

    
}
