package pl.coderstrust.sort;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] array = new int[]{28, 46, 63, 41, 13, 12, 53, 65, 60, 29, 31, 99, 64, 26, 68, 15, 18, 65, 87, 47};
        System.out.println(Arrays.toString(array));
        System.out.println(Arrays.toString(sort(array)));
    }

    public static int[] sort(int[] array) {
        int[] result = array.clone();
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length - i - 1; j++) {
                if (result[j] > result[j + 1]) {
                    swapElementsInArray(result, j, j + 1);
                }
            }
        }
        return result;
    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElementToSwap, int indexOfSecondElementToSwap) {
        int tmp = array[indexOfFirstElementToSwap];
        array[indexOfFirstElementToSwap] = array[indexOfSecondElementToSwap];
        array[indexOfSecondElementToSwap] = tmp;
    }
}
