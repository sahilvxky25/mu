import java.util.Scanner;

public class SeriesSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for the type of progression
        System.out.println("Select the type of progression to calculate the sum:");
        System.out.println("1. Arithmetic Progression (AP)");
        System.out.println("2. Geometric Progression (GP)");
        System.out.println("3. Harmonic Progression (HP)");
        System.out.println("4. Sum of first n natural numbers (AN)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Arithmetic Progression (AP)
                System.out.println("Enter the first term (a) and common difference (d) of the Arithmetic Progression (AP):");
                double a = scanner.nextDouble();
                double d = scanner.nextDouble();
                System.out.println("Enter the number of terms (n):");
                int n = scanner.nextInt();
                double apSum = n / 2.0 * (2 * a + (n - 1) * d);
                System.out.println("Sum of AP: " + apSum);
                break;

            case 2:
                // Geometric Progression (GP)
                System.out.println("Enter the first term (a) and common ratio (r) of the Geometric Progression (GP):");
                a = scanner.nextDouble();
                double r = scanner.nextDouble();
                System.out.println("Enter the number of terms (n):");
                n = scanner.nextInt();
                double gpSum;
                if (r != 1) {
                    gpSum = a * (1 - Math.pow(r, n)) / (1 - r);
                } else {
                    gpSum = a * n;
                }
                System.out.println("Sum of GP: " + gpSum);
                break;

            case 3:
                // Harmonic Progression (HP)
                System.out.println("Enter the first term (a) and common difference (d) of the Harmonic Progression (HP):");
                a = scanner.nextDouble();
                d = scanner.nextDouble();
                System.out.println("Enter the number of terms (n):");
                n = scanner.nextInt();
                double hpSum = 0;
                for (int i = 0; i < n; i++) {
                    hpSum += 1 / (a + i * d);
                }
                System.out.println("Sum of HP: " + hpSum);
                break;

            case 4:
                // Sum of natural numbers (AN)
                System.out.println("Enter the number of terms (n):");
                n = scanner.nextInt();
                int anSum = n * (n + 1) / 2;
                System.out.println("Sum of first " + n + " natural numbers: " + anSum);
                break;

            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }

        scanner.close();
    }
}
