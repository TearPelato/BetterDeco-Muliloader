package net.tier1234.better_deco;

import net.tearpelato.craftcorelib.api.config.ConfigCategory;
import net.tearpelato.craftcorelib.api.config.ConfigManager;
import net.tearpelato.craftcorelib.api.config.ConfigType;
import net.tearpelato.craftcorelib.api.config.ConfigValue;

public class ModConfigs {

    public static final ConfigCategory FLUID = ConfigCategory.create(Constants.MOD_ID, ConfigType.CLIENT);
    public static final ConfigCategory SINK = FLUID.child("sink").title("config.better_deco.fluid.sink");
    public static final ConfigCategory BASIN = FLUID.child("basin").title("config.better_deco.fluid.basin");
    public static final ConfigCategory BATH = FLUID.child("bath").title("config.better_deco.fluid.bath");
    public static final ConfigCategory TOILET = FLUID.child("toilet").title("config.better_deco.fluid.toilet");

    public static final ConfigValue<Boolean> allowAllLiquids = SINK
            .define("allow_all_liquids", false)
            .name("allow_all_liquids")
            .comment("config.better_deco.fluid.sink.allow_all_liquids.desc");

    public static final ConfigValue<Integer> capacitySink = SINK
            .define("capacity", 3)
            .range(1,5).slider()
            .name("capacity")
            .comment("config.better_deco.fluid.capacity.desc");

    public static final ConfigValue<Integer> capacityBasin = BASIN
            .define("capacity", 3)
            .range(1,5).slider()
            .name("capacity")
            .comment("config.better_deco.fluid.capacity.desc");

    public static final ConfigValue<Integer> capacityBath = BATH
            .define("capacity", 10)
            .range(1,13).slider()
            .name("capacity")
            .comment("config.better_deco.fluid.capacity.desc");

    public static final ConfigValue<Integer> capacityToilet = TOILET
            .define("capacity", 1)
            .range(1,2).slider()
            .name("capacity")
            .comment("config.better_deco.fluid.capacity.desc");



    public static void init() {
        ConfigManager.register(Constants.MOD_ID, FLUID);
    }

}
