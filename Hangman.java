import java.util.InputMismatchException;
import java.util.Scanner;

// Entry point for the game. The game should be run via "javac Hangman.java" and "java Hangman".
public class Hangman {
    public static void main(String[] args) {

        // Welcome the user to the game.
        System.out.println("Welcome to Hangman.");
        System.out.println("Select your chosen level of difficulty:");
        System.out.println("1. Easy (10 attempts)");
        System.out.println("2. Medium (8 attempts)");
        System.out.println("3. Hard (6 attempts)");
        System.out.print("Enter your choice as an integer: ");

        // Get the user's selected input difficulty.
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice < 1 || choice > 3) {
            try {
                choice = scanner.nextInt();
//                scanner.nextLine();
                if (choice < 1 || choice > 3) {
                    System.out.println("Invalid input. Please ensure that you enter a number between 1 and 3.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please ensure that you enter an integer between 1 and 3.");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 3.");
                scanner.nextLine();
            }
        }


        // Determine the difficulty based on user input.
        Difficulty difficulty;
        switch (choice) {
            case 1:
                difficulty = Easy.INSTANCE;
                break;
            case 2:
                difficulty = Medium.INSTANCE;
                break;
            case 3:
                difficulty = Hard.INSTANCE;
                break;
            default:
                System.out.println("Invalid input. Defaulting to medium difficulty");
                difficulty = Medium.INSTANCE;
        }

        // Start the game.
        Game game = new Game(difficulty);
        game.run();
    }
}