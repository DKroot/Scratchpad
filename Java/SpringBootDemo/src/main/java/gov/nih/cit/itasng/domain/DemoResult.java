package gov.nih.cit.itasng.domain;

import java.io.Serializable;
import java.util.Date;
//import javax.persistence.Entity;
//import javax.persistence.Id;
import javax.annotation.Nonnull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.Type;

//@Entity
@Data // = @ToString @EqualsAndHashCode @Getter-s @Setter-s (non-final) @RequiredArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
//public class DemoResult implements Serializable {
public class DemoResult implements Serializable {

//  @Id private Integer dbInt;
  @Nonnull private Integer dbInt;

  @Nonnull private String dbString;

  private Boolean booleanDbBit;

  private Boolean booleanDbInt;

//  @Type(type = "org.hibernate.type.YesNoType")
  // TrueFalseType could be used to map 'T'/'F'
//  private Boolean booleanDbChar;

//  private Boolean booleanDbVarchar;

  private Date dbDateTime;

  public String getFoo () {
    throw new RuntimeException("error");
//    return "foo";
  }
}
