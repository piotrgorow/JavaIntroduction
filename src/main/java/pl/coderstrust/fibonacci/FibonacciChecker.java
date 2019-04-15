package pl.coderstrust.fibonacci;

import java.util.HashSet;

public class FibonacciChecker {
    private HashSet hashSet = new HashSet();

    public FibonacciChecker() {
        long previousElement = 0L;
        long currentElement = 1L;
        long tmp;
        for (int i = 2; i <= 92; i++) {
            tmp = currentElement;
            currentElement += previousElement;
            previousElement = tmp;
            hashSet.add(currentElement);
        }
    }

    boolean isFibonacciNumber(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number cannot be less then zero.");
        }
        return hashSet.contains(number);
    }
}
