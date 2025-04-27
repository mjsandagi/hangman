import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

// A concrete implementation of the WordManager Abstract class.
// It loads words from a file and categorises them by difficulty level.
public class FileWordManager extends WordManager {

    public FileWordManager() {
        super(); // Calls the WordManager constructor.
    }

    // Loads words from the words.txt file. 
    // Words are stored in the appropriate difficulty list in the word bank
    @Override
    protected void loadWords() {
        try (Scanner scanner = new Scanner(new File("words.txt"))) {
            while (scanner.hasNextLine()) {
                String[] parts = scanner.nextLine().split("\\s+", 2); // Splits the line into two parts - words and difficulty.

                if (parts.length < 2) {
                    continue; // Skips invalid formats
                }

                // Convert the word to uppercase and get the difficulty.
                String word = parts[0].trim().toUpperCase();
                String difficultyStr = parts[1].trim();

                Difficulty difficulty = resolveDifficulty(difficultyStr);

                // Add the word to the correct word list if the difficulty is valid.
                if (difficulty != null) {
                    wordBank.get(difficulty).add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: words.txt file not found!");
        }
    }

    // Resolves a string to its associated difficulty instance.
    private Difficulty resolveDifficulty(String difficultyStr) {
        return switch (difficultyStr) {
        case "Easy" -> Easy.INSTANCE;
        case "Medium" -> Medium.INSTANCE;
        case "Hard" -> Hard.INSTANCE;
        default -> null;
        };
    }
}