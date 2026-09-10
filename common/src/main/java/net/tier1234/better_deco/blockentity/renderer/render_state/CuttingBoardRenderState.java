package net.tier1234.better_deco.blockentity.renderer.render_state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

public class CuttingBoardRenderState extends BlockEntityRenderState {
    public final ItemStackRenderState item = new ItemStackRenderState();
    public Direction direction = Direction.NORTH;
    public float offset;
    public boolean flat;
}
