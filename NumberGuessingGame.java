import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        int roundsPlayed = 0;
        String playAgain;

        System.out.println("================================");
        System.out.println("     NUMBER GUESSING GAME");
        System.out.println("================================");

        do {
            int secretNumber = random.nextInt(100) + 1;
            int attemptsLeft = 7;
            boolean guessedCorrectly = false;

            roundsPlayed++;

            System.out.println("\nI have selected a number from 1 to 100.");
            System.out.println("You have 7 attempts to guess it.");

            while (attemptsLeft > 0 && !guessedCorrectly) {
                System.out.print("\nEnter your guess: ");
                String input = sc.nextLine();

                int guess;

                try {
                    guess = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid whole number.");
                    continue;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    continue;
                }

                attemptsLeft--;

                if (guess == secretNumber) {
                    guessedCorrectly = true;
                    int points = attemptsLeft + 1;

                    totalScore += points;

                    System.out.println("Correct! You guessed the number.");
                    System.out.println("Points earned: " + points);
                } else if (guess < secretNumber) {
                    System.out.println("Too Low!");
                } else {
                    System.out.println("Too High!");
                }

                if (!guessedCorrectly && attemptsLeft > 0) {
                    System.out.println("Attempts remaining: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Game over! The number was " + secretNumber);
            }

            System.out.println("\nRounds played: " + roundsPlayed);
            System.out.println("Total score: " + totalScore);

            System.out.print("Would you like to play again? (yes/no): ");
            playAgain = sc.nextLine().trim();

        } while (playAgain.equalsIgnoreCase("yes")
                || playAgain.equalsIgnoreCase("y"));

        System.out.println("\nThanks for playing!");
        System.out.println("Final score: " + totalScore);

        sc.close();
    }
}
