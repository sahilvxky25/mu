import java.util.Scanner;
import java.text.DecimalFormat;

class ReciprocalVectorSystem {
    // Vector class to represent 3D vectors
    static class Vector {
        double x, y, z;

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // Cross product calculation
        public Vector crossProduct(Vector other) {
            return new Vector(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
            );
        }

        // Dot product calculation
        public double dotProduct(Vector other) {
            return this.x * other.x + 
                   this.y * other.y + 
                   this.z * other.z;
        }

        // Calculate magnitude (length) of vector
        public double magnitude() {
            return Math.sqrt(x*x + y*y + z*z);
        }

        // Scalar multiplication
        public Vector multiply(double scalar) {
            return new Vector(
                this.x * scalar,
                this.y * scalar,
                this.z * scalar
            );
        }

        // String representation of vector
        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("#.####");
            return "(" + df.format(x) + ", " + df.format(y) + ", " + df.format(z) + ")";
        }
    }

    // Calculate reciprocal vectors
    public static Vector[] calculateReciprocalVectors(Vector a, Vector b, Vector c) {
        // Step 1: Calculate the volume of the original unit cell
        Vector volumeVector = a.crossProduct(b);
        double volume = Math.abs(volumeVector.dotProduct(c));

        // Step 2: Calculate reciprocal lattice vectors
        // a* = (b × c) / V
        // b* = (c × a) / V
        // c* = (a × b) / V
        Vector reciprocalA = b.crossProduct(c).multiply(2 * Math.PI / volume);
        Vector reciprocalB = c.crossProduct(a).multiply(2 * Math.PI / volume);
        Vector reciprocalC = a.crossProduct(b).multiply(2 * Math.PI / volume);

        return new Vector[]{reciprocalA, reciprocalB, reciprocalC};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");

        try {
            // Input original basis vectors
            Vector[] originalVectors = new Vector[3];
            
            for (int i = 0; i < 3; i++) {
                System.out.println("Enter coordinates for Vector " + (char)('A' + i) + " (x y z):");
                double x = scanner.nextDouble();
                double y = scanner.nextDouble();
                double z = scanner.nextDouble();
                originalVectors[i] = new Vector(x, y, z);
            }

            // Calculate reciprocal vectors
            Vector[] reciprocalVectors = calculateReciprocalVectors(
                originalVectors[0], 
                originalVectors[1], 
                originalVectors[2]
            );

            // Display results
            System.out.println("\n--- Reciprocal Vector System ---");
            
            // Original Vectors
            System.out.println("Original Vectors:");
            for (int i = 0; i < 3; i++) {
                System.out.println("Vector " + (char)('A' + i) + ": " + originalVectors[i]);
            }

            // Reciprocal Vectors
            System.out.println("\nReciprocal Vectors:");
            for (int i = 0; i < 3; i++) {
                System.out.println("Reciprocal Vector " + (char)('A' + i) + "*: " + reciprocalVectors[i]);
            }

            // Verification: Dot product checks
            System.out.println("\nVerification (Dot Product Checks):");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    double dotProduct = originalVectors[i].dotProduct(reciprocalVectors[j]);
                    System.out.println("Vector " + (char)('A' + i) + " · Vector " + 
                                       (char)('A' + j) + "*: " + df.format(dotProduct));
                }
            }

        } catch (Exception e) {
            System.out.println("Error: Please enter valid numeric coordinates.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}