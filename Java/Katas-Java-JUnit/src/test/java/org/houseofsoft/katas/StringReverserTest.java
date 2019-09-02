package org.houseofsoft.katas;

import org.houseofsoft.katas.StringReverser;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class StringReverserTest {
    @Test
    public void reverseShouldWork() {
        assertThat(StringReverser.reverse("dk"), is("kd"));
        assertThat(StringReverser.reverse("DoJ"), is("JoD"));
    }

    @Test
    public void reverseShouldWorkOnTrivialInputs() {
        assertThat(StringReverser.reverse(null), nullValue());
        assertThat(StringReverser.reverse(""), is(""));
        assertThat(StringReverser.reverse("a"), is("a"));
    }
}
