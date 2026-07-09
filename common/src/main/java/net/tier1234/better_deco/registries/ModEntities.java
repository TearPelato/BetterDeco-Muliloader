package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.entity.custom.SeatEntity;

@RegistryContainer
public class ModEntities {

    public static final RegistryEntry<EntityType<SeatEntity>> SEAT_ENTITY = RegistryEntry.entityType(Constants.id("seat_entity"),
            ()-> EntityType.Builder.of(SeatEntity::new, MobCategory.MISC).sized(0.5f,0.5f).build("seat_entity"));
}
