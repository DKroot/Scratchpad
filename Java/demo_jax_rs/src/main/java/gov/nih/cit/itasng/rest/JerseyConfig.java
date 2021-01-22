package gov.nih.cit.itasng.rest;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.config.SwaggerConfigLocator;
import io.swagger.jaxrs.config.SwaggerContextService;
import io.swagger.jaxrs.listing.ApiListingResource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.base.JsonMappingExceptionMapper;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    registerClasses(//
        //region Exception mappers
//        GenericExceptionMapper.class, JsonParseExceptionMapper.class
        //endregion
    );

    BeanConfig swaggerConfig = new BeanConfig();
    swaggerConfig.setBasePath("/api");
    SwaggerConfigLocator
        .getInstance().putConfig(SwaggerContextService.CONFIG_ID_DEFAULT, swaggerConfig);

    packages(getClass().getPackage().getName(),
        ApiListingResource.class.getPackage().getName());
  }
}
