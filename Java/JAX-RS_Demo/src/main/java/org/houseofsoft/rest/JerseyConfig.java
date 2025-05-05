package org.houseofsoft.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

import static org.glassfish.jersey.server.ServerProperties.WADL_FEATURE_DISABLE;
import static org.houseofsoft.rest.JerseyConfig.API_ROOT;

@Component
@ApplicationPath(API_ROOT)
public class JerseyConfig extends ResourceConfig implements InitializingBean {

  public static final String API_ROOT = "/api";

  @Override
  public void afterPropertiesSet() {
    registerClasses(//
        //region JAX-RS filter providers
        //BrowserCacheFilterFeature.class,
        //LoggingFilter.class,
        //endregion

        //region Exception mappers
        GenericExceptionMapper.class,
        FailedRequestExceptionMapper.class
        //endregion
    );

    packages(JerseyConfig.class.getPackage().getName());
    property(WADL_FEATURE_DISABLE, true);
  }
}
