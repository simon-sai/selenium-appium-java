package core.abstractclass;

import org.openqa.selenium.By;

import core.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractAndroid extends AbstractWebDriverIO {
    protected AndroidDriver androidDriver;

    public AbstractAndroid() {
        super();

        this.androidDriver = DriverManager.getAndroidDriver();
        if (this.androidDriver == null) {
            throw new IllegalStateException("Android driver is NULL");
        }
    }

    protected abstract String appPackage();

    protected abstract String mainActivity();

    protected String getApkLocation() {
        throw new IllegalStateException("APK location not set");
    }

    public void open() {
        this.androidDriver.activateApp(this.appPackage());
    }

    public void close() {
        this.androidDriver.terminateApp(this.appPackage());
    }

    public void install() {
        String appPath = this.getApkLocation();
        this.install(appPath);
    }

    public void install(String appPath) {
        this.androidDriver.installApp(appPath);
    }

    protected By byText(String buttonText) {
        String expression = "//*[@text='%s']";
        return By.xpath(String.format(expression, buttonText));
    }

    protected By byContentContain(String text) {
        String expression = "//*[contains(@content-desc,'%s')]";
        return By.xpath(String.format(expression, text));
    }
}