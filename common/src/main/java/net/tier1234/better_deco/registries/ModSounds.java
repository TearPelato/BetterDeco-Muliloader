package net.tier1234.better_deco.registries;

import net.minecraft.sounds.SoundEvent;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;

public class ModSounds {

    public static final ObjectRegistries<SoundEvent> FART = ObjectRegistries.registerSound(Constants.id("fart"),
            ()-> SoundEvent.createVariableRangeEvent(Constants.id("")));
    public static void init() {}
}
