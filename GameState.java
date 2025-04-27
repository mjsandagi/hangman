// Handles the dynamic state of the game during play.
// It extends the BaseGameState abstract class, to store
// properties such as the word to guess, guessed letters,
// and remaining attempts.
public class GameState extends BaseGameState {
    // Constructs a GameState for the given word and difficulty.
    public GameState(String wordToGuess, Difficulty difficulty) {
        super(wordToGuess, difficulty);
    }

    // Converts the guessed letter to uppercase, adds it to the set
    // of guessed letters, displays the letter in the correct position
    // if it exists within the word, otherwise penalising the user.
    @Override
    public void validateGuess(char guess) {
        guess = Character.toUpperCase(guess);
        guessedLetters.add(guess);
        boolean isCorrect = false;
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (wordToGuess.charAt(i) == guess) {
                displayedWord[i] = guess;
                isCorrect = true;
            }
        }
        // Decrements the remaining attempts if the guess was incorrect.
        if (!isCorrect) remainingAttempts--;
    }
}