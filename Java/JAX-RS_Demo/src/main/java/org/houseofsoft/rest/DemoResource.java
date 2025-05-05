package org.houseofsoft.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.houseofsoft.AppServerConfiguration;
import org.houseofsoft.domain.DemoResult;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import static org.houseofsoft.rest.DemoResource.RESOURCE_PATH;

@Path(RESOURCE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Component
@RequiredArgsConstructor
@Slf4j
public class DemoResource implements InitializingBean {
  static final String RESOURCE_PATH = "/demo";

  //region Beans injected via the `RequiredArgsConstructor`
  @Nonnull
  private final AppServerConfiguration appServerConfiguration;
  //endregion

  @Override
  public void afterPropertiesSet() {
    log.info("The Demo resource will be available at http://localhost:{}{}{}{}.",
        appServerConfiguration.getServerPort(), appServerConfiguration.getContextPath(), JerseyConfig.API_ROOT,
        RESOURCE_PATH);
  }

  /**
   * Retrieves a demo record
   *
   * @param code an integer
   */
  @GET
  public DemoResult render(@QueryParam("code") @DefaultValue("35") Integer code, @Context UriInfo uriInfo,
      @Context Request request) {
    switch (code) {
      case 400:
        throw new FailedRequestException(Status.BAD_REQUEST, "This is a bad request", uriInfo, "Details of a problem");
      case 401:
        throw new FailedRequestException(Status.UNAUTHORIZED, "This is not authorized", uriInfo);
      case 403:
        throw new FailedRequestException(Status.FORBIDDEN, "This is forbidden");
      case 500:
        throw new RuntimeException("Unexpected error!");
    }
    return new DemoResult(1, "foo");
  }
}