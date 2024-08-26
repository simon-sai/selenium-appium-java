package pages.linagora.tmail.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends WebDomain {

    private final By composeButton = this.byDynamic("flt-semantics", "aria-label", "Compose");
    private final By searchInput = this.byDynamic("input", "aria-label", "Search emails");

    @Override
    public String Uri() {
        return "/dashboard";
    }

    public WebElement getSearchInput() {
        return this.findElementToClick(this.searchInput);
    }

    public WebElement getComposeButton() {
        return this.findElementToClick(this.composeButton);
    }
}
