package net.tier1234.better_deco.datagen;

import com.mrcrayfish.framework.api.datagen.FrameworkGenerator;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.registries.ModItems;

import java.util.Map;

public class CommonItemModelsGenerator extends FrameworkGenerator {
    public CommonItemModelsGenerator(Map<Block, BlockModelDefinitionGenerator> generators, Map<Item, ClientItem> items, Map<Identifier, ModelInstance> models) {
        super(generators, items, models);
    }

    @Override
    public void generate() {
        this.flatItemModel(ModItems.KITCHEN_KNIFE.get());
        this.flatItemModel(ModItems.SLICED_BREAD.get());
        this.flatItemModel(ModItems.COOKED_SLICED_BREAD.get());

    }
}
