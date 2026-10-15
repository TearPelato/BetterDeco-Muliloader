package net.tier1234.better_deco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.util.ModTags;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class FabricAdvancementsProvider extends FabricAdvancementProvider {

    protected FabricAdvancementsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(output, registryLookup);

    }

    @Override
    public void generateAdvancement(HolderLookup.Provider registryLookup, Consumer<AdvancementHolder> outuput) {
            var items = registryLookup.lookupOrThrow(Registries.ITEM);
            var block = registryLookup.lookupOrThrow(Registries.BLOCK);


        AdvancementHolder root = Advancement.Builder.recipeAdvancement().rootDisplay(
                        ModBlocks.WORKBENCH.get().asItem(),
                        Component.translatable("advancement.better_deco.craft_workbench.title"),
                        Component.translatable("advancement.better_deco.craft_workbench.description"),
                        Constants.id(""),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("craftWorkbench", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(items, ModBlocks.WORKBENCH.get()).build()))
                .save(outuput, Constants.id("better_deco/craft_workbench"));

        AdvancementHolder craft_furniture = Advancement.Builder.advancement()
                .parent(root)
                .display(
                        ModBlocks.OAK_CHAIR.get().asItem(),
                        Component.translatable("advancement.better_deco.craft_furniture.title"),
                        Component.translatable("advancement.better_deco.craft_furniture.description"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false
                )
                .addCriterion("craftFurniture", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(items,
                                ModBlocks.BLOCKS.stream()
                                        .filter(entry-> entry!= ModBlocks.WORKBENCH)
                                        .map(entry -> entry.get().asItem())
                                        .toArray(Item[]::new)
                        ).build()))
                .save(outuput,Constants.id("better_deco/craft_furniture"));

        AdvancementHolder craft_electronic_furnitures = Advancement.Builder.advancement()
                .parent(root)
                .display(ModBlocks.FRIDGE_LIGHT.get().asItem(),
                        Component.translatable("advancement.better_deco.craft_electronic_furnitures"),
                        Component.translatable("advancement.better_deco.craft_electronic_furnitures.desc"),
                        AdvancementType.TASK,
                        true,
                        true,
                        false)
                .addCriterion("craft_electronic_furnitures", InventoryChangeTrigger.TriggerInstance.hasItems(
                        ItemPredicate.Builder.item().of(items, ModTags.Items.ELECTRONIC_FURNITURES).build()))
                .save(outuput,Constants.id("better_deco/craft_electronic_furnitures"));
    }
}
