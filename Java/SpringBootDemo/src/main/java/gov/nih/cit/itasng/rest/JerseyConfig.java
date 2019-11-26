package gov.nih.cit.itasng.rest;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/api")
class JerseyConfig extends ResourceConfig {

  public JerseyConfig() {
    registerClasses(//
        //region JAX-RS or Jersey providers
//        BrowserCacheFilterFeature.class,
        //endregion

        //region Exception mappers
        JsonParseExceptionMapper.class, JsonMappingExceptionMapper.class
        //endregion
    );
  }
}
