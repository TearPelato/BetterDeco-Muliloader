package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.inventory.MenuType;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.screen.custom.*;

@RegistryContainer
public class ModMenuTypes {


    public static final RegistryEntry<MenuType<TecqueMenu>> TECQUE_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("tecque_menu"),
                    TecqueMenu.TecqueData.CODEC, TecqueMenu::new);

    public static final RegistryEntry<MenuType<CrateMenu>> CRATE_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("crate_menu"), CrateMenu.CustomData.CODEC, CrateMenu::new);

    public static final RegistryEntry<MenuType<ShelfMenu>> SHELF_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("shelf_menu"), ShelfMenu.CustomData.CODEC, ShelfMenu::new);

    public static final RegistryEntry<MenuType<OvenMenu>> OVEN_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("oven_menu"), OvenMenu.CustomData.CODEC, OvenMenu::new);

    public static final RegistryEntry<MenuType<MicrowaveMenu>> MICROWAVE_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("microwave_menu"), MicrowaveMenu.CustomData.CODEC, MicrowaveMenu::new);

    public static final RegistryEntry<MenuType<FreezerMenu>> FREEZER_MENU =
            RegistryEntry.menuTypeWithData(Constants.id("freezer_menu"), FreezerMenu.FreezerData.CODEC, FreezerMenu::new);

    public static final RegistryEntry<MenuType<WorkbenchMenu>> FURNI_WORKBENCH =
            RegistryEntry.menuTypeWithData(Constants.id("workbench"), WorkbenchMenu.CustomData.STREAM_CODEC, WorkbenchMenu::new);

    
}
