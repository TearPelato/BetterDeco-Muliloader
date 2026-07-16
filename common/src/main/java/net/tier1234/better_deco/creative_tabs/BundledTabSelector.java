package net.tier1234.better_deco.creative_tabs;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mrcrayfish.framework.api.event.ClientConnectionEvents;
import com.mrcrayfish.framework.api.event.ScreenEvents;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.screens.inventory.CreativeModeInventoryScreen;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.Constants;
import net.tier1234.better_deco.mixin.access.CreativeModeInventoryScreenAccessor;
import net.tier1234.better_deco.platform.Services;
import net.tier1234.better_deco.registries.ModBundledTabs;
import net.tier1234.better_deco.registries.ModCreativeTabs;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * BundledTabs from VanillaBackport, used with BlackGear's permission.
 * @author BlackGear
 */
public class BundledTabSelector {
    private static final ResourceLocation SELECTOR_BAR =
            Constants.id("textures/gui/tab_selector/tab_interface.png");
    private static final int VISIBLE_CATEGORIES = 5;

    private static BundledTabSelector instance;

    public static BundledTabSelector bootstrap() {
        if (instance == null) instance = new BundledTabSelector();
        return instance;
    }

    private int guiLeft;
    private int guiTop;
    private int scroll;

    private AbstractWidget scrollUpButton;
    private AbstractWidget scrollDownButton;

    private List<BundledTabs> bundles = null;
    private CreativeModeTab lastTab;
    private int itemCount;

    private BundledTabSelector() {

        this.bundles = ModBundledTabs.getFilters();

        ScreenEvents.MODIFY_WIDGETS.register((screen, widgets, add, remove) -> {
            if(screen instanceof CreativeModeInventoryScreen creativeScreen) {
                this.guiLeft = Services.CLIENT.getGuiLeft(creativeScreen);
                this.guiTop = Services.CLIENT.getGuiTop(creativeScreen);
                this.bundles.forEach(BundledTabs::deselect);
                this.injectWidgets(creativeScreen, add);
            }
        });


        ScreenEvents.CLOSED.register(screen -> {
            if (screen instanceof CreativeModeInventoryScreen) {
                this.bundles.forEach(bundledTabs -> {
                    this.scrollUpButton = null;
                    this.scrollDownButton = null;
                    bundledTabs.setVisible(false);

                });
            }
        });

        ScreenEvents.AFTER_DRAW.register((screen,graphics,mouseX,mouseY,partialTicks)->{
            if (screen instanceof CreativeModeInventoryScreen creativeScreen) {
                CreativeModeTab tab = CreativeModeInventoryScreenAccessor.getSelectedTab();
                if (this.lastTab != tab) {
                    this.onSwitchCreativeTab(tab,creativeScreen);
                    this.lastTab = tab;
                }

            }
        });

        ScreenEvents.AFTER_DRAW_CONTAINER_BACKGROUND.register((screen,graphics,mouseX,mouseY)->{
            if (screen instanceof CreativeModeInventoryScreen creativeScreen) {
                this.renderBackground(screen,graphics,mouseX,mouseY);
            }
        });

        ClientConnectionEvents.LOGGING_OUT.register(player -> {
            this.bundles.forEach(category -> {
                category.setVisible(false);
            });
        });





    }


    public boolean onScroll(double mouseX, double mouseY, double scrollY)
    {
        CreativeModeTab selectedTab = CreativeModeInventoryScreenAccessor.getSelectedTab();
        if(selectedTab != ModCreativeTabs.BETTER_DECO.get())
            return false;

        double startX = this.guiLeft - 28;
        double startY = this.guiTop + 29;
        if (mouseX >= this.guiLeft - 30 && mouseY >= this.guiTop + 2 && mouseX <= this.guiLeft && mouseY <= this.guiTop + 122) {
            if (!(scrollY < 0)) {
                if (this.scroll > 0) this.scroll--;
            } else {
                if (this.scroll < this.getMaxScroll()) this.scroll++;
            }

        this.updateWidgets();
            return true;
        }
        return false;
    }


    private void renderBackground(AbstractContainerScreen<?> screen, GuiGraphics graphics, int mouseX, int mouseY) {
        if (screen instanceof CreativeModeInventoryScreen creativeScreen) {
            CreativeModeTab tab = CreativeModeInventoryScreenAccessor.getSelectedTab();
            graphics.pose().pushPose();
            graphics.pose().translate(0.0, 0.0, 0.0);

            if (this.isValidTab(tab)) {
                graphics.blit(SELECTOR_BAR, this.guiLeft - 34, this.guiTop + 2, 2, 0, 32, 120);
                if (this.hasSelectedBundle() && creativeScreen.getMenu().items.size() == this.itemCount) {
                    this.bundles.forEach(BundledTabs::deselect);
                }

            }

            if (this.lastTab != tab) {
                this.onSwitchCreativeTab(tab, creativeScreen);
                this.lastTab = tab;
            }

            graphics.pose().popPose();
        }
    }

