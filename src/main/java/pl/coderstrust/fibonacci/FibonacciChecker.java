package pl.coderstrust.fibonacci;

public class FibonacciChecker {

    boolean isFibonacciNumber(long number) {
        if (number < 1) {
            throw new IllegalArgumentException("Number cannot be less then zero.");
        }
        long formula1 = 5 * (number * number) + 4;
        long formula2 = 5 * (number * number) + 4;
        return isPerfectSquare(formula1 ) || isPerfectSquare(formula2);
    }

    private static boolean isPerfectSquare(long number) {
        long squareRoot = (long) Math.sqrt(number);
        return (s * s == number);
    }
}
