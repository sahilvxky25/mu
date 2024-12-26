import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Traceroute {
    public static void main(String[] args) {
        // IP address or domain to trace
        String ipAddress = "google.com"; // Replace with the target IP or domain
        tracert(ipAddress);
    }

    public static void tracert(String ipAddress) {
        // Use tracert command on Windows
        String command = "tracert " + ipAddress;

        try {
            // Start the process
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            Process process = processBuilder.start();

            // Read the output from the command
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("Tracing route to " + ipAddress + "...\n");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // Wait for the process to complete
            int exitCode = process.waitFor();
            System.out.println("\nProcess finished with exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            System.err.println("Error occurred while tracing the route: " + e.getMessage());
        }
    }
}
