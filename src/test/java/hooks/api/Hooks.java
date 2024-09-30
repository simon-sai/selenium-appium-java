package hooks.api;

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
    }

    @After
    public void after() {
        super.parentAfter();
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