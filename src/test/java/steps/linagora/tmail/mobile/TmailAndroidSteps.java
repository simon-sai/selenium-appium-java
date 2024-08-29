package steps.linagora.tmail.mobile;

import core.Report;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.linagora.tmail.mobile.TmailApp;

public class TmailAndroidSteps {

    private final TmailApp tmailApp;

    public TmailAndroidSteps() {
        this.tmailApp = new TmailApp();
    }

    @Given("I has Tmail app already installed")
    public void I_has_Tmail_app_already_install() {
        Report.log("I has Tmail app already installed");

        String rootPath = System.getProperty("user.dir");
        this.tmailApp.install(rootPath + "/src/test/resources/apk/tmail-app.apk");
    }

    @When("I open Tmail app")
    public void I_open_Tmail_app() {
        Report.log("I open Tmail app");
        this.tmailApp.open();
    }

    @When("I close Tmail app")
    public void I_close_Tmail_app() {
        Report.log("I close Tmail app");
        this.tmailApp.close();
    }

}
