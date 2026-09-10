package net.tier1234.better_deco;

import com.mrcrayfish.framework.api.datagen.FrameworkModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.tier1234.better_deco.datagen.*;

public class BetterDecoDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(CommonBlockTagProvider::new);
        pack.addProvider((FabricDataGenerator.Pack.Factory<FrameworkModelProvider>) output ->
                new FrameworkModelProvider(output, CommonModelsProvider::new, CommonItemModelsGenerator::new));
        pack.addProvider(CommonRecipeProvider.Runner::new);
        pack.addProvider(FabricLootTableProvider::new);
        pack.addProvider(CommonAdvancementsProvider::new);
        pack.addProvider(CommonItemTagProvider::new);
    }

}
