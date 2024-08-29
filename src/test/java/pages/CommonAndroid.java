package pages;

import core.abstractclass.AbstractAndroidApp;
import core.utilities.Config;

public class CommonAndroid extends AbstractAndroidApp {
    public CommonAndroid() {
        super();
    }

    @Override
    protected String appPackage() {
        return Config.getEnvString("APP_PACKAGE");
    }

    @Override
    protected String mainActivity() {
        return Config.getEnvString("APP_ACTIVITY");
    }
}
