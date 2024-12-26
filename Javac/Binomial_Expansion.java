import java.math.BigInteger;
import java.util.Scanner;

public class BinomialExpansion {
    /**
     * Generates and prints all terms of the binomial expansion (x + y)^n
     * For example, (x + y)^3 = x^3 + 3x^2y + 3xy^2 + y^3
     */
    public static void printExpansion(int n) {
        if (n < 0) {
            System.out.println("Please provide a non-negative exponent");
            return;
        }

        // For each term in the expansion
        for (int r = 0; r <= n; r++) {
            // Calculate coefficient using combination formula
            BigInteger coefficient = calculateCombination(n, r);
            
            // Build the term string
            StringBuilder term = new StringBuilder();
            
            // Add coefficient if it's not 1 (except for the case where the whole term is just 1)
            if (!coefficient.equals(BigInteger.ONE) || (r == n && n == 0)) {
                term.append(coefficient);
            }
            
            // Add x term if power of x is not 0
            if (n - r > 0) {
                term.append("x");
                if (n - r > 1) {
                    term.append("^").append(n - r);
                }
            }
            
            // Add y term if power of y is not 0
            if (r > 0) {
                term.append("y");
                if (r > 1) {
                    term.append("^").append(r);
                }
            }
            
            // Print plus sign before all terms except the first
            if (r == 0) {
                System.out.print(term);
            } else {
                System.out.print(" + " + term);
            }
        }
        System.out.println();
    }
    
    /**
     * Calculates the combination C(n,r) = n!/(r!(n-r)!)
     * Uses BigInteger to handle large numbers accurately
     */
    private static BigInteger calculateCombination(int n, int r) {
        if (r > n - r) {
            r = n - r; // Optimize by using the smaller value
        }
        
        BigInteger result = BigInteger.ONE;
        
        // Calculate combination using multiplicative formula
        // C(n,r) = n * (n-1) * ... * (n-r+1) / (r * (r-1) * ... * 1)
        for (int i = 0; i < r; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                         .divide(BigInteger.valueOf(i + 1));
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Clear instructions for the user
            System.out.println("\nBinomial Expansion Calculator");
            System.out.println("This program will calculate the expansion of (x + y)^n");
            System.out.println("Enter a non-negative integer for n (or enter -1 to quit): ");
            
            // Input validation
            try {
                int n = scanner.nextInt();
                
                // Check if user wants to quit
                if (n == -1) {
                    System.out.println("Thank you for using the Binomial Expansion Calculator!");
                    break;
                }
                
                // Validate the input
                if (n < 0) {
                    System.out.println("Error: Please enter a non-negative integer.");
                    continue;
                }
                
                if (n > 20) {
                    System.out.println("Warning: Large values of n may result in very long expansions.");
                    System.out.println("Are you sure you want to continue? (y/n): ");
                    scanner.nextLine(); // Consume the previous newline
                    String response = scanner.nextLine().trim().toLowerCase();
                    if (!response.equals("y") && !response.equals("yes")) {
                        continue;
                    }
                }
                
                // Print the expansion
                System.out.print("(x + y)^" + n + " = ");
                printExpansion(n);
                
            } catch (java.util.InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        
        scanner.close();
    }
}