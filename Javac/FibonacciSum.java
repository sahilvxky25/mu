import java.util.Scanner;

public class FibonacciSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the  First term ");
        long firstTerm = scanner.nextLong();
         System.out.println("Enter the Second term ");
        long secondTerm = scanner.nextLong();
         System.out.println("Enter the number of terms (n):");
        int n = scanner.nextInt();
        
        long sum = 0;
        
        
        for (int i = 1; i <= n; i++) {
            sum += firstTerm;
            long nextTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = nextTerm;
        }
        
        System.out.println("Sum of the first " + n + " terms of the Fibonacci sequence: " + sum);
        
        scanner.close();
    }
}
