package core.abstractclass;

import core.driver.DriverManager;

public abstract class AbstractFlutter extends AbstractAndroidApp {

    @Override
    public void initDriver() {
        DriverManager.newFlutterDriver(this.getApkLocation());
    }
}