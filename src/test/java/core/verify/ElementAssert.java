/**
 * @author Duc Simon
 *
 */
package core.verify;

import org.openqa.selenium.WebElement;

public class ElementAssert extends AbstractAssert {
	public void HasText(WebElement element, String textExpected) {
		String elementText = element.getText().toLowerCase();
		boolean status = elementText.equals(textExpected.toLowerCase());
		if (status) {
			this.VerifyPass(String.format("element has text `%s`", textExpected));
		} else {
			this.VerifyFail(
					String.format("element DOES NOT have text `%s`, only found `%s`", textExpected, elementText));
		}
	}
}
