package org.houseofsoft;

import java.net.URI;
import java.net.URISyntaxException;

public class UriDemo {

  public static void main(String[] args) throws URISyntaxException {
    String fileName = "Map%20of%20All%20projects%20-%20Arthur%20P.%20Arnold.pdf";

    URI uri = new URI(fileName);
    System.out.println(String.format("Decoded URI: '%s'", uri.getPath()));

    uri = new URI(null, null, fileName, null);
    System.out.println(String.format("Not decoded URI *WTF?!?*: '%s'", uri.getPath()));

    String fileName2 = "Map of All projects.pdf";
    URI uri2 = new URI(null, null, fileName2, null);
    System.out.println(String.format("Encoded URI: '%s'", uri2.toASCIIString()));
  }
}
