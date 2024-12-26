import java.util.Scanner;

public class TriangleAreaFromLines {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coefficients of the three lines
        System.out.println("Enter the coefficients of the first line (Ax + By + C = 0):");
        System.out.print("A1: ");
        double A1 = scanner.nextDouble();
        System.out.print("B1: ");
        double B1 = scanner.nextDouble();
        System.out.print("C1: ");
        double C1 = scanner.nextDouble();

        System.out.println("Enter the coefficients of the second line (Ax + By + C = 0):");
        System.out.print("A2: ");
        double A2 = scanner.nextDouble();
        System.out.print("B2: ");
        double B2 = scanner.nextDouble();
        System.out.print("C2: ");
        double C2 = scanner.nextDouble();

        System.out.println("Enter the coefficients of the third line (Ax + By + C = 0):");
        System.out.print("A3: ");
        double A3 = scanner.nextDouble();
        System.out.print("B3: ");
        double B3 = scanner.nextDouble();
        System.out.print("C3: ");
        double C3 = scanner.nextDouble();

        // Find the intersection points of the lines
        double[] point1 = intersectionPoint(A1, B1, C1, A2, B2, C2);
        double[] point2 = intersectionPoint(A2, B2, C2, A3, B3, C3);
        double[] point3 = intersectionPoint(A3, B3, C3, A1, B1, C1);

        if (point1 == null || point2 == null || point3 == null) {
            System.out.println("The lines do not form a triangle.");
        } else {
            // Calculate the area of the triangle
            double area = Math.abs(
                point1[0] * (point2[1] - point3[1]) +
                point2[0] * (point3[1] - point1[1]) +
                point3[0] * (point1[1] - point2[1])
            ) / 2;

            System.out.printf("The area of the triangle is: %.2f\n", area);
        }

        scanner.close();
    }

    // Method to find the intersection point of two lines
    private static double[] intersectionPoint(double A1, double B1, double C1, double A2, double B2, double C2) {
        double determinant = A1 * B2 - A2 * B1;

        if (determinant == 0) {
            // Lines are parallel or coincident
            return null;
        }

        double x = (B1 * C2 - B2 * C1) / determinant;
        double y = (A2 * C1 - A1 * C2) / determinant;

        return new double[] { x, y };
    }
}
