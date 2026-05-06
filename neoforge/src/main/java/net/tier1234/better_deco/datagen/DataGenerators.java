package net.tier1234.better_deco.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.tier1234.better_deco.Constants;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Constants.MOD_ID, value = Dist.CLIENT)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();


        generator.addProvider(event.includeServer(), new NeoForgeRecipeProvider(output, lookupProvider));
        CommonBlockTagProvider blockTagProvider = generator.addProvider(event.includeServer(), new CommonBlockTagProvider(output, lookupProvider));
        //generator.addProvider(event.includeServer(), new NeoForgeBlockStateProvider(output, existingFileHelper));


    }
}
