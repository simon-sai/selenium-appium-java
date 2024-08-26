package pages.linagora.tmail.mobile;

import core.abstractclass.AbstractAndroid;

public class TmailApp extends AbstractAndroid {

    @Override
    protected String appPackage() {
        return "com.linagora.android.teammail";
    }

    @Override
    protected String mainActivity() {
        return "com.linagora.android.tmail.MainActivity";
    }
}
