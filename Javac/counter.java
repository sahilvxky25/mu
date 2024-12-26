import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileCharacterAnalyzer {
    /**
     * Analyze character types in a given text file
     * 
     * @param filePath Path to the text file to be analyzed
     * @return CharacterCount object containing detailed character type statistics
     * @throws IOException If file reading encounters an error
     */
    public static CharacterCount analyzeFileCharacters(String filePath) throws IOException {
        CharacterCount charCount = new CharacterCount();

        // Use try-with-resources for automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int currentChar;
            
            // Read file character by character
            while ((currentChar = reader.read()) != -1) {
                // Convert to char for easier processing
                char ch = (char) currentChar;
                
                // Increment total character count
                charCount.totalChars++;
                
                // Categorize character
                if (Character.isAlphabetic(ch)) {
                    charCount.alphabetCount++;
                } else if (Character.isDigit(ch)) {
                    charCount.numberCount++;
                } else if (!Character.isWhitespace(ch)) {
                    // If not a whitespace and not an alphabet or number, 
                    // consider it a special character
                    charCount.specialCharCount++;
                }
            }
        }

        return charCount;
    }

    /**
     * Inner class to store and manage character count statistics
     */
    public static class CharacterCount {
        // Character type counters
        int totalChars = 0;
        int alphabetCount = 0;
        int numberCount = 0;
        int specialCharCount = 0;

        /**
         * Generate a formatted report of character analysis
         * 
         * @return Detailed character count report
         */
        public String generateReport() {
            return String.format(
                "Character Analysis Report:\n" +
                "Total Characters: %d\n" +
                "Alphabets: %d\n" +
                "Numbers: %d\n" +
                "Special Characters: %d",
                totalChars, alphabetCount, numberCount, specialCharCount
            );
        }
    }

    /**
     * Main method to demonstrate file character analysis
     * Provides example usage and error handling
     */
    public static void main(String[] args) {
        // File path can be modified as needed
        String filePath = "file.txt";

        try {
            // Analyze the file
            CharacterCount result = analyzeFileCharacters(filePath);
            
            // Print the detailed report
            System.out.println(result.generateReport());

        } catch (IOException e) {
            // Handle potential file reading errors
            System.err.println("Error reading file: " + e.getMessage());
            System.err.println("Please check the file path and ensure the file exists.");
        }
    }
}