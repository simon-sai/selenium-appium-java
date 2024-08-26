package runners;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import core.Report;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public abstract class AbstractRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @Override
    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        Report.println("\n============================================");
        Report.println("==== Set Up Class: " + this.getClass().getName());
        super.setUpClass(context);
    }

    @Override
    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        super.tearDownClass();
        Report.println("==== Tear Down Class: " + this.getClass().getName());
        Report.println("============================================");
    }
}
