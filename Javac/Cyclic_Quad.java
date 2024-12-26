import java.util.Scanner;

public class Cyclic_Quad {
    public static void main(String[] args) {
        // Create a Scanner object to take input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter four Sides Of the Quadrilateral
        System.out.print("Enter the first side of the Quadrilateral: \n");
        double a = scanner.nextDouble();

        System.out.print("Enter the second side of the Quadrilateral: \n");
        double b = scanner.nextDouble();

        System.out.print("Enter the third side of the Quadrilateral: \n");
        double c = scanner.nextDouble();

        System.out.print("Enter the fourth side of the Quadrilateral: \n");
        double d = scanner.nextDouble();
        // finding the diagonals
        double d1 = Math.pow(((a*c+ b*d)*(a*d+b*c))/(a*b+c*d),0.5);
        double d2 = Math.pow(((a*b+ b*d)*(a*c+b*d))/(a*d+c*b),0.5);
       // Check If the Quadrilateral is Cyclic or not by Ptolemy's theorem
       if (d1*d2==((a*c)+(b*d))){
           System.out.print("The Given Quadrilateral is a Cyclic one");
           double s= a+b+c+d;
           //Finding CircumRadius
           double R= 0.25*Math.pow(((a*c+b*d)*(a*d+b*c)*(a*b+c*d))/((s-a)*(s-b)*(s-c)*(s-d)),0.5);
           System.out.printf("The CircumRadius of the Given Cyclic Quadrilateral is: %.2f\n", R);

       } else {
           System.out.print("The Given Quadrilateral is not a Cyclic One");
       }


        // Close the scanner
        scanner.close();
    }
}
