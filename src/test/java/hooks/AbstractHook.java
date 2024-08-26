package hooks;

import core.Report;
import io.cucumber.java.Scenario;

public abstract class AbstractHook {

    protected void parentBefore(Scenario scenario) {
        Report.println("==== Before Scenario =========");
        Report.createTest(scenario);
    }

    protected void parentAfter() {
        Report.println("==== After Scenario =========");
    }

    protected static void parentBeforeAll() {
        Report.println("==== Before All ========");
        Report.init();
    }

    protected static void parentAfterAll() {
        Report.println("==== After All =========");
        Report.flush();
    }
}