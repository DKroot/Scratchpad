package org.houseofsoft.rest;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  public static final String API_ROOT = "/api";

  public JerseyConfig() {
    registerClasses(GenericExceptionMapper.class, FailedRequestExceptionMapper.class);

    var swaggerConfig = new BeanConfig();
    swaggerConfig.setBasePath(API_ROOT);
    SwaggerConfigLocator.getInstance()
        .putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

    packages(getClass().getPackage().getName(), ApiListingResource.class.getPackage().getName());
  }
}
