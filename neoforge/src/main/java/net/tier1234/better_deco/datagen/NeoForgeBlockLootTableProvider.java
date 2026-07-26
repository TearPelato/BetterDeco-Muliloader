package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.registries.ModBlocks;

import java.util.stream.Collectors;

public class NeoForgeBlockLootTableProvider extends CommonBlockLootTableProvider {
    public NeoForgeBlockLootTableProvider(HolderLookup.Provider registries) {
        super(registries);
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.stream()
                .map(entry-> (Block) entry.get())
                .collect(Collectors.toList());
    }
}
