package pl.coderstrust.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest extends MyArrayListTestBase {

  @Override
  List getList() {
    return new ArrayList();
  }
}
