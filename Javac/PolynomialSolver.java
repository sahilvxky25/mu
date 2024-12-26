import java.util.Scanner;

public class PolynomialSolver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the degree of the polynomial:");
        int degree = scanner.nextInt();

        Complex[] coefficients = new Complex[degree + 1];
        System.out.println("Enter the coefficients (real and imaginary parts) from highest degree to constant term:");
        for (int i = degree; i >= 0; i--) {
            System.out.print("Coefficient for x^" + i + " (real part): ");
            double realPart = scanner.nextDouble();
            System.out.print("Coefficient for x^" + i + " (imaginary part): ");
            double imaginaryPart = scanner.nextDouble();
            coefficients[i] = new Complex(realPart, imaginaryPart);
        }

        Complex[] roots = findRoots(coefficients);
        System.out.println("The roots of the polynomial are:");
        for (Complex root : roots) {
            System.out.println(root);
        }
    }

    public static Complex[] findRoots(Complex[] coefficients) {
        int degree = coefficients.length - 1;
        Complex[] roots = new Complex[degree];
        Complex[] newRoots = new Complex[degree];

        // Initialize roots with some starting values
        for (int i = 0; i < degree; i++) {
            roots[i] = new Complex(Math.cos(2 * Math.PI * i / degree), Math.sin(2 * Math.PI * i / degree));
        }

        double tolerance = 1e-7;
        int maxIterations = 1000;

        for (int iteration = 0; iteration < maxIterations; iteration++) {
            boolean converged = true;

            for (int i = 0; i < degree; i++) {
                Complex numerator = evaluatePolynomial(coefficients, roots[i]);
                Complex denominator = new Complex(1, 0);

                for (int j = 0; j < degree; j++) {
                    if (i != j) {
                        denominator = denominator.multiply(roots[i].subtract(roots[j]));
                    }
                }

                newRoots[i] = roots[i].subtract(numerator.divide(denominator));
                if (roots[i].subtract(newRoots[i]).abs().greaterThan(new Complex(tolerance, tolerance))) {
                    converged = false;
                }
            }

            if (converged) {
                break;
            }

            System.arraycopy(newRoots, 0, roots, 0, degree);
        }

        return roots;
    }

    public static Complex evaluatePolynomial(Complex[] coefficients, Complex x) {
        Complex result = new Complex(0, 0);
        for (int i = 0; i < coefficients.length; i++) {
            result = result.add(coefficients[i].multiply(x.pow(i)));
        }
        return result;
    }
}

class Complex {
    private final double real;
    private final double imaginary;

    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    public Complex subtract(Complex other) {
        return new Complex(this.real - other.real, this.imaginary - other.imaginary);
    }

    public Complex multiply(Complex other) {
        double realPart = this.real * other.real - this.imaginary * other.imaginary;
        double imaginaryPart = this.real * other.imaginary + this.imaginary * other.real;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex divide(Complex other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary;
        double realPart = (this.real * other.real + this.imaginary * other.imaginary) / denominator;
        double imaginaryPart = (this.imaginary * other.real - this.real * other.imaginary) / denominator;
        return new Complex(realPart, imaginaryPart);
    }

    public Complex pow(int exponent) {
        Complex result = new Complex(1, 0);
        for (int i = 0; i < exponent; i++) {
            result = result.multiply(this);
        }
        return result;
    }

    public Complex abs() {
        return new Complex(Math.sqrt(this.real * this.real + this.imaginary * this.imaginary), 0);
    }

    public boolean greaterThan(Complex other) {
        return this.real > other.real || this.imaginary > other.imaginary;
    }

    @Override
    public String toString() {
        return String.format("%f + %fi", real, imaginary);
    }
}
