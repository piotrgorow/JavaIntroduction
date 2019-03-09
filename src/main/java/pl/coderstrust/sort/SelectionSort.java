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
            int min = i;
            for (int j = i + 1; j < result.length; j++) {
                if (result[j] < result[min]) {
                    min = j;
                }
            }
            if (result[i] > result[min]) {
                int tmp = result[i];
                result[i] = result[min];
                result[min] = tmp;
            }
        }
        return result;
    }
}
