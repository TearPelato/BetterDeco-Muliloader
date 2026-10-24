package net.tier1234.better_deco.platform;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.platform.services.IRecipeHelper;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.registries.ModRecipes;
import net.tier1234.better_deco.util.ClientRecipes;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FabricRecipeHelper implements IRecipeHelper {
    @Override
    public Collection<RecipeHolder<WorkbenchRecipe>> getWorkbenchRecipes(ServerLevel level) {
        return level.getServer().getRecipeManager().recipes.byType(ModRecipes.WORKBENCH_TYPE.get());
    }

    @Override
    public Collection<RecipeHolder<WorkbenchRecipe>> getClientWorkbenchRecipes() {
        var list = ClientRecipes.get().map(ClientRecipes::workbenchRecipes).orElse(Collections.emptyList());
        Constants.LOG.info("fabric client recipes={}", list.size());
        return list;
    }

}
