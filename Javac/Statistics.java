import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Statistics {

    // Method to calculate mean
    public static double calculateMean(int[] data) {
        int sum = 0;
        for (int num : data) {
            sum += num;
        }
        return (double) sum / data.length;
    }

    // Method to calculate median
    public static double calculateMedian(int[] data) {
        Arrays.sort(data);
        int middle = data.length / 2;
        if (data.length % 2 == 0) {
            return (data[middle - 1] + data[middle]) / 2.0;
        } else {
            return data[middle];
        }
    }

    // Method to calculate mode
    public static int calculateMode(int[] data) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int mode = data[0];
        int maxCount = 0;
        
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        
        return mode;
    }

    // Method to print the frequency of each entry
    public static void printFrequency(int[] data) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        System.out.println("Frequency of each entry:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] data = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        
        double mean = calculateMean(data);
        double median = calculateMedian(data);
        int mode = calculateMode(data);
        
        System.out.println("Mean: " + mean);
        System.out.println("Median: " + median);
        System.out.println("Mode: " + mode);

        printFrequency(data);
        
        scanner.close();
    }
}
