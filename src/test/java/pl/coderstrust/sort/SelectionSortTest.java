package pl.coderstrust.sort;

class SelectionSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new SelectionSort();
    }
}
