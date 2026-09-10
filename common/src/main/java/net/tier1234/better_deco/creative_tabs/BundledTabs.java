package net.tier1234.better_deco.creative_tabs;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * BundledTabs from VanillaBackport, used with BlackGear's permission.
 * @author BlackGear
 */
public class BundledTabs {
    private final Component tooltip;
    private final Supplier<ItemStack> iconSupplier;
    private final List<ItemStack> displayItems;
    private final @Nullable BiConsumer<HolderLookup.Provider, Output> populationLogic;
    private boolean populated;
    private @Nullable BundledTabSelector.Tab tab;
    private boolean selected;

    private BundledTabs(Component tooltip, Supplier<ItemStack> iconSupplier, List<ItemStack> staticItems, @Nullable BiConsumer<HolderLookup.Provider, Output> populationLogic) {
        this.tooltip = tooltip;
        this.iconSupplier = iconSupplier;
        this.displayItems = staticItems;
        this.populationLogic = populationLogic;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Component getTooltip() {
        return this.tooltip;
    }

    public ItemStack getIcon() {
        return this.iconSupplier.get();
    }

    public List<ItemStack> getDisplayItems() {
        return Collections.unmodifiableList(this.displayItems);
    }

    public boolean contains(ItemStack stack) {
        return this.displayItems.stream().anyMatch(st-> ItemStack.isSameItemSameComponents(st,stack));
    }

    public void select() {
        this.selected = true;
    }

    public void deselect() {
        this.selected = false;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public void setContentTab(@Nullable BundledTabSelector.Tab tab) {
        this.tab = tab;
    }

    public void setVisible(boolean visible) {
        if (this.tab != null) this.tab.visible = visible;
    }

    public void setY(int y) {
        if (this.tab != null) this.tab.setY(y);
    }

    public void populate(HolderLookup.Provider provider) {
        if (this.populated || this.populationLogic == null) return;
        this.populationLogic.accept(provider, new Output() {
            @Override
            public void accept(ItemLike item) {
                displayItems.add(new ItemStack(item));
            }

            @Override
            public void accept(ItemStack stack) {
                displayItems.add(stack);
            }

            @Override
            public void accept(TagKey<Item> tag) {
                var opt = provider.lookupOrThrow(Registries.ITEM).get(tag);
                opt.ifPresent(holderSet -> {
                    for (Holder<Item> holder : holderSet) {
                        displayItems.add(new ItemStack(holder));
                    }
                });
            }
        });
        this.populated = true;
    }

    public static class Builder {
        private Component title;
        private Supplier<ItemStack> iconSupplier = () -> ItemStack.EMPTY;
        private BiConsumer<HolderLookup.Provider, Output> populationLogic;

        public Builder title(Component title) {
            this.title = title;
            return this;
        }

        public Builder icon(Supplier<ItemStack> icon) {
            this.iconSupplier = icon;
            return this;
        }

        public Builder icon(ItemLike item) {
            this.iconSupplier = () -> new ItemStack(item);
            return this;
        }

        public Builder displayItems(BiConsumer<HolderLookup.Provider, Output> logic) {
            this.populationLogic = logic;
            return this;
        }

        public BundledTabs build() {
            if (this.title == null) this.title = Component.empty();
            return new BundledTabs(this.title, this.iconSupplier, new ArrayList<>(), this.populationLogic);
        }
    }

    public interface Output {
        void accept(ItemLike item);
        void accept(ItemStack stack);
        void accept(TagKey<Item> tag);

    }
}