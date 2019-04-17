package pl.coderstrust.fibonacci;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FibonacciCheckerTest {
    private FibonacciChecker fibonacciChecker = new FibonacciChecker();

    @ParameterizedTest
    @ValueSource(longs = {1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946,
            17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269})
    void shouldTestValidFibonacciNumbers(long number) {
        assertTrue(fibonacciChecker.isFibonacciNumber(number));
    }

    @ParameterizedTest
    @ValueSource(longs = {4, 6, 10, 15, 25, 35, 50, 80, 145, 232, 378, 611, 988, 1598, 2585, 4182, 6760, 10945,
            17712, 28658, 46360, 75020, 121390, 196419, 317812, 514220, 832041, 1346260})
    void shouldReturnFalseForNonFibonacciNumber(long number) {
        assertFalse(fibonacciChecker.isFibonacciNumber(number));
    }

    @ParameterizedTest
    @ValueSource(longs = {0, -1, -2, -10, -50, -100, -1000})
    void shouldThrowExceptionForInvalidNumbers(long number) {
        assertThrows(IllegalArgumentException.class, () -> fibonacciChecker.isFibonacciNumber(number));
    }
}
