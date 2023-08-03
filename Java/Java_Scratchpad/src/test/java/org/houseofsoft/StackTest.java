package org.houseofsoft;

import static org.junit.Assert.fail;

import java.util.Stack;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;

public class StackTest {

  private static final Logger log = Logger.getLogger(StackTest.class.getName());
  private Stack<Object> stack;

  @Before
  public void setUp() throws Exception {
    stack = new Stack<Object>();
  }

  @Test
  public void stackOfObjectsShouldAcceptPrimitiveInts() {
    log.fine("Starting stackOfObjectsShouldAcceptPrimitiveInts()...");
    try {
      stack.push(5);
    } catch (Exception e) {
      fail("Should be able to push integers");
    }
  }

}
