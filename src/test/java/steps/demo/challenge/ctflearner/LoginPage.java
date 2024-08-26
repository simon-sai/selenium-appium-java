package steps.demo.challenge.ctflearner;

import org.openqa.selenium.By;

import io.cucumber.java.en.When;

public class LoginPage extends CtfLearnPage {

    @Override
    protected String getUri() {
        return "/user/login";
    }

    protected By getInputIdentifierLocator() {
        return this.byDynamic("input", "id", "identifier");
    }

    protected By getInputPasswordLocator() {
        return this.byDynamic("input", "id", "password");
    }

    protected By getButtonSubmitLocator() {
        return this.byDynamic("button", "type", "submit");
    }

    @When("I already login on CTF Learn")
    public void iAlreadyLoginOnCtfLearn() {
        this.report("I already login on CTF Learn");

        this.navigateToTheUrl(this.getUrl());

        String username = this.getMyConfigFromText("env-configs:USERNAME");
        this.sendText(this.getInputIdentifierLocator(), username);

        String password = this.getMyConfigFromText("env-configs:PASSWORD");
        this.sendText(this.getInputPasswordLocator(), password);

        this.clickElement(this.getButtonSubmitLocator());

        // We can verify login success here
    }
}
