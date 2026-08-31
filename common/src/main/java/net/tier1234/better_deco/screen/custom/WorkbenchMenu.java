package net.tier1234.better_deco.screen.custom;

import com.mrcrayfish.framework.api.menu.IMenuData;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.server.level.ServerPlayer;
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
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.WorkbenchRecipe;
import net.tier1234.better_deco.registries.ModMenuTypes;
import net.tier1234.better_deco.registries.ModRecipes;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WorkbenchMenu extends AbstractContainerMenu {

    private final ContainerLevelAccess access;
    private final WorkbenchBlockEntity workbench;
    private Slot outputSlot;
    private final DataSlot selectedRecipes;
    public List<RecipeHolder<WorkbenchRecipe>> recipes;
    private final ResultContainer resultContainer = new ResultContainer();
    private Map<Integer, Integer> counts = new Int2IntOpenHashMap();
    private List<Boolean> canCraftRecipes;
    private final Player player;
    private final Level level;


    public WorkbenchMenu(int id, Inventory inventory, CustomData data) {
        this(id, inventory, inventory.player.level(), BlockPos.ZERO, new SimpleContainer(1));
        this.selectedRecipes.set(data.selectedRecipe);
    }

    public WorkbenchMenu(int id, Inventory inventory, Level level, BlockPos pos, SimpleContainer outputContainer) {
        super(ModMenuTypes.FURNI_WORKBENCH.get(), id);
        this.access = ContainerLevelAccess.create(level,pos);
        this.workbench = level.getBlockEntity(pos) instanceof WorkbenchBlockEntity entity ? entity  : null;
        this.player = inventory.player;
        this.level = level;
        this.selectedRecipes = workbench != null
                ? workbench.selectedRecipeDataSlot()
                : new DataSlot() {
            private int value;

            @Override
            public int get() {
                return value;
            }

            @Override
            public void set(int value) {
                this.value = value;
            }
        };
        this.recipes = this.getRecipes();
        this.outputSlot = addSlot(new Slot(outputContainer, 0, 149, 79){
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false;
            }

            @Override
            public void onTake(Player player, ItemStack stack) {
                stack.onCraftedBy(player.level(), player, stack.getCount());
                WorkbenchMenu.this.onCraft();
                super.onTake(player, stack);
            }
        });
        this.addDataSlot(this.selectedRecipes);
        this.addPlayerInventorySlots(inventory);
        this.updateCraftableRecipes();
    }

    public Level getLevel() {
        return level;
    }

    public List<RecipeHolder<WorkbenchRecipe>> getRecipes() {
        return this.recipes = level.getRecipeManager()
                .getAllRecipesFor(ModRecipes.WORKBENCH_TYPE.get())
                .stream()
                .sorted(Comparator.comparing(RecipeHolder::id))
                .collect(Collectors.toList());
    }

    private void updateOutputSlot()
    {
        if(!this.level.isClientSide())
        {
            int selectedRecipeIndex = this.selectedRecipes.get();
            if(selectedRecipeIndex >= 0 && selectedRecipeIndex < this.recipes.size())
            {
                RecipeHolder<WorkbenchRecipe> recipe = this.recipes.get(selectedRecipeIndex);
                if(this.canCraft(recipe))
                {
                    ItemStack result = this.resultContainer.getItem(0);
                    ItemStack output = recipe.value().getResultItem(this.level.registryAccess());
                    if(!ItemStack.matches(result, output))
                    {
                        this.outputSlot.set(output.copy());
                    }
                }
                else
                {
                    this.outputSlot.set(ItemStack.EMPTY);
                }
            }
            else
            {
                this.outputSlot.set(ItemStack.EMPTY);
            }
            super.broadcastChanges();
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

    public void updateCraftableRecipes() {
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
        for (int i = 0; i < canCraft.length && i < this.canCraftRecipes.size(); i++) {
            this.canCraftRecipes.set(i, canCraft[i]);
        }
    }


    @Override
    public void broadcastChanges() {
        this.updateOutputSlot();
        super.broadcastChanges();
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
         return access.evaluate((level, blockPos)-> level.getBlockEntity(blockPos) instanceof WorkbenchBlockEntity, true);
     }

    public List<RecipeHolder<WorkbenchRecipe>> getAvailableRecipes() {
        return recipes;
    }

    public boolean canCraft(RecipeHolder<WorkbenchRecipe> recipe){
        for(CountedIngredient ingredient : recipe.value().getMaterials()) {
            int required = ingredient.count();
            int totalCount = 0;
            for (ItemStack stack: player.getInventory().items) {
                if(!stack.isEmpty()&& ingredient.ingredient().test(stack)){
                    totalCount += stack.getCount();
                }
            }

            if(totalCount < required){
                return false;
            }
        }

        return true;
     }

     public boolean hasMaterials(CountedIngredient material, Map<Integer, Integer> counted) {
        int remaining = material.count();
        for(ItemStack stack: material.ingredient().getItems()){
            int itemId = Item.getId(stack.getItem());
            int count = this.counts.getOrDefault(itemId, 0);
            count -= counted.getOrDefault(itemId, 0);
            if(count > 0){
                if(count >= remaining){
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
        if(recipe != null && this.canCraft(recipe)){
            this.craft(recipe);
            this.updateOutputSlot();
        }

    }

    public void craft(RecipeHolder<WorkbenchRecipe> recipe) {
        if (recipe == null || !this.canCraft(recipe)) {
            return;
        }

        for (CountedIngredient ingredient : recipe.value().getMaterials()) {
            this.consumeIngredients(ingredient);
        }
    }


    private void consumeIngredients(CountedIngredient ingredient) {
        int remaining = ingredient.count();

        for (ItemStack stack : player.getInventory().items) {
            if (remaining <= 0) {
                break;
            }
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
        return index != -1 ? this.recipes.get(index) : null;
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