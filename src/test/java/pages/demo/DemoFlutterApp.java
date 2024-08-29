package pages.demo;

import org.openqa.selenium.By;

import core.abstractclass.AbstractAndroid;

public class DemoFlutterApp extends AbstractAndroid {

    protected By plusXpath = By.xpath("//android.widget.Button[@content-desc=\"Plus\"]");

    public DemoFlutterApp() {
        super();
    }

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
