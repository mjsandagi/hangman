// This class is implemented as a singleton to ensure that only one instance exists at any time.
// Implements the Difficulty interface.
public class Hard implements Difficulty {
    public static final Hard INSTANCE = new Hard();

    // Prevents external instantiation
    Hard() {}

    // Returns the maximum number of attempts allowed.
    @Override
    public int getMaximumAttempts() {
        return 6;
    }
}