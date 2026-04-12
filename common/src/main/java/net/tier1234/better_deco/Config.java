package net.tier1234.better_deco;

import com.mrcrayfish.framework.api.config.ConfigType;
import com.mrcrayfish.framework.api.config.FrameworkConfig;

public class Config {

    @FrameworkConfig(id = Constants.MOD_ID, name = "client", type = ConfigType.CLIENT)
    public static final Client CLIENT = new Client();

    public static class Client {


    }
}
