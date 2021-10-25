package org.houseofsoft.rest;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.core.UriInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.houseofsoft.ErrorDetails;

/**
 * Custom body for failed request responses with detailed info.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
// Designed similar to an internal Jersey error JSON response
public class FailedRequestResponseWithDetails extends FailedRequestResponse {

  @Nullable
  private Object details; // Field name should = ErrorAttributes.DETAILS_FIELD_NAME

  public FailedRequestResponseWithDetails(@Nullable String message, @Nullable UriInfo uriInfo,
      @Nullable Object details) {
    super(message, uriInfo);
    this.details = details;
  }

  public FailedRequestResponseWithDetails(@Nullable String message, @Nullable UriInfo uriInfo,
      @Nonnull Throwable e) {
    this(message, uriInfo, new ErrorDetails(e));
  }
}
