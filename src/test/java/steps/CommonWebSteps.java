package steps;

import org.openqa.selenium.By;

import core.Report;
import core.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonWeb;

public class CommonWebSteps {

    private final CommonWeb commonPage;

    public CommonWebSteps() {
        this.commonPage = new CommonWeb();
    }

    @When("I open url {string}")
    public void iOpenUrl(String url) {
        this.commonPage.report(String.format("Open URL %s", url));
        this.commonPage.navigateToTheUrl(url);
    }

    @And("I send text {string} to the tag {string} has {string} is {string}")
    public void iSendTextToTheTagHasIs(String text, String tagName, String attributeName, String attributeValue) {
        String message = "Enter '%s' to '%s' has '%s' is '%s'";
        this.commonPage.report(String.format(message, text, tagName, attributeName, attributeValue));
        text = this.commonPage.getMyConfigFromText(text);

        By byDynamic = this.commonPage.byDynamic(tagName, attributeName, attributeValue);
        this.commonPage.sendText(byDynamic, text);
    }

    @And("I wait {int} seconds")
    public void iWaitSeconds(int seconds) {
        this.commonPage.report(String.format("Wait %d seconds", seconds));
        this.commonPage.sleepInSecond(seconds);
    }

    @And("I click on tag {string} has {string} is {string}")
    public void iClickOnTagHasIs(String tagName, String attributeName, String attributeValue) {
        String message = "Click on '%s' has '%s' is '%s'";
        this.commonPage.report(String.format(message, tagName, attributeName, attributeValue));
        By byDynamic = this.commonPage.byDynamic(tagName, attributeName, attributeValue);
        this.commonPage.clickElement(byDynamic);
    }

    @Then("I see tag {string} has text is {string}")
    public void iSeeTagHasTextIs(String tagName, String text) {
        String message = "I see tag '%s' has text is '%s'";
        this.commonPage.report(String.format(message, tagName, text));
        text = this.commonPage.getMyConfigFromText(text);
        this.commonPage.findElementHasText(tagName, text);
    }

    @When("I take a screenshot")
    public void I_take_a_screenshot() {
        Report.screenshot(Status.INFO);
    }

}
