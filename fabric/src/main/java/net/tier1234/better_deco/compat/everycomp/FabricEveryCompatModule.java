package net.tier1234.better_deco.compat.everycomp;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.mehvahdjukaar.every_compat.ECRegistry;
import net.mehvahdjukaar.every_compat.api.PaletteStrategies;
import net.mehvahdjukaar.every_compat.api.SimpleEntrySet;
import net.mehvahdjukaar.every_compat.modules.EveryCompatModule;
import net.mehvahdjukaar.moonlight.api.resources.RecipeTemplate;
import net.mehvahdjukaar.moonlight.api.resources.recipe.BlockTypeSwapIngredient;
import net.mehvahdjukaar.moonlight.api.set.BlockType;
import net.mehvahdjukaar.moonlight.api.set.wood.VanillaWoodTypes;
import net.mehvahdjukaar.moonlight.api.set.wood.WoodType;
import net.mehvahdjukaar.moonlight.api.util.Utils;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.block.KitchenCounterBlock;
import net.tier1234.better_deco.block.KitchenDrawerBlock;
import net.tier1234.better_deco.creative_tabs.BundledTabs;
import net.tier1234.better_deco.recipe.CountedIngredient;
import net.tier1234.better_deco.recipe.FurniCraftingRecipe;
import net.tier1234.better_deco.registries.ModBlocks;
import net.tier1234.better_deco.registries.ModBundledTabs;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class FabricEveryCompatModule extends EveryCompatModule {
    public final SimpleEntrySet<WoodType, KitchenCounterBlock> kitchenCounter;
    public final SimpleEntrySet<WoodType, KitchenDrawerBlock> kitchenDrawer;
    private static  FabricEveryCompatModule INSTANCE;



    public FabricEveryCompatModule() {
        super(Constants.MOD_ID, Constants.MOD_ID);
        INSTANCE = this;
        kitchenCounter = SimpleEntrySet.builder(WoodType.class, "kitchen_counter",
                        ModBlocks.OAK_KITCHEN_COUNTER::get,
                        () -> VanillaWoodTypes.OAK,
                        w -> new KitchenCounterBlock(Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/furniture/kitchen/wodden/oak/oak_kitchen_counter"), PaletteStrategies.PLANKS_STANDARD)
                .noTab()
                .build();

        kitchenDrawer = SimpleEntrySet.builder(WoodType.class, "kitchen_drawer",
                        ModBlocks.OAK_KITCHEN_DRAWER::get,
                        () -> VanillaWoodTypes.OAK,
                        w-> new KitchenDrawerBlock(Utils.copyPropertySafe(w.planks)))
                .copyParentDrop()
                .defaultRecipe()
                .addTexture(modRes("block/furniture/kitchen/wodden/oak/oak_kitchen_drawer"), PaletteStrategies.PLANKS_STANDARD)
                .addTile(getModTile("kitchen_drawer"))
                .noTab()
                .build();


        this.addEntry(kitchenCounter);
        this.addEntry(kitchenDrawer);
    }

    /**
     * Class where registered the Custom filter tab for registering all the custom blocks
     * created with everycompat: It also features the event register
     * */
    public static class EveryCompatCreativeTabRegister {

        public static final BundledTabs EVERYCOMPAT_TAB = ModBundledTabs.register(
                BundledTabs.builder()
                        .icon(ECRegistry.ALL_WOODS.get().getDefaultInstance())
                        .title(Component.translatable("bundled_tab.everycompat"))
                        .displayItems((parameters, output) -> {
                            FabricEveryCompatModule module = getModuleInstance();

                            /**
                             * Method to register all entries, I don't think i'll use that cause i'd like to register
                             * my blocks with my logic*/
                            if (module != null) {
                                module.getEntries().forEach(entry -> {
                                    if (entry instanceof SimpleEntrySet<?, ?> entrySet) {
                                        entrySet.blocks.values().forEach(block -> {
                                            output.accept(block.asItem());
                                        });
                                    }
                                });
                            }

                                    /* if (module != null) {
                                        module.kitchenCounter.blocks.forEach((woodType, block) -> {
                                            output.accept(block.asItem());
                                        });

                                    }*/
                        })
                        .build()
        );

        private static FabricEveryCompatModule getModuleInstance() {
            return FabricEveryCompatModule.INSTANCE;
        }


        public static void register(CreativeModeTab creativeModeTab, FabricItemGroupEntries fabricItemGroupEntries) {

        }
    }

    @Override
    public void onModSetup() {
        super.onModSetup();

        RecipeTemplate.register(FurniCraftingRecipe.class, (old, from, to)-> {
            List<CountedIngredient> newIngredients = convertCountedIngredients(old.getMaterials(), from, to);
            ItemStack originalResult = old.getResultItem(RegistryAccess.EMPTY);
            ItemStack newResult = RecipeTemplate.convertItemStack(originalResult, from, to);
            if (newResult == null) {
                throw new UnsupportedOperationException("Failed to convert recipe result");
            } else {
                NonNullList<CountedIngredient> ingredients = NonNullList.of(CountedIngredient.EMPTY, newIngredients.toArray(CountedIngredient[]::new));
                return new FurniCraftingRecipe(ingredients, newResult, old.showNotification());
            }

        });



    }


    private static <R extends Recipe<?>, T extends BlockType> @NotNull List<CountedIngredient> convertCountedIngredients(
            NonNullList<CountedIngredient> or, T from, T to) {

        List<CountedIngredient> newList = new ArrayList<>();
        for (CountedIngredient si : or) {
            if (si.ingredient().isEmpty()) {
                newList.add(si);
            } else {
                newList.add(CountedIngredient.of(
                        BlockTypeSwapIngredient.create(si.ingredient(), from, to),
                        si.count()));
            }
        }
        return newList;
    }
    /**
     * Event where the tab is registered and initializated
     **/

    public static void register() {
        EveryCompatCreativeTabRegister.EVERYCOMPAT_TAB.toString();
        ItemGroupEvents.MODIFY_ENTRIES_ALL.register(EveryCompatCreativeTabRegister::register);

    }
}