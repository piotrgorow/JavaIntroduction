package pl.coderstrust.sort;

class MergeSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new MergeSort();
    }
}
