package org.houseofsoft.domain;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Nonnull;
import lombok.Data;

@Data
public class DemoResult implements Serializable {

  @Nonnull
  private final Integer dbInt;

  @Nonnull
  private final String dbString;

  private Boolean booleanDbBit;

  private Boolean booleanDbInt;

  private Date dbDateTime;

  @SuppressWarnings("unused") // Serialized
  public String getFoo() {
    return "foo";
  }
}
