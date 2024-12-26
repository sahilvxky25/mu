import java.util.Scanner;

public class LargestDeterminant {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input matrix size
        System.out.println("Enter the size of the square matrix (n x n):");
        int n = scanner.nextInt();

        // Input number of elements to specify
        System.out.println("Enter the number of elements (k) you want to specify:");
        int k = scanner.nextInt();

        if (k > n * n) {
            System.out.println("Invalid input! k cannot be greater than the total number of elements in the matrix.");
            return;
        }

        // Initialize the matrix
        double[][] matrix = new double[n][n];

        // Input the k elements from the user
        System.out.println("Enter the row, column, and value of each specified element (1-based indices):");
        for (int i = 0; i < k; i++) {
            System.out.print("Element " + (i + 1) + " - Row: ");
            int row = scanner.nextInt() - 1; // Convert to 0-based index
            System.out.print("Element " + (i + 1) + " - Column: ");
            int col = scanner.nextInt() - 1; // Convert to 0-based index
            System.out.print("Element " + (i + 1) + " - Value: ");
            matrix[row][col] = scanner.nextDouble();
        }

        // Set the unspecified elements to maximize the determinant
        System.out.println("Setting unspecified elements to maximize the determinant...");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = (i == j) ? 1 : 0; // Set diagonal elements to 1, others to 0
                }
            }
        }

        // Display the resulting matrix
        System.out.println("The resulting matrix is:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Calculate the determinant of the resulting matrix
        double determinant = calculateDeterminant(matrix, n);

        // Display the determinant
        System.out.println("The largest possible determinant is: " + determinant);

        scanner.close();
    }

    // Method to calculate the determinant of a matrix
    private static double calculateDeterminant(double[][] matrix, int n) {
        if (n == 1) {
            return matrix[0][0];
        }

        if (n == 2) {
            return (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
        }

        double determinant = 0;
        double[][] subMatrix = new double[n - 1][n - 1];

        for (int k = 0; k < n; k++) {
            getSubMatrix(matrix, subMatrix, 0, k, n);
            determinant += Math.pow(-1, k) * matrix[0][k] * calculateDeterminant(subMatrix, n - 1);
        }

        return determinant;
    }

    // Helper method to extract the submatrix
    private static void getSubMatrix(double[][] matrix, double[][] subMatrix, int excludingRow, int excludingCol, int n) {
        int r = -1;
        for (int i = 0; i < n; i++) {
            if (i == excludingRow) {
                continue;
            }
            r++;
            int c = -1;
            for (int j = 0; j < n; j++) {
                if (j == excludingCol) {
                    continue;
                }
                subMatrix[r][++c] = matrix[i][j];
            }
        }
    }
}
