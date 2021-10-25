package org.houseofsoft.rest;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Nullable;
import javax.ws.rs.core.UriInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Custom body for failed request responses.
 *
 * Returned data is mostly compatible with {@link gov.nih.cit.itasng.ErrorAttributes} to simplify
 * reporting on both 400s and 500s by the client side.
 */
@Data
@NoArgsConstructor
// Designed similar to an internal Jersey error JSON response
public class FailedRequestResponse implements Serializable {

  private Date timestamp = new Date();

  @Nullable
  private String message;

  @Nullable
  private String path;

  public FailedRequestResponse(@Nullable String message, @Nullable UriInfo uriInfo) {
    this.message = message;
    this.path = uriInfo == null ? null : uriInfo.getAbsolutePath().toString();
  }
}
