import java.util.Scanner;
import java.text.DecimalFormat;

class VectorAngleCalculator {
    // Point/Vector class to represent coordinates
    static class Vector {
        double x, y, z;

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // Calculate magnitude (length) of vector
        public double magnitude() {
            return Math.sqrt(x*x + y*y + z*z);
        }

        // Dot product calculation
        public double dotProduct(Vector other) {
            return this.x * other.x + 
                   this.y * other.y + 
                   this.z * other.z;
        }

        // Method 1: Angle calculation using dot product formula
        public double angleBetweenVectorsDotProduct(Vector other) {
            // Angle = arccos((a · b) / (|a| * |b|))
            double dotProduct = this.dotProduct(other);
            double magnitudeProduct = this.magnitude() * other.magnitude();
            
            // Handle potential floating-point precision issues
            double cosTheta = dotProduct / magnitudeProduct;
            cosTheta = Math.max(-1.0, Math.min(1.0, cosTheta));
            
            // Convert to degrees
            return Math.toDegrees(Math.acos(cosTheta));
        }

        // Method 2: Angle calculation using cross product magnitude
        public double angleBetweenVectorsCrossProduct(Vector other) {
            // Angle = arcsin(|a × b| / (|a| * |b|))
            Vector crossProduct = this.crossProduct(other);
            double crossProductMagnitude = crossProduct.magnitude();
            double magnitudeProduct = this.magnitude() * other.magnitude();
            
            // Handle potential floating-point precision issues
            double sinTheta = crossProductMagnitude / magnitudeProduct;
            sinTheta = Math.max(-1.0, Math.min(1.0, sinTheta));
            
            // Convert to degrees
            return Math.toDegrees(Math.asin(sinTheta));
        }

        // Cross product calculation
        public Vector crossProduct(Vector other) {
            return new Vector(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
            );
        }

        // String representation of vector
        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("#.###");
            return "(" + df.format(x) + ", " + df.format(y) + ", " + df.format(z) + ")";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.###");

        try {
            // Input first vector coordinates
            System.out.println("Enter coordinates for Vector 1 (x y z):");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            Vector vector1 = new Vector(x1, y1, z1);

            // Input second vector coordinates
            System.out.println("Enter coordinates for Vector 2 (x y z):");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double z2 = scanner.nextDouble();
            Vector vector2 = new Vector(x2, y2, z2);

            // Display vector information
            System.out.println("\n--- Vector Angle Analysis ---");
            System.out.println("Vector 1: " + vector1);
            System.out.println("Vector 2: " + vector2);

            // Calculate and display vector magnitudes
            System.out.println("\nVector Magnitudes:");
            System.out.println("Vector 1 Magnitude: " + df.format(vector1.magnitude()));
            System.out.println("Vector 2 Magnitude: " + df.format(vector2.magnitude()));

            // Calculate angles using different methods
            System.out.println("\nAngle Calculation Methods:");
            
            // Method 1: Dot Product Approach
            double angleDotProduct = vector1.angleBetweenVectorsDotProduct(vector2);
            System.out.println("Angle (Dot Product Method): " + 
                               df.format(angleDotProduct) + " degrees");

            // Method 2: Cross Product Approach
            double angleCrossProduct = vector1.angleBetweenVectorsCrossProduct(vector2);
            System.out.println("Angle (Cross Product Method): " + 
                               df.format(angleCrossProduct) + " degrees");

            // Dot Product
            double dotProduct = vector1.dotProduct(vector2);
            System.out.println("\nDot Product: " + df.format(dotProduct));

        } catch (Exception e) {
            System.out.println("Error: Please enter valid numeric coordinates.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}