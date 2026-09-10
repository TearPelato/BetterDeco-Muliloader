package net.tier1234.better_deco.datagen;

import com.mrcrayfish.framework.api.datagen.FrameworkGenerator;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.FridgeBlock;
import net.tier1234.better_deco.block.type.MetalType;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

import java.util.Map;
import java.util.Optional;

public class CommonItemModelsGenerator extends FrameworkGenerator {
    public CommonItemModelsGenerator(Map<Block, BlockModelDefinitionGenerator> generators, Map<Item, ClientItem> items, Map<Identifier, ModelInstance> models) {
        super(generators, items, models);
    }

    @Override
    public void generate() {
        this.fridge(ModBlocks.FRIDGE_LIGHT.get());
        this.fridge(ModBlocks.FRIDGE_DARK.get());
        this.flatItemModel(ModItems.KITCHEN_KNIFE.get());
        this.flatItemModel(ModItems.SLICED_BREAD.get());
        this.flatItemModel(ModItems.COOKED_SLICED_BREAD.get());

    }

    protected void fridge(FridgeBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/fridge_"+ type.getName())));

        ModelTemplate model = new ModelTemplate(Optional.of(Constants.id("block/fridge")), Optional.empty(), TextureSlot.TEXTURE);
        Identifier fridge = model.create(block.asItem(), textures, this.models::put);

        this.items.put(block.asItem(), this.createClientItem(ItemModelUtils.plainModel(fridge)));
    }

}

