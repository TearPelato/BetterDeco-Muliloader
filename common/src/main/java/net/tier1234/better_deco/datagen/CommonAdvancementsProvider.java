package net.tier1234.better_deco.datagen;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementHolder;
import net.minecraft.advancements.AdvancementType;
import net.minecraft.advancements.predicates.ItemPredicate;
import net.minecraft.advancements.triggers.InventoryChangeTrigger;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.advancements.AdvancementSubProvider;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.util.ModTags;

public class CommonAdvancementsProvider extends AdvancementSubProvider {
    private final HolderGetter<Item> items;
    private final HolderGetter<Block> blocks;

    public CommonAdvancementsProvider(BootstrapContext<Advancement> output) {
        super(output);
        this.items = output.lookup(Registries.ITEM);
        this.blocks = output.lookup(Registries.BLOCK);
    }

    public static AdvancementSubProvider create(BootstrapContext<Advancement> context) {
        return new CommonAdvancementsProvider(context);
    }


    @Override
    public void generate() {
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
                .save(output,"better_deco/craft_workbench");

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
                .save(output,"better_deco/craft_furniture");

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
                        ItemPredicate.Builder.item().of(items,ModTags.Items.ELECTRONIC_FURNITURES).build()))
                .save(output,"better_deco/craft_electronic_furnitures");
    }

}
