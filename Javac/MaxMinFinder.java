import java.util.Scanner;

public class MaxMinFinder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String choice;

        while (true) {
            System.out.print("Enter a number: ");
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num > max) {
                    max = num;
                }
                if (num < min) {
                    min = num;
                }
            } else {
                break;
            }

            System.out.print("Do you want to enter another number? (y/n): ");
            choice = scanner.next();
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }

        if (max == Integer.MIN_VALUE || min == Integer.MAX_VALUE) {
            System.out.println("No valid numbers were entered.");
        } else {
            System.out.println("The maximum number is: " + max);
            System.out.println("The minimum number is: " + min);
        }

        scanner.close();
    }
}
