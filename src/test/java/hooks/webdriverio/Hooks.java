package hooks.webdriverio;

import core.Report;
import core.driver.DriverManager;
import hooks.AbstractHook;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends AbstractHook {

    @BeforeAll
    public static void beforeAll() {
        AbstractHook.parentBeforeAll();
    }

    @AfterAll
    public static void afterAll() {
        AbstractHook.parentAfterAll();
    }

    @Before
    public void before(Scenario scenario) {
        super.parentBefore(scenario);
    }

    @After
    public void after() {
        super.parentAfter();
        this.closeBrowserAndApp();
    }

    public void closeBrowserAndApp() {
        Report.println("-- Close browser and app");
        DriverManager.quitAll();
    }
}