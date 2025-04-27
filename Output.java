public class Output extends Handler {
    public void displayWelcome() {
        // Displays a welcome message.
        System.out.println("Welcome!");
        System.out.println("Hangman is a word-guessing game, where you're given a set number of chances to identify an unknown word");
    }

    // Displays the current state of the game, including the
    // partially-identified word and the number of remaining attempts.
    public void displayGameState(GameState gameState) {
        System.out.println("\nCurrent State: " + gameState.getDisplayedWord());
        System.out.println("Remaining Attempts: " + gameState.getRemainingAttempts());
    }

    // Displays the final result of the game, which depends on whether the user won or lost the game.
    public void displayResult(boolean hasWon, GameState gameState) {
        if (hasWon) {
            System.out.println("\nWord identified: " + gameState.getDisplayedWord());
            System.out.println("Well done - you won!");
        } else {
            System.out.println("\nUh oh - you're out of attempts");
            System.out.println("Game over, you lost!");
        }
    }
}