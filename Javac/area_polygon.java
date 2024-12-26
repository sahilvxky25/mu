import java.util.Scanner;

public class PolygonArea {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.println("Enter the number of vertices in the polygon:");
        int n = scanner.nextInt();

        if (n < 3) {
            System.out.println("A polygon must have at least 3 vertices.");
            return;
        }

        // Input the coordinates of the vertices
        double[] x = new double[n];
        double[] y = new double[n];

        System.out.println("Enter the coordinates of the vertices in order (x y):");
        for (int i = 0; i < n; i++) {
            System.out.print("Vertex " + (i + 1) + " - x: ");
            x[i] = scanner.nextDouble();
            System.out.print("Vertex " + (i + 1) + " - y: ");
            y[i] = scanner.nextDouble();
        }

        // Calculate the area using the Shoelace formula
        double area = 0;
        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n; // Next vertex index (wraps around to the first vertex)
            area += x[i] * y[next] - y[i] * x[next];
        }
        area = Math.abs(area) / 2;

        // Output the result
        System.out.printf("The area of the polygon is: %.2f\n", area);

        scanner.close();
    }
}
