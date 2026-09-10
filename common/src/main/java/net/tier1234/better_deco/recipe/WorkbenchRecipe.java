package net.tier1234.better_deco.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.registries.ModRecipes;
import org.jetbrains.annotations.NotNull;


public class WorkbenchRecipe implements Recipe<SingleRecipeInput> {

    private final NonNullList<CountedIngredient> materials;
    private final ItemStackTemplate result;
    private final boolean notification;
    private PlacementInfo placementInfo;

    public WorkbenchRecipe(NonNullList<CountedIngredient> materials, ItemStackTemplate result, boolean notification) {
        this.materials = materials;
        this.result = result;
        this.notification = notification;
    }

    @Override
    public boolean matches(SingleRecipeInput input, Level level) {
        ItemStack inputStack = input.getItem(0);

        if (inputStack.isEmpty()) {
            return false;
        }

        for (CountedIngredient countedIngredient : materials) {
            if (countedIngredient.ingredient().test(inputStack)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public ItemStack assemble(SingleRecipeInput input) {
        return result.create();
    }

    @Override
    public boolean showNotification() {
        return notification;
    }

    @Override
    public String group() {
        return "Workbench";
    }

    @Override
    public @NotNull RecipeSerializer<? extends Recipe<SingleRecipeInput>> getSerializer() {
        return ModRecipes.WORKBENCH_SERIALIZER.get();
    }

    @Override
    public @NotNull RecipeType<? extends Recipe<SingleRecipeInput>> getType() {
        return ModRecipes.WORKBENCH_TYPE.get();
    }


    @Override
    public PlacementInfo placementInfo() {
        if (this.placementInfo == null) {
            this.placementInfo = PlacementInfo.create(
                    this.materials.stream()
                            .map(CountedIngredient::ingredient)
                            .toList()
            );
        }
        return this.placementInfo;
    }
    @Override
    public RecipeBookCategory recipeBookCategory() {
        return null;
    }

    public @NotNull ItemStack getResultItem(HolderLookup.Provider provider) {
        return result.create();
    }

    public ItemStackTemplate getResult() {
        return result;
    }

    public NonNullList<CountedIngredient> getMaterials() {
        return materials;
    }

    public static final MapCodec<WorkbenchRecipe> CODEC =
            RecordCodecBuilder.mapCodec(instance ->
                    instance.group(
                            CountedIngredient.CODEC
                                    .listOf()
                                    .fieldOf("materials")
                                    .flatXmap(list -> {
                                        NonNullList<CountedIngredient> result = NonNullList.create();
                                                result.addAll(list);
                                                return DataResult.success(result);
                                            },
                                            nonNullList -> DataResult.success(nonNullList.stream().toList()))
                                    .forGetter(recipe -> recipe.materials),

                            ItemStackTemplate.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                            Codec.BOOL.optionalFieldOf("show_notification", false)
                                    .forGetter(recipe -> recipe.notification)

                    ).apply(instance, WorkbenchRecipe::new)
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, WorkbenchRecipe> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.collection(NonNullList::createWithCapacity, CountedIngredient.STREAM_CODEC),
                    WorkbenchRecipe::getMaterials,
                    ItemStackTemplate.STREAM_CODEC,
                    WorkbenchRecipe::getResult,
                    ByteBufCodecs.BOOL,
                    recipe -> recipe.notification,
                    WorkbenchRecipe::new
            );
}