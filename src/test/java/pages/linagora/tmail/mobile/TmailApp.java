package pages.linagora.tmail.mobile;

import core.abstractclass.AbstractAndroidApp;

public class TmailApp extends AbstractAndroidApp {

    @Override
    protected String appPackage() {
        return "com.linagora.android.teammail";
    }

    @Override
    protected String mainActivity() {
        return "com.linagora.android.tmail.MainActivity";
    }
}
