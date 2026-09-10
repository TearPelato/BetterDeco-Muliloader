package net.tier1234.better_deco.blockentity.renderer.render_state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public class RotationRenderState extends BlockEntityRenderState {
    public BlockPos lightPosition;
    public Level blockEntityLevel;
    public float rotation;

    public final ItemStackRenderState itemStackRenderState = new ItemStackRenderState();
}