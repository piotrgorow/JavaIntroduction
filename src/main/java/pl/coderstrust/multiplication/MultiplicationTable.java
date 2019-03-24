package pl.coderstrust.multiplication;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationTable {

    public static void main(String[] args) {
        getMultiplicationTable(12).forEach(System.out::println);
    }

    public static List<String> getMultiplicationTable(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size cannot be lower than zero.");
        }
        StringBuilder line = new StringBuilder();
        List<String> result = new ArrayList<>();
        line.append("     ");
        for (int i = 1; i <= size; i++) {
            line.append(getNumberInField(i, 5));
        }
        result.add(line.toString());
        line.delete(0, line.length());
        for (int i = 1; i <= size; i++) {
            line.append(getNumberInField(i, 5));
            for (int j = 1; j <= size; j++) {
                line.append(getNumberInField(i * j, 5));
            }
            result.add(line.toString());
            line.delete(0, line.length());
        }
        return result;
    }

    private static StringBuilder getNumberInField(int number, int width) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < width - String.valueOf(number).length(); i++) {
            result.append(" ");
        }
        result.append(number);
        return result;
    }
}
