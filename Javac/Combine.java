import java.io.*;
import java.nio.file.*;

public class TextFileMerger {
    public static void mergeFiles(String file1Path, String file2Path, String outputPath) throws IOException {
        // Create a Path object for the input and output files
        Path path1 = Paths.get("this.txt");
        Path path2 = Paths.get("this_copy.txt");
        Path outputFilePath = Paths.get(outputPath);

        try (
            // Open input streams for both files
            BufferedReader reader1 = Files.newBufferedReader(path1);
            BufferedReader reader2 = Files.newBufferedReader(path2);
            
            // Open output stream for the merged file
            BufferedWriter writer = Files.newBufferedWriter(outputFilePath, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING)
        ) {
            // Variable to store each line read from files
            String line;

            // Read and write contents of first file
            while ((line = reader1.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Add a separator between files (optional)
            writer.write("--- End of First File ---");
            writer.newLine();

            // Read and write contents of second file
            while ((line = reader2.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            System.out.println("Files merged successfully!");
        }
    }

    public static void main(String[] args) {
        try {
            // Example usage
            mergeFiles("file1.txt", "file2.txt", "merged_output.txt");
        } catch (IOException e) {
            System.err.println("An error occurred while merging files: " + e.getMessage());
            e.printStackTrace();
        }
    }
}