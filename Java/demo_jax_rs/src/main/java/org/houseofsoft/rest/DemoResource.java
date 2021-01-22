package org.houseofsoft.rest;

import io.swagger.annotations.Api;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.GET;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.houseofsoft.domain.DemoResult;
import org.springframework.stereotype.Component;

@Path("demo")
@Produces(MediaType.APPLICATION_JSON)
@Component
@RequiredArgsConstructor
@Slf4j
@Api
public class DemoResource {

  /**
   * Retrieves a demo record
   *
   * @param code an integer
   */
  @GET
  //  @ApiOperation(value = "Sample description", response = DemoResult.class)
  /*@ApiResponses(value = {@ApiResponse(code = 200, message = "Sample description"),
      @ApiResponse(code = 404, message = "Resource not found")})*/
  public DemoResult render(
      @QueryParam("code") @DefaultValue("35") Integer code, @Context UriInfo uriInfo,
      @Context Request request) {
    switch (code) {
      case 400:
        throw new FailedRequestException(Status.BAD_REQUEST, "This is a bad request", uriInfo,
            "Details of a problem");
      case 401:
        throw new FailedRequestException(Status.UNAUTHORIZED, "This is not authorized", uriInfo);
      case 403:
        throw new ForbiddenException("This is forbidden");
      case 500:
        throw new RuntimeException("Unexpected error!");
    }
    return new DemoResult(1, "foo");
  }
}