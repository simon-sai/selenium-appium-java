package hooks.api;

import hooks.AbstractHook;
import io.cucumber.java.*;

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