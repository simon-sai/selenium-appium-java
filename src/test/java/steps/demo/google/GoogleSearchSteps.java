package steps.demo.google;

import org.openqa.selenium.WebElement;

import core.verify.Verify;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.demo.web.google.HomePage;
import pages.demo.web.google.PageGeneratorGoogle;

public class GoogleSearchSteps {

    private final PageGeneratorGoogle pagesGoogle;
    private final HomePage homePage;

    public GoogleSearchSteps() {
        this.pagesGoogle = new PageGeneratorGoogle();
        this.homePage = this.pagesGoogle.getHomePage();
    }

    @When("I open google homepage")
    public void I_open_google_homepage() {
        this.homePage.report("I open google homepage");
        String url = this.homePage.Url();
        this.homePage.navigateToTheUrl(url);
    }

    @When("I search with keyword {string}")
    public void I_send_search_with_keyword(String keyword) {
        this.homePage.report(String.format("I search with keyword {%s}", keyword));
        this.homePage.Search(keyword);
    }

    @Then("I see result relate to {string}")
    public void I_see_result_relate_to(String keyword) {
        this.homePage.report(String.format("I see result relate to {%s}", keyword));
        WebElement element = this.homePage.GetResultTitle();
        String elementText = element.getText();
        Verify.Equal(elementText, keyword);
    }
}
