import java.io.*;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame() {
        System.out.println("You are playing the game...");
        Random random = new Random();
        int score = random.nextInt(62) + 1; // Random number between 1 and 62

        // Fetch the hiscore
        int hiscore = 0;
        File file = new File("hiscore.txt");
        try {
            if (file.exists()) {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = br.readLine();
                if (line != null && !line.isEmpty()) {
                    hiscore = Integer.parseInt(line);
                }
                br.close();
            }
        } catch (IOException e) {
            System.out.println("Error reading hiscore: " + e.getMessage());
        }

        System.out.println("Your score: " + score);

        // Update hiscore if the current score is higher
        if (score > hiscore) {
            System.out.println("New high score!");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("hiscore.txt"))) {
                bw.write(String.valueOf(score));
            } catch (IOException e) {
                System.out.println("Error writing hiscore: " + e.getMessage());
            }
        }
    }
}
