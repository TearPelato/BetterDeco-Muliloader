package net.tier1234.better_deco.registries;

import com.mrcrayfish.framework.api.registry.RegistryContainer;
import com.mrcrayfish.framework.api.registry.RegistryEntry;
import net.minecraft.world.item.*;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.food.ModFoodProperties;

@RegistryContainer
public class ModItems {

    public static final RegistryEntry<Item> KITCHEN_KNIFE = RegistryEntry.item(Constants.id("kitchen_knife"),
           Item::new, ()-> new Item.Properties().durability(365).sword(ToolMaterial.WOOD, 3.0F, -2.4F).stacksTo(1).rarity(Rarity.UNCOMMON));

    public static final RegistryEntry<Item> SLICED_BREAD = RegistryEntry.item(Constants.id("sliced_bread"),
            Item::new,()-> new Item.Properties().food(ModFoodProperties.SLICED_BREAD));

    public static final RegistryEntry<Item> COOKED_SLICED_BREAD = RegistryEntry.item(Constants.id("cooked_sliced_bread"),
            Item::new,()-> new Item.Properties().food(ModFoodProperties.COOKED_SLICED_BREAD));
}