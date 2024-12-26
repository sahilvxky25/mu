import java.util.Arrays;

public class MatrixRankCalculator {
    /**
     * Calculates the rank of a matrix using Gaussian elimination.
     * 
     * The rank of a matrix is the number of linearly independent rows or columns.
     * This method uses row reduction to determine the rank.
     * 
     * @param matrix The input matrix to find the rank of
     * @return The rank of the matrix
     */
    public static int calculateMatrixRank(double[][] matrix) {
        // Handle null or empty matrix
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        // Create a copy of the matrix to avoid modifying the original
        double[][] reducedMatrix = copyMatrix(matrix);

        // Number of rows and columns in the matrix
        int rows = reducedMatrix.length;
        int cols = reducedMatrix[0].length;

        // Track rank and current row/column for reduction
        int rank = 0;
        int currentRow = 0;

        // Iterate through columns
        for (int col = 0; col < cols; col++) {
            // Find pivot row
            int pivotRow = findPivotRow(reducedMatrix, currentRow, col);
            
            // If no pivot found in this column, continue to next column
            if (pivotRow == -1) continue;

            // Swap rows to bring pivot to current row
            swapRows(reducedMatrix, currentRow, pivotRow);

            // Eliminate below the current row
            eliminateRowBelow(reducedMatrix, currentRow, col);

            // Increment rank and move to next row
            rank++;
            currentRow++;

            // Stop if we've processed all rows
            if (currentRow >= rows) break;
        }

        return rank;
    }

    /**
     * Finds the pivot row with the largest absolute value in the specified column.
     * 
     * @param matrix The matrix being processed
     * @param startRow The row to start searching from
     * @param col The column to find the pivot in
     * @return The index of the pivot row, or -1 if no pivot found
     */
    private static int findPivotRow(double[][] matrix, int startRow, int col) {
        int pivotRow = -1;
        double maxValue = 0;

        for (int i = startRow; i < matrix.length; i++) {
            // Use absolute value to find most significant pivot
            double absValue = Math.abs(matrix[i][col]);
            if (absValue > maxValue) {
                maxValue = absValue;
                pivotRow = i;
            }
        }

        return pivotRow;
    }

    /**
     * Swaps two rows in the matrix.
     * 
     * @param matrix The matrix to modify
     * @param row1 First row index
     * @param row2 Second row index
     */
    private static void swapRows(double[][] matrix, int row1, int row2) {
        double[] temp = matrix[row1];
        matrix[row1] = matrix[row2];
        matrix[row2] = temp;
    }

    /**
     * Eliminates entries below the pivot using row operations.
     * 
     * @param matrix The matrix being reduced
     * @param pivotRow The current pivot row
     * @param col The current pivot column
     */
    private static void eliminateRowBelow(double[][] matrix, int pivotRow, int col) {
        for (int i = pivotRow + 1; i < matrix.length; i++) {
            // Calculate elimination factor
            double factor = matrix[i][col] / matrix[pivotRow][col];

            // Subtract multiples of pivot row
            for (int j = col; j < matrix[0].length; j++) {
                matrix[i][j] -= factor * matrix[pivotRow][j];
            }
        }
    }

    /**
     * Creates a deep copy of the input matrix to prevent modification of original.
     * 
     * @param matrix The original matrix
     * @return A deep copy of the matrix
     */
    private static double[][] copyMatrix(double[][] matrix) {
        double[][] copy = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            copy[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
        return copy;
    }

    // Example usage and testing
    public static void main(String[] args) {
        // Example matrices with different ranks
        double[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        double[][] matrix2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };

        double[][] matrix3 = {
            {1, 2},
            {3, 6}
        };

        System.out.println("Rank of Matrix 1: " + calculateMatrixRank(matrix1));
        System.out.println("Rank of Matrix 2: " + calculateMatrixRank(matrix2));
        System.out.println("Rank of Matrix 3: " + calculateMatrixRank(matrix3));
    }
}