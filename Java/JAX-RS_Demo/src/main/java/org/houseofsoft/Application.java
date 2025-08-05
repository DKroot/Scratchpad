package org.houseofsoft;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.houseofsoft.rest.AppOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.annotation.Nonnull;
import jakarta.annotation.PostConstruct;

@SpringBootApplication // = @Configuration @EnableAutoConfiguration @ComponentScan
@EnableConfigurationProperties(AppOptions.class)
@Data
@EqualsAndHashCode(callSuper = true)
@Slf4j
public class Application extends SpringBootServletInitializer {

  //region Beans injected via the `RequiredArgsConstructor`
  @Nonnull
  private final AppServerConfiguration appServerConfiguration;
  //endregion

  public static void main(String[] args) {
    var app = new SpringApplication(Application.class);

    // ApplicationContextProvider is not initialized yet.

    // Start the web server.
    app.run(args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  @PostConstruct
  public void onStartup() {
    // ApplicationContextProvider is not initialized yet.

    log.info("The application will be available at http://localhost:{}{}.", appServerConfiguration.getServerPort(),
        appServerConfiguration.getContextPath());
  }
}
