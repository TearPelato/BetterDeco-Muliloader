package net.tier1234.better_deco;

import com.mrcrayfish.framework.api.config.*;

public class Config {

    @FrameworkConfig(id = Constants.MOD_ID, name = "server", type = ConfigType.SERVER_SYNC)
    public static final Server SERVER = new Server();

    public static class Server {
        @ConfigProperty(name = "Sink", comment = "Sinks Related Settings")
        public final Fluid sink = new Fluid(3,5);

        @ConfigProperty(name = "Basin", comment = "Basin Related settings")
        public final Fluid basin = new Fluid(3,5);

        @ConfigProperty(name = "BathTube", comment = "BathTube Related Settings")
        public final Fluid bathTube = new Fluid(10,13);

        @ConfigProperty(name = "Toilet", comment = "Toilet Related Settings")
        public final Fluid toilet = new Fluid(1,2);

        public static class Fluid {


            @ConfigProperty(name = "Allow All Liquids", comment = """
                Define if the sink accept all liquids: by default it accepts only water, turning this config to true,
                allow the sink to accept lava or modded fluids""")
            public BoolProperty allowAllLiquids = BoolProperty.create(false);

            @ConfigProperty(name = "Capacity", comment = """
                Define the maximun capcacity of sinks in buckets""")
            public final IntProperty capacity;

            public Fluid(int capacity, int maxCapacity) {
                this.capacity = IntProperty.create(capacity,1,maxCapacity);
            }


        }

    }


}
