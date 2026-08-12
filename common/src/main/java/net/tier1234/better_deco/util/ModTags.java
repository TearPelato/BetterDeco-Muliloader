package net.tier1234.better_deco.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;

public class ModTags {
    public static class Blocks {

        private static TagKey<Block> createTag(String name) {
            return TagKey.create(Registries.BLOCK, Constants.id(name));
        }
    }
    public static class Items {

        public static final TagKey<Item> ELECTRONIC_APPLIANCES = createTag("electronic_appliances");

        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Constants.id(name));
        }
    }
}