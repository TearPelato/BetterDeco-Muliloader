package net.tier1234.better_deco.datagen;

import com.google.gson.JsonElement;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.CachedOutput;
import net.minecraft.data.DataProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.models.blockstates.BlockStateGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.tier1234.better_deco.Constants;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class NeoForgeBlockStateProvider extends BlockStateProvider {

    private final PackOutput.PathProvider blockStatePathProvider;
    private final PackOutput.PathProvider modelPathProvider;

    private final Map<Block, BlockStateGenerator> blockStates = new LinkedHashMap<>();
    private final Map<ResourceLocation, Supplier<JsonElement>> models = new LinkedHashMap<>();

    public NeoForgeBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Constants.MOD_ID, exFileHelper);
        this.blockStatePathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "blockstates");
        this.modelPathProvider = output.createPathProvider(PackOutput.Target.RESOURCE_PACK, "models");
    }

    @Override
    protected void registerStatesAndModels() {
        new CommonModelsProvider(this::addBlockState, this::addModel).run();
    }

    private void addBlockState(BlockStateGenerator generator) {
        if (blockStates.put(generator.getBlock(), generator) != null) {
            throw new IllegalStateException("Duplicate blockstate for " + generator.getBlock());
        }
    }

    private void addModel(ResourceLocation id, Supplier<JsonElement> jsonSupplier) {
        if (models.put(id, jsonSupplier) != null) {
            throw new IllegalStateException("Duplicate model for " + id);
        }
    }

    @Override
    public CompletableFuture<?> run(CachedOutput cache) {
        blockStates.clear();
        models.clear();
        registerStatesAndModels();

        CompletableFuture<?> blockStatesFuture = CompletableFuture.allOf(
                blockStates.entrySet().stream().map(entry -> {
                    ResourceLocation id = BuiltInRegistries.BLOCK.getKey(entry.getKey());
                    return DataProvider.saveStable(cache, entry.getValue().get(), blockStatePathProvider.json(id));
                }).toArray(CompletableFuture[]::new)
        );

        CompletableFuture<?> modelsFuture = CompletableFuture.allOf(
                models.entrySet().stream().map(entry ->
                        DataProvider.saveStable(cache, entry.getValue().get(), modelPathProvider.json(entry.getKey()))
                ).toArray(CompletableFuture[]::new)
        );

        return CompletableFuture.allOf(blockStatesFuture, modelsFuture);
    }

}