package pl.coderstrust.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionsSort implements SortingMethod {

    @Override
    public int[] sort(int[] array) {
        List<Integer> result = IntStream.of(array).boxed().collect(Collectors.toList());
        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
