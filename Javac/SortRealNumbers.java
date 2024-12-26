import java.util.Arrays;
import java.util.Scanner;

public class SortRealNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of real numbers:");
        int n = scanner.nextInt();
        double[] numbers = new double[n];

        System.out.println("Enter the real numbers:");
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextDouble();
        }

        Arrays.sort(numbers);

        System.out.println("The numbers in ascending order are:");
        for (double number : numbers) {
            System.out.println(number);
        }
    }
}
