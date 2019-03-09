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
        boolean isChange;
        do {
            isChange = false;
            for (int i = 0; i < result.length - 1; i++) {
                if (result[i] > result[i + 1]) {
                    isChange = true;
                    int tmp = result[i];
                    result[i] = result[i + 1];
                    result[i + 1] = tmp;
                }
            }
        } while (isChange);
        return result;
    }
}
