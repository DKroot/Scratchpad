package org.houseofsoft.katas;

import org.houseofsoft.katas.CoinChange;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CoinChangeTest {
    private static final int ONE_TEST_TIMEOUT = 10 * 60 * 1000; // milliseconds

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void change4To1x2ShouldWork() {
        assertThat(new CoinChange(1, 2).waysToChange(4), is(3L));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void change4To1x2x3ShouldWork() {
        assertThat(new CoinChange(3, 2, 1).waysToChange(4), is(4L));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void change15ShouldWork() {
        assertThat(new CoinChange(25, 10, 5, 1).waysToChange(15), is(6L));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void change100ShouldWork() {
        assertThat(new CoinChange(25, 10, 5, 1).waysToChange(100), is(242L));
    }

    /* Simple recursive implementation times out
        @Test(timeout = ONE_TEST_TIMEOUT)
        public void change1000DollarsShouldWork() {
            assertThat(new CoinChange(1, 5, 10, 25, 50, 100).waysToChange(1000_00), is(13_398_445_413_854_501L));
        }
    */

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void change300Sorted() {
        assertThat(new CoinChange(5, 10, 20, 50, 100, 200, 500).waysToChange(300), is(1022L));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void change300Unsorted() {
        assertThat(new CoinChange(500, 5, 50, 100, 20, 200, 10).waysToChange(300), is(1022L));
    }

    @Test(timeout = ONE_TEST_TIMEOUT)
    public void changeWithoutPennies() {
        assertThat(new CoinChange(5, 10, 20, 50, 100, 200, 500).waysToChange(301), is(0L));
    }
}
