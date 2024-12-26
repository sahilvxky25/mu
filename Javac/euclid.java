public class GCD {
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a; // Base case
        }
        return gcd(b, a % b); // Recursive case
    }

    public static void main(String[] args) {
        System.out.println(gcd(56, 98)); // Output: 14
    }
}
