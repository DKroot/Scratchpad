package org.houseofsoft.katas;

import java.util.Arrays;

public class EightQueens {
    private int[] files = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };

    public EightQueens() {
        int i = 0;
        do {
            boolean canPlace = false;
            while (placeQueenInNextPos(i)) {
                if (!queensCanCapture(i)) {
                    canPlace = true;
                    break;
                }
            }
            if (canPlace) {
                i++;
            } else {
                i--;
            }
        } while (i <= 7);
    }

    private boolean queensCanCapture(int maxQueenIndex) {
        for (int i = 0; i <= maxQueenIndex; i++) {
            for (int j = i + 1; j <= maxQueenIndex; j++) {
                if (canCapture(files[i], i + 1, files[j], j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean placeQueenInNextPos(int queenIndex) {
        if (files[queenIndex] < 8) {
            files[queenIndex]++;
            return true;
        }
        files[queenIndex] = 0;
        return false;
    }

    public static boolean canCapture(String queen1, String queen2) {
        return canCapture(parseFile(queen1), parseRank(queen1), parseFile(queen2), parseRank(queen2));
    }

    private static boolean canCapture(int file1, int rank1, int file2, int rank2) {
        return (file1 == file2) || (rank1 == rank2) || (Math.abs(file1 - file2) == Math.abs(rank1 - rank2));
    }

    private static int parseFile(String square) {
        if (square == null) {
            throw new IllegalArgumentException("Square can't be null");
        }
        if (square.length() != 2) {
            throw new IllegalArgumentException("Invalid algebraic chess notation: " + square);
        }
        int result = square.charAt(0) - 'a' + 1;
        if (result < 1 || result > 8) {
            throw new IllegalArgumentException("Invalid file. Must be between 'a' and 'h': " + square.charAt(0));
        }
        return result;
    }

    private static int parseRank(String square) {
        if (square == null) {
            throw new IllegalArgumentException("Square can't be null");
        }
        if (square.length() != 2) {
            throw new IllegalArgumentException("Invalid algebraic chess notation: " + square);
        }
        int result = square.charAt(1) - '0';
        if (result < 1 || result > 8) {
            throw new IllegalArgumentException("Invalid rank. Must be between '1' and '8': " + square);
        }
        return result;
    }

    public String[] getPositions() {
        String[] result = new String[8];
        for (int queenIndex = 0; queenIndex <= 7; queenIndex++) {
            result[queenIndex] = toSquare(files[queenIndex], queenIndex + 1);
        }
        return result;
    }

    private String toSquare(int file, int rank) {
        char fileChar = (char) ('a' + file - 1);
        return Character.toString(fileChar) + rank;
    }

    public static void main(String[] args) {
        System.out.println("Here are non-capturing queens: " + Arrays.toString(new EightQueens().getPositions()));
    }
}
