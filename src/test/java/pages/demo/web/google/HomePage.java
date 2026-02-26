package pages.demo.web.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.abstractclass.AbstractWeb;

public class HomePage extends AbstractWeb {

    private static final String HOME_URL = "https://www.google.com/?hl=en";

    private final By searchBox     = By.cssSelector("textarea.gLFyf");
    private final By firstResultH3 = By.cssSelector("h3");

    @Override
    public void initDriver() {
        // Driver is initialized by PageGeneratorGoogle before this page is created
    }

    public String Url() {
        return HOME_URL;
    }

    public void Search(String keyword) {
        WebElement input = this.findElement(searchBox);
        input.clear();
        input.sendKeys(keyword);
        this.actionSendKeys("enter");
    }

    public WebElement GetResultTitle() {
        return this.findElement(firstResultH3);
    }
}
