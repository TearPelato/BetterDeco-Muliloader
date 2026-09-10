package net.tier1234.better_deco.recipe;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;

public record CountedIngredient(Ingredient ingredient, int count) {

    public static final Codec<Ingredient> CUSTOM_INGREDIENT_CODEC =
            Codec.either(Ingredient.CODEC, Codec.STRING)
                    .flatXmap(
                            either -> either.map(
                                    DataResult::success,
                                    s -> {
                                        Identifier id = Identifier.parse(s);
                                        Item item = BuiltInRegistries.ITEM.getValue(id);

                                        if (item == BuiltInRegistries.ITEM.getValue(Identifier.parse("minecraft:air"))) {
                                            return DataResult.error(() -> "Unknown item: " + id);
                                        }

                                        return DataResult.success(Ingredient.of(item));
                                    }
                            ),
                            ingredient -> DataResult.success(
                                    com.mojang.datafixers.util.Either.left(ingredient)
                            )
                    );

    public static final Codec<CountedIngredient> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(
                            CUSTOM_INGREDIENT_CODEC
                                    .fieldOf("item")
                                    .forGetter(CountedIngredient::ingredient),

                            Codec.INT
                                    .fieldOf("count")
                                    .forGetter(CountedIngredient::count)
                    ).apply(instance, CountedIngredient::new)
            );

    public static final StreamCodec<RegistryFriendlyByteBuf, CountedIngredient> STREAM_CODEC =
            StreamCodec.composite(
                    Ingredient.CONTENTS_STREAM_CODEC,
                    CountedIngredient::ingredient,
                    ByteBufCodecs.VAR_INT,
                    CountedIngredient::count,
                    CountedIngredient::new
            );

    public static CountedIngredient of(Ingredient ingredient, int count) {
        return new CountedIngredient(ingredient, count);
    }
}