import java.util.Scanner;

public class CommonRootChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input coefficients for the first quadratic equation
        System.out.println("For the first quadratic equation (a1*x^2 + b1*x + c1 = 0):");
        System.out.print("Enter coefficient a1: ");
        double a1 = scanner.nextDouble();
        System.out.print("Enter coefficient b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Enter coefficient c1: ");
        double c1 = scanner.nextDouble();

        // Input coefficients for the second quadratic equation
        System.out.println("\nFor the second quadratic equation (a2*x^2 + b2*x + c2 = 0):");
        System.out.print("Enter coefficient a2: ");
        double a2 = scanner.nextDouble();
        System.out.print("Enter coefficient b2: ");
        double b2 = scanner.nextDouble();
        System.out.print("Enter coefficient c2: ");
        double c2 = scanner.nextDouble();

        // Compute coefficients of the resulting linear equation
        double p = b1 * a2 - b2 * a1;
        double q = c1 * a2 - c2 * a1;

        // Check if the linear equation is valid
        if (p == 0 && q == 0) {
            System.out.println("\nThe two equations are identical, hence they share all roots.");
        } else if (p == 0) {
            System.out.println("\nThe two equations have no common root.");
        } else {
            // Solve the linear equation to find the potential common root
            double commonRoot = -q / p;

            // Check if the common root satisfies both equations
            boolean satisfiesFirst = a1 * commonRoot * commonRoot + b1 * commonRoot + c1 == 0;
            boolean satisfiesSecond = a2 * commonRoot * commonRoot + b2 * commonRoot + c2 == 0;

            if (satisfiesFirst && satisfiesSecond) {
                System.out.println("\nThe two equations have exactly one common root: " + commonRoot);
            } else {
                System.out.println("\nThe two equations do not have exactly one common root.");
            }
        }

        scanner.close();
    }
}
