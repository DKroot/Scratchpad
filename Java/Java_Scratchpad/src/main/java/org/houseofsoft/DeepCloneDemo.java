package org.houseofsoft;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.SneakyThrows;

import javax.annotation.Nonnull;
import java.util.Arrays;

public class DeepCloneDemo {
  public static void main(String[] args) {
    var g = new Person("George", new Country("India"), null, null);
    var d1 = new Person("Dima", new Country("Ukraine"), (byte) 54, new Person[]{g});
    System.out.printf("original=%s%n", d1);

    System.out.println("\nCloning via clone()");
    var d2 = d1.clone();
    compareClones(d1, d2);
  }

  @SuppressWarnings("DuplicatedCode")
  private static void compareClones(Person p1, Person p2) {
    System.out.printf("clone=%s%n", p1);
    System.out.printf("The same objects? = %s%n", p1 == p2);
    System.out.printf("Equal objects? = %s%n", p1.equals(p2));
    // Is it a shallow clone or a deep clone?
    var areObjectFieldsTheSame = p1.getBornIn() == p2.getBornIn();
    System.out.printf("Are the object fields the same? = %s%n", areObjectFieldsTheSame);
    if (!areObjectFieldsTheSame) {
      System.out.printf("Are the object fields equal? = %s%n", p1.getBornIn().equals(p2.getBornIn()));
    }
    var areArrayFieldsTheSame = p1.getFriends() == p2.getFriends();
    System.out.printf("Are the array fields the same? = %s%n", areArrayFieldsTheSame);
    if (!areArrayFieldsTheSame) {
      System.out.printf("Are the array fields equal? = %s%n", Arrays.equals(p1.getFriends(), p2.getFriends()));
    }
  }

  @Data
  public static class Country implements Cloneable {
    private @Nonnull String name;

    @Override
    @SneakyThrows(CloneNotSupportedException.class)
    public Country clone() {
      return (Country) super.clone();
    }
  }

  @Data
  @AllArgsConstructor
  public static class Person implements Cloneable {
    private @Nonnull String name;

    private Country bornIn;

    private Byte age;

    private Person[] friends;

    @Override
    @SneakyThrows(CloneNotSupportedException.class)
    public Person clone() {
      var clone = (Person) super.clone();
      clone.bornIn = bornIn.clone();
      clone.friends = friends.clone();
      return clone;
    }
  }
}
