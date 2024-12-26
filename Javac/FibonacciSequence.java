import java.util.Scanner;

public class FibonacciSequence {
    public static void printFibonacci(int n) {
        int t1 = 0, t2 = 1, nextTerm;

        System.out.print("Fibonacci Sequence: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(t1 + " ");
            nextTerm = t1 + t2;
            t1 = t2;
            t2 = nextTerm;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of terms: ");
        int n = scanner.nextInt();

        printFibonacci(n);

        scanner.close();
    }
}
