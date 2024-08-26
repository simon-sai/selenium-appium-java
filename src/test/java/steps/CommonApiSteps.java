package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.CommonApi;

public class CommonApiSteps {

    private final CommonApi commonApi;

    public CommonApiSteps() {
        this.commonApi = new CommonApi();
    }

    @Then("I see status code is {int}")
    public void iSeeStatusStatusCodeIs(int statusExpect) {
        this.commonApi.report(String.format("I see status code is %d", statusExpect));
        int resStatus = this.commonApi.getStatus();
        this.commonApi.EqualAssert().Equal(resStatus, statusExpect);
    }

    @And("I see error message is {string}")
    public void iSeeErrorMessageIs(String expectErrorMessage) {
        this.commonApi.report(String.format("I see error message is `%s`", expectErrorMessage));
        String actualErrorMessage = this.commonApi.getJsonPath("error");
        this.commonApi.EqualAssert().Equal(actualErrorMessage, expectErrorMessage);
    }
}
