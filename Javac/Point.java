import java.util.Scanner;

class Point3D {
    private double x, y, z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double distance(Point3D other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double dz = other.z - this.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public double[] directionVector(Point3D other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        double dz = other.z - this.z;

        // Normalize the vector to get the direction
        double magnitude = Math.sqrt(dx * dx + dy * dy + dz * dz);
        double[] direction = {dx / magnitude, dy / magnitude, dz / magnitude};
        return direction;
    }
}

public class DistanceAndDirection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the x-coordinate of the first point: ");
        double x1 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the first point: ");
        double y1 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the first point: ");
        double z1 = scanner.nextDouble();

        System.out.print("Enter the x-coordinate of the second point: ");
        double x2 = scanner.nextDouble();
        System.out.print("Enter the y-coordinate of the second point: ");
        double y2 = scanner.nextDouble();
        System.out.print("Enter the z-coordinate of the second point: ");
        double z2 = scanner.nextDouble();

        Point3D point1 = new Point3D(x1, y1, z1);
        Point3D point2 = new Point3D(x2, y2, z2);

        double distance = point1.distance(point2);
        double[] direction = point1.directionVector(point2);

        System.out.println("Distance between the two points: " + distance);
        System.out.println("Direction vector: (" + direction[0] + ", " + direction[1] + ", " + direction[2] + ")");
    }
}