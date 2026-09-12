package net.tier1234.better_deco;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    private Constants() {}

    public static final String MOD_ID = "better_deco";
    public static final String MOD_NAME = "BetterDeco";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static ResourceKey<Block> getBlockResKey(Block block) {
        return BuiltInRegistries.BLOCK.getResourceKey(block).get();
    }
    public static ResourceKey<Item> getItemResKey(Item item) {
        return BuiltInRegistries.ITEM.getResourceKey(item).get();
    }

}
