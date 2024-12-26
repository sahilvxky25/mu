import java.util.Scanner;

public class LineDivider3D {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double x,y,z;
        // Input coordinates of point A
        System.out.println("Enter the coordinates of point A (x1, y1, z1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double z1 = scanner.nextDouble();

        // Input coordinates of point B
        System.out.println("Enter the coordinates of point B (x2, y2, z2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        double z2 = scanner.nextDouble();

        // Input the ratio (m : n)
        System.out.println("Enter the ratio m:n in which the line should be divided:");
        double m = scanner.nextDouble();
        double n = scanner.nextDouble();

        // Check For What to do
        System.out.println("What do you want to do \n 1. Internal Division \n 2. External Division");
        int o = scanner.nextInt();
        switch(o) {
  case 1:
   // Calculate the coordinates of the point dividing the line segment
         x = (m * x2 + n * x1) / (m + n);
         y = (m * y2 + n * y1) / (m + n);
         z = (m * z2 + n * z1) / (m + n);
         // Display the result
         System.out.println("The coordinates of the point dividing the line segment in the ratio " + m + ":" + n + " are:");
         System.out.println("(" + x + ", " + y + ", " + z + ")");

    break;
  case 2:
   // Calculate the coordinates of the point dividing the line segment
         x = (m * x2 - n * x1) / (m - n);
         y = (m * y2 - n * y1) / (m - n);
         z = (m * z2 - n * z1) / (m - n);
         // Display the result
         System.out.println("The coordinates of the point dividing the line segment in the ratio " + m + ":" + n + " are:");
         System.out.println("(" + x + ", " + y + ", " + z + ")");

    break;
  default:
    System.out.println("Please Enter Valid Option");
}
        scanner.close();
    }
}
