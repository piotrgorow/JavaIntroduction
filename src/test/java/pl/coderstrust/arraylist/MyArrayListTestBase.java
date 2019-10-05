package pl.coderstrust.arraylist;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public abstract class MyArrayListTestBase {

  private List<Long> list = getList();

  abstract List getList();

  @BeforeEach
  private void initList() {
    list.clear();
  }

  @Test
  void shouldReturnCorrectValueOfArraySize() {
    //given
    list.add(1L);
    list.add(2L);
    list.add(3L);

    //when
    int result = list.size();

    //then
    assertEquals(3, result);
  }

  @Test
  void shouldReturnTrueIfListIsEmpty() {
    //when
    boolean result = list.isEmpty();

    //then
    assertTrue(result);
  }

  @Test
  void shouldReturnFalseIfListIsNotEmpty() {
    //given
    list.add(1L);

    //when
    boolean result = list.isEmpty();

    //then
    assertFalse(result);
  }

  @Test
  void shouldReturnFalseWhenListNotContainTwo() {
    //given
    list.add(1L);
    list.add(3L);

    //when
    boolean result = list.contains(2L);

    //then
    assertFalse(result);
  }

  @Test
  void shouldReturnTrueWhenListContainTwo() {
    //given
    list.add(2L);

    //when
    boolean result = list.contains(2L);

    //then
    assertTrue(result);
  }

  @Test
  void shouldReturnCorrectValueOfIterator() {
    //given
    list.add(1L);
    list.add(3L);
    list.add(5L);
    list.add(7L);
    list.add(9L);
    Iterator<Long> iterator = list.iterator();
    List<Long> expected = Arrays.asList(1L, 3L, 5L, 7L, 9L);
    List<Long> actual = new ArrayList<>();

    //when
    while (iterator.hasNext()) {
      actual.add(iterator.next());
    }

    //then
    assertEquals(expected, actual);
  }

  @Test
  void shouldReturnCorrectValueOfToArray() {
    //given
    Long[] expected = {1L, 2L, 3L, 4L, 5L};
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    Object[] result = list.toArray();

    //then
    assertArrayEquals(expected, result);
  }

  @Test
  void shouldCorrectAddElementToList() {
    //given
    Long[] expected = new Long[]{1L, 2L, 3L, 4L, 5L};

    //when
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //then
    assertArrayEquals(expected, list.toArray());
  }

  @Test
  void shouldReturnTrueWhenElementIsAddedToList() {
    //given
    boolean result;

    //when
    result = list.add(1L);

    //then
    assertTrue(result);
  }

  @Test
  void shouldCorrectInsertElementToList() {
    //given
    Long[] expected = new Long[]{1L, 2L, 3L, 10L, 4L, 5L};
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    list.add(3, 10L);

    //then
    assertArrayEquals(expected, list.toArray());
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, -5, -1, 1, 5, 10})
  void shouldThrowExceptionWhenIndexOfAddIsIncorrect(int index) {
    assertThrows(IndexOutOfBoundsException.class, () -> list.add(index, 1L));
  }

  @Test
  void shouldCorrectRemoveElementFromList() {
    //given
    list.add(1L);
    list.add(2L);
    list.add(3L);
    Long[] expected = new Long[]{1L, 3L};

    //when
    list.remove(1);

    //then
    assertArrayEquals(expected, list.toArray());
  }

  @Test
  void shouldReturnOldValueAfterRemovedElementFromList() {
    //given
    list.add(1L);
    list.add(2L);
    list.add(3L);

    //when
    Long result = list.remove(1);

    //then
    assertEquals(2L, result);
  }

  @Test
  void shouldReturnTrueOfContainsAllOfList() {
    //given
    List<Long> given = Arrays.asList(2L, 3L, 4L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    boolean result = list.containsAll(given);

    //then
    assertTrue(result);
  }

  @Test
  void shouldReturnFalseOfContainsAllOfList() {
    //given
    List<Long> given = Arrays.asList(2L, 6L, 4L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    boolean result = list.containsAll(given);

    //then
    assertFalse(result);
  }

  @Test
  void shouldThrowExceptionWhenPassedCollectionToContainsAllIsNull() {
    assertThrows(NullPointerException.class, () -> list.containsAll(null));
  }

  @Test
  void shouldReturnCorrectGetValueFromIndex() {
    //given
    list.add(1L);
    list.add(3L);
    list.add(5L);

    //when
    long result1 = list.get(0);
    long result2 = list.get(1);
    long result3 = list.get(2);

    //then
    assertEquals(1, result1);
    assertEquals(3, result2);
    assertEquals(5, result3);
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, -5, -1, 1, 5, 10})
  void shouldThrowExceptionWhenIndexOfGetIsIncorrect(int index) {
    assertThrows(IndexOutOfBoundsException.class, () -> list.get(index));
  }

  @Test
  void shouldCorrectClearList() {
    //given
    list.add(1L);
    list.add(2L);
    list.add(3L);

    //when
    list.clear();
    int result = list.size();

    //then
    assertEquals(0, result);
  }

  @Test
  void shouldReturnCorrectIndexOfElementList() {
    //given
    list.add(2L);
    list.add(4L);
    list.add(6L);

    //when
    int result1 = list.indexOf(2L);
    int result2 = list.indexOf(4L);
    int result3 = list.indexOf(6L);

    //then
    assertEquals(0, result1);
    assertEquals(1, result2);
    assertEquals(2, result3);
  }

  @Test
  void shouldReturnNegativeWhenElementNotExistsIndexOf() {
    //given
    list.add(1L);

    //when
    int result = list.indexOf(2L);

    //then
    assertEquals(-1, result);
  }

  @Test
  void shouldReturnCorrectLastIndexOfElementList() {
    //given
    list.add(2L);
    list.add(2L);
    list.add(2L);

    //when
    int result = list.lastIndexOf(2L);

    //then
    assertEquals(2, result);
  }

  @Test
  void shouldReturnNegativeWhenElementNotExistsLastIndexOf() {
    //given
    list.add(1L);

    //when
    int result = list.lastIndexOf(2L);

    //then
    assertEquals(-1, result);
  }

  @Test
  void shouldCorrectSetElementOfList() {
    //given
    list.add(2L);

    //when
    list.set(0, 4L);

    //then
    assertEquals(4L, list.get(0));
  }

  @Test
  void shouldCorrectReturnPreviousElementOfListSet() {
    //given
    list.add(2L);

    //when
    Long result = list.set(0, 4L);

    //then
    assertEquals(2L, result);
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, -5, -1, 1, 5, 10})
  void shouldThrowExceptionWhenIndexOfSetIsIncorrect(int index) {
    assertThrows(IndexOutOfBoundsException.class, () -> list.set(index, 1L));
  }

  @Test
  void shouldCorrectRemoveElementFromIndexOfList() {
    //given
    list.add(1L);
    list.add(2L);
    list.add(3L);
    Long[] expected = new Long[]{2L, 3L};
    //List<Long> expected = Arrays.asList(2L, 3L);

    //when
    list.remove(0);

    //then
    assertArrayEquals(expected, list.toArray());
    //assertEquals(expected, list);
  }

  @Test
  void shouldReturnCorrectOldValueWhenRemovedElementFromIndexOfList() {
    //given
    list.add(2L);

    //when
    Long result = list.remove(0);

    //then
    assertEquals(2L, result);
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, -5, -1, 1, 5, 10})
  void shouldThrowExceptionWhenIndexOfRemoveIsIncorrect(int index) {
    assertThrows(IndexOutOfBoundsException.class, () -> list.remove(index));
  }

  @Test
  void shouldCorrectRemoveObjectFromList() {
    //given
    list.add(1L);
    list.add(2L);
    list.add(3L);
    Long[] expected = new Long[]{1L, 3L};
    //List<Long> expected = Arrays.asList(1L, 3L);

    //when
    list.remove(2L);

    //then
    assertArrayEquals(expected, list.toArray());
    //assertEquals(expected, list);
  }

  @Test
  void shouldReturnTrueWhenRemovedObjectFromList() {
    //given
    list.add(2L);

    //when
    boolean result = list.remove(2L);

    //then
    assertTrue(result);
  }

  @Test
  void shouldReturnFalseWhenRemovedObjectNotExists() {
    //given
    list.add(1L);

    //when
    boolean result = list.remove(2L);

    //then
    assertFalse(result);
  }

  @Test
  void shouldReturnCorrectSublistFromList() {
    //given
    List<Long> expected = Arrays.asList(3L, 4L, 5L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);
    list.add(6L);
    list.add(7L);
    list.add(8L);

    //when
    List<Long> result = list.subList(2, 5);

    //then
    assertArrayEquals(expected.toArray(), result.toArray());
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, -5, -1})
  void shouldThrowExceptionWhenParameterFromIndexOfSublistIsNegative(int fromIndex) {
    assertThrows(IndexOutOfBoundsException.class, () -> list.subList(fromIndex, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 5, 10})
  void shouldThrowExceptionWhenParameterFromIndexOfSublistIsAboveSize(int fromIndex) {
    assertThrows(IllegalArgumentException.class, () -> list.subList(fromIndex, 0));
  }

  @ParameterizedTest
  @ValueSource(ints = {-10, -5, -1})
  void shouldThrowExceptionWhenParameterToIndexOfSublistMethodIsNegative(int toIndex) {
    assertThrows(IllegalArgumentException.class, () -> list.subList(0, toIndex));
  }

  @ParameterizedTest
  @ValueSource(ints = {2, 5, 10})
  void shouldThrowExceptionWhenParameterToIndexOfSublistIsAboveSize(int toIndex) {
    assertThrows(IndexOutOfBoundsException.class, () -> list.subList(0, toIndex));
  }

  @Test
  void shouldCorrectRemoveAllElementsPassedCollectionFromList() {
    //given
    List<Long> given = Arrays.asList(3L, 4L, 5L);
    List<Long> expected = Arrays.asList(1L, 2L, 6L, 7L, 8L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);
    list.add(6L);
    list.add(7L);
    list.add(8L);

    //when
    list.removeAll(given);

    //then
    assertArrayEquals(expected.toArray(), list.toArray());
  }

  @Test
  void shouldReturnTrueWhenRemoveAllElementsPassedCollectionFromList() {
    //given
    List<Long> given = Arrays.asList(3L, 4L, 5L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);
    list.add(6L);

    //when
    boolean result = list.removeAll(given);

    //then
    assertTrue(result);
  }

  @Test
  void shouldThrowExceptionWhenParameterPassedToRemoveAllIsNull() {
    assertThrows(NullPointerException.class, () -> list.removeAll(null));
  }

  @Test
  void shouldCorrectAddAllElementsPassedCollectionToList() {
    //given
    List<Long> given = Arrays.asList(4L, 5L, 6L);
    List<Long> expected = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L);
    list.add(1L);
    list.add(2L);
    list.add(3L);

    //when
    list.addAll(given);

    //then
    assertArrayEquals(expected.toArray(), list.toArray());
  }

  @Test
  void shouldReturnTrueWhenAddAllElementsPassedCollectionToList() {
    //given
    List<Long> given = Arrays.asList(3L, 4L, 5L);
    list.add(1L);
    list.add(2L);
    list.add(3L);

    //when
    boolean result = list.addAll(given);

    //then
    assertTrue(result);
  }

  @Test
  void shouldThrowExceptionWhenParameterPassedToAddAllIsNull() {
    assertThrows(NullPointerException.class, () -> list.addAll(null));
  }

  @Test
  void shouldCorrectAddAllElementsPassedCollectionToListWithIndex() {
    //given
    List<Long> given = Arrays.asList(6L, 7L, 8L);
    List<Long> expected = Arrays.asList(1L, 2L, 6L, 7L, 8L, 3L, 4L, 5L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    list.addAll(2, given);

    //then
    assertArrayEquals(expected.toArray(), list.toArray());
  }

  @Test
  void shouldReturnTrueWhenAddAllElementsPassedCollectionToListWithIndex() {
    //given
    List<Long> given = Arrays.asList(3L, 4L, 5L);
    list.add(1L);
    list.add(2L);
    list.add(3L);

    //when
    boolean result = list.addAll(1, given);

    //then
    assertTrue(result);
  }

  @Test
  void shouldThrowExceptionWhenParameterPassedToAddAllWithIndexIsNull() {
    assertThrows(NullPointerException.class, () -> list.addAll(0, null));
  }

  @Test
  void shouldCorrectRetainAllElementsPassedCollectionToList() {
    //given
    List<Long> expected = Arrays.asList(2L, 3L, 4L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    list.retainAll(expected);

    //then
    assertArrayEquals(expected.toArray(), list.toArray());
  }

  @Test
  void shouldReturnTrueWhenRetainAllElementsPassedCollectionToList() {
    //given
    List<Long> given = Arrays.asList(2L, 3L, 4L);
    list.add(1L);
    list.add(2L);
    list.add(3L);
    list.add(4L);
    list.add(5L);

    //when
    boolean result = list.retainAll(given);

    //then
    assertTrue(result);
  }

  @Test
  void shouldReturnFalseWhenRetainAllElementsPassedCollectionToList() {
    //given
    List<Long> given = Arrays.asList(2L, 3L, 4L);
    list.add(2L);
    list.add(3L);
    list.add(4L);

    //when
    boolean result = list.retainAll(given);

    //then
    assertFalse(result);
  }

  @Test
  void shouldThrowExceptionWhenParameterPassedToRetainAllIsNull() {
    assertThrows(NullPointerException.class, () -> list.retainAll(null));
  }
}
