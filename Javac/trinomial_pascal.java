// Java Program to print trinomial triangle.
import java.util.*;
import java.lang.*;
  
public class GfG {
  
    // Function to find the trinomial
    // triangle value.
    public static int TrinomialValue(int n, 
                                     int k)
    {
        // base case
        if (n == 0 && k == 0)
            return 1;
  
        // base case
        if (k < -n || k > n)
            return 0;
  
        // recursive step.
        return TrinomialValue(n - 1, k - 1)
            + TrinomialValue(n - 1, k)
            + TrinomialValue(n - 1, k + 1);
    }
  
    // Function to print Trinomial 
    // Triangle of height n.
    public static void printTrinomial(int n)
    {
        // printing n rows.
        for (int i = 0; i < n; i++) 
        {
            // printing first half of triangle
            for (int j = -i; j <= 0; j++)
                System.out.print(TrinomialValue(i, j) 
                                    + " ");
  
            // printing second half of triangle.
            for (int j = 1; j <= i; j++)
                System.out.print(TrinomialValue(i, j) 
                                  + " ");
  
            System.out.println();
        }
    }
  
    // driver function
    public static void main(String argc[])
    {
        int n = 6;
  
        printTrinomial(n);
    }
  
}