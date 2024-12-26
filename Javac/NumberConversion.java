import java.util.Scanner;

public class NumberConversion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Convert Decimal to Binary, Hexadecimal, and Octal");
            System.out.println("2. Convert Binary to Decimal");
            System.out.println("3. Convert Hexadecimal to Decimal");
            System.out.println("4. Convert Octal to Decimal");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a decimal number: ");
                    int decimal = scanner.nextInt();
                    decimalToOtherSystems(decimal);
                    break;
                case 2:
                    System.out.print("Enter a binary number: ");
                    String binary = scanner.next();
                    binaryToDecimal(binary);
                    break;
                case 3:
                    System.out.print("Enter a hexadecimal number: ");
                    String hex = scanner.next();
                    hexadecimalToDecimal(hex);
                    break;
                case 4:
                    System.out.print("Enter an octal number: ");
                    String octal = scanner.next();
                    octalToDecimal(octal);
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void decimalToOtherSystems(int num) {
        System.out.println("Decimal: " + num);
        System.out.println("Binary: " + Integer.toBinaryString(num));
        System.out.println("Hexadecimal: " + Integer.toHexString(num));
        System.out.println("Octal: " + Integer.toOctalString(num));
    }

    private static void binaryToDecimal(String bin) {
        int decimal = Integer.parseInt(bin, 2);
        System.out.println("Binary: " + bin);
        System.out.println("Decimal: " + decimal);
    }

    private static void hexadecimalToDecimal(String hex) {
        int decimal = Integer.parseInt(hex, 16);
        System.out.println("Hexadecimal: " + hex);
        System.out.println("Decimal: " + decimal);
    }

    private static void octalToDecimal(String oct) {
        int decimal = Integer.parseInt(oct, 8);
        System.out.println("Octal: " + oct);
        System.out.println("Decimal: " + decimal);
    }
}
