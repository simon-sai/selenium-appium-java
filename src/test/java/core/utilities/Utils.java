package core.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

/**
 * <h1>Utilities Class</h1>
 * This class included some common functions for all of the system
 */
public class Utils {

    public static String splitCamelCase(String s) {
        return s.replaceAll(String.format("%s|%s|%s",
                "(?<=[A-Z])(?=[A-Z][a-z])",
                "(?<=[^A-Z])(?=[A-Z])",
                "(?<=[A-Za-z])(?=[^A-Za-z])"),
                " ");
    }

    public static double toDouble(String input) {
        // Remove all special character excepts: -(negative value) .(dynamic float)
        input = input.replaceAll("[^./-a-zA-Z0-9]", "");
        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Check string is null or empty.
     */
    public static boolean isNullOrEmpty(String str) {
        return (str == null || str.isEmpty());
    }

    /**
     * Copy array from another array
     *
     * @param source source
     * @param start  start index
     * @param end    end index
     * @return Return String Array
     */
    public static String[] copyArray(String[] source, int start, int end) {
        return Arrays.copyOfRange(source, start, end);
    }

    /**
     * Get random number string
     *
     * @param length Expected number string length
     * @return String
     */
    public static String getRandomNumberString(int length) {
        StringBuilder rndString = new StringBuilder();
        while (rndString.length() < length) {
            int index = (new Random()).nextInt("0123456789".length());
            rndString.append("0123456789".charAt(index));
        }
        return rndString.toString();
    }

    public static String getRandomNumberWithoutZero(int length) {
        StringBuilder rndString = new StringBuilder();
        while (rndString.length() < length) {
            int index = (new Random()).nextInt("123456789".length());
            rndString.append("123456789".charAt(index));
        }
        return rndString.toString();
    }

    /**
     * Get random character
     *
     * @param length Expected string length
     * @return String
     */
    public static String getRandomString(int length) {
        StringBuilder rndString = new StringBuilder();
        while (rndString.length() < length) {
            int index = (new Random()).nextInt("ABCDEFGHIJKLMNOPQRSTUVWXYZ".length());
            rndString.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ".charAt(index));
        }
        return rndString.toString();
    }

    /**
     * Get current date (dd/MM/yyyy) string
     *
     * @return String
     */
    public static String getCurrentDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now());
    }

    /**
     * Get date before (dd/MM/yyyy) string
     *
     * @param days Days before
     * @return String
     */
    public static String getDateBefore(int days) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now().minusDays(days));
    }

    /**
     * Get date after (dd/MM/yyyy) string
     *
     * @param days Days after
     * @return String
     */
    public static String getDateAfter(int days) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtf.format(LocalDateTime.now().plusDays(days));
    }

    /**
     * Get current time (HH:mm) string
     *
     * @return String
     */
    public static String getCurrentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return dtf.format(LocalDateTime.now());
    }
}
