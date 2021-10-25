package org.houseofsoft.rest;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * <p>
 * Converts all generic exceptions to a 500 with a JSON body.
 * </p>
 *
 * <p>
 * A mapper class must be created per each exception superclass needing a different response type.
 * </p>
 */
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

  @Override
  public Response toResponse(Throwable e) {
    return Response.status(Status.INTERNAL_SERVER_ERROR) //
        .type(MediaType.APPLICATION_JSON) //
        .entity(new FailedRequestResponseWithDetails(e.getMessage(), null, e)) //
        .build();
  }
}
