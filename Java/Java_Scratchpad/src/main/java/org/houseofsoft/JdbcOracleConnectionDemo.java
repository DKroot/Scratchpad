package org.houseofsoft;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class JdbcOracleConnectionDemo {

  private static final String DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";

  /*
  Current session banner and connection encryption status.
  If native Oracle Net Services encryption and integrity are in use, the banner entries would include entries indicating
  the specific algorithms in use for the connection. The following output shows an example:
  ```
  AES256 Encryption service adapter for Linux: Version 12.1.0.2.0 - Production
  SHA1 Crypto-checksumming service adapter for Linux: Version 12.1.0.2.0 - Production
  ```
  See https://docs.oracle.com/en/cloud/paas/database-dbaas-cloud/csdbi/use-network-encryption-and-integrity.html.
  */
  private static final String SESSION_QUERY = """
      SELECT sys_context('USERENV', 'SID') AS sid, sci.serial#, sys_context('USERENV', 'DB_NAME') AS db,
        sys_context('USERENV', 'OS_USER') AS os_user,
        sci.client_driver || CASE
                               WHEN instr(sci.client_driver, sci.client_version) = 0 --
                                 THEN ' : ' || sci.client_version
                               ELSE '' END AS client,
        CASE WHEN count(1) > 3 THEN 'Encrypted connection' ELSE 'Unencrypted connection' END encryption,
        listagg(sci.network_service_banner, chr(10)) AS aggregated_network_service_banner
      FROM v$session_connect_info sci
      WHERE sci.sid = sys_context('USERENV', 'SID')
        AND sci.serial# = to_number(substr(dbms_session.unique_session_id, 5, 4), 'XXXX')
      GROUP BY sci.sid, sci.serial#, sci.osuser, sci.client_driver, sci.client_version
      """;

  @SuppressWarnings("DuplicatedCode")
  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    System.out.println("## System Properties ##");
    var properties = System.getProperties();
    var propertyNames = new ArrayList<>(properties.stringPropertyNames());
    Collections.sort(propertyNames);
    propertyNames.forEach(p -> System.out.println(p + "=" + properties.getProperty(p)));

    System.out.printf("%n## Using %s JDBC driver ##%n", DRIVER_CLASS_NAME);
    Class.forName(DRIVER_CLASS_NAME);

    //    var oracleSsl = System.getProperty("oracle.net.ssl_version");
    //    System.out.printf("oracle.net.ssl_version=%s%n", oracleSsl);

    var url = System.getenv("SPRING_DATASOURCE_URL");
    Objects.requireNonNull(url, "SPRING_DATASOURCE_URL is not defined");

    var username = System.getenv("SPRING_DATASOURCE_USERNAME");
    Objects.requireNonNull(username, "SPRING_DATASOURCE_USERNAME is not defined");

    var password = System.getenv("SPRING_DATASOURCE_PASSWORD");
    Objects.requireNonNull(password, "SPRING_DATASOURCE_PASSWORD is not defined");

    System.out.printf("Connecting as %s to %s%n", username, url);

    /*
    //region Using OracleDataSource
    var connProps = new Properties();

    //connProps.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_LEVEL, "REQUIRED");
    //connProps.setProperty(OracleConnection.CONNECTION_PROPERTY_THIN_NET_ENCRYPTION_TYPES, "(AES128,AES192,AES256)");

    var ods = new oracle.jdbc.pool.OracleDataSource();
    ods.setUser(username);
    //ods.setConnectionProperties(connProps);
    ods.setPassword(password);
    ods.setURL(url);
    //endregion

    try (var conn = ods.getConnection()) {
    */

    try (var conn = DriverManager.getConnection(url, username, password)) {
      var metaData = conn.getMetaData();
      System.out.printf("Connected to %s%n", metaData.getDatabaseProductVersion());

      System.out.println("\n## Session Info ##");
      try (var stmt = conn.createStatement(); var rs = stmt.executeQuery(SESSION_QUERY)) {
        while (rs.next()) {
          System.out.printf("sid=`%d`,serial#=`%s`,db=`%s`,os_user=`%s`,client=`%s`,%s%n", rs.getInt("sid"),
              rs.getString("serial#"), rs.getString("db"), rs.getString("os_user"), rs.getString("client"),
              rs.getString("encryption"));
          System.out.println(rs.getString("aggregated_network_service_banner"));
        }
      }

      System.out.println("\nDisconnected");
    }
  }
}
