public class CubicEquationSolver {

    public static void main(String[] args) {
        double a = 1, b = -23, c = 142, d = -120; // Example coefficients
        solveCubicEquation(a, b, c, d);
    }

    public static void solveCubicEquation(double a, double b, double c, double d) {
        if (a == 0) {
            System.out.println("Not a cubic equation.");
            return;
        }

        double f = ((3 * c / a) - (b * b / (a * a))) / 3;
        double g = ((2 * b * b * b / (a * a * a)) - (9 * b * c / (a * a)) + (27 * d / a)) / 27;
        double h = (g * g / 4) + (f * f * f / 27);

        if (h > 0) {
            System.out.println("One real root and two complex roots.");
        } else if (f == 0 && g == 0 && h == 0) {
            double x = -Math.cbrt(d / a);
            System.out.println("All roots are real and equal: x = " + x);
        } else {
            double i = Math.sqrt((g * g / 4) - h);
            double j = Math.cbrt(i);
            double k = Math.acos(-g / (2 * i));
            double l = -j;
            double m = Math.cos(k / 3);
            double n = Math.sqrt(3) * Math.sin(k / 3);
            double p = -b / (3 * a);

            double x1 = 2 * j * Math.cos(k / 3) - b / (3 * a);
            double x2 = l * (m + n) + p;
            double x3 = l * (m - n) + p;

            System.out.println("All roots are real:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
            System.out.println("x3 = " + x3);
        }
    }
}
