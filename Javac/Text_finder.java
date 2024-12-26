import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FindStringInFile {
    public static void main(String[] args) {
        String filePath = "file.txt";
        String searchString = "good";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                if (line.contains(searchString)) {
                    System.out.println("String found on line " + lineNumber + ": " + line);
                }
                lineNumber++;
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}