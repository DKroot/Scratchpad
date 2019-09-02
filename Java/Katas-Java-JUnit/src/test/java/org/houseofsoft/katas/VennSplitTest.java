package org.houseofsoft.katas;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.houseofsoft.katas.VennSplit;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class VennSplitTest {
    private static final Set<Integer> E = Collections.emptySet();

    @SafeVarargs
    private final <T> Set<T> setOf(T... values) {
        return new HashSet<T>(Arrays.asList(values));
    }

    @Test
    public void threeSetsWith1IntersectionShouldBeSplitTo4VennSets() {
        assertThat(VennSplit.of(setOf(setOf(1, 2, 3), setOf(1, 2, 4), setOf(1, 2, 5))),
                is(setOf(setOf(1, 2), setOf(3), setOf(4), setOf(5))));
    }

    @Test
    public void emptySetsShouldBeSkipped() {
        assertThat(VennSplit.of(setOf(E, setOf(1, 2, 4), setOf(1, 2, 5), E)),
                is(setOf(setOf(1, 2), setOf(4), setOf(5))));
        assertThat(VennSplit.of(setOf(E)).isEmpty(), is(true));
    }

    @Test
    public void identicalSetsShouldNotBeDuplicated() {
        assertThat(VennSplit.of(setOf(setOf(1, 2, 4), setOf(1, 2, 4), setOf(1, 2, 5))),
                is(setOf(setOf(1, 2), setOf(4), setOf(5))));
    }

    @Test
    public void nonIntersectingSetsShouldBeIdenticalToVennSets() {
        assertThat(VennSplit.of(setOf(setOf(1, 2), setOf(3, 4), setOf(5))),
                is(setOf(setOf(1, 2), setOf(3, 4), setOf(5))));
    }

    @Test
    public void threeMatryoshkaSetsShouldBeSplitTo3VennSets() {
        assertThat(VennSplit.of(setOf(setOf(1), setOf(1, 2), setOf(1, 2, 3))),
                is(setOf(setOf(1), setOf(2), setOf(3))));
    }
}
