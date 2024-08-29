package core.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.utilities.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

/*
 * TODO: How to manage cross-platform and multi devices scenarios?
 */
public class DriverManager {
    protected static WebDriver currentDriver;
    protected static WebDriver chromeDriver;
    protected static AndroidDriver androidDriver;

    public static String currentDriverName = "";
    public static String chromeName = "chrome";
    public static String androidName = "android";
    public static String flutterName = "flutter";
    public static String uiAutomatorName = "UiAutomator2";
    public static String flutterIntergrationName = "FlutterIntegration";

    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static WebDriver getChromeDriver() {
        if (chromeDriver == null) {
            chromeDriver = new ChromeDriver(OptionsManager.getChromeOptions());
            currentDriver = chromeDriver;
        }

        return chromeDriver;
    }

    public static AndroidDriver newFlutterDriver(String app) {
        return newAndroidDriver(flutterIntergrationName, null, app);
    }

    public static AndroidDriver newAndroidDriver() {
        return newAndroidDriver(uiAutomatorName, null, null);
    }

    public static AndroidDriver newAndroidDriver(String automationName, String deviceName, String app) {
        currentDriverName = androidName;
        URI uri;
        URL url;

        if (deviceName == null) {
            deviceName = Config.getEnvString("DEVICE_NAME");
        }

        @SuppressWarnings("rawtypes")
        BaseOptions options = new BaseOptions().amend("appium:automationName", automationName);
        options.amend("appium:deviceName", deviceName);
        options.amend("platformName", "Android");
        if (app != null) {
            options.amend("appium:app", app);
        }

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
        currentDriver = androidDriver;
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

        currentDriver = null;
        currentDriverName = "";
    }
}
