public class BinarySearch {
    public static int binarySearch(int[] arr, int target, int low, int high) {
        if (low > high) {
            return -1; // Base case: target not found
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == target) {
            return mid; // Base case: target found
        }
        if (arr[mid] > target) {
            return binarySearch(arr, target, low, mid - 1); // Recursive case: search left
        } else {
            return binarySearch(arr, target, mid + 1, high); // Recursive case: search right
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        System.out.println(binarySearch(arr, 7, 0, arr.length - 1)); // Output: 3
    }
}
