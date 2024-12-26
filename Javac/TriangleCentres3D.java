import java.util.Scanner;
import java.text.DecimalFormat;

class TriangleCenters3D {
    // Point class to represent 3D coordinates
    static class Point3D {
        double x, y, z;

        public Point3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // Calculate distance between two 3D points
        public double distanceTo(Point3D other) {
            return Math.sqrt(
                Math.pow(this.x - other.x, 2) + 
                Math.pow(this.y - other.y, 2) + 
                Math.pow(this.z - other.z, 2)
            );
        }

        // Vector subtraction
        public Point3D subtract(Point3D other) {
            return new Point3D(
                this.x - other.x,
                this.y - other.y,
                this.z - other.z
            );
        }

        // Vector cross product
        public Point3D crossProduct(Point3D other) {
            return new Point3D(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
            );
        }

        // Dot product
        public double dotProduct(Point3D other) {
            return this.x * other.x + 
                   this.y * other.y + 
                   this.z * other.z;
        }

        // Scalar multiplication
        public Point3D multiply(double scalar) {
            return new Point3D(
                this.x * scalar,
                this.y * scalar,
                this.z * scalar
            );
        }

        // Addition of vectors
        public Point3D add(Point3D other) {
            return new Point3D(
                this.x + other.x,
                this.y + other.y,
                this.z + other.z
            );
        }

        // Magnitude (length) of vector
        public double magnitude() {
            return Math.sqrt(x*x + y*y + z*z);
        }

        // String representation of point
        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("#.###");
            return "(" + df.format(x) + ", " + df.format(y) + ", " + df.format(z) + ")";
        }
    }

    // Calculate side lengths of the triangle
    public static double[] calculateSideLengths(Point3D a, Point3D b, Point3D c) {
        return new double[]{
            a.distanceTo(b),  // side between points a and b
            b.distanceTo(c),  // side between points b and c
            c.distanceTo(a)   // side between points c and a
        };
    }

    // Calculate area of triangle using cross product
    public static double calculateArea(Point3D a, Point3D b, Point3D c) {
        // Area = 1/2 * magnitude of cross product of two edges
        Point3D ab = b.subtract(a);
        Point3D ac = c.subtract(a);
        return ab.crossProduct(ac).magnitude() / 2;
    }

    // Calculate Incenter (center of inscribed circle)
    public static Point3D calculateIncenter(Point3D a, Point3D b, Point3D c) {
        // In 3D, this is more complex. We'll use the weighted average approach
        double[] sideLengths = calculateSideLengths(a, b, c);
        double perimeter = sideLengths[0] + sideLengths[1] + sideLengths[2];

        return new Point3D(
            (sideLengths[0] * c.x + sideLengths[1] * a.x + sideLengths[2] * b.x) / perimeter,
            (sideLengths[0] * c.y + sideLengths[1] * a.y + sideLengths[2] * b.y) / perimeter,
            (sideLengths[0] * c.z + sideLengths[1] * a.z + sideLengths[2] * b.z) / perimeter
        );
    }

    // Calculate Centroid
    public static Point3D calculateCentroid(Point3D a, Point3D b, Point3D c) {
        return new Point3D(
            (a.x + b.x + c.x) / 3,
            (a.y + b.y + c.y) / 3,
            (a.z + b.z + c.z) / 3
        );
    }

    // Calculate Circumcenter
    public static Point3D calculateCircumcenter(Point3D a, Point3D b, Point3D c) {
        // Calculation of circumcenter in 3D is more complex
        // We'll use the perpendicular bisector method
        Point3D midAB = new Point3D(
            (a.x + b.x) / 2,
            (a.y + b.y) / 2,
            (a.z + b.z) / 2
        );

        Point3D midBC = new Point3D(
            (b.x + c.x) / 2,
            (b.y + c.y) / 2,
            (b.z + c.z) / 2
        );

        // Normal vector to the plane of the triangle
        Point3D normal = b.subtract(a).crossProduct(c.subtract(a));

        // Vector from midpoint of AB to circumcenter
        Point3D toCircumcenter = normal.crossProduct(b.subtract(a));

        // Scale and add to midpoint
        double scale = calculateArea(a, b, c) / normal.magnitude();
        
        return midAB.add(toCircumcenter.multiply(scale / toCircumcenter.magnitude()));
    }

    // Calculate Orthocenter (more complex in 3D)
    public static Point3D calculateOrthocenter(Point3D a, Point3D b, Point3D c) {
        // In 3D, orthocenter is where altitudes intersect
        // We'll use the relationship with circumcenter and centroid
        Point3D circumcenter = calculateCircumcenter(a, b, c);
        Point3D centroid = calculateCentroid(a, b, c);

        // Orthocenter = 3 * Centroid - 2 * Circumcenter
        return new Point3D(
            3 * centroid.x - 2 * circumcenter.x,
            3 * centroid.y - 2 * circumcenter.y,
            3 * centroid.z - 2 * circumcenter.z
        );
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");

        try {
            // Input coordinates for three points
            Point3D[] points = new Point3D[3];
            
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter coordinates for Point " + (char)('A' + i) + " (x y z):");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double z = scanner.nextDouble();
                points[i] = new Point3D(x, y, z);
            }

            // Calculate and display triangle centers
            System.out.println("\n--- 3D Triangle Centers Calculation ---");
            
            // Incenter
            Point3D incenter = calculateIncenter(points[0], points[1], points[2]);
            System.out.println("Incenter: " + incenter);

            // Orthocenter
            Point3D orthocenter = calculateOrthocenter(points[0], points[1], points[2]);
            System.out.println("Orthocenter: " + orthocenter);

            // Circumcenter
            Point3D circumcenter = calculateCircumcenter(points[0], points[1], points[2]);
            System.out.println("Circumcenter: " + circumcenter);

            // Centroid
            Point3D centroid = calculateCentroid(points[0], points[1], points[2]);
            System.out.println("Centroid: " + centroid);

            // Optional: Additional triangle properties
            double[] sideLengths = calculateSideLengths(points[0], points[1], points[2]);
            double area = calculateArea(points[0], points[1], points[2]);

            System.out.println("\nTriangle Properties:");
            System.out.println("Side Lengths:");
            System.out.println("AB: " + df.format(sideLengths[0]));
            System.out.println("BC: " + df.format(sideLengths[1]));
            System.out.println("CA: " + df.format(sideLengths[2]));
            System.out.println("Surface Area: " + df.format(area));

        } catch (Exception e) {
            System.out.println("Error: Please enter valid numeric coordinates.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}