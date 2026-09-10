package net.tier1234.better_deco.compat.jei.category;

import com.ibm.icu.impl.Pair;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModRecipes;
import org.joml.Vector2i;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WorkbenchCategory extends FurnitureRecipeCategory<WorkbenchRecipe> {

    public static final Identifier TEXTURE = Constants.id("textures/gui/jei/workbench_jei.png");
    public static final Supplier<IRecipeHolderType<WorkbenchRecipe>> TYPE = IRecipeHolderType.createDeferred(ModRecipes.WORKBENCH_TYPE::get);


    private IGuiHelper guiHelper;
    private List<Pair<Vector2i, IDrawable>> slots = new ArrayList<>();

    public WorkbenchCategory(IGuiHelper guiHelper) {
        super(TYPE,
        Component.translatable("gui.better_deco.jei.workbench"),
        guiHelper.createDrawable(TEXTURE, 0, 0, 176, 75),
        guiHelper.createDrawableItemStack(new ItemStack(ModBlocks.WORKBENCH.get())));

        this.guiHelper = guiHelper;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("gui.better_deco.jei.workbench");
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, RecipeHolder<WorkbenchRecipe> recipe, IFocusGroup focuses) {
        this.slots.clear();
        NonNullList<CountedIngredient> ingredients = recipe.value().getMaterials();
        int leftPos = 10;
        int topPos = 10;
        int slotSize = 18;
        int boxSize = 54;
        int width = slotSize * Mth.clamp(ingredients.size(), 1, 3);
        int height = slotSize * Mth.clamp(Mth.ceil(ingredients.size() / (float) 3), 1, 3);
        for(int i = 0; i < ingredients.size(); i++)
        {
            int x = leftPos + (i % 3) * slotSize + (boxSize - width) / 2;
            int y = topPos + (i / 3) * slotSize + (boxSize - height) / 2;
            CountedIngredient material = ingredients.get(i);
            List<ItemStack> stacks = material.ingredient().items().map(stack -> {
                ItemStack copy = new ItemStack(stack.value());
                copy.setCount(material.count());
                return copy;
            }).toList();
            builder.addSlot(RecipeIngredientRole.INPUT, x, y).addItemStacks(stacks);
            this.slots.add(Pair.of(new Vector2i(x - 1, y - 1), this.guiHelper.createDrawable(TEXTURE, 0, 0, 16, 16)));


            builder.addSlot(RecipeIngredientRole.OUTPUT, 104,29).add(recipe.value().getResult());
    }
 }

    @Override
    public void draw(RecipeHolder<WorkbenchRecipe> recipe, IRecipeSlotsView view, GuiGraphicsExtractor graphics, double mouseX, double mouseY) {
        super.draw(recipe, view, graphics, mouseX, mouseY);
    }
}
