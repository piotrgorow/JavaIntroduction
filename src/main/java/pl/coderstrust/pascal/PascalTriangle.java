package pl.coderstrust.pascal;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        getPascalTriangle(5).forEach(System.out::println);
    }

    public static List<String> getPascalTriangle(int number) {
        if (number < 2 || number > 20) {
            throw new IllegalArgumentException("Number cannot be lower than 2 or bigger than 20.");
        }
        StringBuilder line = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                line.append(String.format("%4s", " "));
            }
            for (int j = 0; j <= i; j++) {
                long nodeValue = factorial(i) / (factorial(j) * factorial(i - j));
                line.append(String.format("%8d", nodeValue));
            }
            result.add(line.toString());
            line.setLength(0);
        }
        return result;
    }

    private static long factorial(int number) {
        long result = 1;
        for (int i = 1; i <= number; i++) {
            result *= i;
        }
        return result;
    }
}
