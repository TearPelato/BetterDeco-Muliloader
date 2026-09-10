package net.tier1234.better_deco.blockentity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.tier1234.better_deco.recipe.ToasterRecipe;
import net.tier1234.better_deco.recipe.input.ToasterRecipeInput;
import net.tier1234.better_deco.registries.ModBlockEntities;
import net.tier1234.better_deco.registries.ModRecipes;
import org.jetbrains.annotations.Nullable;


public class ToasterBlockEntity extends BlockEntity {

    public static final int SLOTS = 2;

    private final NonNullList<ItemStack> items = NonNullList.withSize(SLOTS, ItemStack.EMPTY);
    private final int[] cookTime = new int[SLOTS];
    private final int[] cookTimeTotal = new int[SLOTS];

    private final RecipeHolder<ToasterRecipe>[] cachedRecipe = new RecipeHolder[SLOTS];

    public ToasterBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TOASTER.get(), pos, state);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, ToasterBlockEntity entity) {
        if (level.isClientSide()) {
            return;
        }

        boolean dirty = false;

        for (int slot = 0; slot < SLOTS; slot++) {
            ItemStack stack = entity.items.get(slot);

            if (stack.isEmpty()) {
                if (entity.cookTime[slot] != 0) {
                    entity.cookTime[slot] = 0;
                    dirty = true;
                }
                entity.cachedRecipe[slot] = null;
                continue;
            }

            ToasterRecipeInput input = new ToasterRecipeInput(stack);
            RecipeHolder<ToasterRecipe> recipe = entity.cachedRecipe[slot];

            if (recipe == null || !recipe.value().matches(input, level)) {
                recipe = ((ServerLevel)level).recipeAccess()
                        .getRecipeFor(ModRecipes.TOASTER_TYPE.get(), input, level)
                        .orElse(null);
                entity.cachedRecipe[slot] = recipe;
            }

            if (recipe != null) {
                entity.cookTimeTotal[slot] = recipe.value().getCookTime();
                entity.cookTime[slot]++;
                dirty = true;

                if (entity.cookTime[slot] >= entity.cookTimeTotal[slot]) {
                    ItemStack result = recipe.value().assemble(input);
                    entity.items.set(slot, result.copy());
                    entity.cookTime[slot] = 0;
                    entity.cachedRecipe[slot] = null;
                }
            } else if (entity.cookTime[slot] != 0) {
                entity.cookTime[slot] = 0;
                dirty = true;
            }
        }

        if (dirty) {
            entity.setChanged();
            level.sendBlockUpdated(pos, state, state, 3);
        }
    }

    public boolean hasEmptySlot() {
        for (int slot = 0; slot < SLOTS; slot++) {
            if (items.get(slot).isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean insertItem(ItemStack stack) {
        for (int slot = 0; slot < SLOTS; slot++) {
            if (items.get(slot).isEmpty()) {
                ItemStack single = stack.copy();
                single.setCount(1);
                items.set(slot, single);
                cookTime[slot] = 0;
                cachedRecipe[slot] = null;
                setChanged();
                syncToClient();
                return true;
            }
        }
        return false;
    }

    public ItemStack removeLastItem() {
        for (int slot = SLOTS - 1; slot >= 0; slot--) {
            if (!items.get(slot).isEmpty()) {
                ItemStack removed = items.get(slot);
                items.set(slot, ItemStack.EMPTY);
                cookTime[slot] = 0;
                cachedRecipe[slot] = null;
                setChanged();
                syncToClient();
                return removed;
            }
        }
        return ItemStack.EMPTY;
    }

    public boolean isEmpty() {
        return items.get(0).isEmpty() && items.get(1).isEmpty();
    }

    public ItemStack getItem(int slot) {
        return items.get(slot);
    }

    public float getProgress(int slot) {
        if (cookTimeTotal[slot] <= 0) {
            return 0f;
        }
        return (float) cookTime[slot] / (float) cookTimeTotal[slot];
    }

    private void syncToClient() {
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);
        ContainerHelper.saveAllItems(output, items);
        output.putIntArray("CookTime", cookTime);
        output.putIntArray("CookTimeTotal", cookTimeTotal);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);
        items.clear();
        ContainerHelper.loadAllItems(input, items);
        int[] ct = input.getIntArray("cooktime").get();
        int[] ctt = input.getIntArray("CookTimeTotal").get();
        for (int i = 0; i < SLOTS && i < ct.length; i++) {
            cookTime[i] = ct[i];
        }
        for (int i = 0; i < SLOTS && i < ctt.length; i++) {
            cookTimeTotal[i] = ctt[i];
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return super.getUpdateTag(registries);
    }
}