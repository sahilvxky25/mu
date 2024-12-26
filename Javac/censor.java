import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordReplacer {

    public static void main(String[] args) throws IOException {
        String[] wordsToReplace = {"Donkey", "bad", "ganda"}; // Array of words to replace
        String filePath = "file.txt";  // Path to the file

        String content = readFile(filePath);

        // Replace words with # symbols
        for (String word : wordsToReplace) {
            content = content.replaceAll(word, repeat("#", word.length()));
        }

        writeFile(filePath, content);
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n"); // Add newline after each read line
            }
        }
        return contentBuilder.toString().trim(); // Remove trailing newline
    }

    private static void writeFile(String filePath, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(content);
        }
    }

    private static String repeat(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }
        return builder.toString();
    }
}