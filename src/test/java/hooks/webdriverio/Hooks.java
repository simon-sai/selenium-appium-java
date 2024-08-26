package hooks.webdriverio;

import java.util.Collection;

import core.Report;
import core.TagEnum;
import core.driver.DriverManager;
import core.utilities.Config;
import hooks.AbstractHook;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks extends AbstractHook {

    @Before
    public void before(Scenario scenario) {
        super.parentBefore(scenario);
        this.openBrowser(scenario);
    }

    public void openBrowser(Scenario scenario) {
        Collection<String> collection = scenario.getSourceTagNames();
        for (String item : collection) {
            if (item.equals(TagEnum.WEB.getValue())) {
                String browser = Config.getEnvString("TEST_BROWSER");
                Report.println("---- openBrowser: " + browser);
                DriverManager.getDriver(browser);
            }

            if (item.equals(TagEnum.ANDROID.getValue())) {
                Report.println("---- getAndroidDriver");
                DriverManager.getAndroidDriver();
            }
        }
    }

    @After
    public void after() {
        super.parentAfter();
        this.closeBrowser();
    }

    public void closeBrowser() {
        Report.println("-- Close browser --");
        DriverManager.quitAll();
    }

    @BeforeAll
    public static void beforeAll() {
        AbstractHook.parentBeforeAll();
    }

    @AfterAll
    public static void afterAll() {
        AbstractHook.parentAfterAll();
    }
}