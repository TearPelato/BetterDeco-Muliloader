package net.tier1234.better_deco.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.data.event.GatherDataRegistryEntriesEvent;
import net.tearpelato.craftcorelib.api.datagen.CraftCoreModelGenerator;
import net.tier1234.better_deco.Constants;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        var lookupProvider = event.getReloadableLookupProvider();

        CommonBlockTagProvider blockTagProvider = generator.addProvider(true, new CommonBlockTagProvider(output, lookupProvider));
        generator.addProvider(true, new CraftCoreModelGenerator(output, Constants.MOD_ID).add(CommonModelsProvider::new).add(CommonItemModelsGenerator::new));
        generator.addProvider(true, new CommonItemTagProvider(output,lookupProvider));

    }

    @SubscribeEvent
    public static void registerDatapack(GatherDataRegistryEntriesEvent event) {
            event.recipe(CommonRecipeProvider::new)
                 .advancement(NeoForgeAdvancementGenerator::new)
                 .lootTable(new LootTableProvider.SubProviderEntry(NeoForgeBlockLootTableProvider::new, LootContextParamSets.BLOCK));
    }
}
