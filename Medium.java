// This class is implemented as a singleton to ensure that only one instance exists at any time.
// Implements the Difficulty interface.
public class Medium implements Difficulty {
    public static final Medium INSTANCE = new Medium();

    // Prevents external instantiation.
    Medium() {}

    // Returns the maximum number of attempts allowed.
    @Override
    public int getMaximumAttempts() {
        return 8;
    }
}