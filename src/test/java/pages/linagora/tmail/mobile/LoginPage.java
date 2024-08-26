package pages.linagora.tmail.mobile;

import org.openqa.selenium.By;

import core.utilities.Config;

public class LoginPage extends TmailApp {

    private final By inputUsername = this.byDynamic("android.widget.TextEdit", "hint", "email");
    private final By buttonSignIn = this.byDynamic("android.widget.Button", "content-desc", "Next");

    // [@hint="Hello world"]
    public void login(String username, String passowrd) {

        this.sendText(this.inputUsername, username);
        this.sleep(200);
        // this.clickElement(this.buttonSignIn);

    }

    public void loginAsFirstUser() {
        String username = Config.getUserEmail("1");
        String password = Config.getUserPassword("1");
        this.login(username, password);
    }
}
