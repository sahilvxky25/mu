import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index for Fibonacci series: ");
        int n = scanner.nextInt();
        scanner.close();
        
        System.out.println("Fibonacci number at index " + n + " is: " + fibonacci(n));
    }
    
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        
        int a = 0, b = 1, fib = 1;
        for (int i = 2; i <= n; i++) {
            fib = a + b;
            a = b;
            b = fib;
        }
        
        return fib;
    }
}