package net.tier1234.better_deco.registries;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.entity.custom.SeatEntity;

public class ModEntities {

    public static final ObjectRegistries<EntityType<SeatEntity>> SEAT_ENTITY = ObjectRegistries.registerEntity(Constants.id("seat_entity"),
            ()-> EntityType.Builder.<SeatEntity>of(((entityType, level) -> new SeatEntity(level)), MobCategory.MISC).sized(0.5f,0.5f).build("seat_entity"));

    public static void init() {}

}
