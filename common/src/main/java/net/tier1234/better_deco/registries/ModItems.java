package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.tier1234.better_deco.Constants;

@RegistryContainer
public class ModItems {

    public static final RegistryEntry<Item> KITCHEN_KNIFE = RegistryEntry.item(Constants.id("kitchen_knife"),
            () -> new SwordItem(Tiers.WOOD,new Item.Properties().stacksTo(1).rarity(Rarity.UNCOMMON).durability(365)));



}
