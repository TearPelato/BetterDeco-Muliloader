package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.IntrinsicHolderTagsProvider;
import net.minecraft.world.item.Item;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class CommonItemTagProvider extends IntrinsicHolderTagsProvider<Item> {
    public CommonItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, Registries.ITEM, lookupProvider, item-> item.builtInRegistryHolder().key());
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ModTags.Items.ELECTRONIC_APPLIANCES)
                .add(ModBlocks.FRIDGE_LIGHT.get().asItem())
                .add(ModBlocks.FRIDGE_DARK.get().asItem())
                .add(ModBlocks.LIGHT_MICROWAVE.get().asItem())
                .add(ModBlocks.DARK_MICROWAVE.get().asItem());
    }
}
