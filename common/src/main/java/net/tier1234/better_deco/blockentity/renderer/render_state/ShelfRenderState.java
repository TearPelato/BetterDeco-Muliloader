package net.tier1234.better_deco.blockentity.renderer.render_state;

import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.client.renderer.item.ItemStackRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.blockentity.ShelfBlockEntity;

import java.util.ArrayList;
import java.util.List;

public class ShelfRenderState extends BlockEntityRenderState {
    public BlockPos lightPosition;
    public Level blockEntityLevel;
    public final List<ItemStackRenderState> itemRenderStates = new ArrayList<>(6);
    public Direction facing;
    public ShelfBlockEntity be;
    public final ItemStackRenderState itemStackRenderState = new ItemStackRenderState();

    public ShelfRenderState() {
        for (int i = 0; i < 6; i++) {
            itemRenderStates.add(new ItemStackRenderState());
        }
    }
}