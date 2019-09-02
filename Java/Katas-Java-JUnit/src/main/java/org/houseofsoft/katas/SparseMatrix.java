package org.houseofsoft.katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Sparse Matrix Assumes sorted input data - by rows then columns
 * 
 * @author DK
 */
public class SparseMatrix {
    /**
     * One cell of data
     */
    static class Cell {
        private long i, j, p;

        /**
         * Initialize as an empty ("NULL") cell
         */
        Cell() {
            i = j = Long.MAX_VALUE;
        }

        /**
         * Initialize with data
         * 
         * @param i
         *            row
         * @param j
         *            column
         * @param p
         *            payload
         */
        public Cell(long i, long j, long p) {
            this.i = i;
            this.j = j;
            this.p = p;
        }

        public long getI() {
            return i;
        }

        public long getJ() {
            return j;
        }

        public long getP() {
            return p;
        }

        /**
         * Compare indices
         * 
         * @param otherCell
         *            another cell to compare to
         * @return does this cell have the same index as the other one?
         */
        public boolean isSameIndex(Cell otherCell) {
            return (i == otherCell.getI()) && (j == otherCell.getJ());
        }

        /**
         * Compare indices
         * 
         * @param otherCell
         * @return does this cell have the index prior (to the upper left) to the other one?
         */
        public boolean isPriorIndex(Cell otherCell) {
            return (i < otherCell.getI()) || (i == otherCell.getI()) && (j < otherCell.getJ());
        }

        /**
         * Add data from the other cell
         * 
         * @param otherCell
         * @return
         */
        public Cell add(Cell otherCell) {
            assert isSameIndex(otherCell) : "The other cell: " + otherCell
                    + " must have the same index as this one: " + toString();
            return new Cell(i, j, p + otherCell.getP());
        }

        @Override
        public String toString() {
            return "(" + i + ", " + j + ", " + p + ")";
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (i ^ (i >>> 32));
            result = prime * result + (int) (j ^ (j >>> 32));
            result = prime * result + (int) (p ^ (p >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Cell other = (Cell) obj;
            if (i != other.i) {
                return false;
            }
            if (j != other.j) {
                return false;
            }
            if (p != other.p) {
                return false;
            }
            return true;
        }
    }

    private static final Cell NULL_CELL = new Cell();

    private List<Cell> data = new ArrayList<Cell>();
    private Iterator<Cell> cursor;

    /**
     * Initialize empty matrix
     */
    public SparseMatrix() {

    }

    /**
     * Initialize matrix from an array of triplets: (i,j,p)
     * 
     * @param data
     *            an array of triplets: (i,j,p)
     */
    public SparseMatrix(long[][] data) {
        for (long[] cellData : data) {
            assert cellData.length == 3 : "Expected triplet passed instead of " + Arrays.toString(cellData);
            addCell(new Cell(cellData[0], cellData[1], cellData[2]));
        }
    }

    /**
     * Matrix addition
     * 
     * @param addend
     *            another matrix to add
     * @return sum
     */
    public SparseMatrix add(SparseMatrix addend) {
        resetCursor();
        addend.resetCursor();
        SparseMatrix result = new SparseMatrix();

        Cell leftCell = NULL_CELL, rightCell = NULL_CELL;
        boolean nextLeft = true, nextRight = true;
        do {
            if (nextLeft) {
                if (hasNext()) {
                    leftCell = next();
                } else {
                    leftCell = NULL_CELL;
                }
            }
            if (nextRight) {
                if (addend.hasNext()) {
                    rightCell = addend.next();
                } else {
                    rightCell = NULL_CELL;
                }
            }

            if (leftCell == NULL_CELL && rightCell == NULL_CELL) {
                break;
            }

            if (leftCell.isSameIndex(rightCell)) {
                result.addCell(leftCell.add(rightCell));
                nextLeft = true;
                nextRight = true;
            } else if (leftCell.isPriorIndex(rightCell)) {
                result.addCell(leftCell);
                nextLeft = true;
                nextRight = false;
            } else {
                result.addCell(rightCell);
                nextLeft = false;
                nextRight = true;
            }
        } while (true);
        return result;
    }

    /**
     * Insert another cell into the matrix
     * 
     * @param cell
     *            cell to add
     */
    public void addCell(Cell cell) {
        assert data.isEmpty() || data.get(data.size() - 1).isPriorIndex(cell) : "Cells must be sorted in the input data. This cell is out of order: "
                + cell;
        data.add(cell);
    }

    @Override
    public String toString() {
        return Arrays.toString(data.toArray());
    }

    /**
     * hashCode() based on data
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((data == null) ? 0 : data.toArray().hashCode());
        return result;
    }

    /**
     * equals() based on data
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        SparseMatrix other = (SparseMatrix) obj;
        if (data == null) {
            if (other.data != null) {
                return false;
            }
        } else if (!Arrays.equals(data.toArray(), other.data.toArray())) {
            return false;
        }
        return true;
    }

    /**
     * Check if the next cell exists
     * 
     * @return true if exists
     */
    public boolean hasNext() {
        return cursor.hasNext();
    }

    /**
     * Get the next cell
     * 
     * @return cell
     */
    public Cell next() {
        return cursor.next();
    }

    /**
     * Reset cursor used in hasNext()/next()
     */
    public void resetCursor() {
        cursor = this.data.iterator();
    }
}
