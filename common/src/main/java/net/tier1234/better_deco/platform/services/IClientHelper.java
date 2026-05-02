package net.tier1234.better_deco.platform.services;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;

public interface IClientHelper {
    int getGuiLeft(AbstractContainerScreen<?> screen);

    int getGuiTop(AbstractContainerScreen<?> screen);
}
