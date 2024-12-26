public class PascalTriangle {

    public static void main(String[] args) {
        int n = 10; // Number of rows
        printPascalTriangle(n);
    }

    public static void printPascalTriangle(int n) {
        for (int line = 0; line < n; line++) {
            for (int j = 0; j <= line; j++) {
                System.out.print(binomialCoefficient(line, j) + " ");
            }
            System.out.println();
        }
    }

    public static int binomialCoefficient(int n, int k) {
        int res = 1;
        if (k > n - k) {
            k = n - k;
        }
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }
        return res;
    }
}
