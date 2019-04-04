package pl.coderstrust.sort;

public class QuickSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();
        return sort(result, 0, array.length - 1);
    }

    private static int[] sort(int[] result, int minArrayIndex, int maxArrayIndex) {
        if (minArrayIndex < maxArrayIndex) {
            int currentPosition = divideTable(result, minArrayIndex, maxArrayIndex);
            sort(result, minArrayIndex, currentPosition);
            sort(result, currentPosition + 1, maxArrayIndex);
        }
        return result;
    }

    private static int divideTable(int[] result, int minArrayIndex, int maxArrayIndex) {
        int valueOfSplit = result[minArrayIndex];
        int i = minArrayIndex - 1;
        int j = maxArrayIndex + 1;
        while (true) {
            do {
                j--;
            }
            while (result[j] > valueOfSplit);
            do {
                i++;
            }
            while (result[i] < valueOfSplit);
            if (i < j) {
                swapElementsInArray(result, i, j);
            } else {
                return j;
            }
        }
    }

    private static void swapElementsInArray(int[] result, int indexOfFirstElementToSwap, int indexOfSecondElementToSwap) {
        int tmp = result[indexOfFirstElementToSwap];
        result[indexOfFirstElementToSwap] = result[indexOfSecondElementToSwap];
        result[indexOfSecondElementToSwap] = tmp;
    }
}
