package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.sounds.SoundEvent;
import net.tier1234.better_deco.Constants;

@RegistryContainer
public class ModSounds {

    public static final RegistryEntry<SoundEvent> FART = RegistryEntry.soundEvent(Constants.id("fart"),
            id-> ()-> SoundEvent.createVariableRangeEvent(id));
}
