package net.tier1234.better_deco.registries;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.entity.custom.SeatEntity;

public class ModEntities {

    public static final ResourceKey<EntityType<?>> SEAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE, Constants.id("seat_entity_key"));

    public static final ObjectRegistries<EntityType<SeatEntity>> SEAT_ENTITY = ObjectRegistries.registerEntity(Constants.id("seat_entity"),
            ()-> EntityType.Builder.<SeatEntity>of(((entityType, level) -> new SeatEntity(level)), MobCategory.MISC).sized(0.5f,0.5f).build(SEAT_KEY));

    public static void init() {}

}
