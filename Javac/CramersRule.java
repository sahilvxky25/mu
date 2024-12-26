import java.util.Scanner;

public class CramersRule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of variables: ");
        int n = sc.nextInt();

        double[][] matrix = new double[n][n];
        double[] constants = new double[n];

        System.out.println("Enter the coefficients of the variables:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }

        System.out.println("Enter the constants:");
        for (int i = 0; i < n; i++) {
            constants[i] = sc.nextDouble();
        }

        double determinant = calculateDeterminant(matrix);

        if (determinant == 0) {
            System.out.println("The system has no unique solution.");
        } else {
            double[] solutions = new double[n];
            for (int i = 0; i < n; i++) {
                double[][] modifiedMatrix = getModifiedMatrix(matrix, constants, i);
                solutions[i] = calculateDeterminant(modifiedMatrix) / determinant;
            }

            System.out.println("Solutions:");
            for (int i = 0; i < n; i++) {
                System.out.println("x" + (i + 1) + " = " + solutions[i]);
            }
        }

        sc.close();
    }

    public static double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        double determinant = 0;
        for (int i = 0; i < n; i++) {
            double[][] subMatrix = new double[n - 1][n - 1];
            for (int j = 1; j < n; j++) {
                int columnIndex = 0;
                for (int k = 0; k < n; k++) {
                    if (k == i) {
                        continue;
                    }
                    subMatrix[j - 1][columnIndex++] = matrix[j][k];
                }
            }
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(subMatrix);
        }
        return determinant;
    }

    public static double[][] getModifiedMatrix(double[][] matrix, double[] constants, int column) {
        int n = matrix.length;
        double[][] modifiedMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j == column) {
                    modifiedMatrix[i][j] = constants[i];
                } else {
                    modifiedMatrix[i][j] = matrix[i][j];
                }
            }
        }
        return modifiedMatrix;
    }
}
