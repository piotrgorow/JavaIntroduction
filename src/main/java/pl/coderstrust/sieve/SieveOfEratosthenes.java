package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static final int MARKER = -1;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SieveOfEratosthenes.sieve(100)));
    }

    public static int[] sieve(int maximumNumber) {
        int[] array = createArrayOfNumbers(0, maximumNumber, 1);
        return filterPrimes(array);
    }

    private static int[] createArrayOfNumbers(int begin, int end, int step) {
        int size = ((end - begin) / step) + 1;
        if (size < 2) {
            return new int[]{};
        }
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        for (int i = 0; i < result.length; i++) {
            if (result[i] < 2) {
                result[i] = MARKER;
                continue;
            }
            markMultiplies(result, i);
        }
        return result;
    }

    private static void markMultiplies(int[] array, int number) {
        if (array[number] == MARKER) {
            return;
        }
        for (int i = 2 * number; i < array.length; i += number) {
            array[i] = MARKER;
        }
    }

    private static int[] filterPrimes(int[] numbers) {
        int i = numberOfPrimes(numbers);
        int[] result = new int[i];
        i = 0;
        for (int j : numbers) {
            if (j != MARKER) {
                result[i] = j;
                i++;
            }
        }
        return result;
    }

    private static int numberOfPrimes(int[] numbers) {
        int i = 0;
        for (int j : numbers) {
            if (j != MARKER) {
                i++;
            }
        }
        return i;
    }
}
