package pl.coderstrust.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class MyArrayList<Long> implements List<Long> {

  private final static int INITIAL_ARRAY_SIZE = 10;
  private Object[] mainTable = new Object[INITIAL_ARRAY_SIZE];

  private int size = 0;

  @Override
  public int size() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public boolean contains(Object o) {
    for (int i = 0; i < size; i++) {
      if (mainTable[i].equals(o)) {
        return true;
      }
    }
    return false;
  }

  @Override
  public Iterator<Long> iterator() {
    return new Itr();
  }

  private class Itr implements Iterator {

    int cursor;
    int lastRet = -1;

    Itr() {
    }

    @Override
    public boolean hasNext() {
      return cursor != size;
    }

    @Override
    public Object next() {
      int i = cursor;
      if (i >= size) {
        throw new NoSuchElementException();
      }
      Object[] elementData = mainTable;
      if (i >= elementData.length) {
        throw new ConcurrentModificationException();
      }
      cursor = i + 1;
      return elementData[lastRet = i];
    }
  }

  @Override
  public Object[] toArray() {
    return Arrays.copyOf(mainTable, size);
  }

  @Override
  public <T> T[] toArray(T[] a) {
    if (a.length < size) {
      return (T[]) Arrays.copyOf(mainTable, size, a.getClass());
    }
    System.arraycopy(mainTable, 0, a, 0, size);
    if (a.length > size) {
      a[size] = null;
    }
    return a;
  }

  @Override
  public boolean add(Long aLong) {
    if (size == mainTable.length) {
      increaseArraySize();
    }
    mainTable[size++] = aLong;
    return true;
  }

  private void increaseArraySize() {
    mainTable = Arrays.copyOf(mainTable, mainTable.length + INITIAL_ARRAY_SIZE);
  }

  @Override
  public boolean remove(Object o) {
    for (int i = 0; i < size; i++) {
      if (mainTable[i].equals(o)) {
        for (int j = i; j < size; j++) {
          mainTable[j] = mainTable[j + 1];
        }
        mainTable[size] = null;
        size--;
        decreaseArraySize();
        return true;
      }
    }
    return false;
  }

  private void decreaseArraySize() {
    if ((size < mainTable.length / 4) && (mainTable.length > INITIAL_ARRAY_SIZE)) {
      mainTable = Arrays.copyOf(mainTable, ((size / INITIAL_ARRAY_SIZE) + 1) * INITIAL_ARRAY_SIZE);
    }
  }

  @Override
  public boolean containsAll(Collection<?> c) {
    boolean result;
    Object[] col = c.toArray();
    for (int i = 0; i < c.size(); i++) {
      result = false;
      for (int j = 0; j < size; j++) {
        if (mainTable[j].equals(col[i])) {
          result = true;
          break;
        }
      }
      if (!result) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean addAll(Collection<? extends Long> c) {
    Object[] obj = c.toArray();
    boolean result = true;
    for (int i = 0; i < obj.length; i++) {
      if (!add((Long) obj[i])) {
        result = false;
      }
    }
    return result;
  }

  @Override
  public boolean addAll(int index, Collection<? extends Long> c) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    Object[] obj = c.toArray();
    int listSize = size;
    for (int i = 0; i < obj.length; i++) {
      add(index++, (Long) obj[i]);
    }
    return size != listSize;
  }

  @Override
  public boolean removeAll(Collection<?> c) {
    Object[] obj = c.toArray();
    boolean result = false;
    for (int i = 0; i < obj.length; i++) {
      if (remove(obj[i])) {
        result = true;
      }
    }
    return result;
  }

  @Override
  public boolean retainAll(Collection<?> c) {
    Object[] obj = c.toArray();
    int listSize = size;
    boolean removeElement;
    int i = 0;
    while (i < size) {
      removeElement = true;
      for (int j = 0; j < obj.length; j++) {
        if (mainTable[i].equals(obj[j])) {
          removeElement = false;
        }
      }
      if (removeElement) {
        remove(mainTable[i]);
        i = 0;
      } else {
        i++;
      }
    }
    return size != listSize;
  }

  @Override
  public void clear() {
    mainTable = new Object[INITIAL_ARRAY_SIZE];
    size = 0;
  }

  @Override
  public Long get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    return (Long) mainTable[index];
  }

  @Override
  public Long set(int index, Long element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Object oldValue = mainTable[index];
    mainTable[index] = element;
    return (Long) oldValue;
  }

  @Override
  public void add(int index, Long element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    if (size == mainTable.length) {
      increaseArraySize();
    }
    size++;
    for (int i = size - 1; i > index; i--) {
      mainTable[i] = mainTable[i - 1];
    }
    mainTable[index] = element;
  }

  @Override
  public Long remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Object oldValue = mainTable[index];
    for (int i = index; i < size - 1; i++) {
      mainTable[i] = mainTable[i + 1];
    }
    mainTable[size - 1] = null;
    size--;
    decreaseArraySize();
    return (Long) oldValue;
  }

  @Override
  public int indexOf(Object o) {
    for (int i = 0; i < size; i++) {
      if (mainTable[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  @Override
  public int lastIndexOf(Object o) {
    for (int i = size - 1; i >= 0; i--) {
      if (mainTable[i].equals(o)) {
        return i;
      }
    }
    return -1;
  }

  //TODO ListIterator ???
  @Override
  public ListIterator<Long> listIterator() {
    if (true) {
      throw new UnsupportedOperationException();
    }
    return null;
  }

  //TODO listIterator ???
  @Override
  public ListIterator<Long> listIterator(int index) {
    if (true) {
      throw new UnsupportedOperationException();
    }
    return null;
  }

  @Override
  public List<Long> subList(int fromIndex, int toIndex) {
    if (fromIndex < 0) {
      throw new IndexOutOfBoundsException();
    }
    if (fromIndex > size) {
      throw new IllegalArgumentException();
    }
    if (toIndex < 0) {
      throw new IllegalArgumentException();
    }
    if (toIndex > size) {
      throw new IndexOutOfBoundsException();
    }
    List<Long> resultList = new ArrayList<>();
    for (int i = fromIndex; i < toIndex; i++) {
      resultList.add((Long) mainTable[i]);
    }
    return resultList;
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(mainTable, size));
  }
}
