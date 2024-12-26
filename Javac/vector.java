import java.util.Scanner;

public class VectorOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input for the first vector
        System.out.println("Enter the components of the first vector:");
        System.out.print("x1: ");
        double x1 = scanner.nextDouble();
        System.out.print("y1: ");
        double y1 = scanner.nextDouble();
        System.out.print("z1: ");
        double z1 = scanner.nextDouble();

        // Input for the second vector
        System.out.println("Enter the components of the second vector:");
        System.out.print("x2: ");
        double x2 = scanner.nextDouble();
        System.out.print("y2: ");
        double y2 = scanner.nextDouble();
        System.out.print("z2: ");
        double z2 = scanner.nextDouble();

        // Create the vectors
        Vector3D v1 = new Vector3D(x1, y1, z1);
        Vector3D v2 = new Vector3D(x2, y2, z2);

        // Perform operations
        Vector3D sum = v1.add(v2);
        Vector3D difference = v1.subtract(v2);
        double dotProduct = v1.dotProduct(v2);
        Vector3D crossProduct = v1.crossProduct(v2);

        // Print the results
        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Dot Product: " + dotProduct);
        System.out.println("Cross Product: " + crossProduct);
    }

    static class Vector3D {
        double x, y, z;

        public Vector3D(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        public Vector3D add(Vector3D other) {
            return new Vector3D(this.x + other.x, this.y + other.y, this.z + other.z);
        }

        public Vector3D subtract(Vector3D other) {
            return new Vector3D(this.x - other.x, this.y - other.y, this.z - other.z);
        }

        public double dotProduct(Vector3D other) {
            return this.x * other.x + this.y * other.y + this.z * other.z;
        }

        public Vector3D crossProduct(Vector3D other) {
            return new Vector3D(
                    this.y * other.z - this.z * other.y,
                    this.z * other.x - this.x * other.z,
                    this.x * other.y - this.y * other.x
            );
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ", " + z + ")";
        }
    }
}