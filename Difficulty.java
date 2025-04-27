// The Difficulty interface represents the concept of difficulty levels in the game.
// Implementing classes will define the maximum number of attempts available.
public interface Difficulty {
    // Returns the maximum number of allowed attempts for this difficulty level.
    int getMaximumAttempts();
}