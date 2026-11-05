import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    private int secretNum;
    private int type;
    private int guess;
    private int attempts;
    Random randInt = new Random();
    DecimalFormat df = new DecimalFormat("#.##");
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
            chooseType();
            if (type == 1) {
                startNo();
            } else if (type == 2) {
                startLessMore();
            } else if (type == 3) {
                startMath();
            } else {
                startExact();
            }
            playAgain = playAgain();
        }

        System.out.println("Thanks for playing my Game!");
        input.close();
    }

    public int chooseType() {
        System.out.println("1. No hints");
        System.out.println("2. With Less/More hints");
        System.out.println("3. With math hints");
        System.out.println("4. With exact hints");
        System.out.print("What type of game do you want to play?: ");
        type = input.nextInt();
        while (type != 1 && type != 2 && type != 3 && type != 4) {
            System.out.println("Invalid Input! Please try again!");
            type = input.nextInt();
        }
        return type;
    }

    public void chooseDifficulty() {
        System.out.print("What difficulty do you want to play? (1-Easy, 2-Medium, 3-Hard): ");
        int difficulty = input.nextInt();

        if (difficulty == 1) {
            secretNum = randInt.nextInt(1) + 1;
            System.out.println("Guess a number between 1 and 10!");
        } else if (difficulty == 2) {
            secretNum = randInt.nextInt(50) + 1;
            System.out.println("Guess a number between 1 and 50!");
        } else if (difficulty == 3) {
            secretNum = randInt.nextInt(100) + 1;
            System.out.println("Guess a number between 1 and 100!");
        } else {
            System.out.println("Invalid difficulty level. Please choose 1, 2, or 3!");
            chooseDifficulty();
        }
    }

    public void startNo() {
        guess = 0;
        attempts = 0;
        System.out.println("Starting No hint mode!");
        attempts++;
        while (guess != secretNum) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            if (guess == secretNum) {
                System.out.println("Congratulations! You guessed the secret number " + secretNum + " in " + attempts
                        + " attempts!");
            } else {
                System.out.println("Nope");
            }
        }
    }

    public void startLessMore() {
        guess = 0;
        attempts = 0;
        System.out.println("Starting Less or More hint mode!");
        while (guess != secretNum) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            attempts++;
            if (guess < secretNum) {
                System.out.println("The secret number is higher than your guess!");
            } else if (guess > secretNum) {
                System.out.println("The secret number is lower than your guess!");
            } else {
                System.out.println("Congratulations! You guessed the secret number " + secretNum + " in " + attempts
                        + " attempts!");
            }

        }
    }

    public void startMath() {
        guess = 0;
        attempts = 0;
        System.out.println("Starting Math hints mode!");
        while (guess != secretNum) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            int math = randInt.nextInt(5);
            int result = 0;
            attempts++;
            if (guess == secretNum) {
                System.out.println("Congratulations! You guessed the secret number " + secretNum + " in " + attempts
                        + " attempts!");
            } else {
                if (math == 0) { // addition
                    result = secretNum + guess;
                    System.out.println("The number plus your guess is " + result + "!");
                } else if (math == 1) { // subtraction
                    result = secretNum - guess;
                    System.out.println("The number minus your guess is " + result + "!");
                } else if (math == 2) { // multiplication
                    result = secretNum * guess;
                    System.out.println("The number times your guess is " + result + "!");
                } else if (math == 3) { // division
                    if (guess != 0) {
                        double div = (double) secretNum / guess;
                        System.out.println("The number divided by your guess is " + df.format(div) + "!");
                    } else {
                        System.out.println("The number divided by your guess is undefined!");
                    }
                } else if (math == 4) { // exponent
                    double exp = Math.pow(secretNum, guess);
                    System.out.println("The number to the power of your guess is " + exp + "!");
                }
            }
        }

    }

    public void startExact() {
        guess = 0;
        attempts = 0;
        System.out.println("Starting Exact hint mode!");
        while (guess != secretNum) {
            System.out.print("Enter your guess: ");
            guess = input.nextInt();
            attempts++;
            int difference = secretNum - guess;
            if (guess < secretNum) {
                System.out.println("The secret number is " + difference + " higher than your guess!");
            } else if (guess > secretNum) {
                System.out.println("The secret number is " + -difference + " lower than your guess!");
            } else {
                System.out.println("Congratulations! You guessed the secret number " + secretNum + " in " + attempts
                        + " attempts!");
            }

        }
    }

    public boolean playAgain() {
        System.out.print("Do you want to play again? (yes/no): ");
        String response = input.next();
        return response.equalsIgnoreCase("yes");
    }

}