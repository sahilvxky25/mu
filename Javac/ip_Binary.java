import java.util.Scanner;

public class IPToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter an IP address (or 'quit' to exit): ");
            String ipAddress = scanner.nextLine();
            
            // Exit condition
            if (ipAddress.equalsIgnoreCase("quit")) {
                break;
            }
            
            try {
                // Convert and display results
                convertIPToBinary(ipAddress);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid IP address: " + e.getMessage());
            }
        }
        
        scanner.close();
        System.out.println("IP to Binary Converter closed.");
    }
    
    public static void convertIPToBinary(String ipAddress) {
        // Validate IP address format
        if (!isValidIPAddress(ipAddress)) {
            throw new IllegalArgumentException("Invalid IP address format");
        }
        
        // Split IP into octets
        String[] octets = ipAddress.split("\\.");
        
        // Convert each octet to binary
        System.out.println("\nIP Address Conversion:");
        System.out.println("Decimal IP: " + ipAddress);
        System.out.println("Binary Representation:");
        
        StringBuilder fullBinaryIP = new StringBuilder();
        
        for (int i = 0; i < octets.length; i++) {
            // Convert each octet to binary
            int octetValue = Integer.parseInt(octets[i]);
            String binaryOctet = String.format("%8s", Integer.toBinaryString(octetValue)).replace(' ', '0');
            
            // Print detailed conversion
            System.out.printf("Octet %d: %3s (Decimal) = %s (Binary)%n", 
                               i + 1, octets[i], binaryOctet);
            
            // Build full binary IP
            fullBinaryIP.append(binaryOctet);
            
            // Add dot between octets except for the last one
            if (i < octets.length - 1) {
                fullBinaryIP.append(".");
            }
        }
        
        // Print full binary representation
        System.out.println("\nFull Binary IP: " + fullBinaryIP.toString());
        System.out.println("Total Binary Length: " + fullBinaryIP.toString().replace(".", "").length() + " bits\n");
    }
    
    public static boolean isValidIPAddress(String ipAddress) {
        // Regular expression to validate IP address format
        if (ipAddress == null || ipAddress.isEmpty()) {
            return false;
        }
        
        // Split into octets
        String[] octets = ipAddress.split("\\.");
        
        // Check if exactly 4 octets
        if (octets.length != 4) {
            return false;
        }
        
        // Validate each octet
        for (String octet : octets) {
            try {
                int value = Integer.parseInt(octet);
                
                // Check if value is between 0 and 255
                if (value < 0 || value > 255) {
                    return false;
                }
                
                // Prevent leading zeros
                if (octet.length() > 1 && octet.startsWith("0")) {
                    return false;
                }
            } catch (NumberFormatException e) {
                return false;
            }
        }
        
        return true;
    }
    
    // Additional method to convert binary back to decimal (optional)
    public static String binaryToDecimalIP(String binaryIP) {
        // Remove dots from binary representation
        String cleanBinaryIP = binaryIP.replace(".", "");
        
        // Validate binary IP length
        if (cleanBinaryIP.length() != 32) {
            throw new IllegalArgumentException("Invalid binary IP length");
        }
        
        StringBuilder decimalIP = new StringBuilder();
        
        // Convert 8 bits at a time
        for (int i = 0; i < 4; i++) {
            String octetBinary = cleanBinaryIP.substring(i * 8, (i + 1) * 8);
            int decimalOctet = Integer.parseInt(octetBinary, 2);
            
            decimalIP.append(decimalOctet);
            if (i < 3) {
                decimalIP.append(".");
            }
        }
        
        return decimalIP.toString();
    }
}