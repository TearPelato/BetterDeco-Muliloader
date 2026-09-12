package net.tier1234.better_deco.mixin.client;

import net.minecraft.client.multiplayer.ClientPacketListener;
import net.tier1234.better_deco.util.ClientRecipes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

/**
 * Author: MrCrayfish
 */
@Mixin(ClientPacketListener.class)
public class ClientPacketListenerMixin implements ClientRecipes.Access
{
    @Unique
    private ClientRecipes syncedRecipes;

    @Unique
    @Override
    public ClientRecipes clientRecipes()
    {
        if(this.syncedRecipes == null)
        {
            this.syncedRecipes = new ClientRecipes();
        }
        return this.syncedRecipes;
    }
}