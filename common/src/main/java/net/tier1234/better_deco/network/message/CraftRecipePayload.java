package net.tier1234.better_deco.network.message;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.tier1234.better_deco.Constants;

public record CraftRecipePayload(int containerId, int recipeIndex)
        implements CustomPacketPayload {

    public static final Type<CraftRecipePayload> TYPE =
            new Type<>(Constants.id("craft_recipe"));

    public static final StreamCodec<FriendlyByteBuf, CraftRecipePayload> STREAM_CODEC =
            StreamCodec.of(
                    (buf, payload) -> {
                        buf.writeInt(payload.containerId());
                        buf.writeInt(payload.recipeIndex());
                    },
                    buf -> new CraftRecipePayload(buf.readInt(), buf.readInt())
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}