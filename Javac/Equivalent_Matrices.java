import java.util.Scanner;

public class MatrixEquivalence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input dimensions of the matrices
        System.out.println("Enter the number of rows and columns of the matrices:");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // Input first matrix
        System.out.println("Enter the elements of the first matrix:");
        int[][] matrix1 = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j] = scanner.nextInt();
            }
        }

        // Input second matrix
        System.out.println("Enter the elements of the second matrix:");
        int[][] matrix2 = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix2[i][j] = scanner.nextInt();
            }
        }

        // Check equivalence
        boolean areEquivalent = true;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    areEquivalent = false;
                    break;
                }
            }
            if (!areEquivalent) {
                break;
            }
        }

        // Output the result
        if (areEquivalent) {
            System.out.println("The matrices are equivalent.");
        } else {
            System.out.println("The matrices are not equivalent.");
        }

        scanner.close();
    }
}
