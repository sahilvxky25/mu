import java.util.Arrays;
import java.util.Scanner;

public class DictionaryOrder {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of words:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        String[] words = new String[n];
        System.out.println("Enter the words:");

        for (int i = 0; i < n; i++) {
            words[i] = scanner.nextLine();
        }

        Arrays.sort(words);

        System.out.println("Words in dictionary order:");
        for (String word : words) {
            System.out.println(word);
        }

        scanner.close();
    }
}
