package gov.nih.cit.itasng.rest;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;

// @formatter:off
/**
 * Custom error report in reading JSON requests. A mapper class must be
 * created per each exception type because the more specific mapper always gets invoked.<br>
 * See <a href="https://stackoverflow.com/questions/43599955/how-to-customize-error-response-when-deserializing-failed"
 * target="_blank">How to customize error response when deserializing failed</a>.
 */
// @formatter:on
abstract class JaxRsExceptionMapper<T extends Throwable> implements ExceptionMapper<T> {

  private final static String JAX_RS_UNEXPECTED_ERROR_MSG = "Invalid request";

  @Override
  public Response toResponse(T cause) {
    return Response.status(Status.BAD_REQUEST) //
        .entity(new BadRequestResponse(JAX_RS_UNEXPECTED_ERROR_MSG, null, cause)) //
        .build();
  }
}
