import java.util.Scanner;

public class TriangleMediansAndAngles {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for the lengths of the sides of the triangle
        System.out.println("Enter the lengths of the sides of the triangle:");

        System.out.print("Enter the length of side a (opposite to vertex A): ");
        double a = scanner.nextDouble();

        System.out.print("Enter the length of side b (opposite to vertex B): ");
        double b = scanner.nextDouble();

        System.out.print("Enter the length of side c (opposite to vertex C): ");
        double c = scanner.nextDouble();

        // Calculate the lengths of the medians using the formula
        double m_a = medianLength(b, c, a); // Median from vertex A
        double m_b = medianLength(a, c, b); // Median from vertex B
        double m_c = medianLength(a, b, c); // Median from vertex C

        // Calculate the angles between the medians and the sides
        double angleA = angleBetweenMediansAndSide(a, b, c, m_a); // Angle for median from A
        double angleB = angleBetweenMediansAndSide(b, c, a, m_b); // Angle for median from B
        double angleC = angleBetweenMediansAndSide(c, a, b, m_c); // Angle for median from C

        // Output the results
        System.out.println("\nMedians Lengths:");
        System.out.println("Length of median from A: " + m_a);
        System.out.println("Length of median from B: " + m_b);
        System.out.println("Length of median from C: " + m_c);

        System.out.println("\nAngles between medians and sides (in degrees):");
        System.out.println("Angle between median from A and side BC: " + Math.toDegrees(angleA));
        System.out.println("Angle between median from B and side AC: " + Math.toDegrees(angleB));
        System.out.println("Angle between median from C and side AB: " + Math.toDegrees(angleC));

        scanner.close();
    }

    // Method to calculate the length of the median using the side lengths
    public static double medianLength(double b, double c, double a) {
        return Math.sqrt((2 * Math.pow(b, 2) + 2 * Math.pow(c, 2) - Math.pow(a, 2)) / 4);
    }

    // Method to calculate the angle between the median and the side using dot product
    public static double angleBetweenMediansAndSide(double a, double b, double c, double medianLength) {
        // Using the cosine rule to calculate the angle between the median and side
        double numerator = b * b + c * c - a * a;
        double denominator = 2 * b * c;
        double cosTheta = numerator / denominator;

        // Calculate the angle in radians
        double angle = Math.acos(cosTheta);

        return angle;
    }
}
