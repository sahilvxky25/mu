import java.util.Scanner;

public class TempConversion {
    public static void main(String[] args)
    {
        System.out.println("Hello User");
        double f;
        int e;
        System.out.println("What would you wish to do");
        System.out.println("Enter 1 to convert Temperature in Celsius to Fahrenheit");
        System.out.println("Enter 2 to convert temperature in Fahrenheit to Celsius");
        System.out.println("Enter 3 to convert Temperature in Celsius to Kelvin");
        System.out.println("Enter 4 to convert Temperature in Kelvin to Celsius");
        Scanner scan = new Scanner(System.in);
        e = scan.nextInt();
        switch(e)
        {
            case 1:
                System.out.println("Enter the temperature in Celsius");
                f = scan.nextDouble();
                f = f*9;
                f = f/5;
                f = f+32;
                System.out.print("The temperature in fahrenheit is " +f);
                break;
            case 2:
                System.out.println("Enter the temperature in Fahrenheit");
            f = scan.nextDouble();
            f = f-32;
            f = f*5;
            f = f/9;
                System.out.print("The Temperature in Celsius is " +f);
                break;
            case 3:
                System.out.println("Enter the temperature in Celsius");
                f = scan.nextDouble();
                f = f+273.15;
                System.out.print("The temperature in Kelvin is " +f);
                break;
            case 4:
                System.out.println("Enter the temperature in Kelvin");
                f = scan.nextDouble();
                f = f-273.15;
                System.out.print("The temperature in Celsius is " +f);
                break;
            default:
                System.out.print("The Entered value is not valid");
        }
    }
}