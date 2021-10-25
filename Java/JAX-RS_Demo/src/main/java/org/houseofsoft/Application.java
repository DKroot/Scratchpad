package org.houseofsoft;

import java.util.ArrayList;
import org.houseofsoft.rest.JerseyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.StringVendorExtension;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication // = @Configuration @EnableAutoConfiguration @ComponentScan
@EnableSwagger2
public class Application extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(Application.class);
  }

  @SuppressWarnings("unused") // Called internally by SpringFox when the app is loaded
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2) //
        .select() //
        .apis(RequestHandlerSelectors.basePackage(JerseyConfig.class.getPackageName())) //
        .paths(PathSelectors.any()) //
        .build() //
        .enable(true) //
        .apiInfo(apiInfo());
  }

  public ApiInfo apiInfo() {
    @SuppressWarnings("rawtypes") // required in order to pass it to `new ApiInfo()`
    var vendorExtensions = new ArrayList<VendorExtension>();
    vendorExtensions.add(new StringVendorExtension("", ""));

    return new ApiInfo( //
        "SpringBoot-Swagger2-JaxRS", //
        "Example project", //
        "1.0", //
        "N/A", //
        null, //
        "Apache 2.0", //
        "www.apache.org", //
        vendorExtensions);
  }
}
