import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

public class IPAddressDetailsRetriever {
    public static void main(String[] args) {
        // You can replace this with user input or command-line argument
        String ipAddress = "192.168.42.205"; // Example IP (Google's DNS)
        
        try {
            // Retrieve IP details
            System.out.println("IP Address Information Retrieval");
            System.out.println("--------------------------------");
            
            // Basic IP Address Details
            InetAddress inetAddress = InetAddress.getByName(ipAddress);
            
            System.out.println("IP Address: " + ipAddress);
            System.out.println("Host Name: " + inetAddress.getHostName());
            System.out.println("Canonical Host Name: " + inetAddress.getCanonicalHostName());
            System.out.println("Is Reachable: " + inetAddress.isReachable(5000)); // 5-second timeout
            System.out.println("Is Loopback Address: " + inetAddress.isLoopbackAddress());
            System.out.println("Is Link Local Address: " + inetAddress.isLinkLocalAddress());
            
            // Geolocation Information (Basic)
            System.out.println("\nGeolocation Information:");
            getGeolocationDetails(ipAddress);
            
            // Hostname Lookup
            System.out.println("\nHostname Lookup:");
            performReverseDNS(ipAddress);
            
        } catch (UnknownHostException e) {
            System.err.println("Unable to resolve IP address: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
    
    // Method to retrieve basic geolocation details using a free API
    private static void getGeolocationDetails(String ipAddress) {
        try {
            // Using ipapi.co for free geolocation lookup
            URL url = new URL("https://ipapi.co/" + ipAddress + "/json/");
            
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))) {
                String line;
                boolean firstLine = true;
                while ((line = reader.readLine()) != null) {
                    // Simple JSON parsing to print key details
                    if (line.contains("\"city\"") || 
                        line.contains("\"region\"") || 
                        line.contains("\"country_name\"") ||
                        line.contains("\"latitude\"") ||
                        line.contains("\"longitude\"") ||
                        line.contains("\"org\"")) {
                        // Clean up the JSON line for readability
                        line = line.trim().replace(",", "").replace("\"", "");
                        System.out.println(line);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Could not retrieve geolocation details: " + e.getMessage());
        }
    }
    
    // Method to perform reverse DNS lookup
    private static void performReverseDNS(String ipAddress) {
        try {
            InetAddress address = InetAddress.getByName(ipAddress);
            String hostName = address.getHostName();
            
            System.out.println("Resolved Hostname: " + hostName);
            
            // Additional hostname information
            InetAddress[] allByName = InetAddress.getAllByName(hostName);
            System.out.println("All Associated IP Addresses:");
            for (InetAddress addr : allByName) {
                System.out.println(" - " + addr.getHostAddress());
            }
            
        } catch (UnknownHostException e) {
            System.err.println("Reverse DNS lookup failed: " + e.getMessage());
        }
    }
}