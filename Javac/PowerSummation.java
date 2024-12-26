import java.util.Scanner;

public class PowerSummation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the number of terms (n):");
        int n = scanner.nextInt();
        
        // Variables to store the sums
        long sumSquares = 0, sumCubes = 0, sumFourthPowers = 0,sumFifth = 0,sumSixth = 0,sumSeventh = 0;
        
        System.out.println("Number\tSquare\tCube\tFourth\tfifth\tsixth\tseventh Power");
        for (int i = 1; i <= n; i++) {
            int square = (int) Math.pow(i, 2);
            int cube = (int) Math.pow(i, 3);
            int fourthPower = (int) Math.pow(i, 4);
            int fifthPower = (int) Math.pow(i, 5);
            int sixthPower = (int) Math.pow(i, 6);
            int seventhPower = (int) Math.pow(i, 7);
            // Calculate the sums
            sumSquares += square;
            sumCubes += cube;
            sumFourthPowers += fourthPower;
            sumFifth +=fifthPower;
            sumSixth += sixthPower;
            sumSeventh += seventhPower;
            
            System.out.println(i + "\t" + square + "\t" + cube + "\t" + fourthPower + "\t" + fifthPower + "\t" + sixthPower + "\t" + seventhPower);
        }
        
        // Print the sums
        System.out.println("Sum of squares: " + sumSquares);
        System.out.println("Sum of cubes: " + sumCubes);
        System.out.println("Sum of fourth powers: " + sumFourthPowers);
         System.out.println("Sum of fifth powers: " + sumFifth);
         System.out.println("Sum of sixth powers: " + sumSixth);
         System.out.println("Sum of seventh powers: " + sumSeventh);
        scanner.close();
    }
}
