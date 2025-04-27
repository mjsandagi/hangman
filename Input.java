// The Input class handles user input during the game.
// It extends the Handler abstract class utilise a shared Scanner.
// The class validates guesses and user input.
public class Input extends Handler {
    public char getValidGuess(GameState state) {
        while (true) {
            // Prompts the user to enter a valid guess.
            System.out.print("Enter a letter: ");
            String input = scanner.nextLine().trim().toUpperCase();

            // The input must be a single character.
            if (input.length() != 1) {
                System.out.println("Your input was invalid. Ensure that you enter a single letter.");
                continue;
            }

            char guess = input.charAt(0);
            // Checks to see if the character is actually a letter (and not a number, symbol etc.)
            if (!Character.isLetter(guess)) {
                System.out.println("Your input was invalid. Ensure that you enter a letter (A-Z).");
            } else if (state.getGuessedCharacters().contains(guess)) { // Checks to see if the letter was already guessed. 
                System.out.println("You have already guessed that letter!");
            } else { // i.e. the guess is valid.
                return guess;
            }
        }
    }
}