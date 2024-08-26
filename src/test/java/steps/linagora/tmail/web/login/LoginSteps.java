package steps.linagora.tmail.web.login;

import core.Report;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.linagora.tmail.web.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @When("I already login with a Twake Account")
    public void I_already_login_with_Twake_Account() {
        Report.log("I already login with a Twake Account");
        this.loginPage.GoTo();
        this.loginPage.loginAsFirstUser();
    }

    @Given("I am on Tmail Login Page")
    public void I_m_on_Tmail_Login_Page() {
        Report.log("I am on Tmail Login Page");
        this.loginPage.GoTo();
    }

    @When("I login to Tmail Login Form")
    public void I_login_to_Tmail_Login_Form() {
        Report.log("I login to Tmail Login Form");
        this.loginPage.loginAsFirstUser();
    }
}
