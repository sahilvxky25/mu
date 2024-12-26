import java.util.*;

public class MultinomialExpansion {
    
    // Function to calculate factorial
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    // Function to calculate multinomial coefficient
    public static long multinomialCoefficient(int n, int[] k) {
        long numerator = factorial(n);
        long denominator = 1;
        for (int ki : k) {
            denominator *= factorial(ki);
        }
        return numerator / denominator;
    }

    // Function to generate and print the multinomial expansion
    public static void multinomialExpansion(int n, String[] terms) {
        int m = terms.length;
        
        // Generate all combinations of k1, k2, ..., km where k1 + k2 + ... + km = n
        int[] k = new int[m];
        k[0] = n;
        
        // This method generates the compositions of n into m parts
        while (k[0] >= 0) {
            long coeff = multinomialCoefficient(n, k);
            StringBuilder term = new StringBuilder();
            for (int i = 0; i < m; i++) {
                if (k[i] > 0) {
                    term.append(terms[i]).append("^").append(k[i]);
                    if (i < m - 1) {
                        term.append(" * ");
                    }
                }
            }
            System.out.println(coeff + " * " + term);
            int i = m - 1;
            while (i >= 0 && k[i] == 0) {
                i--;
            }
            if (i < 0) {
                break;
            }
            k[i]--;
            for (int j = i + 1; j < m; j++) {
                k[j] = n - Arrays.stream(k, 0, j).sum();
            }
        }
    }

    public static void main(String[] args) {
        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Asking the user for the degree n of the expansion
        System.out.print("Enter the degree n for the expansion: ");
        int n = scanner.nextInt();
        
        // Asking the user for the number of terms
        System.out.print("Enter the number of terms in the expansion: ");
        int numTerms = scanner.nextInt();
        scanner.nextLine();  // Consume the newline character
        
        // Asking the user to input the terms (variables)
        String[] terms = new String[numTerms];
        System.out.println("Enter the terms (e.g., x, y, z): ");
        for (int i = 0; i < numTerms; i++) {
            terms[i] = scanner.nextLine();
        }
        
        // Calling the function to compute and display the multinomial expansion
        System.out.println("Multinomial Expansion of (" + String.join(" + ", terms) + ")^" + n + " is:");
        multinomialExpansion(n, terms);
        
        scanner.close();
    }
}
