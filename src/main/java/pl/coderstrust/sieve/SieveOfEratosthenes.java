package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static int MARKER = -1;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SieveOfEratosthenes.sieve(100)));
    }

    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 2) {
            return new int[]{};
        }
        int[] array = createArrayOfNumbers(maximumNumber + 1);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 2) {
                array[i] = MARKER;
                continue;
            }
            markMultiplies(array, i);
        }
        return filterPrimes(array);
    }

    private static int[] createArrayOfNumbers(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i;
        }
        return result;
    }

    private static void markMultiplies(int[] array, int number) {
        for (int i = 2 * number; i < array.length; i++) {
            if (array[i] % number == 0) {
                array[i] = MARKER;
            }
        }
    }

    private static int[] filterPrimes(int[] numbers) {
        int i = 0;
        for (int x : numbers) {
            if (x != MARKER) {
                i++;
            }
        }
        int[] result = new int[i];
        i = 0;
        for (int x : numbers) {
            if (x != MARKER) {
                result[i] = x;
                i++;
            }
        }
        return result;
    }
}
