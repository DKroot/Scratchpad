package org.houseofsoft.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * A word chain is where you provide a start word and an end word. You need to work out how to get to the end word by
 * changing only one letter through each step. On each step it should be a word from an English dictionary. So let's say
 * we have cat and dog: the chain would be cat,cot,cog,dog.
 * 
 * Words must be of the same length and can be assumed to consist only of lower-case English alphabet: 'a'..'z'
 */
public class WordChain {
    List<String> chain = new ArrayList<>();

    public WordChain(String from, String to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Nulls are not allowed");
        }
        if (from.length() != to.length()) {
            throw new IllegalArgumentException("Words must be of equal length");
        }
        chain.add(from);
        String current = from;
        if (current.equals(to)) {
            chain.add(current);
            return;
        }
        do {
            current = nextWord(current);
            if (current != null) {
                chain.add(current);
            } else {
                chain.remove(chain.size() - 1); // TBD stack could be better here
                if (chain.size() == 0) {
                    throw new RuntimeException("No solution could be found");
                }
                current = getLast();
            }
        } while (!current.equals(to));
    }

    // Use wheels of letters to come up with the next word
    private String nextWord(String current) {
        /*
        for (int i = 1; i <= from.length(); i++)
        for (char c = '')
        */

        return null;
    }

    public String getFirst() {
        return chain.get(0);
    }

    public String getLast() {
        return chain.get(chain.size() - 1);
    }
}
