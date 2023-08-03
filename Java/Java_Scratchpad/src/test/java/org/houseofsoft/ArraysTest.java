package org.houseofsoft;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class ArraysTest {

  @Test
  public void arraysUtilityClassEqualityShouldCompareArraysContents() {
    System.out.println("ArraysTest started...");
    log.trace("Trace logging");
    log.debug("Debug logging");
    log.info("Info logging");
    log.warn("Warn logging");

    int[] A1 = {1, 2};
    int[] A2 = {3, 4};
    int[] A3 = {1, 2};

    assertFalse(A1.equals(A2));
    assertFalse(A1.equals(A3));

    assertFalse(Arrays.equals(A1, A2));
    assertTrue(Arrays.equals(A1, A3));
  }
}
