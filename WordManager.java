import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// WordManager is an abstract class that manages the word bank.
// It stores words categorised by their difficulty level, and provides an abstract method for loading the words.
// This is because, in the future, words may be loaded from external servers or databases. 
// Subclasses will implement the tailored logic to obtain words from each specific source.
public abstract class WordManager {
    // A map that holds lists of words.
    protected final Map<Difficulty, List<String>> wordBank;

    // The constructor initialises the word bank with empty lists for each difficulty. 
    // It also has words loaded from a source (defined by the subclasses.)
    public WordManager() {
        wordBank = new HashMap<>();
        wordBank.put(Easy.INSTANCE, new ArrayList<>());
        wordBank.put(Medium.INSTANCE, new ArrayList<>());
        wordBank.put(Hard.INSTANCE, new ArrayList<>());
        loadWords();
    }

    // Concrete implementation to be provided by subclasses.
    protected abstract void loadWords();

    // Retrieves a random word from the word bank. 
    public String getRandomWord(Difficulty difficulty) {
        List < String > words = wordBank.get(difficulty);
        if (words == null || words.isEmpty()) {
            return null;
        }
        return words.get(new Random().nextInt(words.size()));
    }
}