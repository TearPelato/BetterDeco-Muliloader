package net.tier1234.better_deco.registries;

import net.minecraft.world.SimpleContainer;

public class ModInventory extends SimpleContainer {
    private IChanged change = null;
    public ModInventory(int size, IChanged change) {
        super(size);
        this.change = change;
    }

    public ModInventory(int size) {
        super(size);
    }


    public interface IChanged {
        public void changed(int slot);
    }
}