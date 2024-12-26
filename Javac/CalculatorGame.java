import java.util.Random;
import java.util.Scanner;

public class CalculatorGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        int numberOfQuestions = 5;

        System.out.println("Welcome to the Calculator Game!");
        System.out.println("You will be given " + numberOfQuestions + " math problems to solve.");
        System.out.println("For each correct answer, you will earn 1 point.");
        System.out.println("Let's start!");

        for (int i = 0; i < numberOfQuestions; i++) {
            int num1 = random.nextInt(100) + 1; // Random number between 1 and 100
            int num2 = random.nextInt(100) + 1; // Random number between 1 and 100
            char operator = getRandomOperator(random);

            System.out.print("Question " + (i + 1) + ": " + num1 + " " + operator + " " + num2 + " = ");
            int playerAnswer = scanner.nextInt();
            int correctAnswer = calculate(num1, num2, operator);

            if (playerAnswer == correctAnswer) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + correctAnswer);
            }
        }

        System.out.println("Game Over! Your final score is: " + score + " out of " + numberOfQuestions);
        scanner.close();
    }

    // Method to get a random operator
    private static char getRandomOperator(Random random) {
        char[] operators = {'+', '-', '*', '/'};
        return operators[random.nextInt(4)];
    }

    // Method to calculate the result of the operation
    private static int calculate(int num1, int num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            case '/':
                return num1 / num2;
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }
}
