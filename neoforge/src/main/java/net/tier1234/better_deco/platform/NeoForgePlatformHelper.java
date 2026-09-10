package net.tier1234.better_deco.platform;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;
import net.tier1234.better_deco.platform.services.IPlatformHelper;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.getCurrent().isProduction();
    }

    @Override
    public void displayItemsAcceptor(CreativeModeTab.Builder builder, BiConsumer<CreativeModeTab.ItemDisplayParameters, Consumer<ItemStack>> consumer) {
        builder.displayItems((parameters, output) -> consumer.accept(parameters, output::accept));
    }
}
