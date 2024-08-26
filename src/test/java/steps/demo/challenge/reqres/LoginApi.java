package steps.demo.challenge.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginApi extends ReqresApi {

    @Override
    protected String getUri() {
        return "/api/login";
    }

    protected void callLoginApi(String email, String password) {
        String format = "{ \"email\": \"%s\", \"password\": \"%s\" }";
        String jsonBody = String.format(format, email, password);
        this.postJson(this.getUrl(), jsonBody);
    }

    protected void callLoginWithoutPassword(String email) {
        String format = "{ \"email\": \"%s\"}";
        String jsonBody = String.format(format, email);
        this.postJson(this.getUrl(), jsonBody);
    }

    protected void callLoginWithoutEmail(String password) {
        String format = "{ \"password\": \"%s\" }";
        String jsonBody = String.format(format, password);
        this.postJson(this.getUrl(), jsonBody);
    }

    protected void getTokenFromResponse() {
        this.setToken(this.getJsonPath("token"));
    }

    @When("I call Login API")
    public void iCallLoginAPI() {
        this.setToken("");
        this.report("I call Login API");
        this.callLoginApi("eve.holt@reqres.in", "cityslicka"); // TODO: if it real, get password from my-config
        this.getTokenFromResponse();
    }

    @And("I see Login API has new token")
    public void iSeeLoginAPIHasNewToken() {
        this.report("I see Login API has new token");
        this.equalAssert.NotEmpty(this.getToken()); // TODO: if it real, should not show token in report
    }

    @When("I call Login API without password")
    public void iCallLoginAPIWithoutPassword() {
        this.report("I call Login API without password");
        this.callLoginWithoutPassword("peter@klaven");
    }

    @When("I call Login API without email")
    public void iCallLoginAPIWithoutEmail() {
        this.report("I call Login API without email");
        this.callLoginWithoutEmail("123qwe");
    }

    @Given("I already login with API")
    public void iAlreadyLoginWithAPI() {
        this.report("I already login with API");
        this.callLoginApi("george.bluth@reqres.in", "cityslicka"); // TODO: if it real, get password from my-config
        this.getTokenFromResponse();
    }
}
