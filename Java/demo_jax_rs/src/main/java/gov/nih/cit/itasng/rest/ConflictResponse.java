package gov.nih.cit.itasng.rest;

import gov.nih.cit.itasng.ErrorDetails;
import java.util.Date;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.ws.rs.core.UriInfo;
import lombok.Data;

/**
 * Custom body for bad request (400) responses.
 *
 * Returned data is mostly compatible with {@link gov.nih.cit.itasng.ErrorAttributes} to simplify
 * reporting on both 400s and 500s by the client side.
 */
@Data // = @ToString @EqualsAndHashCode @Getter-s @Setter-s (non-final) @RequiredArgsConstructor
// Designed similar to an internal Jersey error JSON response
public class ConflictResponse {

  private Date timestamp = new Date();
  @Nullable private String message;
  @Nullable private String path;

  public ConflictResponse(@Nullable String message, @Nullable UriInfo uriInfo) {
    this.message = message;
    this.path = uriInfo == null ? null : uriInfo.getAbsolutePath().toString();
  }
}
