package org.houseofsoft.rest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

  public static final String API_ROOT = "/api";

  public JerseyConfig() {
    registerClasses(GenericExceptionMapper.class, FailedRequestExceptionMapper.class);
  }
}
