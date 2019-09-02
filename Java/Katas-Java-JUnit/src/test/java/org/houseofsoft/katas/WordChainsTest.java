package org.houseofsoft.katas;

import org.houseofsoft.katas.SpellChecker;
import org.houseofsoft.katas.WordChain;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class WordChainsTest {
    private SpellChecker sc = new SpellChecker();

    @Test
    public void commonWordsShouldBeRecognized() {
        assertThat(sc.isAWord("cat"), is(true));
        assertThat(sc.isAWord("cog"), is(true));
        assertThat(sc.isAWord("dog"), is(true));
    }

    @Test
    public void commonUppercaseWordsShouldNotBeRecognized() {
        assertThat(sc.isAWord("CAT"), is(false));
        assertThat(sc.isAWord("COG"), is(false));
        assertThat(sc.isAWord("DOG"), is(false));
    }

    @Test
    public void gibberishShouldNotBeRecognized() {
        assertThat(sc.isAWord("FHKJFHK"), is(false));
    }

    @Test
    public void chainShouldContainCorrectFirstAndLastWords() {
        WordChain chain = new WordChain("cat", "dog");
        assertThat(chain.getFirst(), is("cat"));
        assertThat(chain.getLast(), is("dog"));
    }
}
