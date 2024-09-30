package steps;

import core.Report;
import core.Status;
import core.abstractclass.AbstractBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CommonSteps {

    @And("I wait {int} seconds")
    public void iWaitSeconds(int seconds) {
        Report.log(String.format("I wait %d seconds", seconds));
        AbstractBase.sleep(seconds * 1000);
    }

    @When("I take a screenshot")
    public void I_take_a_screenshot() {
        Report.screenshot(Status.INFO);
    }

}
