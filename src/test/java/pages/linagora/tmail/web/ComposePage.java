package pages.linagora.tmail.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import core.Report;

public class ComposePage extends HomePage {
    private final By sendButton = this.byDynamic("flt-semantics", "aria-label", "Send");
    private final By receviersInput = this.byDynamic("flt-semantics", "id", "flt-semantic-node-601");

    public WebElement getSendButton() {
        return this.findElementToClick(this.sendButton);
    }

    public WebElement getReceiversInput() {
        WebElement element = this.findElement(this.receviersInput);
        Report.println(element.getAttribute("innterHTML"));
        return element.findElements(By.xpath("//input")).get(0);
    }
}
