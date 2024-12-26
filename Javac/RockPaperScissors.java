import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Choices mapped to their numerical equivalents
        String[] moves = {"Rock", "Scissors", "Paper"};

        int userWins = 0; // Counter for user wins

        System.out.println("Welcome to Rock-Paper-Scissors!");
        System.out.println("Enter your choice:");
        System.out.println("1: Rock\n2: Scissors\n3: Paper\n0: Exit");

        while (true) {
            // Prompt user for input
            System.out.print("\nYour move (1 for Rock, 2 for Scissors, 3 for Paper, 0 to Exit): ");
            int userChoice = getUserChoice(scanner);

            if (userChoice == 0) { // Exit condition
                System.out.println("\nThanks for playing! You won " + userWins + " time(s). Goodbye!");
                break;
            }

            // Generate a random move for the computer (1, 2, or 3)
            int computerChoice = random.nextInt(3) + 1;

            // Display user and computer choices
            System.out.println("You chose: " + moves[userChoice - 1]);
            System.out.println("Computer chose: " + moves[computerChoice - 1]);

            // Determine the winner
            String result = getResult(userChoice, computerChoice);
            System.out.println(result);

            // Update the win counter if the user wins
            if (result.equals("You win!")) {
                userWins++;
            }
        }

        scanner.close();
    }

    // Method to validate user input
    private static int getUserChoice(Scanner scanner) {
        int choice;
        while (true) {
            try {
                choice = Integer.parseInt(scanner.next());
                if (choice >= 0 && choice <= 3) { // Allow 0 (Exit) or 1-3 (Game choices)
                    break;
                } else {
                    System.out.print("Invalid input! Please enter 0, 1, 2, or 3: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a number (0, 1, 2, or 3): ");
            }
        }
        return choice;
    }

    // Method to determine the game result
    private static String getResult(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return "It's a tie!";
        }

        // Win conditions
        if ((userChoice == 1 && computerChoice == 2) || // Rock beats Scissors
            (userChoice == 2 && computerChoice == 3) || // Scissors beats Paper
            (userChoice == 3 && computerChoice == 1)) { // Paper beats Rock
            return "You win!";
        } else {
            return "You lose!";
        }
    }
}
