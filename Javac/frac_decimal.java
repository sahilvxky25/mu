import java.math.BigInteger;
import java.util.Scanner;

public class DecimalFractionConverter {
    /**
     * Converts a decimal number to a fraction by finding the most precise rational approximation.
     * Uses continued fraction algorithm to handle both terminating and repeating decimals.
     * 
     * @param decimal The decimal number to convert
     * @param precision Maximum denominator value to limit fraction complexity
     * @return Fraction representation of the decimal
     */
    public static Fraction decimalToFraction(double decimal, int precision) {
        // Handle special cases first
        if (decimal == 0) return new Fraction(0, 1);
        if (decimal == (int)decimal) return new Fraction((int)decimal, 1);
        
        // Determine if decimal is positive
        int sign = decimal < 0 ? -1 : 1;
        decimal = Math.abs(decimal);
        
        // Initial values for continued fraction algorithm
        long m00 = 1, m01 = 0, m10 = 0, m11 = 1;
        double x = decimal;
        long q;
        
        while (m01 * (q = (long)x) + m11 <= precision) {
            double temp = x - q;
            long m00_next = q * m00 + m01;
            long m01_next = m00;
            long m10_next = q * m10 + m11;
            long m11_next = m10;
            
            m00 = m00_next;
            m01 = m01_next;
            m10 = m10_next;
            m11 = m11_next;
            
            if (temp == 0) break;
            x = 1.0 / temp;
        }
        
        return new Fraction(sign * m00, m10);
    }
    
    /**
     * Converts a fraction to its decimal representation.
     * 
     * @param numerator Numerator of the fraction
     * @param denominator Denominator of the fraction
     * @return Decimal value of the fraction
     */
    public static double fractionToDecimal(int numerator, int denominator) {
        return (double) numerator / denominator;
    }
    
    /**
     * Custom Fraction class to represent rational numbers with simplification
     */
    public static class Fraction {
        private long numerator;
        private long denominator;
        
        public Fraction(long numerator, long denominator) {
            // Prevent division by zero
            if (denominator == 0) {
                throw new IllegalArgumentException("Denominator cannot be zero");
            }
            
            // Ensure negative sign is always on numerator
            long gcd = gcd(Math.abs(numerator), Math.abs(denominator));
            this.numerator = numerator / gcd;
            this.denominator = denominator / gcd;
            
            // Handle negative fractions
            if (this.denominator < 0) {
                this.numerator = -this.numerator;
                this.denominator = -this.denominator;
            }
        }
        
        /**
         * Greatest Common Divisor using Euclidean algorithm
         */
        private long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }
        
        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
        
        // Getters
        public long getNumerator() { return numerator; }
        public long getDenominator() { return denominator; }
    }
    
    /**
     * Interactive console-based demonstration of conversion methods
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nDecimal-Fraction Converter");
            System.out.println("1. Decimal to Fraction");
            System.out.println("2. Fraction to Decimal");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter decimal number: ");
                    double decimal = scanner.nextDouble();
                    Fraction fraction = decimalToFraction(decimal, 1000);
                    System.out.println("Fraction: " + fraction);
                    break;
                
                case 2:
                    System.out.print("Enter numerator: ");
                    int numerator = scanner.nextInt();
                    System.out.print("Enter denominator: ");
                    int denominator = scanner.nextInt();
                    double result = fractionToDecimal(numerator, denominator);
                    System.out.println("Decimal: " + result);
                    break;
                
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                
                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}