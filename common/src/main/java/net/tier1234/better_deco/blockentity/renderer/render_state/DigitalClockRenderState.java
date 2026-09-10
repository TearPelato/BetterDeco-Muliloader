package net.tier1234.better_deco.blockentity.renderer.render_state;

import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.blockentity.state.BlockEntityRenderState;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.FormattedCharSequence;
import net.minecraft.world.level.Level;
import net.tier1234.better_deco.blockentity.DigitalClockBlockEntity;

public class DigitalClockRenderState extends BlockEntityRenderState {
    public Direction facing;
    public FormattedCharSequence timeText;
    public ChatFormatting color;
    public int colorInt;
    public Level level;
    public BlockPos lightPosition;
    public DigitalClockBlockEntity be;
}