import java.util.Scanner;

public class StarPatterns {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();

        // Right-Angled Triangle
        System.out.println("Right-Angled Triangle:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Inverted Right-Angled Triangle
        System.out.println("\nInverted Right-Angled Triangle:");
        for (int i = rows; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Equilateral Triangle
        System.out.println("\nEquilateral Triangle:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Diamond Pattern
        System.out.println("\nDiamond Pattern:");
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= rows - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Pascal's Triangle
        System.out.println("\nPascal's Triangle:");
        for (int i = 0; i < rows; i++) {
            // Print spaces before the stars
            for (int j = 0; j < rows - i - 1; j++) {
                System.out.print(" ");
            }

            // Print stars in each row
            int numStars = 1;
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
                numStars *= (i - j) / (j + 1);
            }

            System.out.println();
        }
        System.out.println("HourGlass Pattern:");
        // Upper half
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (rows - i + 1) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        // Lower half
        for (int i = rows - 1; i >= 1; i--) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= 2 * (rows - i + 1) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}