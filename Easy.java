// This class is implemented as a singleton to ensure that only one instance exists at any time.
// Implements the Difficulty interface.
public class Easy implements Difficulty {
    public static final Easy INSTANCE = new Easy();

    // Prevents external instantiation
    Easy() {}

    // Returns the maximum number of attempts allowed.
    @Override
    public int getMaximumAttempts() {
        return 10;
    }
}