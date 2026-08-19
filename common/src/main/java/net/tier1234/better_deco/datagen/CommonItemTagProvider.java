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
        tag(ModTags.Items.ELECTRONIC_FURNITURES)
                .add(ModBlocks.FRIDGE_LIGHT.get().asItem())
                .add(ModBlocks.FRIDGE_DARK.get().asItem())
                .add(ModBlocks.LIGHT_MICROWAVE.get().asItem())
                .add(ModBlocks.DARK_MICROWAVE.get().asItem());

        tag(ModTags.Items.OFFICE)
                .add(ModBlocks.OAK_DESK.get().asItem())
                .add(ModBlocks.SPRUCE_DESK.get().asItem())
                .add(ModBlocks.BIRCH_DESK.get().asItem())
                .add(ModBlocks.JUNGLE_DESK.get().asItem())
                .add(ModBlocks.ACACIA_DESK.get().asItem())
                .add(ModBlocks.DARK_OAK_DESK.get().asItem())
                .add(ModBlocks.MANGROVE_DESK.get().asItem())
                .add(ModBlocks.CHERRY_DESK.get().asItem())
                .add(ModBlocks.BAMBOO_DESK.get().asItem())
                .add(ModBlocks.CRIMSON_DESK.get().asItem())
                .add(ModBlocks.WARPED_DESK.get().asItem())

                .add(ModBlocks.OAK_DESK_CABINET.get().asItem())
                .add(ModBlocks.SPRUCE_DESK_CABINET.get().asItem())
                .add(ModBlocks.BIRCH_DESK_CABINET.get().asItem())
                .add(ModBlocks.JUNGLE_DESK_CABINET.get().asItem())
                .add(ModBlocks.ACACIA_DESK_CABINET.get().asItem())
                .add(ModBlocks.DARK_OAK_DESK_CABINET.get().asItem())
                .add(ModBlocks.MANGROVE_DESK_CABINET.get().asItem())
                .add(ModBlocks.CHERRY_DESK_CABINET.get().asItem())
                .add(ModBlocks.BAMBOO_DESK_CABINET.get().asItem())
                .add(ModBlocks.CRIMSON_DESK_CABINET.get().asItem())
                .add(ModBlocks.WARPED_DESK_CABINET.get().asItem());
    }
}
