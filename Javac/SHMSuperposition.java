import java.util.Scanner;

public class SHMSuperposition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the parameters from the user
        System.out.print("Enter amplitude of first SHM (A1): ");
        double A1 = sc.nextDouble();

        System.out.print("Enter angular frequency of first SHM (w1): ");
        double w1 = sc.nextDouble();

        System.out.print("Enter phase of first SHM (phi1): ");
        double phi1 = sc.nextDouble();

        System.out.print("Enter amplitude of second SHM (A2): ");
        double A2 = sc.nextDouble();

        System.out.print("Enter angular frequency of second SHM (w2): ");
        double w2 = sc.nextDouble();

        System.out.print("Enter phase of second SHM (phi2): ");
        double phi2 = sc.nextDouble();

        System.out.print("Enter the angle between the two SHMs in degrees: ");
        double angle = sc.nextDouble();

        // Convert angle to radians
        double angleRad = Math.toRadians(angle);

        // Compute the resultant amplitude and phase
        double resultantAmplitude = Math.sqrt(Math.pow(A1, 2) + Math.pow(A2, 2) + 2 * A1 * A2 * Math.cos(angleRad));
        double resultantPhase = Math.atan((A1 * Math.sin(phi1) + A2 * Math.sin(phi2)) / (A1 * Math.cos(phi1) + A2 * Math.cos(phi2)));

        System.out.println("The resultant amplitude is: " + resultantAmplitude);
        System.out.println("The resultant phase is: " + resultantPhase);
        
        // Time variable
        double t = 0;
        
        // Assume equal angular frequency for simplicity, otherwise you need to handle w1 and w2 separately
        double w = (w1 + w2) / 2; 

        // Print the equation of trajectory
        System.out.println("The equation of the trajectory is: x(t) = " + resultantAmplitude + " * cos(" + w + " * t + " + resultantPhase + ")");
    }
}
