package core;

import org.openqa.selenium.Keys;

public class KeySend {
    public static Keys fromString(String keyString) {
        switch (keyString.toLowerCase()) {
            case "tab":
                return Keys.TAB;
            case "enter":
            case "return":
                return Keys.RETURN;
            case "escape":
            case "esc":
                return Keys.ESCAPE;
            case "up":
            case "arrowup":
                return Keys.UP;
            case "down":
            case "arrowdown":
                return Keys.DOWN;
            case "left":
            case "arrowleft":
                return Keys.LEFT;
            case "right":
            case "arrowright":
                return Keys.RIGHT;
            case "backspace":
                return Keys.BACK_SPACE;
            case "delete":
                return Keys.DELETE;
            default:
                throw new IllegalArgumentException(String.format("Key %s not defined yet.", keyString));
        }
    }
}
