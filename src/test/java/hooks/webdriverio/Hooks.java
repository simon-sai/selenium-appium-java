package hooks.webdriverio;

import core.Report;
import core.driver.DriverManager;
import hooks.AbstractHook;
import io.cucumber.java.After;

public class Hooks extends AbstractHook {

    @After
    public void after() {
        super.parentAfter();
        this.closeBrowserAndApp();
    }

    public void closeBrowserAndApp() {
        Report.println("-- Close browser and app --");
        DriverManager.quitAll();
    }
}