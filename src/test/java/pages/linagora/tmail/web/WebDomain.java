package pages.linagora.tmail.web;

import core.Report;
import core.utilities.Config;
import pages.CommonWeb;

public abstract class WebDomain extends CommonWeb {

    public abstract String Uri();

    public String Domain() {
        return Config.getEnvString("TMAIL_HOST");
    }

    public String Url() {
        return this.Domain() + this.Uri();
    }

    public void GoTo() {
        String url = this.Url();
        Report.log(String.format("Web go to [%s]", url));
        this.navigateToTheUrl(url);
    }
}
