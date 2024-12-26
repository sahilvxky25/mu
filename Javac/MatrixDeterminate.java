import java.util.Scanner;

public class MatrixDeterminant {

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
        double det = determinant(matrix); // calculate the determinant
        System.out.println("The determinant of the matrix is: " + det); // print the result
    }
}
