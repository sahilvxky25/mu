import java.util.Scanner;

public class TriangleAngles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the lengths of the sides of the triangle
        System.out.println("Enter the lengths of the three sides of the triangle:");
        System.out.print("Side a: ");
        double a = scanner.nextDouble();
        System.out.print("Side b: ");
        double b = scanner.nextDouble();
        System.out.print("Side c: ");
        double c = scanner.nextDouble();

        // Check if the sides form a valid triangle
        if (a + b > c && a + c > b && b + c > a) {
            // Calculate the angles using the cosine rule
            double angleA = Math.acos((b * b + c * c - a * a) / (2 * b * c));
            double angleB = Math.acos((a * a + c * c - b * b) / (2 * a * c));
            double angleC = Math.acos((a * a + b * b - c * c) / (2 * a * b));

            // Convert angles from radians to degrees
            angleA = Math.toDegrees(angleA);
            angleB = Math.toDegrees(angleB);
            angleC = Math.toDegrees(angleC);

            // Output the angles
            System.out.printf("Angle A: %.2f degrees\n", angleA);
            System.out.printf("Angle B: %.2f degrees\n", angleB);
            System.out.printf("Angle C: %.2f degrees\n", angleC);
        } else {
            System.out.println("The given sides do not form a valid triangle.");
        }

        scanner.close();
    }
}
