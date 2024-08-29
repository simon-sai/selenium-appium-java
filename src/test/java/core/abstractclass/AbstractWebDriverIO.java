package core.abstractclass;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import core.Report;
import core.Status;
import core.driver.DriverManager;
import core.utilities.Config;
import core.verify.ElementAssert;

public abstract class AbstractWebDriverIO extends AbstractBase {
    protected WebDriverWait explicitWait;
    protected ElementAssert elementAssert;

    public AbstractWebDriverIO() {
        super();
        this.elementAssert = new ElementAssert();
    }

    public ElementAssert ElementAssert() {
        return this.elementAssert;
    }

    public final WebDriverWait getWait(WebDriver driver, int millisecond) {
        if (explicitWait == null) {
            Duration timeOut = Duration.ofMillis(millisecond);
            explicitWait = new WebDriverWait(driver, timeOut);
        }
        return explicitWait;
    }

    public By byDynamic(String tagName, String attribute, String value) {
        String path = String.format("//%s[contains(@%s,'%s')]", tagName, attribute, value);
        return By.xpath(path);
    }

    public By byText(String tagName, String text) {
        String path = String.format("//%s[contains(text(),'%s')]", tagName, text);
        return By.xpath(path);
    }

    public WebElement findElement(By elementBy) {
        return this.findElement(this.explicitWait, elementBy);
    }

    public WebElement findElement(By elementBy, int millisecond) {
        return this.findElement(this.getWait(DriverManager.getCurrentDriver(), millisecond), elementBy);
    }

    public WebElement findElement(WebDriverWait explicDriverWait, By elementBy) {
        try {
            return explicDriverWait.until(ExpectedConditions.visibilityOfElementLocated(elementBy));
        } catch (Exception e) {
            String errorMessage = String.format("The element is not exist: %s", elementBy.toString());
            Report.log(errorMessage, Status.FAIL);
            Report.screenshot(Status.FAIL);
            Assert.fail(errorMessage);
        }
        return null;
    }

    public List<WebElement> findElements(By elementBy) {
        try {
            return this.explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
        } catch (Exception e) {
            String errorMessage = String.format("The elements are not exist: %s", elementBy.toString());
            Report.log(errorMessage, Status.FAIL);
            Report.screenshot(Status.FAIL);
            Assert.fail(errorMessage);
        }
        return null;
    }

    public WebElement sendText(By elementBy, String text) {
        WebElement element = this.findElementToClick(elementBy);
        this.sendText(element, text);
        return element;
    }

    public WebElement sendText(WebElement element, String text) {
        element.sendKeys(text);
        return element;
    }

    public WebElement clickElement(By elementBy) {
        WebElement element = this.findElementToClick(elementBy);
        element.click();
        return element;
    }

    public WebElement findElementToClick(By elementBy) {
        return this.findElementToClick(this.explicitWait, elementBy);
    }

    public WebElement findElementToClick(WebDriverWait explicDriverWait, By elementBy) {
        try {
            return explicDriverWait.until(ExpectedConditions.elementToBeClickable(elementBy));
        } catch (Exception e) {
            String errorMessage = String.format("The element is not exist or clickable: %s", elementBy.toString());
            Report.log(errorMessage, Status.FAIL);
            Report.screenshot(Status.FAIL);
            Assert.fail(errorMessage);
        }
        return null;
    }

    public String getMyConfigFromText(String text) {
        String[] arrayOfString = text.split("env-configs:");
        if (arrayOfString.length == 1)
            return text;
        return Config.getEnvString(arrayOfString[1]);
    }

    public WebElement findElementHasText(String tagName, String text) {
        By byDynamic = this.byText(tagName, text);
        return this.findElement(byDynamic);
    }
}