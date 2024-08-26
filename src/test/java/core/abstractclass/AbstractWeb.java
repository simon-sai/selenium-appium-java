package core.abstractclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import core.driver.DriverManager;

public abstract class AbstractWeb extends AbstractWebDriverIO {

    public AbstractWeb() {
        super();
    }

    public void navigateToTheUrl(String url) {
        DriverManager.getWebDriverIO().navigate().to(url);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void actionClick(WebElement target) {
        this.sleep(500);
        Actions action = new Actions(this.driver);
        action.click(target).build().perform();
    }

    public void actionSendKeys(WebElement target, String text) {
        this.sleep(500);
        Actions action = new Actions(this.driver);
        action.sendKeys(target, text).build().perform();
    }
}