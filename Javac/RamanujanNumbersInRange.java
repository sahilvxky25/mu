import java.util.Scanner;

public class RamanujanNumbersInRange {
    public static void findRamanujanNumbersInRange(int start, int end) {
        for (int a = 1; a <= Math.cbrt(end); a++) {
            for (int b = a; b <= Math.cbrt(end); b++) {
                int sum1 = a * a * a + b * b * b;
                if (sum1 > end || sum1 < start)
                    continue;

                for (int c = a + 1; c <= Math.cbrt(end); c++) {
                    for (int d = c; d <= Math.cbrt(end); d++) {
                        int sum2 = c * c * c + d * d * d;
                        if (sum2 > end || sum2 < start)
                            continue;

                        if (sum1 == sum2) {
                            System.out.printf("%d = %d^3 + %d^3 = %d^3 + %d^3%n", sum1, a, b, c, d);
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the start of the range: ");
        int start = scanner.nextInt();

        System.out.print("Enter the end of the range: ");
        int end = scanner.nextInt();

        findRamanujanNumbersInRange(start, end);

        scanner.close();
    }
}
