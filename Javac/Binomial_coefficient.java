import java.util.Scanner;

public class BinomialExpansion {

    // Method to calculate factorial
    public static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    // Method to calculate nCr (Combination)
    public static long combination(int n, int r) {
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // User inputs
        System.out.print("Enter the power of the binomial (n): ");
        int n = scanner.nextInt();

        System.out.print("Enter the value of p (term index): ");
        int p = scanner.nextInt();

        // Calculate term from the start
        int k_start = p; // k for the (p+1)th term from the start
        long coefficient_start = combination(n, k_start);

        // Calculate term from the end
        int k_end = n - p; // k for the (p+1)th term from the end
        long coefficient_end = combination(n, k_end);

        // Output results
        System.out.println("The (p+1)th term from the start has coefficient: " + coefficient_start);
        System.out.println("The (p+1)th term from the end has coefficient: " + coefficient_end);

        // Bonus: Show the terms explicitly
        System.out.println("Term from the start: C(" + n + ", " + k_start + ") = " + coefficient_start);
        System.out.println("Term from the end: C(" + n + ", " + k_end + ") = " + coefficient_end);

        scanner.close();
    }
}
