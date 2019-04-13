package pl.coderstrust.ipadress;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IpAddressValidator {
    private static Pattern pattern = Pattern.compile("(([0-9]|[0-1]?[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[0-1]?[0-9][0-9]|2[0-4][0-9]|25[0-5])");

    public static boolean isIpAddress(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Parameter input cannot be null.");
        }
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
