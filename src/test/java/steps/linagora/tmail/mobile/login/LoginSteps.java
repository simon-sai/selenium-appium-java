package steps.linagora.tmail.mobile.login;

import io.cucumber.java.en.When;
import pages.linagora.tmail.mobile.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }

    @When("I login as first user on tmail app")
    public void I_login_as_first_user_on_tmail_app() {
        this.loginPage.loginAsFirstUser();
    }
}
