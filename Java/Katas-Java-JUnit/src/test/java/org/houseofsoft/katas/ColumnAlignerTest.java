package org.houseofsoft.katas;

import org.houseofsoft.katas.ColumnAligner;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class ColumnAlignerTest {
    private static ColumnAligner ca1, ca2, ca3, ca4;

    @BeforeClass
    public static void setup() {
        ca1 = new ColumnAligner("a$bcde$\naaaa$bc");
        ca2 = new ColumnAligner("a$\naaaa$bc");
        ca3 = new ColumnAligner("one liner$here");
        ca4 = new ColumnAligner("");
    }

    @Test
    public void columnAlignerShouldLeftAlignColumns() {
        assertThat(ca1.alignLeft(), is("|a   |bcde|\n|aaaa|bc  |\n"));
        assertThat(ca2.alignLeft(), is("|a   |\n|aaaa|bc|\n"));
    }

    @Test
    public void columnAlignerShouldRightAlignColumns() {
        assertThat(ca1.alignRight(), is("|   a|bcde|\n|aaaa|  bc|\n"));
        assertThat(ca2.alignRight(), is("|   a|\n|aaaa|bc|\n"));
    }

    @Test
    public void columnAlignerShouldCenterAlignColumns() {
        assertThat(ca1.alignCenter(), is("| a  |bcde|\n|aaaa| bc |\n"));
        assertThat(ca2.alignCenter(), is("| a  |\n|aaaa|bc|\n"));
    }

    @Test
    public void columnAlignerShouldWorkOnOneLine() {
        assertThat(ca3.alignLeft(), is("|one liner|here|\n"));
    }

    @Test
    public void columnAlignerShouldWorkOnEmptyString() {
        assertThat(ca4.alignLeft(), is("||\n"));
    }
}
