package pages.linagora.tmail.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.utilities.Config;

public class LoginPage extends WebDomain {

    private final By inputUsername = this.byDynamic("input", "id", "username");
    private final By inputPassword = this.byDynamic("input", "id", "password");
    private final By buttonSignIn = this.byDynamic("input", "id", "kc-login");

    @Override
    public String Uri() {
        return "/login";
    }

    public WebElement getUsernameInput() {
        return this.findElement(this.inputUsername);
    }

    public void login(String username, String passowrd) {
        this.sendText(this.inputUsername, username);
        this.sleep(200);
        this.sendText(this.inputPassword, passowrd);
        this.sleep(200);
        this.clickElement(this.buttonSignIn);
    }

    public void loginAsFirstUser() {
        String username = Config.getUserEmail("1");
        String password = Config.getUserPassword("1");
        this.login(username, password);
    }
}