    private void injectWidgets(CreativeModeInventoryScreen screen, Consumer<AbstractWidget> widgets) {
        this.bundles.forEach(category -> {
            Tab tab = new Tab(this.guiLeft - 26, this.guiTop + 7, category, button -> {
                if (category.isSelected()) {
                    category.deselect();
                } else {
                    this.bundles.forEach(BundledTabs::deselect);
                    category.select();
                }
                this.updateItems(screen);
            });

            tab.visible = false;
            widgets.accept(tab);
        });

        this.scrollUpButton = new ScrollButton(this.guiLeft - 27, this.guiTop + 6, 37, button -> {
            if (this.scroll > 0) this.scroll--;
            this.updateWidgets();
        });
        this.scrollDownButton = new ScrollButton(this.guiLeft - 27, this.guiTop + 107, 57, button -> {
            if (this.scroll < this.getMaxScroll()) this.scroll++;
            this.updateWidgets();
        });

        widgets.accept(this.scrollUpButton);
        widgets.accept(this.scrollDownButton);

        this.updateWidgets();
        this.onSwitchCreativeTab(CreativeModeInventoryScreenAccessor.getSelectedTab(), screen);
    }

    private int getMaxScroll() {
        return Math.max(0, this.bundles.size() - VISIBLE_CATEGORIES);
    }

    private void updateItems(CreativeModeInventoryScreen screen) {
        Set<ItemStack> seenItems = new HashSet<>();
        LinkedHashSet<ItemStack> displayItems = new LinkedHashSet<>();

        boolean hasSelected = this.bundles.stream().anyMatch(BundledTabs::isSelected);

        ModCreativeTabs.BETTER_DECO.get().getDisplayItems().forEach(stack -> {
            if (!hasSelected) {
                if (!seenItems.contains(stack)) {
                    displayItems.add(stack.copy());
                    seenItems.add(stack);
                }
            } else {
                this.bundles.stream()
                        .filter(BundledTabs::isSelected)
                        .forEach(bundle -> {
                            if (!seenItems.contains(stack) && bundle.contains(stack)) {
                                displayItems.add(stack.copy());
                                seenItems.add(stack);
                            }
                        });
            }
        });

        NonNullList<ItemStack> items = screen.getMenu().items;
        items.clear();
        items.addAll(displayItems);
        screen.getMenu().scrollTo(0);
    }

    private void updateWidgets() {
        this.bundles.forEach(bundle -> bundle.setVisible(false));

        for (int i = this.scroll; i < this.scroll + VISIBLE_CATEGORIES && i < this.bundles.size(); i++) {
            BundledTabs bundle = this.bundles.get(i);
            bundle.setY(this.guiTop + 18 * (i - this.scroll) + 18);
            bundle.setVisible(true);
        }

        boolean isValidTab = this.isValidTab(CreativeModeInventoryScreenAccessor.getSelectedTab());

        this.scrollUpButton.visible = isValidTab && this.scroll > 0;
        this.scrollDownButton.visible = isValidTab && this.scroll < this.getMaxScroll();
    }

    private void onSwitchCreativeTab(CreativeModeTab tab, CreativeModeInventoryScreen screen) {
        if (this.isValidTab(tab)) {
            this.updateWidgets();
            this.updateItems(screen);
        } else {
            this.scrollUpButton.visible = false;
            this.scrollDownButton.visible = false;
            this.bundles.forEach(bundle -> bundle.setVisible(false));
        }
    }

    private boolean isValidTab(CreativeModeTab tab) {
        return tab == ModCreativeTabs.BETTER_DECO.get();
    }

    private boolean hasSelectedBundle() {
        return this.bundles != null && this.bundles.stream().anyMatch(BundledTabs::isSelected);
    }

    public static class Tab extends Button {
        private final BundledTabs bundle;

        protected Tab(int x, int y, BundledTabs bundle, OnPress onPress) {
            super(x, y, 16, 16, Component.empty(), onPress, DEFAULT_NARRATION);
            this.bundle = bundle;
            bundle.setContentTab(this);
            this.setTooltip(Tooltip.create(bundle.getTooltip()));
        }

        @Override
        protected void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
            graphics.pose().pushPose();
            graphics.pose().translate(0.0, 0.0, 20.0);
            this.renderSelected(graphics);
            graphics.renderItem(this.bundle.getIcon(), this.getX(), this.getY());
            graphics.pose().popPose();
            this.renderHighlight(graphics);
        }

        private void renderSelected(GuiGraphics graphics) {
            if (this.bundle.isSelected()) {
                graphics.blit(SELECTOR_BAR, this.getX() - 7, this.getY() - 1, 37, 24, 30, 19);
            }
        }

        private void renderHighlight(GuiGraphics graphics) {
            if (this.isHovered() && !this.bundle.isSelected()) {
                graphics.pose().pushPose();
                graphics.pose().translate(0.0, 0.0, 20.0);
                RenderSystem.enableBlend();
                RenderSystem.defaultBlendFunc();
                graphics.blit(SELECTOR_BAR, this.getX(), this.getY(),  33, 44, 16, 16);
                RenderSystem.disableBlend();
                graphics.pose().popPose();
            }
        }
    }

    public static class ScrollButton extends Button {
        private final int uOffset;

        public ScrollButton(int x, int y, int uOffset, OnPress onPress) {
            super(x, y, 18, 11, Component.empty(), onPress, DEFAULT_NARRATION);
            this.uOffset = uOffset;
        }

        @Override
        public void renderWidget(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
            int textureY = this.isHovered ? 0 : 12;
            graphics.pose().pushPose();
            graphics.pose().translate(0.0, 0.0, 20.0);
            graphics.blit(SELECTOR_BAR, this.getX(), this.getY(), this.uOffset, textureY, 18, 11);
            graphics.pose().popPose();
        }
    }
}
