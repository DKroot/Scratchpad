package org.houseofsoft;

public class GenericsDemo {

  static class Item<T> {
    public Item(T value) {
      this.value = value;
    }

    T value;
  }

  public static void main(String[] args) {
    Item<Integer> i = new Item<>(3);
    System.out.println(i);
  }
}
