package pl.coderstrust.foobar;

import java.util.ArrayList;
import java.util.List;

public class FooBar {

    public static void main(String[] args) {
        getFooBar(100).forEach(System.out::println);
    }

    public static List<String> getFooBar(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Number cannot be lower than zero.");
        }
        List<String> result = new ArrayList<>();
        StringBuilder line = new StringBuilder();
        for (int i = 0; i <= number; i++) {
            line.append(i + " ");
            if (i % 3 == 0) {
                line.append("Foo");
            }
            if (i % 5 == 0) {
                line.append("Bar");
            }
            result.add(line.toString());
            line.delete(0, line.length());
        }
        return result;
    }
}
