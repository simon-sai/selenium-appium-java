package steps.demo.android;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.demo.DemoFlutterApp;

public class DemoFlutterSteps {

    private final DemoFlutterApp demoFlutterApp;

    public DemoFlutterSteps() {
        this.demoFlutterApp = new DemoFlutterApp();
    }

    @Given("Demo Flutter has intergration installed")
    public void Flutter_calculator_installed() {
        this.demoFlutterApp.report("Demo Flutter has intergration installed");
        this.demoFlutterApp.install();
        // this.demoFlutterApp.install("src/test/resources/apk/flutter-intergration-demo.apk");
    }

    @When("I open app Demo Flutter has intergration")
    public void I_open_app_Demo_Flutter_has_intergration() {
        this.demoFlutterApp.report("I open flutter calculator");
        this.demoFlutterApp.open();
    }
}
