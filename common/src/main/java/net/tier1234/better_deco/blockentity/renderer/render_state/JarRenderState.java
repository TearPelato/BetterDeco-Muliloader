package net.tier1234.better_deco.blockentity.renderer.render_state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.Direction;

import java.util.ArrayList;
import java.util.List;

public class JarRenderState extends BlockEntityRenderState {
    public Direction direction = Direction.NORTH;
    public final List<ItemStackRenderState> items = new ArrayList<>();
    public final List<Float> offsets = new ArrayList<>();
    public final List<Boolean> flat = new ArrayList<>();
}
