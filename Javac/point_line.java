import java.util.Scanner;
import java.text.DecimalFormat;

class DistancePointToLine2D {

    // Point2D class to represent a 2D point
    static class Point2D {
        double x, y;

        public Point2D(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Calculate the distance of a point from a line in 2D space.
     *
     * @param point Point2D - the point whose distance is to be calculated
     * @param A double - coefficient of x in the line equation
     * @param B double - coefficient of y in the line equation
     * @param C double - constant in the line equation
     * @return double - the shortest distance from the point to the line
     */
    public static double distanceFromPointToLine(Point2D point, double A, double B, double C) {
        // Distance formula: |Ax + By + C| / sqrt(A^2 + B^2)
        return Math.abs(A * point.x + B * point.y + C) / Math.sqrt(A * A + B * B);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");

        try {
            // Input the coefficients of the line equation Ax + By + C = 0
            System.out.println("Enter the coefficients of the line equation Ax + By + C = 0:");
            System.out.print("A: ");
            double A = scanner.nextDouble();
            System.out.print("B: ");
            double B = scanner.nextDouble();
            System.out.print("C: ");
            double C = scanner.nextDouble();

            // Input the coordinates of the point
            System.out.println("Enter the coordinates of the point (x y):");
            double px = scanner.nextDouble();
            double py = scanner.nextDouble();
            Point2D point = new Point2D(px, py);

            // Calculate the distance
            double distance = distanceFromPointToLine(point, A, B, C);

            // Display the result
            System.out.println("The distance from the point to the line is: " + df.format(distance));

        } catch (Exception e) {
            System.out.println("Error: Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
