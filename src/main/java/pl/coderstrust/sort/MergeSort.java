package pl.coderstrust.sort;

public class MergeSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        int[] result = array.clone();
        int[] tmp = result.clone();
        topDownSplitMerge(tmp, 0, result.length, result);
        return result;
    }

    private static void topDownSplitMerge(int[] tmp, int minArrayIndex, int maxArrayIndex, int[] result) {
        if (maxArrayIndex - minArrayIndex < 2) {
            return;
        }
        int indexOfSplit = (maxArrayIndex + minArrayIndex) / 2;
        topDownSplitMerge(result, minArrayIndex, indexOfSplit, tmp);
        topDownSplitMerge(result, indexOfSplit, maxArrayIndex, tmp);
        topDownMerge(tmp, minArrayIndex, indexOfSplit, maxArrayIndex, result);
    }

    private static void topDownMerge(int[] result, int minArrayIndex, int indexOfSplit, int maxArrayIndex, int[] tmp) {
        int k = minArrayIndex, l = indexOfSplit;
        for (int i = minArrayIndex; i < maxArrayIndex; i++) {
            if (k < indexOfSplit && (l >= maxArrayIndex || result[k] <= result[l])) {
                tmp[i] = result[k++];
            } else {
                tmp[i] = result[l++];
            }
        }
    }
}
