package org.houseofsoft.katas;

import lombok.extern.slf4j.Slf4j;

/**
 * Calculate Ackermann function with arbitrary precision without using analytic formula.<br>
 * It is a function that grows very quickly. The result could be a big number.<br>
 * 
 * A(m, n) where m >=0 and n >=0<br>
 * = n+1 if m = 0<br>
 * = A(m-1, 1) if m > 0 and n=0<br>
 * = A(m-1, A(m, n-1)) if m>0 and n>0<br>
 * 
 * This implementation is limited to <code>int</code> results, and it is using shallow stack, proportional to number of
 * rows, allowing to avoid stack overflows on <code>int</code> results.
 */
@Slf4j
public class AckermannFunc {
    // private final static int MB = 1024 * 1024;

    // Analytic function
    public static int a(int m, int n) {
        log.info("Calculating ackermann({},{})...", m, n);
        if (m < 0 || n < 0) {
            throw new IllegalArgumentException("Arguments must not be negative");
        }
        if (m == 0) {
            return n + 1;
        }
        if (m == 1) {
            return n + 2;
        }
        int result = upArrow(m - 2, 2, n + 3) - 3;
        log.info("= {}", result);
        return result;
    }

    /*
        // Analytic function
        public static BigInteger aBig(int m, int n) {
            log.info("Calculating ackermann({},{})...", m, n);
            if (m < 0 || n < 0) {
                throw new IllegalArgumentException("Arguments must not be negative");
            }
            if (m == 0) {
                return BigInteger.valueOf(n + 1);
            }
            if (m == 1) {
                return BigInteger.valueOf(n + 2);
            }
            BigInteger result = upArrow(m - 2, 2, BigInteger.valueOf(n + 3)).subtract(BigInteger.valueOf(3));
            log.info("= {}", result);
            return result;
        }
    */
    /**
     * Knuth's n-th up-arrow operator, limited to ints
     * 
     * @param n
     *            number of up-arrows: must be non-negative (>=0)<br>
     * @param a
     *            first operand
     * @param b
     *            second operand: must be non-negative (>=0)
     * @return If n == 0, it returns a * b per extrapolated definition
     */
    public static int upArrow(int n, int a, int b) {
        if (n < 0) {
            throw new IllegalArgumentException("n must be >= 0");
        }
        if (b < 0) {
            throw new IllegalArgumentException("b must be >= 0");
        }
        if (b == 0) {
            return 1;
        }
        if (n == 0) {
            return a * b;
        }
        int result = a;
        for (int times = 1; times < b; times++) {
            result = upArrow(n - 1, a, result);
        }
        return result;
    }

    /**
     * Knuth's n-th up-arrow operator
     * 
     * @param n
     *            number of up-arrows: must be non-negative (>=0)<br>
     * @param a
     *            first operand
     * @param b
     *            second operand: must be non-negative (>=0)
     * @return If n == 0, it returns a * b per extrapolated definition
     */
    /*    
        public static BigInteger upArrow(int n, int a, BigInteger b) {
            if (n < 0) {
                throw new IllegalArgumentException("n must be >= 0");
            }
            if (b.compareTo(BigInteger.ZERO) < 0) {
                throw new IllegalArgumentException("b must be >= 0");
            }
            if (b.equals(BigInteger.ZERO)) {
                return BigInteger.ONE;
            }
            if (n == 0) {
                return BigInteger.valueOf(a).multiply(b); // a * b
            }
            BigInteger result = BigInteger.valueOf(a);
            for (BigInteger times = BigInteger.ONE; times.compareTo(b) < 0; times.add(BigInteger.ONE)) {
                result = upArrow(n - 1, a, result);
            }
            return result;
        }
    */

    /*
        // Full calculation using recursion
        private static int aRecursive(int m, int n) {
            if (m < 0 || n < 0) {
                throw new IllegalArgumentException("Arguments must not be negative");
            }
            if (m == 0) {
                return n + 1;
            }
            if (n == 0) {
                return aRecursive(m - 1, 1);
            }
            return aRecursive(m - 1, aRecursive(m, n - 1));
        }

        // Full calculation using shallow stack with sparse matrix
        public static int aShallowStack(int m, int n) {
            log.info("Calculating ackermann({},{})...", m, n);
            try {
                if (m < 0 || n < 0) {
                    throw new IllegalArgumentException("Arguments must not be negative");
                }
                if (m == 0) {
                    return n + 1;
                }
                FlexibleMatrix matrix = new FlexibleMatrix(m);
                int value = 0;
                for (int column = 0; column <= n; column++) {
                    value = matrix.row(m).fill(column);
                    log.info("Last row: [{},{}]={}", m, column, value);
                }

                log.info("= {}", value);
                return value;
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Throwable e) {
                Runtime r = Runtime.getRuntime();
                log.error("Error! (heap memory: used={}M, total={}M, max={}M)",
                        (r.totalMemory() - r.freeMemory()) / MB, r.totalMemory() / MB, r.maxMemory() / MB, e);
                throw e;
            }
        }

        private static class FlexibleMatrix {
            List<FlexibleRow> rows = new ArrayList<>();

            public FlexibleMatrix(int m) {
                FlexibleRow prevRow = null;
                for (int i = 1; i <= m; i++) {
                    FlexibleRow row = new FlexibleRow(prevRow);
                    rows.add(row);
                    prevRow = row;
                }
            }

            public FlexibleRow row(int m) {
                return rows.get(m - 1);
            }
        }

        private static class FlexibleRow {
            // List<Integer> values = new LinkedList<>();
            List<Integer> values = new ArrayList<>(); // ArrayList performs better on this implementation
            FlexibleRow prevRow;

            public FlexibleRow(FlexibleRow prevRow) {
                this.prevRow = prevRow;
            }

            public int m() {
                int rowIndex = 1;
                FlexibleRow r = prevRow;
                while (r != null) {
                    rowIndex++;
                    r = r.prevRow;
                }
                return rowIndex;
            }

            public int lastFilledColumn() {
                return values.size() - 1;
            }

            public void add(int value) {
                values.add(value);
            }

            public int fill(int n) {
                int value = 0;
                for (int unfilledColumn = values.size(); unfilledColumn <= n; unfilledColumn++) {
                    int prevRowColumn = (unfilledColumn == 0) ? 1 : values.get(unfilledColumn - 1);
                    value = (prevRow == null) ? prevRowColumn + 1 : prevRow.fill(prevRowColumn);
                    add(value);
                    log.debug("[{},{}]={}", m(), unfilledColumn, value);
                }
                return value;
            }
        }
    */
}
