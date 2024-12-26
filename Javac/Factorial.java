import java.util.Scanner;
public class Factorial {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double a;
    System.out.println("Enter the number for which you want to Find the Factorial");
    a = scan.nextDouble();
    double b=1;
    double i=1;
    while(i<=a)
    { b=b*i;
    i++;
    
      }
      System.out.println("The Factorial of the Number is " +b);
      }
}