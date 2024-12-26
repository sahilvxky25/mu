import java.util.Scanner;

public class MatrixToUnitMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions of the square matrix
        System.out.println("Enter the size of the square matrix (n x n):");
        int n = scanner.nextInt();

        // Input the matrix
        System.out.println("Enter the elements of the matrix:");
        double[][] matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Initialize the identity matrix
        double[][] identity = new double[n][n];
        for (int i = 0; i < n; i++) {
            identity[i][i] = 1.0;
        }

        // Transform the matrix into a unit (identity) matrix using Gauss-Jordan elimination
        for (int i = 0; i < n; i++) {
            // Make the diagonal element 1
            double diagElement = matrix[i][i];
            if (diagElement == 0) {
                System.out.println("The matrix is not invertible and cannot be transformed into a unit matrix.");
                return;
            }
            for (int j = 0; j < n; j++) {
                matrix[i][j] /= diagElement;
                identity[i][j] /= diagElement;
            }

            // Make all other elements in the current column 0
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    double factor = matrix[k][i];
                    for (int j = 0; j < n; j++) {
                        matrix[k][j] -= factor * matrix[i][j];
                        identity[k][j] -= factor * identity[i][j];
                    }
                }
            }
        }

        // Output the transformed unit (identity) matrix
        System.out.println("The transformed unit matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(identity[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
