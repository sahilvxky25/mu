import java.util.Scanner;

public class CountOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Enter the number to count: ");
        int target = scanner.nextInt();

        int result = countOccurrences(arr, size, target);
        System.out.println("The number " + target + " occurs " + result + " times in the array.");

        scanner.close();
    }

    public static int countOccurrences(int[] arr, int size, int target) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arr[i] == target) {
                count++;
            }
        }
        return count;
    }
}
