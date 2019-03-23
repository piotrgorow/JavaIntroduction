package pl.coderstrust.christmas;

import java.util.ArrayList;
import java.util.List;

public class ChristmasTree {

    public static void main(String[] args) {
        getChristmasTree(10).forEach(System.out::println);
    }

    public static List<String> getChristmasTree(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be lower than zero.");
        }
        StringBuilder line = new StringBuilder();
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size - i; j++) {
                line.append(" ");
            }
            for (int j = 1; j <= (i * 2) - 1; j++) {
                line.append("*");
            }
            result.add(line.toString());
            line.delete(0, line.length());
        }
        result.add(getChristmasTreeTrunk(size).toString());
        return result;
    }

    private static StringBuilder getChristmasTreeTrunk(int heightOfTree) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < heightOfTree - 1; i++) {
            result.append(" ");
        }
        if (heightOfTree < 4) {
            result.append(" *");
        } else {
            result.append("***");
        }
        return result;
    }
}
