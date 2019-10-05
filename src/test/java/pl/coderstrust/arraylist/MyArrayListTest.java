package pl.coderstrust.arraylist;

import java.util.List;

public class MyArrayListTest extends MyArrayListTestBase {

  @Override
  List getList() {
    return new MyArrayList();
  }
}
