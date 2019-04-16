package pl.coderstrust.fibonacci;

public class FibonacciChecker {

    boolean isFibonacciNumber(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number cannot be less then zero.");
        }
        return isPerfectSquare(5 * number * number + 4) || isPerfectSquare(5 * number * number - 4);
    }

    private static boolean isPerfectSquare(long number) {
        long s = (long) Math.sqrt(number);
        return (s * s == number);
    }
}
