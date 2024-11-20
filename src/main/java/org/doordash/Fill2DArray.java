package org.doordash;

public class Fill2DArray {
    public static int[][] generateMagicSquare(int n) {
        int[][] matrix = new int[n][n];
        int targetSum = n * (n * n + 1) / 2;

        int num = 1;
        // Fill the matrix with consecutive integers
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = num++;
            }
        }

        // Check if the sums of rows, columns, and diagonals are equal to the target sum
        for (int i = 0; i < n; i++) {
            int rowSum = 0;
            int colSum = 0;
            for (int j = 0; j < n; j++) {
                rowSum += matrix[i][j];
                colSum += matrix[j][i];
            }
            if (rowSum != targetSum || colSum != targetSum) {
                return null;
            }
        }

        int diag1Sum = 0;
        int diag2Sum = 0;
        for (int i = 0; i < n; i++) {
            diag1Sum += matrix[i][i];
            diag2Sum += matrix[i][n - i - 1];
        }
        if (diag1Sum != targetSum || diag2Sum != targetSum) {
            return null;
        }

        return matrix;
    }

    public static void main(String[] args) {
        int n = 3; // Change the value of n as needed
        int[][] magicSquare = generateMagicSquare(n);
        if (magicSquare != null) {
            // Print the resulting magic square
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(magicSquare[i][j] + "\t");
                }
                System.out.println();
            }
        } else {
            System.out.println("A magic square of size " + n + "x" + n + " is not possible.");
        }
    }
}
