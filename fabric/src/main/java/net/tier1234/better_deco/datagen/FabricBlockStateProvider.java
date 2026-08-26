package net.tier1234.better_deco.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;

public class FabricBlockStateProvider extends FabricModelProvider {

    public FabricBlockStateProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerator) {
        new CommonModelsProvider(blockModelGenerator.blockStateOutput, blockModelGenerator.modelOutput).run();
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerator) {

    }
}