package steps.demo.challenge.ctflearner;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Report;
import core.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChallengePage extends CtfLearnPage {

    protected String lastChallengeTitle = "";

    @Override
    protected String getUri() {
        return "/challenge/1/browse";
    }

    protected By getInputTitleLocator() {
        return this.byDynamic("input", "id", "title");
    }

    protected By getInputFlagLocator() {
        return this.byDynamic("input", "id", "flag");
    }

    protected By getTextHowLocator() {
        return this.byDynamic("textarea", "id", "howtosolve");
    }

    protected By getButtonSubmitLocator() {
        return this.byDynamic("button", "type", "submit");
    }

    protected By getChallengeNameLocator() {
        return this.byDynamic("span", "id", "title-display");
    }

    @When("I open Create Challenge page")
    public void iOpenCreateChallengePage() {
        this.report("I open Create Challenge page");
        this.clickElement(this.getAnchorChallengesDropdownLocator());
        this.clickElement(this.getAnchorCreateChallengeLocator());
    }

    @When("I create a random Challenge")
    public void iCreateARandomChallenge() {
        this.report("I create a random Challenge");
        String randomString = "Title-" + RandomStringUtils.randomAlphabetic(7);
        this.lastChallengeTitle = randomString;
        this.sendText(this.getInputTitleLocator(), randomString);

        String format = "CTFlearn{'%s'}";
        String randomFlag = String.format(format, RandomStringUtils.randomAlphabetic(7));
        this.sendText(this.getInputFlagLocator(), randomFlag);

        String randomHow = "How-" + RandomStringUtils.randomAlphabetic(27);
        this.sendText(this.getTextHowLocator(), randomHow);

        this.clickElement(this.getButtonSubmitLocator());
    }

    @Then("I see last challenge name appear")
    public void iSeeLastChallengeNameAppear() {
        this.report("I see last challenge name appear");
        WebElement element = this.findElement(this.getChallengeNameLocator());
        this.elementAssert.HasText(element, this.lastChallengeTitle);
    }

    @When("I open My Challenge page")
    public void iOpenMyChallengePage() {
        this.report("I open My Challenge page");
        this.clickElement(this.getAnchorChallengesDropdownLocator());
        this.clickElement(this.getAnchorMyChallengeLocator());
    }

    @And("I see last challenge name in My Challenge page")
    public void iSeeLastChallengeNameInMyChallengePage() {
        // TODO: this is for demo only, we can make this step faster
        this.report("I see last challenge name in My Challenge page");
        By byDynamic = this.byText("span", this.lastChallengeTitle);
        this.findElement(byDynamic);
        Report.screenshot(Status.PASS);
    }

    @When("I create a Challenge with wrong flag")
    public void iCreateAChallengeWithoutTitle() {
        this.report("I create a Challenge with wrong flag");

        String randomString = "Title-" + RandomStringUtils.randomAlphabetic(7);
        this.lastChallengeTitle = randomString;
        this.sendText(this.getInputTitleLocator(), randomString);

        String format = "Wrong{'%s'}";
        String randomFlag = String.format(format, RandomStringUtils.randomAlphabetic(7));
        this.sendText(this.getInputFlagLocator(), randomFlag);

        String randomHow = "How-" + RandomStringUtils.randomAlphabetic(27);
        this.sendText(this.getTextHowLocator(), randomHow);

        this.clickElement(this.getButtonSubmitLocator());

    }

    @Then("I see error message of flag appear")
    public void iSeeErrorMessageOfFlagAppear() {
        this.report("I see error message of flag appear");
        this.findElementHasText("div", "Flag must be in the form CTFlearn{}");
        this.reportPass("I see error message appear");
        Report.screenshot(Status.PASS);
    }
}
