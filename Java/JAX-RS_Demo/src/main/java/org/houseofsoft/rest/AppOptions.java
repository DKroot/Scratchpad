package org.houseofsoft.rest;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.houseofsoft.AppServerConfiguration;
import org.houseofsoft.ApplicationContextProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("demo-app")
@Data
@Slf4j
public class AppOptions {
  //region Beans can't be injected here via `@RequiredArgsConstructor` with Spring Boot 3.0+
  @Autowired
  private AppServerConfiguration appServerConfiguration;
  //endregion

  private String debug;

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
  public static AppOptions get() {
    return ApplicationContextProvider.getBean(AppOptions.class);
  }
}
