package core.driver;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import core.Report;
import core.utilities.Config;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.options.BaseOptions;

/*
 * TODO: How to manage cross-platform and multi devices scenarios?
 */
public class DriverManager {
    protected static WebDriver currentDriver;
    protected static WebDriver webDriver;
    protected static AndroidDriver androidDriver;

    public static String uiAutomatorName = "UiAutomator2";
    public static String flutterIntergrationName = "FlutterIntegration";

    public static WebDriver getCurrentDriver() {
        return currentDriver;
    }

    public static AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static WebDriver newWebDriver() {
        Report.println("-- newWebDriver --");
        webDriver = new ChromeDriver(OptionsManager.getChromeOptions());
        currentDriver = webDriver;
        return webDriver;
    }

    public static AndroidDriver newFlutterDriver(String appPackage, String appActivity) {
        return newAndroidDriver(DriverManager.flutterIntergrationName, null, null, appPackage, appActivity);
    }

    public static AndroidDriver newFlutterDriver(String app) {
        return newAndroidDriver(DriverManager.flutterIntergrationName, null, app, null, null);
    }

    public static AndroidDriver newAndroidDriver() {
        return newAndroidDriver(DriverManager.uiAutomatorName, null, null, null, null);
    }

    public static AndroidDriver newAndroidDriver(
            String automationName,
            String deviceName,
            String app,
            String appPackage,
            String appActivity) {
        Report.println(String.format("-- newAndroidDriver: %s", automationName));
        URI uri;
        URL url;

        if (deviceName == null) {
            deviceName = Config.getEnvString("DEVICE_NAME");
        }

        @SuppressWarnings("rawtypes")
        BaseOptions options = new BaseOptions().amend("appium:automationName", automationName);
        options.amend("appium:deviceName", deviceName);
        options.amend("platformName", "Android");

        if (app == null) {
            if (appPackage != null) {
                Report.println(String.format("-- openPackageActivity: %s", appPackage));
                options.amend("appium:appPackage", appPackage);
                options.amend("appium:appActivity", appActivity);
            }
        } else {
            Report.println(String.format("-- installApp: %s", app));
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
        Report.println("-- DriverManager quitAll");
        if (webDriver != null) {
            webDriver.quit();
            webDriver = null;
        }

        if (androidDriver != null) {
            androidDriver.quit();
            androidDriver = null;
        }

        currentDriver = null;
    }
}
