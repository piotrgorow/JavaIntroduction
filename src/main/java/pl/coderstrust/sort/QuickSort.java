package pl.coderstrust.sort;

public class QuickSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();
        return sort(result, 0, array.length - 1);
    }

    public static int[] sort(int[] result, int minArrayIndex, int maxArrayIndex) {
        if (result == null || result.length == 0 || minArrayIndex < 0 || maxArrayIndex < minArrayIndex - 1) {
            throw new IllegalArgumentException("Table is empty or index out of range.");
        }
        while (minArrayIndex < maxArrayIndex) {
            int currentPosition = divideTable(result, minArrayIndex, maxArrayIndex);
            if ((currentPosition - minArrayIndex) <= (maxArrayIndex - currentPosition)) {
                sort(result, minArrayIndex, currentPosition - 1);
                minArrayIndex = currentPosition + 1;
            } else {
                sort(result, currentPosition, maxArrayIndex);
                maxArrayIndex = currentPosition - 1;
            }
        }
        return result;
    }

    private static int divideTable(int[] result, int minArrayIndex, int maxArrayIndex) {
        int indexOfSplit = minArrayIndex + ((maxArrayIndex - minArrayIndex) / 2);
        int valueOfSplit = result[indexOfSplit];
        swapElementsInArray(result, indexOfSplit, maxArrayIndex);
        int currentPosition = minArrayIndex;
        for (int i = minArrayIndex; i < maxArrayIndex; i++) {
            if (result[i] < valueOfSplit) {
                swapElementsInArray(result, i, currentPosition);
                currentPosition++;
            }
        }
        swapElementsInArray(result, currentPosition, maxArrayIndex);
        return currentPosition;
    }

    private static void swapElementsInArray(int[] array, int indexOfFirstElementToSwap, int indexOfSecondElementToSwap) {
        int tmp = array[indexOfFirstElementToSwap];
        array[indexOfFirstElementToSwap] = array[indexOfSecondElementToSwap];
        array[indexOfSecondElementToSwap] = tmp;
    }
}
