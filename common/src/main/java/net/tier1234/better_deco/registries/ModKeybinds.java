package net.tier1234.better_deco.registries;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import org.apache.logging.log4j.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class ModKeybinds {

    public static final KeyMapping KEY_MAPPING_G = new KeyMapping("key.better_deco.g",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.better_deco");

    public static final Lazy<KeyMapping> PRESS_G = Lazy.lazy(() -> KEY_MAPPING_G);

    public static void init() {

    }

}
