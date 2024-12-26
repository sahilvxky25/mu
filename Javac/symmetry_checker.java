import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparator {

    public static void main(String[] args) throws IOException {
        String file1Path = "this.txt";
        String file2Path = "this_copy.txt";

        String content1 = readFile(file1Path);
        String content2 = readFile(file2Path);

        if (content1.equals(content2)) {
            System.out.println("Yes, these files are identical");
        } else {
            System.out.println("No, these files are not identical");
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n"); // Add newline after each line
            }
        }
        return contentBuilder.toString().trim(); // Remove trailing newline
    }
}