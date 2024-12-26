import java.util.*;

public class CommonElementsWithCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input size and elements of the first array
        System.out.print("Enter size of the first array: ");
        int n1 = scanner.nextInt();
        System.out.println("Enter elements of the first array:");
        int[] array1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            array1[i] = scanner.nextInt();
        }

        // Input size and elements of the second array
        System.out.print("Enter size of the second array: ");
        int n2 = scanner.nextInt();
        System.out.println("Enter elements of the second array:");
        int[] array2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            array2[i] = scanner.nextInt();
        }

        // Find common elements with their counts
        Map<Integer, Integer> commonElements = findCommonElementsWithCount(array1, array2);

        // Print the common elements with their counts
        System.out.println("Common elements with their counts:");
        for (Map.Entry<Integer, Integer> entry : commonElements.entrySet()) {
            System.out.println("Element: " + entry.getKey() + ", Count: " + entry.getValue());
        }

        scanner.close();
    }

    public static Map<Integer, Integer> findCommonElementsWithCount(int[] array1, int[] array2) {
        Map<Integer, Integer> countMap1 = new HashMap<>();
        Map<Integer, Integer> countMap2 = new HashMap<>();
        Map<Integer, Integer> commonCount = new HashMap<>();

        // Count occurrences of each element in the first array
        for (int num : array1) {
            countMap1.put(num, countMap1.getOrDefault(num, 0) + 1);
        }

        // Count occurrences of each element in the second array
        for (int num : array2) {
            countMap2.put(num, countMap2.getOrDefault(num, 0) + 1);
        }

        // Find common elements and their counts
        for (Map.Entry<Integer, Integer> entry : countMap1.entrySet()) {
            int key = entry.getKey();
            if (countMap2.containsKey(key)) {
                // The count is the minimum of the two arrays' counts
                commonCount.put(key, Math.min(entry.getValue(), countMap2.get(key)));
            }
        }

        return commonCount;
    }
}
