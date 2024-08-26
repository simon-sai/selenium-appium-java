/**
 * @author Duc Simon
 */
package core.utilities;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import core.Status;
import core.driver.DriverManager;
import io.cucumber.java.Scenario;

public class ExtReport {
	public static ExtentTest extentTest;
	public static ExtentReports extentReport = new ExtentReports();
	public static String reportPath = "target/extent-report/report.html";

	public static void init() {
		ExtentSparkReporter spark = new ExtentSparkReporter(ExtReport.reportPath);
		ExtReport.init(spark);
	}

	public static void init(ExtentSparkReporter spark) {
		ExtReport.println("== ExtReport.init ======");
		ExtReport.println("== Path: " + spark.getFile());
		ExtReport.extentReport.attachReporter(spark);
	}

	protected static void println(String log) {
		System.out.println(log);
	}

	public static ExtentTest createTest(Method method) {
		Test test = method.getAnnotation(Test.class);

		String testName = test.testName();
		if (testName.isEmpty())
			testName = method.getName();

		String description = test.description();
		String[] groups = test.groups();

		String[] newGroups = Arrays.copyOf(groups, groups.length + 1);
		newGroups[groups.length] = "POM";

		return ExtReport.createTest(testName, description, newGroups, null, null);
	}

	public static ExtentTest createTest(String name, String desc, String[] groups, String author, String device) {
		name = Utils.splitCamelCase(name);
		ExtReport.extentTest = ExtReport.extentReport.createTest(name, desc);
		ExtReport.extentTest.assignCategory(groups);
		if (author != null)
			ExtReport.extentTest.assignAuthor(author);
		if (device != null)
			ExtReport.extentTest.assignDevice(device);
		return ExtReport.extentTest;
	}

	public static ExtentTest createTest(Scenario scenario) {

		String testName = scenario.getName();

		String description = "";

		Collection<String> groupsString = scenario.getSourceTagNames();
		String[] groups = groupsString.toArray(new String[0]);

		String[] newGroups = Arrays.copyOf(groups, groups.length + 1);
		newGroups[groups.length] = "Cucumber";

		return ExtReport.createTest(testName, description, newGroups, null, null);
	}

	public static void log(String log) {
		ExtReport.log(Status.INFO, log);
	}

	public static void log(Status status, String log) {
		switch (status) {
			case PASS:
				log = String.format("<span class='font-weight-bold' style='color:#9ccc65'>%s</span>", log);
				break;
			case FAIL:
				log = String.format("<span class='text-danger font-weight-bold'>%s</span>", log);
				break;
			case WARNING:
				log = String.format("<span class='text-warning font-weight-bold'>%s</span>", log);
				break;
			default:
				break;
		}

		if (ExtReport.extentTest == null) {
			// ExtReport.println("ExtLog: " + log);
		} else {
			// ExtReport.println("ExtLog: " + log);
			ExtReport.extentTest.log(getExtStatus(status), log);
		}
	}

	public static void screenshot() {
		ExtReport.screenshot(Status.INFO);
	}

	public static void screenshot(Status status) {
		WebDriver driver = DriverManager.getDriver();
		if (driver == null) {
			return;
		}

		if (extentTest == null) {
			return;
		}

		TakesScreenshot ts = (TakesScreenshot) driver;
		String source = "data:image/png;base64," + ts.getScreenshotAs(OutputType.BASE64);
		String html = "";
		html += "<a href='" + source + "' data-featherlight='image'>";
		html += "<img style='width: 70%' src='" + source + "'/>";
		html += "</a>";
		extentTest.log(getExtStatus(status), html);
	}

	public static com.aventstack.extentreports.Status getExtStatus(Status status) {
		switch (status) {
			case PASS:
				return com.aventstack.extentreports.Status.PASS;
			case FAIL:
				return com.aventstack.extentreports.Status.FAIL;
			case WARNING:
				return com.aventstack.extentreports.Status.WARNING;
			case INFO:
			default:
				return com.aventstack.extentreports.Status.INFO;
		}
	}
}
