public class MatrixCofactorCalculator {
    /**
     * Calculates the cofactor matrix for a given input matrix.
     * 
     * A cofactor is the signed minor of a matrix element. 
     * For each element, we:
     * 1. Create a submatrix by removing its row and column
     * 2. Calculate the determinant of this submatrix
     * 3. Multiply by (-1)^(i+j) to get the signed value
     * 
     * @param matrix The input matrix
     * @return The cofactor matrix
     * @throws IllegalArgumentException If matrix is not square
     */
    public static double[][] calculateCofactorMatrix(double[][] matrix) {
        // Validate input matrix
        validateMatrix(matrix);

        int n = matrix.length;
        double[][] cofactorMatrix = new double[n][n];

        // Calculate cofactor for each element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Calculate cofactor by finding determinant of submatrix
                cofactorMatrix[i][j] = calculateCofactor(matrix, i, j);
            }
        }

        return cofactorMatrix;
    }

    /**
     * Calculates the cofactor for a specific matrix element.
     * 
     * @param matrix The original matrix
     * @param row Row index of the element
     * @param col Column index of the element
     * @return The cofactor value
     */
    private static double calculateCofactor(double[][] matrix, int row, int col) {
        // Create submatrix by removing current row and column
        double[][] subMatrix = createSubMatrix(matrix, row, col);

        // Calculate determinant of submatrix
        double minor = calculateDeterminant(subMatrix);

        // Apply sign based on position ((-1)^(i+j))
        return Math.pow(-1, row + col) * minor;
    }

    /**
     * Creates a submatrix by removing a specific row and column.
     * 
     * @param matrix Original matrix
     * @param excludeRow Row to exclude
     * @param excludeCol Column to exclude
     * @return Reduced submatrix
     */
    private static double[][] createSubMatrix(double[][] matrix, int excludeRow, int excludeCol) {
        int n = matrix.length;
        double[][] subMatrix = new double[n - 1][n - 1];

        int r = 0;
        for (int i = 0; i < n; i++) {
            // Skip the excluded row
            if (i == excludeRow) continue;

            int c = 0;
            for (int j = 0; j < n; j++) {
                // Skip the excluded column
                if (j == excludeCol) continue;

                // Copy remaining elements
                subMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }

        return subMatrix;
    }

    /**
     * Calculates the determinant of a matrix using recursive method.
     * 
     * This method uses cofactor expansion along the first row.
     * 
     * @param matrix Input matrix
     * @return Determinant of the matrix
     */
    private static double calculateDeterminant(double[][] matrix) {
        // Base cases for 1x1 and 2x2 matrices
        int n = matrix.length;
        if (n == 1) return matrix[0][0];
        if (n == 2) return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        // Recursive case: cofactor expansion along first row
        double det = 0;
        for (int j = 0; j < n; j++) {
            // Create submatrix by removing first row and current column
            double[][] subMatrix = createSubMatrix(matrix, 0, j);
            
            // Calculate determinant recursively
            det += Math.pow(-1, j) * matrix[0][j] * calculateDeterminant(subMatrix);
        }

        return det;
    }

    /**
     * Validate that the input is a square matrix.
     * 
     * @param matrix Matrix to validate
     * @throws IllegalArgumentException If matrix is not square
     */
    private static void validateMatrix(double[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        // Check if matrix is square
        int rows = matrix.length;
        for (double[] row : matrix) {
            if (row.length != rows) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }
    }

    /**
     * Prints a matrix in a readable format.
     * 
     * @param matrix Matrix to print
     */
    private static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double val : row) {
                System.out.printf("%8.2f ", val);
            }
            System.out.println();
        }
    }

    // Example usage and demonstration
    public static void main(String[] args) {
        // Example matrices
        double[][] matrix1 = {
            {1, 2},
            {3, 4}
        };

        double[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        try {
            System.out.println("Original Matrix 1:");
            printMatrix(matrix1);
            System.out.println("\nCofactor Matrix 1:");
            printMatrix(calculateCofactorMatrix(matrix1));

            System.out.println("\nOriginal Matrix 2:");
            printMatrix(matrix2);
            System.out.println("\nCofactor Matrix 2:");
            printMatrix(calculateCofactorMatrix(matrix2));
        } catch (Exception e) {
            System.err.println("Error calculating cofactors: " + e.getMessage());
        }
    }
}