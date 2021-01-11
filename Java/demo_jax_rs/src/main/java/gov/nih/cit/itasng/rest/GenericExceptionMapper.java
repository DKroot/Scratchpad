package gov.nih.cit.itasng.rest;

import javax.inject.Singleton;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

// @formatter:off
/**
 * Custom error report. A mapper class must becreated per each exception type because the more
 * specific mapper always gets invoked.
 */
// @formatter:on
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

  @Override
  public Response toResponse(Exception ex) {
    return Response.status(Status.INTERNAL_SERVER_ERROR).
        entity(ex.getMessage()).
        type(MediaType.TEXT_PLAIN).
        build();
  }
}