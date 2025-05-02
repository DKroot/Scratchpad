package org.houseofsoft.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.houseofsoft.domain.DemoResult;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
@Component
@RequiredArgsConstructor
@Slf4j
public class DemoResource {

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