package org.houseofsoft;

public class ShiftsDemo {

  public static void main(String[] args) {
    preservingAbs(-1);
    preservingAbs(1);
  }

  private static void preservingAbs(int i) {
    System.out.println(String.format("Initial value: 0x%x (%1$s)", i));
    long l = ((long) i);
    System.out.println(String.format("Converted to long: 0x%x (%1$s)", l));
    l = l >>> 1;
    System.out.println(String.format("Positive long: 0x%x (%1$s)", l));
  }

}
