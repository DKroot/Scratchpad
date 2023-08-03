package org.houseofsoft;

import java.util.Arrays;
import java.util.List;

public class FooBarHandsOnAsList {

  public static void main(String[] args) {
    List<Integer> l = Arrays
        .asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23,
            24, 25); // ... 100
    for (Integer i : l) {
      if (i % 3 != 0 && i % 5 != 0) {
        System.out.println(i);
      } else {
        if (i % 3 == 0) {
          System.out.println("Foo");
        }
        if (i % 5 == 0) {
          System.out.println("Bar");
        }
      }
    }
  }
}
