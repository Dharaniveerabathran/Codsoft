import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 0;
        int totalAttempts = 0;
        int rounds = 0;
        int correctGuesses = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        boolean playAgain = true;
        while (playAgain) {
            rounds++;
            int secretNumber = random.nextInt(maxRange - minRange + 1) + minRange;
            attempts = 0;
            System.out.println("\nRound " + rounds + ": I've selected a number between " + minRange + " and " + maxRange + ". Can you guess it?");

            while (true) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;
                totalAttempts++;

                if (guess < minRange || guess > maxRange) {
                    System.out.println("Please enter a number within the specified range.");
                    continue;
                }

                if (guess == secretNumber) {
                    System.out.println("Congratulations! You guessed the number " + secretNumber + " correctly in " + attempts + " attempts.");
                    correctGuesses++;
                    break;
                } else if (attempts >= 5) {
                    System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: " + secretNumber);
                    break;
                } else if (guess < secretNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }

            System.out.print("\nDo you want to play again? (yes/no): ");
            String playAgainInput = scanner.next();

            if (!playAgainInput.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\nGame Over!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Total attempts: " + totalAttempts);
        System.out.println("Correct guesses: " + correctGuesses);
        System.out.println("Your score: " + calculateScore(totalAttempts, rounds, correctGuesses));
        scanner.close();
    }

    public static int calculateScore(int totalAttempts, int rounds, int correctGuesses) {
       
        int score = 1000 - totalAttempts + (rounds * 100) + (correctGuesses * 50);
        return score;
    }
}