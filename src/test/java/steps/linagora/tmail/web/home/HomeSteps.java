package steps.linagora.tmail.web.home;

import org.openqa.selenium.WebElement;

import core.Report;
import core.verify.Verify;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.linagora.tmail.web.HomePage;

public class HomeSteps {

    private final HomePage homePage;

    public HomeSteps() {
        this.homePage = new HomePage();
    }

    @When("I am on Twake Mail home page")
    public void I_already_on_Twake_Mail_home_page() {
        Report.log("I am on Twake Mail home page");
        this.homePage.GoTo();
        WebElement webElement = this.homePage.getSearchInput();
        Verify.IsTrue(webElement.isDisplayed());
    }

    @Then("I see Search Input")
    public void I_see_search_input() {
        Report.log("I see Search Input");

    }

    @Then("I see Compose Button of Tmail Dashboard")
    public void I_see_Compose_Button_of_Tmail_Dashboard() {
        Report.log("I see Compose Button of Tmail Dashboard");
        WebElement webElement = this.homePage.getComposeButton();
        Verify.IsTrue(webElement.isDisplayed());
    }
}
