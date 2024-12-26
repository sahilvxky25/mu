import java.util.Scanner;

public class Subsets {
    // Variable to keep track of the number of subsets
    static int subsetCount = 0;

    public static void printSubsets(String str, String result, int index) {
        if (index == str.length()) {
            System.out.println(result); // Print current subset
            subsetCount++; // Increment the count of subsets
            return;
        }
        // Include current character
        printSubsets(str, result + str.charAt(index), index + 1);
        // Exclude current character
        printSubsets(str, result, index + 1);
    }

    public static void main(String[] args) {
        // Create a scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a string: ");
        String inputString = scanner.nextLine();

        // Call the recursive method to print all subsets
        printSubsets(inputString, "", 0); // Output: all subsets of the user-input string

        // Print the count of subsets
        System.out.println("Total number of subsets: " + subsetCount);

        // Close the scanner
        scanner.close();
    }
}
