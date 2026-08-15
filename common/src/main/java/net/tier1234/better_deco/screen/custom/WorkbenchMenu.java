package net.tier1234.better_deco.screen.custom;

import com.mrcrayfish.framework.api.menu.IMenuData;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.blockentity.WorkbenchBlockEntity;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.network.message.SyncCraftableRecipesPayload;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.FurniCraftingRecipe;
import net.tier1234.better_deco.registries.ModMenuTypes;
import net.tier1234.better_deco.registries.ModRecipes;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkbenchMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    private final Player player;
    private final Level level;
    private final WorkbenchBlockEntity blockEntity;
    private final SimpleContainer outputContainer;
    private List<RecipeHolder<FurniCraftingRecipe>> availableRecipes;
    private List<Boolean> canCraftRecipes;

    private int selectedRecipeIndex = -1;
    private int selectedAmount = 0;

    private static final int OUTPUT_SLOT_INDEX = 0;

    public WorkbenchMenu(int id, Inventory inventory, CustomData data) {
        this(id, inventory, inventory.player.level(), BlockPos.ZERO, new SimpleContainer(1));
        this.setCraftableRecipes(data.canCraft());
    }

    public WorkbenchMenu(int id, Inventory inventory, Level level, BlockPos pos, SimpleContainer outputContainer) {
        super(ModMenuTypes.FURNI_WORKBENCH.get(), id);
        this.access = ContainerLevelAccess.create(level, pos);
        this.player = inventory.player;
        this.level = level;
        this.blockEntity = level.getBlockEntity(pos) instanceof WorkbenchBlockEntity entity ? entity : null;
        this.outputContainer = outputContainer;

        fetchAvailableRecipes();
        addPlayerInventorySlots(inventory);
        addOutputSlot();

        updateCraftableRecipes();
    }

    public WorkbenchMenu(int id, Inventory inventory, Level level, BlockPos pos) {
        this(id, inventory, level, pos, new SimpleContainer(1));
    }

    public WorkbenchMenu(int id, Inventory inventory, FriendlyByteBuf buf) {
        this(id, inventory, inventory.player.level(), buf.readBlockPos(), new SimpleContainer(1));
    }

    public WorkbenchMenu(int id, Inventory inventory) {
        this(id, inventory, inventory.player.level(), BlockPos.ZERO, new SimpleContainer(1));
    }


    @Override
    public void broadcastChanges() {
        super.broadcastChanges();
        updateCraftableRecipes();
    }

    public CustomData createCustomData() {
        boolean[] craftable = new boolean[canCraftRecipes.size()];
        for (int i = 0; i < canCraftRecipes.size(); i++) {
            craftable[i] = canCraftRecipes.get(i);
        }
        return new CustomData(craftable);
    }

    public void updateCraftableRecipes() {
        this.canCraftRecipes = availableRecipes.stream()
                .map(r -> canCraft(r.value()))
                .collect(Collectors.toList());
        syncCraftableRecipesToClient();
    }

    private void syncCraftableRecipesToClient() {
        if (!(player instanceof ServerPlayer serverPlayer)) return;

        boolean[] craftableArray = new boolean[canCraftRecipes.size()];
        for (int i = 0; i < canCraftRecipes.size(); i++) {
            craftableArray[i] = canCraftRecipes.get(i);
        }

        ModPackets.sendToClient(serverPlayer,
                new SyncCraftableRecipesPayload(containerId, craftableArray));
    }

    private void fetchAvailableRecipes() {
        this.availableRecipes = level.getRecipeManager()
                .getAllRecipesFor(ModRecipes.WORKBENCH_TYPE.get())
                .stream()
                .sorted(Comparator.comparing(holder -> holder.value().getResultItem(null).getHoverName().getString()))
                .collect(Collectors.toList());
    }

    public void selectRecipe(int recipeIndex, int amountDelta) {
        if (recipeIndex < 0 || recipeIndex >= availableRecipes.size()) return;

        if (selectedRecipeIndex != recipeIndex) {
            selectedRecipeIndex = recipeIndex;
            selectedAmount = 0;
        }

        FurniCraftingRecipe recipe = availableRecipes.get(selectedRecipeIndex).value();
        ItemStack base = recipe.getResultItem(null);
        int maxMultiplier = Math.max(1, base.getMaxStackSize() / Math.max(1, base.getCount()));

        selectedAmount = Mth.clamp(selectedAmount + amountDelta, 1, maxMultiplier);

        updateOutputPreview();
    }

    public void clearSelection() {
        selectedRecipeIndex = -1;
        selectedAmount = 0;
        outputContainer.setItem(OUTPUT_SLOT_INDEX, ItemStack.EMPTY);
    }

    private void updateOutputPreview() {
        if (selectedRecipeIndex < 0 || selectedRecipeIndex >= availableRecipes.size()) {
            outputContainer.setItem(OUTPUT_SLOT_INDEX, ItemStack.EMPTY);
            return;
        }

        FurniCraftingRecipe recipe = availableRecipes.get(selectedRecipeIndex).value();
        ItemStack base = recipe.getResultItem(null);
        int totalCount = Math.min(base.getCount() * selectedAmount, base.getMaxStackSize());

        ItemStack preview = base.copy();
        preview.setCount(totalCount);
        outputContainer.setItem(OUTPUT_SLOT_INDEX, preview);
    }

    public int getSelectedRecipeIndex() {
        return selectedRecipeIndex;
    }

    public int getSelectedAmount() {
        return selectedAmount;
    }

    public List<RecipeHolder<FurniCraftingRecipe>> getAvailableRecipes() {
        return availableRecipes;
    }

    public boolean canCraft(FurniCraftingRecipe recipe) {
        return canCraft(recipe, 1);
    }

    public boolean canCraft(FurniCraftingRecipe recipe, int multiplier) {
        for (CountedIngredient ci : recipe.getMaterials()) {
            int requiredCount = ci.count() * multiplier;
            int totalCount = 0;
            for (ItemStack stack : player.getInventory().items) {
                if (!stack.isEmpty() && ci.ingredient().test(stack)) {
                    totalCount += stack.getCount();
                }
            }
            if (totalCount < requiredCount) {
                return false;
            }
        }
        return true;
    }

    private void addOutputSlot() {
        this.addSlot(new Slot(outputContainer, OUTPUT_SLOT_INDEX, 149, 86) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public boolean mayPickup(Player player) {
                if (selectedRecipeIndex < 0 || selectedRecipeIndex >= availableRecipes.size()) {
                    return false;
                }
                FurniCraftingRecipe recipe = availableRecipes.get(selectedRecipeIndex).value();
                return canCraft(recipe, selectedAmount);
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                super.onTake(player, stack);
                confirmCraft();
            }
        });
    }

    // NEW: consuma i materiali per la recipe/quantità selezionata (chiamato SOLO da onTake)
    private void confirmCraft() {
        if (selectedRecipeIndex < 0 || selectedRecipeIndex >= availableRecipes.size()) {
            clearSelection();
            return;
        }

        FurniCraftingRecipe recipe = availableRecipes.get(selectedRecipeIndex).value();
        int amount = selectedAmount;

        if (canCraft(recipe, amount)) {
            for (CountedIngredient ci : recipe.getMaterials()) {
                removeItemsFromInventory(ci, amount);
            }
        }

        clearSelection();
    }

    private void removeItemsFromInventory(CountedIngredient ci, int multiplier) {
        int remaining = ci.count() * multiplier;
        for (int i = 0; i < player.getInventory().items.size(); i++) {
            ItemStack stack = player.getInventory().items.get(i);
            if (!stack.isEmpty() && ci.ingredient().test(stack)) {
                int take = Math.min(stack.getCount(), remaining);
                stack.shrink(take);
                remaining -= take;
                if (remaining <= 0) break;
            }
        }
    }

    private void addPlayerInventorySlots(Inventory inventory) {
        int yOffset = 38;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, 84 + yOffset + row * 18));
            }
        }

        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, 142 + yOffset));
        }
    }



    public void craftSelectedRecipe(int recipeIndex) {
        if (recipeIndex < 0 || recipeIndex >= availableRecipes.size() || blockEntity == null) {
            return;
        }

        RecipeHolder<FurniCraftingRecipe> recipeHolder = availableRecipes.get(recipeIndex);
        FurniCraftingRecipe recipe = recipeHolder.value();

        if (!canCraft(recipe)) {
            return;
        }

        ItemStack result = recipe.getResultItem(null);
        ItemStack outputSlot = outputContainer.getItem(OUTPUT_SLOT_INDEX);

        if (!outputSlot.isEmpty()) {
            if (!outputSlot.is(result.getItem()) ||
                    outputSlot.getCount() + result.getCount() > outputSlot.getMaxStackSize()) {
                return;
            }
        }

        for (CountedIngredient ci : recipe.getMaterials()) {
            removeItemsFromInventory(ci);
        }

        if (outputSlot.isEmpty()) {
            outputContainer.setItem(OUTPUT_SLOT_INDEX, result.copy());
        } else {
            outputSlot.grow(result.getCount());
        }
    }

    private void removeItemsFromInventory(CountedIngredient ci) {
        int requiredCount = ci.count();
        int remaining = requiredCount;
        for (int i = 0; i < player.getInventory().items.size(); i++) {
            ItemStack stack = player.getInventory().items.get(i);
            if (!stack.isEmpty() && ci.ingredient().test(stack)) {
                int take = Math.min(stack.getCount(), remaining);
                stack.shrink(take);
                remaining -= take;
                if (remaining <= 0) {
                    break;
                }
            }
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate((level, pos) -> level.getBlockEntity(pos) instanceof WorkbenchBlockEntity, true);
    }

    public void setCraftableRecipes(boolean[] canCraft) {
        for (int i = 0; i < canCraft.length && i < this.canCraftRecipes.size(); i++) {
            this.canCraftRecipes.set(i, canCraft[i]);
        }
    }

    public boolean hasMaterials(CountedIngredient material, Map<Integer, Integer> counted) {
        int required = material.count();
        // Loop over every item in the player's inventory.
        for (ItemStack stack : player.getInventory().items) {
            if (!stack.isEmpty() && material.ingredient().test(stack)) {
                // Use the item's hashCode as a key.
                int key = stack.getItem().hashCode();
                int alreadyUsed = counted.getOrDefault(key, 0);
                // Determine how many of this item are still available.
                int available = stack.getCount() - alreadyUsed;
                if (available > 0) {
                    // Use up as many items as needed from this stack.
                    int used = Math.min(required, available);
                    required -= used;
                    counted.put(key, alreadyUsed + used);
                    if (required <= 0) {
                        return true; // Requirement satisfied.
                    }
                }
            }
        }
        return false; // Not enough items found.
    }


    public record CustomData(boolean[] canCraft) implements IMenuData<CustomData> {

        public static final StreamCodec<RegistryFriendlyByteBuf, CustomData> STREAM_CODEC =
                StreamCodec.of(
                        (buf, data) -> {
                            buf.writeVarInt(data.canCraft().length);
                            for (boolean b : data.canCraft()) {
                                buf.writeBoolean(b);
                            }
                        },
                        buf -> {
                            int size = buf.readVarInt();
                            boolean[] canCraft = new boolean[size];
                            for (int i = 0; i < size; i++) {
                                canCraft[i] = buf.readBoolean();
                            }
                            return new CustomData(canCraft);
                        }
                );

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CustomData> codec() {
            return STREAM_CODEC;
        }
    }
}