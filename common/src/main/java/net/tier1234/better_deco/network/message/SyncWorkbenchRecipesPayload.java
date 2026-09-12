package net.tier1234.better_deco.network.message;

import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;

import java.util.List;

public record SyncWorkbenchRecipesPayload(int containerId, List<ItemStack> results, List<RecipeHolder<WorkbenchRecipe>> recipes) implements CustomPacketPayload {

    public static final Type<SyncWorkbenchRecipesPayload> TYPE =
            new Type<>(Constants.id("sync_workbench_recipes"));

    public static final StreamCodec<RegistryFriendlyByteBuf, SyncWorkbenchRecipesPayload> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.VAR_INT, SyncWorkbenchRecipesPayload::containerId,
                    ItemStack.OPTIONAL_LIST_STREAM_CODEC, SyncWorkbenchRecipesPayload::results,
                    (StreamCodec) RecipeHolder.STREAM_CODEC.apply(ByteBufCodecs.list()),
                    SyncWorkbenchRecipesPayload::recipes,
                    SyncWorkbenchRecipesPayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}