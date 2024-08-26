package steps.demo.android;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.demo.CalculatorFlutter;

public class CalculatorFluttterSteps {

    private final CalculatorFlutter calculatorFlutter;

    public CalculatorFluttterSteps() {
        this.calculatorFlutter = new CalculatorFlutter();
    }

    @When("I open flutter calculator")
    public void I_open_flutter_calculator() {
        this.calculatorFlutter.report("I open flutter calculator");
        this.calculatorFlutter.open();
    }

    @Given("Flutter calculator installed")
    public void Flutter_calculator_installed() {
        this.calculatorFlutter.install("src/test/resources/apk/simplistic-calculator.apk");
    }

}
