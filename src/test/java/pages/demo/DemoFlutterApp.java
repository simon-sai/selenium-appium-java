package pages.demo;

import org.openqa.selenium.By;

import core.abstractclass.AbstractAndroidFlutter;

public class DemoFlutterApp extends AbstractAndroidFlutter {

    protected By plusXpath = By.xpath("//android.widget.Button[@content-desc=\"Plus\"]");

    @Override
    protected String appPackage() {
        return "com.datdang.flutter_appium";
    }

    @Override
    protected String mainActivity() {
        return ".MainActivity";
    }

    @Override
    protected String getApkLocation() {
        return "src/test/resources/apk/flutter-intergration-demo.apk";
    }
}
