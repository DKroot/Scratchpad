package org.houseofsoft;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

public class JdbcConnectionDemo {

  @SuppressWarnings("DuplicatedCode")
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    var driverClassName = System.getenv("SPRING_DATASOURCE_DRIVER_CLASS_NAME");
    Objects.requireNonNull(driverClassName, "SPRING_DATASOURCE_DRIVER_CLASS_NAME is not defined");
    System.out.printf("Using %s JDBC driver%n", driverClassName);
    Class.forName(driverClassName);

    var url = System.getenv("SPRING_DATASOURCE_URL");
    Objects.requireNonNull(url, "SPRING_DATASOURCE_URL is not defined");

    var username = System.getenv("SPRING_DATASOURCE_USERNAME");
    Objects.requireNonNull(username, "SPRING_DATASOURCE_USERNAME is not defined");

    var password = System.getenv("SPRING_DATASOURCE_PASSWORD");
    Objects.requireNonNull(password, "SPRING_DATASOURCE_PASSWORD is not defined");

    System.out.printf("Connecting as %s@%s%n", username, url);
    try (var conn = DriverManager.getConnection(url, username, password)) {
      var metaData = conn.getMetaData();
      System.out.printf("Connected to %s%n", metaData.getDatabaseProductVersion());
    }
    System.out.println("Disconnected");
  }
}
