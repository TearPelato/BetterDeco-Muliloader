package net.tier1234.better_deco.blockentity.renderer.render_state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class ToasterRenderState extends BlockEntityRenderState {
    public final ItemStackRenderState[] items = {
            new ItemStackRenderState(),
            new ItemStackRenderState()
    };

    public Direction facing = Direction.NORTH;
}
