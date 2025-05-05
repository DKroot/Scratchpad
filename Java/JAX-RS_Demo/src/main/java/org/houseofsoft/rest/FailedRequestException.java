package org.houseofsoft.rest;

import javax.annotation.Nullable;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.StatusType;
import jakarta.ws.rs.core.UriInfo;

/**
 * <p>
 * Generates an error response with a JSON body.
 * </p>
 *
 * <p>
 * A mapper class must be created per each exception superclass needing a different response type.
 * </p>
 */
public class FailedRequestException extends WebApplicationException {

  /**
   * Generates an error response with a custom message and details.
   *
   * @param customMessage message to include in the report
   * @param uriInfo (optional) original request URI info
   * @see FailedRequestResponseWithDetails
   */
  public FailedRequestException(StatusType status, String customMessage, @Nullable UriInfo uriInfo,
      @Nullable Object details) {
    super(customMessage, Response.status(status) //
        .type(MediaType.APPLICATION_JSON) //
        .entity(new FailedRequestResponseWithDetails(customMessage, uriInfo, details)) //
        .build());
  }

  /**
   * Generates an error response with a custom message
   *
   * @param customMessage message to include in the report
   * @param uriInfo (optional) original request URI info
   * @see FailedRequestResponseWithDetails
   */
  public FailedRequestException(StatusType status, String customMessage,
      @Nullable UriInfo uriInfo) {
    this(status, customMessage, uriInfo, null);
  }

  /**
   * Generates an error response with a custom message
   *
   * @param customMessage message to include in the report
   * @param uriInfo (optional) original request URI info
   * @see FailedRequestResponseWithDetails
   */
  public FailedRequestException(StatusType status, String customMessage) {
    this(status, customMessage, null);
  }
}
