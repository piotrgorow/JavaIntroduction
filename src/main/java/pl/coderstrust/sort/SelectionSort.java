package pl.coderstrust.sort;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] array = new int[]{28, 46, 63, 41, 13, 12, 53, 65, 60, 29, 31, 99, 64, 26, 68, 15, 18, 65, 87, 47};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        int[] result = array.clone();
        for (int i = 0; i < result.length - 1; i++) {
            int minimalElementIndex = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[minimalElementIndex]) {
                    minimalElementIndex = j;
                }
            }
            swapElementsInArray(result, i, minimalElementIndex);
        }
        return result;
    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElementToSwap, int indexOfSecondElementToSwap) {
        int tmp = array[indexOfFirstElementToSwap];
        array[indexOfFirstElementToSwap] = array[indexOfSecondElementToSwap];
        array[indexOfSecondElementToSwap] = tmp;
    }
}
