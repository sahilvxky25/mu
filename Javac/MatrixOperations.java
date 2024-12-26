import java.util.Scanner;

public class MatrixOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get dimensions for the first matrix
        System.out.println("Enter the number of rows for the first matrix:");
        int rowsA = scanner.nextInt();
        System.out.println("Enter the number of columns for the first matrix:");
        int colsA = scanner.nextInt();

        // Get dimensions for the second matrix
        System.out.println("Enter the number of rows for the second matrix:");
        int rowsB = scanner.nextInt();
        System.out.println("Enter the number of columns for the second matrix:");
        int colsB = scanner.nextInt();

        // Validate dimensions
        if (rowsA <= 0 || colsA <= 0 || rowsB <= 0 || colsB <= 0) {
            System.out.println("Invalid matrix dimensions.");
            return;
        }

        // Create matrices
        int[][] matrixA = new int[rowsA][colsA];
        int[][] matrixB = new int[rowsB][colsB];

        // Fill matrices with values
        System.out.println("Enter the elements of the first matrix:");
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsA; j++) {
                matrixA[i][j] = scanner.nextInt();
            }
        }

        System.out.println("Enter the elements of the second matrix:");
        for (int i = 0; i < rowsB; i++) {
            for (int j = 0; j < colsB; j++) {
                matrixB[i][j] = scanner.nextInt();
            }
        }

        // Perform matrix operations
        if (rowsA == rowsB && colsA == colsB) {
            System.out.println("Matrix Addition:");
            int[][] sum = addMatrices(matrixA, matrixB);
            printMatrix(sum);

            System.out.println("Matrix Subtraction:");
            int[][] difference = subtractMatrices(matrixA, matrixB);
            printMatrix(difference);

            System.out.println("Element-wise Division:");
            double[][] division = divideMatrices(matrixA, matrixB);
            printMatrix(division);
        } else {
            System.out.println("Matrix addition, subtraction, and division are not possible with the given dimensions.");
        }

        // Multiply matrices if dimensions are valid
        if (colsA == rowsB) {
            System.out.println("Matrix Multiplication:");
            int[][] product = multiplyMatrices(matrixA, matrixB);
            printMatrix(product);
        } else {
            System.out.println("Matrix multiplication is not possible with the given dimensions.");
        }

        scanner.close();
    }

    public static int[][] addMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = firstMatrix[0].length;
        int[][] sum = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum[i][j] = firstMatrix[i][j] + secondMatrix[i][j];
            }
        }
        return sum;
    }

    public static int[][] subtractMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = firstMatrix[0].length;
        int[][] difference = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                difference[i][j] = firstMatrix[i][j] - secondMatrix[i][j];
            }
        }
        return difference;
    }

    public static double[][] divideMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int rows = firstMatrix.length;
        int cols = firstMatrix[0].length;
        double[][] division = new double[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (secondMatrix[i][j] != 0) {
                    division[i][j] = (double) firstMatrix[i][j] / secondMatrix[i][j];
                } else {
                    System.out.println("Division by zero detected at element (" + i + "," + j + "). Setting result to infinity.");
                    division[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
        return division;
    }

    public static int[][] multiplyMatrices(int[][] firstMatrix, int[][] secondMatrix) {
        int r1 = firstMatrix.length;
        int c1 = firstMatrix[0].length;
        int c2 = secondMatrix[0].length;
        int[][] product = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    product[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }
        return product;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            for (double column : row) {
                System.out.print(column + " ");
            }
            System.out.println();
        }
    }
}
