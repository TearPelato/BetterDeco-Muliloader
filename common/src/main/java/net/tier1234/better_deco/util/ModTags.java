package net.tier1234.better_deco.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> OVEN = createTag("oven");
        public static final TagKey<Block> TECQUE = createTag("tecque");

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Constants.id(name));
        }
    }
    public static class Items {

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Constants.id(name));
        }
    }
}