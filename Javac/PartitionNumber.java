import java.util.Arrays;


public class PartitionNumber {

    // Function to print an array
    private static void printArray(int[] p, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(p[i] + " ");
        }
        System.out.println();
    }

    // Function to generate and count partitions
    private static int partitionNumber(int n) {
        int[] p = new int[n]; // An array to store a partition
        int k = 0; // Index of last element in a partition
        p[k] = n; // Initialize first partition as number itself
        int count = 0;

        while (true) {
            printArray(p, k + 1); // Print current partition
            count++; // Increment count for each partition

            // Find the rightmost non-one value in p[]
            int remaining_sum = 0;
            while (k >= 0 && p[k] == 1) {
                remaining_sum += p[k];
                k--;
            }

            // If there are no more partitions
            if (k < 0)
                return count;

            // Decrease the p[k] found above and adjust the remaining sum
            p[k]--;
            remaining_sum++;

            // Fill remaining sum with 1s
            while (remaining_sum > p[k]) {
                p[k + 1] = p[k];
                remaining_sum -= p[k];
                k++;
            }

            // Assign last remaining_sum to the next position
            p[k + 1] = remaining_sum;
            k++;
        }
    }

    public static void main(String[] args) {
        
        int n=10;
        
        // Change this value to partition another number
        int totalPartitions = partitionNumber(n);
        System.out.println("Total number of partitions of " + n + ": " + totalPartitions);
    }
}
