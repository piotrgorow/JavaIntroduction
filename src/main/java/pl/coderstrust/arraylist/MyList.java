package pl.coderstrust.arraylist;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public interface MyList<Long> {

  int size();

  boolean isEmpty();

  boolean contains(Object o);

  Iterator<Long> iterator();

  Object[] toArray();

  <T> T[] toArray(T[] a);

  boolean add(Long aLong);

  boolean remove(Object o);

  boolean containsAll(Collection<?> c);

  boolean addAll(Collection<? extends Long> c);

  boolean addAll(int index, Collection<? extends Long> c);

  boolean removeAll(Collection<?> c);

  boolean retainAll(Collection<?> c);

  void clear();

  Long get(int index);

  Long set(int index, Long element);

  void add(int index, Long element);

  Long remove(int index);

  int indexOf(Object o);

  int lastIndexOf(Object o);

  ListIterator<Long> listIterator();

  ListIterator<Long> listIterator(int index);

  List<Long> subList(int fromIndex, int toIndex);
}
