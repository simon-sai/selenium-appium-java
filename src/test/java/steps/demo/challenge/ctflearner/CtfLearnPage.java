package steps.demo.challenge.ctflearner;

import org.openqa.selenium.By;

import pages.CommonWeb;

public abstract class CtfLearnPage extends CommonWeb {
    protected String domain = "https://ctflearn.com";

    protected String getDomain() {
        return this.domain;
    }

    protected abstract String getUri();

    protected String getUrl() {
        return this.getDomain() + this.getUri();
    }

    protected By getAnchorProfileLocator() {
        return this.byDynamic("a", "id", "profileDropdown");
    }

    protected By getAnchorChallengesDropdownLocator() {
        return this.byDynamic("a", "class", "nav-link d-inline dropdown-toggle");
    }

    protected By getAnchorMyChallengeLocator() {
        return this.byDynamic("a", "href", "/challenge/by/");
    }

    protected By getAnchorCreateChallengeLocator() {
        return this.byDynamic("a", "href", "/challenge/create");
    }
}
