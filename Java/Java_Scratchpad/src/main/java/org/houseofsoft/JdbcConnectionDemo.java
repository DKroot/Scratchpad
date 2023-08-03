package org.houseofsoft;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class JdbcConnectionDemo {

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    var driverClassName = System.getenv("SPRING_DATASOURCE_DRIVER_CLASS_NAME");
    Objects.requireNonNull(driverClassName, "SPRING_DATASOURCE_DRIVER_CLASS_NAME is not defined");
    Class.forName(driverClassName);

    var url = System.getenv("SPRING_DATASOURCE_URL");
    Objects.requireNonNull(url, "SPRING_DATASOURCE_URL is not defined");

    var username = System.getenv("SPRING_DATASOURCE_USERNAME");
    Objects.requireNonNull(username, "SPRING_DATASOURCE_USERNAME is not defined");

    var password = System.getenv("SPRING_DATASOURCE_PASSWORD");
    Objects.requireNonNull(password, "SPRING_DATASOURCE_PASSWORD is not defined");

    try (var conn = DriverManager.getConnection(url, username, password)) {
      System.out.printf("Connected to %s OK%n", conn.getCatalog());
    }
    System.out.println("Disconnected");
  }
}
