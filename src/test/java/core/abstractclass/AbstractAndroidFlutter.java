package core.abstractclass;

import core.driver.DriverManager;

public abstract class AbstractAndroidFlutter extends AbstractAndroid {

    @Override
    public void initDriver() {
        DriverManager.newFlutterDriver(this.getApkLocation());
    }
}