package org.houseofsoft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication // = @Configuration @EnableAutoConfiguration @ComponentScan
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    var app = new SpringApplication(Application.class);

    // Start the web server and exit.
    app.run(args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }
}
