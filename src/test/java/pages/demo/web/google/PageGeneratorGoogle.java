package pages.demo.web.google;

import core.driver.DriverManager;
import core.abstractclass.AbstractWeb;

/**
 * Factory/generator for Google page objects.
 * Ensures the WebDriver is initialised before any page is used.
 */
public class PageGeneratorGoogle extends AbstractWeb {

    @Override
    public void initDriver() {
        if (DriverManager.getWebDriver() == null) {
            DriverManager.newWebDriver();
        }
    }

    public HomePage getHomePage() {
        this.initDriver();
        return new HomePage();
    }
}
