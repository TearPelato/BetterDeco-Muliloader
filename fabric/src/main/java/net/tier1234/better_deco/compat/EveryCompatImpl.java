package net.tier1234.better_deco.compat;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mehvahdjukaar.every_compat.api.EveryCompatAPI;
import net.tier1234.better_deco.compat.everycomp.CommonEveryCompatModule;

public class EveryCompatImpl {
    public static void init() {
        EveryCompatAPI.registerModule(new CommonEveryCompatModule());
        CommonEveryCompatModule.EveryCompatCreativeTabRegister.register();
        ItemGroupEvents.MODIFY_ENTRIES_ALL.register((helper, event) ->
                CommonEveryCompatModule.EveryCompatCreativeTabRegister.register());
    }
}
