import java.util.Arrays;

public class MatrixEigenvalueCalculator {
    // Tolerance for floating-point comparisons
    private static final double EPSILON = 1e-10;
    // Maximum number of iterations for QR algorithm
    private static final int MAX_ITERATIONS = 1000;

    /**
     * Calculate eigenvalues using the QR Algorithm.
     * 
     * The QR algorithm is an iterative method for computing eigenvalues 
     * that works by repeatedly decomposing the matrix into Q and R matrices
     * and transforming it to a triangular form.
     * 
     * @param matrix The input square matrix
     * @return Array of eigenvalues
     * @throws IllegalArgumentException If matrix is not square
     */
    public static double[] calculateEigenvalues(double[][] matrix) {
        // Validate input matrix
        validateMatrix(matrix);

        // Create a copy of the matrix to work with
        double[][] workingMatrix = copyMatrix(matrix);
        int n = workingMatrix.length;

        // Perform QR decomposition iteratively
        for (int iteration = 0; iteration < MAX_ITERATIONS; iteration++) {
            // Perform QR decomposition
            double[][] q = new double[n][n];
            double[][] r = new double[n][n];
            performQRDecomposition(workingMatrix, q, r);

            // Multiply R * Q to get the next iteration matrix
            double[][] nextMatrix = multiplyMatrices(r, q);

            // Check for convergence
            if (isConverged(workingMatrix, nextMatrix)) {
                break;
            }

            // Update working matrix
            workingMatrix = nextMatrix;
        }

        // Extract eigenvalues from the diagonal
        return extractDiagonalValues(workingMatrix);
    }

    /**
     * Validate the input matrix.
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
     * Perform QR Decomposition using Gram-Schmidt process.
     * 
     * This decomposes the matrix into an orthogonal matrix Q 
     * and an upper triangular matrix R.
     * 
     * @param matrix Input matrix
     * @param q Output orthogonal matrix
     * @param r Output upper triangular matrix
     */
    private static void performQRDecomposition(double[][] matrix, double[][] q, double[][] r) {
        int n = matrix.length;

        // Copy matrix columns to Q
        for (int j = 0; j < n; j++) {
            // Copy column
            for (int i = 0; i < n; i++) {
                q[i][j] = matrix[i][j];
            }

            // Orthogonalize against previous columns
            for (int k = 0; k < j; k++) {
                // Calculate projection
                double proj = dotProduct(matrix[j], q[k]);
                for (int i = 0; i < n; i++) {
                    q[i][j] -= proj * q[i][k];
                }
            }

            // Normalize the column
            double norm = Math.sqrt(dotProduct(q[j], q[j]));
            for (int i = 0; i < n; i++) {
                q[i][j] /= norm;
            }
        }

        // Calculate R = Q^T * A
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                r[i][j] = dotProduct(q[i], matrix[j]);
            }
        }
    }

    /**
     * Compute dot product of two columns.
     * 
     * @param col1 First column
     * @param col2 Second column
     * @return Dot product
     */
    private static double dotProduct(double[] col1, double[] col2) {
        double sum = 0;
        for (int i = 0; i < col1.length; i++) {
            sum += col1[i] * col2[i];
        }
        return sum;
    }

    /**
     * Multiply two matrices.
     * 
     * @param a First matrix
     * @param b Second matrix
     * @return Resulting matrix
     */
    private static double[][] multiplyMatrices(double[][] a, double[][] b) {
        int rowsA = a.length;
        int colsA = a[0].length;
        int colsB = b[0].length;

        double[][] result = new double[rowsA][colsB];

        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    /**
     * Check if matrix has converged.
     * 
     * @param oldMatrix Previous iteration matrix
     * @param newMatrix Current iteration matrix
     * @return True if matrices are sufficiently close
     */
    private static boolean isConverged(double[][] oldMatrix, double[][] newMatrix) {
        for (int i = 0; i < oldMatrix.length; i++) {
            for (int j = 0; j < oldMatrix.length; j++) {
                if (Math.abs(oldMatrix[i][j] - newMatrix[i][j]) > EPSILON) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Extract diagonal values as eigenvalues.
     * 
     * @param matrix Converged matrix
     * @return Array of eigenvalues
     */
    private static double[] extractDiagonalValues(double[][] matrix) {
        int n = matrix.length;
        double[] eigenvalues = new double[n];

        for (int i = 0; i < n; i++) {
            eigenvalues[i] = matrix[i][i];
        }

        return eigenvalues;
    }

    /**
     * Create a deep copy of the matrix.
     * 
     * @param matrix Original matrix
     * @return Copy of the matrix
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
        // Example matrices
        double[][] matrix1 = {
            {4, -2},
            {1, 1}
        };

        double[][] matrix2 = {
            {3, 1},
            {2, 2}
        };

        try {
            System.out.println("Eigenvalues of Matrix 1:");
            printEigenvalues(calculateEigenvalues(matrix1));

            System.out.println("\nEigenvalues of Matrix 2:");
            printEigenvalues(calculateEigenvalues(matrix2));
        } catch (Exception e) {
            System.err.println("Error calculating eigenvalues: " + e.getMessage());
        }
    }

    /**
     * Pretty print eigenvalues.
     * 
     * @param eigenvalues Array of eigenvalues
     */
    private static void printEigenvalues(double[] eigenvalues) {
        for (int i = 0; i < eigenvalues.length; i++) {
            System.out.printf("λ%d = %.4f%n", i + 1, eigenvalues[i]);
        }
    }
}