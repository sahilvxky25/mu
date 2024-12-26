import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearchUtility {
    /**
     * Searches for a file with the given name in the specified directory and its subdirectories.
     * 
     * @param directoryPath The path of the directory to start searching from
     * @param fileName The name of the file to search for
     * @param searchRecursively Whether to search in subdirectories as well
     * @return A list of file paths where the file was found
     */
    public static List<String> searchFile(String directoryPath, String fileName, boolean searchRecursively) {
        // List to store found file paths
        List<String> foundFiles = new ArrayList<>();
        
        // Create a File object for the directory
        File directory = new File(directoryPath);
        
        // Validate that the directory exists and is actually a directory
        if (!directory.exists() || !directory.isDirectory()) {
            System.err.println("Invalid directory path: " + directoryPath);
            return foundFiles;
        }
        
        // Call the recursive search method
        searchFileRecursive(directory, fileName, searchRecursively, foundFiles);
        
        return foundFiles;
    }
    
    /**
     * Recursive method to search for files in the given directory
     * 
     * @param directory Current directory to search
     * @param fileName Name of the file to find
     * @param searchRecursively Whether to continue searching in subdirectories
     * @param foundFiles List to accumulate found file paths
     */
    private static void searchFileRecursive(File directory, String fileName, 
                                            boolean searchRecursively, List<String> foundFiles) {
        // Get all files and directories in the current directory
        File[] files = directory.listFiles();
        
        // Handle empty directories
        if (files == null) {
            return;
        }
        
        // Iterate through all files and directories
        for (File file : files) {
            // Check if the current file matches the target filename
            if (file.isFile() && file.getName().equals(fileName)) {
                foundFiles.add(file.getAbsolutePath());
            }
            
            // Recursively search subdirectories if enabled
            if (searchRecursively && file.isDirectory()) {
                searchFileRecursive(file, fileName, true, foundFiles);
            }
        }
    }
    
    /**
     * Main method to demonstrate file search functionality
     */
    public static void main(String[] args) {
        // Example usage of the file search utility
        String searchPath = "D:/Coding/Html";  // Replace with actual path
        String targetFileName = "index.html";
        
        // Search with recursive option
        List<String> results = searchFile(searchPath, targetFileName, true);
        
        // Print results
        if (results.isEmpty()) {
            System.out.println("No files found matching: " + targetFileName);
        } else {
            System.out.println("Found " + results.size() + " file(s):");
            for (String filePath : results) {
                System.out.println(filePath);
            }
        }
    }
}