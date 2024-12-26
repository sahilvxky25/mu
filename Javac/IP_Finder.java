import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class SystemIPFinder {
    public static void main(String[] args) {
        try {
            // Find and print local IP addresses
            System.out.println("Local IP Addresses:");
            
            // Enumerate all network interfaces
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            
            while (interfaces.hasMoreElements()) {
                NetworkInterface networkInterface = interfaces.nextElement();
                
                // Skip loopback and inactive interfaces
                if (networkInterface.isLoopback() || !networkInterface.isUp()) {
                    continue;
                }
                
                // Get IP addresses for this interface
                Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
                
                while (addresses.hasMoreElements()) {
                    InetAddress address = addresses.nextElement();
                    
                    // Filter out IPv6 addresses and link-local addresses
                    if (!address.isLoopbackAddress() && 
                        !address.isLinkLocalAddress() && 
                        address.getHostAddress().contains(".")) {
                        System.out.println("Interface: " + networkInterface.getName() + 
                                           ", IP: " + address.getHostAddress());
                    }
                }
            }
            
            // Get public IP (if available through InetAddress)
            InetAddress publicIP = InetAddress.getLocalHost();
            System.out.println("\nPublic IP: " + publicIP.getHostAddress());
            
        } catch (SocketException | java.net.UnknownHostException e) {
            System.err.println("Error finding IP address: " + e.getMessage());
            e.printStackTrace();
        }
    }
}