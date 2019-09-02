package org.houseofsoft.katas;

import org.houseofsoft.katas.AckermannFunc;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Note:<br>
 * Enabling DEBUG logging will significantly degrade performance and cause timeouts in some tests<br>
 * Tests with the Shallow Stack Implementation for 3x21 and larger require >1GB of max heap:<br>
 * 2GB is sufficient for 3x21<br>
 * 4GB is sufficient for 3x22
 */
public class AckermannFuncTest {
    private static final int ONE_TEST_TIMEOUT = 5 * 60 * 1000; // milliseconds

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void shouldWorkForSmallNumbersOnBoundaries() {
        assertThat(AckermannFunc.a(0, 0), is(1));
        assertThat(AckermannFunc.a(0, 4), is(5));
        assertThat(AckermannFunc.a(0, 10), is(11));

        assertThat(AckermannFunc.a(1, 0), is(2));
        assertThat(AckermannFunc.a(4, 0), is(13));
    }

    /*
        // Analytic (on BigIntegers): Times out after 5 minutes
        @Test(timeout = ONE_TEST_TIMEOUT)
        public void shouldWorkWithBigIntegers() {
            assertThat(AckermannFunc.aBig(4, 0), is(BigInteger.valueOf(13)));
        }
    */
    @Test(timeout = ONE_TEST_TIMEOUT)
    public void shouldWorkFor3x04() {
        assertThat(AckermannFunc.a(3, 4), is(125));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void shouldWorkFor4x01() {
        assertThat(AckermannFunc.a(4, 1), is(65_533));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    // Shallow Stack Implementation: about 0.1 s on a MacBook Pro 2010
    // Recursive Implementation: about 4:00 m:s
    public void shouldWorkFor3x15() {
        assertThat(AckermannFunc.a(3, 15), is(262_141));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    // Shallow Stack Implementation: about 0.2 s on a MacBook Pro 2010
    // Recursive Implementation: Times out after 5 minutes
    public void shouldWorkFor3x17() {
        assertThat(AckermannFunc.a(3, 17), is(1_048_573));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    // Shallow Stack Implementation: about 1.7 s on a MacBook Pro 2010
    // Recursive Implementation: Times out after 5 minutes
    public void shouldWorkFor3x18() {
        assertThat(AckermannFunc.a(3, 18), is(2_097_149));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    // Shallow Stack Implementation: about 10-13 s on a MacBook Pro 2010
    // Recursive Implementation: Times out after 5 minutes
    public void shouldWorkFor3x20() {
        assertThat(AckermannFunc.a(3, 20), is(8_388_605));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    // Shallow Stack Implementation: about 20-27 s on a MacBook Pro 2010
    // Recursive Implementation: Times out after 5 minutes
    public void shouldWorkFor3x21() {
        assertThat(AckermannFunc.a(3, 21), is(16_777_213));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    // Analytic (on ints) Implementation: <1 ms
    // Shallow Stack Implementation: about 37-39 s on a MacBook Pro 2010
    // Recursive Implementation: Times out after 5 minutes
    public void shouldWorkFor3x22() {
        assertThat(AckermannFunc.a(3, 22), is(33_554_429));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionOnNegativeNumbers() {
        AckermannFunc.a(-1, 0);
    }
}
