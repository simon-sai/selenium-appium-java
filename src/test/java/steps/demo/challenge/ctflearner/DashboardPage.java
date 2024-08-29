package steps.demo.challenge.ctflearner;

import core.driver.DriverManager;
import io.cucumber.java.en.And;

public class DashboardPage extends CtfLearnPage {

    @Override
    protected String getUri() {
        return "/dashboard";
    }

    @And("I see Dashboard page opened")
    public void iSeeDashboardPageOpened() {
        this.report("I see Dashboard page opened");
        String currentUrl = DriverManager.getCurrentDriver().getCurrentUrl();
        this.equalAssert.Equal(currentUrl, this.getUrl());
    }

}
