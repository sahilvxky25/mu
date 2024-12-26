import java.util.Scanner;

public class MatrixAdjoint {

    // A method to calculate the cofactor of a matrix element
    public static double cofactor(double[][] matrix, int row, int col) {
        int n = matrix.length; // the dimension of the matrix
        double[][] minor = new double[n-1][n-1]; // the minor matrix
        for (int i = 0; i < n; i++) { // loop through the rows
            if (i != row) { // skip the row that matches the element
                for (int j = 0; j < n; j++) { // loop through the columns
                    if (j != col) { // skip the column that matches the element
                        int index_i = i < row ? i : i - 1; // adjust the index for minor matrix
                        int index_j = j < col ? j : j - 1; // adjust the index for minor matrix
                        minor[index_i][index_j] = matrix[i][j]; // copy the element to the minor matrix
                    }
                }
            }
        }
        // return the cofactor using the formula: (-1)^(i+j) * det(minor)
        return Math.pow(-1, row + col) * determinant(minor);
    }

    // A method to calculate the determinant of a matrix recursively
    public static double determinant(double[][] matrix) {
        int n = matrix.length; // the dimension of the matrix
        if (n == 1) { // base case: 1x1 matrix
            return matrix[0][0];
        }
        if (n == 2) { // base case: 2x2 matrix
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        // general case: nxn matrix
        double det = 0; // the determinant
        for (int i = 0; i < n; i++) { // loop through the first row
            double[][] minor = new double[n-1][n-1]; // the minor matrix
            for (int j = 0; j < n; j++) { // loop through the columns
                if (j != i) { // skip the column that matches the row element
                    for (int k = 1; k < n; k++) { // loop through the remaining rows
                        int index = j < i ? j : j - 1; // adjust the index for minor matrix
                        minor[k-1][index] = matrix[k][j]; // copy the element to the minor matrix
                    }
                }
            }
            // add the term to the determinant using the cofactor expansion formula
            det += Math.pow(-1, i) * matrix[0][i] * determinant(minor);
        }
        return det; // return the final determinant
    }

    // A method to calculate the adjoint of a matrix
    public static double[][] adjoint(double[][] matrix) {
        int n = matrix.length; // the dimension of the matrix
        double[][] adj = new double[n][n]; // the adjoint matrix
        for (int i = 0; i < n; i++) { // loop through the rows
            for (int j = 0; j < n; j++) { // loop through the columns
                // calculate the cofactor of the element at (i,j)
                double cof = cofactor(matrix, i, j);
                // place the cofactor at the transpose position (j,i)
                adj[j][i] = cof;
            }
        }
        return adj; // return the adjoint matrix
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // create a scanner object
        System.out.println("Enter the dimension of the matrix: "); // prompt the user for the dimension
        int n = sc.nextInt(); // read the dimension
        double[][] matrix = new double[n][n]; // create a matrix of the given dimension
        System.out.println("Enter the elements of the matrix: "); // prompt the user for the elements
        for (int i = 0; i < n; i++) { // loop through the rows
            for (int j = 0; j < n; j++) { // loop through the columns
                matrix[i][j] = sc.nextDouble(); // read the element
            }
        }
        sc.close(); // close the scanner
        double[][] adj = adjoint(matrix); // calculate the adjoint
        System.out.println("The adjoint of the matrix is: "); // print the result
        for (int i = 0; i < n; i++) { // loop through the rows
            for (int j = 0; j < n; j++) { // loop through the columns
                System.out.print(adj[i][j] + " "); // print the element
            }
            System.out.println(); // print a new line
        }
    }
}
