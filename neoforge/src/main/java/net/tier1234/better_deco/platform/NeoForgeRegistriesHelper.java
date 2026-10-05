package net.tier1234.better_deco.platform;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.tier1234.better_deco.platform.services.IRegistriesHelper;

public class NeoForgeRegistriesHelper implements IRegistriesHelper {
    @Override
    public void openMenuWithPos(ServerPlayer player, MenuProvider provider, BlockPos pos) {
        player.openMenu(provider, buf->buf.writeBlockPos(pos));
    }
}
