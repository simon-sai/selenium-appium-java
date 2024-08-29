package core.abstractclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import core.driver.DriverManager;

public abstract class AbstractWeb extends AbstractWebDriverIO {

    public AbstractWeb() {
        super();
    }

    public void navigateToTheUrl(String url) {
        DriverManager.getCurrentDriver().navigate().to(url);
    }

    public String getCurrentUrl() {
        return DriverManager.getCurrentDriver().getCurrentUrl();
    }

    public void actionClick(WebElement target) {
        this.sleep(500);
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.click(target).build().perform();
    }

    public void actionSendKeys(WebElement target, String text) {
        this.sleep(500);
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.sendKeys(target, text).build().perform();
    }
}