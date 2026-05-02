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
            RegistryEntry.menuType(Constants.id("tecque_menu"),
                    (id, inv)-> new TecqueMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<PedestalMenu>> PEDESTAL_MENU =
            RegistryEntry.menuType(Constants.id("pedestal_menu"),
                    (id,inv)-> new PedestalMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<CrateMenu>> CRATE_MENU =
            RegistryEntry.menuType(Constants.id("crate_menu"),
                    (id,inv)-> new CrateMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<ShelfMenu>> SHELF_MENU =
            RegistryEntry.menuType(Constants.id("shelf_menu"),
                    (id,inv)-> new ShelfMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<OvenMenu>> OVEN_MENU =
            RegistryEntry.menuType(Constants.id("oven_menu"),
                    (id,inv)-> new OvenMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<MicrowaveMenu>> MICROWAVE_MENU =
            RegistryEntry.menuType(Constants.id("microwave_menu"),
                    (id,inv)-> new MicrowaveMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<SinkMenu>> SINK_MENU =
            RegistryEntry.menuType(Constants.id("sink_menu"),
                    (id,inv)-> new SinkMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<FreezerMenu>> FREEZER_MENU =
            RegistryEntry.menuType(Constants.id("freezer_menu"),
                    (id,inv)-> new FreezerMenu(id, inv, (FriendlyByteBuf) null));

    public static final RegistryEntry<MenuType<FurniWorkbenchMenu>> FURNI_WORKBENCH =
            RegistryEntry.menuType(Constants.id("workbench"),
                    (id,inv)-> new FurniWorkbenchMenu(id, inv, (FriendlyByteBuf) null));

    
}
