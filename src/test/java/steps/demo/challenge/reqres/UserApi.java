package steps.demo.challenge.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class UserApi extends ReqresApi {

    @Override
    protected String getUri() {
        return "/api/users/%d";
    }

    @When("I get user data has id is {int}")
    public void iGetUserDataHasIdIs(int userId) {
        this.report("I get user data has id is " + userId);
        String url = String.format(this.getUrl(), userId);
        this.getJson(url);
    }

    @And("I see first name is {string}")
    public void iSeeFirstNameIs(String expectFirstName) {
        this.report("I see first name is " + expectFirstName);
        String actualFirstName = this.getJsonPath("data.first_name");
        this.equalAssert.Equal(actualFirstName, expectFirstName);
    }

    @And("I change first name of current user to {string}")
    public void iChangeFirstNameOfCurrentUserTo(String newName) {
        this.report("I change first name of current user to " + newName);
        int currentUserId = Integer.parseInt(this.getJsonPath("data.id"));

        String url = String.format(this.getUrl(), currentUserId);
        String format = "{ \"name\": \"%s\" }";
        String jsonBody = String.format(format, newName);
        this.putJson(url, jsonBody);

        String newNameResponse = this.getJsonPath("name");
        this.equalAssert.Equal(newName, newNameResponse);
    }
}
