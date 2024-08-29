package pages.demo;

import org.openqa.selenium.By;

import core.abstractclass.AbstractFlutter;

public class DemoFlutterApp extends AbstractFlutter {

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
