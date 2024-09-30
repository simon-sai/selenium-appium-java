package core;

import org.openqa.selenium.Keys;

public class KeySend {
    public static Keys fromString(String keyString) {
        switch (keyString.toLowerCase()) {
            case "tab":
                return Keys.TAB;
            case "up":
            case "arrowup":
                return Keys.UP;
            default:
                throw new IllegalArgumentException(String.format("Key %s not defined yet.", keyString));
        }
    }
}
