package pl.coderstrust.sort;

class CollectionsSortTest extends SortingTestBase {

    @Override
    public SortingMethod getSortingMethod() {
        return new CollectionsSort();
    }
}
