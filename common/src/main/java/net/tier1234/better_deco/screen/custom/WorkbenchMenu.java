package net.tier1234.better_deco.screen.custom;

import com.mrcrayfish.framework.api.Environment;
import com.mrcrayfish.framework.api.menu.IMenuData;
import com.mrcrayfish.framework.api.util.TaskRunner;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.blockentity.WorkbenchBlockEntity;
import net.tier1234.better_deco.network.ModPackets;
import net.tier1234.better_deco.network.message.SyncCraftableRecipesPayload;
import net.tier1234.better_deco.network.message.SyncWorkbenchRecipesPayload;
import net.tier1234.better_deco.platform.Services;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.registries.ModMenuTypes;
import net.tier1234.better_deco.util.ClientRecipes;
import net.tier1234.better_deco.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.stream.Collectors;

public class WorkbenchMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    private final WorkbenchBlockEntity workbench;
    private Slot outputSlot;
    private final DataSlot selectedRecipes;
    public List<RecipeHolder<WorkbenchRecipe>> recipes;
    private final ResultContainer resultContainer = new ResultContainer();
    private Map<Integer, Integer> counts = new Int2IntOpenHashMap();
    private List<Boolean> canCraftRecipes = new ArrayList<>();
    private final Player player;
    private final Level level;

    private List<ItemStack> clientResults = new ArrayList<>();

    private static final List<TagKey<Item>> RECIPE_ORDER = List.of(
            ModTags.Items.GENERAL,
            ModTags.Items.KITCHEN,
            ModTags.Items.OFFICE,
            ModTags.Items.BEDROOM,
            ModTags.Items.BATHROOM,
            ModTags.Items.OUTDOOR
    );

    public WorkbenchMenu(int id, Inventory inventory, CustomData data) {
        this(id, inventory, inventory.player.level(), BlockPos.ZERO, new SimpleContainer(1));
        this.selectedRecipes.set(data.selectedRecipe);
    }

    public WorkbenchMenu(int id, Inventory inventory, Level level, BlockPos pos, SimpleContainer outputContainer) {
        super(ModMenuTypes.FURNI_WORKBENCH.get(), id);
        this.access = ContainerLevelAccess.create(level, pos);
        this.workbench = level.getBlockEntity(pos) instanceof WorkbenchBlockEntity entity ? entity : null;
        this.player = inventory.player;
        this.level = level;

        this.selectedRecipes = workbench != null
                ? workbench.selectedRecipeDataSlot()
                : new DataSlot() {
            private int value;
            @Override public int get() { return value; }
            @Override public void set(int value) { this.value = value; }
        };

        this.recipes = this.setupRecipes(this.level);
        this.outputSlot = addSlot(new Slot(outputContainer, 0, 149, 79) {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player, stack.getCount());
                WorkbenchMenu.this.onCraft();
                super.onTake(player, stack);
                level.playSound(null, pos, SoundEvents.UI_CARTOGRAPHY_TABLE_TAKE_RESULT, SoundSource.BLOCKS, 1.0F, 1.0F);
            }
        });

        this.addDataSlot(this.selectedRecipes);
        this.addPlayerInventorySlots(inventory);

        if (!level.isClientSide() && player instanceof ServerPlayer serverPlayer) {
            List<ItemStack> results = this.recipes.stream()
                    .map(h -> h.value().getResultItem(level.registryAccess()).copy())
                    .toList();

            ModPackets.sendToClient(serverPlayer, new SyncWorkbenchRecipesPayload(this.containerId, results, recipes));
            this.updateCraftableRecipes();
        }
    }

    public Level getLevel() {
        return level;
    }

    public List<RecipeHolder<WorkbenchRecipe>> getRecipes() {
        return this.recipes;
    }

    private List<RecipeHolder<WorkbenchRecipe>> setupRecipes(Level level)
    {
        List<RecipeHolder<WorkbenchRecipe>> recipes = new ArrayList<>(this.getWorkbenchRecipeHolders(level));

        Map<Item, Integer> priority = new HashMap<>();
        int counter = 0;
        for (TagKey<Item> tag : RECIPE_ORDER) {
            Optional<HolderSet.Named<Item>> tagHolders = BuiltInRegistries.ITEM.get(tag);
            if (tagHolders.isPresent()) {
                for (Holder<Item> holder : tagHolders.get()) {
                    priority.putIfAbsent(holder.value(), counter++);
                }
            }
        }

        recipes.sort(Comparator.comparingInt(holder -> {
            Item resultItem = holder.value().getResultItem(level.registryAccess()).getItem();
            return priority.getOrDefault(resultItem, Integer.MAX_VALUE);
        }));

        return recipes;
    }

    private Collection<RecipeHolder<WorkbenchRecipe>> getWorkbenchRecipeHolders(Level level)
    {
        if(level instanceof ServerLevel serverLevel)
        {
            return Services.RECIPE.getWorkbenchRecipes(serverLevel);
        }
        else if(level instanceof ClientLevel)
        {
            return TaskRunner.callIf(Environment.CLIENT, () -> ClientRecipes::get)
                    .map(ClientRecipes::workbenchRecipes)
                    .orElse(Collections.emptyList());
        }
        return Collections.emptyList();
    }

    public void setClientRecipes(List<ItemStack> results) {
        this.clientResults = results != null ? new ArrayList<>(results) : new ArrayList<>();
        this.recipes = new ArrayList<>(Collections.nCopies(this.clientResults.size(), null));
        this.canCraftRecipes = new ArrayList<>(Collections.nCopies(this.clientResults.size(), false));
    }

    private void updateOutputSlot() {
        if (this.level.isClientSide()) return;

        int selectedRecipeIndex = this.selectedRecipes.get();
        if (selectedRecipeIndex >= 0 && selectedRecipeIndex < this.recipes.size()) {
            RecipeHolder<WorkbenchRecipe> recipe = this.recipes.get(selectedRecipeIndex);
            if (recipe != null && this.canCraft(recipe)) {
                ItemStack output = recipe.value().getResultItem(this.level.registryAccess()).copy();
                ItemStack current = this.outputSlot.getItem();
                if (!ItemStack.matches(current, output)) {
                    this.outputSlot.set(output);
                }
            } else {
                if (!this.outputSlot.getItem().isEmpty()) {
                    this.outputSlot.set(ItemStack.EMPTY);
                }
            }
        } else {
            if (!this.outputSlot.getItem().isEmpty()) {
                this.outputSlot.set(ItemStack.EMPTY);
            }
        }
    }
    public List<ItemStack> getClientResults() {
        return clientResults;
    }

    public ItemStack getResultStack(int originalIndex) {
        if (originalIndex < 0 || originalIndex >= recipes.size()) {
            return ItemStack.EMPTY;
        }

        RecipeHolder<WorkbenchRecipe> holder = recipes.get(originalIndex);
        if (holder != null) {
            return holder.value().getResultItem(level.registryAccess()).copy();
        }

        if (originalIndex < clientResults.size()) {
            return clientResults.get(originalIndex).copy();
        }
        return ItemStack.EMPTY;
    }

    public boolean hasRecipe(int originalIndex) {
        return originalIndex >= 0 && originalIndex < recipes.size() && recipes.get(originalIndex) != null;
    }

    private void addPlayerInventorySlots(Inventory inventory) {
        int invTop = 122;
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 9; ++col) {
                this.addSlot(new Slot(inventory, col + row * 9 + 9, 8 + col * 18, invTop + row * 18));
            }
        }
        for (int col = 0; col < 9; ++col) {
            this.addSlot(new Slot(inventory, col, 8 + col * 18, invTop + 58));
        }
    }

    public void updateCraftableRecipes() {
        if (this.level.isClientSide()) return;

        this.canCraftRecipes = recipes.stream()
                .map(this::canCraft)
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

    public void setCraftableRecipes(boolean[] canCraft) {
        this.canCraftRecipes = new ArrayList<>(canCraft.length);
        for (boolean b : canCraft) {
            this.canCraftRecipes.add(b);
        }
    }

    public boolean isCraftable(int index) {
        return index >= 0 && index < canCraftRecipes.size() && canCraftRecipes.get(index);
    }

    @Override
    public void broadcastChanges() {
        this.updateOutputSlot();
        super.broadcastChanges();
    }

    @Override
    public void slotsChanged(Container container) {
        this.updateCraftableRecipes();
        this.updateOutputSlot();
        super.slotsChanged(container);
    }

    public void selectRecipe(int recipeIndex) {
        if (recipeIndex < -1 || recipeIndex >= this.recipes.size()) {
            return;
        }
        this.selectedRecipes.set(recipeIndex);
        this.broadcastChanges();
    }

    public int getSelectedRecipe() {
        return this.selectedRecipes.get();
    }

    @Override
    public ItemStack quickMoveStack(Player player, int i) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean stillValid(Player player) {
        return access.evaluate((level, blockPos) ->
                level.getBlockEntity(blockPos) instanceof WorkbenchBlockEntity, true);
    }

    public List<RecipeHolder<WorkbenchRecipe>> getAvailableRecipes() {
        return recipes;
    }

    public boolean canCraft(RecipeHolder<WorkbenchRecipe> recipe) {
        if (recipe == null) return false;
        for (CountedIngredient ingredient : recipe.value().getMaterials()) {
            int required = ingredient.count();
            int totalCount = 0;
            for (ItemStack stack : player.getInventory().getNonEquipmentItems()) {
                if (!stack.isEmpty() && ingredient.ingredient().test(stack)) {
                    totalCount += stack.getCount();
                }
            }
            if (totalCount < required) {
                return false;
            }
        }
        return true;
    }

    public boolean hasMaterials(CountedIngredient material, Map<Integer, Integer> counted) {
        int remaining = material.count();
        for (Holder<Item> holder : material.ingredient().items().toList()) {
            int itemId = Item.getId(holder.value());
            int count = this.counts.getOrDefault(itemId, 0);
            count -= counted.getOrDefault(itemId, 0);
            if (count > 0) {
                if (count >= remaining) {
                    counted.merge(itemId, remaining, Integer::sum);
                    remaining = 0;
                    break;
                }
                counted.merge(itemId, count, Integer::sum);
                remaining -= count;
            }
        }

        return remaining > 0;
    }

    public void onCraft() {
        RecipeHolder<WorkbenchRecipe> recipe = this.selectedRecipe();
        if (recipe != null && this.canCraft(recipe)) {
            this.craft(recipe);
            this.updateOutputSlot();
            this.updateCraftableRecipes(); // re-sync craftable after consuming items
        }
    }

    public void craft(RecipeHolder<WorkbenchRecipe> recipe) {
        if (recipe == null || !this.canCraft(recipe)) return;
        for (CountedIngredient ingredient : recipe.value().getMaterials()) {
            this.consumeIngredients(ingredient);
        }
    }

    private void consumeIngredients(CountedIngredient ingredient) {
        int remaining = ingredient.count();
        for (ItemStack stack : player.getInventory().getNonEquipmentItems()) {
            if (remaining <= 0) break;
            if (!stack.isEmpty() && ingredient.ingredient().test(stack)) {
                int take = Math.min(stack.getCount(), remaining);
                stack.shrink(take);
                remaining -= take;
            }
        }
    }

    @Nullable
    private RecipeHolder<WorkbenchRecipe> selectedRecipe() {
        int index = this.selectedRecipes.get();
        return index != -1 && index < this.recipes.size() ? this.recipes.get(index) : null;
    }

    public record CustomData(int selectedRecipe) implements IMenuData<CustomData> {
        public static final StreamCodec<RegistryFriendlyByteBuf, CustomData> STREAM_CODEC = StreamCodec.composite(
                ByteBufCodecs.VAR_INT,
                CustomData::selectedRecipe,
                CustomData::new
        );

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CustomData> codec() {
            return STREAM_CODEC;
        }
    }
}