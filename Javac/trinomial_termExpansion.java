import java.math.BigInteger;
import java.util.Scanner;

public class TrinomialExpansion {
    /**
     * Calculates and prints the trinomial expansion (x + y + z)^n as an equation.
     */
    public static void writeExpansionAsEquation(int x, int y, int z, int n) {
        StringBuilder equation = new StringBuilder();

        for (int i = 0; i <= n; i++) { // i is the power of x
            for (int j = 0; j <= n - i; j++) { // j is the power of y
                int k = n - i - j; // k is the power of z

                // Calculate the coefficient
                BigInteger coefficient = calculateTrinomialCoefficient(n, i, j, k);

                // Format the current term
                String term = formatTerm(coefficient, x, i, y, j, z, k);

                // Append term to the equation
                if (equation.length() > 0) {
                    equation.append(" + ");
                }
                equation.append(term);
            }
        }

        System.out.println("Trinomial Expansion: " + equation.toString());
    }

    /**
     * Calculates the trinomial coefficient for (x + y + z)^n
     * Coefficient = n! / (i! * j! * k!)
     */
    private static BigInteger calculateTrinomialCoefficient(int n, int i, int j, int k) {
        return factorial(n).divide(factorial(i).multiply(factorial(j)).multiply(factorial(k)));
    }

    private static BigInteger factorial(int num) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= num; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    private static String formatTerm(BigInteger coefficient, int x, int xPower, 
                                     int y, int yPower, int z, int zPower) {
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

        // Add y term if power is not 0
        if (yPower != 0) {
            term.append("y");
            if (yPower > 1) {
                term.append("^").append(yPower);
            }
        }

        // Add z term if power is not 0
        if (zPower != 0) {
            term.append("z");
            if (zPower > 1) {
                term.append("^").append(zPower);
            }
        }

        return term.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Trinomial Expansion Calculator!");
        System.out.println("This program will calculate the expansion of (x + y + z)^n");
        System.out.println("----------------------------------------");

        // Get user input
        System.out.print("Enter the value of x: ");
        int x = scanner.nextInt();
        System.out.print("Enter the value of y: ");
        int y = scanner.nextInt();
        System.out.print("Enter the value of z: ");
        int z = scanner.nextInt();
        System.out.print("Enter the power (n) of the expansion: ");
        int n = scanner.nextInt();

        System.out.println("\nResults for (" + x + "x + " + y + "y + " + z + "z)^" + n + ":");
        writeExpansionAsEquation(x, y, z, n);

        scanner.close();
    }
}
