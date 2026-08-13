package net.tier1234.better_deco.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementProvider;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.util.ModTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class CommonAdvancementsProvider extends AdvancementProvider {
    public CommonAdvancementsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, List.of(new BetterDecoAdvancements()));
    }

    public static class BetterDecoAdvancements implements AdvancementSubProvider {
        @Override
        public void generate(HolderLookup.Provider provider, Consumer<AdvancementHolder> consumer) {

            AdvancementHolder root = Advancement.Builder.recipeAdvancement().display(
                    ModBlocks.FURNI_WORKBENCH.get(),
                    Component.translatable("advancement.better_deco.craft_workbench.title"),
                    Component.translatable("advancement.better_deco.craft_workbench.description"),
                    Constants.id(""),
                    AdvancementType.TASK,
                    true,
                    true,
                    false
            )
                    .addCriterion("craftWorkbench", InventoryChangeTrigger.TriggerInstance.hasItems(ItemPredicate.Builder.item().of(ModBlocks.FURNI_WORKBENCH.get()).build()))
                    .save(consumer, "better_deco/craft_workbench");

            AdvancementHolder craft_furniture = Advancement.Builder.advancement()
                    .parent(root)
                    .display(
                    ModBlocks.OAK_CHAIR.get(),
                    Component.translatable("advancement.better_deco.craft_furniture.title"),
                    Component.translatable("advancement.better_deco.craft_furniture.description"),
                            null,
                            AdvancementType.TASK,
                            true,true,false
            )
                    .addCriterion("craftFurniture", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(
                                    ModBlocks.BLOCKS.stream()
                                            .filter(entry-> entry!= ModBlocks.FURNI_WORKBENCH)
                                            .map(entry -> entry.get().asItem())
                                            .toArray(Item[]::new)
                            ).build()))
                    .save(consumer, "better_deco/craft_furniture");

            AdvancementHolder craft_electronic_furnitures = Advancement.Builder.advancement()
                    .parent(root)
                    .display(ModBlocks.FRIDGE_LIGHT.get(),
                            Component.translatable("advancement.better_deco.craft_electronic_furnitures"),
                            Component.translatable("advancement.better_deco.craft_electronic_furnitures.desc"),
                            null,AdvancementType.TASK,true,true,false)
                    .addCriterion("craft_electronic_furnitures", InventoryChangeTrigger.TriggerInstance.hasItems(
                            ItemPredicate.Builder.item().of(ModTags.Items.ELECTRONIC_APPLIANCES).build()))
                    .save(consumer, "better_deco/craft_electronic_furnitures");


        }
    }
}
