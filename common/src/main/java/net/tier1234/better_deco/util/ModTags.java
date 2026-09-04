package net.tier1234.better_deco.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.tier1234.better_deco.Constants;

public class ModTags {
    public static class Items {

        public static final TagKey<Item> ELECTRONIC_FURNITURES = createTag("electronic_furnitures");

        public static final TagKey<Item> GENERAL = createTag("general");
        public static final TagKey<Item> KITCHEN = createTag("kitchen");
        public static final TagKey<Item> BATHROOM = createTag("bath");
        public static final TagKey<Item> BEDROOM = createTag("bedroom");
        public static final TagKey<Item> OFFICE = createTag("office");
        public static final TagKey<Item> OUTDOOR = createTag("outdoor");


        private static TagKey<Item> createTag(String name) {
            return TagKey.create(Registries.ITEM, Constants.id(name));
        }
    }
}