import java.util.*;

public class GreatestCoefficient {

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

    // Recursive function to generate all valid combinations of k1, k2, ..., km where k1 + k2 + ... + km = n
    public static void findGreatestCoefficient(int n, int m, int[] k, int index, List<Long> coefficients) {
        if (index == m - 1) {
            k[index] = n; // The last term is determined automatically
            coefficients.add(multinomialCoefficient(Arrays.stream(k).sum(), k));
            return;
        }

        for (int i = 0; i <= n; i++) {
            k[index] = i;
            findGreatestCoefficient(n - i, m, k, index + 1, coefficients);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for degree of the multinomial expansion
        System.out.print("Enter the degree n of the expansion: ");
        int n = scanner.nextInt();

        // Input for the number of terms in the multinomial
        System.out.print("Enter the number of terms in the expansion: ");
        int m = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Input the terms (names are not used in the calculation but could be displayed for context)
        String[] terms = new String[m];
        System.out.println("Enter the terms (e.g., x, y, z): ");
        for (int i = 0; i < m; i++) {
            terms[i] = scanner.nextLine();
        }

        // Prepare to find the greatest coefficient
        int[] k = new int[m];
        List<Long> coefficients = new ArrayList<>();
        findGreatestCoefficient(n, m, k, 0, coefficients);

        // Find and display the greatest coefficient
        long greatestCoefficient = Collections.max(coefficients);
        System.out.println("The greatest coefficient in the expansion of (" + String.join(" + ", terms) + ")^" + n + " is: " + greatestCoefficient);

        scanner.close();
    }
}
