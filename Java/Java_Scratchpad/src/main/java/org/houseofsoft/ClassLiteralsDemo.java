package org.houseofsoft;

public class ClassLiteralsDemo {
  public static void main(String[] args) {
    printClass(String.class);
    // Possible in Groovy, not Java
//    printClass(String);

    Integer i = 5;
    printClass(i.getClass());
  }

  @SuppressWarnings("rawtypes")
  static void printClass(Class c) {
    System.out.println(c);
  }
}
