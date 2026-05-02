package net.tier1234.better_deco.platform;

import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.tier1234.better_deco.platform.services.IClientHelper;

public class FabricClientHelper implements IClientHelper {
    @Override
    public int getGuiLeft(AbstractContainerScreen<?> screen) {
        return screen.leftPos;
    }

    @Override
    public int getGuiTop(AbstractContainerScreen<?> screen) {
        return screen.topPos;
    }
}
