package org.houseofsoft.katas;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SpellChecker {
    Map<String, Boolean> dict = new HashMap<>();

    public SpellChecker() {
        List<String> words;
        try {
            words = Files.readAllLines(Paths.get("bin", "words-utf8.dic"), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException("Can't load dictionary from words-utf8.dic file", e);
        }
        for (String word : words) {
            dict.put(word, Boolean.TRUE);
        }
    }

    public Boolean isAWord(String s) {
        return dict.containsKey(s);
    }
}
