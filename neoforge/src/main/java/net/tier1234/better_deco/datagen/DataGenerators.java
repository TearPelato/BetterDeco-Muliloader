package net.tier1234.better_deco.datagen;

import com.mrcrayfish.framework.api.datagen.FrameworkModelProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.tier1234.better_deco.Constants;

import java.util.Collections;
import java.util.List;

@EventBusSubscriber(modid = Constants.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();


        generator.addProvider(true, new CommonRecipeProvider.Runner(output, lookupProvider));
        CommonBlockTagProvider blockTagProvider = generator.addProvider(true, new CommonBlockTagProvider(output, lookupProvider));
        generator.addProvider(true, new FrameworkModelProvider(output, CommonModelsProvider::new, CommonItemModelsGenerator::new));
        generator.addProvider(true, new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(NeoForgeBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(true, new CommonAdvancementsProvider(output, lookupProvider));
        generator.addProvider(true, new CommonItemTagProvider(output,lookupProvider));

    }
}
