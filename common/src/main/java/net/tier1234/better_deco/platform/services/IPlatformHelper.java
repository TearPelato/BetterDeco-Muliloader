package net.tier1234.better_deco.platform.services;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;

public interface IPlatformHelper {

    String getPlatformName();

    boolean isModLoaded(String modId);

    boolean isDevelopmentEnvironment();

/**
 * @author: MrCrayfish
 * */
    void displayItemsAcceptor(CreativeModeTab.Builder builder, Consumer<Consumer<ItemStack>> consumer);

    default String getEnvironmentName() {
        return isDevelopmentEnvironment() ? "development" : "production";
    }
}
