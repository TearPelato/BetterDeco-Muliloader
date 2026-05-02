package net.tier1234.better_deco.network.message;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.tier1234.better_deco.Constants;

public record SyncCraftableRecipesPayload(int containerId, boolean[] craftable)
        implements CustomPacketPayload {

    public static final Type<SyncCraftableRecipesPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(Constants.MOD_ID, "sync_craftable_recipes"));

    public static final StreamCodec<FriendlyByteBuf, SyncCraftableRecipesPayload> STREAM_CODEC =
            StreamCodec.of(
                    (buf, payload) -> {
                        buf.writeInt(payload.containerId());
                        buf.writeInt(payload.craftable().length);
                        for (boolean b : payload.craftable()) {
                            buf.writeBoolean(b);
                        }
                    },
                    buf -> {
                        int containerId = buf.readInt();
                        int len = buf.readInt();
                        boolean[] craftable = new boolean[len];
                        for (int i = 0; i < len; i++) {
                            craftable[i] = buf.readBoolean();
                        }
                        return new SyncCraftableRecipesPayload(containerId, craftable);
                    }
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}