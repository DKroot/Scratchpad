package org.houseofsoft.jsonpathdemo;

import com.jayway.jsonpath.JsonPath;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JsonPathTests {

  private final static String BICYCLE = "{ \"bicycle\": { \"color\": \"red\", \"price\": 19.95 } }";

  private final static String ARRAY = "[ "
      + "{ \"color\": \"red\", \"price\": 19.95 },"
      + "{ \"color\": \"blue\", \"price\": 29.95 }"
      + " ]";

  @Test
  public void definitePathShouldReturnAMap() {
    Map<String, Object> bicycle = JsonPath.read(BICYCLE, "$.bicycle");
    Assertions.assertNotNull(bicycle);
    Assertions.assertEquals("red", bicycle.get("color"));
    Assertions.assertEquals(19.95, bicycle.get("price"));
  }

  @Test
  public void indefinitePathShouldReturnAList() {
    List<Map<String, Object>> bicycles = JsonPath.read(ARRAY, "$");
    Assertions.assertNotNull(bicycles);
    Assertions.assertEquals(2, bicycles.size());
  }

  @Test
  public void predicatePathShouldReturnAList() {
    List<Map<String, Object>> bicycles = JsonPath.read(ARRAY, "$[?( @.color == 'red' )]");
    Assertions.assertNotNull(bicycles);
    Assertions.assertEquals(1, bicycles.size());
  }
}
