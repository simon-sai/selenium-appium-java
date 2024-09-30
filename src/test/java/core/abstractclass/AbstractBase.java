package core.abstractclass;

import core.Report;
import core.Status;
import core.verify.EqualAssert;

public abstract class AbstractBase {
    protected EqualAssert equalAssert;

    public AbstractBase() {
        this.equalAssert = new EqualAssert();
    }

    public static void sleep(int miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            Report.println(e.getMessage());
        }
    }

    public EqualAssert EqualAssert() {
        return this.equalAssert;
    }

    public void sleepInSecond(int seconds) {
        sleep(seconds * 1000);
    }

    public void report(String log) {
        Report.log(log);
    }

    public void reportPass(String log) {
        Report.log(log, Status.PASS);
    }

    public void println(String log) {
        System.out.println(log);
    }
}