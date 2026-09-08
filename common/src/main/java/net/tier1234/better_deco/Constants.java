package net.tier1234.better_deco;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Constants {
    private Constants() {}

    public static final String MOD_ID = "better_deco";
    public static final String MOD_NAME = "BetterDeco";
    public static final Logger LOG = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }


}
