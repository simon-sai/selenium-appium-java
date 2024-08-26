package steps.linagora.tmail.web.compose;

import org.openqa.selenium.WebElement;

import core.Report;
import core.utilities.Config;
import core.verify.Verify;
import io.cucumber.java.en.When;
import pages.linagora.tmail.web.ComposePage;

public class ComposeSteps {

    private final ComposePage composePage;

    public ComposeSteps() {
        this.composePage = new ComposePage();
    }

    @When("I see New Message popup")
    public void I_see_New_Message_popup() {
        Report.log("I see New Message popup");
        WebElement webElement = this.composePage.getSendButton();
        Verify.IsTrue(webElement.isDisplayed());
    }

    @When("I click on Compose Button")
    public void I_click_on_Compose_Button() {
        Report.log("I click on Compose Button");
        WebElement composeButton = this.composePage.getComposeButton();
        composeButton.click();
    }

    @When("I enter email of second user into receiver input")
    public void I_enter_email_of_second_user_into_receiver_input() {
        Report.log("I enter email of second user into receiver input");
        String secondUserEmail = Config.getUserEmail("2");
        WebElement receiversInput = this.composePage.getReceiversInput();
        this.composePage.actionClick(receiversInput);
        this.composePage.actionSendKeys(receiversInput, secondUserEmail);

        // Write code here that turns the phrase above into concrete actions
    }

}
