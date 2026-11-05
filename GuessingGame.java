import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private int secretNum;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        GuessingGame game = new GuessingGame();
        game.playGame();
    }

    public void playGame() {
        System.out.println("Hello! Welcome to my Guessing Game!");

        boolean playAgain = true;

        while (playAgain) {
            chooseDifficulty();
            getGuess();
            playAgain = playAgain();
        }

        System.out.println("Thanks for playing my Game!");
        input.close();
    }

    public void chooseDifficulty() {
        System.out.print("What difficulty do you want to play? (1-Easy, 2-Medium, 3-Hard): ");
        int difficulty = input.nextInt();
        Random randInt = new Random();

        if (difficulty == 1) {
            secretNum = randInt.nextInt(10) + 1;
            System.out.println("Guess a number between 1 and 10!");
        }
        else if (difficulty == 2) {
            secretNum = randInt.nextInt(50) + 1;
            System.out.println("Guess a number between 1 and 50!");
        }
        else if (difficulty == 3){
            secretNum = randInt.nextInt(100) + 1;
            System.out.println("Guess a number between 1 and 100!");
        } else {
            System.out.println("Invalid difficulty level. Please choose 1, 2, or 3!");
            chooseDifficulty();
        }
    }

    public void getGuess() {
        int guess = 0;
        int attempts = 0;
        while(guess != secretNum) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            attempts++;
            if(guess < secretNum) {
                System.out.println("The secret number is higher than your guess!");
            } else if (guess > secretNum) {
                System.out.println("The secret number is lower than your guess!");
            } else {
                System.out.println("Congratulations! You guessed the secret number " + secretNum + " in " + attempts + " attempts!");
            }
            
        }
    }

    public boolean playAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = input.next();
        return response.equalsIgnoreCase("yes");
    }

}