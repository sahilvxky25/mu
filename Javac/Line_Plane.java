import java.util.Scanner;

public class LinePlaneIntersection {

    // Method to calculate the magnitude of a vector
    public static double magnitude(double x, double y, double z) {
        return Math.sqrt(x * x + y * y + z * z);
    }

    // Method to calculate the dot product of two vectors
    public static double dotProduct(double x1, double y1, double z1, double x2, double y2, double z2) {
        return x1 * x2 + y1 * y2 + z1 * z2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coefficients of the plane equation (Ax + By + Cz + D = 0)
        System.out.println("Enter the coefficients of the plane equation (Ax + By + Cz + D = 0):");
        System.out.print("Enter A: ");
        double A = scanner.nextDouble();
        System.out.print("Enter B: ");
        double B = scanner.nextDouble();
        System.out.print("Enter C: ");
        double C = scanner.nextDouble();
        System.out.print("Enter D: ");
        double D = scanner.nextDouble();

        // Input the direction vector of the line
        System.out.println("\nEnter the direction vector of the line (dx, dy, dz):");
        System.out.print("Enter dx: ");
        double dx = scanner.nextDouble();
        System.out.print("Enter dy: ");
        double dy = scanner.nextDouble();
        System.out.print("Enter dz: ");
        double dz = scanner.nextDouble();

        // Input a point on the line
        System.out.println("\nEnter a point on the line (x0, y0, z0):");
        System.out.print("Enter x0: ");
        double x0 = scanner.nextDouble();
        System.out.print("Enter y0: ");
        double y0 = scanner.nextDouble();
        System.out.print("Enter z0: ");
        double z0 = scanner.nextDouble();

        // Calculate the angle between the line and the plane
        double lineMagnitude = magnitude(dx, dy, dz);
        double normalMagnitude = magnitude(A, B, C);
        double dot = dotProduct(dx, dy, dz, A, B, C);

        double sinTheta = Math.abs(dot) / (lineMagnitude * normalMagnitude);
        double theta = Math.toDegrees(Math.asin(sinTheta)); // Convert to degrees

        // Solve for the intersection point
        double denominator = A * dx + B * dy + C * dz;
        if (Math.abs(denominator) < 1e-6) { // Check if the line is parallel to the plane
            System.out.println("\nThe line is parallel to the plane. No intersection point exists.");
        } else {
            // Calculate t
            double t = -(A * x0 + B * y0 + C * z0 + D) / denominator;

            // Calculate the intersection point
            double x = x0 + t * dx;
            double y = y0 + t * dy;
            double z = z0 + t * dz;

            // Output the results
            System.out.printf("\nThe angle between the line and the plane is: %.2f degrees\n", theta);
            System.out.printf("The point of intersection of the line and the plane is: (%.2f, %.2f, %.2f)\n", x, y, z);
        }

        scanner.close();
    }
}
