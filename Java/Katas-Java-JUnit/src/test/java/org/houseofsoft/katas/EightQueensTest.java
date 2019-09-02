package org.houseofsoft.katas;

import org.houseofsoft.katas.EightQueens;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class EightQueensTest {
    @Test
    public void queenShouldCaptureOnTheSameFile() {
        assertThat(EightQueens.canCapture("a1", "a2"), is(true));
        assertThat(EightQueens.canCapture("a2", "a1"), is(true));
    }

    @Test
    public void queenShouldCaptureOnTheSameRank() {
        assertThat(EightQueens.canCapture("a1", "b1"), is(true));
        assertThat(EightQueens.canCapture("b1", "a1"), is(true));
    }

    @Test
    public void queenShouldCaptureOnTheSameDiagonal() {
        assertThat(EightQueens.canCapture("a1", "c3"), is(true));
        assertThat(EightQueens.canCapture("c3", "a1"), is(true));
        assertThat(EightQueens.canCapture("h4", "g5"), is(true));
    }

    @Test
    public void queenShouldNotCaptureOtherwise() {
        assertThat(EightQueens.canCapture("a1", "c4"), is(false));
        assertThat(EightQueens.canCapture("b4", "e5"), is(false));
    }

    @Test
    public void queensShouldBePlacedInNonCapturingPositions() {
        String[] queens = new EightQueens().getPositions();
        assertThat(queens.length, is(8));

        for (int i = 0; i <= 7; i++) {
            for (int j = i + 1; j <= 7; j++) {
                if (EightQueens.canCapture(queens[i], queens[j])) {
                    fail("These queens can capture each other: Q" + queens[i] + " and Q" + queens[j]);
                }
            }
        }
    }
}
