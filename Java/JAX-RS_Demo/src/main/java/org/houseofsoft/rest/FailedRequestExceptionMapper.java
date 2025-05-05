package org.houseofsoft.rest;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

/**
 * <p>
 * Converts `FailedRequestException` to a corresponding response.
 * </p>
 *
 * <p>
 * A mapper class must be created per each exception superclass needing a different response type.
 * </p>
 */
@Provider
public class FailedRequestExceptionMapper implements ExceptionMapper<FailedRequestException> {

  @Override
  public Response toResponse(FailedRequestException e) {
    return e.getResponse();
  }
}
