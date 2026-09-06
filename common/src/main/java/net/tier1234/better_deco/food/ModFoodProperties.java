package net.tier1234.better_deco.food;

import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties SLICED_BREAD = new FoodProperties.Builder().nutrition(3)
            .saturationModifier(0.4F).build();

    public static final FoodProperties COOKED_SLICED_BREAD = new FoodProperties.Builder().nutrition(5)
            .saturationModifier(0.6F).build();
}
