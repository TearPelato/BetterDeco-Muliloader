package net.tier1234.better_deco.datagen;

import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class CommonDataPackProvider {
    public static final RegistrySetBuilder RELOADABLE = new RegistrySetBuilder()
            .add(CommonRecipeProvider.create())
            .add(Registries.ADVANCEMENT,CommonAdvancementsProvider::new)
            .add(Registries.LOOT_TABLE, new LootTableProvider(Set.of(), List.of(
                    new LootTableProvider.SubProviderEntry(CommonBlockLooTableProvider::new, LootContextParamSets.BLOCK)

            )));


}
