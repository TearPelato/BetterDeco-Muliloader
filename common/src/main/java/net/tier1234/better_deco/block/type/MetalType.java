package net.tier1234.better_deco.block.type;

import com.mojang.serialization.Codec;
import net.minecraft.util.StringRepresentable;

import java.util.stream.Stream;

/**
 * Author: MrCrayfish
 */
public enum MetalType implements StringRepresentable
{
    LIGHT("light"),
    DARK("dark");

    public static final Codec<MetalType> CODEC = StringRepresentable.fromEnum(MetalType::values);

    private final String name;

    MetalType(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    @Override
    public String getSerializedName()
    {
        return this.name;
    }
}