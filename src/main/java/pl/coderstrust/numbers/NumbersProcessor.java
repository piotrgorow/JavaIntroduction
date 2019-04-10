package pl.coderstrust.numbers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumbersProcessor {
    private Pattern pattern;

    public NumbersProcessor() {
        pattern = Pattern.compile("-?[0-9]+");
    }

    public String processLine(String line) {
        Matcher matcher = pattern.matcher(line);
        StringBuilder result = new StringBuilder();
        int sum = 0;
        while (matcher.find()) {
            if (result.length() > 0 && Integer.parseInt(matcher.group()) >= 0) {
                result.append('+');
            }
            result.append(Integer.parseInt(matcher.group()));
            sum += Integer.parseInt(matcher.group());
        }
        if (result.length() > 0) {
            result.append("=").append(sum);
        }
        return result.toString();
    }
}
