package pl.coderstrust.fibonacci;

import java.util.HashMap;

public class FibonacciChecker {

    private static HashMap<Long, Boolean> cache = new HashMap<>();

    public static boolean isFibonacciNumber(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number cannot be less then one.");
        }
        if (hashMap.containsKey(number)) {
            return hashMap.get(number);
        }
        long formula1 = 5 * (number * number) - 4;
        long formula2 = 5 * (number * number) + 4;
        boolean result = isPerfectSquare(formula1) || isPerfectSquare(formula2);
        hashMap.put(number, result);
        return result;
    }

    private static boolean isPerfectSquare(long number) {
        long squareRoot = (long) Math.sqrt(number);
        return (squareRoot * squareRoot == number);
    }
}
