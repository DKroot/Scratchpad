package org.houseofsoft.katas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.houseofsoft.katas.SparseMatrix;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SparseMatrixTest {
    private SparseMatrix m1, m2, expectedResult;

    public SparseMatrixTest(SparseMatrix m1, SparseMatrix m2, SparseMatrix expectedResult) {
        super();
        this.m1 = m1;
        this.m2 = m2;
        this.expectedResult = expectedResult;
    }

    //@formatter:off
    @Parameters    
    public static Collection<SparseMatrix[]> defineTestData() {
        List<SparseMatrix[]> testData = new ArrayList<SparseMatrix[]>();

        //each list item defines one test case

        //Test case 0: same positions
        testData.add(new SparseMatrix[] {
                new SparseMatrix(new long[][] {{1, 1, 10}, {2, 2, 20}}),
                new SparseMatrix(new long[][] {{1, 1, 1}, {2, 2, 2}}),
                new SparseMatrix(new long[][] {
                        {1, 1, 11},
                        {2, 2, 22}})
        });

        //Test case 1: first matrix is blank
        testData.add(new SparseMatrix[] {
                new SparseMatrix(),
                new SparseMatrix(new long[][] {{1, 1, 1}}),
                new SparseMatrix(new long[][] {
                        {1, 1, 1}})
        });

        //Test case 2: second matrix is blank
        testData.add(new SparseMatrix[] {
                new SparseMatrix(new long[][] {{1, 1, 10}}),
                new SparseMatrix(),
                new SparseMatrix(new long[][] {
                        {1, 1, 10}})
        });

        //Test case 3: both matrices are blanks
        testData.add(new SparseMatrix[] {
                new SparseMatrix(),
                new SparseMatrix(),
                new SparseMatrix()
        });

        //Test case 4: first matrix is entirely prior to the second one. Second one has 1 cell.
        testData.add(new SparseMatrix[] {
                new SparseMatrix(new long[][] {{1, 1, 10}, {2, 2, 20}, {3, 3, 30}}),
                new SparseMatrix(new long[][] {{4, 4, 4}}),
                new SparseMatrix(new long[][] {
                        {1, 1, 10},
                        {2, 2, 20},
                        {3, 3, 30},
                        {4, 4, 4}})
        });

        //Test case 5: first matrix is entirely prior to the second one. Second one has multiple cells.
        testData.add(new SparseMatrix[] {
                new SparseMatrix(new long[][] {{1, 1, 10}, {2, 2, 20}, {3, 3, 30}}),
                new SparseMatrix(new long[][] {{4, 4, 4}, {5, 5, 5}}),
                new SparseMatrix(new long[][] {
                        {1, 1, 10},
                        {2, 2, 20},
                        {3, 3, 30},
                        {4, 4, 4},
                        {5, 5, 5}})
        });

        //Test case 6: second matrix is entirely prior to the first one
        testData.add(new SparseMatrix[] {
                new SparseMatrix(new long[][] {{4, 4, 40}}),
                new SparseMatrix(new long[][] {{1, 1, 1}, {2, 2, 2}, {3, 3, 3}}),
                new SparseMatrix(new long[][] {
                        {1, 1, 1},
                        {2, 2, 2},
                        {3, 3, 3},
                        {4, 4, 40}})
        });

        //Test case 7: total mix
        testData.add(new SparseMatrix[] {
                new SparseMatrix(new long[][] {{1, 1, 10}, {2, 2, 20}, {3, 3, 30}, {4, 4, 40}}),
                new SparseMatrix(new long[][] {{1, 1, 1}, {1, 2, 2}, {3, 4, 3}, {4, 4, 4}}),
                new SparseMatrix(new long[][] {
                        {1, 1, 11}, {1, 2, 2},
                        {2, 2, 20},
                        {3, 3, 30}, {3, 4, 3},
                        {4, 4, 44}})
        });

        return testData;
    }
    //@formatter:on

    @Test
    public void testAdd() {
        SparseMatrix sum = m1.add(m2);
        assertEquals("Result differs from the expected sum", expectedResult, sum);
    }
}
