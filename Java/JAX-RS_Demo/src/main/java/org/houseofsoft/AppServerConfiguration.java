package org.houseofsoft;

import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

@Configuration
@Data
@Slf4j
public class AppServerConfiguration {

  public static final String HTTPS_URI_SCHEME = "https";

  private static final String AJP_DEFAULT_SCHEME = HTTPS_URI_SCHEME;
  private static final int MAX_AJP_PACKET_SIZE = 58368;

  //region Beans injected via the `RequiredArgsConstructor`
  /**
   * Application host name (works inside Docker containers too: returns the actual Linux host running the container).
   * "N/A" if the local host could not be resolved into an address.
   */
  @Getter(lazy = true)
  private final String appServerHost = lookupHost();

  @Value("${server.servlet.context-path}")
  private String contextPath;

  @Value("${server.port}")
  private Integer serverPort;
  //endregion

  @Value("${spring.jersey.application-path}")
  private String apiRoot;

  @Bean
  public WebServerFactoryCustomizer<TomcatServletWebServerFactory> servletContainer() {
    log.debug("Starting an app server at http://localhost:{}{}", serverPort, contextPath);
    return server -> {
     /* if (server != null) {
        var ajpProperties = startupProperties.getAjp();
        if (ajpProperties.getPort() != null) {
          server.addAdditionalTomcatConnectors(createAjpConnector(ajpProperties));
        }
      }
     */
    };
  }

  // consistent with the Spring `Starting ... on {host}` message: see `StartupInfoLogger.appendOn()`
  private String lookupHost() {
    InetAddress appHostIp = null;
    try {
      appHostIp = InetAddress.getLocalHost();
    } catch (UnknownHostException e) {
      // intentionally ignoring: default to N/A
    }
    // `.getCanonicalHostName()` is nice, but it might fail where `.getHostName()` works
    return appHostIp != null ? appHostIp.getHostName() : "N/A";
  }
}
