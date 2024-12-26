import java.util.InputMismatchException;
import java.util.Scanner;

public class MathFunctions {
    
    // Method to calculate factorial
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Factorial is not defined for negative numbers.");
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Method to calculate permutations (nPr)
    public static long permutation(int n, int r) {
        if (n < 0 || r < 0) {
            throw new IllegalArgumentException("n and r should be non-negative.");
        }
        if (r > n) {
            throw new IllegalArgumentException("r should not be greater than n.");
        }
        return factorial(n) / factorial(n - r);
    }

    // Method to calculate combinations (nCr)
    public static long combination(int n, int r) {
        if (n < 0 || r < 0) {
            throw new IllegalArgumentException("n and r should be non-negative.");
        }
        if (r > n) {
            throw new IllegalArgumentException("r should not be greater than n.");
        }
        return factorial(n) / (factorial(r) * factorial(n - r));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1: Factorial");
            System.out.println("2: Permutation");
            System.out.println("3: Combination");
            System.out.println("0: Exit");
            
            try {
                int choice = scanner.nextInt();
                
                if (choice == 0) {
                    System.out.println("Exiting...");
                    break;
                }
                
                switch (choice) {
                    case 1:
                        System.out.print("Enter a number: ");
                        int num = scanner.nextInt();
                        System.out.println("Factorial of " + num + " is: " + factorial(num));
                        break;
                    case 2:
                        System.out.print("Enter n: ");
                        int n1 = scanner.nextInt();
                        System.out.print("Enter r: ");
                        int r1 = scanner.nextInt();
                        System.out.println("Permutation (nPr) is: " + permutation(n1, r1));
                        break;
                    case 3:
                        System.out.print("Enter n: ");
                        int n2 = scanner.nextInt();
                        System.out.print("Enter r: ");
                        int r2 = scanner.nextInt();
                        System.out.println("Combination (nCr) is: " + combination(n2, r2));
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid operation.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
