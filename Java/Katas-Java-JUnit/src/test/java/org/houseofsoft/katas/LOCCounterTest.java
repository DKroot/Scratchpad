package org.houseofsoft.katas;

import org.houseofsoft.katas.LOCCounter;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class LOCCounterTest {
    @Test
    public void pureCodeLinesShouldBeCounted() {
        assertThat(LOCCounter.getLOC("line1;"), is(1));
        assertThat(LOCCounter.getLOC("line1;\nline2"), is(2));
        assertThat(LOCCounter.getLOC("line1;\n"), is(1));
    }

    @Test
    public void whiteSpaceShouldBeOmitted() {
        assertThat(LOCCounter.getLOC("          \n\nline1;"), is(1));
    }

    @Test
    public void lineCommentsShouldBeOmitted() {
        assertThat(LOCCounter.getLOC("//line comment\n\nline1;"), is(1));
        assertThat(LOCCounter.getLOC("line 1; //line comment\n\nline2;"), is(2));
    }

    @Test
    public void blockCommentsShouldBeOmitted() {
        assertThat(LOCCounter.getLOC("/*block comment\ncommented out\ncommented out*/ "), is(0));
        assertThat(LOCCounter.getLOC("line 1; /*block comment\ncommented out\ncommented out*/ line 2"), is(2));
        assertThat(LOCCounter.getLOC("/*block comment*/ line 1;\nnot commented out;\nline 3"), is(3));
        assertThat(LOCCounter.getLOC("/*b1*/ line 1; /*b2*/\nnot commented out;\nline 3"), is(3));
    }

    @Test
    public void blockCommentsShouldNotCountBehindLineComments() {
        assertThat(LOCCounter.getLOC("line 1; //not really /*block comment\nline 2;\nline 3; //commented out*/ "),
                is(3));
        assertThat(LOCCounter.getLOC("line 1; /*block comment\ncommented out\ncommented out*/ line 2"), is(2));
    }

    @Test
    public void lineCommentsShouldNotCountBehindLineComments() {
        assertThat(LOCCounter.getLOC("/*block: //not really line comment*/line 1;\nline 2;\nline 3;"), is(3));
        assertThat(LOCCounter.getLOC("/*block: //not really line comment b 1;\nb 2;\n//b 3;*/line 1;"), is(1));
    }
}
