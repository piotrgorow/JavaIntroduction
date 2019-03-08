package pl.coderstrust.sieve;

import java.util.Arrays;

public class SieveOfEratosthenes {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(SieveOfEratosthenes.sieve(12)));
    }

    public static int[] sieve(int maximumNumber) {
        if (maximumNumber < 2) {
            return new int[]{-1};
        }
        int[] arraySieve = new int[maximumNumber + 1];
        for (int i = 2; i <= maximumNumber; i++) {
            arraySieve[i] = i;
        }
        int i = 2;
        while (i <= Math.sqrt(maximumNumber)) {
            for (int j = i + i; j <= maximumNumber; j += i) {
                arraySieve[j] = 0;
            }
            while (i <= Math.sqrt(maximumNumber)) {
                i++;
                if (arraySieve[i] != 0) {
                    break;
                }
            }
        }
        i = 0;
        for (int j = 2; j < maximumNumber + 1; j++) {
            if (arraySieve[j] != 0) {
                i++;
            }
        }
        int[] result = new int[i];
        i = 0;
        for (int j = 2; j <= maximumNumber; j++) {
            if (arraySieve[j] != 0) {
                result[i] = arraySieve[j];
                i++;
            }
        }
        return result;
    }
}
