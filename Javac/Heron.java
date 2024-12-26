import java.util.Scanner;

public class HeronFormula {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the sides of the triangle
        System.out.println("Enter the lengths of the three sides of the triangle:");
        System.out.print("Side a: ");
        double a = scanner.nextDouble();
        System.out.print("Side b: ");
        double b = scanner.nextDouble();
        System.out.print("Side c: ");
        double c = scanner.nextDouble();

        // Check if the sides form a valid triangle
        if (a + b > c && a + c > b && b + c > a) {
            // Calculate the semi-perimeter
            double s = (a + b + c) / 2;

            // Calculate the area using Heron's formula
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));

            // Output the result
            System.out.printf("The area of the triangle is: %.2f\n", area);
        } else {
            System.out.println("The given sides do not form a valid triangle.");
        }

        scanner.close();
    }
}
