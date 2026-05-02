package net.tier1234.better_deco.creative_tabs.core;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import net.tearpelato.deco_lib.client.core.core_tabs.ScreenAccess;
import net.tier1234.better_deco.mixin.access.ScreenAccessor;

import java.util.List;

public class ScreenAccessImpl implements ScreenAccess {
    private Screen screen;

    public ScreenAccessImpl(Screen screen) {
        this.screen = screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public Screen screen() {
        return this.screen;
    }

    @Override
    public List<NarratableEntry> narratables() {
        return ((ScreenAccessor) this.screen).getNarratables();
    }

    @Override
    public List<Renderable> renderables() {
        return ((ScreenAccessor) this.screen).getRenderables();
    }

    @Override
    public <T extends AbstractWidget & Renderable & NarratableEntry> T addRenderableWidget(T widget) {
        return ((ScreenAccessor) this.screen).callAddRenderableWidget(widget);
    }

    @Override
    public <T extends Renderable> T addRenderableOnly(T listener) {
        return ((ScreenAccessor) this.screen).callAddRenderableOnly(listener);
    }

    @Override
    public <T extends GuiEventListener & NarratableEntry> T addWidget(T listener) {
        return ((ScreenAccessor) this.screen).callAddWidget(listener);
    }
}