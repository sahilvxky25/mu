import java.util.Scanner;

public class ScaleneTrianglePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input for the three sides of the triangle
        System.out.print("Enter the length of the first side: ");
        int side1 = scanner.nextInt();
        
        System.out.print("Enter the length of the second side: ");
        int side2 = scanner.nextInt();
        
        System.out.print("Enter the length of the third side: ");
        int side3 = scanner.nextInt();
        
        // Sort sides to determine the maximum size for rows
        int[] sides = {side1, side2, side3};
        java.util.Arrays.sort(sides);  // Sort in ascending order
        
        int maxSide = sides[2]; // The largest side determines the height of the triangle
        
        // Print the triangle based on the side lengths
        for (int i = 1; i <= maxSide; i++) {
            // Print spaces for alignment (to form the scalene shape)
            for (int j = 0; j < maxSide - i; j++) {
                System.out.print(" ");
            }
            
            // Determine how many stars to print based on the row number and side lengths
            if (i <= side1) {
                System.out.print("*");
            }
            if (i <= side2) {
                System.out.print("*");
            }
            if (i <= side3) {
                System.out.print("*");
            }
            
            // Move to the next line
            System.out.println();
        }
        
        scanner.close();
    }
}
