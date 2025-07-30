package org.houseofsoft.domain;

import lombok.Data;

import javax.annotation.Nonnull;
import java.util.Date;

@Data
public class DemoResult {

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
