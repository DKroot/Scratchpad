package org.houseofsoft.katas;
import org.houseofsoft.katas.HundredDoorsHall;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;

public class HundredDoorsHallTest {
    private HundredDoorsHall hall;

    @Before
    public void setUp() {
        hall = new HundredDoorsHall();
        hall.pass100Times();
    }

    @Test
    public void firstDoorDoorsShouldBeOpen() {
        assertThat(hall.isDoorOpen(1), is(true));
    }

    @Test
    public void primeNumberDoorsShouldBeClosed() {
        assertThat(hall.isDoorOpen(2), is(false));
        assertThat(hall.isDoorOpen(3), is(false));
        assertThat(hall.isDoorOpen(5), is(false));
        assertThat(hall.isDoorOpen(7), is(false));
    }

    @Test
    public void factorsOfTwoShouldBeAlternativelyOpenOrClosed() {
        assertThat(hall.isDoorOpen(4), is(true));
        assertThat(hall.isDoorOpen(8), is(false));
        assertThat(hall.isDoorOpen(16), is(true));
        assertThat(hall.isDoorOpen(32), is(false));
        assertThat(hall.isDoorOpen(64), is(true));
    }

    @Test
    public void hudrendthDoorShouldBe() {
        // Passes: 1, 2, 4, 5, 10, 20, 25, 50, 100
        assertThat(hall.isDoorOpen(100), is(true));
    }
}
