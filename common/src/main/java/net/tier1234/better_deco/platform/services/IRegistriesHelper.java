package net.tier1234.better_deco.platform.services;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;

public interface IRegistriesHelper {

    void openMenuWithPos(ServerPlayer player, MenuProvider provider, BlockPos pos);

}
