public class PalindromeGenerator {
    public static void generatePalindromes(String str, String result) {
        if (str.isEmpty()) {
            if (isPalindrome(result)) {
                System.out.println(result); // Print if it's a palindrome
            }
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            generatePalindromes(str.substring(0, i) + str.substring(i + 1), result + str.charAt(i));
        }
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        generatePalindromes("asas", ""); // Output: all palindromes formed
    }
}
