import java.util.Scanner;

public class HCFCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of integers:");
        int n = scanner.nextInt();
        int[] numbers = new int[n];

        System.out.println("Enter the integers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int hcf = findHCF(numbers);
        System.out.println("The HCF of the given numbers is: " + hcf);
    }

    public static int findHCF(int[] numbers) {
        int hcf = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            hcf = gcd(hcf, numbers[i]);
        }
        return hcf;
    }

    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
