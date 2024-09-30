package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Report;
import core.utilities.Utils;
import core.verify.Verify;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CommonWeb;

public class CommonWebSteps {

    private final CommonWeb commonWeb;

    public CommonWebSteps() {
        this.commonWeb = new CommonWeb();
        this.commonWeb.initDriver();
    }

    @When("I open url {string}")
    public void iOpenUrl(String url) {
        this.commonWeb.report(String.format("Open URL %s", url));
        this.commonWeb.navigateToTheUrl(url);
    }

    @And("I send text {string} to the tag {string} has {string} is {string}")
    public void iSendTextToTheTagHasIs(String text, String tagName, String attributeName, String attributeValue) {
        String message = "Enter '%s' to '%s' has '%s' is '%s'";
        this.commonWeb.report(String.format(message, text, tagName, attributeName, attributeValue));
        text = this.commonWeb.getMyConfigFromText(text);

        By byDynamic = this.commonWeb.byDynamic(tagName, attributeName, attributeValue);
        this.commonWeb.sendText(byDynamic, text);
    }

    @And("I click on tag {string} has {string} is {string}")
    public void iClickOnTagHasIs(String tagName, String attributeName, String attributeValue) {
        String message = "Click on '%s' has '%s' is '%s'";
        this.commonWeb.report(String.format(message, tagName, attributeName, attributeValue));
        By byDynamic = this.commonWeb.byDynamic(tagName, attributeName, attributeValue);
        this.commonWeb.clickElement(byDynamic);
    }

    @Then("I see tag {string} has text is {string}")
    public void iSeeTagHasTextIs(String tagName, String text) {
        String message = "I see tag '%s' has text is '%s'";
        this.commonWeb.report(String.format(message, tagName, text));
        text = this.commonWeb.getMyConfigFromText(text);
        WebElement element = this.commonWeb.findElementHasText(tagName, text);
        Verify.IsTrue(element.isDisplayed());
    }

    @When("I press {string} on web")
    public void I_press_on_web(String key) {
        Report.log(String.format("I press {%s} on web", key));
        this.commonWeb.actionSendKeys(key);
    }

    @When("I type {string} on web")
    public void I_type_on_web(String text) {
        Report.log(String.format("I type {%s} on web", text));
        this.commonWeb.actionTyping(text);
    }

    @When("I type random content start with {string} on web")
    public void I_type_random_content_start_with_on_web(String textPrefix) {
        Report.log(String.format("I type random content start with {%s} on web", textPrefix));
        String text = textPrefix + Utils.getRandomString(7);
        this.commonWeb.actionTyping(text);
    }
}
