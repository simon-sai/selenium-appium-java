package core.abstractclass;

import org.openqa.selenium.By;

import core.driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public abstract class AbstractAndroid extends AbstractWebDriverIO {
    protected AndroidDriver androidDriver;

    protected abstract String appPackage();

    protected abstract String mainActivity();

    public void initDriver() {
        DriverManager.newAndroidDriver();
    }

    protected String getApkLocation() {
        String errorMessage = String.format("Sub class [%s] does not override method getApkLocation yet",
                this.getClass().getSimpleName());
        throw new IllegalStateException(errorMessage);
    }

    public AndroidDriver getAndroiDriver() {
        if (this.androidDriver == null) {
            this.androidDriver = DriverManager.getAndroidDriver();
        }
        return this.androidDriver;
    }

    public void open() {
        this.getAndroiDriver().activateApp(this.appPackage());
    }

    public void close() {
        this.getAndroiDriver().terminateApp(this.appPackage());
    }

    public void install() {
        String appPath = this.getApkLocation();
        this.install(appPath);
    }

    public void install(String appPath) {
        this.getAndroiDriver().installApp(appPath);
    }

    protected By byText(String buttonText) {
        String expression = "//*[@text='%s']";
        return By.xpath(String.format(expression, buttonText));
    }

    protected By byContentContain(String text) {
        String expression = "//*[contains(@content-desc,'%s')]";
        return By.xpath(String.format(expression, text));
    }

    protected void SwitchToWebView() {

    }
}