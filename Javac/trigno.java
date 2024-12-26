import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an operation:");
        System.out.println("1. Sine");
        System.out.println("2. Cosine");
        System.out.println("3. Tangent");
        System.out.println("4. Inverse Sine");
        System.out.println("5. Inverse Cosine");
        System.out.println("6. Inverse Tangent");

        int choice = scanner.nextInt();

        if (choice >= 1 && choice <= 6) {
            System.out.print("Enter the value: ");
            double value = scanner.nextDouble();

            double result;

            switch (choice) {
                case 1:
                    result = Math.sin(Math.toRadians(value));
                    System.out.println("Sine of " + value + " degrees is: " + result);
                    break;
                case 2:
                    result = Math.cos(Math.toRadians(value));
                    System.out.println("Cosine of " + value + " degrees is: " + result);
                    break;
                case 3:
                    result = Math.tan(Math.toRadians(value));
                    System.out.println("Tangent of " + value + " degrees is: " + result);
                    break;
                case 4:
                    result = Math.toDegrees(Math.asin(value));
                    System.out.println("Inverse Sine of " + value + " is: " + result + " degrees");
                    break;
                case 5:
                    result = Math.toDegrees(Math.acos(value));
                    System.out.println("Inverse Cosine of " + value + " is: " + result + " degrees");
                    break;
                case 6:
                    result = Math.toDegrees(Math.atan(value));
                    System.out.println("Inverse Tangent of " + value + " is: " + result + " degrees");
                    break;
            }
        } else {
            System.out.println("Invalid choice.");
        }
    }
}