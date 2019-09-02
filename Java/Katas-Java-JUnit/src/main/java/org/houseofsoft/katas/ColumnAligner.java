package org.houseofsoft.katas;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/*
 * Given a text file of many lines, where fields within a line are delineated by a single '$' character, write a program
 * that aligns data into a table of columns separated by '|' character on both sides.<br/>
 * <br/>
 * Output to the console.<br/>
 * Input lines can have variable number of columns from zero (blank lines) to any number.<br/>
 * Further, allow users to select left justification, right justification or centering for the entire output
 * as an option.
 * 
 * Solved in: 1h:35m+
 */

/**
 * Aligns fields into columns, separated by "|"<br>
 * Requires Java 7+<br>
 * Uses third-party Apache Commons Lang 3 library for string padding functions
 */
public class ColumnAligner {
    private List<String[]> linesWithFields = new ArrayList<>();
    private int numberOfColumns = 0;
    private List<Integer> columnWidths = new ArrayList<>();

    /**
     * Initialize columns aligner from lines in a single string
     * 
     * @param s
     *            lines in a single string. Empty string does form a column.
     */
    public ColumnAligner(String s) {
        String[] lines = s.split("\\n");
        for (String line : lines) {
            processInputLine(line);
        }
    }

    /**
     * Initialize columns aligner from lines in a list of strings
     * 
     * @param lines
     *            lines in a single string. Empty string does form a column.
     */
    public ColumnAligner(List<String> lines) {
        for (String line : lines) {
            processInputLine(line);
        }
    }

    private void processInputLine(String line) {
        String[] lineFields = line.split("\\$");
        linesWithFields.add(lineFields);
        numberOfColumns = Math.max(numberOfColumns, lineFields.length);
        for (int i = 0; i < lineFields.length; i++) {
            String word = lineFields[i];
            if (i >= columnWidths.size()) {
                columnWidths.add(word.length());
            } else {
                columnWidths.set(i, Math.max(columnWidths.get(i), word.length()));
            }
        }
    }

    interface AlignFunction {
        String align(String s, int length);
    }

    /**
     * Left-align all columns
     * 
     * @return Lines, terminated by "\n" of columns, separated by "|"
     */
    public String alignLeft() {
        return align(new AlignFunction() {
            @Override
            public String align(String s, int length) {
                return StringUtils.rightPad(s, length);
            }
        });
    }

    /**
     * Right-align all columns
     * 
     * @return Lines, terminated by "\n" of columns, separated by "|"
     */
    public String alignRight() {
        return align(new AlignFunction() {
            @Override
            public String align(String s, int length) {
                return StringUtils.leftPad(s, length);
            }
        });
    }

    /**
     * Center-align all columns
     * 
     * @return Lines, terminated by "\n" of columns, separated by "|"
     */
    public String alignCenter() {
        return align(new AlignFunction() {
            @Override
            public String align(String s, int length) {
                return StringUtils.center(s, length);
            }
        });
    }

    private String align(AlignFunction a) {
        StringBuilder result = new StringBuilder();
        for (String[] lineFields : linesWithFields) {
            for (int i = 0; i < numberOfColumns; i++) {
                String field = (i < lineFields.length) ? lineFields[i] : "";
                if (i == 0) {
                    result.append("|");
                }
                result.append(a.align(field, columnWidths.get(i)) + "|");
            }
            result.append("\n");
        }
        return result.toString();
    }

    public static void main(String args[]) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: ColumnAligner file [left|right|center]");
            return;
        }
        String filePath = args[0];
        String alignment = "left";
        if (args.length >= 2) {
            alignment = args[1];
        }
        ColumnAligner ca = new ColumnAligner(Files.readAllLines(Paths.get(filePath), StandardCharsets.UTF_8));
        switch (alignment) {
        case "left":
            System.out.print(ca.alignLeft());
            break;
        case "right":
            System.out.print(ca.alignRight());
            break;
        case "center":
            System.out.print(ca.alignCenter());
            break;
        default:
            System.err.println(String.format("Error! Unknown alignment: '%s'", alignment));
            break;
        }
    }
}
