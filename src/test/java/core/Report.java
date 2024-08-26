package core;

import core.utilities.ExtReport;
import io.cucumber.java.Scenario;

public class Report {
    public static void init() {
        ExtReport.init();
    }

    public static void screenshot(Status status) {
        ExtReport.screenshot(status);
    }

    public static void createTest(Scenario scenario) {
        ExtReport.createTest(scenario);
    }

    public static void flush() {
        ExtReport.extentReport.flush();
    }

    public static void log(String log) {
        ExtReport.log(log);
    }

    public static void println(String log) {
        System.out.println(log);
    }

    public static void log(String log, Status status) {
        ExtReport.log(status, log);
    }
}
