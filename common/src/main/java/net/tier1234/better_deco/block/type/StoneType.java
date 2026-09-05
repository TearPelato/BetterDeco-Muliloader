package net.tier1234.better_deco.block.type;

import net.minecraft.util.StringRepresentable;

public enum StoneType implements StringRepresentable {
    STONE("stone"),
    GRANITE("granite"),
    DIORITE("diorite"),
    ANDESITE("andesite"),
    DEEPSLATE("deepslate");

    private final String id;

    StoneType(String id) {
        this.id= id;

    }

    public String getName() {
        return this.id;
    }

    @Override
    public String toString() {
        return this.getSerializedName();
    }

    @Override
    public String getSerializedName() {
        return this.id;
    }
}
