import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int numberToGuess = random.nextInt(10) + 1;
        int numberOfTries = 0;
        boolean hasGuessedCorrectly = false;
        int guess;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("Guess a number between 1 and 10:");

        while (!hasGuessedCorrectly) {
            try {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                numberOfTries++;

                if (guess < 1 || guess > 10) {
                    System.out.println("Invalid input. Please guess a number between 1 and 10.");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the correct number in " + numberOfTries + " tries.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        scanner.close();
    }
}
