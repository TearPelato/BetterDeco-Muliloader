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
        public static final TagKey<Item> DISPLAYED = createTag("displayed");

        public static final TagKey<Item> GENERAL = createTag("general");
        public static final TagKey<Item> KITCHEN = createTag("kitchen");
        public static final TagKey<Item> LIVING = createTag("living");
        public static final TagKey<Item> BATH = createTag("bath");
        public static final TagKey<Item> BEDROOM = createTag("bedroom");




        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Constants.id(name));
        }
    }
}