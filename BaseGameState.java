import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Base abstract class with template for managing game state, 
// including functionality such as the word to guess, remaining
// letters, guessed letters, and current progress.  
public abstract class BaseGameState {
    protected final String wordToGuess;
    protected final char[] displayedWord;
    protected int remainingAttempts;
    protected final Set<Character> guessedLetters;


    // Initialises the game state
    public BaseGameState(String wordToGuess, Difficulty difficulty) {
        this.wordToGuess = wordToGuess.toUpperCase();
        this.displayedWord = new char[wordToGuess.length()];
        Arrays.fill(this.displayedWord, '_');
        this.remainingAttempts = difficulty.getMaximumAttempts();
        this.guessedLetters = new HashSet<>();
    }

    // CONTRACT: Processes and validates the user's input - must be implemented
    // by any subclasses to update and alter game state accordingly.
    public abstract void validateGuess(char guess);

    // Checks to see if the user has successfully identified the word.
    public boolean hasSuccessfullyTerminated() {
        return new String(displayedWord).equals(wordToGuess);
    }

    // Checks to see if no more attempts are left.
    public boolean isGameOver() {
        return remainingAttempts <= 0;
    }

    // Returns the current state of the identified fragment of the word.
    public String getDisplayedWord() {
        return new String(displayedWord);
    }


    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    // Returns the set of letters that have been guessed so far.
    public Set<Character> getGuessedCharacters() {
        return guessedLetters;
    }
}

