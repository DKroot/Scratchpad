package org.houseofsoft;

import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class JavaEnv {

  public static void main(String[] args) throws Exception {
    System.out.println("## Environment ##\n");
    Map<String, String> sortedEnv = new TreeMap<>(System.getenv());
    for (Entry<String, String> entry : sortedEnv.entrySet()) {
      System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
    }

    System.out.println("\n## Java system properties ##\n");
    Map<Object, Object> sortedProperties = new TreeMap<>(System.getProperties());
    for (Entry<Object, Object> entry : sortedProperties.entrySet()) {
      System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
    }
  }
}
