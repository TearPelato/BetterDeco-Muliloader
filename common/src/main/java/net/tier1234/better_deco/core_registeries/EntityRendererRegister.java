package net.tier1234.better_deco.core_registeries;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

/**
 * Author: MrCrayfish
 */
@Deprecated(forRemoval = true)
@FunctionalInterface
public interface EntityRendererRegister
{
    <E extends Entity> void apply(EntityType<? extends E> entityType, EntityRendererProvider<E> entityRendererFactory);
}