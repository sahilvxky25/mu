import java.awt.geom.Point2D;
import java.util.Scanner;

public class NinePointCircle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for the coordinates of the triangle vertices
        System.out.println("Enter the coordinates of the triangle vertices:");

        System.out.print("Enter x-coordinate of A: ");
        double Ax = scanner.nextDouble();
        System.out.print("Enter y-coordinate of A: ");
        double Ay = scanner.nextDouble();

        System.out.print("Enter x-coordinate of B: ");
        double Bx = scanner.nextDouble();
        System.out.print("Enter y-coordinate of B: ");
        double By = scanner.nextDouble();

        System.out.print("Enter x-coordinate of C: ");
        double Cx = scanner.nextDouble();
        System.out.print("Enter y-coordinate of C: ");
        double Cy = scanner.nextDouble();

        // Create Point objects for the vertices of the triangle
        Point2D.Double A = new Point2D.Double(Ax, Ay);
        Point2D.Double B = new Point2D.Double(Bx, By);
        Point2D.Double C = new Point2D.Double(Cx, Cy);

        // Step 1: Calculate the circumcenter and circumradius
        Point2D.Double circumcenter = findCircumcenter(A, B, C);
        double circumradius = calculateCircumradius(A, B, C);

        // Step 2: Radius of the Nine-Point Circle is half the circumradius
        double ninePointRadius = circumradius / 2;

        // Step 3: Equation of the Nine-Point Circle (center, radius)
        System.out.println("\nNine-Point Circle Equation: ");
        System.out.println("(x - " + circumcenter.x + ")^2 + (y - " + circumcenter.y + ")^2 = " + ninePointRadius * ninePointRadius);
        
        scanner.close();
    }

    // Method to find the circumcenter of a triangle (A, B, C)
    public static Point2D.Double findCircumcenter(Point2D.Double A, Point2D.Double B, Point2D.Double C) {
        double D = 2 * (A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y));
        
        double Ux = ((A.x * A.x + A.y * A.y) * (B.y - C.y) +
                     (B.x * B.x + B.y * B.y) * (C.y - A.y) +
                     (C.x * C.x + C.y * C.y) * (A.y - B.y)) / D;

        double Uy = ((A.x * A.x + A.y * A.y) * (C.x - B.x) +
                     (B.x * B.x + B.y * B.y) * (A.x - C.x) +
                     (C.x * C.x + C.y * C.y) * (B.x - A.x)) / D;
        
        return new Point2D.Double(Ux, Uy);
    }

    // Method to calculate the circumradius of a triangle (A, B, C)
    public static double calculateCircumradius(Point2D.Double A, Point2D.Double B, Point2D.Double C) {
        double a = A.distance(B);
        double b = B.distance(C);
        double c = C.distance(A);

        double area = calculateArea(A, B, C);
        
        return (a * b * c) / (4 * area);
    }

    // Method to calculate the area of the triangle using Heron's formula
    public static double calculateArea(Point2D.Double A, Point2D.Double B, Point2D.Double C) {
        double a = A.distance(B);
        double b = B.distance(C);
        double c = C.distance(A);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
}
