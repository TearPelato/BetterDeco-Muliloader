package net.tier1234.better_deco.compat.jei.category;

import net.minecraft.world.item.crafting.RecipeMap;

/**
 * @author MrCrayfish*/
public class SyncedRecipes
{
    private static RecipeMap map = RecipeMap.EMPTY;

    public static RecipeMap getMap()
    {
        return map;
    }

    public static void setMap(RecipeMap map)
    {
        SyncedRecipes.map = map;
    }

    public static void reset()
    {
        SyncedRecipes.map = RecipeMap.EMPTY;
    }
}