package net.tier1234.better_deco;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tier1234.better_deco.datagen.*;

public class BetterDecoDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(CommonBlockTagProvider::new);
        FabricDataGenerator.Pack.Factory<FabricBlockStateProvider> factory =
                FabricBlockStateProvider::new;
        pack.addProvider(factory);
        pack.addProvider(CommonRecipeProvider::new);
        pack.addProvider(FabricLootTableProvider::new);

    }

}
