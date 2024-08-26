/**
 * @author Duc Simon
 *
 */
package core.verify;

import core.Report;
import core.Status;

public abstract class AbstractAssert {
	public void VerifyPass(String text) {
		String message = "Verify pass: " + text;
		Report.log(message, Status.PASS);
		Report.screenshot(Status.PASS);
	}

	public void VerifyFail(String text) {
		String errorMessage = "Verify fail: " + text;
		Report.log(errorMessage, Status.FAIL);
		Report.screenshot(Status.FAIL);
		org.testng.Assert.fail(errorMessage);
	}
}
