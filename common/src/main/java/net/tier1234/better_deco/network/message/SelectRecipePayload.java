package net.tier1234.better_deco.network.message;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.tier1234.better_deco.Constants;

public record SelectRecipePayload(int containerId, int recipeIndex, int amountDelta)
        implements CustomPacketPayload {

    public static final Type<SelectRecipePayload> TYPE =
            new Type<>(Constants.id("select_recipe"));

    public static final StreamCodec<FriendlyByteBuf, SelectRecipePayload> STREAM_CODEC =
            StreamCodec.of(
                    (buf, payload) -> {
                        buf.writeInt(payload.containerId());
                        buf.writeInt(payload.recipeIndex());
                        buf.writeInt(payload.amountDelta());
                    },
                    buf -> new SelectRecipePayload(buf.readInt(), buf.readInt(), buf.readInt())
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}