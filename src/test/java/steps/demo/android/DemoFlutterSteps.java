package steps.demo.android;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.demo.DemoFlutterApp;

public class DemoFlutterSteps {

    private final DemoFlutterApp demoFlutterApp;

    public DemoFlutterSteps() {
        this.demoFlutterApp = new DemoFlutterApp();
        this.demoFlutterApp.initDriver();
    }

    @Given("Demo Flutter has intergration installed")
    public void Flutter_calculator_installed() {
        this.demoFlutterApp.report("Demo Flutter has intergration installed");

        // Actually flutter app already installed when initDriver
        this.demoFlutterApp.install();
    }

    @When("I open Demo Flutter app has intergration")
    public void I_open_Demo_Flutter_app_has_intergration() {
        this.demoFlutterApp.report("I open Demo Flutter app has intergration");
        this.demoFlutterApp.open();
    }

    @When("I close Demo Flutter app")
    public void I_close_Demo_Flutter_app() {
        this.demoFlutterApp.report("I close Demo Flutter app");
        this.demoFlutterApp.close();
    }
}
