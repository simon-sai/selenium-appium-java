package steps.demo.android;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.demo.android.CalculatorApp;

public class CalculatorSteps {

    private final CalculatorApp calculatorApp;

    public CalculatorSteps() {
        this.calculatorApp = new CalculatorApp();
        this.calculatorApp.initDriver();
    }

    @When("I open calculator app")
    public void I_open_flutter_calculator() {
        this.calculatorApp.report("I open calculator appr");
        this.calculatorApp.open();
    }

    @Given("Calculator app already installed")
    public void Flutter_calculator_installed() {
        this.calculatorApp.report("Calculator app already installed");
        this.calculatorApp.install("src/test/resources/apk/simplistic-calculator.apk");
    }

    @When("I close calculator app")
    public void I_close_calculator_app() {
        this.calculatorApp.report("I close calculator appr");
        this.calculatorApp.close();
    }

}
