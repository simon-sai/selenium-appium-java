package steps;

import io.cucumber.java.en.When;
import pages.CommonAndroid;

public class CommonAndroidSteps {

    private final CommonAndroid commonAndroid;

    public CommonAndroidSteps() {
        this.commonAndroid = new CommonAndroid();
    }

    @When("I open app from env")
    public void I_open_app_from_env() {
        this.commonAndroid.open();
    }
}
