package org.houseofsoft.katas;

public class Strings {

    public static String padRight(String s, int length) {
        if (s == null || length <= s.length()) {
            return s;
        }
        return String.format("%1$-" + length + "s", s);
    }

    public static String padLeft(String s, int length) {
        if (s == null || length <= s.length()) {
            return s;
        }
        return String.format("%1$" + length + "s", s);
    }

    public static String center(String s, int length) {
        if (s == null || length <= s.length()) {
            return s;
        }
    
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < (length - s.length()) / 2; i++) {
            sb.append(" ");
        }
        sb.append(s);
        while (sb.length() < length) {
            sb.append(" ");
        }
        return sb.toString();
    }

}
