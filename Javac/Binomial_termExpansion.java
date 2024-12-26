import java.math.BigInteger;
import java.util.Scanner;

public class BinomialExpansion {
    /**
     * Represents a term in the binomial expansion with both algebraic and numerical forms
     */
    static class Term {
        String algebraicForm;     // The term in algebraic form (e.g., 3x²a)
        BigInteger numericalValue; // The numerical value after substituting variables

        Term(String algebraicForm, BigInteger numericalValue) {
            this.algebraicForm = algebraicForm;
            this.numericalValue = numericalValue;
        }
    }

    /**
     * Writes all terms of the binomial expansion (x + a)^n
     */
    public static Term[] writeAllTerms(int x, int a, int n) {
        Term[] terms = new Term[n + 1];

        for (int p = 0; p <= n; p++) {
            BigInteger coefficient = calculateBinomialCoefficient(n, p);
            int xPower = n - p;
            int aPower = p;
            String algebraicTerm = formatTerm(coefficient, x, xPower, a, aPower);
            BigInteger numericalValue = calculateNumericalValue(coefficient, x, xPower, a, aPower);
            terms[p] = new Term(algebraicTerm, numericalValue);
        }

        return terms;
    }

    /**
     * Calculates the numerical value of a term after substituting variables
     */
    private static BigInteger calculateNumericalValue(BigInteger coefficient, int x, int xPower, 
                                                       int a, int aPower) {
        BigInteger xTerm = BigInteger.valueOf(x).pow(xPower);
        BigInteger aTerm = BigInteger.valueOf(a).pow(aPower);
        return coefficient.multiply(xTerm).multiply(aTerm);
    }

    private static BigInteger calculateBinomialCoefficient(int n, int r) {
        if (r > n - r) {
            r = n - r;
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 0; i < r; i++) {
            result = result.multiply(BigInteger.valueOf(n - i))
                         .divide(BigInteger.valueOf(i + 1));
        }
        return result;
    }

    private static String formatTerm(BigInteger coefficient, int x, int xPower, int a, int aPower) {
        StringBuilder term = new StringBuilder();

        // Add coefficient if not 1
        if (!coefficient.equals(BigInteger.ONE)) {
            term.append(coefficient);
        }

        // Add x term if power is not 0
        if (xPower != 0) {
            term.append("x");
            if (xPower > 1) {
                term.append("^").append(xPower);
            }
        }

        // Add a term if power is not 0
        if (aPower != 0) {
            term.append("a");
            if (aPower > 1) {
                term.append("^").append(aPower);
            }
        }

        return term.toString();
    }

    private static int getValidInput(Scanner scanner, String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = scanner.nextInt();
                if (input >= min && input <= max) {
                    break;
                } else {
                    System.out.printf("Please enter a value between %d and %d.\n", min, max);
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
            }
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Binomial Expansion Term Writer!");
        System.out.println("This program will help you find all terms in a binomial expansion (x + a)^n");
        System.out.println("----------------------------------------");

        // Get user input with validation
        int x = getValidInput(scanner, "Enter the coefficient of x (first term): ", -100, 100);
        int a = getValidInput(scanner, "Enter the value of a (second term): ", -100, 100);
        int n = getValidInput(scanner, "Enter the power (n) of the expansion: ", 1, 20);

        Term[] terms = writeAllTerms(x, a, n);

        // Display results with clear formatting and both algebraic and numerical forms
        System.out.println("\nResults for (" + x + "x + " + a + ")^" + n + ":");
        System.out.println("----------------------------------------");

        for (int i = 0; i <= n; i++) {
            System.out.println("Term " + (i + 1) + ":");
            System.out.println("  Algebraic form: " + terms[i].algebraicForm);
           // System.out.println("  Numerical value: " + terms[i].numericalValue);
        }

        scanner.close();
    }
}
