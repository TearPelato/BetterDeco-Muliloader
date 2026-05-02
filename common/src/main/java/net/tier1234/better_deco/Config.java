package net.tier1234.better_deco;

import com.mrcrayfish.framework.api.config.*;

public class Config {

    @FrameworkConfig(id = Constants.MOD_ID, name = "client", type = ConfigType.CLIENT)
    public static final Client CLIENT = new Client();

    public static class Client {
        @ConfigProperty(name = "Sink", comment = "Sinks related settings")
        public final Fluid sink = new Fluid();


    }

    public static class Fluid {
        @ConfigProperty(name = "Sink Allow All Liquids", comment = """
                Define if the sink accept all liquids: by default it accepts only water, turning this config to true,
                allow the sink to accept lava or modded fluids""")
        public final BoolProperty sinkAllowAllLiquids = BoolProperty.create(false);

        @ConfigProperty(name = "Sink Capacity", comment = """
                Define the maximun capcacity of sinks in buckets""")
        public final IntProperty sinkCapacity = IntProperty.create(3,1,10);


    }
}
