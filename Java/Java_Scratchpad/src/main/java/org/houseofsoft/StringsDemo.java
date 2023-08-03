package org.houseofsoft;

import com.google.common.base.Strings;
import com.google.common.primitives.Ints;
import java.util.Arrays;

public class StringsDemo {

  public static void main(String[] args) {
    String s = "a";
    s = s.replaceAll("a", "");

    System.out.println(String.format("s = \"%s\"", s));
    System.out.println(String.format("(s == \"\") = %s", s == ""));
    System.out.println(String.format("s.isEmpty() = %s", s.isEmpty()));
    System.out.println("s.split(\";\") = " + Arrays.toString(s.split(";")));

    s = "String to split";
    System.out.println("Trivial string split = " + Arrays.toString(s.split(";")));

    // System.out.println(new Integer(null)); // Error here
    System.out
        .println("Safe conversion to an integer = " + Ints.tryParse(Strings.nullToEmpty(null)));

        /*
        for (Character c : s) { // DOES NOT COMPILE

        }
        */
  }
}
