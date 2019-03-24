package pl.coderstrust.multiplication;

import java.util.Arrays;

public class MultiplicationTable {

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(getMultiplicationTable(12)));
    }

    public static int[][] getMultiplicationTable(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("Size cannot be lower than zero.");
        }
        int[][] result = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                result[j - 1][i - 1] = i * j;
            }
        }
        return result;
    }
}
