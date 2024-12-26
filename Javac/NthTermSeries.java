import java.util.Scanner;

public class NthTermSeries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for the type of series
        System.out.println("Select the type of series:");
        System.out.println("1. Arithmetic Progression (AP)");
        System.out.println("2. Geometric Progression (GP)");
        System.out.println("3. Harmonic Progression (HP)");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                // Arithmetic Progression (AP)
                System.out.println("Enter the first term (a) and common difference (d) of the AP:");
                double a = scanner.nextDouble();
                double d = scanner.nextDouble();
                System.out.println("Enter the term number (n):");
                int n = scanner.nextInt();
                double apNthTerm = a + (n - 1) * d;
                System.out.println("The " + n + "th term of the AP is: " + apNthTerm);
                break;

            case 2:
                // Geometric Progression (GP)
                System.out.println("Enter the first term (a) and common ratio (r) of the GP:");
                a = scanner.nextDouble();
                double r = scanner.nextDouble();
                System.out.println("Enter the term number (n):");
                n = scanner.nextInt();
                double gpNthTerm = a * Math.pow(r, n - 1);
                System.out.println("The " + n + "th term of the GP is: " + gpNthTerm);
                break;

            case 3:
                // Harmonic Progression (HP)
                System.out.println("Enter the first term (a) and common difference (d) of the HP:");
                a = scanner.nextDouble();
                d = scanner.nextDouble();
                System.out.println("Enter the term number (n):");
                n = scanner.nextInt();
                double hpNthTerm = 1 / (a + (n - 1) * d);
                System.out.println("The " + n + "th term of the HP is: " + hpNthTerm);
                break;

            default:
                System.out.println("Invalid choice. Please select a valid option.");
                break;
        }

        scanner.close();
    }
}
