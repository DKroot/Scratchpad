package org.houseofsoft.rest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.houseofsoft.AppServerConfiguration;
import org.houseofsoft.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "demo-app")
@Data
@Slf4j
public class StartupProperties {
  // Beans can't be injected here via the `@RequiredArgsConstructor` with Spring Boot 3.0+
  @Autowired
  private AppServerConfiguration appServerConfiguration;
  //endregion

  private final FooProperties foo = new FooProperties();

  @Data
  public static class FooProperties {

    private String message;
  }

  /**
   * Get the bean instance from non-Bean contexts
   *
   * @return initialized bean
   */
  public static StartupProperties get() {
    return ApplicationContextProvider.getBean(StartupProperties.class);
  }
}
