package core.utilities;

import core.PropertiesReader;

public class Config {

    public static String getEnvString(String keyName) {
        return PropertiesReader.getInstance().getEnvValue(keyName);
    }

    public static int getEnvInt(String keyName) {
        String value = PropertiesReader.getInstance().getEnvValue(keyName);
        return Integer.parseInt(value);
    }

    public static String getUserEmail(String userIndex) {
        return getEnvString("TMAIL_USERNAME_" + userIndex);
    }

    public static String getUserPassword(String userIndex) {
        return getEnvString("TMAIL_PASSWORD_" + userIndex);
    }
}