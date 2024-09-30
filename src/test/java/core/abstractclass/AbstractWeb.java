package core.abstractclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import core.KeySend;
import core.driver.DriverManager;

public abstract class AbstractWeb extends AbstractWebDriverIO {

    @Override
    public void initDriver() {
        if (DriverManager.getWebDriver() == null) {
            DriverManager.newWebDriver();
        }
    }

    public void navigateToTheUrl(String url) {
        DriverManager.getCurrentDriver().navigate().to(url);
    }

    public String getCurrentUrl() {
        return DriverManager.getCurrentDriver().getCurrentUrl();
    }

    public void actionClick(WebElement target) {
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.click(target).build().perform();
    }

    public void actionSendKeys(WebElement target, String text) {
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.sendKeys(target, text).build().perform();
    }

    public void actionTyping(String text) {
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.sendKeys(text).build().perform();
    }

    public void actionSendKeys(String key) {
        Keys keySend = KeySend.fromString(key);
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.sendKeys(keySend).build().perform();
    }

    public void clickByJavascript(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) DriverManager.getWebDriver();
        js.executeScript("arguments[0].click();", element);
    }

    public void clickByPosition(WebElement element, int x, int y) {
        Actions action = new Actions(DriverManager.getCurrentDriver());
        action.moveToElement(element, x, y).click().perform();
    }

    public void switchToIFrame(int index) {
        WebDriver webDriver = DriverManager.getCurrentDriver();
        webDriver.switchTo().frame(index);
    }

    public void switchToIFrame(WebElement iframe) {
        WebDriver webDriver = DriverManager.getCurrentDriver();
        webDriver.switchTo().frame(iframe);
    }
}