package net.tier1234.better_deco.registries;

import net.minecraft.world.inventory.MenuType;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.screen.custom.*;

public class ModMenuTypes {


    public static final ObjectRegistries<MenuType<TecqueMenu>> TECQUE_MENU =
            ObjectRegistries.registerMenu(Constants.id("tecque_menu"), TecqueMenu::new);

    public static final ObjectRegistries<MenuType<ShelfMenu>> SHELF_MENU =
            ObjectRegistries.registerMenu(Constants.id("shelf_menu"), ShelfMenu::new);

    public static final ObjectRegistries<MenuType<OvenMenu>> OVEN_MENU =
            ObjectRegistries.registerMenu(Constants.id("oven_menu"), OvenMenu::new);

    public static final ObjectRegistries<MenuType<MicrowaveMenu>> MICROWAVE_MENU =
            ObjectRegistries.registerMenu(Constants.id("microwave_menu"), MicrowaveMenu::new);

    public static final ObjectRegistries<MenuType<FreezerMenu>> FREEZER_MENU =
            ObjectRegistries.registerMenuData(Constants.id("freezer_menu"), FreezerMenu::new);

    public static final ObjectRegistries<MenuType<WorkbenchMenu>> FURNI_WORKBENCH =
            ObjectRegistries.registerMenu(Constants.id("workbench"), WorkbenchMenu::new);

    public static void init() {}
    
}
