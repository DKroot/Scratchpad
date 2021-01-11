package gov.nih.cit.itasng;

import com.google.common.base.Throwables;
import java.util.Optional;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import lombok.Data;

@Data // = @ToString @EqualsAndHashCode @Getter-s @Setter-s (non-final) @RequiredArgsConstructor
// Designed similar to an internal Jersey error JSON response
public class ErrorDetails {

  @Nullable private String rootCause;

  public ErrorDetails(@Nonnull Throwable error) {
    Throwable rootCauseError = Optional.ofNullable(Throwables.getRootCause(error)).orElse(error);
    this.rootCause = Throwables.getStackTraceAsString(rootCauseError);
  }
}
