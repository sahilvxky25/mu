public class MatrixEchelonFormChecker {
    /**
     * Checks whether the given matrix is in Echelon Form.
     * 
     * Echelon Form (or Row Echelon Form) has the following properties:
     * 1. Any zero rows are at the bottom of the matrix
     * 2. The leading coefficient (first non-zero element) of a row 
     *    is always to the right of the leading coefficient of the row above it
     * 3. The leading coefficient of each row is 1
     * 
     * @param matrix The 2D array representing the matrix to check
     * @return true if the matrix is in Echelon Form, false otherwise
     */
    public static boolean isEchelonForm(int[][] matrix) {
        // Handle empty or null matrix
        if (matrix == null || matrix.length == 0) {
            return true;
        }

        int previousLeadingIndex = -1;
        boolean foundNonZeroRow = false;

        // Iterate through each row of the matrix
        for (int i = 0; i < matrix.length; i++) {
            // Find the leading coefficient (first non-zero element) in the current row
            int leadingIndex = findLeadingIndex(matrix[i]);

            // Skip zero rows
            if (leadingIndex == -1) {
                // If we've already found a non-zero row, 
                // ensure all subsequent rows are zero rows
                if (foundNonZeroRow) {
                    for (int j = i; j < matrix.length; j++) {
                        if (!isZeroRow(matrix[j])) {
                            return false;
                        }
                    }
                    break;
                }
                continue;
            }

            // Mark that we've found at least one non-zero row
            foundNonZeroRow = true;

            // Check if the leading coefficient is 1
            if (matrix[i][leadingIndex] != 1) {
                return false;
            }

            // Ensure leading index progresses from left to right
            if (leadingIndex <= previousLeadingIndex) {
                return false;
            }

            // Update previous leading index
            previousLeadingIndex = leadingIndex;
        }

        return true;
    }

    /**
     * Finds the index of the first non-zero element in a row.
     * 
     * @param row The row to search
     * @return The index of the first non-zero element, or -1 if all elements are zero
     */
    private static int findLeadingIndex(int[] row) {
        for (int j = 0; j < row.length; j++) {
            if (row[j] != 0) {
                return j;
            }
        }
        return -1;
    }

    /**
     * Checks if a row contains only zero elements.
     * 
     * @param row The row to check
     * @return true if all elements are zero, false otherwise
     */
    private static boolean isZeroRow(int[] row) {
        for (int val : row) {
            if (val != 0) {
                return false;
            }
        }
        return true;
    }

    // Example usage and testing
    public static void main(String[] args) {
        // Example of an Echelon Form matrix
        int[][] echelonMatrix = {
            {1, 0, 0, 4},
            {0, 1, 0, 7},
            {0, 0, 1, 2}
        };

        // Example of a non-Echelon Form matrix
        int[][] nonEchelonMatrix = {
            {1, 2, 3},
            {0, 1, 4},
            {1, 0, 0}
        };

        System.out.println("Is Echelon Matrix in Echelon Form? " + 
            isEchelonForm(echelonMatrix)); // Should print true
        System.out.println("Is Non-Echelon Matrix in Echelon Form? " + 
            isEchelonForm(nonEchelonMatrix)); // Should print false
    }
}