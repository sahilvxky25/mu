import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ReplaceStringInFile {
    public static void main(String[] args) {
        String filePath = "file.txt";
        String oldString = "good";
        String newString = "nice";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            StringBuilder result = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                line = line.replace(oldString, newString);
                result.append(line).append("\n");
            }

            // Write the modified content back to the file
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
                writer.write(result.toString());
            }
        } catch (IOException e) {
            System.err.println("Error reading/writing file: " + e.getMessage());
        }
    }
}