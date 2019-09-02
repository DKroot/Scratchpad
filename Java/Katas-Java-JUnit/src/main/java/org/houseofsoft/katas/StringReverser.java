package org.houseofsoft.katas;

public class StringReverser {
    public static String reverse(String s) {
        if (s == null) {
            return null;
        }
        String result = "";
        for (int i = s.length(); i > 0; i--) {
            result += s.charAt(i - 1);
        }
        return result;
    }
}
