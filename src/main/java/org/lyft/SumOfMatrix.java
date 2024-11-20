package org.lyft;

/**
 * summing numbers in a matrix
 */
public class SumOfMatrix {

    public static int sumOfMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int sum = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
}
