package net.tier1234.better_deco.block.entity.custom;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.tearpelato.deco_lib.api.util.BlockEntityUtil;
import net.tier1234.better_deco.init.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class DigitalClockBlockEntity extends BlockEntity {

    private DyeColor textColor = DyeColor.WHITE;

    public DigitalClockBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.DIGITAL_CLOCK.get(), pos, state);
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.loadAdditional(tag, registries);
        if (tag.contains("TextColor")) {
            this.textColor = DyeColor.byName(tag.getString("TextColor"), DyeColor.WHITE);
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        super.saveAdditional(tag, registries);
        // Salva i dati extra
        tag.putString("TextColor", this.textColor.getName());
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider registries) {
        return saveWithFullMetadata(registries);
    }

    @Nullable
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this, BlockEntity::getUpdateTag);
    }

    public void sync() {
        BlockEntityUtil.sendUpdate(this);
        setChanged();
    }

    public DyeColor getTextColor() {
        return textColor;
    }

    public void setTextColor(DyeColor textColor) {
        this.textColor = textColor;
        this.sync();
    }

    public static String getFormattedTime(long ticks) {
        int hours = (int) ((Math.floor(ticks / 1000.0) + 6) % 24);
        int minutes = (int) Math.floor((ticks % 1000) / 1000.0 * 60);
        return String.format("%02d:%02d", hours, minutes);
    }

    public static ChatFormatting getFromColor(DyeColor color) {
        switch (color) {
            case ORANGE: return ChatFormatting.GOLD;
            case MAGENTA: return ChatFormatting.LIGHT_PURPLE;
            case LIGHT_BLUE: return ChatFormatting.BLUE;
            case YELLOW: return ChatFormatting.YELLOW;
            case LIME: return ChatFormatting.GREEN;
            case PINK: return ChatFormatting.LIGHT_PURPLE;
            case GRAY: return ChatFormatting.DARK_GRAY;
            case LIGHT_GRAY: return ChatFormatting.GRAY;
            case CYAN: return ChatFormatting.DARK_AQUA;
            case PURPLE: return ChatFormatting.DARK_PURPLE;
            case BLUE: return ChatFormatting.DARK_BLUE;
            case BROWN: return ChatFormatting.RED;
            case GREEN: return ChatFormatting.DARK_GREEN;
            case RED: return ChatFormatting.DARK_RED;
            case BLACK: return ChatFormatting.BLACK;
            default: return ChatFormatting.WHITE;
        }
    }
}