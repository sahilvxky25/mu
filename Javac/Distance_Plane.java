import java.util.Scanner;

public class DistanceFromPlane {

    // Method to calculate the distance of a point from a plane
    public static double distanceFromPlane(double A, double B, double C, double D, double x1, double y1, double z1) {
        // Numerator: Absolute value of Ax1 + By1 + Cz1 + D
        double numerator = Math.abs(A * x1 + B * y1 + C * z1 + D);

        // Denominator: Square root of A^2 + B^2 + C^2
        double denominator = Math.sqrt(A * A + B * B + C * C);

        // Distance = Numerator / Denominator
        return numerator / denominator;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coefficients of the plane equation Ax + By + Cz + D = 0
        System.out.println("Enter the coefficients of the plane equation (Ax + By + Cz + D = 0):");
        System.out.print("Enter A: ");
        double A = scanner.nextDouble();
        System.out.print("Enter B: ");
        double B = scanner.nextDouble();
        System.out.print("Enter C: ");
        double C = scanner.nextDouble();
        System.out.print("Enter D: ");
        double D = scanner.nextDouble();

        // Input the coordinates of the point
        System.out.println("\nEnter the coordinates of the point (x1, y1, z1):");
        System.out.print("Enter x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter z1: ");
        double z1 = scanner.nextDouble();

        // Calculate the distance
        double distance = distanceFromPlane(A, B, C, D, x1, y1, z1);

        // Output the result
        System.out.printf("\nThe distance of the point (%.2f, %.2f, %.2f) from the plane %.1fx + %.1fy + %.1fz + %.1f = 0 is: %.2f\n",
                x1, y1, z1, A, B, C, D, distance);

        scanner.close();
    }
}
