package gov.nih.cit.itasng.rest;

import gov.nih.cit.itasng.domain.DemoResult;
import io.swagger.annotations.Api;
import javax.ws.rs.BadRequestException;
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
import javax.ws.rs.core.UriInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
   * @param i an integer
   */
  @GET
  //  @ApiOperation(value = "Sample description", response = DemoResult.class)
  /*@ApiResponses(value = {@ApiResponse(code = 200, message = "Sample description"),
      @ApiResponse(code = 404, message = "Resource not found")})*/ public DemoResult render(
      @QueryParam("i") @DefaultValue("35") Integer i, @Context UriInfo uriInfo,
      @Context Request request) {
    switch (i) {
      case 400:
        throw new BadRequestException("This is a bad request");
      case 401:
        throw new NotAuthorizedException("This is not authorized");
      case 403:
        throw new ForbiddenException("This is forbidden");
    }
    return new DemoResult(1, "foo");
  }
}