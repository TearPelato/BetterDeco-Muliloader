package net.tier1234.better_deco.platform;

import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.tier1234.better_deco.platform.services.IPlatformHelper;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class FabricPlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public void displayItemsAcceptor(CreativeModeTab.Builder builder, BiConsumer<CreativeModeTab.ItemDisplayParameters, Consumer<ItemStack>> consumer) {
        builder.displayItems((parameters, output) -> consumer.accept(parameters, output::accept));
    }
}
