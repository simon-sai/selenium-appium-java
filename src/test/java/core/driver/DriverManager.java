package core.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.utilities.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

/*
 * TODO: How to manage cross-platform and multi devices scenarios?
 */
public class DriverManager {
    protected static WebDriver driver;
    protected static WebDriver chromeDriver;
    protected static AndroidDriver androidDriver;

    public static String currentDriver = "";
    public static String chromeName = "chrome";
    public static String androidName = "android";

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = getDriver(currentDriver);
        }

        return driver;
    }

    public static WebDriver getWebDriverIO() {
        if (driver == null) {
            driver = getDriver(chromeName);
        }

        return driver;
    }

    public static WebDriver getDriver(String driverName) {
        // core.Report.println("------- getDriver: " + driverName);

        if (currentDriver.equals(driverName)) {
            return driver;
        }

        if (driverName.equals(chromeName)) {
            driver = getChromeDriver();
        }

        if (driverName.equals(androidName)) {
            driver = getAndroidDriver();
        }

        currentDriver = driverName;
        return driver;
    }

    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver(OptionsManager.getChromeOptions());
        }

        return chromeDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        if (androidDriver != null) {
            return androidDriver;
        }

        currentDriver = androidName;
        URI uri;
        URL url;

        String deviceName = Config.getEnvString("DEVICE_NAME");

        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setDeviceName(deviceName);

        // FlutterIntegrationTestDriver options = new FlutterIntegrationTestDriver()

        // @SuppressWarnings("rawtypes")
        // BaseOptions options = new BaseOptions()
        // .amend("platformName", "Android")
        // .amend("appium:deviceName", deviceName)
        // .amend("appium:flutterSystemPort", 9000)
        // .amend("appium:automationName", "FlutterIntegration");

        try {
            uri = new URI("http://127.0.0.1:4723");
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }

        try {
            url = uri.toURL();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        androidDriver = new AndroidDriver(url, options);

        driver = androidDriver;
        return androidDriver;
    }

    public static void quitAll() {
        if (chromeDriver != null) {
            chromeDriver.quit();
            chromeDriver = null;
        }

        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }

        driver = null;
        currentDriver = "";
    }
}
