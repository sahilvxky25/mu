import java.util.Scanner;

public class ExcenterCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input coordinates of the triangle vertices
        System.out.println("Enter the coordinates of vertex A (x1 y1): ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();

        System.out.println("Enter the coordinates of vertex B (x2 y2): ");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.println("Enter the coordinates of vertex C (x3 y3): ");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        // Calculate side lengths
        double a = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2)); // Side opposite A
        double b = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2)); // Side opposite B
        double c = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)); // Side opposite C

        // Calculate excenter opposite to vertex A
        double xExcenterA = (a * x1 + b * x2 + c * x3) / (a + b + c);
        double yExcenterA = (a * y1 + b * y2 + c * y3) / (a + b + c);

        System.out.printf("Excenter opposite to vertex A: (%.2f, %.2f)%n", xExcenterA, yExcenterA);

        // Calculate excenter opposite to vertex B
        double xExcenterB = (-a * x1 + b * x2 + c * x3) / (-a + b + c);
        double yExcenterB = (-a * y1 + b * y2 + c * y3) / (-a + b + c);

        System.out.printf("Excenter opposite to vertex B: (%.2f, %.2f)%n", xExcenterB, yExcenterB);

        // Calculate excenter opposite to vertex C
        double xExcenterC = (a * x1 - b * x2 + c * x3) / (a - b + c);
        double yExcenterC = (a * y1 - b * y2 + c * y3) / (a - b + c);

        System.out.printf("Excenter opposite to vertex C: (%.2f, %.2f)%n", xExcenterC, yExcenterC);

        scanner.close();
    }
}
