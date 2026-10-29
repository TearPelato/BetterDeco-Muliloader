package net.tier1234.better_deco;

import net.tearpelato.craftcorelib.api.config.ConfigBuilder;
import net.tearpelato.craftcorelib.api.config.ConfigType;
import net.tearpelato.craftcorelib.api.config.ConfigValue;

public class ModConfigs {

    public static final ConfigValue<Boolean> allowAllLiquids;
    public static final ConfigValue<Integer> capacitySink;
    public static final ConfigValue<Integer> capacityBasin;
    public static final ConfigValue<Integer> capacityBath;
    public static final ConfigValue<Integer> capacityToilet;

    public static final ConfigBuilder BUILDER = new ConfigBuilder(Constants.MOD_ID, ConfigType.SERVER);

    static {
        BUILDER.start("fluid");
         //Sink
         BUILDER.start("sink");
         allowAllLiquids = BUILDER.comment("allow_all_liquids").defineBoolean("allow_all_liquids", false);
         capacitySink = BUILDER.comment("sink_capacity").defineInt("sink_capacity",3,1,5);
         BUILDER.end();
         //Basin
         BUILDER.start("basin");
         capacityBasin = BUILDER.comment("basin_capacity").defineInt("basin_capacity",3,1,5);
         BUILDER.end();
         //BathTube
         BUILDER.start("bath");
         capacityBath = BUILDER.comment("bath_capacity").defineInt("bath_capacity",10,1,13);
         BUILDER.end();
         //Toilet
         BUILDER.start("toilet");
         capacityToilet = BUILDER.comment("toilet_capacity").defineInt("toilet_capacity",1,1,3);
         BUILDER.end();


        BUILDER.end();
    }

    public static void init() {
        BUILDER.build();
    }

}
