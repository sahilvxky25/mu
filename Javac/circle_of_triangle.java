import java.util.Scanner;

public class SOT {
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

        System.out.println("Enter the Angles of the three sides of the triangle:");
        System.out.print("Side A: ");
        double A = scanner.nextDouble();
        System.out.print("Side B: ");
        double B = scanner.nextDouble();
        System.out.print("Side C: ");
        double C = scanner.nextDouble();

        // Check if the sides form a valid triangle
        if (a + b > c && a + c > b && b + c > a) {
            // Calculate the semi-perimeter
            double s = (a + b + c) / 2;

            // Calculate the area using Heron's formula
            double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
            double r =  (a*b*c)/(4*area);
            // Output the result
            System.out.printf("The area of the triangle is: %.2f\n", area);
            System.out.printf("The CircumRadius of the triangle is: %.2f\n", (a*b*c)/(4*area));
            System.out.printf("The InRadius of the triangle is: %.2f\n", area/s);
            System.out.printf("The Radius of Escribed Circles of Triangle are: \n");
            System.out.printf("For Side a: %.2f\n", (area/s-a));
            System.out.printf("For Side b: %.2f\n", (area/s-b)); 
            System.out.printf("For Side c: %.2f\n", (area/s-c));
            // Ex-Central Triangle
            System.out.printf("The Length of Ex-Central Triangle of the Given Triangle are: \n");
            System.out.printf("For Side a: %.2f\n", 4*r*Math.cos(Math.toRadians(A/2)));
            System.out.printf("For Side b: %.2f\n", 4*r*Math.cos(Math.toRadians(B/2))); 
            System.out.printf("For Side c: %.2f\n", 4*r*Math.cos(Math.toRadians(C/2)));
            System.out.printf("The CircumRadius of the Ex-Central triangle is: %.2f\n", 2*r);
        } else {
            System.out.println("The given sides do not form a valid triangle.");
        }

        scanner.close();
    }
}
