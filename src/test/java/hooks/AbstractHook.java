package hooks;

import core.Report;
import io.cucumber.java.Scenario;

public abstract class AbstractHook {

    protected void parentBefore(Scenario scenario) {
        Report.println("==== AbstractHook Before Scenario =========");
        Report.createTest(scenario);
    }

    protected void parentAfter() {
        Report.println("==== AbstractHook After Scenario =========");
    }

    protected static void parentBeforeAll() {
        Report.println("==== AbstractHook Before All ========");
        Report.init();
    }

    protected static void parentAfterAll() {
        Report.println("==== AbstractHook After All =========");
        Report.flush();
    }
}