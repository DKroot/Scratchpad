package org.houseofsoft.katas;

/**
 * Counts the lines of actual code in a Java program. Whitespace and comments don't count. Assumes that code compiles.
 */
public class LOCCounter {

    public static int getLOC(String code) {
        int result = 0;
        boolean inBlockComment = false;
        for (String line : code.split("\\n")) {
            String codeLine = line.trim();
            if (inBlockComment) {
                if (codeLine.contains("*/")) {
                    inBlockComment = false;
                    codeLine = codeLine.substring(codeLine.indexOf("*/") + 2);
                } else {
                    continue;
                }
            }
            codeLine = codeLine.replaceAll("/\\*.*?\\*/", "").replaceFirst("//.*", "");
            if (codeLine.contains("/*")) {
                inBlockComment = true;
            }
            if (codeLine.length() != 0 && !codeLine.startsWith("/*")) {
                result++;
            }
        }
        return result;
    }
}
