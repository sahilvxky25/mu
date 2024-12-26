import java.util.Scanner;

public class AGPSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for AGP
        System.out.println("Enter the first term of AP (a) and common difference of AP (d):");
        double a = scanner.nextDouble();
        double d = scanner.nextDouble();
        System.out.println("Enter the first term of GP (b) and common ratio of GP (r):");
        double b = scanner.nextDouble();
        double r = scanner.nextDouble();
        System.out.println("Enter the number of terms (n):");
        int n = scanner.nextInt();
        
        double agpSum = 0;
        for (int i = 0; i < n; i++) {
            agpSum += (a + i * d) * b * Math.pow(r, i);
        }
        
        System.out.println("Sum of first " + n + " terms of AGP: " + agpSum);
        
        scanner.close();
    }
}
