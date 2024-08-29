package steps;

import io.cucumber.java.en.When;
import pages.CommonAndroid;

public class CommonAndroidSteps {

    private final CommonAndroid commonAndroid;

    public CommonAndroidSteps() {
        this.commonAndroid = new CommonAndroid();
    }

    @When("I open android app from env")
    public void I_open_android_app_from_env() {
        this.commonAndroid.report("I open android app from env");
        this.commonAndroid.open();
    }

    @When("I close android app from app")
    public void I_close_android_app_from_env() {
        this.commonAndroid.report("I close android app from app");
        this.commonAndroid.close();
    }
}
