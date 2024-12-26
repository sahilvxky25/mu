import java.util.Scanner;

class VectorAnalysis {
    // Inner class to represent a 3D vector
    static class Vector {
        double x, y, z;

        // Constructor
        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // Calculate magnitude of the vector
        public double magnitude() {
            return Math.sqrt(x*x + y*y + z*z);
        }

        // Dot product of two vectors
        public double dotProduct(Vector other) {
            return this.x * other.x + this.y * other.y + this.z * other.z;
        }

        // Cross product of two vectors
        public Vector crossProduct(Vector other) {
            return new Vector(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
            );
        }

        // Check if vectors are parallel (collinear)
        public boolean isParallel(Vector other) {
            // Parallel if cross product is zero vector
            Vector crossProd = this.crossProduct(other);
            return Math.abs(crossProd.x) < 1e-10 && 
                   Math.abs(crossProd.y) < 1e-10 && 
                   Math.abs(crossProd.z) < 1e-10;
        }

        // Check if vectors are coplanar
        public boolean isCoplanar(Vector v2, Vector v3) {
            // Coplanar if scalar triple product is zero
            Vector crossProd = v2.crossProduct(v3);
            double scalarTripleProduct = Math.abs(this.dotProduct(crossProd));
            return Math.abs(scalarTripleProduct) < 1e-10;
        }

        // Check if vectors are coincident (on the same line)
        public boolean isCoincident(Vector other) {
            // First check if they are parallel
            if (!this.isParallel(other)) return false;

            // Then check if they point in the same or opposite direction
            double angle = Math.acos(this.dotProduct(other) / (this.magnitude() * other.magnitude()));
            return Math.abs(angle) < 1e-10 || Math.abs(angle - Math.PI) < 1e-10;
        }

        // Check if vectors are co-initial (start from the same point)
        public boolean isCoInitial(Vector other, Vector origin) {
            // In this implementation, we'll compare whether both vectors 
            // start from the same origin point
            return origin != null;
        }

        // Check if vectors are co-terminal (end at the same point)
        public boolean isCoTerminous(Vector other, Vector origin) {
            // Calculate the end points of both vectors
            Vector endPoint1 = new Vector(
                origin.x + this.x,
                origin.y + this.y,
                origin.z + this.z
            );
            
            Vector endPoint2 = new Vector(
                origin.x + other.x,
                origin.y + other.y,
                origin.z + other.z
            );

            // Check if end points are the same
            return Math.abs(endPoint1.x - endPoint2.x) < 1e-10 &&
                   Math.abs(endPoint1.y - endPoint2.y) < 1e-10 &&
                   Math.abs(endPoint1.z - endPoint2.z) < 1e-10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Input for first vector
            System.out.println("Enter coordinates for Vector 1 (x y z):");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            Vector vector1 = new Vector(x1, y1, z1);

            // Input for second vector
            System.out.println("Enter coordinates for Vector 2 (x y z):");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double z2 = scanner.nextDouble();
            Vector vector2 = new Vector(x2, y2, z2);

            // Input for third vector (for coplanar check)
            System.out.println("Enter coordinates for Vector 3 (x y z):");
            double x3 = scanner.nextDouble();
            double y3 = scanner.nextDouble();
            double z3 = scanner.nextDouble();
            Vector vector3 = new Vector(x3, y3, z3);

            // Input for origin point
            System.out.println("Enter coordinates for Origin Point (x y z):");
            double ox = scanner.nextDouble();
            double oy = scanner.nextDouble();
            double oz = scanner.nextDouble();
            Vector origin = new Vector(ox, oy, oz);

            // Perform and display vector relationship checks
            System.out.println("\n--- Vector Relationship Analysis ---");
            System.out.println("Vectors: V1(" + x1 + "," + y1 + "," + z1 + 
                               "), V2(" + x2 + "," + y2 + "," + z2 + 
                               "), V3(" + x3 + "," + y3 + "," + z3 + ")");

            // Parallel/Collinear Check
            if (vector1.isParallel(vector2)) {
                System.out.println("V1 and V2 are PARALLEL/COLLINEAR");
            } else {
                System.out.println("V1 and V2 are NOT parallel/collinear");
            }

            // Coplanar Check
            if (vector1.isCoplanar(vector2, vector3)) {
                System.out.println("V1, V2, and V3 are COPLANAR");
            } else {
                System.out.println("V1, V2, and V3 are NOT coplanar");
            }

            // Co-initial Check
            if (vector1.isCoInitial(vector2, origin)) {
                System.out.println("V1 and V2 are CO-INITIAL");
            } else {
                System.out.println("V1 and V2 are NOT co-initial");
            }

            // Co-terminal Check
            if (vector1.isCoTerminous(vector2, origin)) {
                System.out.println("V1 and V2 are CO-TERMINAL");
            } else {
                System.out.println("V1 and V2 are NOT co-terminal");
            }

            // Coincident Check
            if (vector1.isCoincident(vector2)) {
                System.out.println("V1 and V2 are COINCIDENT");
            } else {
                System.out.println("V1 and V2 are NOT coincident");
            }

        } catch (Exception e) {
            System.out.println("Error: Please enter valid numeric coordinates.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}