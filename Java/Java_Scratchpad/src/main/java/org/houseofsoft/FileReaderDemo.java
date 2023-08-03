package org.houseofsoft;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {

  public static final String THIS_FILE_PATH = "src/main/java/org/houseofsoft/FileReaderDemo.java";

  public static void method1() throws IOException {
    File file = new File(THIS_FILE_PATH);
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line = reader.readLine();
      while (line != null) {
        System.out.println(line.toUpperCase());
        line = reader.readLine();
      }
    }
  }

  public static void method2() throws IOException {
    File file = new File(THIS_FILE_PATH);

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line.toUpperCase());
      }
    }
  }

  public static void method3() throws IOException {
    File file = new File(THIS_FILE_PATH);
    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      String line;
      do {
        line = reader.readLine();
        if (line == null) {
          break;
        }
        System.out.println(line.toUpperCase());
      } while (true);
    }
  }

  public static void main(String args[]) throws IOException {
    method2();
  }
}
