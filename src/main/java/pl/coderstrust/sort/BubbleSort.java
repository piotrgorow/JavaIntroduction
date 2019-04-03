package pl.coderstrust.sort;

public class BubbleSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty.");
        }
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
