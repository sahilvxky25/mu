import java.util.Scanner;
import java.text.DecimalFormat;

class ShortestLineDistance {
    // Vector class to represent 3D vectors
    static class Vector {
        double x, y, z;

        public Vector(double x, double y, double z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        // Vector subtraction
        public Vector subtract(Vector other) {
            return new Vector(
                this.x - other.x,
                this.y - other.y,
                this.z - other.z
            );
        }

        // Dot product calculation
        public double dotProduct(Vector other) {
            return this.x * other.x + 
                   this.y * other.y + 
                   this.z * other.z;
        }

        // Cross product calculation
        public Vector crossProduct(Vector other) {
            return new Vector(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
            );
        }

        // Calculate magnitude (length) of vector
        public double magnitude() {
            return Math.sqrt(x*x + y*y + z*z);
        }

        // String representation of vector
        @Override
        public String toString() {
            DecimalFormat df = new DecimalFormat("#.####");
            return "(" + df.format(x) + ", " + df.format(y) + ", " + df.format(z) + ")";
        }
    }

    // Represents a line in 3D space by a point and a direction vector
    static class Line {
        Vector point;   // A point on the line
        Vector direction; // Direction vector of the line

        public Line(Vector point, Vector direction) {
            this.point = point;
            this.direction = direction;
        }
    }

    // Calculate shortest distance between two lines
    public static double calculateShortestDistance(Line line1, Line line2) {
        // Direction vectors of the lines
        Vector u = line1.direction;
        Vector v = line2.direction;

        // Vector connecting points on the two lines
        Vector w = line1.point.subtract(line2.point);

        // Calculations for the shortest distance
        double a = u.dotProduct(u);         // squared length of line1 direction
        double b = u.dotProduct(v);         // dot product of line directions
        double c = v.dotProduct(v);         // squared length of line2 direction
        double d = u.dotProduct(w);         // dot product of line1 direction and connecting vector
        double e = v.dotProduct(w);         // dot product of line2 direction and connecting vector
        
        // Denominator for parameter calculations
        double denom = a*c - b*b;

        // Parallel lines or near-parallel case
        if (denom < 1e-10) {
            // If lines are essentially parallel, project the distance of closest approach
            return w.magnitude();
        }

        // Parameters along each line where closest points occur
        double t1 = (b*e - c*d) / denom;
        double t2 = (a*e - b*d) / denom;

        // Calculate points of closest approach on each line
        Vector closestPoint1 = new Vector(
            line1.point.x + t1 * u.x,
            line1.point.y + t1 * u.y,
            line1.point.z + t1 * u.z
        );

        Vector closestPoint2 = new Vector(
            line2.point.x + t2 * v.x,
            line2.point.y + t2 * v.y,
            line2.point.z + t2 * v.z
        );

        // Calculate and return the distance between these closest points
        return closestPoint1.subtract(closestPoint2).magnitude();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#.####");

        try {
            // Input for first line
            System.out.println("Enter a point on Line 1 (x y z):");
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            Vector point1 = new Vector(x1, y1, z1);

            System.out.println("Enter direction vector for Line 1 (x y z):");
            double dx1 = scanner.nextDouble();
            double dy1 = scanner.nextDouble();
            double dz1 = scanner.nextDouble();
            Vector direction1 = new Vector(dx1, dy1, dz1);

            // Input for second line
            System.out.println("Enter a point on Line 2 (x y z):");
            double x2 = scanner.nextDouble();
            double y2 = scanner.nextDouble();
            double z2 = scanner.nextDouble();
            Vector point2 = new Vector(x2, y2, z2);

            System.out.println("Enter direction vector for Line 2 (x y z):");
            double dx2 = scanner.nextDouble();
            double dy2 = scanner.nextDouble();
            double dz2 = scanner.nextDouble();
            Vector direction2 = new Vector(dx2, dy2, dz2);

            // Create line objects
            Line line1 = new Line(point1, direction1);
            Line line2 = new Line(point2, direction2);

            // Calculate and display shortest distance
            System.out.println("\n--- Shortest Distance Between Lines ---");
            
            // Line information
            System.out.println("Line 1 Point: " + point1);
            System.out.println("Line 1 Direction: " + direction1);
            System.out.println("Line 2 Point: " + point2);
            System.out.println("Line 2 Direction: " + direction2);

            // Shortest distance
            double shortestDistance = calculateShortestDistance(line1, line2);
            System.out.println("\nShortest Distance: " + df.format(shortestDistance));

        } catch (Exception e) {
            System.out.println("Error: Please enter valid numeric coordinates.");
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}