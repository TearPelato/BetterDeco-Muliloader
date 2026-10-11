package net.tier1234.better_deco.datagen;

import net.minecraft.client.data.models.model.ItemModelUtils;
import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.item.ClientItem;
import net.minecraft.client.resources.model.sprite.Material;
import net.minecraft.resources.Identifier;
import net.tearpelato.craftcorelib.api.datagen.CoreGenerator;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.FridgeBlock;
import net.tier1234.better_deco.block.type.MetalType;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModItems;

import java.util.Optional;

public class CommonItemModelsGenerator extends CoreGenerator {

    public CommonItemModelsGenerator(Context context) {
        super(context);
    }

    @Override
    public void generate() {
        this.fridge(ModBlocks.FRIDGE_LIGHT.get());
        this.fridge(ModBlocks.FRIDGE_DARK.get());
        this.flatItem(ModItems.KITCHEN_KNIFE.get());
        this.flatItem(ModItems.SLICED_BREAD.get());
        this.flatItem(ModItems.COOKED_SLICED_BREAD.get());
    }

    protected void fridge(FridgeBlock block) {
        MetalType type = block.getType();
        TextureMapping textures = new TextureMapping();
        textures.put(TextureSlot.TEXTURE, new Material(Constants.id("block/fridge_"+ type.getName())));

        ModelTemplate model = new ModelTemplate(Optional.of(Constants.id("block/fridge")), Optional.empty(), TextureSlot.TEXTURE);
        Identifier fridge = model.create(block.asItem(), textures, this.context.models()::put);

        this.context.items().put(block.asItem(), new ClientItem(ItemModelUtils.plainModel(fridge), ClientItem.Properties.DEFAULT));
    }



}

