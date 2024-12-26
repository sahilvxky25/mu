import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileDifferenceFinder {

    public static void main(String[] args) throws IOException {
        String file1Path = "file1.txt";
        String file2Path = "file2.txt";

        List<String> file1Lines = readFile(file1Path);
        List<String> file2Lines = readFile(file2Path);

        findDifferences(file1Lines, file2Lines, file1Path, file2Path);
    }

    private static List<String> readFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    private static void findDifferences(List<String> file1Lines, List<String> file2Lines, String file1Path, String file2Path) {
        int minLines = Math.min(file1Lines.size(), file2Lines.size());

        // Check for differences in common lines
        for (int i = 0; i < minLines; i++) {
            if (!file1Lines.get(i).equals(file2Lines.get(i))) {
                System.out.println("Difference found:");
                System.out.println("File 1 (" + file1Path + "), Line " + (i + 1) + ": " + file1Lines.get(i));
                System.out.println("File 2 (" + file2Path + "), Line " + (i + 1) + ": " + file2Lines.get(i));
                System.out.println();
            }
        }

        // Check for extra lines in file1
        if (file1Lines.size() > minLines) {
            System.out.println("Extra lines in " + file1Path + " starting from line " + (minLines + 1) + ":");
            for (int i = minLines; i < file1Lines.size(); i++) {
                System.out.println("Line " + (i + 1) + ": " + file1Lines.get(i));
            }
            System.out.println();
        }

        // Check for extra lines in file2
        if (file2Lines.size() > minLines) {
            System.out.println("Extra lines in " + file2Path + " starting from line " + (minLines + 1) + ":");
            for (int i = minLines; i < file2Lines.size(); i++) {
                System.out.println("Line " + (i + 1) + ": " + file2Lines.get(i));
            }
            System.out.println();
        }

        if (file1Lines.size() == file2Lines.size() && file1Lines.equals(file2Lines)) {
            System.out.println("The files are identical.");
        }
    }
}