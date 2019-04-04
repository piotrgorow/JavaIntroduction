package pl.coderstrust.sort;

public class SelectionSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
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
