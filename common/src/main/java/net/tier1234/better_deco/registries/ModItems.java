package net.tier1234.better_deco.registries;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.tearpelato.craftcorelib.api.registry.ObjectRegistries;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.food.ModFoodProperties;

public class ModItems {

    public static final ObjectRegistries<Item> KITCHEN_KNIFE = ObjectRegistries.registerItem(Constants.id("kitchen_knife"),
            () -> new SwordItem(Tiers.WOOD,new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).durability(365)));

    public static final ObjectRegistries<Item> SLICED_BREAD = ObjectRegistries.registerItem(Constants.id("sliced_bread"),
            ()-> new Item(new Item.Properties().food(ModFoodProperties.SLICED_BREAD)));

    public static final ObjectRegistries<Item> COOKED_SLICED_BREAD = ObjectRegistries.registerItem(Constants.id("cooked_sliced_bread"),
            ()-> new Item(new Item.Properties().food(ModFoodProperties.COOKED_SLICED_BREAD)));


    public static void init() {}
}
