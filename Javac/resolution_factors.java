import java.util.Scanner;

public class QuadraticInTwoVariables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input coefficients for the quadratic equation in two variables
        System.out.println("For the quadratic equation ax^2 + bxy + cy^2 + dx + ey + f = 0:");
        System.out.print("Enter coefficient a (x^2 term): ");
        double a = scanner.nextDouble();
        System.out.print("Enter coefficient b (xy term): ");
        double h = scanner.nextDouble();
        h=h/2;
        System.out.print("Enter coefficient c (y^2 term): ");
        double b = scanner.nextDouble();
        System.out.print("Enter coefficient d (x term): ");
        double g = scanner.nextDouble();
        g=g/2;
        System.out.print("Enter coefficient e (y term): ");
        double f = scanner.nextDouble();
        f=f/2;
        System.out.print("Enter coefficient f (constant term): ");
        double c = scanner.nextDouble();

        // Calculate the discriminant
        double discriminant = (a*b*c)+(2*f*g*h)-(a*f*f)-(b*g*g)-(c*h*h);

        // Check the condition for resolution into linear factors
        if (discriminant == 0) {
            System.out.println("The equation can be resolved into linear factors (represents a pair of lines).");
        } else {
            System.out.println("The equation cannot be resolved into linear factors (does not represent a pair of lines).");
        }

        scanner.close();
    }
}
