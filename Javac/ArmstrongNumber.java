import java.util.*;
public class ArmstrongNumber {
    // Function to check if a number is an Armstrong number
    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int sum = 0;
        int numberOfDigits = String.valueOf(num).length();

        while (num != 0) {
            int remainder = num % 10;
            sum += Math.pow(remainder, numberOfDigits);
            num /= 10;
        }

        return sum == originalNum;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lowerlimit , upperlimit;// Change this to any number to find Armstrong numbers less than it
        System.out.println("Enter The Lower Bound");
        lowerlimit = scan.nextInt();
         System.out.println("Enter The Upper Bound");
        upperlimit = scan.nextInt();
        int count = 0;
        System.out.println("The Armstrong Numbers are");

        for (int i = lowerlimit; i <= upperlimit; i++) {
            if (isArmstrong(i)) {
                System.out.println(i);
                count++;
            }
        }
         System.out.println("The Number of Armstrong Number Within The Specified Range is " + count);
        
    }
}
