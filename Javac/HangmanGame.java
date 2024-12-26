import java.util.Scanner;
import java.util.Random;

class HangmanGame {

    static Scanner input;

    public static void hangman() {
        input = new Scanner(System.in);

        // Expanded array of strings containing more company words
        String[] company = {
            // Indian Companies
            "Maruti", "Tata", "Suzuki", "Reliance", "Infosys", 
            "Wipro", "HCL", "HDFC", "Mahindra", "Godrej",
            
            // Global Tech Companies
            "Google", "Apple", "Microsoft", "Amazon", "Intel", 
            "Samsung", "Oracle", "Adobe", "Netflix", "Twitter",
            
            // Automotive Companies
            "Ducati", "Toyota", "Honda", "BMW", "Mercedes", 
            "Ferrari", "Volkswagen", "Ford", "Tesla", "Porsche",
            
            // Other Global Brands
            "Coca", "Pepsi", "Nike", "Adidas", "Disney", 
            "IBM", "Sony", "Philips", "Canon", "Panasonic"
        };
        
        System.out.println("Welcome to HANGMAN GAME");

        Random obj = new Random();
        int Ran_num = obj.nextInt(company.length);

        // Takes input of the word
        String word = (company[Ran_num]);
        word = word.toUpperCase();

        // To show the word in underscores
        String word1 = word.replaceAll("[A-Z]", "_ ");

        // Play the game
        System.out.println("Let's play the game");
        startGame(word, word1);
    }

    public static void startGame(String word, String word1) {
        // Total guesses
        int guess_ = 0;

        // Number of wrong guesses
        int wrong = 0;

        // For each guess
        String guess;

        // Stores the guessed letter
        char letter;

        // Stores if the letter was already guessed
        boolean guessescontainsguess;
        String guesses = "";
        boolean guessinword;

        // While loop starts here
        while (wrong < 5 && word1.contains("_")) {

            System.out.println(word1 + "\n");
            int temp = 5 - wrong;
            if (wrong != 0) {
                // For remaining guesses
                System.out.println("You have " + temp + " guesses left.");
            }

            System.out.print("Your Guess: ");

            // Takes guess input
            guess = input.nextLine();

            // Converts to uppercase for comparison
            guess = guess.toUpperCase();

            // Gets the first letter as guessed letter
            letter = guess.charAt(0);

            guessescontainsguess = (guesses.indexOf(letter)) != -1;

            // Stores every letter guessed in guesses
            guesses += letter;

            // Converts to uppercase for comparison
            letter = Character.toUpperCase(letter);
            System.out.println();

            // If letter already guessed
            if (guessescontainsguess) {
                // Already guessed letter
                System.out.println("You ALREADY guessed " + letter + ". \n");
            }

            // Guessed letter is in the word
            guessinword = (word.indexOf(letter)) != -1;

            // If statement begins
            if (guessinword) {
                // Print the letter
                System.out.println(letter + " is present in the word.");
                System.out.print("\n");

                // Find the letter positions and replace dashes with those
                // letter at valid positions
                for (int position = 0; position < word.length(); position++) {
                    // Guessed letter is equal to letter at position in word
                    // and word1 has previously does not have that letter
                    if (word.charAt(position) == letter && word1.charAt(position) != letter) {
                        word1 = word1.replaceAll("_ ", "_");
                        String word2;
                        word2 = word1.substring(0, position) + letter + word1.substring(position + 1);
                        word2 = word2.replaceAll("_", "_ ");
                        word1 = word2;
                    }
                }
            }

            // If statement ends, else if begins
            else {
                // Prints wrong = wrong + 1, after every wrong answer
                System.out.println(letter + " is not present in the word.");
                wrong++;
            }

            // guess_ = guess_ + 1, after every attempt
            guess_++;

        } // While loop ends

        // If the lifelines finish
        if (wrong == 5) {
            System.out.println("YOU LOST! The correct word was: " + word + ".");
        } else {
            // When solved
            System.out.print("The word is: " + word1 + "\nWell Played, you did it!!");
        }
    }

    public static void main(String[] args) {
        // Play Hangman game
        hangman();
    }
}