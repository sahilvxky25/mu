import java.util.Scanner;

public class OrthocenterDistance {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the coordinates of the triangle's vertices
        System.out.println("Enter the coordinates of the first vertex (x1, y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter the coordinates of the second vertex (x2, y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("Enter the coordinates of the third vertex (x3, y3):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // Calculate the slopes of the altitudes
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);

        double perpendicularSlopeAB = -1 / slopeAB;
        double perpendicularSlopeBC = -1 / slopeBC;

        // Find the equations of the altitudes
        // Equation of altitude from C to AB: y - y3 = perpendicularSlopeAB * (x - x3)
        // Equation of altitude from A to BC: y - y1 = perpendicularSlopeBC * (x - x1)

        // Simplify to general form Ax + By + C = 0
        double A1 = perpendicularSlopeAB;
        double B1 = -1;
        double C1 = y3 - perpendicularSlopeAB * x3;

        double A2 = perpendicularSlopeBC;
        double B2 = -1;
        double C2 = y1 - perpendicularSlopeBC * x1;

        // Find the intersection point of the two altitudes (orthocenter)
        double determinant = A1 * B2 - A2 * B1;
        double orthocenterX = (B1 * C2 - B2 * C1) / determinant;
        double orthocenterY = (A2 * C1 - A1 * C2) / determinant;

        System.out.printf("The coordinates of the orthocenter are: (%.2f, %.2f)\n", orthocenterX, orthocenterY);

        // Calculate the distances from the orthocenter to the vertices
        double distanceToA = Math.sqrt(Math.pow(orthocenterX - x1, 2) + Math.pow(orthocenterY - y1, 2));
        double distanceToB = Math.sqrt(Math.pow(orthocenterX - x2, 2) + Math.pow(orthocenterY - y2, 2));
        double distanceToC = Math.sqrt(Math.pow(orthocenterX - x3, 2) + Math.pow(orthocenterY - y3, 2));

        System.out.printf("Distance from orthocenter to A: %.2f\n", distanceToA);
        System.out.printf("Distance from orthocenter to B: %.2f\n", distanceToB);
        System.out.printf("Distance from orthocenter to C: %.2f\n", distanceToC);

        // Calculate the distances from the orthocenter to the sides
        double distanceToAB = Math.abs((y2 - y1) * orthocenterX - (x2 - x1) * orthocenterY + (x2 * y1 - y2 * x1)) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
        double distanceToBC = Math.abs((y3 - y2) * orthocenterX - (x3 - x2) * orthocenterY + (x3 * y2 - y3 * x2)) / Math.sqrt(Math.pow(y3 - y2, 2) + Math.pow(x3 - x2, 2));
        double distanceToCA = Math.abs((y1 - y3) * orthocenterX - (x1 - x3) * orthocenterY + (x1 * y3 - y1 * x3)) / Math.sqrt(Math.pow(y1 - y3, 2) + Math.pow(x1 - x3, 2));

        System.out.printf("Distance from orthocenter to side AB: %.2f\n", distanceToAB);
        System.out.printf("Distance from orthocenter to side BC: %.2f\n", distanceToBC);
        System.out.printf("Distance from orthocenter to side CA: %.2f\n", distanceToCA);

        scanner.close();
    }
}
