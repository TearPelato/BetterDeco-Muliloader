package net.tier1234.better_deco.recipe;


import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.init.ModBlocks;
import net.tier1234.better_deco.init.ModRecipes;

public record FreezerRecipe(ResourceLocation id, Ingredient input, ItemStack output, int freezeTime, float experience)
        implements Recipe<FreezerRecipeInput> {

    @Override
    public boolean matches(FreezerRecipeInput container, Level level) {
        return input.test(container.getInput());
    }

    @Override
    public ItemStack assemble(FreezerRecipeInput container, HolderLookup.Provider registries) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider registries) {
        return output;
    }

    public ResourceLocation getId() {
        return id;
    }

    public int getFreezeTime() {
        return freezeTime;
    }

    public float getExperience() {
        return experience;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FREEZER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FREEZER_TYPE.get();
    }

    @Override
    public ItemStack getToastSymbol() {
        return new ItemStack(ModBlocks.FRIDGE_LIGHT.get());
    }

    public static class Serializer implements RecipeSerializer<FreezerRecipe> {
        public static final MapCodec<FreezerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                ResourceLocation.CODEC.fieldOf("id").forGetter(FreezerRecipe::getId),
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(FreezerRecipe::input),
                ItemStack.CODEC.fieldOf("result").forGetter(FreezerRecipe::output),
                Codec.INT.fieldOf("cookingtime").forGetter(FreezerRecipe::getFreezeTime),
                Codec.FLOAT.fieldOf("experience").forGetter(FreezerRecipe::getExperience)
        ).apply(inst, FreezerRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FreezerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        ResourceLocation.STREAM_CODEC, FreezerRecipe::getId,
                        Ingredient.CONTENTS_STREAM_CODEC, FreezerRecipe::input,
                        ItemStack.STREAM_CODEC, FreezerRecipe::output,
                        new StreamCodec<RegistryFriendlyByteBuf, Integer>() { // int codec
                            @Override
                            public void encode(RegistryFriendlyByteBuf buf, Integer value) {
                                buf.writeInt(value);
                            }

                            @Override
                            public Integer decode(RegistryFriendlyByteBuf buf) {
                                return buf.readInt();
                            }
                        }, FreezerRecipe::getFreezeTime,
                        new StreamCodec<RegistryFriendlyByteBuf, Float>() { // float codec
                            @Override
                            public void encode(RegistryFriendlyByteBuf buf, Float value) {
                                buf.writeFloat(value);
                            }

                            @Override
                            public Float decode(RegistryFriendlyByteBuf buf) {
                                return buf.readFloat();
                            }
                        }, FreezerRecipe::getExperience,
                        FreezerRecipe::new
                );

        @Override
        public MapCodec<FreezerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FreezerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}